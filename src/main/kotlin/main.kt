package ru.netology

fun main() {
    val typeCard = "Mastercard"
    val transferAmount = 65_000_00
    val previousTransaction = 20_000_00

    val commission = calculationCommission(typeCard = typeCard, previousTransaction = previousTransaction, transferAmount = transferAmount)
    println("При переводе: $transferAmount копеек с карты: $typeCard, комиссия составит: $commission копеек")
}

fun calculationCommission(typeCard: String = "VK Pay", previousTransaction: Int = 0, transferAmount: Int): Int {
    val prefLimit = 75_000_00
    val overrunLimit = prefLimit - previousTransaction - transferAmount
    val commission = transferAmount * 0.0075
    val minCommission1 = 20 * 100
    val minCommission2 = 35 * 100

    return when(typeCard) {
        "Mastercard", "Maestro" -> if (overrunLimit < 0) (kotlin.math.abs(overrunLimit) * 0.006 + minCommission1).toInt() else 0
        "Visa", "Мир" ->  if (commission > minCommission2) commission.toInt() else minCommission2
        else -> 0
    }
}