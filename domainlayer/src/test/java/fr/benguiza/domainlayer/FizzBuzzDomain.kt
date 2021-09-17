package fr.benguiza.domainlayer

import fr.benguiza.domainlayer.FizzBuzzItem

class FizzBuzzDomain {

    private val fizz = FizzBuzzItem(
        id = 3,
        title = "fizz"
    )

    private val buzz = FizzBuzzItem(
        id = 5,
        title = "buzz"
    )
    private val fizzBuzz = FizzBuzzItem(
        id = 15,
        title = "fizzbuzz"
    )

    private val notFizzBuzz = FizzBuzzItem(
        id = 22,
        title = "not Fizz Buzz"
    )

    val list = listOf(fizz, buzz,fizzBuzz,notFizzBuzz)

}