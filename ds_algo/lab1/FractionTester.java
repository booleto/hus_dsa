public class FractionTester {
    public static void main(String[] args) {
        Fraction frac1 = new Fraction(1, 3);
        Fraction frac2 = new Fraction(4, -5);

        System.out.println(Fraction.fracPlus(frac1, frac2));
        System.out.println(Fraction.fracMinus(frac1, frac2));
        System.out.println(Fraction.fracDivide(frac1, frac2));
        System.out.println(Fraction.fracMultiply(frac1, frac2));
    }
}
