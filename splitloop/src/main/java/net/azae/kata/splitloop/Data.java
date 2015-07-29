package net.azae.kata.splitloop;

class Data {
    private final int age;
    private final int salary;


    Data(int age, int salary) {
        this.age = age;
        this.salary = salary;
    }

    Data(double age, double salary) {
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

