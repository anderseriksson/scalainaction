class Generation(val aliveCells: Set[Cell] = Set.empty) {

  def next: Generation = new Generation(stayingAlive ++ born)

  private def stayingAlive = aliveCells filter (Set(2, 3) contains aliveNeighbours(_).size)

  private def born = aliveCells flatMap deadNeighbours filter (aliveNeighbours(_).size == 3)

  private def aliveNeighbours(cell: Cell) = cell.neighbours intersect aliveCells

  private def deadNeighbours(cell: Cell) = cell.neighbours diff aliveCells
}
