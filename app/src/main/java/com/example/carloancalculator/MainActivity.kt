package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            calculateRepayment()
        }
    }

    private fun calculateRepayment() {
        //TODO get inputs and show outputs
        if(editTextCarPrice.text.isEmpty()){
            editTextCarPrice.setError(getString(R.string.error_input))
            return
        }
        if(editTextDownPayment2.text.isEmpty()){
            editTextDownPayment2.setError(getString(R.string.error_input))
            return
        }
        if(editTextInterestRate.text.isEmpty()){
            editTextInterestRate.setError(getString(R.string.error_input))
            return
        }
        if(editTextLoanPeriod.text.isEmpty()){
            editTextLoanPeriod.setError(getString(R.string.error_input))
            return
        }



        val carPrice: Int  = editTextCarPrice.text.toString().toInt()
        val downPayment: Int = editTextDownPayment2.text.toString().toInt()
        val loanPeriod = carPrice - downPayment
        val interest: Float = editTextInterestRate.text.toString().toFloat() * carPrice * editTextLoanPeriod.text.toString().toInt()
        val monthlyRepayment: Float = (carPrice+interest)/loanPeriod/12


        textViewLoan.setText(getString(R.string.loan)+"${loanPeriod}")
        textViewInterest.setText(getString(R.string.interest)+"${interest}")
        textViewMonthlyRepayment.setText(getString(R.string.monthly_repayment)+"${monthlyRepayment}")


    }

    fun reset(view : View){
        //TODO clear all inputs and outputs
        editTextLoanPeriod.setText("")
        editTextCarPrice.setText("")
        editTextDownPayment2.setText("")
        editTextInterestRate.setText("")
        textViewMonthlyRepayment.setText(getString(R.string.monthly_repayment))
        textViewInterest.setText(getString(R.string.interest))
        textViewLoan.setText(getString(R.string.loan))

    }
}
