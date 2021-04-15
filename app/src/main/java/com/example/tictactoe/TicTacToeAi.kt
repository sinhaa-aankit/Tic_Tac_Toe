package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.X
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class TicTacToeAi : AppCompatActivity() {

    lateinit var b1: Button
    lateinit var b2: Button
    lateinit var b3: Button
    lateinit var b4: Button
    lateinit var b5: Button
    lateinit var b6: Button
    lateinit var b7: Button
    lateinit var b8: Button
    lateinit var b9: Button
    lateinit var reset: Button
    var won=false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tic_tac_toe_ai)

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
    var human = "0"
    var ai = "X"
    var currentPlayer = human

    private var board: Array<Array<String>> = arrayOf(
        arrayOf("","",""),
        arrayOf("","",""),
        arrayOf("","","")
    )

    fun onClk(view: View){
        ++move
        val button = view as Button
        var st = button.tag.toString()
        button.text = human
        updateBoard(st,human)
        if(checkWinner() == human){
            playerWins.text="PLAYER 1 WINS"
            stopClick()
        }
        if(move == 9){
            if(checkWinner() == human){
                playerWins.text="PLAYER 1 WINS"
                stopClick()
            }
            else{
                playerWins.text="TIE!"
            }
        }
        button.isClickable = false

        if(move<=8 && !won){
            bestMove()
        }


    }
    //bestMove

    private lateinit var sfi: String
    private lateinit var sli: String

    private fun bestMove() {
        // AI to make its turn
        var bestScore = Int.MIN_VALUE
//        var alpha = Int.MIN_VALUE + 1
//        var beta = Int.MAX_VALUE - 1
        for (i in 0..2) {
            for (j in 0..2) {
            // Is the spot available?
            if (board[i][j] == "") {
                board[i][j] = ai;
                var score = minimax(board, 0, false, Int.MAX_VALUE, Int.MIN_VALUE);
                board[i][j] = "";
                if (score > bestScore) {
                    bestScore = score;
                    sfi = "$i"
                    sli = "$j"
                }
            }
        }
        }
        var stfl:String = sfi+sli
        updateBoard(stfl,ai)
        ++move
        aiMove(stfl)
        if(checkWinner() == ai){
            playerWins.text="PLAYER 2 WINS"
            stopClick()
        }
        currentPlayer = human;
    }

    private fun minimax(board:Array<Array<String>>, depth:Int, isMaximizing:Boolean, alpha:Int, beta:Int):Int {
        var result = checkWinner();
        if (result != "null") {
            return if(result == "0"){
                -1000
            } else{
                10 - depth
            }
        }

        var alphaOne = alpha
        var betaOne = beta

        if (isMaximizing) {
            var bestScore = Int.MIN_VALUE;
            for (i in 0..2) {
                for (j in 0..2) {
                // Is the spot available?
                if (board[i][j] == "") {
                    board[i][j] = ai;
                    var score = minimax(board, depth + 1, false, alpha, beta)
                    board[i][j] = ""
                    bestScore = maxOf(score, bestScore)
//                    alphaOne = maxOf(alphaOne, bestScore)
//                    if(betaOne <= alphaOne) break

                }
            }
            }
            return bestScore;
        } else {
            var bestScore = Int.MAX_VALUE;
            for (i in 0..2) {
                for (j in 0..2) {
                // Is the spot available?
                if (board[i][j] == "") {
                    board[i][j] = human;
                    var score = minimax(board, depth + 1, true, alpha, beta);
                    board[i][j] = ""
                    bestScore = minOf(score, bestScore);
//                    betaOne = minOf(betaOne, bestScore)
//                    if(betaOne <= alphaOne) break
                }
            }
            }
            return bestScore;
        }
    }


    private fun aiMove(st:String) {
        when (st) {
            "00" -> {
                b1.text = ai
                b1.isClickable = false
            }
            "01" -> {
                b2.text = ai
                b2.isClickable = false
            }
            "02" -> {
                b3.text = ai
                b3.isClickable = false
            }
            "10" -> {
                b4.text = ai
                b4.isClickable = false
            }
            "11" -> {
                b5.text = ai
                b5.isClickable = false
            }
            "12" -> {
                b6.text = ai
                b6.isClickable = false
            }
            "20" -> {
                b7.text = ai
                b7.isClickable = false
            }
            "21" -> {
                b8.text = ai
                b8.isClickable = false
            }
            "22" -> {
                b9.text = ai
                b9.isClickable = false
            }

        }
    }

    private fun updateBoard(st:String, txt:String) {
        when (st) {
            "00" -> {
                board[0][0] = txt
            }
            "01" -> {
                board[0][1] = txt
            }
            "02" -> {
                board[0][2] = txt
            }
            "10" -> {
                board[1][0] = txt
            }
            "11" -> {
                board[1][1] = txt
            }
            "12" -> {
                board[1][2] = txt
            }
            "20" -> {
                board[2][0] = txt
            }
            "21" -> {
                board[2][1] = txt
            }
            "22" -> {
                board[2][2] = txt
            }

        }
    }







    private fun stopClick(){
        b1.isClickable = false
        b2.isClickable = false
        b3.isClickable = false
        b4.isClickable = false
        b5.isClickable = false
        b6.isClickable = false
        b7.isClickable = false
        b8.isClickable = false
        b9.isClickable = false
    }

    private fun checkWinner() : String {
        var winner = "null";

        // horizontal
        for (i in 0..2) {
            if (equals3(board[i][0], board[i][1], board[i][2])) {
                winner = board[i][0];
            }
        }

        // Vertical
        for (i in 0..2) {
            if (equals3(board[0][i], board[1][i], board[2][i])) {
                winner = board[0][i];
            }
        }

        // Diagonal
        if (equals3(board[0][0], board[1][1], board[2][2])) {
            winner = board[0][0];
        }
        if (equals3(board[2][0], board[1][1], board[0][2])) {
            winner = board[2][0];
        }

        var openSpots = 0;
        for (i in 0..2) {
            for (j in 0..2) {
                if (board[i][j] == "") {
                    openSpots++;
                }
            }
        }

//        if(winner != "null" && openSpots != 0){
//            colorButtons();
//        }

        return if(winner == "null" && openSpots == 0) {
            "TIE";
        } else {
            winner;
        }
    }

//    private fun colorButtons() {
//        if(board[0][0] == ai && board[0][1]  == ai && board[0][2] == ai){
//            b1.setBackgroundColor(Color.RED)
//            b2.setBackgroundColor(Color.RED)
//            b3.setBackgroundColor(Color.RED)
//        }
//        if(board[1][0] == ai && board[1][1]  == ai && board[1][2] == ai){
//            b4.setBackgroundColor(Color.RED)
//            b5.setBackgroundColor(Color.RED)
//            b6.setBackgroundColor(Color.RED)
//        }
//        if(board[2][0] == ai && board[2][1]  == ai && board[2][2] == ai){
//            b7.setBackgroundColor(Color.RED)
//            b8.setBackgroundColor(Color.RED)
//            b9.setBackgroundColor(Color.RED)
//        }
//        if(board[0][0] == ai && board[1][0]  == ai && board[2][0] == ai){
//            b1.setBackgroundColor(Color.RED)
//            b4.setBackgroundColor(Color.RED)
//            b7.setBackgroundColor(Color.RED)
//        }
//        if(board[0][1] == ai && board[1][1]  == ai && board[2][1] == ai){
//            b2.setBackgroundColor(Color.RED)
//            b5.setBackgroundColor(Color.RED)
//            b8.setBackgroundColor(Color.RED)
//        }
//        if(board[0][2] == ai && board[1][2]  == ai && board[2][2] == ai){
//            b3.setBackgroundColor(Color.RED)
//            b6.setBackgroundColor(Color.RED)
//            b9.setBackgroundColor(Color.RED)
//        }
//        if(board[0][0] == ai && board[1][1]  == ai && board[2][2] == ai){
//            b1.setBackgroundColor(Color.RED)
//            b5.setBackgroundColor(Color.RED)
//            b9.setBackgroundColor(Color.RED)
//        }
//        if(board[2][0] == ai && board[1][1]  == ai && board[0][2] == ai){
//            b3.setBackgroundColor(Color.RED)
//            b5.setBackgroundColor(Color.RED)
//            b7.setBackgroundColor(Color.RED)
//        }
//
//
//
//        if(board[0][0] == human && board[0][1]  == human && board[0][2] == human){
//            b1.setBackgroundColor(Color.RED)
//            b2.setBackgroundColor(Color.RED)
//            b3.setBackgroundColor(Color.RED)
//        }
//        if(board[1][0] == human && board[1][1]  == human && board[1][2] == human){
//            b4.setBackgroundColor(Color.RED)
//            b5.setBackgroundColor(Color.RED)
//            b6.setBackgroundColor(Color.RED)
//        }
//        if(board[2][0] == human && board[2][1]  == human && board[2][2] == human){
//            b7.setBackgroundColor(Color.RED)
//            b8.setBackgroundColor(Color.RED)
//            b9.setBackgroundColor(Color.RED)
//        }
//        if(board[0][0] == human && board[1][0]  == human && board[2][0] == human){
//            b1.setBackgroundColor(Color.RED)
//            b4.setBackgroundColor(Color.RED)
//            b7.setBackgroundColor(Color.RED)
//        }
//        if(board[0][1] == human && board[1][1]  == human && board[2][1] == human){
//            b2.setBackgroundColor(Color.RED)
//            b5.setBackgroundColor(Color.RED)
//            b8.setBackgroundColor(Color.RED)
//        }
//        if(board[0][2] == human && board[1][2]  == human && board[2][2] == human){
//            b3.setBackgroundColor(Color.RED)
//            b6.setBackgroundColor(Color.RED)
//            b9.setBackgroundColor(Color.RED)
//        }
//        if(board[0][0] == human && board[1][1]  == human && board[2][2] == human){
//            b1.setBackgroundColor(Color.RED)
//            b5.setBackgroundColor(Color.RED)
//            b9.setBackgroundColor(Color.RED)
//        }
//        if(board[2][0] == human && board[1][1]  == human && board[0][2] == human){
//            b3.setBackgroundColor(Color.RED)
//            b5.setBackgroundColor(Color.RED)
//            b7.setBackgroundColor(Color.RED)
//        }
//    }


    private fun equals3(a:String, b:String, c:String):Boolean {
        return a == b && b == c && a != ""
    }

    private fun reset(){
        intent
        finish()
        startActivity(intent)
    }


}