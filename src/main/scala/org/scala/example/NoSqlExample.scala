package org.scala.example
import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

object NoSqlExample {
  def main(args: Array[String]){
    println("Hello World!")
    val customerPath = "file:/Laxman/Project/scala/workassignment1/src/main/data/Customer.csv"
    val conf = new SparkConf().setAppName("CustomerData").setMaster("local[2]")
    val context = new SparkContext(conf)
    val spark = SparkSession.builder().appName("Test").config("x","y").getOrCreate()

    val df = spark.read.option("header", "true").csv(customerPath)

//    df.show()
    df.show(200, false)

    df.printSchema()

    df.orderBy("CustomerName").show(200,false)

    df.groupBy("MemberCategory")
      .sum("AmountSpent")
      .show(200,false)
  }
}
