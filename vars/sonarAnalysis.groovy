def call(boolean abortOnFailure = false, boolean abortPipeline) {
        //sleep time: 3, unit: 'MINUTES'
        
        def result = executeSonar()

        def passed = qualityGate(result)

        if(abortOnFailure && !passed && abortPipeline){
            error 'pipeline aborted proccess...'
        }
        return passed
}

def executeSonar(){
    echo "Ejecucion de las pruebas de calidad de codigo."
    return 'SECCESS'
}

def qualityGate(result){
    echo 'quality gate, waiting for results'
    sleep time: 2, unit: 'MINUTES'
    return result == 'SUCCESS'
}