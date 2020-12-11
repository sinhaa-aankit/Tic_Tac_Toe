package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.activity_choose_player.*

class ChoosePlayerActivity : AppCompatActivity() {
    lateinit var pvpRelative: RelativeLayout
    lateinit var pvcRelative: RelativeLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_player)

        pvpRelative=findViewById(R.id.pvp)
        pvcRelative=findViewById(R.id.pvc)

        pvp.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, PlayerVsPlayer::class.java)
            startActivity(intent)

        })
        pvc.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, PlayerVsAI::class.java)
            startActivity(intent)
        })
    }
}