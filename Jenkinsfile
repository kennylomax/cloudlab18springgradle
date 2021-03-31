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

ls -R build/generated

cp -R build/generated/ build/bod

ls -R build/bod
'''
        stash(name: 'assembled', includes: '**/build/**', excludes: 'bod')
        sh 'ls -R build/generated'
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
            sh '''ls -R build/generated

#gradle test -DincludeTags=\'slow\' --fail-fast --info

'''
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
            sh '''ls -R build/bod

#cp -R build/generated/ build/bod

#ls -R build/bod


#gradle test -DincludeTags=\'fast\' --fail-fast --info

'''
          }
        }

      }
    }

  }
}