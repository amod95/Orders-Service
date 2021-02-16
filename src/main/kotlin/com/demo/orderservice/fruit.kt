package com.demo.orderservice

class Fruit {
    private var fruitPrices: Map<String, Double> = mapOf("Apple" to .60, "Orange" to .25)
    private var fruitOrder = mutableMapOf<String, Int>()

    constructor(Order: List<String>) {
        fruitOrder.set("Apple", 0)
        fruitOrder.set("Orange", 0)
        for (fruit in Order) {
            when (fruit) {
                "Apple" -> fruitOrder[fruit] = fruitOrder.getOrDefault(fruit, 0) + 1
                "Orange" -> fruitOrder[fruit] = fruitOrder.getOrDefault(fruit, 0) + 1
            }
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
