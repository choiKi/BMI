package com.ckh.bmi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ckh.bmi.databinding.ActivityResultBinding
import kotlin.math.pow

class ResultActivity:AppCompatActivity() {

    val binding by lazy { ActivityResultBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val height =intent.getIntExtra("height",0)
        val weight =intent.getIntExtra("weight",0)

        val bmi = weight / (height.toDouble() / 100).pow(2.0)
        val bmiResult = when {
            bmi >=35.0 -> "고도비만"
            bmi >=30.0 -> "중정도비만"
            bmi >=25.0 -> "경도비만"
            bmi >=23.0 -> "과체중"
            bmi >=18.5 -> "정상체중"
            else -> "저체중"
        }
        binding.resultText.text ="${bmi}"
        binding.bmiLevel.text = "${bmiResult} 입니다"
    }
}