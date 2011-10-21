import org.specs2.mutable.Specification

class GenerationSpec extends Specification {

  "Calling Generation.next" should {
    "return an empty Generation for a empty Generation" in {
      new Generation(Set.empty).next.aliveCells mustEqual Set.empty
    }
    "return a Generation with a horizontal triple for a Generation with a vertical triple" in {
      new Generation(Set(Cell(-1, 0), Cell(0, 0), Cell(1, 0))).next.aliveCells mustEqual
        Set(Cell(0, -1), Cell(0, 0), Cell(0, 1))
    }
    "return a Generation with a vertical triple for a Generation with a horizontal triple" in {
      new Generation(Set(Cell(0, -1), Cell(0, 0), Cell(0, 1))).next.aliveCells mustEqual
        Set(Cell(-1, 0), Cell(0, 0), Cell(1, 0))
    }
  }
}
