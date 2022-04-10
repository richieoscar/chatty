def gv

pipeline {
    agent any
    tools {
        maven 'maven'
    }

    stages{

        stage("init"){
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("Increment Version"){
            steps {
                script {
                    gv.incrementVersion()
                }
            }
        }



        stage("Test"){
            steps {
                script {
                    gv.testApp()
                     echo "Executing Pipeline on branch $BRANCH_NAME"
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

         stage("Commit & Push to Remote Git"){
                    steps {
                        script {
                            gv.commitVersionIncrementToGit()

                        }
                    }
          }
    } 
}
