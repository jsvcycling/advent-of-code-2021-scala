package com.jsvcycling.aoc2021

import Utils._

trait Day {
  type Input
  type Output

  def parseInput(input: LazyList[String]): LazyList[Input]

  def part1(input: LazyList[Input]): Output
  def part2(input: LazyList[Input]): Output

  def run(filename: String): Unit = {
    val input = readInputToLines(filename).map(parseInput)
    val result1 = input.map(part1)
    val result2 = input.map(part2)

    println(s"Part 1: ${printResult(result1)}")
    println(s"Part 2: ${printResult(result2)}")
  }
}
