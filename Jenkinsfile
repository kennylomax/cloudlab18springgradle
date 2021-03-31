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

mkdir build/generated/dir1
mkdir build/generated/dir2
cd build/generated/dir1
mkdir dir3
cd dir3
touch bod.txt
cd ../../..
ls -R
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
            sh '''ls -R build/generated

#gradle test -DincludeTags=\'fast\' --fail-fast --info

'''
          }
        }

      }
    }

  }
}