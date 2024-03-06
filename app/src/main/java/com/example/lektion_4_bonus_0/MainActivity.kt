package com.example.lektion_4_bonus_0

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

fun main() {
    val scaryMonster = Monster("Scary Monster", 100)
    val heroPlayer = Player("Hero", 80)
    val epicAdventure = Game("Epic Adventure", 1)
    val whiskersCat = Cat("Whiskers", "Gray")
    val buddyDog = Dog("Buddy", "Golden Retriever")

    // Använd instanser av klasserna här
    scaryMonster.attack()
    heroPlayer.heal()
    epicAdventure.start()
    whiskersCat.meow()
    buddyDog.bark()


}