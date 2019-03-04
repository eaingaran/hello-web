pipeline {
 agent any
 tools {
  gradle 'gradle'
  jdk 'jdk1.8.0'
 }
 stages {
  stage('clean') {
   steps {
    sh "gradle clean"
   }
  }
  stage('test') {
   steps {
    sh "gradle test"
   }
  }
  stage('build') {
   steps {
    sh "gradle build"
   }
  }
  stage("Running SONAR") {
   steps {
       sh 'echo "Hi"'
       //sh './gradlew clean sonarqube'
   }
  }
  stage('publish') {
   steps {
    sh 'curl -u admin:password -X PUT "http://54.212.214.245:8081/artifactory/libs-snapshot-local/hello-web/hello-web-0.0.1.${BUILD_ID}.jar" -T build/libs/hello-web-0.0.1-SNAPSHOT.jar'
   }
  }
  stage('cleanup') {
   steps {
    //sh "sudo kill \$(lsof -t -i:9001)"
    //sh 'fuser -n tcp -k 9001 | echo "killed"'
    catchError {
            sh "curl -X POST 54.212.214.245:9001/actuator/shutdown"
    }
    //sh "curl -X POST 54.212.214.245:9001/actuator/shutdown"
   }
  }
  stage('deploy') {
   steps {
    sh "nohup java -jar build/libs/hello-web-0.0.1-SNAPSHOT.jar > /dev/null 2>&1 &"
   }
  }
 }
}
