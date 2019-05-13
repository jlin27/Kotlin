/** Kotlin Inventory Project Code
 * Simple inventory tracking app.
 * User can create new Products and add them to an Inventory ArrayList.
 * There are also functions to calculate the total value of the inventory
 * and the total number of products.
 */

fun main(args: Array<String>){
    var inventoryList = Inventory()
    inventoryList.addProduct("tea", 3, 1, 5)
    inventoryList.addProduct("coffee", 4, 2, 10)
    inventoryList.calculateValue()
    inventoryList.calculateQuantity()
}


class Product(val name:String, val price:Int, val id:Int, val quantity:Int){
   
   init {
        println("Product Name: $name")
        println("Product Price: $$price")
        println("Product ID: $id")
        println("Product Quantity: $quantity")
        println("---------------------------")
    }
}

class Inventory(){

    //Creating an empty arraylist  
    var inventoryList = ArrayList<Product>()
    
    // Add a product to the inventory
    fun addProduct(name:String, price:Int, id:Int, quantity:Int){
        inventoryList.add(Product(name, price, id, quantity))
    }
    //Calculate value
    fun calculateValue(){
        var inventoryValue = 0
        for (obj in inventoryList){
         inventoryValue += obj.quantity * obj.price
    }
        println("Inventory Value: $inventoryValue")
    } 
    
    //Calculate total product quantity
    fun calculateQuantity(){
    var totalQuantity = 0
    for (obj in inventoryList){
        totalQuantity += obj.quantity
    }
        println("Inventory Quantity: $totalQuantity")

    }
     
     
}
