package fr.benguiza.fizzbuzz.di.modules

import dagger.Module
import dagger.Provides
import fr.benguiza.domainlayer.GetFizzOrBuzzUseCase
import fr.benguiza.presentationlayer.ui.fizzbuzz.details.FizzBuzzDetailsViewModel
import fr.benguiza.presentationlayer.ui.fizzbuzz.details.IFizzBuzzDetailsViewModel

@Module
class ViewModelsModule {

    @Provides
    fun provideFizzBuzzListingViewModel(getFizzOrBuzzUseCase: GetFizzOrBuzzUseCase): IFizzBuzzDetailsViewModel {
        return FizzBuzzDetailsViewModel(getFizzOrBuzzUseCase)
    }
}