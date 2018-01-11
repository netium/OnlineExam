pipeline {
    agent {
        docker { image 'maven:3.5.2-jdk-8-alpine' }
    }

    stages {
        stage('Build') {
            steps {
                sh 'ls && mvn install'
            }

        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
