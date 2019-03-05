pipeline {
 agent any
 tools {
  gradle 'gradle'
  jdk 'jdk1.8.0'
 }
 stages {
  stage('clean') {
   steps {
    sh "gradle -Dorg.gradle.daemon=false clean"
   }
  }
  stage('test') {
   steps {
    sh "gradle -Dorg.gradle.daemon=false test"
   }
  }
  stage('build') {
   steps {
    sh "gradle -Dorg.gradle.daemon=false build"
   }
  }
  stage("Running SONAR") {
   steps {
       sh 'echo "Skipping upload due to low memory"'
       //sh 'gradle sonarqube -Dorg.gradle.daemon=false -Dsonar.projectKey=helo-web -Dsonar.host.url=http://54.184.11.135:9000 -Dsonar.login=e6ead4be8327d4410cb4ba94d7d798cc55c810d0'
   }
  }
  stage('publish') {
   steps {
    sh 'echo "Skipping upload due to low memory"'
    //sh 'curl -u admin:password -X PUT "http://54.184.11.135:8081/artifactory/libs-snapshot-local/hello-web/hello-web-0.0.1.${BUILD_ID}.jar" -T build/libs/hello-web-0.0.1-SNAPSHOT.jar'
   }
  }
  stage('cleanup') {
   steps {
    catchError {
            //sh 'fuser -n tcp -k 9001 | echo "killed"'
            sh "docker stop helloweb"
    }
   }
  }
  stage('create Docker image') {
   steps {
     //sh 'JENKINS_NODE_COOKIE=dontKillMe nohup java -jar build/libs/hello-web-0.0.1-SNAPSHOT.jar &'
    sh "docker build --tag=helloweb:0.0.1.${BUILD_ID} ."
   }
  }
  stage('run Docker image') {
   steps {
     //sh 'JENKINS_NODE_COOKIE=dontKillMe nohup java -jar build/libs/hello-web-0.0.1-SNAPSHOT.jar &'
    sh "docker run --name=helloweb -d -p 9001:9001  helloweb:0.0.1.${BUILD_ID}"
   }
  }
 }
}
