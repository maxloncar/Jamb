import kotlin.random.Random

class Dice (ID: Int) {
    private val diceID : Int = ID
    private var rolledDiceNumber : Int = 0
    private var lockedState : Boolean = false

    fun rollTheDice() = if (!checkDiceLockedState()){      //lockedState == false
            this.rolledDiceNumber = Random.nextInt(1, 7)
        } else println("Dice with an ID $diceID and value $rolledDiceNumber is in a locked state! Unlock it to roll it.")

    fun changeDiceLockedState(){
        this.lockedState = !lockedState
    }

    fun getRolledDiceNumber(): Int{
        return rolledDiceNumber
    }

    private fun checkDiceLockedState() : Boolean{
        return lockedState
    }

    fun getDiceID(): Int{
        return diceID
    }
}