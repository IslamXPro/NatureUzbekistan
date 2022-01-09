package com.example.natureuzbekistan

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.example.natureuzbekistan.databinding.ActivityMainBinding
import com.example.natureuzbekistan.databinding.FragmentAddBinding
import com.example.natureuzbekistan.models.User
import com.example.passregistr.Database.DataBase
import com.google.android.material.snackbar.Snackbar
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*


class AddFragment : Fragment() {

    lateinit var binding: FragmentAddBinding
    var img: String = ""
    lateinit var dataBase: DataBase
    lateinit var bundle: Bundle
    lateinit var handler: Handler

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(layoutInflater)
        handler = Handler()
        bundle = Bundle()

        dataBase = context?.let { DataBase.getInstance(it) }!!


        binding.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.adImg.setOnClickListener {
            getImageCount.launch("image/*")
        }

        binding.adAddBtn.setOnClickListener {
            val user = User()
            user.name = binding.adName.text.toString().trim()
            user.name2 = binding.adName2.text.toString().trim()
            user.descr = binding.adDecrp.text.toString().trim()
            user.image = img

            if (user.name != "" && user.name2 != "" && user.descr != "" && user.image != "") {
                dataBase.userDao().addUser(user)
                bundle.putString("userDescr", user.descr)
                binding.adName.text.clear()
                binding.adName2.text.clear()
                binding.adDecrp.text.clear()
                binding.adImg.setImageResource(R.drawable.img_ic)
                Snackbar.make(binding.root, "Saved!", Snackbar.LENGTH_LONG).show()
            }
        }


        return binding.root
    }

    @SuppressLint("SimpleDateFormat")
    private val getImageCount =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri ->
            uri ?: return@registerForActivityResult
            binding.adImg.setImageURI(uri)
            val inputStream = activity?.contentResolver?.openInputStream(uri)
            val simpleDateFormat = SimpleDateFormat("yyyy|MM|dd_HH:mm:ss").format(Date())
            val file = File(activity?.filesDir, "${simpleDateFormat}image.jpg")
            val fileOutputStream = FileOutputStream(file)
            inputStream?.copyTo(fileOutputStream)
            inputStream?.close()
            fileOutputStream.close()
            img = file.absolutePath
        }
}