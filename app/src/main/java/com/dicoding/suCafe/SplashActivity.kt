package com.dicoding.sucafe

import android.content.Intent
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class SplashScreenActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_splash)

                val iv_note = findViewById<LinearLayout>(R.id.imageView)
                iv_note.alpha = 0f
                iv_note.animate().setDuration(1500).alpha(1f).withEndAction {
                        val i = Intent(this, MainActivity::class.java)
                        startActivity(i)
                        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
                        finish()
                }

        }

}