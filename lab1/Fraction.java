public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.simplify();
    }

    public void simplify() {
        if (this.denominator == this.numerator) {
            this.denominator = 1;
            this.numerator = 1;
        }
        if (this.denominator == -this.numerator) {
            this.denominator = 1;
            this.numerator = -1;
        }
        if (this.denominator < 0) {
            this.denominator = -this.denominator;
            this.numerator = -this.denominator;
        }
        int gcd = gcd(this.numerator, this.denominator);
        this.numerator = this.numerator / gcd;
        this.denominator = this.denominator / gcd;
    }

    public void setNumer(int numerator) {
        this.numerator = numerator;
    }

    public int getNumer() {
        return this.numerator;
    }
    
    public void setDenom(int denominator) {
        if (denominator != 0) {
            this.denominator = denominator;
        }
    }

    public int getDenom() {
        return this.denominator;
    }

    public static Fraction fracPlus(Fraction frac1, Fraction frac2) {
        Fraction result = new Fraction();
        prepDenom(frac1, frac2);

        result.setDenom(frac1.getDenom());
        result.setNumer(frac1.getNumer() + frac2.getNumer());
        result.simplify();
        frac1.simplify();
        frac2.simplify();
        return result;
    }

    public static Fraction fracMinus(Fraction frac1, Fraction frac2) {
        Fraction result = new Fraction();
        prepDenom(frac1, frac2);

        result.setDenom(frac1.getDenom());
        result.setNumer(frac1.getNumer() - frac2.getNumer());
        result.simplify();
        frac1.simplify();
        frac2.simplify();
        return result;
    }

    public static void prepDenom(Fraction frac1, Fraction frac2) {
        int den1 = frac1.getDenom();
        int den2 = frac2.getDenom();
        int lcm_den = lcm(den1, den2);
        
        frac1.setDenom(lcm_den);
        frac2.setDenom(lcm_den);
        frac1.setNumer(frac1.getNumer() * den2);
        frac2.setNumer(frac2.getNumer() * den1);
    }

    public static Fraction fracMultiply(Fraction frac1, Fraction frac2) {
        Fraction result = new Fraction();
        result.setDenom(frac1.getDenom() * frac2.getDenom());
        result.setNumer(frac1.getNumer() * frac2.getNumer());
        result.simplify();
        return result;
    }

    public static Fraction fracDivide(Fraction frac1, Fraction frac2) {
        Fraction result = new Fraction();
        result.setNumer(frac1.getNumer() * frac2.getDenom());
        result.setDenom(frac1.getDenom() * frac2.getNumer());
        result.simplify();
        return result;
    }

    public static int gcd(int a, int b) {
        int t = 0;
        while (b != 0) {
            t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return (Math.abs(a) / gcd(a, b)) * Math.abs(b);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.numerator + " / " + this.denominator;
    }
}
