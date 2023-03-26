#!/usr/bin/env groovy

pipeline {
    agent any
    tools {
        maven 'maven-3.6'
    }
    stages {
        stage('build jar') {
            steps {
                script {
                    echo "Building the application..."
                    sh 'mvn package'
                }
            }
        }
        stage('build image') {
            steps {
                script {
                    echo "Building the docker image..."
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]){
                        sh 'docker build -t beckett1015/dev-ops:java-maven-2.0'
                        sh "echo $PASS | docker login -u $user --password-stdin"
                        sh 'docker push beckett1015/dev-ops:java-maven-2.0'
                    }
                    
                }
            }
        }
        stage('deploy') {
            steps {
                script {
                    echo "Deploying the application..."
                }
            }
        }
    }
}
