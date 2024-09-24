pipeline {
    agent any

    parameters {
        string(name:'Your name',
                defaultValue: 'Arja', 
                description: 'Enter your name')
        choice(name: 'Choose your gender',
                choices: ['Male', 'Female', 'Non-Binary'])
        password(name: 'Choose your password',
                description: 'Password should be atleast 8 letters')
                
        booleanParam(name: 'Agree to get email notification', 
                defaultValue: false,
                description: 'check this to get emails about the build result ')
    }    

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
        stage('Git checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/fullstackjava082023/Jenkins1HW.git'
            }
        }
        stage('Run Python Program') {
            steps {
               sh 'python3 main.py'
            }
        }
        
    }
}
