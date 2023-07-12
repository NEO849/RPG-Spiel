import kotlin.random.Random

class DbzStoryModus(name: String, lP: Int, istBesiegt: Boolean = false) : Charakter(name, lP, istBesiegt = false) {

    val spieler : Charakter
    val soldat1 : Charakter
    val soldat2 : Charakter
    val soldat3 : Charakter
    val endGegner1 : Charakter
    val endGegner2 : Charakter
    val endGegner3 : Charakter

    init {
        spieler = Charakter("Son Goku",20000,"Schlag","Block")
        soldat1 = Charakter("Soldat1",15000,"Schlag","Block")
        soldat2 = Charakter("Soldat2",20000,"Schlag","Block")
        soldat3 = Charakter("Soldat3",25000,"Schlag","Block")
        endGegner1 = Charakter("Vegeta",20000, "Schlag","Block")
        endGegner2 = Charakter("Freezer",40000, "Schlag","Block")
        endGegner3 = Charakter("Cell",60000, "Schlag","Block")
    }

    // startet Arcade Modus, Kämpfer Auswahl und Spiellogik
    fun startStoryModus() {

        // Intro 1
        println("\nDie Welt wird wieder mal bedroht und nur der Kämpfer  ${spieler.name}  kann uns Retten")

        // Kampf 1 gegen Soldat 1
        println("Kampf 1:  Son Goku vs.  ${soldat1.name}")
        kampfSequenz(spieler, soldat1)

        // Intro 2
        println("\nDiese Gegner sind ganz schön Stark, wo kommen die nur her?")
        println("Ohh Nein! Ein mächtiger Bossgegner erscheint, es ist  ${endGegner1.name}  der Prinz der Saijayin´s!")

        // Kampf 2 gegen Vegeta
        println("Kampf 2:  Son Goku vs.  ${endGegner1.name}")
        kampfSequenz(spieler, endGegner1)

        // Intro 3
        println("\nBoah das war knapp, wenn die alle so Stark sind...")
        println("Achtung da sind schon wieder Gegner!!")

        // Kampf 3 gegen Soldat 2
        println("Kampf 3:  Son Goku vs.  ${soldat2.name}")
        kampfSequenz(spieler, soldat2)

        // Intro 4
        println("\nSowas verdrück ich ja zum Frühstück...")
        println("Achtung ein Endgegner!")

        // Kampf 4 gegen Freezer
        println("Kampf 2:  Son Goku vs.  ${endGegner2.name}")
        kampfSequenz(spieler, endGegner2)

        // Intro 5
        println("\nBoah das war knapp, wenn die alle so Stark sind...")
        println("Achtung da sind schon wieder Gegner!!")

        // Kampf 5 gegen Soldat 3
        println("Kampf 4:  Son Goku vs.  ${soldat3.name}")
        kampfSequenz(spieler, soldat3)

        // Intro 6
        println("\nBoah das war knapp, wenn die alle so Stark sind...")
        println("Achtung der End Kampf erwartet dich!")

        // Kampf 6 gegen Cell
        println("Kampf 5:  Son Goku vs.  ${endGegner3.name}")
        kampfSequenz(spieler, endGegner3)

        println("Glückwunsch du hast den Story- Modus abgeschlossen!")
    }

    private fun kampfSequenz(spieler:Charakter, gegner:Charakter) {
        var spielerLP = spieler.lP
        var gegnerLP = gegner.lP

        while (spielerLP > 0 && gegnerLP > 0) {
            println("\nSpieler:  ${spieler.name}    $spielerLP lP")
            println("Gegner:   ${gegner.name}    $gegnerLP lP")

            println("\nWähle eine Aktion")
            println("[1] Schlag")
            println("[2] Tritt")

            val auswahl = readln().toIntOrNull() ?: 0

                if (auswahl == 1 || auswahl == 2) {
                val spielerSchaden = if (auswahl == 1) Random.nextInt(2000, 5000) else Random.nextInt(1500, 3500)
                val gegnerSchaden = Random.nextInt(800, 7000)

                gegnerLP -= spielerSchaden
                spielerLP -= gegnerSchaden

                println("\nSpieler fügt dem Gegner  $spielerSchaden  Schaden zu!")
                println("\nGegner fügt dem Spieler  $gegnerSchaden  Schaden zu!")
                println()
            } else {
                println("Ungültige Auswahl!")
            }
        }

        if (spielerLP <= 0) {
            println("\n${spieler.name}  ist K.O!!!")
        } else {
            println("\n${gegner.name}  ist K.O!!!")
        }
    }

    override fun angreifen(schaden: Int, angriffsArt: String): String {
        return "$name greift mit $angriffsArt an!"
    }

    override fun verteidigen(schaden: Int, verteidigungsArt: String): String {
        return "$name verteidigt sich mit $verteidigungsArt!"
    }

    override fun spezialFaehigkeit(schaden: Int, spezialfaehigkeit: String): String {
        return "$name setzt die Spezialfähigkeit $spezialfaehigkeit ein!"
    }

    override fun transformation(schaden: Int, transformation: String): String {
        return "$name transformiert sich in $transformation!"
    }

    override fun heilen(schaden: Int): String {
        return "$name verwendet eine magische Bohne, um sich zu heilen!"
    }

    override fun schadenErleiden(schaden: Int): String {
        return "$name erleidet $schaden Schaden!"
    }
}

