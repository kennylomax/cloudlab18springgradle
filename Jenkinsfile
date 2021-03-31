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
        stash(name: 'assembled', includes: '**/*')
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
            unstash 'assembled'
          }
        }

        stage('error') {
          agent {
            docker {
              image 'gradle:6.8.3-jdk11'
            }

          }
          steps {
            sh 'gradle test -DincludeTags=\'fast\' --fail-fast --info'
            unstash 'assembled'
          }
        }

      }
    }

  }
}