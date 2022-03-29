def gv

pipeline {
    agent any
    tools {
        maven 'maven-3.8.5'
    }

    stages{

        stage("init"){
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }

        stage("Test"){
            steps {
                echo "Executing Pipeline on branch $BRANCH_NAME"
                script {
                    gv.testApp()
                     
                }
            }
        }

        stage("Build Jar"){
            when{
                expression {
                    BRANCH_NAME == 'main'
                }
            }
            steps {
                script {
                    gv.buildJar()
                }
            }
        }

        stage("Build Docker Image"){
             when{
                expression{
                    BRANCH_NAME == 'main'
                }
            }
            steps {
                script {
                    gv.buildDockerImage()   
                }
            }
        
        }
    } 
}
