package com.demo.orderservice

import kotlin.system.exitProcess

fun main(args: Array<String>) {
    // Read in order from command line, then split individual fruit by comma
    println("Please input your order")
    val fruitInputString = readLine() ?: exitProcess(0)
    val fruitArray = fruitInputString.split(",")

    val fruitOrder = Fruit(fruitArray)
    //If in stock, output order total
        // Create fruit object
        val orderTotal = fruitOrder.getTotal()
        println("Your order total is $" + orderTotal)   
}
