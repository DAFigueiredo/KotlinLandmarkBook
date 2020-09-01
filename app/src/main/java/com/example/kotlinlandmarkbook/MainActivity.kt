package com.example.kotlinlandmarkbook

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var landmarkNames = ArrayList<String>()
        landmarkNames.add("Guimarães")
        landmarkNames.add("Óbidos")
        landmarkNames.add("Batalha")
        landmarkNames.add("Alcobaça")
        landmarkNames.add("Jerónimos")
        landmarkNames.add("Pena")
        landmarkNames.add("Belém")

        val guimaraes =
            BitmapFactory.decodeResource(applicationContext.resources, R.drawable.guimaraes)
        val obidos = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.obidos)
        val batalha = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.batalha)
        val alcobaca =
            BitmapFactory.decodeResource(applicationContext.resources, R.drawable.alcobaca)
        val jeronimos =
            BitmapFactory.decodeResource(applicationContext.resources, R.drawable.jeronimos)
        val pena = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.pena)
        val belem = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.belem)

        val landmarkImages = ArrayList<Bitmap>()

        landmarkImages.add(guimaraes)
        landmarkImages.add(obidos)
        landmarkImages.add(batalha)
        landmarkImages.add(alcobaca)
        landmarkImages.add(jeronimos)
        landmarkImages.add(pena)
        landmarkImages.add(belem)


        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, landmarkNames)

        listView.adapter = arrayAdapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->

            val intent = Intent(applicationContext, DetailActivity::class.java)
            intent.putExtra("name", landmarkNames[i])

            val bitmap = landmarkImages[i]

            val chosen = Globals.Chosen
            chosen.chosenImage = bitmap


            startActivity(intent)


        }


    }
}