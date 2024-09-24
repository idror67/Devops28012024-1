pipeline {
    agent any
    parameters {
        choice(name:'ENVIRONMENT',
                choices: ['DEVELOPMENT', 'STAGING', 'PRODUCTION'] )
        password(name: 'APIKEY',
                defaultValue: '123ABC',
                description: 'Password should be atleast 8 letters')
                
        text(name: 'CHANGELOG', 
                defaultValue: 'This is the change log.',
                description: 'This is the change log')
    }     
    stages {
        stage('Test') {
            steps {
                echo "This step tests the project"
            }
        }
        stage('Deploy') {
            when {
                expression {
                   // environment is production
                   return params.ENVIRONMENT == 'PRODUCTION'
                }
            }
            steps {
                echo "This stage deploys the project"
            }
        }
        stage('Report') {
            steps {
                echo "This stage generates a report"
                sh "printf \"${params.CHANGELOG}\" > report.txt"
                archiveArtifacts allowEmptyArchive: true,
                    artifacts: '*.txt',
                    fingerprint: true,
                    followSymlinks: false,
                    onlyIfSuccessful: true
            }
        }
    }
}
