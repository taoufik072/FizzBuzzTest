package fr.benguiza.domainlayer

class GetFizzOrBuzzUseCase {

    fun execute(number: Int,int1 :Int, int2:Int, str1:String , str2:String): FizzBuzzItem {

        if (number % int1 == 0 && number % int2 == 0) {
            return FizzBuzzItem(number,"$str1$str2")
        }

        if (number % int1 == 0) {
            return FizzBuzzItem(number,str1)
        }

        if (number % int2 == 0) {
            return FizzBuzzItem(number,str2)
        }

        return FizzBuzzItem(number,"not Fizz Buzz")
    }
}