pipeline {
    agent any
    tools{
       jdk 'java' 
       gradle 'gradle'
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
       stage ('Deploy') {
            steps {
                sh 'docker run -d -p 8081:8081 ankitjainbaid/country-app'
            }
        } 
    }
}
