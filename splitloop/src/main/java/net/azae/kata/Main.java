package net.azae.kata;

import java.text.ParseException;

class Main {

    private static Data[] createData() {
        final Data[] data = new Data[10000];
        for (int i = 0; i < data.length; i++) {
            data[i] = new Data(10, 42);
        }
        return data;
    }

    private static void singleLoop(final Data[] data) {
        final long startTime = System.nanoTime();
        double averageAge = 0;
        long totalSalary = 0;
        for (Data entry: data) {
            averageAge += entry.getAge();
            totalSalary += entry.getSalary();
        }
        final long endTime = System.nanoTime();
        System.out.println("single loop execution time: " + (endTime - startTime) );
        System.out.println(averageAge);
        System.out.println(totalSalary);
    }

    private static void splittedLoop(final Data[] data) {
        final long startTime = System.nanoTime();
        double averageAge = 0;
        for (Data entry: data) {
            averageAge += entry.getAge();
        }

        long totalSalary = 0;
        for (Data entry: data) {
            totalSalary += entry.getSalary();
        }
        final long endTime = System.nanoTime();
        System.out.println("splitted loop execution time: " + (endTime - startTime) );
        System.out.println(averageAge);
        System.out.println(totalSalary);
    }

    public static void main(final String[] args) throws ParseException {
        final Data[] data = createData();
        singleLoop(data);
        splittedLoop(data);
    }
}

