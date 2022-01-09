package com.example.natureuzbekistan.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.natureuzbekistan.Database.MySharedPreference
import com.example.natureuzbekistan.databinding.ItemRvBinding
import com.example.natureuzbekistan.models.User


class RvAdapter(val list: ArrayList<User>, var myClick: MyClick) :
    RecyclerView.Adapter<RvAdapter.Vh>() {


    inner class Vh(var itemRv: ItemRvBinding) : RecyclerView.ViewHolder(itemRv.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(user: User, pos: Int) {
            itemRv.rvPlName.text = user.name
            itemRv.rvPlName2.text = user.name2
            itemRv.rvImg.setImageURI(Uri.parse(user.image))
            itemRv.root.setOnClickListener {
                myClick.click(user)
            }
            /* MySharedPreference.init(context)
             var index = -1
             val mList = MySharedPreference.adibList
             for (n in mList.indices){
                 if (mList[n].id == user.id){
                     index = n
                     break
                 }
             }
             if (index!=-1){
                 itemRv.likeAnim.speed = 1f
                 itemRv.likeAnim.playAnimation()
             }else{
                 itemRv.likeAnim.speed = -1f
                 itemRv.likeAnim.playAnimation()
             }
             itemRv.likeBtn.setOnClickListener {
                 if (index != -1){
                     val l = MySharedPreference.adibList
                     MySharedPreference.adibList = l
                 }else{
                     val l = MySharedPreference.adibList
                     l.add(user)
                     MySharedPreference.adibList = l
                 }
                 if (save == 1){
                     list.remove(user)
                     notifyItemRemoved(position)
                     notifyItemRangeRemoved(position, mList.size)
                 }else{
                     notifyItemChanged(position)
                 }
             }*/
        }
    }

    interface MyClick {
        fun click(user: User)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

}