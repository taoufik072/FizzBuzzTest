package fr.benguiza.presentationlayer.di

import dagger.Subcomponent
import fr.benguiza.presentationlayer.ui.fizzbuzz.details.FizzBuzzDetailsFragment
import fr.benguiza.presentationlayer.ui.fizzbuzz.inputs.FizzBuzzInputsFragment

@Subcomponent
interface FragmentsComponent {
    fun inject(fragment: FizzBuzzInputsFragment)
    fun inject(fragment: FizzBuzzDetailsFragment)
}