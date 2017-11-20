package com.tictactoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var activePlayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var winner = 0
    var checked = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        table.setBackgroundResource(R.color.white)
        bt_restart.setBackgroundResource(R.color.green)

        bt_1.setOnClickListener { game(it,1) }
        bt_2.setOnClickListener { game(it,2) }
        bt_3.setOnClickListener { game(it,3) }
        bt_4.setOnClickListener { game(it,4) }
        bt_5.setOnClickListener { game(it,5) }
        bt_6.setOnClickListener { game(it,6) }
        bt_7.setOnClickListener { game(it,7) }
        bt_8.setOnClickListener { game(it,8) }
        bt_9.setOnClickListener { game(it,9) }

        bt_restart.setOnClickListener { recreate() }
    }

    private fun game(v:View, id:Int){

        var selectBt = v as Button

        if(activePlayer == 1){
            selectBt.setBackgroundResource(R.color.colorPrimary)
            selectBt.setText("X")
            player1.add(id)
            checkWinner()
            if(winner == 0) {
                activePlayer = 2
                autoPlay()
            }else{
                return
            }

        }else{
            selectBt.setBackgroundResource(R.color.red)
            selectBt.setText("O")
            player2.add(id)
            checkWinner()
            if(winner == 0) {
                activePlayer = 1
            }else{
                return
            }

        }
        v.isEnabled = false
    }

    private fun checkWinner(){

        checked++

        if(winner == 0) {
            if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
                winner = 1
            }
            if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
                winner = 1
            }
            if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
                winner = 1
            }

            if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
                winner = 1
            }
            if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
                winner = 1
            }
            if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
                winner = 1
            }

            if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
                winner = 1
            }
            if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
                winner = 1
            }
        }
        if(winner == 0) {
            if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
                winner = 2
            }
            if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
                winner = 2
            }
            if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
                winner = 2
            }

            if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
                winner = 2
            }
            if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
                winner = 2
            }
            if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
                winner = 2
            }

            if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
                winner = 2
            }
            if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
                winner = 2
            }
        }

        if(winner != 0){
            Toast.makeText(this, "The Winner is Player $winner", Toast.LENGTH_SHORT).show()
            disableAll()
        }

    }

    fun autoPlay(){

        var emptyCells = ArrayList<Int>()

        if(checked == 9){
            Toast.makeText(this, "Drawn Game", Toast.LENGTH_SHORT).show()
            return
        }

        for(i in 1..9){
            if(!(player1.contains(i) || player2.contains(i))){
                emptyCells.add(i)
            }
        }

        var r = Random()
        val rIndex = r.nextInt( emptyCells.size-0 )-0

        val id = emptyCells[rIndex]

        var btSelect:Button? = null
        when(id){
            1 -> btSelect = findViewById<Button>(R.id.bt_1)
            2 -> btSelect = findViewById<Button>(R.id.bt_2)
            3 -> btSelect = findViewById<Button>(R.id.bt_3)
            4 -> btSelect = findViewById<Button>(R.id.bt_4)
            5 -> btSelect = findViewById<Button>(R.id.bt_5)
            6 -> btSelect = findViewById<Button>(R.id.bt_6)
            7 -> btSelect = findViewById<Button>(R.id.bt_7)
            8 -> btSelect = findViewById<Button>(R.id.bt_8)
            9 -> btSelect = findViewById<Button>(R.id.bt_9)
        }
        game(btSelect!!,id)
    }

    private fun disableAll(){
        bt_1.isEnabled = false
        bt_2.isEnabled = false
        bt_3.isEnabled = false
        bt_4.isEnabled = false
        bt_5.isEnabled = false
        bt_6.isEnabled = false
        bt_7.isEnabled = false
        bt_8.isEnabled = false
        bt_9.isEnabled = false
    }
}

