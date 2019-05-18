/** Kotlin Inventory Project Code
 * Simple inventory tracking app.
 * User can create new Products and add them to an Inventory ArrayList.
 * There are also functions to calculate the total value of the inventory
 * calculatethe total number of products, and read/write inventory data to a file.
 */

// Import File package to use for reaading/writing data to file
import java.io.File

fun main(args: Array<String>){

    // Create an Inventory object
    var inventoryList = Inventory()
    
    // Add sample products
    inventoryList.addProduct("tea", 3, 1, 5)
    inventoryList.addProduct("coffee", 4, 2, 10)
    
    // Read/write inventory datai to specified file
    inventoryList.printInventory("inventory.txt")
}

// Setup Product class
class Product(val name:String, val price:Int, val id:Int, val quantity:Int){
   
   // Initializer block that runs during an instance initialization
   init {
        println("Product Name: $name")
        println("Product Price: $$price")
        println("Product ID: $id")
        println("Product Quantity: $quantity")
        println("---------------------------")
    }
}

// Setup Inventory class
class Inventory(){

    //Creating an empty arraylist  
    var inventoryList = ArrayList<Product>()
    var totalValue = 0
     var totalQuantity = 0
    
    
    // Add a product to the inventory
    fun addProduct(name:String, price:Int, id:Int, quantity:Int){
        inventoryList.add(Product(name, price, id, quantity))
    }
    // Loop through Inventory list to calculate and return total value
    fun calculateValue():Int{
        totalValue = 0
        for (obj in inventoryList){
         totalValue += obj.quantity * obj.price
    }
        return totalValue
    } 
    
    // Loop through Inventory list to calculate and return total product
    // quantity
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
    
        // Calculate the total value and total quantity
        totalValue = calculateValue()
        totalQuantity = calculateQuantity()
    
        // Prints data  to a specified file. 
        val myfile = File(fileName)
        myfile.printWriter().use { out ->
        
        for (obj in inventoryList){
            out.println("Product Name: ${obj.name}")
        }
        out.println("Inventory Value: $$totalValue")
        out.println("Inventory Quantity: $totalQuantity")
        }
     
        // Reads data from a specified file and prints to screen
        val lines: List<String> = File(fileName).readLines()
        lines.forEach { line -> println(line) }
        
    }
    
}
