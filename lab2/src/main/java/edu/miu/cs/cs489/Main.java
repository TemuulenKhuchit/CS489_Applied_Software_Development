package edu.miu.cs.cs489;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final ObjectMapper MAPPER = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .enable(SerializationFeature.INDENT_OUTPUT)
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    public static void main(String[] args) throws Exception {
        List<Employee> employees = seedData();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Employee Pension CLI ===");
            System.out.println("1) Print ALL employees (JSON)");
            System.out.println("2) Quarterly Upcoming Enrollees (JSON)");
            System.out.println("0) Exit");
            System.out.print("Choose: ");
            switch (sc.nextLine().trim()) {
                case "1" -> printAllEmployees(employees);
                case "2" -> printQuarterlyUpcomingEnrollees(employees);
                case "0" -> { return; }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private static void printAllEmployees(List<Employee> employees) throws Exception {
        var sorted = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getYearlySalary).reversed()
                        .thenComparing(Employee::getLastName))
                .toList();
        System.out.println(MAPPER.writeValueAsString(sorted));
    }

    private static void printQuarterlyUpcomingEnrollees(List<Employee> employees) throws Exception {
        LocalDate[] range = nextQuarterRange(LocalDate.now());
        LocalDate start = range[0], end = range[1];

        var filtered = employees.stream()
                .filter(e -> (e.getPensionPlan() == null || e.getPensionPlan().getEnrollmentDate() == null)
                        && !e.getEmploymentDate().plusYears(3).isBefore(start)
                        && !e.getEmploymentDate().plusYears(3).isAfter(end))
                .sorted(Comparator.comparing(Employee::getEmploymentDate).reversed())
                .toList();

        System.out.printf("Next quarter: %s to %s%n", start, end);
        System.out.println(MAPPER.writeValueAsString(filtered));
    }

    private static LocalDate[] nextQuarterRange(LocalDate today) {
        int q = ((today.getMonthValue() - 1) / 3) + 1;
        int nextQ = (q == 4) ? 1 : q + 1;
        int year = (q == 4) ? today.getYear() + 1 : today.getYear();

        Month startMonth = switch (nextQ) {
            case 1 -> Month.JANUARY;
            case 2 -> Month.APRIL;
            case 3 -> Month.JULY;
            case 4 -> Month.OCTOBER;
            default -> throw new IllegalStateException();
        };
        LocalDate first = LocalDate.of(year, startMonth, 1);
        LocalDate last = first.plusMonths(2).withDayOfMonth(first.plusMonths(2).lengthOfMonth());
        return new LocalDate[]{first, last};
    }

    private static List<Employee> seedData() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1L, "Daniel", "Agar",
                LocalDate.parse("2023-01-17"), 105_945.50,
                new PensionPlan("EX1089", null, 100.00)));
        list.add(new Employee(2L, "Benard", "Shaw",
                LocalDate.parse("2022-09-03"), 197_750.00,
                new PensionPlan(null, LocalDate.parse("2025-09-03"), null)));
        list.add(new Employee(3L, "Carly", "Agar",
                LocalDate.parse("2014-05-16"), 842_000.75,
                new PensionPlan("SM2307", LocalDate.parse("2017-05-17"), 1555.50)));
        list.add(new Employee(4L, "Wesley", "Schneider",
                LocalDate.parse("2023-07-21"), 74_500.00));
        list.add(new Employee(5L, "Anna", "Wiltord",
                LocalDate.parse("2023-03-15"), 85_750.00));
        list.add(new Employee(6L, "Yosef", "Tesfalem",
                LocalDate.parse("2024-10-31"), 100_000.00));
        return list;
    }
}
