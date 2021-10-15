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
			    withCredentials([usernamePassword(credentialsId: 'DockerHub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
			        sh '''
			            docker login --username=$USER --password=$PASS
			            docker push brandonwilliams2/selenium-docker:latest
			        '''
			    }
            }
        }
        stage('Run Tests'){
            steps{
                sh "docker-compose up"
            }
        }
        stage('Bring Grid Down'){
            steps{
                sh "docker-compose down"
            }
        }
    }
}