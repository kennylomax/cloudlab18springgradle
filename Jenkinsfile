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
        stage('slow') {
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

        stage('fast') {
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