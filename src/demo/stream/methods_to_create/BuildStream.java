package demo.stream.methods_to_create;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BuildStream {
    public static void main(String[] args) throws IOException {
        System.out.println("Test buildStream start");

        // Creation Stream from values
        Stream<String> streamFromValues = Stream.of("a1", "a2", "a3");
        System.out.println("Stream from value " +streamFromValues.collect(Collectors.toList()));

        // Creation from array
        String[] array = {"arr1", "arr2", "arr3"};
        Stream<String> streamFromArray = Arrays.stream(array);
        System.out.println("Stream from array: " +streamFromArray.collect(Collectors.toList()));

        // Creation from file (each entry will be a different line in the stream)
        File file = new File("source.txt");
        Stream<String> streamFromFile = Files.lines(Paths.get(file.getAbsolutePath()));
        System.out.println("Stream from file: " +streamFromFile.collect(Collectors.toList()));

        // Creation stream from collection
        Collection<String> collection = Arrays.asList("Col1", "Col2", "Col3");
        Stream<String> streamFromCollection = collection.stream();
        System.out.println("Stream from collection: " +streamFromCollection.collect(Collectors.toList()));

        // Creation number stream from the line
        IntStream streamFromString = "123".chars();
        System.out.print("Stream from string: ");
        streamFromString.forEach((num) -> System.out.print(num+ ", "));
        System.out.println();

        // Creation by helping Stream.builder()
        Stream.Builder<String> builer = Stream.builder();
        Stream<String> streamFromBuilder = builer.add("builder1").add("build2").add("build3").build();
        System.out.println("Stream from builder: " +streamFromBuilder.collect(Collectors.toList()));

        // Infinity.streams()
        // Stream iterate
        Stream<Integer> streamFromIterate = Stream.iterate(1, n -> n+2);
        System.out.println("Stream from iterate: " +streamFromIterate.limit(3).collect(Collectors.toList()));

        // Stream.generate()
        Stream<String> streamFromGenerate = Stream.generate(() ->"gen1");
        System.out.println("Stream from generate: " + streamFromGenerate.limit(4).collect(Collectors.toList()));

        // Empty stream
        Stream<String> emptyStream = Stream.empty();
        System.out.println("Empty sream: " +emptyStream.collect(Collectors.toList()));

        // Parallel stream
        Stream<String> parallelStream = collection.parallelStream();
        System.out.println("Parallel stream: " +parallelStream.collect(Collectors.toList()));

    }
}
