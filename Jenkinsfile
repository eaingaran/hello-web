pipeline  {
  agent any
  tools {
    maven 'gradle'
    jdk 'jdk1.8.0'
  }
  stages  {
    stage('clean')  {
      steps {
        sh "gradle clean" 
      }
    }
    stage('build')  {
      steps {
        sh "gradle build"
      }
    }
    stage('publish')  {
      steps {
        sh 'curl -X PUT -U admin:AP3FBGSctQB7PMkRdHSypbQjuVB -T build/libs/hello-web-0.0.1.jar "http://54.218.12.85:8081/artifactory/libs-release-local/hello-web/hello-web-0.0.1.jar"'
      }
    }
    stage('deploy') {
      steps {
        sh "ps | grep java-fullstack | awk '{print $1}' | xargs kill -9 || true env SERVER.PORT=8081 nohup java -jar ./build/libs/hello-web-0.0.1.jar &"
      }
    }
  }
}
