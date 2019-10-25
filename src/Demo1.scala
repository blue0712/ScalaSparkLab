import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}
import org.slf4j.LoggerFactory

object Demo1 {
  val LOGGER = LoggerFactory.getLogger(Demo1.getClass.getSimpleName)
  def main(args: Array[String]): Unit = {
    LOGGER.info("Hello Scala!")
    Logger.getLogger("org").setLevel(Level.WARN)
    val config = new SparkConf().setAppName("simple connection")
      .setMaster("local[*]")
    val sc = new SparkContext(config)
    val textFile1 = sc.textFile("data\\README.md")
    LOGGER.info(s"we have total ${textFile1.count()}");
    val numAs = textFile1.filter(line => line.contains("A")).count();
    val numBs = textFile1.filter(line => line.contains("B")).count();
    LOGGER.info(s"we have a:$numAs, b:$numBs");
    sc.stop()
  }
}
