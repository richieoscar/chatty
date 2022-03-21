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

        stage("Build Jar"){
            steps {
                script{
                    gv.buildJar()
                }
            }
        }

        stage("Build Docker Image"){
            steps {
                script {
                    gv.buildDockerImage()
                    }
                }
            }
    }
}
