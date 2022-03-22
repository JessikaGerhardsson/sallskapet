package se.jessikagerhardsson.sallskapet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class SimonsaysActivity : AppCompatActivity() {
    var correctSeq = mutableListOf<Int>()
    var playerSeq = mutableListOf<Int>()
    var hej = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simonsays)

        //Fetch buttons and textviews
        //val title = findViewById<TextView>(R.id.titleText)
        val scoreText = findViewById<TextView>(R.id.scoreText)
        val green = findViewById<Button>(R.id.greenBtn)
        val yellow = findViewById<Button>(R.id.yellowBtn)
        val blue = findViewById<Button>(R.id.blueBtn)
        val red = findViewById<Button>(R.id.redBtn)
        val restart = findViewById<Button>(R.id.restartBtn)
        //val activitiesArray: Array<Class<out AppCompatActivity>> = arrayOf(Green::class.java, Yellow::class.java, Blue::class.java, Red::class.java)


        //Get count, index and color from intent
        //var score = intent.getIntExtra("score", -2)
        //var count = intent.getIntExtra("count", -3)
        //val colors: ArrayList<String> = intent.getStringArrayListExtra("colors")!!

        //Update displayed score
        scoreText.text = hej.toString()
        //scoreText.text = "HEJ"
        //Log.i("HEJ", "scoretext = $hej")



        correctSeq.add((0..3).random())

        doHighlight(0)

        //on click listeners for each button

        green.setOnClickListener {

            //onCorrect("Green",0)

            playerSeq.add(0)
            checkCorrect()
        }

        yellow.setOnClickListener {

            //onCorrect("Yellow", 1)
            playerSeq.add(1)
            checkCorrect()
        }

        blue.setOnClickListener {
            //onCorrect("Blue", 2)
            playerSeq.add(2)
            checkCorrect()
        }

        red.setOnClickListener {
            //onCorrect("Red", 3)
            playerSeq.add(3)
            checkCorrect()
        }
        restart.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }



    }

    fun checkCorrect()
    {
        Log.i("PIAXDEBUG", "*************")
        Log.i("PIAXDEBUG", correctSeq.toString())
        Log.i("PIAXDEBUG", playerSeq.toString())
        var allcorrect = true
        playerSeq.forEachIndexed { index, i ->
            if(playerSeq[index] != correctSeq[index])
            {
                allcorrect = false
            }
        }

        if(allcorrect == true)
        {

            if(playerSeq.size == correctSeq.size)
            {
                playerSeq.clear()
                Toast.makeText(this, "Correct", Toast.LENGTH_LONG).show()

                var random: Int = (0..3).random()

                correctSeq.add(random)
                doHighlight(0)
                hej ++
                Log.i("HEJ", hej.toString())

            }

        } else {
            // VISA FÖRLORA
            Toast.makeText(this, "YOU LOSE", Toast.LENGTH_LONG).show()
        }

    }

    fun doHighlight(animnumber : Int)
    {
        if(animnumber == correctSeq.size)
        {
            // Visa text "din tur"
            // playerturn = true
            return
        }

        val green = findViewById<Button>(R.id.greenBtn)
        val yellow = findViewById<Button>(R.id.yellowBtn)
        val blue = findViewById<Button>(R.id.redBtn)
        val red = findViewById<Button>(R.id.redBtn)

        var animButton : Button? = null

        if(correctSeq[animnumber] == 0)
        {
            animButton = findViewById<Button>(R.id.greenBtn)
        }
        if(correctSeq[animnumber] == 1)
        {
            animButton = findViewById<Button>(R.id.yellowBtn)
        }
        if(correctSeq[animnumber] == 2)
        {
            animButton = findViewById<Button>(R.id.redBtn)
        }
        if(correctSeq[animnumber] == 3)
        {
            animButton = findViewById<Button>(R.id.redBtn)
        }


        animButton!!.animate().apply {
            alpha(0f)
            duration = 2000
        }.withEndAction {
            animButton!!.animate().apply {
                alpha(1f)
                duration = 2000
            }.withEndAction {
                doHighlight(animnumber +1)
            }.start()
        }.start()


    }


    }
