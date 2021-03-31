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
mkdir dir1
mkdir dir2
cd dir1
mkdir dir3
cd dir3
touch bod.txt
cd ../..
ls -R
'''
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
            unstash 'assembled'
            sh '''ls -R
gradle test -DincludeTags=\'slow\' --fail-fast --info

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
            sh '''ls -R

gradle test -DincludeTags=\'fast\' --fail-fast --info

'''
          }
        }

      }
    }

  }
}