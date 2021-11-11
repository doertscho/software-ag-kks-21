package week6

fun containsLetterA(word: String): Boolean {
    return word.contains("a")
}

fun main() {

    val listOfWords: List<String> = listOf("Apple", "Banana", "Lemon", "Grapefruit")

    val filteredListOfWords = listOfWords.filter(::containsLetterA)
//    println("Folgende Worte enthalten den Buchstaben 'a': $filteredListOfWords")

    val filteredList2 = listOfWords.filter { word -> word.contains("a") }
//    println("Folgende Worte enthalten den Buchstaben 'a': $filteredList2")

    val filteredList3 = listOfWords.filter { word -> containsLetterA(word) }
//    println("Folgende Worte enthalten den Buchstaben 'a': $filteredList3")

    val lowercaseList = listOfWords.map { word -> word.lowercase() }
    println("Mit Kleinbuchstaben: $lowercaseList")

    val mappedList = listOfWords.map { word -> word.length }
    println("Veränderte Liste: $mappedList")
}
