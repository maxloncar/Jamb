class DiceGroup (diceQuantity: Int){
    private var numberOfDices: Int = diceQuantity
    //key(Int), value(Dice)
    private var dices: MutableMap<Int, Dice> = mutableMapOf()      //MutableMap for Dice values

    //initialization
    init {
        for (i in 0 until numberOfDices) dices[i] = Dice(i+1)
    }

    fun rollDices(){
        for (dice in dices) dice.value.rollTheDice()
    }

    fun changeLockedStateForAllDices(){
        for (dice in dices) dice.value.changeDiceLockedState()
    }

    fun changeLockedStateForSpecificDice(diceID: Int){
        if (diceID in 1..numberOfDices) {
            for (dice in dices) {
                if (dice.value.getDiceID() == diceID) {
                    dice.value.changeDiceLockedState()
                    println("Locked state for dice with a key $diceID is changed.")
                }
            }
        }
        else println("$diceID is not regular key for dice.")
    }

    fun showRolledNumberForAllDices(){
        for (dice in dices) println(dice.value.getRolledDiceNumber())
    }

    fun getDices(): MutableMap<Int, Dice>{
        return dices
    }

    fun getDicesValues(): MutableList<Int>{     //getting the integer values from map dices into the list
        val rolledNumbers: MutableList<Int> = mutableListOf()
        for (dice in dices){
            rolledNumbers.add(dice.value.getRolledDiceNumber())
        }
        return rolledNumbers
    }

}