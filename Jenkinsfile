pipeline {
    agent any
    stages {
        stage('Build backend'){
            steps {
                sh 'mvn clean package -DSkipTests=true'
            }
            
        }
        stage('Unit tests'){
            steps {
                sh 'mvn test'
            }
            
        }
        stage('Sonar Analises'){
            environment {
                scannerHome = tool 'SONAR_SCANNER'
            }
            steps {
                withSonarQubeEnv('SONAR_LOCAL'){
                    sh "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=DeployBack -Dsonar.host.url=http://localhost:9000 -Dsonar.login=e6c39252b8d1984a1b79911809e7708e82bdbf3e -Dsonar.java.binaries=target -Dsonar.coverage.exclusions=**/.mvn/**,**/src/test/**,**/model/**,**Application.java"
                }
            }
            
        }
        stage('Qualite Gate'){
            steps {
                sleep(5)
                timeout(time: 1, unit: 'MINUTES')
                waitForQualiteGate abortPipeline: true
            }
            
        }
    }
}
