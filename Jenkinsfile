pipeline {
  agent any
  stages {
    stage('assemble') {
      agent {
        docker {
          image 'gradle:6.8.3-jdk11'
        }

      }
      steps {
        sh 'gradle assemble'
      }
    }

    stage('test') {
      parallel {
        stage('test') {
          agent {
            docker {
              image 'gradle:6.8.3-jdk11'
            }

          }
          steps {
            sh 'gradle test -DincludeTags=\'slow\' --fail-fast --info'
          }
        }

        stage('error') {
          steps {
            sh 'gradle test -DincludeTags=\'fast\' --fail-fast --info'
          }
        }

      }
    }

  }
}