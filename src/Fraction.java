public class Fraction {
    private int numerator;
    private int denominator;

    // Конструктор
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть нулем");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Геттеры и сеттеры
    public int getNumerator() { return numerator; }
    public void setNumerator(int numerator) { this.numerator = numerator; }

    public int getDenominator() { return denominator; }
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть нулем");
        }
        this.denominator = denominator;
    }

    // Методы для работы с дробями
    public Fraction sum(Fraction other) {
        int newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator / gcd(newNumerator, newDenominator), newDenominator / gcd(newNumerator, newDenominator));
    }

    public Fraction subtract(Fraction other) {
        int newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator / gcd(newNumerator, newDenominator), newDenominator / gcd(newNumerator, newDenominator));
    }

    public Fraction multiply(Fraction other) {
        int newNumerator = this.numerator * other.numerator;
        int newDenominator = this.denominator * other.denominator;
        return new Fraction(newNumerator / gcd(newNumerator, newDenominator), newDenominator / gcd(newNumerator, newDenominator));
    }

    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        int newNumerator = this.numerator * other.denominator;
        int newDenominator = this.denominator * other.numerator;
        return new Fraction(newNumerator / gcd(newNumerator, newDenominator), newDenominator / gcd(newNumerator, newDenominator));
    }

    // Метод для получения строкового представления
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Метод для нахождения НОК
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Метод для упрощения дроби
    public void simplify() {
        int common = gcd(this.numerator, this.denominator);
        this.numerator /= common;
        this.denominator /= common;
    }
}