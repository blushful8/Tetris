package com.example.tetris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.tetris.storage.AppReferences

class GameActivity : AppCompatActivity() {

    var tvCurrentScore: TextView? = null
    var tvHighScore: TextView? = null
    var appReferences: AppReferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        appReferences = AppReferences(this)

        tvCurrentScore = findViewById(R.id.tv_current_score)
        tvHighScore = findViewById(R.id.tv_high_score)
        val btnRestart = findViewById<AppCompatButton>(R.id.btn_restart)

        updateHighScore()
        updateCurrentScore()
    }

    private fun updateHighScore() {
        tvHighScore?.text = "${appReferences?.getHighScore()}"
    }

    private fun updateCurrentScore() {
        tvCurrentScore?.text = "0"
    }

}