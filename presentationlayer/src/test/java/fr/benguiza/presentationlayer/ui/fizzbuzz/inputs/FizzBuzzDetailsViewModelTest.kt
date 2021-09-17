package fr.benguiza.presentationlayer.ui.fizzbuzz.inputs

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import fr.benguiza.domainlayer.GetFizzOrBuzzUseCase
import fr.benguiza.presentationlayer.ui.fizzbuzz.FizzBuzzUi
import fr.benguiza.presentationlayer.ui.fizzbuzz.FizzBuzzUiData
import fr.benguiza.presentationlayer.ui.fizzbuzz.details.FizzBuzzDetailsViewModel
import fr.benguiza.presentationlayer.ui.fizzbuzz.details.IFizzBuzzDetailsViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class FizzBuzzDetailsViewModelTest {
    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: IFizzBuzzDetailsViewModel
    private lateinit var data: FizzBuzzUiData
    private lateinit var getFizzOrBuzzUseCase: GetFizzOrBuzzUseCase
    private lateinit var loadingObserver: Observer<Boolean>
    private lateinit var errorObserver: Observer<Boolean>
    private lateinit var fizzBuzzListObserver: Observer<List<FizzBuzzUi>>

    @Before
    fun setUp() {

        data = FizzBuzzUiData()
        getFizzOrBuzzUseCase= GetFizzOrBuzzUseCase()
        loadingObserver = mock()
        errorObserver = mock()
        fizzBuzzListObserver = mock()
    }

    @Test
    fun getFizzBuzzList() {
        // Given
        viewModel = FizzBuzzDetailsViewModel(getFizzOrBuzzUseCase)
        val grouping =viewModel.generateList(size = 10, int1 = 3, int2 = 5, str1 = "fizz", str2 = "buzz")
        viewModel.groupingFizzBuzzList(grouping)
        // When
        viewModel.observeError().observeForever(errorObserver)
        viewModel.observeLoading().observeForever(loadingObserver)
        viewModel.observeList().observeForever(fizzBuzzListObserver)
        // Then
        Assert.assertTrue(viewModel.observeLoading().hasObservers())
        Assert.assertTrue(viewModel.observeError().hasObservers())
        Assert.assertTrue(viewModel.observeList().hasObservers())

        verify(fizzBuzzListObserver).onChanged(data.ui.list)
    }


}