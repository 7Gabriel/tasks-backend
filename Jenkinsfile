pipeline {
    agent any
    stages {
        stage('Build backend'){
            steps {
                sh 'mvn clean package -DSkipTests=true'
            }
            
        }
    }
}