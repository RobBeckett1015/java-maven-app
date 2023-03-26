def buildJar() {
    echo 'building the application'
    sh 'mvn package'
}

def testApp() {
    echo 'Testing the application'
}

def deployApp() {
    echo "Deploying the application..."
    echo "Deploying version ${params.VERSION}"
}

def buildDockerImage(){
    echo "Building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]){
        sh 'docker build -t beckett1015/dev-ops:java-maven-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push beckett1015/dev-ops:java-maven-2.0'
}

return this