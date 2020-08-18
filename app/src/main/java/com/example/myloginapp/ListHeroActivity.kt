package com.example.myloginapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myloginapp.adapter.ListHeroAdapter
import com.example.myloginapp.model.Hero
import kotlinx.android.synthetic.main.activity_hello.*

class ListHeroActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
    }
    
    private val list = ArrayList<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)

        val name = intent.getStringExtra(EXTRA_NAME)

        supportActionBar?.hide()

        list.addAll(getListHeroes())
        rv_heroes.setHasFixedSize(true)
        showRecyclerList()
    }

    private fun getListHeroes(): ArrayList<Hero> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataRole = resources.getStringArray(R.array.data_role)
        val dataPhoto = resources.getIntArray(R.array.data_photo)

        val listHero = ArrayList<Hero>()
        for (position in dataName.indices) {
            val hero = Hero(
                dataName[position],
                dataRole[position],
                dataPhoto[position]
            )
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList() {
        rv_heroes.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListHeroAdapter(list)
        rv_heroes.adapter = listHeroAdapter
    }
}