package com.example.natureuzbekistan

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.natureuzbekistan.adapter.RvAdapter
import com.example.natureuzbekistan.databinding.FragmentHomeBinding
import com.example.natureuzbekistan.models.User
import com.example.passregistr.Database.DataBase
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.*
import java.util.*
import kotlin.collections.ArrayList
import android.app.Activity
import android.content.res.Configuration
import android.content.res.Resources
import android.media.Image
import android.os.Build
import android.widget.ImageView
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
import androidx.navigation.findNavController
import com.google.zxing.WriterException


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var rvAdapter: RvAdapter
    lateinit var bundle: Bundle
    lateinit var dataBase: DataBase
    lateinit var locale: Locale
    var isChecked = false

    //image for QRCode from View
    lateinit var img: ImageView

    @SuppressLint("ObsoleteSdkInt")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater)
        bundle = Bundle()

        /* val config = resources.configuration
         val lang = "ru" // your language code
         val locale = Locale(lang)
         Locale.setDefault(locale)
         if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
             config.setLocale(locale)
         else
             config.locale = locale*/

        binding.apply {
            searchBtn.setOnClickListener {
                findNavController().navigate(R.id.searchFragment)
                searchIc.setImageResource(R.drawable.search_ic_bl)
                homeIc.setImageResource(R.drawable.home_ic)
                addIc.setImageResource(R.drawable.add_ic_home)
                favouriteIc.setImageResource(R.drawable.favourite_ic)
                accountIc.setImageResource(R.drawable.account_ic)
            }
            addBtn.setOnClickListener {
                findNavController().navigate(R.id.addFragment)
                addIc.setImageResource(R.drawable.add_ic_bl)
                homeIc.setImageResource(R.drawable.home_ic)
                searchIc.setImageResource(R.drawable.search_ic)
                favouriteIc.setImageResource(R.drawable.favourite_ic)
                accountIc.setImageResource(R.drawable.account_ic)
            }
            favouriteBtn.setOnClickListener {
                findNavController().navigate(R.id.favouriteFragment)
                favouriteIc.setImageResource(R.drawable.favourite_ic_bl)
                homeIc.setImageResource(R.drawable.home_ic)
                searchIc.setImageResource(R.drawable.search_ic)
                addIc.setImageResource(R.drawable.add_ic_home)
                accountIc.setImageResource(R.drawable.account_ic)
            }
            accountBtn.setOnClickListener {
                findNavController().navigate(R.id.accountFragment)
                accountIc.setImageResource(R.drawable.account_ic_bl)
                homeIc.setImageResource(R.drawable.home_ic)
                searchIc.setImageResource(R.drawable.search_ic)
                addIc.setImageResource(R.drawable.add_ic_home)
                favouriteIc.setImageResource(R.drawable.favourite_ic)
            }
        }
        onResume()
/*        binding.navItem.setNavigationItemSelectedListener(this)*/
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        dataBase = context?.let { DataBase.getInstance(it) }!!
        val list = ArrayList<User>()
        list.addAll(dataBase.userDao().getAllUser())
        rvAdapter = RvAdapter(list, object : RvAdapter.MyClick {
            override fun click(user: User) {
                findNavController().navigate(
                    R.id.infoFragment, bundleOf(
                        "users" to user
                    )
                )
            }
        })
        binding.recycle.adapter = rvAdapter
    }


    //for change app language
    fun setLocale(lang: String) {
        locale = Locale(lang)
        val res = resources
        val dm = res.displayMetrics
        val conf = res.configuration
        res.updateConfiguration(conf, dm)

        val refresh = Intent(context, HomeFragment::class.java)
        startActivity(refresh)

    }

    //for change app language
    fun settLocale(activity: HomeFragment, languageCode: String?) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val resources: Resources = activity.resources
        val config: Configuration = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)




        //start QRCode for unique id or for sharing link location from QRCode to Google Maps(app)
        fun qrCode(text: String) {
            val qrGenerator = QRGEncoder(text, null, QRGContents.Type.TEXT, 400)
            try {
                val bMap = qrGenerator.encodeAsBitmap()
                img?.setImageBitmap(bMap)
            } catch (e: WriterException) {

            }
        }
    }

/*    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item){

        }
        return true
    }*/
}