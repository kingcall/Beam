package com.kingcall.base;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.DoFn;


public class BeamLine {
    public static void main(String[] args) {
        /**
         * 怎么运行pipline 是在本地运行还是spark 或者 flink 上
         */
        PipelineOptions options = PipelineOptionsFactory.create();
        PipelineOptions options2 =
                PipelineOptionsFactory.fromArgs(args).create();
        options.setRunner(PipelineOptions.DirectRunner.class);
;

        Pipeline p = Pipeline.create(options);

    }
}
