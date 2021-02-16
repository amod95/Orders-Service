package com.demo.orderservice

object Stockpile {
    private var fruitStock: MutableMap<String, Int> = mutableMapOf("Apple" to 10, "Orange" to 10)
    var returnFlag: Boolean = false

    fun isInStock(fruitOrder: List<String>): Boolean {
        var appleStockpile = fruitStock.get("Apple")!!
        var orangeStockpile = fruitStock.get("Orange")!!

        for (fruit in fruitOrder) {
            if (fruit == "Apple") {
                if (appleStockpile > 0) {
                    returnFlag = true
                    appleStockpile -= 1
                } else returnFlag = false
            } else if (fruit == "Orange") {
                if (orangeStockpile > 0) {
                    returnFlag = true
                    orangeStockpile -= 1
                } else returnFlag = false
            } else {
                println("This fruit" + fruit + "does not exist")
            }
        }

        fruitStock.set("Apple", appleStockpile)
        fruitStock.set("Orange", orangeStockpile)
        return returnFlag
    }

    fun getAppleStockpile(): Int
    {
        return fruitStock.get("Apple")!!
    }

    fun getOrangeStockpile(): Int {
    return fruitStock.get("Orange")!!
}

}
