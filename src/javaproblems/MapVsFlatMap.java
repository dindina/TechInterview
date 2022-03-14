package javaproblems;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapVsFlatMap {
    public static void main(String[] args) throws IOException {
        List<String> stringList = new ArrayList<>();
        stringList.add("Dinesh good boy");
        stringList.add("Avini and AMi good girls");

        List<String> all  = stringList.stream().map(item -> item.split("").toString()).collect(Collectors.toList());
        System.out.println(all);

        List<List<String>> stringList1 = new ArrayList<>();
        stringList1.add(Arrays.asList("Dinesh good boy"));
        stringList1.add(Arrays.asList("Avini and AMi good girls"));
        //List<String> all1 = stringList.stream().map(item1-> item1.toUpperCase()).flatMap(item -> Arrays.stream(item.split("")).map(item1->item1.toUpperCase())).collect(Collectors.toList());
        //List<String> newlist = stringList1.stream().flatMap(list -> list.stream().collect(Collectors.toList())).collect(Collectors.toList());

        //System.out.println(newlist);
        String input = "dog,cat,bird";
        Stream<String> stream = Arrays.stream(input.split( "," ));
        stream.forEach(System.out::println);

        Path path = Paths.get("src/javaproblems", "MapVsFlatMap.java");
        try (Stream<String> lines = Files.lines(path)) {
            List<String> strings = lines.flatMap(l -> Arrays.stream(l.split("\n"))).map(String::trim)
                    .collect(Collectors.toCollection(LinkedList::new));
            System.out.println(strings);
        }

    }

}
