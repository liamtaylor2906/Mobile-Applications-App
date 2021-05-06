package com.example.movieapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_watchlist.*

class Watchlist : AppCompatActivity() {

    private var watchlistArray : Array<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_watchlist)

        home.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            var b = Bundle()
            b.putStringArray("watchlist", watchlistArray)
            intent.putExtras(b)
            startActivity(intent)
        }

        var b = intent.extras
        if (b != null) {
            watchlistArray = b.getStringArray("watchlist")
            if (watchlistArray != null) {
                var watchlistString: String = ""
                for (i in 0 until watchlistArray!!.size) {
                    watchlistString += watchlistArray!![i] + "\n"
                }
                watchlistText.text = watchlistString
            }
        }
    }
}