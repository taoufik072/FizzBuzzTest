package fr.benguiza.fizzbuzz.di

import dagger.Component
import fr.benguiza.fizzbuzz.di.modules.AppModule
import fr.benguiza.fizzbuzz.di.modules.UseCasesModule
import fr.benguiza.fizzbuzz.di.modules.ViewModelsModule
import fr.benguiza.presentationlayer.di.AppComponent
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class,
        UseCasesModule::class, ViewModelsModule::class]
)
interface TAppComponent : AppComponent