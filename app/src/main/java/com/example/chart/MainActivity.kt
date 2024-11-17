package com.example.chart

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate

class MainActivity : AppCompatActivity() {
    private lateinit var pieChart: PieChart
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pieChart = findViewById(R.id.pieChart)

        // Dữ liệu ví dụ
        val entries = listOf(
            PieEntry(10f, "Item 1"),
            PieEntry(20f, "Item 2"),
            PieEntry(30f, "Item 3"),
            PieEntry(40f, "Item 3")
        )

        // DataSet và thiết lập màu sắc
        val dataSet = PieDataSet(entries, "Example Data")
        dataSet.apply {
            colors = ColorTemplate.MATERIAL_COLORS.toList()
            sliceSpace = 1f
            isUsingSliceColorAsValueLineColor = true
            yValuePosition = PieDataSet.ValuePosition.OUTSIDE_SLICE
            xValuePosition = PieDataSet.ValuePosition.OUTSIDE_SLICE
            valueLinePart1OffsetPercentage = 100f
            valueLinePart1Length = 0.4f
            valueLinePart2Length = 0.5f
        }

        // Tạo PieData
        val data = PieData(dataSet)
        data.apply {
            setValueTextColor(Color.BLACK)
            setValueTextSize(12f)
        }

        // Cài đặt PieChart
        pieChart.data = data
        pieChart.apply {
            setUsePercentValues(true)
            description.isEnabled = false
            setEntryLabelTextSize(12f)
            setEntryLabelColor(Color.BLACK)
            setExtraOffsets(20f , 20f, 20f, 20f)
            legend.isEnabled = false
        }

    }
}