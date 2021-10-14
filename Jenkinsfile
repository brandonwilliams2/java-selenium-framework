pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jars') {
            steps {
                sh "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                sh "docker build -t='brandonwilliams2/selenium-docker' ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'DockerHub', passwordVariable: 'pass', usernameVariable: 'user')]) {
			        sh 'docker login --username=${user} --password-stdin=${pass}'
			        sh 'docker push brandonwilliams2/selenium-docker:latest'
			    }
            }
        }
    }
}