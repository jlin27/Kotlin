
import java.util.*

fun main(args: Array<String>) {
	println("Let's play Rock, Paper, Scissors! Please enter a move.\n"
                +"Choose (1) - Rock, (2) - Scissors, or (3) - Paper")
    val playerInput:Int = readLine()!!.toInt()
    println("You chose: " + playerInput)
    if(playerInput == 1 || playerInput == 2 || playerInput == 3){
    	playGame(playerInput, getComputerPlay())
    } else {
    		// Exit game if user entered invalid input
    		println("Invalid Input: " + playerInput)
    		println("Exiting Game")
    }

}


fun playGame(playerInput:Int, computerPlay:Int){

    val ROCK = 1
	val PAPER = 2
	val SCISSORS = 3

    println("Computer play is: $computerPlay")
    
    when (playerInput) {
    
    computerPlay -> print("It is a tie.")
    ROCK -> {
        if (computerPlay == SCISSORS) { print("You win") }
        else if (computerPlay == PAPER) { print("Computer wins") }
        }
    SCISSORS -> {
        if (computerPlay == PAPER) { print("You win") }
        else if (computerPlay == ROCK) { print("You win") }
        }
    PAPER -> {
        if (computerPlay == ROCK) { print("You win") }
        else if (computerPlay == SCISSORS) { print("Computer wins") }
        }
    
    }
}
// Get computer's move
fun getComputerPlay():Int{
    var computerPlay:Int
	computerPlay = Random().nextInt(3) + 1
	return computerPlay
}