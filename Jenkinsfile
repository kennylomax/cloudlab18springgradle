pipeline {
  agent any
  stages {
    stage('error') {
      agent {
        docker {
          image 'gradle:6.8.3-jdk11'
        }

      }
      steps {
        sh 'gradle build'
      }
    }

  }
}