#!/usr/bin/env groovy
def PublishImage(ImageName) {
    docker.withServer('tcp://34.121.109.235:4243') {
     docker.withRegistry('https://docker.skosolapov.lab.playpit.by', '6cfb44e2-1d7d-40e5-bb13-849ae755fd2c') {
        def customImage = docker.build(ImageName, "./helloworld-project")
        customImage.push()
    }
  }
}
