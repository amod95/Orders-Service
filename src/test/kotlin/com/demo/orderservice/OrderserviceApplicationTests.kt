package com.demo.orderservice

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.junit.jupiter.api.Assertions

class OrderserviceApplicationTests {

@Test
fun getValue() {
    val fruitPrices = mapOf<String, Double>("Apple" to .60, "Orange" to .25)
    val fruits = listOf("Orange", "Apple", "Orange", "Orange", "Apple")
    val testFruit = Fruit(fruits)
    val expectedResult =
            mapOf<String, Double>(
                    "Apple" to testFruit.getPriceofApple(),
                    "Orange" to testFruit.getPriceofOrange())
    Assertions.assertEquals(expectedResult, fruitPrices)
}

@Test
fun `test getOrderQuantityMap passes`() {
    val fruits = listOf("Orange", "Orange", "Orange", "Apple", "Apple")
    val testFruit = Fruit(fruits)
    val orderQuantityMap =
            mapOf<String, Int>(
                    "Orange" to testFruit.getNumberofOranges(),
                    "Apple" to testFruit.getNumberofApples())
    val expectedResult = mapOf<String, Int>("Orange" to 3, "Apple" to 2)
    Assertions.assertEquals(expectedResult, orderQuantityMap)
}

@Test
fun `test checkOrangeOffer passes`() {
    val fruits = listOf<String>("Orange", "Orange", "Orange")
    val testFruit = Fruit(fruits)
    Assertions.assertEquals(.5, testFruit.getTotal())
}

@Test
fun `test checkAppleSelection passes`() {
    val fruits = listOf<String>("Apple", "Apple")
    val testFruit = Fruit(fruits)
    Assertions.assertEquals(.6, testFruit.getTotal())
}

@Test
fun `test multipleFruits passes`() {
    val fruits = listOf<String>("Apple", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange")
    val testFruit = Fruit(fruits)
    Assertions.assertEquals(1.95, testFruit.getTotal())
}

@Test
fun `test checkInventory passes`() {
    val fruits = listOf<String>("Apple", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange")
	Stockpile.setOrangeStockpile(10)
	Stockpile.setAppleStockpile(10)
    for(fruit in fruits)
	{
		Stockpile.isInStock(fruit)
	}
    val expectedInventory = mapOf<String, Int>("Apple" to 7, "Orange" to 6)
    val actualInventory =
            mapOf<String, Int>(
                    "Apple" to Stockpile.getAppleStockpile(),
                    "Orange" to Stockpile.getOrangeStockpile())
    Assertions.assertEquals(expectedInventory, actualInventory)
}


}
