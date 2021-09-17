package fr.benguiza.domainlayer

import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test
import kotlin.test.assertEquals

class UseCaseTest {
    @Test
    fun test() {
        // Given
        val data = FizzBuzzDomain()
        val useCase = GetFizzOrBuzzUseCase()
        val expected = data.list.first()

        // When
        val actual = useCase.execute(number = 3, int1 = 3, int2 = 5, str1 = "fizz", str2 = "buzz")
        // Then
        actual  shouldBeEqualTo expected

    }

    @Test
    fun test2() {
        // Given
        val data = FizzBuzzDomain()
        val useCase = GetFizzOrBuzzUseCase()
        val expected = data.list[1]

        // When
        val actual = useCase.execute(number = 5, int1 = 3, int2 = 5, str1 = "fizz", str2 = "buzz")
        // Then
        actual  shouldBeEqualTo expected
    }

    @Test
    fun test3() {
        // Given
        val data = FizzBuzzDomain()
        val useCase = GetFizzOrBuzzUseCase()
        val expected = data.list[2]

        // When
        val actual = useCase.execute(number = 15, int1 = 3, int2 = 5, str1 = "fizz", str2 = "buzz")
        // Then
        assertEquals(expected, actual)

    }

    @Test
    fun test4() {
        // Given
        val data = FizzBuzzDomain()
        val useCase = GetFizzOrBuzzUseCase()
        val expected = data.list[3]

        // When
        val actual = useCase.execute(number = 22, int1 = 3, int2 = 5, str1 = "fizz", str2 = "buzz")
        // Then
        assertEquals(expected, actual)
    }

}