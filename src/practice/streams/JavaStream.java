package practice.streams;

import jdk.nashorn.internal.ir.annotations.Immutable;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStream {

    class Car{
        String name;
        Double price;

        String country;
        public String toString()
        {
            return name + price+ country;
        }

        Car(String name , Double price){
            this.name=name;
            this.price=price;
        }

        Car(String name , Double price , String Country){
            this.name=name;
            this.price=price;
            this.country=Country;
        }

        Double getPrice()
        {
            return price;
        }

        String getCountry()
        {
            return country;
        }


    }
    public static void main(String[] args) {
        String str = "dineshdinesh";
        // create a character map with key as char , value as count using streams

        Map<String, Long> map = new HashMap<>();

        ArrayList list =str.chars().mapToObj(ch->(char)ch).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(list);

        map = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        //Arrays.asList(str.split("")).stream().collect(Collectors.groupingBy());


    }

    @Test
    public void getMaxMinInArray()
    {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(100);

        Integer min = list.stream().min(Comparator.naturalOrder()).get();
        Integer max = list.stream().min(Comparator.reverseOrder()).get();
        System.out.println(max);
        System.out.println(min);

    }

    @Test
    public void removeDuplicates()
    {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(100);
        list.add(100);

        List<Integer> dicticnt = list.stream().distinct().collect(Collectors.toList());
        System.out.println(dicticnt);

    }

    @Test
    public void removeDuplicatesWithSet()
    {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(100);
        list.add(100);

        Set<Integer> dicticnt = list.stream().collect(Collectors.toSet());
        System.out.println(dicticnt);

    }

    @Test
    public void filter()
    {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(100);
        list.add(100);

        List<Integer> integers = list.stream().filter(item->item>2).collect(Collectors.toList());
        System.out.println(integers);

    }

    @Test
    public void map()
    {
        List<String> newList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(100);
        list.add(100);

        list.stream().forEach(item->
                newList.add(item.toString()));
        System.out.println(newList);

    }

    @Test
    public void findAny(){

        Integer[] numbers = {1,3,4,5,6,7,13};
        String str = "dinesh";
        System.out.println(Arrays.stream(numbers).findAny().get());
        Arrays.stream(str.split("")).findAny().get();

    }

    @Test
    public void counting()
    {
        Car car1 = new Car("Tesla",1000.0);
        Car car2 = new Car("Toyota",500.0);List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);

        Double min = cars.stream().mapToDouble(Car::getPrice).min().getAsDouble();
        System.out.println(min);

        Double max = cars.stream().mapToDouble(Car::getPrice).max().getAsDouble();
        System.out.println(max);

        Double avg = cars.stream().mapToDouble(Car::getPrice).average().getAsDouble();
        System.out.println(avg);

        long count = cars.stream().mapToDouble(Car::getPrice).count();
        System.out.println(count);





    }

    @Test
    public void statistics()
    {
        Car car1 = new Car("Tesla",1000.0);
        Car car2 = new Car("Toyota",500.0);List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);

        DoubleSummaryStatistics summaryStatistics = cars.stream().mapToDouble(Car::getPrice).summaryStatistics();
        System.out.println(summaryStatistics.getMin());
        System.out.println(summaryStatistics.getMax());
        System.out.println(summaryStatistics.getAverage());
        System.out.println(summaryStatistics.getSum());
        System.out.println(summaryStatistics.getCount());

    }

    @Test
    public void grouping()
    {
        Car car1 = new Car("Tesla",1000.0,"US");
        Car car2 = new Car("Jeep",700.0,"US");
        Car car3 = new Car("Toyota",500.0,"Japan");
        Car car4 = new Car("Honda",500.0,"Japan");
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);

        Map<String, List<Car>> map = cars.stream().collect(Collectors.groupingBy(Car::getCountry));
        System.out.println(map);

    }

    @Test
    public void groupingAndCounting()
    {
        List<String> list = new ArrayList<>();
        list.add("Dinesh");list.add("Dinesh");
        list.add("Dinesh");
        list.add("Saran");list.add("Saran");

        System.out.println(list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
        System.out.println(list.stream().collect(Collectors.groupingBy(String::toString,Collectors.counting())));

    }

    @Test
    public void reduce()
    {
        Integer[] integers = {1,3,4,};
        Integer reduce = Arrays.stream(integers).reduce(0, (a, b) -> a + b);
        System.out.println(reduce);
        Integer reduce1 = Arrays.stream(integers).reduce(100,Integer::sum);
        System.out.println(reduce1);
    }

    @Test
    public void flatMap()
    {

        List<String> list1 = Arrays.asList("dinesh","dinesh");
        List<String> list2 = Arrays.asList("saran","avini");
        List<String> list3 = Arrays.asList("Ami","Jaya");

        List<List<String >> allList = new ArrayList<>();
        allList.add(list1);
        allList.add(list2);
        allList.add(list3);

        Set<String> set = allList.stream().flatMap(List::stream).collect(Collectors.toSet());
        System.out.println(set);


    }

    @Test
    public void  concatenateString()
    {

        List<String> list1 = Arrays.asList("dinesh","ganesh");

        //System.out.println(list1.stream().collect(Collectors.toList()));

        System.out.println(Optional.of(list1.stream().collect(ArrayList::new, ArrayList::add, ArrayList::addAll)));

        //System.out.println(list1.stream().collect(Collectors.joining(",")));
        //System.out.println(list1.stream().collect(Collectors.joining()));
        //System.out.println(list1.stream().map(String::toUpperCase).collect(Collectors.joining("->","","")));
        Integer integer=2;
        System.out.println(changeInt(integer));
        System.out.println(integer);

    }

    public long changeInt(Integer integer)
    {
        integer=10;
        return integer*integer;
    }





}
