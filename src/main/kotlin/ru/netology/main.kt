package ru.netology

fun main() {
    val typeCard = "Mastercard"
    val transferAmount = 65_000_00
    val previousTransaction = 10_000_00

    val commission = calculationCommission(typeCard = typeCard, previousTransaction = previousTransaction, transferAmount = transferAmount)
    println("При переводе: $transferAmount копеек с карты: $typeCard, комиссия составит: $commission копеек")
}

fun calculationCommission(typeCard: String = "VK Pay", previousTransaction: Int = 0, transferAmount: Int): Int {

    return when (typeCard) {
        "Mastercard", "Maestro" -> {
            val prefLimitForMastercardAndMaestro = 75_000_00
            val overrunLimit = prefLimitForMastercardAndMaestro - previousTransaction - transferAmount
            val minCommissionForMastercardAndMaestro = 20 * 100
            val commissionForMastercardAndMaestro = 0.006
            if (overrunLimit >= 0) 0 else (kotlin.math.abs(overrunLimit) * commissionForMastercardAndMaestro + minCommissionForMastercardAndMaestro).toInt()
        }
        "Visa", "Mir" -> {
            val minCommissionForVisaAndMir = 35 * 100
            val commissionForVisaAndMir = 0.0075
            val totalCommissionForVisaAndMir = transferAmount * commissionForVisaAndMir
            if (totalCommissionForVisaAndMir <= minCommissionForVisaAndMir) minCommissionForVisaAndMir else totalCommissionForVisaAndMir.toInt()
        }
        else -> 0
    }
}