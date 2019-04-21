package com.example.jooq;

//import com.example.spark.BreezeMethods;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaDoubleRDD;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.mllib.linalg.Vectors;
import org.apache.spark.mllib.linalg.Vector;
import org.apache.spark.mllib.linalg.DenseMatrix;
import org.apache.spark.mllib.regression.LinearRegressionWithSGD;
import org.apache.spark.mllib.regression.RidgeRegressionModel;
import org.apache.spark.mllib.linalg.SparseMatrix;
import org.apache.spark.mllib.optimization.LeastSquaresGradient;
import org.apache.spark.mllib.optimization.SquaredL2Updater;
import org.apache.spark.mllib.optimization.GradientDescent;
import org.apache.spark.mllib.optimization.LBFGS;
import org.apache.spark.mllib.stat.Statistics;
import org.apache.spark.mllib.stat.test.KolmogorovSmirnovTestResult;
import org.apache.spark.mllib.tree.RandomForest;
import org.apache.spark.mllib.tree.model.RandomForestModel;
import org.apache.spark.mllib.util.MLUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;
import org.apache.spark.mllib.regression.LassoWithSGD;
import org.apache.spark.mllib.regression.RidgeRegressionWithSGD;
import org.apache.spark.mllib.stat.MultivariateStatisticalSummary;
import org.apache.spark.mllib.regression.LinearRegressionModel;
import org.apache.spark.mllib.evaluation.RegressionMetrics;
import org.apache.spark.mllib.linalg.Matrix;
import org.apache.spark.mllib.regression.LabeledPoint;
import org.apache.spark.mllib.regression.LassoModel;
import org.apache.spark.mllib.feature.StandardScaler;
import org.apache.spark.mllib.feature.StandardScalerModel;
import org.apache.spark.mllib.linalg.Matrices;
import org.apache.spark.mllib.linalg.distributed.RowMatrix;
import org.apache.spark.mllib.linalg.distributed.CoordinateMatrix;

import org.apache.spark.sql.SparkSession;
import scala.Tuple2;

public class SparkTest2 {

    public static void main(String[] args) throws IOException {

        System.setProperty("hadoop.home.dir", "d:\\spark-data\\");

        SparkSession spark = SparkSession
                .builder()
                .appName("JavaWordCount")
                .master("local[*]")
                .config("spark.sql.warehouse.dir", "file:///d:/java_workspace4/jooq-gradle/spark-warehouse")
                .getOrCreate();

        JavaSparkContext jsc = new JavaSparkContext(spark.sparkContext());


        Logger.getLogger("breeze").setLevel(Level.WARN);

/*
        SparkConf conf =
                new SparkConf().setAppName("JavaHypothesisTestingKolmogorovSmirnovTestExample").setMaster("local[*]");
        JavaSparkContext jsc = new JavaSparkContext(conf);
*/

        // Load and parse the data file.
        String datapath = "D:\\java_workspace4\\jooq-gradle\\src\\main\\resources\\static\\sample_libsvm_data.txt";

        JavaRDD<LabeledPoint> data = MLUtils.loadLibSVMFile(jsc.sc(), datapath).toJavaRDD();
        // Split the data into training and test sets (30% held out for testing)
        JavaRDD<LabeledPoint>[] splits = data.randomSplit(new double[]{0.7, 0.3});
        JavaRDD<LabeledPoint> trainingData = splits[0];
        JavaRDD<LabeledPoint> testData = splits[1];

        // Train a RandomForest model.
        // Empty categoricalFeaturesInfo indicates all features are continuous.
        int numClasses = 2;
        Map<Integer, Integer> categoricalFeaturesInfo = new HashMap<>();
        int numTrees = 3; // Use more in practice.
        String featureSubsetStrategy = "auto"; // Let the algorithm choose.
        String impurity = "gini";
        int maxDepth = 5;
        int maxBins = 32;
        int seed = 12345;

        RandomForestModel model = RandomForest.trainClassifier(trainingData, numClasses,
                categoricalFeaturesInfo, numTrees, featureSubsetStrategy, impurity, maxDepth, maxBins,
                seed);

        // Evaluate model on test instances and compute test error
        JavaPairRDD<Double, Double> predictionAndLabel =
                testData.mapToPair(p -> new Tuple2<>(model.predict(p.features()), p.label()));
        double testErr =
                predictionAndLabel.filter(pl -> !pl._1().equals(pl._2())).count() / (double) testData.count();
        System.out.println("Test Error: " + testErr);
        System.out.println("Learned classification forest model:\n" + model.toDebugString());

        // Save and load model
        model.save(jsc.sc(), "target/tmp/myRandomForestClassificationModel");
        RandomForestModel sameModel = RandomForestModel.load(jsc.sc(),
                "target/tmp/myRandomForestClassificationModel");
        // $example off$


        jsc.stop();
    }

}