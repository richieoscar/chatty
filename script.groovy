
def incrementVersion(){
    echo 'incrementing Version'
    sh 'mvn build-helper:parse-version versions:set -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.incrementalVersion} versions:commit'
    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
    def version = matcher[0][1]
    env.IMAGE_NAME = "$version-$BUILD_NUMBER"
}

def testApp(){
     echo 'executing Tests'
    sh 'mvn test'
}

def deployApp(){
    echo 'Deploying Application....'
    echo "Deploying version ${params.VERSION}"
}

def buildJar(){
      echo "====++++Building Jar++++===="
      sh 'mvn clean package'
}

def buildDockerImage(){
    withCredentials([
         usernamePassword(credentialsId:'dockerhub', usernameVariable: 'USER', passwordVariable: 'PASSWORD')])
         {
         echo "====++++Building Docker Image++++===="
         sh "docker build -t richieoscar/chatty-app:${IMAGE_NAME} ."
         sh  "echo $PASSWORD | docker login -u $USER --password-stdin"
         sh "docker push richieoscar/chatty-app:${IMAGE_NAME}"
         }
}

def commitVersionIncrementToGit(){
    withCredentials([
            usernamePassword(credentialsId:'jenkins-id', usernameVariable: 'USER', passwordVariable: 'PASSWORD')])
            {
                echo "====++++Commiting To Remote Repository++++===="
                sh 'git status'
                sh 'git branch'
                sh 'git config --list'
                sh "git remote set-url origin https://${USER}:${PASSWORD}@github.com/richieoscar/chatty.git"
                sh  "git add ."
                sh 'git commit -m "ci: version change"'
                sh 'git push origin main'
            }
}

return this
