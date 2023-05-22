pipeline {
    agent any
    stages {
        stage('Build backend'){
            steps {
                sh 'mvn clean pacakge -DSkipTests=true'
            }
            
        }
    }
}