/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.gihyo.spark.ch03.basic_transformation

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

// scalastyle:off println

object SampleExample {
  def main(args: Array[String]) {
    Logger.getLogger("org").setLevel(Level.WARN)

    val conf = new SparkConf().setAppName("SampleExample")
    val sc = new SparkContext(conf)

    run(sc)
    sc.stop()
  }

  def run(sc: SparkContext) {
    val fruits = sc.parallelize(Array("Apple", "Orange", "Peach", "Orange", "PineApple", "Orange"))
    val samples = fruits.sample(withReplacement = false, 0.5, 1)

    println(s"""fruits:  ${fruits.collect().mkString(", ")}""")
    println(s"""samples: ${samples.collect().mkString(", ")}""")
  }
}

// scalastyle:on println
