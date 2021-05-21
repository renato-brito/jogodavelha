package br.com.pirate.jogodavelha.model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GameTest {

    private lateinit var game: Game
    private var player: Player? = null
    private var anotherPlayer: Player? = null

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        game = Game("Heider", "Android")
        player = game.player1
        anotherPlayer = game.player2
    }

    @Test
    fun `return True If Has Three Same Horizontal Cells At Row 1`() {
//        val game = Game("Heider", "Android")
//        val player = game.player1
        val cell = Cell(player)

        game.cells[0][0] = cell
        game.cells[0][1] = cell
        game.cells[0][2] = cell

        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()

        assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    @Throws(Exception::class)
    fun `return True If Has Three Same Horizontal Cells At Row 2`() {
//        val game = Game("Heider", "Android")
//        val player = game.player1
        val cell = Cell(player)

        game.cells[1][0] = cell
        game.cells[1][1] = cell
        game.cells[1][2] = cell

        val hasThreeSameHorizontalCells =
            game.hasThreeSameHorizontalCells()

        assertTrue(hasThreeSameHorizontalCells)
    }

    @Test
    @Throws(Exception::class)
    fun `return True If Has Three Same Horizontal Cells At Row 3`() {
//        val game = Game("Heider", "Android")
//        val player = game.player1
        val cell = Cell(player)

        game.cells[2][0] = cell
        game.cells[2][1] = cell
        game.cells[2][2] = cell

        val hasThreeSameHorizontalCells =
            game.hasThreeSameHorizontalCells()

        assertTrue("Algum problema na linha 2 ", hasThreeSameHorizontalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnFalseIfDoesNotHaveThreeSameHorizontalCells() {
//        val game = Game("Heider", "Android")
//        val player = game.player1
//        val anotherPlayer = game.player2
        val cell = Cell(player)
        val anotherCell = Cell(anotherPlayer)

        game.cells[0][0] = cell
        game.cells[0][1] = cell
        game.cells[0][2] = anotherCell

        val hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells()

        assertFalse(hasThreeSameHorizontalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameVerticalCellsAtColumn1() {
        val cell = Cell(player)

        game.cells[0][0] = cell
        game.cells[1][0] = cell
        game.cells[2][0] = cell

        val hasThreeSameVerticalCells =
            game.hasThreeSameVerticalCells()

        assertTrue(hasThreeSameVerticalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameVerticalCellsAtColumn2() {
        val cell = Cell(player)

        game.cells[0][1] = cell
        game.cells[1][1] = cell
        game.cells[2][1] = cell

        val hasThreeSameVerticalCells =
            game.hasThreeSameVerticalCells()

        assertTrue(hasThreeSameVerticalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameVerticalCellsAtColumn3() {
        val cell = Cell(player)

        game.cells[0][2] = cell
        game.cells[1][2] = cell
        game.cells[2][2] = cell

        val hasThreeSameVerticalCells =
            game.hasThreeSameVerticalCells()

        assertTrue(hasThreeSameVerticalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnFalseIfDoesNotHaveThreeSameVerticalCells() {
        //Entrada
        val cell = Cell(player)
        val anotherCell = Cell(anotherPlayer)

        game.cells[0][2] = cell
        game.cells[1][2] = cell
        game.cells[2][2] = anotherCell

        val hasThreeSameVerticalCells = game.hasThreeSameVerticalCells()

        assertFalse(hasThreeSameVerticalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameDiagonalCellsFromLeft() {
        val cell = Cell(player)

        game.cells[0][0] = cell
        game.cells[1][1] = cell
        game.cells[2][2] = cell

        val hasThreeSameDiagonalCells =
            game.hasThreeSameDiagonalCells()

        assertTrue(hasThreeSameDiagonalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnTrueIfHasThreeSameDiagonalCellsFromRight() {
        val cell = Cell(player)

        game.cells[0][2] = cell
        game.cells[1][1] = cell
        game.cells[2][0] = cell

        val hasThreeSameDiagonalCells = game.hasThreeSameDiagonalCells()

        assertTrue(hasThreeSameDiagonalCells)
    }

    @Test
    @Throws(Exception::class)
    fun returnFalseIfDoesNotHaveThreeSameDiagonalCells() {
        val cell = Cell(player)
        val anotherCell = Cell(anotherPlayer)

        game.cells[0][2] = cell
        game.cells[1][1] = cell
        game.cells[2][0] = anotherCell

        val hasThreeSameDiagonalCells = game.hasThreeSameDiagonalCells()

        assertFalse(hasThreeSameDiagonalCells)
    }

    @Test
    fun endGameIfHasThreeSameHorizontalCells() {
        val cell = Cell(player)

        game.cells[0][0] = cell
        game.cells[0][1] = cell
        game.cells[0][2] = cell

        val hasGameEnded = game.hasGameEnded()

        assertTrue(hasGameEnded)
    }

    @Test
    fun endGameIfHasThreeSameVerticalCells() {
        val cell = Cell(player)

        game.cells[0][0] = cell
        game.cells[1][0] = cell
        game.cells[2][0] = cell

        val hasGameEnded = game.hasGameEnded()

        assertTrue(hasGameEnded)
    }

    @Test
    fun endGameIfHasThreeSameDiagonalCells() {
        val cell = Cell(player)

        game.cells[0][0] = cell
        game.cells[1][1] = cell
        game.cells[2][2] = cell

        val hasGameEnded = game.hasGameEnded()

        assertTrue(hasGameEnded)
    }

    @Test
    fun endGameIfBoardIsFull() {
        val cellPlayer1 = Cell(player)
        val cellPlayer2 = Cell(anotherPlayer)

        game.cells[0][0] = cellPlayer1
        game.cells[0][1] = cellPlayer1
        game.cells[0][2] = cellPlayer2
        game.cells[1][0] = cellPlayer2
        game.cells[1][1] = cellPlayer1
        game.cells[1][2] = cellPlayer1
        game.cells[2][0] = cellPlayer1
        game.cells[2][1] = cellPlayer2
        game.cells[2][2] = cellPlayer2

        val hasGameEnded = game.hasGameEnded()

        assertTrue(hasGameEnded)
    }
}