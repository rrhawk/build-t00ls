#!/usr/bin/env groovy
def PublishArtifact(String GAVID, String GAVClass, String GAVType, String GAVGroupID, String GAVVersion, String filename) {
    step([$class: 'NexusArtifactUploader', artifacts: [[artifactId: GAVID, classifier: GAVClass, file: filename, type: GAVType]], credentialsId: '6cfb44e2-1d7d-40e5-bb13-849ae755fd2c', groupId: GAVGroupID, nexusUrl: 'nexus.skosolapov.lab.playpit.by/repository/artifact_storage', nexusVersion: 'nexus3', protocol: 'http', repository: 'artifact_storage', version:  GAVVersion])
}
def PublishImage(String ImageName) {
    docker.withServer('tcp://34.121.109.235:4243') {
     docker.withRegistry('https://docker.skosolapov.lab.playpit.by', '6cfb44e2-1d7d-40e5-bb13-849ae755fd2c') {
        def customImage = docker.build(ImageName, "./helloworld-project")
        customImage.push()
    }
  }
}
