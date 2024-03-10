def call(boolean abortOnFailure = fales) {
        //sleep time: 3, unit: 'MINUTES'
        
        def result = executeSonar()
        def timeout = 2 * 60

        def passed = qualityGate(result, timeout)

        return passed
}

def executeSonar(){
    echo "Ejecucion de las pruebas de calidad de codigo."
    return 'SECCESS'
}

def qualityGate(result, timeout){
    echo 'quality gate, waiting for results'
    sleep(timeout)
    return result = 'SUCCESS'
}