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

         stage("Deploy to AWS EC2 Server"){
                            steps {
                                script {
                                    gv.deployToAWSEc2()

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
