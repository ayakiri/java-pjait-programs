package com.pjatk.example.mathutils;

public class MathUtils {

    /*
        Funkcja oblicza n!
     */
    public static int factorial(int n){
        Integer factorial = 1;
        for(int i = 1; i <= n; i++){
            factorial *= i;
        };
        return factorial;
    }

    /*
        Funkcja oblicza n! (zastosować rekurencję)
     */
    public static int factorialRecursive(int n){
        Integer factorial = multiplyFractorial(n);
        return factorial;
    }
    public static int multiplyFractorial(int n){
        if(n == 1 || n == 0){
            return 1;
        } else {
            return (n * multiplyFractorial(n-1));
        }
    }

    /*
        Funkcja oblicza przyblożoną całkę oznaczoną od a do b dla wielomiany o podanych w tabeli współczunnikach
        (całka oznaczona to pole powierzchni pod wykresem wielomianu na przedziale [a,b])
     */

    // wychodzi mi albo 0.0 albo NaN :C
    public static double integralOfPolynomial(double[] coefficients,double a, double b){
        // get f from b
        double[] polynomialOfB;
        polynomialOfB = countPolynomial(coefficients, b);

        // get f from a
        double[] polynomialOfA;
        polynomialOfA = countPolynomial(coefficients, a);

        Double sum = sumPolynomial(polynomialOfB) - sumPolynomial(polynomialOfA);

        return sum;
    }

    public static double[] countPolynomial(double[] coefficients, double n){
        double[] polynomialOfN = new double[coefficients.length];
        for(int i = 0; i < coefficients.length; i++){
            polynomialOfN[i] = (coefficients[i] * Math.pow(n, i+1)) / (n+1);
        }
        return polynomialOfN;
    }

    public static double sumPolynomial(double[] polynomialOfN){
        Double sum = 0.0;
        for(int i = 0; i < polynomialOfN.length; i++){
            sum = sum + polynomialOfN[i];
        }
        return sum;
    }

    /*
        Funkcja przedstawia nieskracalny ułamek w postaci a/b
        np. dla 9/12 zwróci "3/4"
                15/5 zwróci "3"
     */
    public static String simplifyFractionInString(int meter, int denominator){
        // check greater num
        Integer greaterNum;
        if(meter >= denominator){
            if(meter%denominator==0) {
                return Integer.toString(meter/denominator);
            };
            greaterNum = meter;
        } else {
            greaterNum = denominator;
        }
        // go thru every num from num to 1, and div where possible
        for(int i = ((greaterNum*2)-greaterNum); i > 1; i--){
            if(meter%i==0 && denominator%i==0){
                meter = meter/i;
                denominator = denominator/i;
            }
        };
        String fraction = Integer.toString(meter) + "/" + Integer.toString(denominator);
        return fraction;
    }

}
