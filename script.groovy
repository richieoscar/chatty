def buildApp(){
    echo 'building application....'
}

def cleanApp(){
    echo 'Cleaning code'
    sh 'mvn clean'
}

def testApp(){
     echo 'executing Tests'
    sh 'mvn test'
}

def packageApp(){
    echo 'Packaging Application....'
    sh 'mvn pacakage'
}
def deployApp(){
    echo 'Deploying Application....'
    echo "Deploying version ${params.VERSION}"
}

def buildJar(){
      echo "====++++Building Jar++++===="
      sh 'mvn package'
}

def buildDockerImage(){
    withCredentials([
         usernamePassword(credentialsId:'dockerhub', usernameVariable: USER, passwordVariable: PASSWORD)])
         {
         echo "====++++Building Docker Image++++===="
         sh 'docker build -t richieoscar/chatty-app:1.0 .'
         sh  "echo $PASSWORD | docker login -u $USER --password-stdin"
         sh 'docker push richieoscar/chatty-app:1.0'
         }
}

return this
