package runner

import org.apache.commons.cli.{BasicParser, Options}
import org.apache.spark.sql.{DataFrame, SparkSession}

object RunnerV0 {
  def main(args: Array[String]): Unit = {

    val options = new Options()

    options.addOption("opt1", true, "opt1-details")
    options.addOption("opt2", true, "opt2-details")
    options.addOption("opt3", true, "opt3-details")

    val parser = new BasicParser()
    val job_args = parser.parse(options, args)

    var opt1 = new String()
    var opt2 = new String()
    var opt3 = new String()

    try {
      opt1 = job_args.getOptionValue("opt1")
      opt2 = job_args.getOptionValue("opt2")
      opt3 = job_args.getOptionValue("opt3")
    } catch {
      case exp: Exception =>
        System.err.println("Parsing failed. Reason: " + exp.getMessage)
    }

    val spark = SparkSession.builder.getOrCreate()
    import spark.implicits._

    // Random spark code, replace with own
    val rdd = spark.sparkContext.parallelize(Array(1,2,3,4,5))
    println(rdd.take(5))
  }
}
