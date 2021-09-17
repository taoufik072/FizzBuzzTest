package fr.benguiza.presentationlayer.ui.fizzbuzz.inputs

import android.content.Context
import android.os.Bundle
import android.view.View
import fr.benguiza.presentationlayer.R
import fr.benguiza.presentationlayer.di.injector
import fr.benguiza.presentationlayer.tools.cast
import fr.benguiza.presentationlayer.BaseFragment

class FizzBuzzInputsFragment : BaseFragment(R.layout.fragment_fizz_buzz_listing) {

    private var view: FizzBuzzInputsView? = null
    private var delegate: Delegate? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        delegate = context.cast()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector?.inject(this)
    }

    override fun afterViewCreated(view: View) {
        this.view = FizzBuzzInputsView(
            view = view,
            showGraphDetails = { size, int1, int2, str1, str2 ->
                delegate?.showGraphDetails(
                    size = size,
                    int1 = int1,
                    int2 = int2,
                    str1 = str1,
                    str2 = str2
                )
            }
        )
    }

    override fun onDetach() {
        super.onDetach()
        view = null
        delegate = null
    }

    interface Delegate {
        fun showGraphDetails(size: Int, int1: Int, int2: Int, str1: String, str2: String)
    }
}