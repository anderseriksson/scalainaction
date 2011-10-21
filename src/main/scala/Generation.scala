class Generation(val aliveCells: Set[Cell] = Set.empty) {

  def next: Generation = new Generation()
}
