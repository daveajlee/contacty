node {
   def mvnHome = tool 'Maven 3.3.9'
   stage('Git Checkout') {
      // Get code from contact-microservice GitHub repository
      git 'https://github.com/daveajlee/contact-microservice.git'
   }
   stage('Build') {
      // Run the maven build
      sh "'${mvnHome}/bin/mvn' clean install -Panalysis"
   }
   stage('Results') {
      junit '**/target/surefire-reports/TEST-*.xml'
      step([$class: 'CoberturaPublisher', autoUpdateHealth: false, autoUpdateStability: false, coberturaReportFile: '**/coverage.xml', failUnhealthy: false, failUnstable: false, maxNumberOfBuilds: 0, onlyStable: false, sourceEncoding: 'ASCII', zoomCoverageChart: false])
      archive 'target/*.jar'
      checkstyle canComputeNew: false, defaultEncoding: '', healthy: '', pattern: 'target/checkstyle-result.xml', unHealthy: ''
      findbugs canComputeNew: false, defaultEncoding: '', excludePattern: '', healthy: '', includePattern: '', pattern: 'target/findbugs.xml', unHealthy: ''
      publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false, reportDir: 'target/site/apidocs', reportFiles: 'index.html', reportName: 'Javadoc', reportTitles: ''])
   }
}
