pipeline {
   agent any

 
   stages 
   {
      stage('Build') 
      {
         steps {
            // Get some code from a GitHub repository
            git 'https://github.com/simul91/fleetman-position-tracker'
            sh "mvn package" 
           
              }

         
         post {
            // If Maven was able to run the tests, even if some of the test
            // failed, record the test results and archive the jar file.
            success 
                {
               junit '**/target/surefire-reports/TEST-*.xml'
               archiveArtifacts 'target/*.jar'
               
                   withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: '', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']])
                   {
                  // some block
                      ansiblePlaybook credentialsId: 'ssh-credentials', installation: 'ansible-installation', playbook: 'deploy.yaml'
}
                }
             }
        }
   }
}
