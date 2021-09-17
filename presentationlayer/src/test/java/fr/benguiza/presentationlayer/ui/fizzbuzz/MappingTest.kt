package fr.benguiza.presentationlayer.ui.fizzbuzz

import org.amshove.kluent.shouldBeEqualTo
import org.junit.Before
import org.junit.Test

class MappingTest {

    private lateinit var data: FizzBuzzUiData

    @Before
    fun setUp() {
        data = FizzBuzzUiData()
    }

    @Test
    fun mapDomainToUi() {
        //Given
        val expected = data.ui.list
        //when
        val ui = data.domain.list.map { it.toUi() }

        ui shouldBeEqualTo expected
    }
}