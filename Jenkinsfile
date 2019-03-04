pipeline  {
  agent any
  tools {
    maven 'maven'
    jdk 'jdk1.8.0'
  }
  stages  {
    stage('clean')  {
      steps {
        sh "mvn clean" 
      }
    }
    stage('compile')  {
      steps {
        sh "mvn compile"
      }
    }
    stage('test')  {
      steps {
        sh "mvn test"
      }
    }
    stage('package')  {
      steps {
        sh "mvn -DskipTests package"
      }
    }
    stage('publish')  {
      steps {
        sh 'mvn deploy'
      }
    }
    stage('deploy') {
      steps {
        sh "java -jar target/hello-web-0.0.1-SNAPSHOT.jar"
      }
    }
  }
}
