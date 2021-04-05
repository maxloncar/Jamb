const val numberOfDices: Int = 6
const val numberOfRounds: Int = 3
var gameIsOver: Boolean = false

fun endTheGame(){
    gameIsOver = !gameIsOver
}

fun main() {
    val diceGroup = DiceGroup(numberOfDices)    //6 dices
    val dicePoints = DicePoints(diceGroup)
    do {
        println("Game is starting!")
        Thread.sleep(2000)
        println("Rolling your dices:")
        for (i in 0 until numberOfRounds) {     //3 rounds of rolling dice
            diceGroup.rollDices()
            diceGroup.showRolledNumberForAllDices()
            println("Do you want to lock/unlock some dices? Locked dices won't roll.")
            println("If you want to lock/unlock a dice, write it's ID (1-6).")
            println("If you want to lock/unlock all the dices, write \"all\".")
            println("Anything else will skip locking.")
            when (readLine()) {
                "1" -> diceGroup.changeLockedStateForSpecificDice(1)
                "2" -> diceGroup.changeLockedStateForSpecificDice(2)
                "3" -> diceGroup.changeLockedStateForSpecificDice(3)
                "4" -> diceGroup.changeLockedStateForSpecificDice(4)
                "5" -> diceGroup.changeLockedStateForSpecificDice(5)
                "6" -> diceGroup.changeLockedStateForSpecificDice(6)
                "all" -> diceGroup.changeLockedStateForAllDices()
                else -> break
            }
        }
        println("After rolling dices, here comes checking for jamb.")
        dicePoints.checkDiceRollingResults()
        println("Total score: ${dicePoints.getTotalPointsWon()}")
        println("Do you want to end the game? Write \"yes\" if you want.")
        val endInput = readLine()
        if (endInput == "yes"){
            endTheGame()
        }
    } while (!gameIsOver)
}