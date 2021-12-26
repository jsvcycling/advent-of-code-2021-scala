package com.jsvcycling.aoc2021

object Day3 extends Day {
  override type Input = Array[Char]
  override type Output = Int

  override def parseInput(input: LazyList[String]): LazyList[Input] = input.map(_.toArray)

  override def part1(input: LazyList[Input]): Output = {
    val one_counts = new Array[Int](input.head.length)
    var gamma = ""
    var epsilon = ""

    input.foreach(_.zipWithIndex.foreach {
      case ('1', idx) => one_counts(idx) += 1
      case _ => ()
    })

    one_counts.foreach(c => {
      if (c > input.length / 2) {
        gamma ++= "1"
        epsilon ++= "0"
      } else {
        gamma ++= "0"
        epsilon ++= "1"
      }
    })

    Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2)
  }

  override def part2(input: LazyList[Input]): Output = 0

  def main(args: Array[String]): Unit = run("day3.txt")
}
