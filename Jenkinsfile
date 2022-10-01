pipeline {
    agent any
    tools{
      gradle '7.5.1'
    }
    stages{
        stage('GIT checkout') {
            steps {               
                git([url: 'https://github.com/ankitjainbaid/country-app', branch: 'main', credentialsId: 'ankitjainbaid_github'])
           }
       }
       stage('Build Package') {
            steps {
                sh 'gradle --version'
                sh 'chmod +x ./gradlew'
                sh './gradlew clean build'
            }
        }
       stage ('Build & Push docker image') {
            steps {
                withDockerRegistry(credentialsId: dockerhub, url: 'https://index.docker.io/v1/') {
                    sh 'docker push ankitjainbaid/country-app'
                }
            }
       } 
    }
}
