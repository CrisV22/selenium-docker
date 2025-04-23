pipeline {
    agent any

    stages {
        stage('Build Jar') {
            steps {
                bat "mvn clean package -DskipTests"
            }
        }

        stage('Build Image') {
            steps {
                bat "docker build -t=cristianvso/selenium ."
            }
        }

        stage('Push image') {
            steps {
                sh "docker push cristianvso/selenium"
            }
        }
    }
}