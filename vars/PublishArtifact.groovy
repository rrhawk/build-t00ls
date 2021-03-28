#!/usr/bin/env groovy
def PublishArtifact(GAVID, GAVClass, GAVType, GAVGroupID, GAVVersion, filename) {
    step([$class: 'NexusArtifactUploader', artifacts: [[artifactId: GAVID, classifier: GAVClass, file: filename, type: GAVType]], credentialsId: '6cfb44e2-1d7d-40e5-bb13-849ae755fd2c', groupId: GAVGroupID, nexusUrl: 'nexus.skosolapov.lab.playpit.by/repository/artifact_storage', nexusVersion: 'nexus3', protocol: 'http', repository: 'artifact_storage', version:  GAVVersion])
}
