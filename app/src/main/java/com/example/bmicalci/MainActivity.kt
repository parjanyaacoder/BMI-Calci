package com.example.bmicalci

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import com.example.bmicalci.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private var myRes : MyRes = MyRes("Result is")
      override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myRes = myRes
        binding.calculateButton.setOnClickListener{calculate()}
    }

    private fun calculate() {


        val wt = binding.weight.text.toString()
        val ht = binding.height.text.toString()
        val myWt = wt.toFloat()
        val myHt = ht.toFloat()/100.0
        val myResult = myWt / (myHt * myHt)
        binding.apply {
            myRes?.res = myResult.toString()
            binding.resultText.visibility= View.VISIBLE
            invalidateAll()
        }



    }



}

