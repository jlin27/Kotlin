fun playGame (player1:Int, player2:Int) {
    val ROCK = 1
    val SCISSORS = 2
    val PAPER = 3
    
    when (player1) {
    
    player2 -> print("It is a tie.")
    ROCK -> {
        if (player2 == SCISSORS) { print("Player 1 wins!") }
        else if (player2 == PAPER) { print("Player 2 wins!") }
        }
    SCISSORS -> {
        if (player2 == PAPER) { print("Player 1 wins!") }
        else if (player2 == ROCK) { print("Player 2 wins!") }
        }
    PAPER -> {
        if (player2 == ROCK) { print("Player 1 wins!") }
        else if (player2 == SCISSORS) { print("Player 2 wins!") }
        }
    else -> print("Values need to be either 1, 2, or 3. Please try again.")

    }
}
    


fun main(args: Array<String>) {
    println("Player 1: Choose (1) - Rock, (2) - Scissors, or (3) - Paper:")
    val player1:Int = readLine()!!.toInt()
    println("You entered: $player1")
    
    println("Player 2: Choose (1) - Rock, (2) - Scissors, or (3) - Paper:")
    val player2:Int = readLine()!!.toInt()
    println("You entered: $player2\n")
    
    playGame(player1, player2)

 }
