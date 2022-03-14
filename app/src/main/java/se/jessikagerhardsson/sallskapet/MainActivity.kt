package se.jessikagerhardsson.sallskapet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Simon says
        val game = findViewById<ImageView>(R.id.gameImageView)

        //memory
        val pair = findViewById<ImageView>(R.id.pairImageView)

        //bokstav mot ord
        val match = findViewById<ImageView>(R.id.matchImageView)

        //räkna spindlarna
        val spider = findViewById<ImageView>(R.id.spiderImageView)

        //hur många hundar
        val dog = findViewById<ImageView>(R.id.dogsImageView)

    }
}

