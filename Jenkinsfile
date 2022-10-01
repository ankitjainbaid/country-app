pipeline {
    agent any
    stages{
        stage('GIT checkout') {
            steps {
                git credentialsId: 'ankitjainbaid_github', url: 'https://github.com/ankitjainbaid/country-app.git'
           }
       }
       stage('Build Package') {
            steps {
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
