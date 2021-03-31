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

ls -la build'''
        stash(name: 'assembled', includes: '**/build/**', allowEmpty: true)
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
            unstash 'assembled'
            sh '''ls -la build
ls -la build/generated
'''
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