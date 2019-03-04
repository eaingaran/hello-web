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
    sh 'echo "Hi"'
    sh 'curl -u admin:password -X PUT "http://54.212.214.245:8081/artifactory/libs-snapshot-local/hello-web/hello-web-0.0.1.${BUILD_ID}.jar" -T build/libs/hello-web-0.0.1-SNAPSHOT.jar'
   }
  }
  stage('cleanup') {
   steps {
    sh 'echo "Hi"'
    //sh "kill \$(lsof -t -i:9001)"
    sh 'sudo fuser -n tcp -k 9001 | echo "hello"'
   }
  }
  stage('deploy') {
   steps {
    sh 'echo "Hi"'
    sh 'nohup java -jar build/libs/hello-web-0.0.1-SNAPSHOT.jar & echo "Done"'
   }
  }
 }
}
