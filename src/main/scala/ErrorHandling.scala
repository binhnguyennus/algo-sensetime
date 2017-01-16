package com.sensetime.ad.algo.scalatest

/**
  *
  * Chapter 4 : Error Handling , Functional Programming with Scala
  *
  * Created by yuanpingzhou on 1/11/17.
  */
import scala.util.{Try,Success,Failure}

object ErrorHandling {

  def toInt(str: String): Option[Int] = {
    try{
      Some(str.toInt)
    }
    catch{
      case e : NumberFormatException => None
    }
  }

  def divide(a: Int,b: Int): Either[String,Double] = {
    if(b == 0){
      Left("cannot divide by 0")
    }
    else{
      Right(a.toDouble/b.toDouble)
    }
  }

  def main(args: Array[String]) = {

    // just throw the exception
    val str = "abc"
    toInt(str) match {
      case Some(v) => println("success")
      case None => println("error ")
    }

    // replace exception with default value
    val ret = toInt(str).getOrElse(-1)
    println(s"return value is ${ret}")

    // throw exception error message with standard Scala library method Try
    // message is generated by std Scala library
    Try(str.toInt) match {
      case Success(v) => println(s"value is ${v}")
      case Failure(msg) => println(s"error message is [${msg}]")
    }

    // throw exception error message with Either
    // message is customer-defined
    divide(10,0) match {
      case Left(msg) => println(s"error message is [${msg}]")
      case Right(v) => println(s"return value of division is ${v}")
    }

  }
}
