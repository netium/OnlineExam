pipeline {
    agent {
        docker { image '3.5.2-jdk-8-alpine' }
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn --version'
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
