package com.example.zaruygulamasi

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class  MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val zar1Image : ImageView = findViewById(R.id.zar1Image)
        val zar2Image : ImageView = findViewById(R.id.zar2Image)
        val sallaButton : Button = findViewById(R.id.sallaButton)
        val clearButton : Button = findViewById(R.id.clearButton)

        sallaButton.setOnClickListener {    // butona basildiginda ne oluyor
            rollDice()
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()
        }

        clearButton.setOnClickListener {
            zar1Image.setImageResource(R.drawable.empty_dice)
            zar2Image.setImageResource(R.drawable.empty_dice)
            val toast = Toast.makeText(this, "Clear!", Toast.LENGTH_SHORT)
            toast.show()
        }

    }

    fun rollDice() {

        val dice1 = Dice()
        val dice2 = Dice()

        val dice1Roll = dice1.roll()
        val dice2Roll = dice2.roll()

        val zar1Image : ImageView = findViewById(R.id.zar1Image)
        val zar2Image : ImageView = findViewById(R.id.zar2Image)

        when (dice1Roll) {
            1 -> zar1Image.setImageResource(R.drawable.dice_1)
            2 -> zar1Image.setImageResource(R.drawable.dice_2)
            3 -> zar1Image.setImageResource(R.drawable.dice_3)
            4 -> zar1Image.setImageResource(R.drawable.dice_4)
            5 -> zar1Image.setImageResource(R.drawable.dice_5)
            else -> zar1Image.setImageResource(R.drawable.dice_6)
        }

        when (dice2Roll) {
            1 -> zar2Image.setImageResource(R.drawable.dice_1)
            2 -> zar2Image.setImageResource(R.drawable.dice_2)
            3 -> zar2Image.setImageResource(R.drawable.dice_3)
            4 -> zar2Image.setImageResource(R.drawable.dice_4)
            5 -> zar2Image.setImageResource(R.drawable.dice_5)
            else -> zar2Image.setImageResource(R.drawable.dice_6)
        }

    }

}

class Dice() {
    // 1-6 arasi degere sahip zar sinifi
    fun roll(): Int {
        val randomSayi = (1..6).random()    // 1'den 6'ya kadar random sayi uret
        return randomSayi
    }

}