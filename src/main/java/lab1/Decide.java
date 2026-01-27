package lab1;
public class Decide {

    // ////////////
    // CONSTANT //////////
    public static final double PI = 3.1415926535;

    // //////////// TYPE DECLARATIONS ///////////
    public enum Connectors {
        NOTUSED(777),
        ORR(778),
        ANDD(779);

        private final int value;
        Connectors(int value) { this.value = value; }
    }

    // pointer to an array of 100 doubles
    // represented as double[] in Java

    // pointer to a 2-D array of [15,15] CONNECTORS
    // represented as Connectors[][] in Java

    // always in the range [0..1]
    // represented as boolean in Java (originally typedef int boolean)

    // pointer to a 2-D array of [15,15] booleans
    // represented as boolean[][] in Java

    // pointer to an array of 15 booleans
    // represented as boolean[] in Java

    public enum CompType {
        LT(1111),
        EQ(1112),
        GT(1113);

        private final int value;
        CompType(int value) { this.value = value; }
    }

    // inputs to the DECIDE() function
    public static class ParametersT {
        public double LENGTH1;     // Length in LICs 0, 7, 12
        public double RADIUS1;     // Radius in LICs 1, 8, 13
        public double EPSILON;     // Deviation from PI in LICs 2, 9
        public double AREA1;       // Area in LICs 3, 10, 14
        public int Q_PTS;          // No. of consecutive points in LIC 4
        public int QUADS;          // No. of quadrants in LIC 4
        public double DIST;        // Distance in LIC 6
        public int N_PTS;          // No. of consecutive pts. in LIC 6
        public int K_PTS;          // No. of int. pts. in LICs 7, 12
        public int A_PTS;          // No. of int. pts. in LICs 8, 13
        public int B_PTS;          // No. of int. pts. in LICs 8, 13
        public int C_PTS;          // No. of int. pts. in LIC 9
        public int D_PTS;          // No. of int. pts. in LIC 9
        public int E_PTS;          // No. of int. pts. in LICs 10, 14
        public int F_PTS;          // No. of int. pts. in LICs 10, 14
        public int G_PTS;          // No. of int. pts. in LIC 11
        public double LENGTH2;     // Maximum length in LIC 12
        public double RADIUS2;     // Maximum radius in LIC 13
        public double AREA2;       // Maximum area in LIC 14
    }

    // //////////// global variable declarations ////////////
    public static ParametersT PARAMETERS = new ParametersT();
    private static ParametersT PARAMETERS2 = new ParametersT();

    // X coordinates of data points
    public static double[] X;
    private static double[] X2;

    // Y coordinates of data points
    public static double[] Y;
    private static double[] Y2;

    // Number of data points
    public static int NUMPOINTS;
    private static int NUMPOINTS2;

    // Logical Connector Matrix
    public static Connectors[][] LCM;
    private static Connectors[][] LCM2;

    // Preliminary Unlocking Matrix
    public static boolean[][] PUM;
    private static boolean[][] PUM2;

    // Conditions Met Vector
    public static boolean[] CMV;
    private static boolean[] CMV2;

    // Final Unlocking Vector
    public static boolean[] FUV;
    private static boolean[] FUV2;

    // Decision: Launch or No Launch
    public static boolean LAUNCH;
    private static boolean LAUNCH2;

    // compares floating point numbers
    public static CompType DOUBLECOMPARE(double A, double B) {
        if (Math.abs(A - B) < 0.000001) return CompType.EQ;
        if (A < B) return CompType.LT;
        return CompType.GT;
    }

    public static boolean lic3() {
        for(int i = 0; i < NUMPOINTS - 2; i++) {
            double x1 = X[i], x2 = X[i + 1];
            double x3 = X[i + 2], y1 = Y[i];
            double y2 = Y[i + 1], y3 = Y[i + 2];

            // Shoelace formula for area of triangle
            double area = 0.5 * Math.abs(x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2));

            if(area > PARAMETERS.AREA1) {
                return true;
            }
        }
        return false;
    }

    // Helper function for calculating the Euclidean distance between two points
    private static double distance(int p1Idx, int p2Idx) {
        double x1 = X[p1Idx];
        double y1 = Y[p1Idx];
        double x2 = X[p2Idx];
        double y2 = Y[p2Idx];
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    // Helper function for calculating the area of a triangle formed by three points
    private static double triangleArea(int p1, int p2, int p3) {
        double x1 = X[p1], y1 = Y[p1];
        double x2 = X[p2], y2 = Y[p2];
        double x3 = X[p3], y3 = Y[p3];
        return 0.5 * Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
    }

    public static boolean lic6() {
        if (NUMPOINTS < 3) { return false; }

        for (int i = 0; i <= NUMPOINTS - PARAMETERS.N_PTS; i++) {
            int startIdx = i;
            int endIdx = i + PARAMETERS.N_PTS - 1;

            // Check if first and last points are identical
            boolean isIdentical =
                    (DOUBLECOMPARE(X[startIdx], X[endIdx]) == CompType.EQ) &&
                    (DOUBLECOMPARE(Y[startIdx], Y[endIdx]) == CompType.EQ);

            // Calculate the length of the line segment
            double lineLength = 0;
            if (!isIdentical) {
                lineLength = distance(startIdx, endIdx);
            }

            // Iterate through the points in the window (excluding the endpoints)
            for (int j = startIdx + 1; j < endIdx; j++) {
                double distanceToLine;
                if (isIdentical) {
                    distanceToLine = distance(startIdx, j);
                } else {  // Use triangle geometry to find normal line
                    double area = triangleArea(startIdx, endIdx, j);
                    distanceToLine = (2 * area) / lineLength;
                }
                // LIC met if distance is greater than DIST
                if (DOUBLECOMPARE(distanceToLine, PARAMETERS.DIST) == CompType.GT) {
                    return true;
                }
            }
        }
        return false;
    }

    // function you must write
    public static void DECIDE() {
        // Implementation goes here
    }
}
