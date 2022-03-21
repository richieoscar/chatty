pipeline{
    agent any
    tools{
        maven 'maven-3.8.5'
    }
    parameters{
        choice(name:'VERSION', choices:['1.2', '1.3', '1.4','1.5'], description:"")
        booleanParam(name:'executeTests', defaultValue:'true', description:"" )
    }
    stages{
        stage("Cleaning Code"){
            steps{
                echo 'Cleaning code...'
                sh 'mvn clean'
            }
        }

        
        stage("Testing Application"){
            
            when{
                    expression{
                        params.executeTests
                        echo 'executing Tests'
                        sh 'mvn test'
                    }
                }  
           
            steps{
                echo 'executing Tests'
            }   
            
        }

        stage("Packaging Application") {
            steps{

                echo 'Packagin application......'
                sh 'mvn package'

            }
        }
        
         stage("Deploying Application") {
            steps{

                echo 'Deploying application......'
                echo "${params.VERSION}"

            }
        }
    }
    
    
}
