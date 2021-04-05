class DicePoints (diceGroup: DiceGroup){
    private val groupOfDices: DiceGroup = diceGroup
    private var totalPointsWon: Int = getSumOfDiceNumbers()

    private fun getSumOfDiceNumbers(): Int{
        var sumOfDiceNumbers = 0
        for (dice in groupOfDices.getDices()){
            sumOfDiceNumbers += dice.value.getRolledDiceNumber()
        }
        return sumOfDiceNumbers
    }

    fun checkDiceRollingResults(){      //checks for Jamb
        val rolledValues: MutableList<Int> = groupOfDices.getDicesValues()      //List with integer values
        checkJamb(rolledValues)
        checkPoker(rolledValues)
        checkLargeStraight(rolledValues)
        regularCheck()
    }

    private fun checkJamb(diceValues: MutableList<Int>){
        if (diceValues.groupingBy { it }.eachCount().any { it.value == 5 }){    //if there are 5 same values
            totalPointsWon += 50
        }
    }

    private fun checkPoker(diceValues: MutableList<Int>){
        if (diceValues.groupingBy { it }.eachCount().any { it.value == 4 }) {    //if there are 4 same values
            totalPointsWon += 40
        }
    }

    private fun checkLargeStraight(diceValues: MutableList<Int>){   //"skala" (5 in a row)
        diceValues.sort()
        if( ((diceValues[0] == 1) &&
                    (diceValues[1] == 2) &&
                    (diceValues[2] == 3) &&
                    (diceValues[3] == 4) &&
                    (diceValues[4] == 5)) ||
            ((diceValues[0] == 2) &&
                    (diceValues[1] == 3) &&
                    (diceValues[2] == 4) &&
                    (diceValues[3] == 5) &&
                    (diceValues[4] == 6)) ){
            totalPointsWon += 40
        }
    }

    private fun regularCheck(){
        totalPointsWon += getSumOfDiceNumbers()
    }

    fun getTotalPointsWon(): Int{
        return totalPointsWon
    }
}