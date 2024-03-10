def call(boolean abortOnFailure = false, abortPipeline = false) {
        //sleep time: 3, unit: 'MINUTES'
        
        def result = executeSonar()
        def timeout = 2 * 60

        def passed = qualityGate(result, timeout)

        if(abortOnFailure && !passed && abortOnFailure){
            error 'pipeline aborted proccess...'
        }
        return passed
}

def executeSonar(){
    echo "Ejecucion de las pruebas de calidad de codigo."
    return 'SECCESS'
}

def qualityGate(result, timeout){
    echo 'quality gate, waiting for results'
    sleep(timeout)
    return result == 'SUCCESS'
}