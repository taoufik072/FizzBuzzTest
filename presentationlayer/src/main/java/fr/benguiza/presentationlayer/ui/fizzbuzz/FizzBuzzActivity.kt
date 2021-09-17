package fr.benguiza.presentationlayer.ui.fizzbuzz

import androidx.navigation.findNavController
import fr.benguiza.presentationlayer.R
import fr.benguiza.presentationlayer.tools.bundle
import fr.benguiza.presentationlayer.BaseActivity
import fr.benguiza.presentationlayer.ui.fizzbuzz.details.*
import fr.benguiza.presentationlayer.ui.fizzbuzz.inputs.FizzBuzzInputsFragment

class FizzBuzzActivity : BaseActivity(R.layout.activity_fizz_buzz_inputs),
    FizzBuzzInputsFragment.Delegate {

    override fun showGraphDetails(size: Int, int1: Int, int2: Int, str1: String, str2: String) {
        findNavController(R.id.nav_host).navigate(R.id.action_fizzBuzzInputsFragment_to_fizzBuzzDetailsFragment,
            bundle {
                putString(ARG_FIRST_WORD, str1)
                putString(ARG_SECOND_WORD, str2)
                putInt(ARG_FIRST_NUMBER, int1)
                putInt(ARG_SECOND_NUMBER, int2)
                putInt(ARG_LIMIT_NUMBER, size)

            }

        )

    }

}