def call(boolean abortOnFailure, boolean abortPipeline) {
        //sleep time: 3, unit: 'MINUTES'
        
        def result = executeSonar()

        def passed = qualityGate(result)

        if(abortOnFailure && passed && abortPipeline){
            error 'pipeline aborted proccess...'
        }

        echo 'abortOnFailure '+abortOnFailure + 'passed '+ passed + 'abortPipeline' + abortPipeline
        return passed
}

def executeSonar(){
    echo "Ejecucion de las pruebas de calidad de codigo."
    return 'SUCCESS'
}

def qualityGate(result){
    echo 'quality gate, waiting for results'
   // sleep time: 2, unit: 'MINUTES'
    return result == 'SUCCESS'
}