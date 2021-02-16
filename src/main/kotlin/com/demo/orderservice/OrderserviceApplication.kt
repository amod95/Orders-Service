package com.demo.orderservice

import kotlin.system.exitProcess

fun main(args: Array<String>) {
    // Read in order from command line, then split individual fruit by comma
    println("Please input your order")
    val fruitInputString = readLine() ?: exitProcess(0)
    val fruitArray = fruitInputString.split(",")
	
	val fruitOrder = Fruit(fruitArray)

    val stockpile = Stockpile.isInStock(fruitArray)

    if (stockpile) {
        val orderTotal = fruitOrder.getTotal()
        println("Your order is in stock.")
        println("Your order total is $" + orderTotal)
    } else println("Your order is not in stock.")
}
