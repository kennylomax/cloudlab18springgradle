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
        sh '''gradle assemble

ls -la'''
        stash(name: 'assembled', includes: '**/build/**')
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
            sh 'ls -la build'
            unstash 'assembled'
            sh 'ls -la'
            sh 'gradle test -DincludeTags=\'slow\' --fail-fast --info'
          }
        }

        stage('fast') {
          agent {
            docker {
              image 'gradle:6.8.3-jdk11'
            }

          }
          steps {
            unstash 'assembled'
            sh '''ls -la

gradle test -DincludeTags=\'fast\' --fail-fast --info

ls -la'''
          }
        }

      }
    }

  }
}