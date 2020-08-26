pipeline {
    agent any
    parameters {
        choice(name: 'ENVType', choices: ['Dev', 'QA'], description: 'Choose an Env Type')
	    text(name: 'ENVName', defaultValue: '', description: '')
        text(name: 'BranchName', defaultValue: '', description: 'Branch Name')
        text(name: 'BuildID', defaultValue: '', description: 'Build ID')
        choice(name: 'DeploymentType', choices: ['InPlace','BlueGreen'], description: 'Choose an Deployment Type')
    }
    stages {
        stage('Get Environment Details') {
            steps {
                echo 'Development Deployment'
                sleep 10
            }
        }
        stage('Download artifacts from S3') {
            steps {
                echo 'Downloading Artifacts from Artifactory Server'
                sleep 10
            }
        }
        stage('Upload artifacts to S3') {
            steps {
                echo 'Uploading to S3'
                sleep 10
            }
        }
        stage('Deploy to Dev') {
            steps {
                echo 'deploy Messaging.css.mcafee.com'
                sleep 10
		script{
			if(params.DeploymentType == 'InPlace'){
			    //CALL ::: Inplace-AppDeployment.jdp
			}
			else{
			    //CALL ::: BlueGreen-AppDeployment.jdp
			}
		}
            }
        }
        stage('Validate deployment') {
            input {
                message "Deployment of {Applicationname} (Build #14) to DEVELOPMENT environment is complete. Please validate deployment and approve to proceed with clean up of resources? ?"
                ok "Approve?"
                submitter "DevOps Team"
                parameters {
                    string(name: 'APPROVER', defaultValue: 'Mr Sridhar', description: 'We are going to deploy build no: ?')
                }
                }
            steps {
                echo 'CI Release Environment'
            }
        }
        ///////////////////////////QA DEPLOY START////////////////////////////////
        stage('Get Environment Details') {
            steps {
                echo 'Development Deployment'
                sleep 10
            }
        }
        stage('Download artifacts from S3') {
            steps {
                echo 'Downloading Artifacts from Artifactory Server'
                sleep 10
            }
        }
        stage('Upload artifacts to S3') {
            steps {
                echo 'Uploading to S3'
                sleep 10
            }
        }
        stage('Deployment to QA') {
            steps {
                echo 'CI Release Environment'
                script{
			if(params.DeploymentType == 'InPlace'){
			    //CALL ::: Inplace-AppDeployment.jdp
			}
			else{
			    //CALL ::: BlueGreen-AppDeployment.jdp
			}
		}
            }
        }
        ///////////////////////////QA DEPLOY END////////////////////////////////
    }
}
