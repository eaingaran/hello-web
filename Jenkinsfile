pipeline {
 agent any
 environment {
  registry = "eaingaran/hello-web"
  registryCredential = 'credentials'
  artifactoryCredential = 'artifactoryCredentials'
  dockerImage = ''
  containerId = sh(script: 'docker ps -aqf "name=helloweb"', returnStdout: true)
 }
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
    //sh 'echo "Skipping upload due to low memory"'
    sh 'gradle sonarqube -Dorg.gradle.daemon=false -Dsonar.projectKey=helo-web -Dsonar.host.url=http://34.221.104.185:9000 -Dsonar.login=664c5e9d4bce819bbb355cfd9a782b2b5a8680af'
   }
  }
  stage('publish') {
   steps {
    //sh 'echo "Skipping upload due to low memory"'
    sh 'curl -u admin:password -X PUT "http://34.221.104.185:8081/artifactory/libs-snapshot-local/hello-web/hello-web-0.0.2.${BUILD_ID}.jar" -T build/libs/hello-web-0.0.1-SNAPSHOT.jar'
   }
  }
  stage('Building image') {
   steps {
    script {
     dockerImage = docker.build registry + ":$BUILD_NUMBER"
    }
   }
  }
  stage('Push Image') {
   steps {
    script {
     docker.withRegistry('', registryCredential) {
      dockerImage.push()
     }
     docker.withRegistry('http//34.221.104.185:8081/artifactory/docker/', artifactoryCredential) {
      dockerImage.push()
     }
    }
   }
  }
  stage('Cleanup') {
   when {
    not {
     environment ignoreCase: true, name: 'containerId', value: ''
    }
   }
   steps {
    sh 'docker stop ${containerId}'
    sh 'docker rm ${containerId}'
   }
  }
  stage('run Docker image') {
   steps {
    //sh 'JENKINS_NODE_COOKIE=dontKillMe nohup java -jar build/libs/hello-web-0.0.1-SNAPSHOT.jar &'
    //sh "docker run --name=helloweb -d -p 9001:9001  helloweb:0.0.1.${BUILD_ID}"
    sh 'docker run --name=helloweb -d -p 3000:9001 $registry:$BUILD_NUMBER'
   }
  }
  stage('Remove Unused docker image') {
   steps {
    //sh "docker rmi $registry:$BUILD_NUMBER"
    echo 'not implemented currently'
   }
  }
 }
}
