
/**
 * This project is an implementation of the classic game Rock Paper Scissors.
 * The user inputs the number of times the game runs.
 * Weapons are generated by a random number generator.
 * The output is the ratio of winning weapons.
 */

// Imports the java.util.* package in order to use the Random class.
import java.util.*

fun main(args: Array<String>) {

    // Prompt use to input number of times to play the game.
    println("Let's play Rock, Paper, Scissors! Please enter a move.\n"
                +"Enter the number of times to play the game.")
    
    // Read in number of times to play game. Input cannot be null.
    val numPlays:Int = readLine()!!.toInt()
    
    // Play the game.
    playGame(numPlays)

}

/**
 * This method plays the game a user-specified number of times.
 * The output is the ratios of winning weapons. 
 *
 * @property numPlays the user-specified number of times to play the game
 */
fun playGame(numPlays:Int){
        
    // Set constant values
    val ROCK = 1
    val PAPER = 2
    val SCISSORS = 3
        
    // Initiate win counters
    var rockWins = 0
    var paperWins = 0
    var scissorWins = 0
    var ties = 0

    // Uses a for loop to play the game the number of times indicated by numPlays
    for (i in 1..numPlays){
        val computerPlay1 = getComputerPlay()
        val computerPlay2 = getComputerPlay()
    
        when (computerPlay1) {
    
        computerPlay2 -> ties++
        ROCK -> {
            if (computerPlay2 == SCISSORS) { rockWins++ }
            else if (computerPlay2 == PAPER) { paperWins++ }
            }
        SCISSORS -> {
            if (computerPlay2 == PAPER) { scissorWins++ }
            else if (computerPlay2 == ROCK) { rockWins++ }
            }
        PAPER -> {
            if (computerPlay2 == ROCK) { paperWins++ }
            else if (computerPlay2 == SCISSORS) { scissorWins++ }
            }   
    
        }
        
    }
    
    // Print ratio of wins
    println("Number of wins for each options out of $numPlays rounds")
    println("-------------------------------------------------------")
    println("Rock Wins: $rockWins")
    println("Scissor Wins: $scissorWins")
    println("Paper Wins: $paperWins")
    println("Ties: $ties")
    
}

/**
 * This method returns an integer that corresponds to a randomly-generated computer move. 
 *
 * @return a randomly-generated computer move
 */
fun getComputerPlay():Int{
    var computerPlay:Int
    computerPlay = Random().nextInt(3) + 1
    return computerPlay
}
