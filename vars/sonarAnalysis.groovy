def call(boolean abortOnFailure, boolean abortPipeline, String branchName = env.BRANCH_NAME) {
        //sleep time: 3, unit: 'MINUTES'
        
        echo '#### branch name: ' + branchName
        def result = executeSonar()

        def passed = qualityGate(result)

        if(abortPipeline){
            error 'pipeline aborted proccess...'
        }else{
            if(branchName === 'master'){
                error 'pipeline aborted proccess... branch master'
            }else{
                if(branchName.startWith('hotfix')){
                    echo 'start with hotfix'
                }
            }
        }

        return passed
}

def executeSonar(){
    echo "Ejecucion de las pruebas de calidad de codigo."
    return 'SUCCESS'
}

def qualityGate(result){
    echo 'quality gate, waiting for results'
    sleep time: 2, unit: 'MINUTES'
    return result == 'SUCCESS'
}<