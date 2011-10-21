import org.specs2.mutable.Specification

class CellSpec extends Specification {

  "Callig Cell(0, 0).neighbours" should {
    "return the correct neighbours around (0, 0)" in {
      Cell(0, 0).neighbours ==== Set(
        Cell(-1, -1), Cell(-1, 0), Cell(-1, 1),
        Cell(0, -1), Cell(0, 1),
        Cell(1, -1), Cell(1, 0), Cell(1, 1)
      )
    }
  }
}
