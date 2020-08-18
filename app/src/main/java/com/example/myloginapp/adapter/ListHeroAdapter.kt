package com.example.myloginapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myloginapp.R
import com.example.myloginapp.model.Hero
import kotlinx.android.synthetic.main.item_row_hero.view.*

class ListHeroAdapter(private val listHero: ArrayList<Hero>): RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListHeroAdapter.ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    override fun onBindViewHolder(holder: ListHeroAdapter.ListViewHolder, position: Int) {
        holder.bind(listHero[position])
    }

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(hero: Hero) {
            with(itemView) {
                Glide.with(itemView.context)
                    .load(hero.photo)
                    .apply(RequestOptions().override(75, 75))
                    .into(img_item_photo)
                tv_name.text = hero.name
                tv_role.text = hero.role
            }
        }
    }

}