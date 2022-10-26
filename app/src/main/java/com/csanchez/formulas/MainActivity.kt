package com.csanchez.formulas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentTransaction
import com.csanchez.formulas.databinding.ActivityFormulaResultBinding
import com.csanchez.formulas.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener  {

    private lateinit var formula1Fragment: Formula1Fragment
    private lateinit var formula2Fragment: Formula2Fragment
    private lateinit var formula3Fragment: Formula3Fragment
    private lateinit var initialFragment: InitialFragment
    private lateinit var transaction: FragmentTransaction
    private lateinit var layout: androidx.constraintlayout.widget.ConstraintLayout

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val spinner: Spinner = findViewById(R.id.spinner)

        layout = binding.mainActivityLayout

        ArrayAdapter.createFromResource(
            this,
            R.array.formulas_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = this


        formula1Fragment = Formula1Fragment()
        formula2Fragment = Formula2Fragment()
        formula3Fragment = Formula3Fragment()
        initialFragment = InitialFragment()

        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, initialFragment).commit()



    }


    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {

        val transaction = supportFragmentManager.beginTransaction()

        when(pos){
            0 -> {
                transaction.replace(R.id.fragmentContainer, initialFragment).commit()
                layout?.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.white))
            }
            1 -> {
                transaction.replace(R.id.fragmentContainer, formula1Fragment).commit()
                layout?.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.formula1))

            }
            2 -> {
                transaction.replace(R.id.fragmentContainer, formula2Fragment).commit()
                layout?.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.formula2))
            }
            3 -> {
                transaction.replace(R.id.fragmentContainer, formula3Fragment).commit()
                layout?.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.formula3))
            }
        }

    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}