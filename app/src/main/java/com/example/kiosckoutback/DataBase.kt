package com.example.kiosckoutback
import android.graphics.Bitmap
import com.google.gson.Gson


object DataBase {
    data class menuList(
        val dataListPasta: ArrayList<menu>,
        val dataListSteak: ArrayList<menu>,
        val dataListWine: ArrayList<menu>,
    )
    data class menu(
        val name: String,
        val price: String,
        val image: String
    )

    lateinit var menuData: menuList

    lateinit var menuPasta:ArrayList<menu>
    lateinit var menuWine:ArrayList<menu>
    lateinit var menuSteak:ArrayList<menu>

    lateinit var pastaImage:MutableList<Bitmap>
    lateinit var wineImage:MutableList<Bitmap>
    lateinit var steakImage:MutableList<Bitmap>


    fun initMenu(jsonString: String) {
        val gson= Gson()
        menuData = gson.fromJson(jsonString, menuList::class.java)
        menuPasta = menuData.dataListPasta
        menuWine = menuData.dataListWine
        menuSteak = menuData.dataListSteak
    }
    fun initImage(imagePasta:MutableList<Bitmap>,imageSteak:MutableList<Bitmap>,imageWine:MutableList<Bitmap>){
        pastaImage =imagePasta
        wineImage =imageWine
        steakImage =imageSteak
    }

}

