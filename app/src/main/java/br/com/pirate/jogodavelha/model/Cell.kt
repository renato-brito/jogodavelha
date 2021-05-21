package br.com.pirate.jogodavelha.model

data class Cell(var player: Player?) {

    val isEmpty: Boolean
        get() = player?.value?.isEmpty() == true
}