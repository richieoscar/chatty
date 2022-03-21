pipeline {
    agent any
    tools {
        maven 'maven-3.8.5'
    }

    stages{

        stage("Build Jar"){

            steps {

                script{
                    echo "====++++Building Jar++++===="
                    sh 'mvn package'
                }
            }
        }

        stage("Build Docker Image"){
            steps {
                script {
                    withCredentials([
                        usernamePassword(credentialsId:'dockerhub', usernameVariable: 'USER', passwordVariable: 'PASSWORD')]){
                            echo "====++++Building Docker Image++++===="
                            sh 'docker build -t richieoscar/chatty-app:1.0 .'
                            sh  "echo $PASSWORD | docker login - u $USER --password-stdin"
                            sh 'docker push richieoscar/chatty-app:1.0 '

                    }
                }
            }
        }
    }
}
