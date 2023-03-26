#!/usr/bin/env groovy
def gv
pipeline {
    agent any
    tools {
        maven 'maven-3.6'
    }
    stages {
        stage("init")  {
            steps{
                script{
                    gv = load "script.groovy"
                }
            }
        }
        stage('build jar') {
            steps {
                script {
                    gv.buildJar()
                }
            }
        }
        stage('build image') {
            steps {
                script {
                    buildDockerImage()
                    }
                    
                }
            }
        stage('deploy') {
            steps {
                script {
                    deployApp()
                }
            }
        }
    }
}

