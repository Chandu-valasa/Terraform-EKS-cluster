pipeline {
  agent any

  stages {

    stage('git checkout') {
      steps {
        git url: 'https://github.com/Chandu-valasa/Terraform-EKS-cluster.git', branch: 'main'
      }
    }
    stage('EKS CLUSTER') {
      steps {
        withCredentials([
          [$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'AWS']
        ]) {
          sh "terraform init"
        }
      }
    }
    stage('tp') {
      steps {
         withCredentials([
          [$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'AWS']
        ]) {
        sh 'terraform plan'
        }
      }
    }
    stage('ta') {
      steps {
         withCredentials([
          [$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'AWS']
        ]) {
        sh 'terraform apply --auto-approve'
        }
      }
    }
  }
}