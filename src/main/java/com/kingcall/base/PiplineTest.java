package com.kingcall.base;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.coders.VarIntCoder;
import org.apache.beam.sdk.testing.PAssert;
import org.apache.beam.sdk.testing.TestPipeline;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname PiplineTest
 * @Date 2019/7/15 23:09
 * @Created by kingcall
 * @Description TODO
 */
class EvenNumberFn extends DoFn<Integer, Integer> {
    @ProcessElement
    public void processElement(@Element Integer in, OutputReceiver<Integer> out) {
        if (in % 2 == 0) {
            out.output(in);
        }
    }
}
public class PiplineTest {
    static final List<Integer> INPUTS = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    public static void main(String[] args) {
        Pipeline p = TestPipeline.create();
        PCollection<Integer> input = p.apply(Create.of(INPUTS)).setCoder(VarIntCoder.of());
        PCollection<String> output = input.apply(ParDo.of(new EvenNumberFn()));
        PAssert.that(output).containsInAnyOrder(2, 4, 6, 8, 10);

    }
}
