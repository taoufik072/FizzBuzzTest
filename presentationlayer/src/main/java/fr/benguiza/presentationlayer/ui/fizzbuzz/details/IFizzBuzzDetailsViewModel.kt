package fr.benguiza.presentationlayer.ui.fizzbuzz.details

import androidx.lifecycle.LiveData
import fr.benguiza.presentationlayer.ui.fizzbuzz.FizzBuzzUi

interface IFizzBuzzDetailsViewModel {
    fun observeList(): LiveData<List<FizzBuzzUi>>
    fun observeError(): LiveData<Boolean>
    fun observeLoading(): LiveData<Boolean>
    fun generateList(size: Int, int1: Int, int2: Int, str1: String, str2: String): List<FizzBuzzUi>
    fun groupingFizzBuzzList(list: List<FizzBuzzUi>)
}