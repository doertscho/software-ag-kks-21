package week5

fun main() {

    // Ein paar simple Datentypen kennen wir schon:
    val x: Int = 5
    val truth: Boolean = true
    val text: String = "Hallo, Welt!"

    // Ebenso ein paar Möglichkeiten, unseren Programmfluss dynamisch zu gestalten:
    if (x > 3) {
        println("x ist größer als drei!")
    }

    for (i in 1 .. x) {
        println(text)
    }

    // Heute kommt etwas Neues dazu: Komplexe Datentypen. Erstes Beispiel: Listen!
    val fruits: List<String> = listOf("apple", "banana", "lemon", "grapefruit", "cherry", "strawberry")
    for (fruit in fruits) {
        println("$fruit is a delicious fruit")
    }
    val listLength = fruits.size
    println("The list of fruits contains $listLength entries!")

    val lastElement = fruits.last()
    println("The last element in the list of fruits is $lastElement")

    val randomFruit = fruits.random()
    println("The fruit of the day is $randomFruit")

    val favouriteNumbers: List<Int> = listOf(24, 1, 3, 32, 64, 102, 5, 6, 24, 24, 24, 24, 105, 4, 12)
    var greatestNumber = 0
    for (i in favouriteNumbers) {
        if (i > greatestNumber) {
            greatestNumber = i
        }
    }
    println("The greatest of my favourite numbers is $greatestNumber")

    val maxNumber = favouriteNumbers.maxOrNull()
    println("The `maxOrNull` value is $maxNumber")

    val sum = favouriteNumbers.sum()
    println("The sum of all my favourite numbers is $sum")

    // Arrays sind in vieler Hinsicht Listen sehr ähnlich.
    // Sie sind aber darauf ausgelegt, gezielt auf einzelne Elemente zuzugreifen.
    val arrayOfFruits: Array<String> = arrayOf("banana", "apple", "strawberry")
    for (fruit in arrayOfFruits) {
        println("One fruit in my array is a $fruit")
    }

    println("My array of fruits is: ${arrayOfFruits.toList()}")
    println("The first element in my array of fruits is ${arrayOfFruits[0]}")
    println("The second element in my array of fruits is ${arrayOfFruits[1]}")

    // Einzelne Elemente können auch gezielt verändert werden:
    arrayOfFruits[1] = "grapefruit"
    println("My array of fruits is: ${arrayOfFruits.toList()}")
    println("The second element in my array of fruits is ${arrayOfFruits[1]}")

    // Durch Verschachtelung können zweidimensionale Arrays erstellt werden.
    val board: Array<Array<String>> = arrayOf(
        arrayOf("bla", "blub", "test"),
        arrayOf("bla", "blub", "test"),
        arrayOf("bla", "blub", "test")
    )
    println("Text in der ersten Zeile, zweites Feld: ${board[0][1]}")
}
