# **CI/CD Documentation for Employee Overtime App**

## **1. Introduction**
This document outlines the Continuous Integration and Continuous Deployment (CI/CD) pipeline for the Employee Overtime App. The pipeline automates building, testing, containerization, and deploying the application using **GitHub, Jenkins, Docker, and SSH**.

## **2. Technologies Used**
- **Version Control**: Git & GitHub
- **CI/CD Server**: Jenkins
- **Containerization**: Docker & Docker Compose
- **Image Repository**: DockerHub
- **Deployment**: SSH to a remote server
- **Database**: MySQL

---

## **3. Pipeline Stages**

### **1️⃣ Source Code Management**
- The code is hosted in a **GitHub repository**.
- The project follows a **branching strategy**:
  - `development`: Active development
  - `test`: Pre-release testing
  - `production`: Stable release

---

### **2️⃣ Continuous Integration with Jenkins**
- **Jenkins is configured to trigger builds on GitHub commits.**
- Jenkinsfile defines the pipeline stages:

```groovy
pipeline {
    agent any
    
    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/your-repo/employee-overtime-app.git'
            }
        }
        
        stage('Build Backend') {
            steps {
                sh 'cd backend && mvn clean package'
            }
        }
        
        stage('Run Tests') {
            steps {
                sh 'cd backend && mvn test'
            }
        }
        
        stage('Build Docker Images') {
            steps {
                sh 'docker build -t your-dockerhub-username/employee-overtime-backend:latest ./backend'
                sh 'docker build -t your-dockerhub-username/employee-overtime-frontend:latest ./frontend'
            }
        }
        
        stage('Push Images to DockerHub') {
            steps {
                withDockerRegistry([credentialsId: 'docker-hub-credentials', url: '']) {
                    sh 'docker push your-dockerhub-username/employee-overtime-backend:latest'
                    sh 'docker push your-dockerhub-username/employee-overtime-frontend:latest'
                }
            }
        }
    }
}
```

---

### **3️⃣ Containerization with Docker & Docker Compose**

#### **Dockerfiles**
- **Backend Dockerfile**
```dockerfile
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/backend-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]
```

- **Frontend Dockerfile**
```dockerfile
FROM node:18
WORKDIR /app
COPY . .
RUN npm install && npm run build
CMD ["npm", "start"]
```

#### **docker-compose.yml**
```yaml
version: '3.8'
services:
  db:
    image: mysql:8
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: overtime_db
  backend:
    image: your-dockerhub-username/employee-overtime-backend:latest
    depends_on:
      - db
  frontend:
    image: your-dockerhub-username/employee-overtime-frontend:latest
    depends_on:
      - backend
```

---

### **4️⃣ Continuous Deployment via SSH**

#### **Server Preparation**
1. Install Docker and Docker Compose:
```bash
sudo apt update
sudo apt install docker.io docker-compose -y
```
2. Set up SSH access for Jenkins.

#### **Deployment Script (`deploy.sh`)**
```bash
#!/bin/bash
docker-compose down
docker pull your-dockerhub-username/employee-overtime-backend:latest
docker pull your-dockerhub-username/employee-overtime-frontend:latest
docker-compose up -d
```
- Jenkins executes this script remotely via SSH to deploy the latest version.

---

## **4. Automation & Triggering Deployments**
- **GitHub Webhook** triggers Jenkins on every push.
- Jenkins automatically builds and deploys the latest version.
- Remote server pulls the latest Docker images and restarts the app.

---

## **5. Conclusion**
This CI/CD setup ensures automated testing, secure deployment, and efficient updates. The pipeline minimizes downtime and provides a seamless DevOps workflow for the Employee Overtime App.

🚀 **Next Steps:** Monitor pipeline logs and optimize the Jenkinsfile for performance.

