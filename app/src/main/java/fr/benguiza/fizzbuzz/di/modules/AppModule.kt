package fr.benguiza.fizzbuzz.di.modules

import fr.benguiza.fizzbuzz.app.FizzBuzzApplication
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(private val tapplication: FizzBuzzApplication) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return tapplication
    }


}