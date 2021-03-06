package com.example.kiosckoutback

import java.io.Serializable

class CartClass(
) :Serializable{

    var cartSteak= mutableListOf<List>()
    var cartPasta= mutableListOf<List>()
    var cartWine= mutableListOf<List>()
    var total=0

//    serializable 안에 클래스가 있으면 그 객체도 serializable을 선언해줘야함
    data class List (
        val name:String,
        var count:String,
        val price:String
        ): Serializable

    fun addCart(type:String,name: String,count:String,price:String){
        if (type=="steak"){
            var cart=List(name, count, price)
            var sequence=0
            for (index in 0 until cartSteak.size) {
                if (cartSteak[index].name==cart.name){
                    cartSteak[index].count = (cartSteak[index].count.toInt()+1).toString()
                    sequence=100
                    break
                }
            }
            if (sequence==0){
                cartSteak.add(cart)
            }
        }
        else if (type=="pasta"){
            var cart = List(name, count, price)
            var sequence=0
            for (index in 0 until cartPasta.size) {
                if (cartPasta[index].name==cart.name){
                    cartPasta[index].count = (cartPasta[index].count.toInt()+1).toString()
                    sequence=100
                    break
                }
            }
            if (sequence==0){
                cartPasta.add(cart)
            }
        }
        else if (type=="wine"){
            var cart = List(name, count, price)
            var sequence=0
            for (index in 0 until cartWine.size) {
                if (cartWine[index].name==cart.name){
                    cartWine[index].count = (cartWine[index].count.toInt()+1).toString()
                    sequence=100
                    break
                }
            }
            if (sequence==0){
                cartWine.add(cart)
            }
        }
    }

    fun totalCal():Int{
        total=0
        for (index in 0 until cartSteak.size){
            total+=cartSteak[index].count.toInt()*cartSteak[index].price.toInt()
        }
        for (index in 0 until cartPasta.size){
            total+=cartPasta[index].count.toInt()*cartPasta[index].price.toInt()
        }
        for (index in 0 until cartWine.size){
            total+=cartWine[index].count.toInt()*cartWine[index].price.toInt()
        }
        return total
    }
}