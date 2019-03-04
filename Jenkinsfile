pipeline  {
  agent any
  tools {
    gradle 'gradle'
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
        sh 'curl -u admin:password -X PUT "http://54.212.214.245:8081/artifactory/libs-snapshot-local/hello-web/hello-web-0.0.1.${BUILD_ID}.jar" -T build/libs/hello-web-0.0.1-SNAPSHOT.jar'
        //sh 'curl -X PUT -U admin:AP3FBGSctQB7PMkRdHSypbQjuVB -T build/libs/hello-web-0.0.1-SNAPSHOT.jar "http://54.212.214.245:8081/artifactory/libs-snapshot-local/hello-web-0.0.1.${BUILD_ID}.jar"'
      }
    }
    stage('deploy') {
      steps {
        sh "kill $(lsof -t -i:9001)"
        sh "nohup java -jar build/libs/hello-web-0.0.1-SNAPSHOT.jar"
        //sh "nohup java -jar ./build/libs/hello-web-0.0.1-SNAPSHOT.jar &"
        //sh "ps | grep java-fullstack | awk '{print $1}' | xargs kill -9 || true env SERVER.PORT=8081 nohup java -jar ./build/libs/hello-web-0.0.1.jar &"
      }
    }
  }
}
