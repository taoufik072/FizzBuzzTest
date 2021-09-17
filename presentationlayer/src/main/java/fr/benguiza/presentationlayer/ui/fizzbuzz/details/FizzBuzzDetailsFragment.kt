package fr.benguiza.presentationlayer.ui.fizzbuzz.details

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import fr.benguiza.presentationlayer.R
import fr.benguiza.presentationlayer.di.injector
import fr.benguiza.presentationlayer.BaseFragment
import javax.inject.Inject

class FizzBuzzDetailsFragment : BaseFragment(R.layout.fragment_fizz_buzz_details) {

    @Inject
    lateinit var viewModel: IFizzBuzzDetailsViewModel
    private var view: FizzBuzzDetailsView? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector?.inject(this)
    }

    override fun afterViewCreated(view: View) {
        this.view = FizzBuzzDetailsView(
            view = view,
            lifecycle = this,
            viewModel = viewModel,
            firstNumber = arguments!!.getInt(ARG_FIRST_NUMBER),
            secondNumber = arguments!!.getInt(ARG_SECOND_NUMBER),
            firstWord = arguments!!.getString(ARG_FIRST_WORD)!!,
            secondWord = arguments!!.getString(ARG_SECOND_WORD)!!,
            limitNumber = arguments!!.getInt(ARG_LIMIT_NUMBER)
        )
    }

    override fun onDetach() {
        super.onDetach()
        view = null
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }
}

const val ARG_LIMIT_NUMBER = ":ARG_LIMIT_NUMBER"
const val ARG_FIRST_NUMBER = ":ARG_FIRST_NUMBER"
const val ARG_SECOND_NUMBER = ":ARG_SECOND_NUMBER"
const val ARG_FIRST_WORD = ":ARG_FIRST_WORD"
const val ARG_SECOND_WORD = ":ARG_SECOND_WORD"
