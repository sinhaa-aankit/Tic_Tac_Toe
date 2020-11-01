package com.example.tictactoe

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    var move = 0

    fun onClk(view: View){
        val button = view as Button
        if(button.text == """X""" || button.text == """0"""){

        }
        else if(move == 0){
            button.text = """X"""
            move = 1
        }
        else{
            button.text = """0"""
            move = 0
        }
    }

    /*fun btn1(view: View) {
        if(move == 0){
            button1.text = """X"""
            move = 1
        }
        else{
            button1.text = """0"""
            move = 0
        }
    }*/

}