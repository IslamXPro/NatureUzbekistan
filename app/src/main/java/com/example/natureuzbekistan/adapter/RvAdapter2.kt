package com.example.natureuzbekistan.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.natureuzbekistan.databinding.ItemRvBinding
import com.example.natureuzbekistan.models.User
import com.example.passregistr.Database.DataBase


class RvAdapter2(val list: ArrayList<User>, var myClick: MyClick) :
    RecyclerView.Adapter<RvAdapter2.Vh>() {


    inner class Vh(var itemRv: ItemRvBinding) : RecyclerView.ViewHolder(itemRv.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(user: User, pos: Int) {
            itemRv.rvPlName.text = user.name
            itemRv.rvPlName2.text = user.name2
            itemRv.rvImg.setImageURI(Uri.parse(user.image))
            itemRv.root.setOnClickListener {
                myClick.click(user)
            }
            itemRv.root.setOnLongClickListener {
                myClick.delete(user)
                true
            }
        }
    }

    interface MyClick {
        fun click(user: User)
        fun delete(user: User)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

}