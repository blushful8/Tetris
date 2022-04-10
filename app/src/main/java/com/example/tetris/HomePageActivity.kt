package com.example.tetris

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.tetris.storage.AppReferences
import com.google.android.material.snackbar.Snackbar

private var exit: AppCompatButton? = null
private var reset: AppCompatButton? = null
private var newGame: AppCompatButton? = null

@SuppressLint("StaticFieldLeak")
lateinit var highScore: TextView
var appReferences: AppReferences? = null

class HomePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        supportActionBar?.hide()
        init()

        highScore.text = "High score: 0"

        newGame?.setOnClickListener(this::onBtnGameClick)
        exit?.setOnClickListener(this::onBtnExitClick)
        reset?.setOnClickListener(this::onBtnResetClick)
    }

    private fun onBtnResetClick(view: View) {
        val prefenrences = AppReferences(this)
        Snackbar.make(view, "Score successfuly reset", Snackbar.LENGTH_SHORT).show()
        highScore.text = "High score: ${prefenrences.clearHighScore()}"
        highScore.text = "High score: 0"
    }

    private fun onBtnExitClick(view: View) {
        System.exit(0)
    }

    override fun onStart() {
        super.onStart()
        highScore.text = "High score: ${appReferences?.getHighScore()}"
    }

    override fun onRestart() {
        super.onRestart()
        highScore.text = "High score: ${appReferences?.getHighScore()}"
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
        appReferences = AppReferences(this)
    }
}