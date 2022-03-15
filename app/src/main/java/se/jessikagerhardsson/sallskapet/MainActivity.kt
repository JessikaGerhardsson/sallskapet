package se.jessikagerhardsson.sallskapet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView

//TODO Bilderna på startskärmen syns inte

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Simon says
        val game = findViewById<ImageView>(R.id.gameImageView)
        game.setOnClickListener {
            val intent = Intent(this, SimonsaysActivity::class.java)
            startActivity(intent)
            Log.i("HEJ", "simon says")
        }

        //Hittaparen
        val pair = findViewById<ImageView>(R.id.pairImageView)
        pair.setOnClickListener {
            val intent = Intent(this, HittaparenActivity::class.java)
            intent.putExtra("knapp", 1)
            startActivity(intent)
            Log.i("HEJ", "hitta paren")
        }

        //bokstav mot ord
        val match = findViewById<ImageView>(R.id.matchImageView)
        match.setOnClickListener {
            val intent = Intent(this, HittaparenActivity::class.java)
            intent.putExtra("knapp", 2)
            startActivity(intent)
            Log.i("HEJ", "bokstav mot djur")
        }

        //räkna spindlarna
        val spider = findViewById<ImageView>(R.id.spiderImageView)
        spider.setOnClickListener {
            val intent = Intent(this, HittaparenActivity::class.java)
            intent.putExtra("knapp", 3)
            startActivity(intent)
            Log.i("HEJ", "spindlar")
        }

        //hur många hundar
        val dog = findViewById<ImageView>(R.id.dogsImageView)
        dog.setOnClickListener {
            val intent = Intent(this, DogActivity::class.java)
            startActivity(intent)
            Log.i("HEJ", "hundar")
        }

    }
}

