package com.example.jooq;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.mllib.linalg.Vector;
import org.apache.spark.mllib.linalg.Vectors;
import org.apache.spark.mllib.linalg.distributed.RowMatrix;
import org.apache.spark.mllib.regression.LinearRegressionModel;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.mllib.regression.LinearRegressionWithSGD;
import org.apache.spark.mllib.stat.MultivariateStatisticalSummary;
import org.apache.spark.sql.SparkSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class SparkTest {

    @Test
    public void test() {

        System.setProperty("hadoop.home.dir", "d:\\spark-data\\");

        SparkSession spark = SparkSession
                .builder()
                .appName("JavaWordCount")
                .master("local[*]")
                .config("spark.sql.warehouse.dir", "file:///d:/java_workspace4/jooq-gradle/spark-warehouse")
                .getOrCreate();

        JavaSparkContext jsc = new JavaSparkContext(spark.sparkContext());

        jsc.textFile("D:\\java_workspace4\\jooq-gradle\\spark-warehouse\\example.txt");

        JavaRDD<String> housingLines = jsc.textFile("d:/spark-data/bin/house.txt", 6);
        JavaRDD<Vector> housingVals = housingLines.map((String x) -> {
            String[] arr = x.split(",");
            double[] darr = new double[arr.length];
            for (int i = 0; i < arr.length; i++)
                darr[i] = Double.parseDouble(arr[i].trim());
            return Vectors.dense(darr);
        });

        System.out.println("\nSection 7.4.1\n");

        RowMatrix housingMat = new RowMatrix(housingVals.rdd());
        MultivariateStatisticalSummary housingStats = housingMat.computeColumnSummaryStatistics();
        housingStats.min();
        Vector vectors= Vectors.dense(5.0,6.0,7.0,8.0);

        spark.stop();

    }
}
