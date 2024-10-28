import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Задание 1.3
        Name name1 = new Name("Клеопатра");
        Name name2 = new Name("Александр", "Пушкин", "Сергеевич");
        Name name3 = new Name("Владимир", "Маяковский");

        System.out.println(name1); // Клеопатра
        System.out.println(name2); // Пушкин Александр Сергеевич
        System.out.println(name3); // Маяковский Владимир

        // Задание 1.5
        House house1 = new House(1);
        House house2 = new House(5);
        House house3 = new House(23);

        System.out.println(house1);
        System.out.println(house2);
        System.out.println(house3);

        // Задание 2.4
        Department itDepartment = new Department("IT");
        Employee petrov = new Employee("Петров", itDepartment);
        Employee kozlov = new Employee("Козлов", itDepartment);
        Employee sidorov = new Employee("Сидоров", itDepartment);

        itDepartment.addEmployee(petrov);
        itDepartment.addEmployee(kozlov);
        itDepartment.addEmployee(sidorov);
        itDepartment.setHead(kozlov);

        System.out.println(petrov);
        System.out.println(kozlov);
        System.out.println(sidorov);

        // Задание 3.4
        System.out.println("Сотрудники отдела IT:");
        for (Employee employee : itDepartment.getEmployees()) {
            System.out.println(employee.getLastName());
        }

        // Задание 4.5
        Name name4 = new Name("Клеопатра");
        Name name5 = new Name("Сергеевич", "Александр", "Пушкин");
        Name name6 = new Name("Маяковский", "Владимир");
        Name name7 = new Name("Бонифатьевич", "Христофор");

        System.out.println(name4);
        System.out.println(name5);
        System.out.println(name6);
        System.out.println(name7);

        // Задание 5.5
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Введите числитель первой дроби:");
                int numerator1 = scanner.nextInt();

                System.out.println("Введите знаменатель первой дроби:");
                int denominator1 = scanner.nextInt();

                if (denominator1 == 0) {
                    throw new IllegalArgumentException("Знаменатель не может быть нулем");
                }

                System.out.println("Введите числитель второй дроби:");
                int numerator2 = scanner.nextInt();

                System.out.println("Введите знаменатель второй дроби:");
                int denominator2 = scanner.nextInt();

                if (denominator2 == 0) {
                    throw new IllegalArgumentException("Знаменатель не может быть нулем");
                }

                System.out.println("Введите числитель третьей дроби:");
                int numerator3 = scanner.nextInt();

                System.out.println("Введите знаменатель третьей дроби:");
                int denominator3 = scanner.nextInt();

                if (denominator3 == 0) {
                    throw new IllegalArgumentException("Знаменатель не может быть нулем");
                }

                validInput = true;

                Fraction f1 = new Fraction(numerator1, denominator1);
                Fraction f2 = new Fraction(numerator2, denominator2);
                Fraction f3 = new Fraction(numerator3, denominator3);

                // Вывод результатов операций с другой дробью
                System.out.println("Сложение: " + f1 + " + " + f2 + " = " + f1.sum(f2));
                System.out.println("Вычитание: " + f1 + " - " + f2 + " = " + f1.subtract(f2));
                System.out.println("Умножение: " + f1 + " * " + f2 + " = " + f1.multiply(f2));
                System.out.println("Деление: " + f1 + " / " + f2 + " = " + f1.divide(f2));

                // Выполнение сложной операции
                Fraction result = f1.sum(f2).divide(f3).subtract(5);
                result.simplify();
                System.out.println("(" + f1 + " + " + f2 + ") / " + f3 + " - 5 = " + result);

                break; // Выходим из цикла после успешного ввода

            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка ввода: " + e.getMessage());
                System.out.println("Пожалуйста, повторите ввод.");
            } catch (ArithmeticException e) {
                System.out.println("Арифметическая ошибка: " + e.getMessage());
                System.out.println("Пожалуйста, проверьте знаменатели и попробуйте снова.");
            }
        }
    }
}



