package com.csanchez.formulas

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.csanchez.formulas.databinding.FragmentFormula1Binding
import java.lang.Math.pow


/**
 * A simple [Fragment] subclass.
 * Use the [Formula1Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Formula1Fragment : Fragment() {


    private var _binding: FragmentFormula1Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFormula1Binding.inflate(inflater, container, false)
        //return inflater.inflate(R.layout.fragment_formula1, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener{
            if(validaDatos()){
                calcularFormula()
            }
        }
    }



    fun validaDatos(): Boolean {
        with(binding) {
            if (valor1.text.isEmpty() || valor2.text.isEmpty()) {
                Toast.makeText(requireActivity(), getString(R.string.ingresa_un_valor), Toast.LENGTH_LONG).show()
                if(valor1.text.isEmpty())
                    valor1.error = getString(R.string.valor_requerido)
                if(valor2.text.isEmpty())
                    valor2.error = getString(R.string.valor_requerido)
                return false
            }
            return true
        }
    }

    fun calcularFormula(){
        with(binding){
            val numero1 = valor1.text.toString().toDouble()
            val numero2 = valor1.text.toString().toDouble()
            val resultado =    pow(numero1,2.0) +2*numero1*numero2+ pow(numero2,2.0) //numero1*numero1+2*numero1*numero2+numero2*numero2
            val intent = Intent(requireActivity(), FormulaResultActivity::class.java)
            intent.putExtra("resultado",resultado)
            intent.putExtra("numero1",numero1)
            intent.putExtra("numero2",numero2)
            intent.putExtra("formula",1)
            startActivity(intent)

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}