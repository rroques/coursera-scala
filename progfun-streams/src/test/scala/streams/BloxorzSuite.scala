package streams

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import Bloxorz._

@RunWith(classOf[JUnitRunner])
class BloxorzSuite extends FunSuite {

  trait SolutionChecker extends GameDef with Solver with StringParserTerrain {
    /**
     * This method applies a list of moves `ls` to the block at position
     * `startPos`. This can be used to verify if a certain list of moves
     * is a valid solution, i.e. leads to the goal.
     */
    def solve(ls: List[Move]): Block =
      ls.foldLeft(startBlock) {
        case (block, move) => move match {
          case Left => block.left
          case Right => block.right
          case Up => block.up
          case Down => block.down
        }
      }
  }

  trait Level1 extends SolutionChecker {
    /* terrain for level 1*/

    val level =
      """ooo-------
        |oSoooo----
        |ooooooooo-
        |-ooooooooo
        |-----ooToo
        |------ooo-""".stripMargin

    val optsolution = List(Right, Right, Down, Right, Right, Right, Down)
  }

  test("terrain function level 1") {
    new Level1 {
      assert(terrain(Pos(0, 0)), "0,0")
      assert(!terrain(Pos(4, 11)), "4,11")
    }
  }

  test("findChar level 1") {
    new Level1 {
      assert(startPos == Pos(1, 1))
    }
  }

  test("neighborsWithHistory") {
    new Level1 {
      assert(neighborsWithHistory(Block(Pos(1, 1), Pos(1, 1)), List(Left, Up)).toSet == Set(
        (Block(Pos(1, 2), Pos(1, 3)), List(Right, Left, Up)),
        (Block(Pos(2, 1), Pos(3, 1)), List(Down, Left, Up))))
    }
  }

  test("newNeighborsWithHistory") {
    new Level1 {
      assert(newNeighborsOnly(
        Set(
          (Block(Pos(1, 2), Pos(1, 3)), List(Right, Left, Up)),
          (Block(Pos(2, 1), Pos(3, 1)), List(Down, Left, Up))).toStream,

        Set(Block(Pos(1, 2), Pos(1, 3)), Block(Pos(1, 1), Pos(1, 1)))) == Set(
          (Block(Pos(2, 1), Pos(3, 1)), List(Down, Left, Up))).toStream)
    }
  }

  test("optimal solution for level 1") {
    new Level1 {
      assert(solve(solution) == Block(goal, goal))
    }
  }

  test("optimal solution length for level 1") {
    new Level1 {
      assert(solution.length == optsolution.length)
    }
  }

  trait Stage3 extends SolutionChecker {

    val level =
      """------ooooooo--
      |oooo--ooo--oo--
      |ooooooooo--oooo
      |oSoo-------ooTo
      |oooo-------oooo
      |------------ooo""".stripMargin

    val optsolution = List(Up, Left, Down, Right, Up, Right, Right, Right, Right, Up, Up, Right, Right, Right, Down, Down, Down, Right, Up)
  }

  test("`Bloxorz` - Stage 3") {
    new Stage3 {
      assert(solution.length == optsolution.length)
    }
  }

  trait Stage33 extends SolutionChecker {

    val level =
      """-----oo-ooo----
|-----oooooo----
|ooo---oo-ooooo-
|oSooooooo--oo--
|-----oo-oo-ooo-
|-----oooooo-oo-
|ooo--oooooo-ooo
|oooooo-o--ooo-T
|ooo--ooo---oooo
|ooo---------ooo""".stripMargin

    val optsolution = List(Up, Right, Right, Down, Down, Left, Down, Right, Down, Down, Right, Down, Right, Up, Left, Left, Up, Right, Down, Right, Down, Right, Right, Up, Up, Right, Up, Left, Down, Down, Left, Up, Right, Right, Right, Right)
  }

  test("`Bloxorz` - Stage 33") {
    new Stage33 {
      assert(solution.length == optsolution.length)
    }
  }

  trait Stage33b extends SolutionChecker {

    val level =
      """-----oo-ooo----
|-----ooooooo---
|ooo---oo-ooooo-
|ooooooooo--oo--
|-----oo-oo-ooo-
|-----oooooo-oo-
|ooo--oooooo-ooo
|oToooo-o--ooo-S
|ooo--ooo---oooo
|ooo---------ooo""".stripMargin

    val optsolution = List(Up, Left, Down, Left, Left, Down, Left, Down, Down, Down, Left, Left, Left, Up, Right, Down, Left, Up, Left, Up, Up, Left, Up, Right, Up, Up, Left, Left, Down)
  }

  test("`Bloxorz` - Stage 33b") {
    new Stage33b {
      assert(solution.length == optsolution.length)
    }
  }
}
