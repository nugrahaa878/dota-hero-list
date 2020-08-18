package com.example.myloginapp

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myloginapp.adapter.ListHeroAdapter
import com.example.myloginapp.model.Hero
import kotlinx.android.synthetic.main.activity_hello.*

class ListHeroActivity : AppCompatActivity() {

    private lateinit var dataName: Array<String>
    private lateinit var dataRole: Array<String>
    private lateinit var dataPhoto:TypedArray

    private var listHero = ArrayList<Hero>()

    companion object {
        const val EXTRA_NAME = "extra_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)

        supportActionBar?.title = "Dota 2 Hero"

        prepare()
        addItem()
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rv_heroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter =ListHeroAdapter(listHero)
        rv_heroes.adapter = listHeroAdapter
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val hero = Hero(
                dataName[position],
                dataRole[position],
                dataPhoto.getResourceId(position, -1)
            )
            listHero.add(hero)
        }
    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.data_name)
        dataRole = resources.getStringArray(R.array.data_role)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
    }


}