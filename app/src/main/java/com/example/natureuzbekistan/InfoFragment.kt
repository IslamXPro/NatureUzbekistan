package com.example.natureuzbekistan

import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.natureuzbekistan.Database.MySharedPreference
import com.example.natureuzbekistan.adapter.RvAdapter
import com.example.natureuzbekistan.databinding.FragmentInfoBinding
import com.example.natureuzbekistan.models.User
import com.example.passregistr.Database.DataBase


class InfoFragment : Fragment() {

    lateinit var binding: FragmentInfoBinding
    lateinit var dataBase: DataBase
    lateinit var rvAdapter: RvAdapter
    lateinit var handler: Handler
    var index = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInfoBinding.inflate(layoutInflater)

        dataBase = DataBase.getInstance(binding.root.context)

        binding.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }
        /* binding.likeBtn.setOnClickListener {
             val user = arguments?.getSerializable("users") as User
             DataBase.getInstance(binding.root.context).userDao().updateUser(user)
             onResume()
         }*/
        return binding.root
    }

    override fun onResume() {
        super.onResume()
/*
        MySharedPreference.init(binding.root.context)*/

        val user = arguments?.getSerializable("users") as User
        binding.deleteBtn.setOnClickListener {
            dataBase.userDao().deleteUser(user)
            findNavController().navigate(R.id.homeFragment)
        }
        /*  if (index != -1) {
              binding.likeAnim.speed = -1f
              binding.likeAnim.playAnimation()
              val list2 = MySharedPreference.adibList
              list2.removeAt(index)
              MySharedPreference.adibList = list2
              onResume()
              //LoveListga qo'shilishi
          } else {
              binding.likeAnim.speed = 1.5f
              binding.likeAnim.playAnimation()
              val list2 = MySharedPreference.adibList
              list2.add(user)
              MySharedPreference.adibList = list2
              onResume()
          }*/

/*        binding.likeBtn.setOnClickListener {
            if (index == -1) {
                binding.likeAnim.setImageResource(R.drawable.like_ic_red)
                dataBase.userDao().addUserLike(user)
                Toast.makeText(context, "Add favourite", Toast.LENGTH_SHORT).show()
            }else{
                binding.likeAnim.setImageResource(R.drawable.like_ic)
                dataBase.userDao().deleteUserLike(user)
            }
        }*/


        Log.d("Kamyob", "onResume: ${user.toString()}")

        binding.infoName.text = user.name
        binding.infoName2.text = user.name2
        binding.infoDescr.text = user.descr
        binding.infoImg.setImageURI(Uri.parse(user.image))
    }
}