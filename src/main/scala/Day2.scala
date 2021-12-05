package com.jsvcycling.aoc2021

object Day2 extends Day {
  override type Input = (String, Int)
  override type Output = Int

  override def parseInput(input: LazyList[String]): LazyList[Input] = input.map(_.split(' ').take(2)).map {
    case Array(a, b) => (a, b.toInt)
  }

  override def part1(input: LazyList[Input]): Output = {
    val movements = input.map {
      case Tuple2(dir, amt) if dir == "forward" => (amt, 0)
      case Tuple2(dir, amt) if dir == "up" => (0, -amt)
      case Tuple2(dir, amt) if dir == "down" => (0, amt)
    }

    val position = movements.reduce((a, b) => (a._1 + b._1, a._2 + b._2))
    position._1 * position._2
  }

  override def part2(input: LazyList[Input]): Output = {
    var position = (0, 0)
    var dir = 0

    input.foreach(i => i._1 match {
      case "forward" => position = (position._1 + i._2, position._2 + (dir * i._2))
      case "up" => dir -= i._2
      case "down" => dir += i._2
    })

    position._1 * position._2
  }

  def main(args: Array[String]): Unit = run("day2.txt")
}
