package ru.netology

import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    // комиссия для Mastercard 0р. при сумме переводов <= 75 000р. в месяц
    fun calculationCommission_forMastercardWithBenefits() {
        // arrange
        val typeCard = TypeCard.MASTERCARD
        val transferAmount = 60_000_00
        val previousTransaction = 10_000_00

        // act
        val result = calculationCommission(
                typeCard = typeCard,
                previousTransaction = previousTransaction,
                transferAmount = transferAmount
        )

        // assert
        assertEquals(result, 0)
    }

    @Test
    // комиссия для Mastercard при сумме переводов > 75 000р. в месяц составит 0.6% + 20р.
    fun calculationCommission_forMastercardWithoutBenefits() {
        // arrange
        val typeCard = TypeCard.MASTERCARD
        val transferAmount = 65_000_00
        val previousTransaction = 20_000_00

        // act
        val result = calculationCommission(
                typeCard = typeCard,
                previousTransaction = previousTransaction,
                transferAmount = transferAmount
        )

        // assert
        assertEquals(result, 80_00)
    }

    @Test
    // комиссия для Maestro 0р. при сумме переводов <= 75 000р. в месяц
    fun calculationCommission_forMaestroWithBenefits() {
        // arrange
        val typeCard = TypeCard.MAESTRO
        val transferAmount = 60_000_00
        val previousTransaction = 10_000_00

        // act
        val result = calculationCommission(
                typeCard = typeCard,
                previousTransaction = previousTransaction,
                transferAmount = transferAmount
        )

        // assert
        assertEquals(result, 0)
    }

    @Test
    // комиссия для Maestro при сумме переводов > 75 000р. в месяц составит 0.6% + 20р.
    fun calculationCommission_forMaestroWithoutBenefits() {
        // arrange
        val typeCard = TypeCard.MAESTRO
        val transferAmount = 65_000_00
        val previousTransaction = 20_000_00

        // act
        val result = calculationCommission(
                typeCard = typeCard,
                previousTransaction = previousTransaction,
                transferAmount = transferAmount
        )

        // assert
        assertEquals(result, 80_00)
    }

    //----------------------------------------------------------------------------------------------------

    @Test
    // минимальная комиссия для Visa 35р., если 0.75% от покупки <= 35р.
    fun calculationCommission_forVisaWhenMinCommission() {
        // arrange
        val typeCard = TypeCard.VISA
        val transferAmount = 2_000_00
        val previousTransaction = 10_000_00

        // act
        val result = calculationCommission(
                typeCard = typeCard,
                previousTransaction = previousTransaction,
                transferAmount = transferAmount
        )

        // assert
        assertEquals(result, 35_00)
    }

    @Test
    // стандартная для Visa комиссия 0.75%, минимальный порог превышен = 35р.
    fun calculationCommission_forVisa() {
        // arrange
        val typeCard = TypeCard.VISA
        val transferAmount = 6_000_00
        val previousTransaction = 10_000_00

        // act
        val result = calculationCommission(
                typeCard = typeCard,
                previousTransaction = previousTransaction,
                transferAmount = transferAmount
        )

        // assert
        assertEquals(result, 45_00)
    }

    @Test
    // минимальная комиссия для Mir 35р., если 0.75% от покупки <= 35р
    fun calculationCommission_forMirWhenMinCommission() {
        // arrange
        val typeCard = TypeCard.MIR
        val transferAmount = 2_000_00
        val previousTransaction = 10_000_00

        // act
        val result = calculationCommission(
                typeCard = typeCard,
                previousTransaction = previousTransaction,
                transferAmount = transferAmount
        )

        // assert
        assertEquals(result, 35_00)
    }

    @Test
    // стандартная для Mir комиссия 0.75%, минимальный порог превышен = 35р.
    fun calculationCommission_forMir() {
        // arrange
        val typeCard = TypeCard.MIR
        val transferAmount = 6_000_00
        val previousTransaction = 10_000_00

        // act
        val result = calculationCommission(
                typeCard = typeCard,
                previousTransaction = previousTransaction,
                transferAmount = transferAmount
        )

        // assert
        assertEquals(result, 45_00)
    }

    //----------------------------------------------------------------------------------------------------

    @Test
    // комиссия для VK Pay не взимается
    fun calculationCommission_forVkPay() {
        // arrange
        val typeCard = TypeCard.VKPAY
        val transferAmount = 2_000_00
        val previousTransaction = 10_000_00

        // act
        val result = calculationCommission(
                typeCard = typeCard,
                previousTransaction = previousTransaction,
                transferAmount = transferAmount
        )

        // assert
        assertEquals(result, 0)
    }
}