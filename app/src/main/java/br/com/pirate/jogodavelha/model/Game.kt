package br.com.pirate.jogodavelha.model

import android.util.Log
import androidx.lifecycle.MutableLiveData

class Game(playerOne: String, playerTwo: String) {
    var player1: Player? = null
    var player2: Player? = null
    var currentPlayer = player1
    var cells: Array<Array<Cell?>>
    var winner: MutableLiveData<Player> = MutableLiveData()

    init {
        cells = Array(BOARD_SIZE) { arrayOfNulls<Cell>(BOARD_SIZE) }
        player1 = Player(playerOne, "x")
        player2 = Player(playerTwo, "o")
        currentPlayer = player1
    }

    companion object {
        private val TAG = Game::class.java.simpleName
        private val BOARD_SIZE = 3
    }

    val isBoardFull: Boolean
        get() {
            for (row in cells)
                for (cell in row)
                    if (cell == null || cell.isEmpty) return false
            return true
        }

    fun switchPlayer() {
        currentPlayer = if (currentPlayer === player1) player2 else
            player1
    }

    fun reset() {
        player1 = null
        player2 = null
        currentPlayer = null
        cells = Array(BOARD_SIZE) { arrayOfNulls<Cell>(BOARD_SIZE) }
    }

    private fun areEqual(vararg cells: Cell?): Boolean {
        for (cell in cells) if (cell?.player?.value == null)
            return false
        val comparisonBase = cells[0]
        for (i in 1 until cells.size)
            if
                    (!comparisonBase?.player?.value.equals(cells[i]?.player?.value))
                return false
        return true
    }

    fun hasThreeSameHorizontalCells(): Boolean {
        try {
            for (i in 0 until BOARD_SIZE)
                if (areEqual(cells[i][0], cells[i][1], cells[i][2]))
                    return true
            return false
        } catch (e: NullPointerException) {
            Log.e(TAG, e.message!!)
            return false
        }
    }

    fun hasThreeSameVerticalCells(): Boolean {
        return try {
            for (i in 0 until BOARD_SIZE) if (areEqual(
                    cells[0][i],cells[1][i],cells[2][i]
                )
            ) return true
            false
        } catch (e: java.lang.NullPointerException) {
            Log.e(TAG, e.message!!)
            false
        }
    }

    fun hasThreeSameDiagonalCells(): Boolean {
        return try {
            (areEqual(cells[0][0], cells[1][1], cells[2][2]) ||
                    areEqual(
                        cells[0][2],
                        cells[1][1],
                        cells[2][0]
                    ))
        } catch (e: NullPointerException) {
            Log.e(TAG, e.message!!)
            false
        }
    }

    fun hasGameEnded(): Boolean {
        if (hasThreeSameHorizontalCells() ||
            hasThreeSameVerticalCells() || hasThreeSameDiagonalCells()) {
            winner.value = currentPlayer
            return true
        }
        if (isBoardFull) {
            winner.value = null
            return true
        }
        return false
    }
}