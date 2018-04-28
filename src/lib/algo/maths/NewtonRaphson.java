package lib.algo.maths;

/**
 * @author Manish Singh
 */
public class NewtonRaphson {

    private double guess;

    public NewtonRaphson(double guess) {
        this.guess = guess;
    }

    /**
     * Solves equation of the form: a * x * x + b * x + c = k
     */
    public double solveQuadratic(double a, double b, double c, double k) {
        double x = 0, x1 = guess;
        do {
            x = x1;
            double fx = 0, f1x = 0;
            fx = a * x * x + b * x + c - k;
            f1x = 2 * a * x + b;
            x1 = x - fx / f1x;
        } while (Math.abs(x1 - x) > 0.01);
        x = x1;
        return x;
    }

    /**
     * Solves equation of the form: a * x * x * x + b * x * x + c * x + d = k
     */
    public double solveCubic(double a, double b, double c, double d, double k) {
        double x = 0, x1 = guess;
        do {
            x = x1;
            double fx = 0, f1x = 0;
            fx = a * x * x * x + b * x * x + c * x + d - k;
            f1x = 3 * a * x * x + 2 * b * x + c;
            x1 = x - fx / f1x;
        } while (Math.abs(x1 - x) > 0.01);
        x = x1;
        return x;
    }
}
