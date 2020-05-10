pipeline {
  agent {
    docker {
      image 'androidsdk/android-26'
    }

  }
  stages {
    stage('clean') {
      steps {
        withGradle() {
          sh './clean'
          sh './build'
          sh './assembleDebug'
        }

      }
    }

  }
}