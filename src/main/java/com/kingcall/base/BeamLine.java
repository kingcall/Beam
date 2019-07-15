package com.kingcall.base;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;

public class BeamLine {
    public static void main(String[] args) {
        /**
         * 怎么运行pipline 是在本地运行还是spark 或者 flink 上
         */
        PipelineOptions options = PipelineOptionsFactory.create();
        Pipeline p = Pipeline.create(options);

    }
}
