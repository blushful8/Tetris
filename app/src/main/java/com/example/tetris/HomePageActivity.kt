package com.example.tetris

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton

private var exit: AppCompatButton? = null
private var reset: AppCompatButton? = null
private var newGame: AppCompatButton? = null

@SuppressLint("StaticFieldLeak")
lateinit var highScore: TextView

class HomePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        supportActionBar?.hide()
        init()

        newGame?.setOnClickListener(this::onBtnGameClick)
        exit?.setOnClickListener(this::onBtnExitClick)
        reset?.setOnClickListener(this::onBtnResetClick)
    }

    private fun onBtnResetClick(view: View) {

    }

    private fun onBtnExitClick(view: View) {
        System.exit(0)
    }

    private fun onBtnGameClick(view: View) {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }

    fun init() {
        exit = findViewById(R.id.btn_exit)
        newGame = findViewById(R.id.btn_new_game)
        reset = findViewById(R.id.btn_res_score)
        highScore = findViewById(R.id.tv_high_score)
    }
}