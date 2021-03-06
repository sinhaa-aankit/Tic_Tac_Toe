package com.example.tictactoe

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class PlayerVsPlayer : AppCompatActivity() {
    lateinit var b1:Button
    lateinit var b2:Button
    lateinit var b3:Button
    lateinit var b4:Button
    lateinit var b5:Button
    lateinit var b6:Button
    lateinit var b7:Button
    lateinit var b8:Button
    lateinit var b9:Button
    lateinit var reset:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        b1 = findViewById(R.id.button1)
        b2 = findViewById(R.id.button2)
        b3 = findViewById(R.id.button3)
        b4 = findViewById(R.id.button4)
        b5 = findViewById(R.id.button5)
        b6 = findViewById(R.id.button6)
        b7 = findViewById(R.id.button7)
        b8 = findViewById(R.id.button8)
        b9 = findViewById(R.id.button9)
        reset = findViewById(R.id.reset)

        reset.setOnClickListener(View.OnClickListener {
            reset()
        })

    }
    var move = 0
    var str1 = "X"
    var str2 = "0"

    private val first: Array<IntArray> = arrayOf(
        intArrayOf(2, 2, 2),
        intArrayOf(2, 2, 2),
        intArrayOf(2, 2, 2)
    )

    fun onClk(view: View){
        ++move
        val button = view as Button
        var st = button.tag.toString()

        if(move%2 == 0){
            button.text = str1
            //button.setBackgroundColor(Color.BL)
            checkWin(st,0)
        }
        else{
            button.text = str2
            checkWin(st,1)
        }
        if(move == 9){
            playerWins.text="TIE!"
        }
        button.isClickable = false


    }

    private fun checkWin(st:String, i:Int){
        when (st) {
            "00"-> first[0][0] = i
            "01"-> first[0][1] = i
            "02"-> first[0][2] = i
            "10"-> first[1][0] = i
            "11"-> first[1][1] = i
            "12"-> first[1][2] = i
            "20"-> first[2][0] = i
            "21"-> first[2][1] = i
            "22"-> first[2][2] = i

        }

        if(first[0][0] == 1 && first[0][1]  == 1 && first[0][2] == 1){
            b1.setBackgroundColor(Color.RED)
            b2.setBackgroundColor(Color.RED)
            b3.setBackgroundColor(Color.RED)
            onWin(1)
        }
        if(first[1][0] == 1 && first[1][1]  == 1 && first[1][2] == 1){
            b4.setBackgroundColor(Color.RED)
            b5.setBackgroundColor(Color.RED)
            b6.setBackgroundColor(Color.RED)
            onWin(1)
        }
        if(first[2][0] == 1 && first[2][1]  == 1 && first[2][2] == 1){
            b7.setBackgroundColor(Color.RED)
            b8.setBackgroundColor(Color.RED)
            b9.setBackgroundColor(Color.RED)
            onWin(1)
        }
        if(first[0][0] == 1 && first[1][0]  == 1 && first[2][0] == 1){
            b1.setBackgroundColor(Color.RED)
            b4.setBackgroundColor(Color.RED)
            b7.setBackgroundColor(Color.RED)
            onWin(1)
        }
        if(first[0][1] == 1 && first[1][1]  == 1 && first[2][1] == 1){
            b2.setBackgroundColor(Color.RED)
            b5.setBackgroundColor(Color.RED)
            b8.setBackgroundColor(Color.RED)
            onWin(1)
        }
        if(first[0][2] == 1 && first[1][2]  == 1 && first[2][2] == 1){
            b3.setBackgroundColor(Color.RED)
            b6.setBackgroundColor(Color.RED)
            b9.setBackgroundColor(Color.RED)
            onWin(1)
        }
        if(first[0][0] == 1 && first[1][1]  == 1 && first[2][2] == 1){
            b1.setBackgroundColor(Color.RED)
            b5.setBackgroundColor(Color.RED)
            b9.setBackgroundColor(Color.RED)
            onWin(1)
        }
        if(first[2][0] == 1 && first[1][1]  == 1 && first[0][2] == 1){
            b3.setBackgroundColor(Color.RED)
            b5.setBackgroundColor(Color.RED)
            b7.setBackgroundColor(Color.RED)
            onWin(1)
        }



        if(first[0][0] == 0 && first[0][1]  == 0 && first[0][2] == 0){
            b1.setBackgroundColor(Color.RED)
            b2.setBackgroundColor(Color.RED)
            b3.setBackgroundColor(Color.RED)
            onWin(0)
        }
        if(first[1][0] == 0 && first[1][1]  == 0 && first[1][2] == 0){
            b4.setBackgroundColor(Color.RED)
            b5.setBackgroundColor(Color.RED)
            b6.setBackgroundColor(Color.RED)
            onWin(0)
        }
        if(first[2][0] == 0 && first[2][1]  == 0 && first[2][2] == 0){
            b7.setBackgroundColor(Color.RED)
            b8.setBackgroundColor(Color.RED)
            b9.setBackgroundColor(Color.RED)
            onWin(0)
        }
        if(first[0][0] == 0 && first[1][0]  == 0 && first[2][0] == 0){
            b1.setBackgroundColor(Color.RED)
            b4.setBackgroundColor(Color.RED)
            b7.setBackgroundColor(Color.RED)
            onWin(0)
        }
        if(first[0][1] == 0 && first[1][1]  == 0 && first[2][1] == 0){
            b2.setBackgroundColor(Color.RED)
            b5.setBackgroundColor(Color.RED)
            b8.setBackgroundColor(Color.RED)
            onWin(0)
        }
        if(first[0][2] == 0 && first[1][2]  == 0 && first[2][2] == 0){
            b3.setBackgroundColor(Color.RED)
            b6.setBackgroundColor(Color.RED)
            b9.setBackgroundColor(Color.RED)
            onWin(0)
        }
        if(first[0][0] == 0 && first[1][1]  == 0 && first[2][2] == 0){
            b1.setBackgroundColor(Color.RED)
            b5.setBackgroundColor(Color.RED)
            b9.setBackgroundColor(Color.RED)
            onWin(0)
        }
        if(first[2][0] == 0 && first[1][1]  == 0 && first[0][2] == 0){
            b3.setBackgroundColor(Color.RED)
            b5.setBackgroundColor(Color.RED)
            b7.setBackgroundColor(Color.RED)
            onWin(0)
        }

    }
    fun onWin(player:Int){
        if(player == 1){
            playerWins.text = "Player $player Wins"
        }

        else{
            playerWins.text = "Player 2 Wins"
        }
        b1.isClickable=false
        b2.isClickable=false
        b3.isClickable=false
        b4.isClickable=false
        b5.isClickable=false
        b6.isClickable=false
        b7.isClickable=false
        b8.isClickable=false
        b9.isClickable=false
    }

    fun reset(){
        val inent = intent
        finish()
        startActivity(intent)
    }

}