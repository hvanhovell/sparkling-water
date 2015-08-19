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

package org.apache.spark.sql

import org.apache.spark.h2o.{H2OContext, H2OSchemaUtils}
import org.apache.spark.rdd.H2OSchemaRDD
import water.fvec.H2OFrame

/**
 * Utilities to create a Spark DataFrame from an H2O Frame.
 */
object H2ODataFrameUtils {
  def createH2OSchemaRDD(fr: H2OFrame, h2OContext: H2OContext, sqlContext: SQLContext): DataFrame = {
    val h2oSchemaRDD = new H2OSchemaRDD(h2OContext, fr)
    sqlContext.internalCreateDataFrame(h2oSchemaRDD, H2OSchemaUtils.createSchema(fr))
  }
}
