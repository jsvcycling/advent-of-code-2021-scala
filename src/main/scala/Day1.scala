package com.jsvcycling.aoc2021

object Day1 extends Day {
  type Input = Int
  type Output = Int

  def window(input: Seq[Input], idx: Int): Int = if (idx + 1 >= input.length) {
    0
  } else if (input(idx + 1) > input(idx)) {
    window(input, idx + 1) + 1
  } else {
    window(input, idx + 1)
  }

  override def parseInput(input: LazyList[String]): LazyList[Input] = input.map(_.toInt)

  override def part1(input: LazyList[Input]): Output = {
    window(input, 0)
  }

  override def part2(input: LazyList[Input]): Output = {
    val sums = input.sliding(3).map(_.sum).toArray
    window(sums, 0)
  }

  def main(args: Array[String]): Unit = run("day1.txt")
}