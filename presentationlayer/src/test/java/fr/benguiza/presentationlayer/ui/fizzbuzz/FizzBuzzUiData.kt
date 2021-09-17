package fr.benguiza.presentationlayer.ui.fizzbuzz

import fr.benguiza.domainlayer.FizzBuzzItem

class FizzBuzzUiData() {

    val ui by lazy { Ui() }
    val domain by lazy { Domain() }

    class Domain {


        private val fizzBuzzItem1 = FizzBuzzItem(
            id = 3,
            title = "fizz"
        )

        private val fizzBuzzItem2 = FizzBuzzItem(
            id = 5,
            title = "buzz"
        )
        val list = listOf(fizzBuzzItem1, fizzBuzzItem2)
    }

    class Ui {

        private val fizzBuzzUi1 = FizzBuzzUi(
            id = 1,
            title = "not Fizz Buzz",
            countCalling = 5
        )

        private val fizzBuzzUi2 = FizzBuzzUi(
            id = 3,
            title = "fizz",
            countCalling = 3
        )

        private val fizzBuzzUi3 = FizzBuzzUi(
            id = 5,
            title = "buzz",
            countCalling = 2
        )
        val list = listOf(fizzBuzzUi1, fizzBuzzUi2, fizzBuzzUi3)

    }
}