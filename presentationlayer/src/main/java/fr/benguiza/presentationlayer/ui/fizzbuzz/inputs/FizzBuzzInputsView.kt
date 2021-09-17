package fr.benguiza.presentationlayer.ui.fizzbuzz.inputs

import android.view.View
import android.widget.EditText
import android.widget.TextView
import fr.benguiza.presentationlayer.R
import fr.benguiza.presentationlayer.tools.*
import fr.benguiza.presentationlayer.tools.views.errorView

class FizzBuzzInputsView(
    view: View,
    private val showGraphDetails:  (size: Int, int1: Int, int2: Int, str1: String, str2: String) -> Unit
) {

    private val firstInput by unsafeLazy { view.findViewById<EditText>(R.id.word_one) }
    private val secondInput by unsafeLazy { view.findViewById<EditText>(R.id.word_two) }
    private val firstNumber by unsafeLazy { view.findViewById<EditText>(R.id.first_number) }
    private val secondNumber by unsafeLazy { view.findViewById<EditText>(R.id.second_number) }
    private val limitInput by unsafeLazy { view.findViewById<EditText>(R.id.limit) }
    private val graphBtn by unsafeLazy { view.findViewById<TextView>(R.id.graph_btn) }
    private val errorView by unsafeLazy {
        errorView(
            view = view, title = R.string.error_title,
            icon = R.drawable.ic_error
        ) { retry() }
    }

    init {
        graphBtn.setOnClickListener { handleInputs() }
    }

    private fun retry() {
        errorView.hide()
    }

    private fun handleInputs() {
        val int1: Int  = firstNumber.text.toString().toIntOrNull() ?: -1
        val int2 = secondNumber.text.toString().toIntOrNull() ?: -1

        val str1 = firstInput.text.toString()
        val str2 = secondInput.text.toString()
        val limit = limitInput.text.toString().toIntOrNull() ?:-1

        if (int1 <= 0 || int2 <= 0 || limit !in 0..100 || str1.isEmpty() || str2.isEmpty())
            errorView.show()
        else
            showGraphDetails.invoke(limit,int1,int2,str1,str2)
    }

}