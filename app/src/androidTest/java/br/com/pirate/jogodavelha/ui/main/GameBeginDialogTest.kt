package br.com.pirate.jogodavelha.ui.main

import android.support.test.rule.ActivityTestRule
import br.com.pirate.jogodavelha.R
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertNotExist
import com.schibsted.spain.barista.interaction.BaristaDialogInteractions.clickDialogPositiveButton
import com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class GameBeginDialogTest {

    @Rule
    @JvmField
    var activityRule: ActivityTestRule<GameActivity> =
        ActivityTestRule(GameActivity::class.java)

    @Test
    @Throws(Exception::class)
    fun display_same_names_message_if_names_same() {
        writeTo(R.id.et_player1, "Android")
        writeTo(R.id.et_player2, "IOS")
        clickDialogPositiveButton()
        assertDisplayed(R.string.game_dialog_same_names)
    }

    @Test
    @Throws(Exception::class)
    fun display_empty_name_message_if_one_name_empty() {
        writeTo(R.id.et_player1, "")
        writeTo(R.id.et_player2, "Android")
        clickDialogPositiveButton()
        assertDisplayed(R.string.game_dialog_empty_name)
    }

    @Test
    @Throws(Exception::class)
    fun close_dialog_after_names_valid() {
        writeTo(R.id.et_player1, "Heider 1")
        writeTo(R.id.et_player2, "Android")
        clickDialogPositiveButton()
        assertNotExist(R.id.player1Layout)
    }
}