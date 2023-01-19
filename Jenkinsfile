pipeline {
    agent any
    tools {
        maven 'Local_Maven'
    }
    stages{
        stage("GIT checkout"){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/girish-thetechieguy/address-service']]])
            }
        }
        stage("Run Unit testing"){
            steps{
                sh 'mvn test'
            }
        }
        stage("Run Integration Test"){
            steps{
                sh 'mvn verify -DskipUnitTests'
            }
        }
        stage('Build maven'){
            steps{
                sh 'mvn clean install'
            }
        }
        stage('SonarQube Analysis'){
            steps{
                script{
                    withSonarQubeEnv(credentialsId: 'local_sonar_api_key') {
                     sh 'mvn clean package sonar:sonar'
                    } 
                }
            }
        }
        stage('Quality Gate status'){
            steps{
                script{
                    waitForQualityGate abortPipeline: false, credentialsId: 'local_sonar_api_key'
                }
            }
        }
        stage('Build Docker Image'){
            steps{
                script{
                    sh 'docker build -t girishtechieguy/address-service .'
                }
            }
        }
    }
}
