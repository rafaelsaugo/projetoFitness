package co.tiagoaguiar.codelab.myapplication.model

class calcular_beberAgua {
    private val ml_juvenil = 40.0
    private val ml_jovem = 35.0
    private val ml_adulto = 30.0
    private val ml_idoso = 25.0

    private var resultadoMl = 0.0

    private var resultadoTotalMl = 0.0

    fun CalcularTotalMl (peso: Double, idade: Int){

        if(idade <= 17){
            resultadoMl = peso * ml_juvenil
            resultadoTotalMl = resultadoMl
        }else if(idade <= 55){
            resultadoMl = peso * ml_jovem
            resultadoTotalMl = resultadoMl
        }else if (idade <= 65){
            resultadoMl = peso * ml_adulto
            resultadoTotalMl = resultadoMl
        }else{
            resultadoMl = peso * ml_idoso
            resultadoTotalMl = resultadoMl
        }
    }
    fun ResultadoMl(): Double{
        return resultadoTotalMl
    }

}