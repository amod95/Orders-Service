package com.demo.orderservice

//Fruit object, with static fruit prices. Users can't edit fruit prices.
class Fruit {
    private var fruitPrices: Map<String, Double> = mapOf("Apple" to .60, "Orange" to .25)
    private var fruitOrder = mutableMapOf<String, Int>()

    //Constructor creates internal fruit map
    constructor(Order: List<String>) {
        //Initializes fruit value to 0
        fruitOrder.set("Apple", 0)
        fruitOrder.set("Orange", 0)
        //Checks to see if each fruit is available in stockpile. If so, add it to the fruit Map. Else, let user know fruit isn't in stock
        for (fruit in Order) {
        if(Stockpile.isInStock(fruit.toLowerCase().capitalize()))
        {
            addFruitToMap(fruit.toLowerCase().capitalize())
        }
        else
            println(fruit.toLowerCase().capitalize()+"'s are not in stock.")
    }
    }

    //Add fruit to map if in stock
    fun addFruitToMap(fruit: String) {
        when (fruit) {
                "Apple" -> fruitOrder[fruit] = fruitOrder.getOrDefault(fruit, 0) + 1
                "Orange" -> fruitOrder[fruit] = fruitOrder.getOrDefault(fruit, 0) + 1
            }
    }

    fun getNumberofApples(): Int {
        return fruitOrder.get("Apple")!!
    }

    fun getNumberofOranges(): Int {
        return fruitOrder.get("Orange")!!
    }

    fun getPriceofApple(): Double {
        return fruitPrices.get("Apple")!!
    }

    fun getPriceofOrange(): Double {
        return fruitPrices.get("Orange")!!
    }

    //Calculating total fruit price with deal
    public fun getTotal(): Double {
        var numberOfApples: Int = getNumberofApples()
        var numberOfOranges: Int = getNumberofOranges()
        var priceOfOrange: Double = getPriceofOrange()
        var priceOfApple: Double = getPriceofApple()

        return (priceOfApple *
                (((numberOfApples - (numberOfApples % 2)) / 2) + (numberOfApples % 2))) +
                (priceOfOrange *
                        (((2 * (numberOfOranges - (numberOfOranges % 3))) / 3) +
                                (numberOfOranges % 3)))
    }
}
