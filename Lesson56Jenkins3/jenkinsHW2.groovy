pipeline {
    agent any
    
    parameters {
        booleanParam(name: "DRY_RUN", defaultValue: false, description: "Set to true to skip the run stage")
    }

    stages {
        stage('Git checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/fullstackjava082023/Jenkins1HW.git'   
            }
        }
         stage('Run Python Code') {
            when {
                expression { return params.DRY_RUN == false } 
            } 
            steps {
                sh 'python3 main.py > output.txt'  
            }
        }
      
        
    }
}
