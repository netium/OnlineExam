pipeline {
    agent {
        docker { image 'maven:3.5.2-jdk-8-alpine' }
    }

    stages {
        stage('Test') {
            steps {
                sh 'mvn test'
            }

        }
        stage('Build') {
            steps {
                sh 'mvn install'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
