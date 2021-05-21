package br.com.pirate.jogodavelha.ui.main

import android.support.test.rule.ActivityTestRule
import br.com.pirate.jogodavelha.R
import br.com.pirate.jogodavelha.model.Player
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickOn
import com.schibsted.spain.barista.interaction.BaristaDialogInteractions.clickDialogPositiveButton
import com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class GameActivityTest {

    @Rule
    @JvmField
    var activityRule: ActivityTestRule<GameActivity> =
        ActivityTestRule(GameActivity::class.java)

    private val player1 = Player("Android", "x")
    private val player2 = Player("IOS", "o")

    @Test
    fun end_game_when_one_player_wins() {
        writeTo(R.id.et_player1, player1.name)
        writeTo(R.id.et_player2, player2.name)

        clickDialogPositiveButton()

        clickOn(R.id.cell_00)
        clickOn(R.id.cell_10)
        clickOn(R.id.cell_01)
        clickOn(R.id.cell_11)
        clickOn(R.id.cell_02)

        assertDisplayed(R.id.tvWinner)
        assertDisplayed(player1.name)
    }
}