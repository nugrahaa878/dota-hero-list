package com.example.myloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val username = "nugrahaa"
    private val password = "admin123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        btn_login.setOnClickListener {
            if ((edt_password.text.toString() == password) && (edt_username.text.toString() == username)) {
                val mIntent = Intent(this@MainActivity, ListHeroActivity::class.java)
                mIntent.putExtra(ListHeroActivity.EXTRA_NAME, username)
                startActivity(mIntent)
            } else {
                tv_error.visibility = View.VISIBLE
            }
        }
    }
}