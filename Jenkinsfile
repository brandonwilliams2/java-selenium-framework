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
                        script {
                            docker.withRegistry('https://registry.hub.docker.com', 'DockerHub') {
                                app.push("${BUILD_NUMBER}")
                                app.push("latest")
                            }
                        }
                    }
        }
    }
}