package net.azae.kata.splitloop;

class Data {
    private final int age;
    private final int salary;


    Data(final int age, final int salary) {
        this.age = age;
        this.salary = salary;
    }

    Data(final double age, final double salary) {
        this.age = (int) Math.round(age);
        this.salary = (int) Math.round(salary);
    }

    public int getAge() {
        return age;
    }


    public int getSalary() {
        return salary;
    }
}

