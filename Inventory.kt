/**
 * Kotlin Inventory Project Code
 * User can create new Products and add them to an Inventory ArrayList.
 * There are also functions to calculate the total value of the inventory
 * calculate the total number of products, and read/write inventory data to a file.
 */

// Imports File package to use for reading/writing data to file.
import java.io.File

fun main(args: Array<String>){

    // Setup file name.
    var fileName = "inventory.txt"

    // Creates an Inventory object.
    var inventoryList = Inventory()
    
    // Adds sample products and write data to specified file.
    inventoryList.addProduct("tea", 3, 1, 5, fileName)
    inventoryList.addProduct("coffee", 4, 2, 10, fileName)
    
    // Writes/reads inventory data to specified file.
    inventoryList.printInventory(fileName)
}

// Setup Person class and declare and initialize properties from the primary constructor.
class Product(var name:String, var price:Int, var id:Int, var quantity:Int){

}

// Setup Inventory class.
class Inventory(){

    // Creates an empty arraylist.  
    var inventoryList = ArrayList<Product>()
    var totalValue = 0
    var totalQuantity = 0
    
    
    // Adds a product to the inventory and writes product data to specified file.
    fun addProduct(name:String, price:Int, id:Int, quantity:Int, fileName:String){
        inventoryList.add(Product(name, price, id, quantity))

        var contentName:String = "Product Name: $name\n"
        var contentPrice:String = "Product Price: $$price\n"
        var contentID:String = "Product ID: $id\n"
        var contentQuantity:String = "Product Quantity: $quantity\n"
        var contentDivider:String = "---------------------------\n"

        File(fileName).appendText(contentName)
        File(fileName).appendText(contentPrice)
        File(fileName).appendText(contentID)
        File(fileName).appendText(contentQuantity)
        File(fileName).appendText(contentDivider)

    }
    // Loops through Inventory list to calculate and returns total value.
    fun calculateValue():Int{
        totalValue = 0
        for (obj in inventoryList){
         totalValue += obj.quantity * obj.price
    }
        return totalValue
    } 
    
    // Loops through Inventory list to calculate and returns total product
    // quantity.
    fun calculateQuantity():Int{
        totalQuantity = 0
        for (obj in inventoryList){
            totalQuantity += obj.quantity
         }
        return totalQuantity
    }
    
    // Prints all products in inventory list, the total inventory value
    // and the total inventory quantity. Takes in a file name the
    // data will be printed to.
    fun printInventory(fileName:String){

      // Calculates the total value and total quantity.
        totalValue = calculateValue()
        totalQuantity = calculateQuantity()
        
        var totalValue:String = "Inventory Value: $$totalValue\n"
        var totalQuantity:String = "Inventory Quantity: $totalQuantity\n"
        
        // Writes data to a specified file
        File(fileName).appendText(totalValue)
        File(fileName).appendText(totalQuantity)
    
        
        // Reads data from a specified file and prints to screen
        val lines: List<String> = File(fileName).readLines()
        lines.forEach { line -> println(line) }
        
    }
    
}
