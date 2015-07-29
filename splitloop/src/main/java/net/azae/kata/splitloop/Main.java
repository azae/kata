package net.azae.kata.splitloop;

import java.text.ParseException;

class Main {

    private static Data[] createData() {
        final Data[] data = new Data[10000];
        for (int i = 0; i < data.length; i++) {
            data[i] = new Data(Math.random() * 60, Math.random() * 4000 + 1000);
        }
        return data;
    }

    private static void singleLoop(final Data[] data) {
        final long startTime = System.nanoTime();
        double totalAge = 0;
        long totalSalary = 0;
        for (Data entry: data) {
            totalAge += entry.getAge();
            totalSalary += entry.getSalary();
        }
        final long endTime = System.nanoTime();
        System.out.println("single loop execution time: " + (endTime - startTime) / 1000000.0  );
        System.out.println(totalAge/data.length);
        System.out.println(totalSalary/data.length);
    }

    private static void splittedLoop(final Data[] data) {
        final long startTime = System.nanoTime();
        double totalAge = 0;
        for (Data entry: data) {
            totalAge += entry.getAge();
        }

        long totalSalary = 0;
        for (Data entry: data) {
            totalSalary += entry.getSalary();
        }
        final long endTime = System.nanoTime();
        System.out.println("splitted loop execution time: " + (endTime - startTime)/ 1000000.0 );
        System.out.println(totalAge/data.length);
        System.out.println(totalSalary/data.length);
    }

    public static void main(final String[] args) throws ParseException {
        final Data[] data = createData();
        singleLoop(data);
        splittedLoop(data);
    }
}

