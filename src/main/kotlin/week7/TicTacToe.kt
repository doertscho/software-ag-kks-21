package week7

fun getTriples(state: State): List<List<Symbol?>> {
    val field = state.field
    return listOf(
        // rows
        listOf(field[0][0], field[0][1], field[0][2]),
        listOf(field[1][0], field[1][1], field[1][2]),
        listOf(field[2][0], field[2][1], field[2][2]),
        // columns
        listOf(field[0][0], field[1][0], field[2][0]),
        listOf(field[0][1], field[1][1], field[2][1]),
        listOf(field[0][2], field[1][2], field[2][2]),
        // diagonals
        listOf(field[0][0], field[1][1], field[2][2]),
        listOf(field[0][2], field[1][1], field[2][0])
    )
}

fun winner(state: State): Symbol? {
    val triples = getTriples(state)

    for (triple in triples) {
        if (
            (triple[0] != null) &&
            (triple[0] == triple[1]) &&
            (triple[0] == triple[2])
        ) {
            return triple[0]
        }
    }
    return null
}

fun isValidMove(state: State, move: Move): Boolean {
    return state.field[move.row][move.column] == null
}

fun validMoveIsPossible(state: State): Boolean {
    for (row in 0 .. 2) {
        for (column in 0 ..2) {
            if (isValidMove(state, Move(row, column))) {
                return true
            }
        }
    }
    return false
}

fun runGame(state: State, players: Map<Symbol, Player>) {

    while (winner(state) == null && validMoveIsPossible(state)) {
        val playerSymbol = state.nextPlayerSymbol
        val player: Player = players[playerSymbol] ?: error("player $playerSymbol not available")

        val nextMove = player.nextMove(state)
        if (!isValidMove(state, nextMove)) {
            error("invalid move from $playerSymbol: $nextMove")
        }

        state.field[nextMove.row][nextMove.column] = playerSymbol
        state.nextPlayerSymbol = state.nextPlayerSymbol.other()
    }

    val winner = winner(state)
    println("$winner wins the game!")
}