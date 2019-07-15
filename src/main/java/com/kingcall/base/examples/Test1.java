package com.kingcall.base.examples;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.values.PCollection;

/**
 * @Classname Test1
 * @Date 2019/7/15 23:16
 * @Created by kingcall
 * @Description TODO
 */
public class Test1 {
    public static void main(String[] args) {
        // Start by defining the options for the pipeline.
        PipelineOptions options = PipelineOptionsFactory.create();

        // Then create the pipeline.
        Pipeline pipeline = Pipeline.create(options);

        PCollection<String> lines = pipeline.apply(
                "ReadLines", TextIO.read().from("gs://some/inputData.txt"));

        PCollection<String> filteredLines = lines.apply(new FilterLines());

        filteredLines.apply("WriteMyFile", TextIO.write().to("gs://some/outputData.txt"));

        pipeline.run().waitUntilFinish();
    }

}
