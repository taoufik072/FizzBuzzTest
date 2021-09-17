package fr.benguiza.fizzbuzz.di.modules

import dagger.Module
import dagger.Provides
import fr.benguiza.domainlayer.GetFizzOrBuzzUseCase

@Module
class UseCasesModule {

    @Provides
    fun provideGetFizzOrBuzzUseCase(): GetFizzOrBuzzUseCase {
        return GetFizzOrBuzzUseCase()
    }
}