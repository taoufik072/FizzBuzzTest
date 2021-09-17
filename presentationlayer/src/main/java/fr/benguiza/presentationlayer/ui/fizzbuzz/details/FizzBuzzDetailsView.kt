package fr.benguiza.presentationlayer.ui.fizzbuzz.details

import android.graphics.Color
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.IValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.github.mikephil.charting.utils.MPPointF
import fr.benguiza.presentationlayer.R
import fr.benguiza.presentationlayer.tools.unsafeLazy
import fr.benguiza.presentationlayer.tools.views.ListAdapter
import fr.benguiza.presentationlayer.tools.views.ViewHolder
import fr.benguiza.presentationlayer.ui.fizzbuzz.FizzBuzzUi

class FizzBuzzDetailsView(
    view: View,
    limitNumber: Int,
    firstNumber: Int,
    secondNumber: Int,
    firstWord: String,
    secondWord: String,
    viewModel: IFizzBuzzDetailsViewModel,
    lifecycle: LifecycleOwner
) {
    private val recyclerView by unsafeLazy { view.findViewById<RecyclerView>(R.id.view_fizz_buzz_list) }
    private val pieChart  by unsafeLazy { view.findViewById<PieChart>(R.id.pie_chart) }


    init {
        viewModel.observeList().observe(lifecycle, Observer { showGraph(it) })

       val generatedList =  viewModel.generateList(
            size = limitNumber,
            int1 = firstNumber,
            int2 = secondNumber,
            str1 = firstWord,
            str2 = secondWord
        )

        showList(generatedList)
        viewModel.groupingFizzBuzzList(generatedList)

    }


    private fun showList(fizzBuzzList: List<FizzBuzzUi>) {
        recyclerView.adapter = ListAdapter(
            items = fizzBuzzList,
            layout = R.layout.item_fizz_holder,
            createViewHolder = { itemView ->
                FizzBuzzViewHolder(view = itemView)
            })

    }

    private fun showGraph(fizzBuzzList: List<FizzBuzzUi>) {
        val pieEntries = ArrayList<PieEntry>()

        fizzBuzzList.forEach { item ->
            pieEntries.add(PieEntry(item.countCalling.toFloat(), item.title))
        }
        val dataSet = PieDataSet(pieEntries, "Number Of Fizz & Buzz")

        dataSet.setDrawIcons(false)
        dataSet.valueFormatter =
            IValueFormatter { value, _, _, _ -> value.toInt().toString(); }
        dataSet.sliceSpace = 3f
        dataSet.iconsOffset = MPPointF(0F, 40F)
        dataSet.selectionShift = 5f
        dataSet.setColors(*ColorTemplate.COLORFUL_COLORS)

        val data = PieData(dataSet)
        data.setValueTextSize(11f)
        data.setValueTextColor(Color.BLUE)

        pieChart.data = data
        pieChart.highlightValues(null)
        pieChart.invalidate()
        pieChart.animateXY(1000, 1000)
    }

}

class FizzBuzzViewHolder(view: View) :
    ViewHolder<FizzBuzzUi>(view) {
    private val titleView by unsafeLazy { view.findViewById<AppCompatTextView>(R.id.view_fizz_title) }
    private val numberView by unsafeLazy { view.findViewById<AppCompatTextView>(R.id.view_fizz_buzz_number) }

    override fun bind(item: FizzBuzzUi) {
        super.bind(item)
        with(item) {
            titleView.text = title
            numberView.text = id.toString()
        }
    }
}