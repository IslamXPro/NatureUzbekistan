package com.example.natureuzbekistan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.natureuzbekistan.Database.MySharedPreference
import com.example.natureuzbekistan.adapter.RvAdapter
import com.example.natureuzbekistan.adapter.RvAdapter2
import com.example.natureuzbekistan.databinding.FragmentFavouriteBinding
import com.example.natureuzbekistan.models.User
import com.example.passregistr.Database.DataBase

class FavouriteFragment : Fragment() {

    lateinit var binding: FragmentFavouriteBinding
/*    lateinit var dataBase: DataBase*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavouriteBinding.inflate(layoutInflater)
/*        dataBase = DataBase.getInstance(binding.root.context)*/
/*        val list = MySharedPreference.adibList*/
        /* val list = ArrayList<User>()
         list.addAll(dataBase.userDao().getAllUserLike())
         binding.recycle.adapter = RvAdapter2(list, object : RvAdapter2.MyClick {
             override fun click(user: User) {
                 findNavController().navigate(R.id.infoFragment, bundleOf("users" to user))
             }

             override fun delete(user: User) {
                 dataBase.userDao().deleteUserLike(user)
             }
         })*/

        binding.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }

    /*override fun onResume() {
        super.onResume()
        val dataBase = DataBase.getInstance(binding.root.context)
        val list = ArrayList<User>()
        list.addAll(listOf(dataBase.userDao().getUserByIdLike(true)))
        val rvAdapter = RvAdapter2(list, object : RvAdapter2.MyClick {
            override fun click(user: User) {
                findNavController().navigate(
                    R.id.infoFragment, bundleOf(
                        "users" to user
                    )
                )
            }

            override fun delete(user: User) {
                dataBase.userDao().deleteUserLike(user)
            }
        })
        binding.recycle.adapter = rvAdapter
    }*/
}