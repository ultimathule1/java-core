package ru.sorokin.javacore.hw.streamapi;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(List.of(
                new Product(1L, "\"1984\" by George Orwell", ProductCategory.BOOK.getName(), new BigDecimal("109.99")),
                new Product(2L, "\"To Kill a Mockingbird\" by Harper Lee", ProductCategory.BOOK.getName(), new BigDecimal("18.99")),
                new Product(3L, "\"Pride and Prejudice\" by Jane Austen", ProductCategory.BOOK.getName(), new BigDecimal("9.90")),
                new Product(4L, "Children's fruit mixture Heins fruity", ProductCategory.CHILDREN_CATEGORY.getName(), new BigDecimal("4.29")),
                new Product(5L, "children's apple juice Agusha", ProductCategory.CHILDREN_CATEGORY.getName(), new BigDecimal("2.29")),
                new Product(6L, "Diapers for children Hagis", ProductCategory.CHILDREN_CATEGORY.getName(), new BigDecimal("9.49")),
                new Product(7L, "Hammer", ProductCategory.TOYS.getName(), new BigDecimal("8.99")),
                new Product(8L, "Car Toy Porsche", ProductCategory.TOYS.getName(), new BigDecimal("13.99")),
                new Product(9L, "Barby doll", ProductCategory.TOYS.getName(), new BigDecimal("11.79")),
                new Product(10L, "\"The Great Gatsby\" by F. Scott Fitzgerald", ProductCategory.BOOK.getName(), new BigDecimal("16.99")),
                new Product(11L, "baby powder", ProductCategory.CHILDREN_CATEGORY.getName(), new BigDecimal("7.99")),
                new Product(12L, "laser gun", ProductCategory.TOYS.getName(), new BigDecimal("14.99"))
        ));

        Set<Order> orders1 = new HashSet<>(List.of(
                new Order(1L, LocalDate.of(2024,2,1),
                        LocalDate.of(2024, 2, 1), "delivered",
                            new HashSet<>(List.of(products.get(1), products.get(3)))),

                new Order(2L, LocalDate.of(2024, 3, 14),
                        LocalDate.of(2024, 3, 16), "shipped",
                        new HashSet<>(List.of(products.get(0), products.get(4)))),

                new Order(3L, LocalDate.of(2024, 12, 12),
                        LocalDate.of(2024, 12, 13), "pending",
                        new HashSet<>(List.of(products.get(2), products.get(5), products.get(8)))),

                new Order(4L, LocalDate.of(2024, 2, 27),
                        LocalDate.of(2024, 2, 28), "out for delivery",
                        new HashSet<>(List.of(products.get(1), products.get(7), products.get(10)))),

                new Order(5L, LocalDate.of(2024, 3, 12),
                        LocalDate.of(2024, 3, 12), "canceled",
                        new HashSet<>(List.of(products.get(3), products.get(9), products.get(11))))
        ));

        Set<Order> orders2 = new HashSet<>(List.of(
                new Order(6L, LocalDate.of(2024, 7, 13),
                        LocalDate.of(2024, 7, 14), "shipped",
                        new HashSet<>(List.of(products.get(0), products.get(4), products.get(6)))),

                new Order(7L, LocalDate.of(2024, 10, 12),
                        LocalDate.of(2024, 10, 13), "processing",
                        new HashSet<>(List.of(products.get(5), products.get(7)))),

                new Order(8L, LocalDate.of(2024, 10, 11),
                        LocalDate.of(2024, 10, 12), "out for delivery",
                        new HashSet<>(List.of(products.get(2), products.get(8), products.get(10)))),

                new Order(9L, LocalDate.of(2024, 2, 1),
                        LocalDate.of(2024, 2, 1), "returned",
                        new HashSet<>(List.of(products.get(9), products.get(11)))),

                new Order(10L, LocalDate.of(2024, 2, 9),
                        LocalDate.of(2024, 2, 19), "pending",
                        new HashSet<>(List.of(products.get(1), products.get(3), products.get(7))))

        ));

        Set<Order> orders3 = new HashSet<>(List.of(
                new Order(11L, LocalDate.of(2024, 2, 12),
                        LocalDate.of(2024, 2, 13), "pending",
                        new HashSet<>(List.of(products.get(2), products.get(5), products.get(8)))),

                new Order(12L, LocalDate.of(2024, 2, 2),
                        LocalDate.of(2024, 2, 3), "delivered",
                        new HashSet<>(List.of(products.get(1), products.get(7), products.get(10)))),

                new Order(13L, LocalDate.of(2024, 1, 10),
                        LocalDate.of(2024, 1, 11), "processing",
                        new HashSet<>(List.of(products.get(0), products.get(4), products.get(6)))),

                new Order(14L, LocalDate.of(2024, 2, 17),
                        LocalDate.of(2024, 2, 20), "canceled",
                        new HashSet<>(List.of(products.get(3), products.get(9), products.get(11)))),

                new Order(15L, LocalDate.of(2024, 4, 6),
                        LocalDate.of(2024, 4, 6), "shipped",
                        new HashSet<>(List.of(products.get(2), products.get(5), products.get(7))))
        ));

        Set<Order> orders4 = new HashSet<>(List.of(
                new Order(16L, LocalDate.of(2024, 10, 11),
                        LocalDate.of(2024, 10, 12), "out for delivery",
                        new HashSet<>(List.of(products.get(1), products.get(7), products.get(10)))),

                new Order(17L, LocalDate.of(2024, 2, 10),
                        LocalDate.of(2024, 2, 11), "shipped",
                        new HashSet<>(List.of(products.get(2), products.get(5)))),

                new Order(18L, LocalDate.of(2024, 3, 14),
                        LocalDate.of(2024, 3, 15), "pending",
                        new HashSet<>(List.of(products.get(0), products.get(6), products.get(8)))),

                new Order(19L, LocalDate.of(2024, 2, 3),
                        LocalDate.of(2024, 2, 4), "delivered",
                        new HashSet<>(List.of(products.get(3), products.get(9), products.get(11)))),

                new Order(20L, LocalDate.of(2024, 10, 7),
                        LocalDate.of(2024, 10, 8), "canceled",
                        new HashSet<>(List.of(products.get(4), products.get(10), products.get(11))))
        ));

        Set<Order> orders5 = new HashSet<>(List.of(
                new Order(21L, LocalDate.of(2024, 10, 10),
                        LocalDate.of(2024, 10, 11), "canceled",
                        new HashSet<>(List.of(products.get(3)))),

                new Order(22L, LocalDate.of(2024, 2, 9),
                        LocalDate.of(2024, 2, 10), "shipped",
                        new HashSet<>(List.of(products.get(2), products.get(5)))),

                new Order(23L, LocalDate.of(2024, 3, 14),
                        LocalDate.of(2024, 3, 14), "out for delivery",
                        new HashSet<>(List.of(products.get(0), products.get(7), products.get(10)))),

                new Order(24L, LocalDate.of(2024, 3, 7),
                        LocalDate.of(2024, 3, 8), "pending",
                        new HashSet<>(List.of(products.get(1), products.get(4), products.get(6)))),

                new Order(25L, LocalDate.of(2024, 2, 6),
                        LocalDate.of(2024, 2, 7), "delivered",
                        new HashSet<>(List.of(products.get(8), products.get(9), products.get(2))))
        ));

        Set<Customer> customers = new HashSet<>(List.of(
                new Customer(1L, "Krikun", 1L, orders1),
                new Customer(2L, "Ivanov", 2L, orders2),
                new Customer(3L, "Petrov", 2L, orders3),
                new Customer(4L, "Sidorov", 1L, orders4),
                new Customer(5L, "Smirnov", 3L, orders5)
        ));

        //1
        List<Product> expensiveBooks = completeTask1(customers);
        printCompletedTask(expensiveBooks, 1);

        //2
        List<Order> task2 = completeTask2(customers);
        printCompletedTask(task2, 2);

        //3
        Map<List<Product>, Double> task3 = completeTask3(customers);
        printCompletedTaskWithMap(task3, 3);

        //4
        List<Product> task4 = completeTask4(customers);
        System.out.println(task4.size());
        printCompletedTask(task4, 4);

        //5
        List<Product> task5 = completeTask5(customers);
        printCompletedTask(task5, 5);

        //6
        List<Order> task6 = completeTask6(customers);
        printCompletedTask(task6, 6);

        //7
        List<Order> task7 = completeTask7(customers);
        printCompletedTask(task7, 7);

        //8
        BigDecimal task8 = completeTask8(customers);
        System.out.println("task 8 sum: " + task8);

        //9
        BigDecimal task9 = completeTask9(customers);
        System.out.println("task 9 average: " + task9);

        //10
        StatisticsTask10 task10 = completeTask10(customers);
        System.out.println("task 10: " + task10);

        //11
        Map<Long, Integer> task11 = completeTask11(customers);
        printCompletedTaskWithMap(task11, 11);

        //12
        Map<Customer, List<Order>> task12 = completeTask12(customers);
        printCompletedTaskWithMap(task12, 12);

        //13
        Map<Order, BigDecimal> task13 = completeTask13(customers);
        printCompletedTaskWithMap(task13, 13);

        //14
        Map<String, List<String>> task14 = completeTask14(customers);
        printCompletedTaskWithMap(task14, 14);

        //15
        Map<String, Product> task15 = completeTask15(customers);
        printCompletedTaskWithMap(task15, 15);
    }

    public static List<Product> completeTask1(Set<Customer> customers) {
        return customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(ords -> ords.getProducts().stream())
                .filter(product -> product.getCategory().equals(ProductCategory.BOOK.getName()))
                .filter(book -> book.getPrice().compareTo(new BigDecimal("100.00")) >= 0)
                .distinct()
                .toList();
    }

    public static List<Order> completeTask2(Set<Customer> customers) {
        return customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getProducts().stream()
                        .anyMatch(product -> product.getCategory()
                                .equals(ProductCategory.CHILDREN_CATEGORY.getName()))
                )
                .distinct()
                .toList();
    }

    public static Map<List<Product>, Double> completeTask3(Set<Customer> customers) {
        List<Product> productsToysWithDiscount = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> product.getCategory().equals(ProductCategory.TOYS.getName()))
                .distinct()
                .toList();

        BigDecimal value = productsToysWithDiscount.stream()
                .map(product -> product.getPrice().subtract(product.getPrice().multiply(new BigDecimal("0.1"))))
                .reduce(new BigDecimal("0.0"), BigDecimal::add);

        Map<List<Product>, Double> map =  new HashMap<>();
        map.put(productsToysWithDiscount, value.doubleValue());

        return map;
    }

    public static List<Product> completeTask4(Set<Customer> customers) {
        return customers.stream()
                .filter(customer -> customer.getLevel().equals(2L))
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getOrderDate().isAfter(LocalDate.of(2024,2, 1))
                    && order.getOrderDate().isBefore(LocalDate.of(2024, 4, 1))
                )
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .toList();
    }

    public static List<Product> completeTask5(Set<Customer> customers) {
        return customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> product.getCategory().equals(ProductCategory.BOOK.getName()))
                .distinct()
                .sorted(Comparator.comparing(Product::getPrice))
                .limit(2)
                .toList();
    }

    public static List<Order> completeTask6(Set<Customer> customers) {
        return customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(3)
                .distinct()
                .toList();
    }

    public static List<Order> completeTask7(Set<Customer> customers) {
        return customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getOrderDate().isEqual(LocalDate.of(2024, 3, 15)))
                .peek(order -> System.out.println("id: " + order.getId()))
                .toList();
    }

    public static BigDecimal completeTask8(Set<Customer> customers) {
        return customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getOrderDate().getMonth().equals(Month.FEBRUARY))
                .flatMap(order -> order.getProducts().stream())
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static BigDecimal completeTask9(Set<Customer> customers) {
        List<BigDecimal> tempList = customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> order.getOrderDate().isEqual(LocalDate.of(2024, Month.MARCH, 14)))
                .map(order -> order.getProducts().stream()
                        .map(Product::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                    )
                .toList();

        return (tempList.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add)
               )
               .divide(new BigDecimal(tempList.size()), RoundingMode.HALF_UP);
    }

    public static StatisticsTask10 completeTask10(Set<Customer> customers) {
        return customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .filter(product -> product.getCategory().equals(ProductCategory.BOOK.getName()))
                .map(Product::getPrice)
                .collect(Collectors.teeing(
                        Collectors.reducing(BigDecimal.ZERO, BigDecimal::add),
                        Collectors.summarizingDouble(BigDecimal::doubleValue),
                        (sum, stat) -> new StatisticsTask10
                                (sum,
                                 new BigDecimal(String.valueOf(stat.getMax())),
                                 new BigDecimal(String.valueOf(stat.getMin())),
                                 stat.getCount()
                                )
                        )
                );
    }

    public static Map<Long, Integer> completeTask11(Set<Customer> customers) {
        return customers.stream()
                .flatMap(x -> x.getOrders().stream())
                .collect(Collectors.toMap(
                        Order::getId,
                        x2 -> x2.getProducts().size()
                ));
    }

    public static Map<Customer, List<Order>> completeTask12(Set<Customer> customers) {
        return customers.stream()
                .collect(Collectors.toMap(
                        customer -> customer,
                        x -> x.getOrders().stream().toList()
                ));
    }

    public static Map<Order, BigDecimal> completeTask13(Set<Customer> customers) {
        return customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .collect(Collectors.toMap(
                        order -> order,
                        order -> order.getProducts().stream()
                                .map(Product::getPrice)
                                .reduce(BigDecimal.ZERO, BigDecimal::add)
                ))
        ;
    }

    public static Map<String, List<String>> completeTask14(Set<Customer> customers) {
        return customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.mapping(Product::getName,
                                Collectors.collectingAndThen(
                                        Collectors.toSet(),
                                        ArrayList::new
                                ))
                ))
        ;
    }

    public static Map<String, Product> completeTask15(Set<Customer> customers) {
        return customers.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Product::getPrice)),
                                x -> x.orElseThrow(() -> new IllegalStateException("No products found for category"))
                        )
                ))
        ;
    }

    public static void printCompletedTask(Collection<?> collection, int taskNumber) {
        System.out.println();
        System.out.println(taskNumber + " task:");
        collection.forEach(x -> System.out.println(x + "\n"));
        System.out.println();
    }

    public static void printCompletedTaskWithMap(Map<?, ?> map, int taskNumber) {
        System.out.println();
        System.out.println(taskNumber + " task:");
        map.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println();
    }
}

class StatisticsTask10 {
    private final BigDecimal sum;
    private final BigDecimal avg;
    private final BigDecimal max;
    private final BigDecimal min;
    private final long count;

    public StatisticsTask10(BigDecimal sum, BigDecimal max, BigDecimal min, long count) {
        this.sum = sum;
        this.max = max;
        this.min = min;
        this.count = count;
        this.avg = calculateAvg();
    }

    public BigDecimal getSum() {
        return sum;
    }

    public BigDecimal getMax() {
        return max;
    }

    public BigDecimal getMin() {
        return min;
    }

    public long getCount() {
        return count;
    }

    public BigDecimal getAverage() {
        return avg;
    }

    private BigDecimal calculateAvg() {
        return count <= 0 ? BigDecimal.ZERO : sum.divide(new BigDecimal(count), RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return "StatisticsTask10{" +
                "sum=" + sum +
                ", avg=" + avg +
                ", max=" + max +
                ", min=" + min +
                ", count=" + count +
                '}';
    }
}