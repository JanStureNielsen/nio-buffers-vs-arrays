/*
 * Copyright 2014 Parity authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nio.buffers.vs.arrays;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 3, jvmArgsAppend = {"-XX:+UseParallelGC", "-Xms1G", "-Xmx1G"})
@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.SampleTime)
public class BufferVsArrayBenchmark {

    private static String data = 
            """
            This is a block of data for the input stream.
            This is a block of data for the input stream.
            This is a block of data for the input stream.
            This is a block of data for the input stream.
            This is a block of data for the input stream.
            """;

    private static InputStream is = _inputStream(data);

    private static InputStream _inputStream(String data) {
        InputStream is = null;
        try {
            is = new ByteArrayInputStream(data.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
        }

        return is;
    }

    @Setup(Level.Iteration)
    public void prepare() {
    }

    @Benchmark
    public void add() {
    }

}
