package com.ckh.bmi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.ckh.bmi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.calBtn.setOnClickListener {
            if(binding.height.text.isEmpty()||binding.weight.text.isEmpty()){
                Toast.makeText(this,"값을 입력해 주십시오",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            calculatingBMI()
        }
    }
    fun calculatingBMI() {
        val height:Int = binding.height.text.toString().toInt()
        val weight:Int = binding.weight.text.toString().toInt()
        val intent = Intent(this,ResultActivity::class.java)
        intent.putExtra("height",height)
        intent.putExtra("weight",weight)
        startActivity(intent)
    }
}