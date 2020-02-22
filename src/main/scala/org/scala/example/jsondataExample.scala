package org.scala.example

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

object jsondataExample {
  def main(args: Array[String]): Unit = {
    val producerPath = "file:/Laxman/Project/scala/workassignment1/src/main/data/Producers.json"
    val conf = new SparkConf().setAppName("ProducerData").setMaster("local[2]")
    val contextx =  new SparkContext(conf)
    val sparkx = SparkSession.builder().appName("Test").config("x","y").getOrCreate()

    val dfProd = sparkx.read.json(producerPath)

    dfProd.show(200, false)
  }
}
