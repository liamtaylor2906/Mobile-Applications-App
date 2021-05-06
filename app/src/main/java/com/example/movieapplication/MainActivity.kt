package com.example.movieapplication

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val topicList : MutableList<String> = mutableListOf(
        "TV SHOW: Lucifer (Supernateral, Comedy)",
        "TV SHOW: The Boys (Dark Comedy)",
        "TV SHOW: After Life (Drama)",
        "TV SHOW: You (Drama, Psychological Thriller)",
        "TV SHOW: The Witcher (Fantasy)",
        "TV SHOW: The Office (Comedy)",
        "TV SHOW: Brooklyn Nine Nine (Comedy)",
        "TV SHOW: Breaking Bad (Drama, Crime)",
        "TV SHOW: Community (Comedy)",
        "TV SHOW: Schitt's Creek (Comedy)",
        "MOVIE: The Wolf of Wall Street (Crime)",
        "MOVIE: We're The Millers (Comedy)",
        "MOVIE: Deadpool (Action, Comedy ",
        "MOVIE: Inception (Science Fiction)",
        "MOVIE: Step Brothers (Comedy)",
        "MOVIE: Castaway (Drama, Adventure)",
        "MOVIE: Zodiac (Thriller, Horror, Crime)",
        "MOVIE: Shrek (Animation, Comedy, Fantasy)",
        "MOVIE: Limitless (Action, Science Fiction)",
        "MOVIE: Instant Family (Drama, Comedy)",
        "MOVIE: Scarface (Mafia, Action, Crime)",
        "MOVIE: The Other Guys (Action, Comedy)",
        "TV SHOW: Sons of Anarchy (Action, Drama)",
        "TV SHOW: The Big Bang Theory (Comedy)",
        "TV SHOW: The Last Kingdom",
        "TV SHOW: Arrested Development (Comedy)",
        "MOVIE: Superbad (Comedy)",
        "TV SHOW: Prison Break (Action, Drama)",
        "TV SHOW: Stranger Things (Supernatural)",
        "TV SHOW: Beyond (Science Fiction)",
        "TV SHOW: Vikings (War, Historical film)",
        "TV SHOW: The Flash (Action, Superhero)",
        "MOVIE: Joker (Psychological Thriller)",
        "MOVIE: Tag (Comedy)",
        "TV SHOW: Peaky Blinders (Drama, Crime)",
        "TV SHOW: Rick and Morty (Animated, Comedy)",
        "TV SHOW: Bad Education (Comedy)",
        "TV SHOW: Better Call Saul (Drama, Comedy)",
        "MOVIE: Overlord (Horror, Thriller, Action)",
        "TV SHOW: American Horror Story (Horror, Thriller)",
        "TV SHOW: Final Space (Animated, Comedy)",
        "TV SHOW: Living With Yourself (Drama, Comedy)",
        "MOVIE: Spider-Man Into The Spider-Verse (Animated)",
        "MOVIE: Marriage Story (Drama)",
        "TV SHOW: Happy (Dark comedy, Drama, Crime film)",
        "TV SHOW: The Umbrella Academy (Action, Drama)",
        "TV SHOW: Daredevil (Action, Drama)"


    )

    private var watchlistArray : Array<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var b = intent.extras
        if (b != null) {
            watchlistArray = b.getStringArray("watchlist")
        }

        generateTopic()

        btnAddWatchlist.setOnClickListener {
            addToWatchlist()
            btnAddWatchlist.text = "Added!"
        }

        watchlist.setOnClickListener {
            val intent = Intent(this, Watchlist::class.java)
            var b = Bundle()
            b.putStringArray("watchlist", watchlistArray)
            intent.putExtras(b)
            startActivity(intent)
        }
    }
    private fun generateTopic() {
        btnGenerate.setOnClickListener {
            btnAddWatchlist.text = "Add to watch list!"
            val random = (0 until(topicList.size)).random()
            btnGenerate.text = topicList[random]
            btnAddWatchlist.isEnabled = true
        }

    }

    private fun addToWatchlist() {
        if (watchlistArray != null) {
            for (i in 0 until watchlistArray!!.size) {
                if (watchlistArray!![i] == btnGenerate.text.toString()) {
                    return
                }
            }
            var tempList = watchlistArray!!.toMutableList()
            tempList.add(btnGenerate.text.toString())
            watchlistArray = tempList.toTypedArray()
        } else {
            watchlistArray = arrayOf(btnGenerate.text.toString())
        }

    }
}