pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                bat "mvn -D clean test"
            }

            post {
                success {
                   publishHTML([
                       allowMissing: false,
                       alwaysLinkToLastBuild: false,
                       keepAll: false,
                       reportDir: 'target/surefire-reports/',
                       reportFiles: 'AutomationReport.html',
                       reportName: 'HTML Report',
                       reportTitles: '',
                       useWrapperFileDirectly: true])
                }
            }
        }
    }
}