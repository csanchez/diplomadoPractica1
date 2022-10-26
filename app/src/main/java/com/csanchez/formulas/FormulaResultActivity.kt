package com.csanchez.formulas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.csanchez.formulas.databinding.ActivityFormulaResultBinding
import com.csanchez.formulas.databinding.FragmentFormula3Binding

class FormulaResultActivity : AppCompatActivity() {
    private var  numero1 : Double = 1.0
    private var  numero2 : Double = 1.0
    private var  numero3 : Double = 1.0
    private var formula : Int = 0
    private var resultadoFormula : Double = 1.0

    private var _binding: ActivityFormulaResultBinding? = null
    private val binding get() = _binding!!

    private lateinit var layout: androidx.constraintlayout.widget.ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityFormulaResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_formula_result)
        layout = binding.resultActivityLayout
        numero1 = intent.getDoubleExtra("numero1",1.0)
        numero2 = intent.getDoubleExtra("numero2",1.0)
        numero3 = intent.getDoubleExtra("numero3",1.0)
        resultadoFormula = intent.getDoubleExtra("resultado",1.0)
        formula = intent.getIntExtra("formula",0)

        with(binding){
            valor1.text = "${resources.getString(R.string.hinta)}: ${numero1}"
            valor2.text = "${resources.getString(R.string.hintb)}: ${numero2}"
            resultado.text = "${resources.getString(R.string.resultado)}: ${resultadoFormula}"
            valor3.visibility = View.GONE
            when(formula){
                1 -> {
                    nombreFormula.text = resources.getString(R.string.formula1)
                    layout?.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.formula1))
                }
                2 -> {
                    nombreFormula.text = resources.getString(R.string.formula2)
                    valor1.text = "${resources.getString(R.string.hintu)}: ${numero1}"
                    valor2.text = "${resources.getString(R.string.hintv)}: ${numero2}"
                    valor3.text = "${resources.getString(R.string.hintc)}: ${numero3}"
                    valor3.visibility = View.VISIBLE
                    layout?.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.formula2))
                }
                3 -> {
                    nombreFormula.text = resources.getString(R.string.formula3)
                    layout?.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.formula3))
                }
            }

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}