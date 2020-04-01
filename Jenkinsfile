pipeline {
    agent { label 'app-server' }
    environment {
        JBOSS_HOME = '/opt/jboss-eap' 
    }
    stages {
        stage('Git Pull') {
            steps{
                sh 'printenv'
                git branch: "${BRANCH_NAME}",
                    url: "${GIT_URL}"
            }
        }
        stage('Testing') {
            steps {
                sh 'gradle test'
            }
         }
        stage('Build') {
            steps {
                sh 'gradle build'
            }
         }
        stage('Deploy to JBOSS') {
            steps {
                echo 'Deploying to JBOSS'
                sh 'gradle deploy'
            }
        }
    }
}
