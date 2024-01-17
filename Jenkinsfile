pipeline {
    agent any
    environment {
        SYSTEM_PATH = "C:\\Windows\\System32"
        MAVEN_PATH = "C:\\apache-maven-3.9.6\\bin"
        PATH = "${SYSTEM_PATH};${MAVEN_PATH}"
    }
    stages {
        stage('Preparación del proyecto') {
            steps {
                // Paso 3.1: Clonar el repositorio remoto de GitHub
                checkout scm
            }
        }
        
        stage('Construcción del proyecto') {
            steps {
                // Paso 3.2: Compilar el proyecto con Maven
                bat 'mvn clean package'
            }
        }

        stage('Pruebas y resultados') {
            steps {
                // Paso 3.3: Ejecutar pruebas y guardar resultados en archivo XML
                bat 'mvn test'
            }
            post {
                always {
                    // Capturar reportes de pruebas pero no fallar si no se encuentran
                    junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
                }
            }
        }
    }
    
    post {
        success {
            // Paso 4: Evidenciar artefacto generado después de la compilación
            archiveArtifacts artifacts: '**/target/*.war', allowEmptyArchive: true
        }
    }
}
