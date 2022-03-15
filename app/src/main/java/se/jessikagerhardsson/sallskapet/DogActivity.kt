package se.jessikagerhardsson.sallskapet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class Animal {
    var imagenumber = 0
    var animalname = ""
}

class DogActivity : AppCompatActivity() {


        var animals = mutableListOf<Animal>()
        var correctPosition = 0

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_dog)

            //val images = mutableListOf<Int>(R.drawable.hund1, R.drawable.gris, R.drawable.star)
            //val ord = mutableListOf<String>("hund", "Gris", "Stjärna")

            var animal1 = Animal()
            animal1.imagenumber = R.drawable.dog1
            animal1.animalname = "1"
            animals.add(animal1)
            var animal2 = Animal()
            animal2.imagenumber = R.drawable.dog2
            animal2.animalname = "2"
            animals.add(animal2)
            var animal3 = Animal()
            animal3.imagenumber = R.drawable.dog3
            animal3.animalname = "3"
            animals.add(animal3)

            //var correctanswer = mutableListOf<Int>()
            //correctanswer.add((0..2).random())

            var bild1 = findViewById<ImageView>(R.id.bild)
            var ord1 = findViewById<TextView>(R.id.ord1)
            var ord2 = findViewById<TextView>(R.id.ord2)
            var ord3 = findViewById<TextView>(R.id.ord3)

            newword()

            ord1.setOnClickListener {
                if(correctPosition == 0)
                {
                    // HURRA RÄTT
                    correctword()
                } else {
                    // BU FEL
                    wrongword()
                }
            }
            ord2.setOnClickListener {
                if(correctPosition == 1)
                {
                    // HURRA RÄTT
                    correctword()
                } else {
                    // BU FEL
                    wrongword()
                }
            }
            ord3.setOnClickListener {
                if(correctPosition == 2)
                {
                    // HURRA RÄTT
                    correctword()
                } else {
                    // BU FEL
                    wrongword()
                }
            }
        }

        fun correctword()
        {
            Log.i("PIXDEBUG", "RÄTT")
            newword()
        }

        fun wrongword()
        {
            Log.i("PIXDEBUG", "FEL")

        }

        fun newword()
        {
            var bild1 = findViewById<ImageView>(R.id.bild)
            var ord1 = findViewById<TextView>(R.id.ord1)
            var ord2 = findViewById<TextView>(R.id.ord2)
            var ord3 = findViewById<TextView>(R.id.ord3)


            animals.shuffle()

            correctPosition = (0..2).random()
            if(correctPosition == 0)
            {
                ord1.text = animals[0].animalname
                ord2.text = animals[1].animalname
                ord3.text = animals[2].animalname
            }
            if(correctPosition == 1)
            {
                ord1.text = animals[1].animalname
                ord2.text = animals[0].animalname
                ord3.text = animals[2].animalname
            }
            if(correctPosition == 2)
            {
                ord1.text = animals[2].animalname
                ord2.text = animals[1].animalname
                ord3.text = animals[0].animalname
            }

            bild1.setImageResource(animals[0].imagenumber)
        }

        fun clickWord()
        {

        }

    }