def CodeDeployement(String applicationName, String deploymentConfig, String deploymentGroupName, String s3bucket, String versionFileName){
	step([
		$class: 'AWSCodeDeployPublisher', 
		applicationName: '{$applicationName}', 
		awsAccessKey: 'AKIA2O67XNNTQOYA3EEH', 
		awsSecretKey: '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', 
		credentials: 'awsAccessKey', 
		deploymentConfig: '{$deploymentConfig}', 
		deploymentGroupAppspec: false, 
		deploymentGroupName: '{$deploymentGroupName}', 
		deploymentMethod: 'deploy', 
		excludes: '', iamRoleArn: '', includes: '**', pollingFreqSec: 15, pollingTimeoutSec: 3000, proxyHost: '', proxyPort: 0, 
		region: 'us-east-1', 
		s3bucket: '{$s3bucket}', 
		s3prefix: '', 
		subdirectory: '', 
		versionFileName: '{$versionFileName}', 
		waitForCompletion: true
	])
}

def getCodedeployApplicationName(env, type, jsonFile){

        def fileContent = readJSON file: "${jsonFile}"
        Map jsonContent = (Map) new JsonSlurper().parseText(fileContent)
        def envobj = jsonContent.get("${env}")
        def deployType = jsonContent.get("${type}")
        def appName = jsonContent.get("ApplicationName")
		def groupName = jsonContent.get("DeploymentGroupName")

        return appName
}

def getCodedeployGroupName(env, type, jsonFile){

	def fileContent = readJSON file: "${jsonFile}"
	Map jsonContent = (Map) new JsonSlurper().parseText(fileContent)
	def envobj = jsonContent.get("${env}")
	def deployType = jsonContent.get("${type}")
	def groupName = jsonContent.get("DeploymentGroupName")

	return groupName
}

def GetParamSecretsByEnvironment(String credentialsId){
	// AWS credentialid will be different according to the env and aws accounts
		withAWSParameterStore(credentialsId: '${credentialsId}', naming: 'relative', path: '/service', recursive: true, regionName: '{$awsRegion}') {
	// some block
	}
}