class App(){

    fun convertToCelcius(valueFahrenheit: Double): Double{

        var valueCalsius: Double =  valueFahrenheit/ (9/5) - 32
        return  valueCalsius
    }


    fun convertToFahrenheit(valueCelsius: Double): Double{

        var valueFahrenheit: Double = valueCelsius * 9/5  + 32

        return valueFahrenheit
    }
}