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
        var animalsleft = mutableListOf<Animal>()
        var correctPosition = 0

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_dog)



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
            var animal4 = Animal()
            animal1.imagenumber = R.drawable.spider0
            animal1.animalname = "0"
            animals.add(animal4)
            var animal5 = Animal()
            animal2.imagenumber = R.drawable.dog4
            animal2.animalname = "4"
            animals.add(animal5)
            var animal6 = Animal()
            animal3.imagenumber = R.drawable.dog5
            animal3.animalname = "5"
            animals.add(animal6)
            var animal7 = Animal()
            animal1.imagenumber = R.drawable.dog6
            animal1.animalname = "6"
            animals.add(animal7)
            var animal8 = Animal()
            animal2.imagenumber = R.drawable.dog7
            animal2.animalname = "7"
            animals.add(animal8)
            var animal9 = Animal()
            animal3.imagenumber = R.drawable.dog8
            animal3.animalname = "8"
            animals.add(animal9)
            var animal10 = Animal()
            animal1.imagenumber = R.drawable.dog9
            animal1.animalname = "9"
            animals.add(animal10)
            var animal11 = Animal()
            animal2.imagenumber = R.drawable.dog10
            animal2.animalname = "10"
            animals.add(animal10)
            var animal12 = Animal()
            animal3.imagenumber = R.drawable.dog11
            animal3.animalname = "11"
            animals.add(animal11)
            var animal13 = Animal()
            animal1.imagenumber = R.drawable.dog12
            animal1.animalname = "12"
            animals.add(animal12)
            var animal14 = Animal()
            animal2.imagenumber = R.drawable.dog13
            animal2.animalname = "13"
            animals.add(animal13)
            var animal15 = Animal()
            animal3.imagenumber = R.drawable.dog14
            animal3.animalname = "14"
            animals.add(animal14)
            var animal16 = Animal()
            animal1.imagenumber = R.drawable.dog15
            animal1.animalname = "15"
            animals.add(animal15)
            var animal17 = Animal()
            animal2.imagenumber = R.drawable.dog16
            animal2.animalname = "16"
            animals.add(animal16)
            var animal18 = Animal()
            animal3.imagenumber = R.drawable.dog17
            animal3.animalname = "17"
            animals.add(animal17)
            var animal19 = Animal()
            animal1.imagenumber = R.drawable.dog18
            animal1.animalname = "18"
            animals.add(animal19)
            var animal20 = Animal()
            animal2.imagenumber = R.drawable.dog19
            animal2.animalname = "19"
            animals.add(animal20)
            var animal21 = Animal()
            animal2.imagenumber = R.drawable.dog20
            animal2.animalname = "20"
            animals.add(animal21)



            animals.shuffle()

            animalsleft = animals.toList().toMutableList()

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
            animalsleft.removeAt(0)

            if (animalsleft.size == 0)
            {
                //Slut på djur
                Log.i("HEJ", "SLUT")
            } else {
                newword()
            }
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




            correctPosition = (0..2).random()

            var wrongAnimal1 = animals.filterNot { it.animalname == animalsleft[0].animalname } [0]
            var wrongAnimal2 = animals.filterNot { it.animalname == animalsleft[0].animalname }.filterNot {
                it.animalname == wrongAnimal1.animalname } [0]

            if(correctPosition == 0)
            {
                ord1.text = animalsleft[0].animalname
                ord2.text = wrongAnimal1.animalname
                ord3.text = wrongAnimal2.animalname
            }
            if(correctPosition == 1)
            {
                ord1.text = wrongAnimal2.animalname
                ord2.text = animalsleft[0].animalname
                ord3.text = wrongAnimal1.animalname
            }
            if(correctPosition == 2)
            {
                ord1.text = wrongAnimal2.animalname
                ord2.text = wrongAnimal1.animalname
                ord3.text = animalsleft[0].animalname
            }

            bild1.setImageResource(animalsleft[0].imagenumber)
        }

        fun clickWord()
        {

        }

    }