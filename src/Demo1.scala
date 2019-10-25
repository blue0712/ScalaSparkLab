import org.apache.spark.{SparkConf, SparkContext}

object Demo1 {
  def main(args: Array[String]): Unit = {
    System.out.println("Hello Scala!")
    val config = new SparkConf().setAppName("simple connection")
      .setMaster("local[*]")
    val sc = new SparkContext(config)
    val textFile1 = sc.textFile("data\\README.md")
    System.out.println(s"we have total ${textFile1.count()}");
    sc.stop()
  }
}

