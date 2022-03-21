def gv


pipeline {
    agent any
    tools{
        maven 'maven-3.8.5'
    }
    parameters{
        choice(name:"", choices:['1.2', '1.3', '1.4','1.5'], description:"")
        booleanParam(name:'executeTests', defaultValue:'true', description:"" )
    }
    stages{

        stage("init"){
            steps{

                script {
                    gv = load "script.groovy"
                }
            }
        }

        stage("Cleaning Code"){
            steps{
                script{
                    gv.cleanApp()
                }
            }
        }

        
        stage("Testing Application"){
             when{
                    expression{
                        params.executeTests
                    }
                } 
           
            steps{
                    script {
                        gv.testApp()
                    }
                }      
            
        }

        stage("Packaging Application") {
            steps{
                     script {
                        gv.packageApp()
                    }

            }
        }

        stage("Deploying  Application") {
            steps{
                     script {
                        gv.deployApp()
                    }

            }
        }
    }

    
}
