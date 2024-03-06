package Blackjeck
import kotlin.random.Random

class Card(val suit: String, val rank: String, val value: Int)

class Deck {
    private val suits = listOf("Hearts", "Diamonds", "Clubs", "Spades")
    private val ranks = listOf("2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace")
    private val cards = mutableListOf<Card>()

    init {
        // Initialize the deck with 52 cards
        for (suit in suits) {
            for (rank in ranks) {
                val value = when {
                    rank == "Ace" -> 11
                    rank in listOf("King", "Queen", "Jack") -> 10
                    else -> rank.toInt()
                }
                cards.add(Card(suit, rank, value))
            }
        }
    }

    fun shuffle() {
        cards.shuffle()
    }

    fun dealCard(): Card {
        return cards.removeAt(0)
    }
}

class Hand {
    private val cards = mutableListOf<Card>()

    fun addCard(card: Card) {
        cards.add(card)
    }

    fun getScore(): Int {
        var score = cards.sumBy { it.value }
        var numAces = cards.count { it.rank == "Ace" }

        while (score > 21 && numAces > 0) {
            score -= 10
            numAces--
        }

        return score
    }

    fun display() {
        for (card in cards) {
            println("${card.rank} of ${card.suit}")
        }
    }
}

class Player(val name: String) {
    val hand = Hand()

    fun displayHand() {
        println("$name's Hand:")
        hand.display()
        println("Total Score: ${hand.getScore()}\n")
    }
}

class BlackjackGame {
    private val deck = Deck()
    private val player = Player("Player")
    private val dealer = Player("Dealer")

    fun startGame() {
        deck.shuffle()
        player.hand.addCard(deck.dealCard())
        dealer.hand.addCard(deck.dealCard())
        player.hand.addCard(deck.dealCard())
        dealer.hand.addCard(deck.dealCard())

        player.displayHand()
        dealer.displayHand()

        // Implement player and dealer turns here
    }
}

fun main() {
    val game = BlackjackGame()
    game.startGame()
}