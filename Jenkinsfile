pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "your_dockerhub_username/your_app_name"
    }

    stages {
        stage('Checkout') {
            steps {
                // Pull the code from GitHub
                checkout scm
            }
        }

        stage('Build Backend') {
            steps {
                script {
                    // Build the Spring Boot app using Maven
                    sh './mvnw clean install'
                }
            }
        }

        stage('Run Unit Tests') {
            steps {
                script {
                    // Run unit tests using Maven
                    sh './mvnw test'
                }
            }
        }

        stage('Build Frontend') {
            steps {
                script {
                    // Build React app using npm
                    sh 'npm install'
                    sh 'npm run build'
                }
            }
        }

        stage('Docker Build & Push') {
            steps {
                script {
                    // Build Docker image for backend and frontend
                    sh 'docker build -t ${DOCKER_IMAGE}:latest .'

                    // Log in to DockerHub (optional)
                    sh 'docker login -u your_username -p your_password'

                    // Push Docker image to DockerHub
                    sh 'docker push ${DOCKER_IMAGE}:latest'
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Deploy Docker containers on the remote server
                    sh 'ssh user@your_server_ip "docker pull ${DOCKER_IMAGE}:latest && docker-compose -f /path/to/docker-compose.yml up -d"'
                }
            }
        }
    }

    post {
        success {
            echo 'Build and deployment succeeded!'
        }
        failure {
            echo 'Build or deployment failed!'
        }
    }
}
