pipeline {
    agent any
    parameters {
        text(name: 'BranchName', defaultValue: '', description: 'Branch Name')
        text(name: 'BuildID', defaultValue: '', description: 'Build ID')
    }
    stages {
    	stage('init'){
		steps{
		    script {
			logCode = load "${workspace}\vars\log.groovy"
			logCode.info('Init Release pipeline')
		    }
		}
    	}
        stage('STAGE Download artifacts from S3') {
            steps {
                echo 'Downloading Artifacts from Artifactory Server'
                sleep 10
            }
        }
	    stage('STAGE Get Env Params from aws ParamStore') {
            steps {
                echo 'Get Env Params from aws ParamStore'
                sleep 10
            }
        }
    	stage('STAGE Get Environment Details') {
            steps {
                echo 'Get Environment Details'
                //def deploymentType = //method call
	         sleep 10
            }
        }
	    stage('Deploy to STAGE') {
            steps {
                echo 'Deploy to STAGE'
                sleep 10
		script{
			if(params.DeploymentType == 'InPlace'){
			    //CALL ::: Inplace-AppDeployment.jdp
			}
			else if(params.DeploymentType == 'BlueGreen'){
			    //CALL ::: BlueGreen-AppDeployment.jdp
			}
		}
            }
        }
	    
        stage('STAGE Validate deployment') {
            input {
                message "Deployment of {Applicationname} (Build #14) to PRODUCTION environment is complete. Please validate deployment and approve to proceed with clean up of resources?"
                ok "Approve"
                submitter "DevOps Team"
                parameters {
                    string(name: 'APPROVER', defaultValue: 'Mr Sridhar', description: 'We are going to deploy build no: ?')
                }
                }
            steps {
                echo 'CI Release Environment'
              //Wait for approval response
            }
        }
		////////////////////////DEPLOY PROD ENV START////////////////////////////////////////
        stage('Download artifacts from S3') {
            steps {
                echo 'Downloading Artifacts from Artifactory Server'
                sleep 10
            }
        }
	    stage('Get Env Params from aws ParamStore') {
            steps {
                echo 'Get Env Params from aws ParamStore'
                sleep 10
            }
        }
    	stage('Get Environment Details') {
            steps {
                echo 'Get Environment Details'
                //def deploymentType = //method call
	         sleep 10
            }
        }
	    stage('Deploy to PRODUCTION') {
            steps {
                echo 'Deploy to PRODUCTION'
                sleep 10
                script{
			if(params.DeploymentType == 'InPlace'){
			    //CALL ::: Inplace-AppDeployment.jdp
			}
			else if(params.DeploymentType == 'BlueGreen'){
			    //CALL ::: BlueGreen-AppDeployment.jdp
			}
		}
            }
        }	    
        ////////////////////////////// DEPLOY PROD ENV END////////////////////////////////////////////
    }
}
