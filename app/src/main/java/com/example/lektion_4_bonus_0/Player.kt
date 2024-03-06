package com.example.lektion_4_bonus_0

class Player(val playerName: String, var healthPoints: Int) {
    fun heal() {
        println("$playerName is healing.")
    }
}
