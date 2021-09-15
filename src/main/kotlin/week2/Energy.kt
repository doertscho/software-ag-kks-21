package week2

fun berechneTaeglichenVerbrauch(verbrauch: Double, stundenProTag: Double): Double {
    return verbrauch * stundenProTag
}

fun berechneJaehrlichenVerbrauch(verbrauch: Double, stundenProTag: Double): Double {
    return 365 * berechneTaeglichenVerbrauch(verbrauch, stundenProTag)
}

fun berechneJaehrlichenVerbrauchKWH(verbrauch: Double, stundenProTag: Double): Double {
    return berechneJaehrlichenVerbrauch(verbrauch, stundenProTag) / 1000.0
}

val preisProKWH = 0.3
fun berechnePreis(gesamtVerbrauchKWH: Double): Double {
    return gesamtVerbrauchKWH * preisProKWH
}

val co2ProKWH = 0.4
fun berechneCO2(gesamtVerbrauchKWH: Double): Double {
    return gesamtVerbrauchKWH * co2ProKWH
}

val co2Budget = 2100.0
fun berechneCo2BudgetAnteil(co2Ausstoss: Double): Double {
    val anteil = co2Ausstoss / co2Budget
    val prozentZahl = anteil * 100.0
    return prozentZahl
}

fun liesZahl(): Double {
    val eingabe: String = readLine() ?: error("Ungültige Eingabe!")
    return eingabe.toDouble()
}

fun main() {

    print("Gib den Verbrauch deines Elektrogeräts ein (in Watt): ")
    val verbrauch: Double = liesZahl()
    print("Wie lang ist das Gerät jeden Tag in Betrieb? (in Stunden): ")
    val stundenProTag: Double = liesZahl()

    val jaehrlicherVerbrauchKWH = berechneJaehrlichenVerbrauchKWH(verbrauch, stundenProTag)
    println("Der jährliche Verbrauch beträgt $jaehrlicherVerbrauchKWH kWh")

    val jaehrlicherPreis = berechnePreis(jaehrlicherVerbrauchKWH)
    println("Der Preis in einem Jahr beträgt $jaehrlicherPreis Euro")

    val jaehrlichesCO2 = berechneCO2(jaehrlicherVerbrauchKWH)
    println("Der jährliche CO2-Ausstoß beträgt $jaehrlichesCO2 kg")

    val co2BudgetAnteil = berechneCo2BudgetAnteil(jaehrlichesCO2)
    println("Das entspricht etwa $co2BudgetAnteil% deines persönlichen CO2-Budgets")
}
