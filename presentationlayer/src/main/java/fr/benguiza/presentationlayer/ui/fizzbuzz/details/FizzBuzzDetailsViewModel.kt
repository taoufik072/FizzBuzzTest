package fr.benguiza.presentationlayer.ui.fizzbuzz.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.benguiza.domainlayer.GetFizzOrBuzzUseCase
import fr.benguiza.presentationlayer.ui.fizzbuzz.FizzBuzzUi
import fr.benguiza.presentationlayer.ui.fizzbuzz.toUi

class FizzBuzzDetailsViewModel(
    private val getFizzOrBuzzUseCase: GetFizzOrBuzzUseCase
) : ViewModel(), IFizzBuzzDetailsViewModel {

    private val fizzBuzzList = MutableLiveData<List<FizzBuzzUi>>()

    //not needed here
    private val errorState = MutableLiveData<Boolean>()
    private val loadingState = MutableLiveData<Boolean>()

    override fun observeError(): LiveData<Boolean> = errorState
    override fun observeLoading(): LiveData<Boolean> = loadingState

    override fun observeList(): LiveData<List<FizzBuzzUi>> = fizzBuzzList
    override fun groupingFizzBuzzList(list : List<FizzBuzzUi>){
        val grouping =list.groupingBy(FizzBuzzUi::title)
        val aggregate = grouping
            .aggregate { _, accumulator: FizzBuzzUi?, element: FizzBuzzUi, _ ->
                accumulator?.let {
                    it.copy(
                        id = it.id, title = it.title, countCalling = it.countCalling+1
                    )
                } ?: element
            }
        fizzBuzzList.postValue(aggregate.values.toList())
    }

    override fun generateList(size: Int, int1: Int, int2: Int, str1: String, str2: String) : List<FizzBuzzUi> {
       return (1..size).map { getFizzOrBuzzUseCase.execute(it, int1, int2, str1, str2).toUi() }
    }

}