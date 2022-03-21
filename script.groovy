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
    sh 'mvn package'
}
def deployApp(){
    echo 'Deploying Application....'
    echo "Deploying version ${params.VERSION}"
}

return this
