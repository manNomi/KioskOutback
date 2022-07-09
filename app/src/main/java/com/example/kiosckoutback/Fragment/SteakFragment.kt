package com.example.kiosckoutback.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.kiosckoutback.Activity.DataFromFragment
import com.example.kiosckoutback.DataBase
import com.example.kiosckoutback.R
import com.example.kiosckoutback.dialogClass

class SteakFragment : Fragment() {
    var total=arrayOf(0,0,0)
    lateinit var dataList:ArrayList<DataBase.menu>
    val db= DataBase
    lateinit var newFragment : dialogClass


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragment = inflater.inflate(R.layout.main_page_fragment_steak, container, false)
        dataList=db.menuSteak
        val linearLayout = fragment.findViewById<LinearLayout>(R.id.steakLinear)
        for (index in 0 until dataList.size) {
            val customLinear = layoutInflater.inflate(R.layout.custom_cart_btn, linearLayout, false)
            customLinear.findViewById<TextView>(R.id.foodText).text = dataList[index].name
            val image =customLinear.findViewById<ImageView>(R.id.foodImage)
            Glide.with(fragment)
                .load(db.steakImage[index])
                .into(image)
            customLinear.findViewById<LinearLayout>(R.id.steakBtnLinear).setOnClickListener{initEvent(index)}
            linearLayout.addView(customLinear)
        }
        return fragment
    }
    fun initEvent( number: Int){
        showDialog()
        if (newFragment.isCancelable){
            insertEvent(number)
        }
    }

    fun insertEvent(number: Int)
    {
        total[number]+=1
        val text=dataList[number].name+" 추가되었습니다"
        Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
        val dataInterface = context as DataFromFragment
        dataInterface.sendData("pasta",dataList[number].name,total[number].toString(),dataList[number].price)
    }


    fun showDialog() {
        newFragment= dialogClass()
        val fragmentManager=requireActivity().supportFragmentManager
        newFragment.show(fragmentManager, "dialog")
    }

}