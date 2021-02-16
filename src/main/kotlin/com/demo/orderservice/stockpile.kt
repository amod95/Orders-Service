package com.demo.orderservice

//Static Stockpile instance, representing a mock database
object Stockpile {
    //Static fruit stockpile
    private var fruitStock: MutableMap<String, Int> = mutableMapOf("Apple" to 10, "Orange" to 10)
    var returnFlag: Boolean = false

    //Check to see if fruit passed to function is in stock. If so, return true boolean and update stockpile. Else, return false boolean. 
    fun isInStock(fruit: String): Boolean {
        var appleStockpile = fruitStock.get("Apple")!!
        var orangeStockpile = fruitStock.get("Orange")!!

            if (fruit.toLowerCase().capitalize() == "Apple") {
                if (appleStockpile > 0) {
                    returnFlag = true
                    appleStockpile -= 1
                    setAppleStockpile(appleStockpile)
                } else returnFlag = false
            } else if (fruit.toLowerCase().capitalize() == "Orange") {
                if (orangeStockpile > 0) {
                    returnFlag = true
                    orangeStockpile -= 1
                    setOrangeStockpile(orangeStockpile)
                } else returnFlag = false
            } else {
                println("This fruit " + fruit + " does not exist")
            }

        getAppleStockpile()
        getOrangeStockpile()
            return returnFlag
    }

    //Stockpile getters and setters
    fun getAppleStockpile(): Int
    {
        return fruitStock.get("Apple")!!
    }

    fun getOrangeStockpile(): Int {
    return fruitStock.get("Orange")!!}

    fun setOrangeStockpile(orangeStockpile: Int)
    {
        fruitStock.set("Orange", orangeStockpile)
    }

    fun setAppleStockpile(appleStockpile: Int) {
    fruitStock.set("Apple", appleStockpile)
}

}
