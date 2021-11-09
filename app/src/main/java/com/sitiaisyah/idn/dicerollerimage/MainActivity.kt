package com.sitiaisyah.idn.dicerollerimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var diceImages : ImageView
    lateinit var secondDiceImages : ImageView
    lateinit var textValue : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton = findViewById<Button>(R.id.btn_roller)
        rollButton.setOnClickListener { rollNumber() }

        val resetButton = findViewById<Button>(R.id.btn_resset)
        resetButton.setOnClickListener { resetNumber() }

        diceImages = findViewById(R.id.iv_dice)
        secondDiceImages = findViewById(R.id.iv_dice_second)

        textValue = findViewById(R.id.tv_dice_first)
    }

    private fun resetNumber() {
        if (diceImages != resources.getDrawable(R.drawable.dice_1)){
            diceImages.setImageResource(R.drawable.dice_1)
            if (secondDiceImages != resources.getDrawable(R.drawable.dice_3)){
                secondDiceImages.setImageResource(R.drawable.dice_1)
            }
        }
    }

    private fun rollNumber() {
        val randomValue = (1..6).random()
        val imageRandom = when (randomValue){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImages.setImageResource(imageRandom)
        
        val secondRandomValue = (1..6).random()
        val secondImageRandom = when (secondRandomValue){
            1 -> R.drawable.dice_3
            2 -> R.drawable.dice_5
            3 -> R.drawable.dice_1
            4 -> R.drawable.dice_6
            5 -> R.drawable.dice_2
            else -> R.drawable.dice_4
        }
        secondDiceImages.setImageResource(secondImageRandom)

    }
}
