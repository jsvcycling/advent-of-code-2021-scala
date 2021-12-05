package com.jsvcycling.aoc2021

object Day2 extends Day {
  override type Input = Command
  override type Output = Int

  sealed trait Command
  case class Forward(amt: Int) extends Command
  case class Up(amt: Int) extends Command
  case class Down(amt: Int) extends Command
  case class Unknown() extends Command

  override def parseInput(input: LazyList[String]): LazyList[Input] = input.map(_.split(' ')).map {
    case Array(a, b, _*) if a == "forward" => Forward(b.toInt)
    case Array(a, b, _*) if a == "up" => Up(b.toInt)
    case Array(a, b, _*) if a == "down" => Down(b.toInt)
    case _ => Unknown()
  }

  override def part1(input: LazyList[Input]): Output = {
    val movements = input.map {
      case Forward(i) => (i, 0)
      case Up(i) => (0, -i)
      case Down(i) =>(0, i)
      case _ => (0, 0)
    }

    val position = movements.reduce((a, b) => (a._1 + b._1, a._2 + b._2))
    position._1 * position._2
  }

  override def part2(input: LazyList[Input]): Output = {
    var position = (0, 0)
    var dir = 0

    input.foreach {
      case Forward(i) => position = (position._1 + i, position._2 + (dir * i))
      case Up(i) => dir -= i
      case Down(i) => dir += i
      case _ => ()
    }

    position._1 * position._2
  }

  def main(args: Array[String]): Unit = run("day2.txt")
}
