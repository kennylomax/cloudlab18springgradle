pipeline {
  agent any
  stages {
    stage('') {
      agent {
        docker {
          image 'gradle:latest'
        }

      }
      steps {
        sh 'gradle build'
      }
    }

  }
}