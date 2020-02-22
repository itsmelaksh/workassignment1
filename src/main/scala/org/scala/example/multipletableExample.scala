package org.scala.example

import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

object multipletableExample {
  def main(args: Array[String]): Unit = {
    val customerPath = "file:/Laxman/Project/scala/workassignment1/src/main/data/Customer.csv"
    val countryPath = "file:/Laxman/Project/scala/workassignment1/src/main/data/Country.csv"
    val conf = new SparkConf().setAppName("CustomerData").setMaster("local[2]")
    val context = new SparkContext(conf)
    val spark = SparkSession.builder().appName("Test").config("x", "y").getOrCreate()

    val df1 = spark.read.option("header", "true").option("inferSchema", "true").csv(customerPath)
    val df2 = spark.read.option("header", "true").option("inferSchema", "true").csv(countryPath)

    val joinDF = df1.join(df2, "CountryCode")

    joinDF.select(joinDF("CustomerID"), joinDF("CustomerName"), joinDF("CountryCode"), joinDF("CountryName"), joinDF("Currency"), joinDF("TimeZone")).show(300, false)
  }
}
