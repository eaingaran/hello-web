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
       try { 
         sh 'echo "Hi"'
         //sh './gradlew clean sonarqube'
       }
       catch (e) {
         emailext attachLog: true, body: 'See attached log', subject: 'BUSINESS Build Failure', to: 'aingaran.elango@tcs.com'
         step([$class: 'WsCleanup'])
         return
       }
     }
  }
  stage('publish') {
   steps {
    sh 'echo "Hi"'
    //sh 'curl -u admin:password -X PUT "http://54.212.214.245:8081/artifactory/libs-snapshot-local/hello-web/hello-web-0.0.1.${BUILD_ID}.jar" -T build/libs/hello-web-0.0.1-SNAPSHOT.jar'
   }
  }
  stage('cleanup') {
   steps {
    sh 'echo "Hi"'
    //sh "kill $(lsof -t -i:9001)"
   }
  }
  stage('deploy') {
   steps {
    sh 'echo "Hi"'
    //sh "nohup java -jar build/libs/hello-web-0.0.1-SNAPSHOT.jar"
   }
  }
 }
}
