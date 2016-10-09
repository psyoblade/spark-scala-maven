package com.psyoblade.scala.study.ft

import org.junit._
import Assert._

@Test
class chapter2 {
  val source = 1 to 6 toList

  @Test
  def testPartFilter(): Unit = {
    val partAnswer = (List(2,4,6), List(1,3,5))
    assertEquals(partAnswer, source partition (_ % 2 == 0))
    val filterAnswer = List(2,4,6)
    assertEquals(filterAnswer, source filter (_ % 2 == 0))
  }
  
  @Test
  def testTakeDropWhile: Unit = { // takeWhile, dropWhile
    val takeAnswer = List(1,2,3)
    assertEquals(takeAnswer, source takeWhile (_ <= 3))
    val dropAnswer = List(4,5,6)
    assertEquals(dropAnswer, source dropWhile (_ <= 3))
  }
  
  @Test
  def testMapReduceFold : Unit = {
    val mapAnswer = List(2,4,6,8,10,12)
    assertEquals(mapAnswer, source map (_ * 2))
    val reduceAnswer = 1+2+3+4+5+6
    assertEquals(reduceAnswer, source reduce (_ + _))
    val foldSeed = 100
    val foldAnswer = foldSeed+reduceAnswer
//    assertEquals(foldAnswer, source.foldLeft(foldSeed)((a,b) => a+b))
    assertEquals(foldAnswer, source.foldLeft(foldSeed)(_ + _)) // fold 경우 space 로 연산을 할 수 없다.
  }
}