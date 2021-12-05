package com.jsvcycling.aoc2021

import cats.implicits.toBifunctorOps

import scala.io.Source.fromFile
import scala.util.Try

object Utils {
  trait Error
  case class IOError(e: Throwable) extends Error

  def readInputToLines(filename: String): Either[Error, LazyList[String]] = {
    Try(fromFile(s"src/main/resources/$filename").getLines())
      .toEither
      .bimap(IOError, _.to(LazyList))
  }

  def printResult[O](result: Either[Error, O]): String = result match {
    case Right(v) => v.toString
    case Left(err) => s"ERROR: $err"
  }
}
