package lab1;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DecideTest {
    @BeforeEach                                         
    void setUp() {
        // Reset parameters before every test to ensure clean state
        Decide.PARAMETERS = new Decide.ParametersT();
    }

    // LIC 3 TEST

    @Test
    @DisplayName("LIC 3 should be true when area is bigger than AREA1")
    void testLic3Positive() {
        // Setting up new test parameters
        Decide.PARAMETERS.AREA1 = 0.2;
        Decide.NUMPOINTS = 3;
        Decide.X = new double[]{0.0, 0.0, 1.0}; 
        Decide.Y = new double[]{1.0, 0.0, 0.0};   

        assertTrue(Decide.lic3(), "Expected LIC3 to be true for area > AREA1");
    }
    @Test
    @DisplayName("LIC 3 should be false when area is smaller than AREA1")
    void testLic3Negative() {
        // Setting up new test parameters
        Decide.PARAMETERS.AREA1 = 5.0;
        Decide.NUMPOINTS = 3;
        Decide.X = new double[]{0.0, 2.0, 1.0}; 
        Decide.Y = new double[]{2.0, 0.0, 0.0};

        assertFalse(Decide.lic3(), "Expected LIC3 to be false for area < AREA1");
    }

    // LIC 6 TEST

    @Test
    public void testLic6Positive() {
        // Requirement: distance > DIST
        Decide.NUMPOINTS = 3;
        Decide.PARAMETERS.N_PTS = 3;
        Decide.PARAMETERS.DIST = 1.0;

        // Line from (0,0) to (4,0)
        Decide.X[0] = 0.0; Decide.Y[0] = 0.0;
        Decide.X[2] = 4.0; Decide.Y[2] = 0.0;

        // Point in between at (2, 2). Distance to x-axis line is 2
        Decide.X[1] = 2.0; Decide.Y[1] = 2.0;

        // 2 > 1 -> True
        assertTrue("LIC 6 should be true when point is further than DIST from line", Decide.checkLIC6());
    }

    @Test
    public void testLic6Negative() {
        // Requirement: distance > DIST
        Decide.NUMPOINTS = 3;
        Decide.PARAMETERS.N_PTS = 3;
        Decide.PARAMETERS.DIST = 3.0;

        // Line from (0,0) to (4,0)
        Decide.X[0] = 0.0; Decide.Y[0] = 0.0;
        Decide.X[2] = 4.0; Decide.Y[2] = 0.0;

        // Point in between at (2, 2). Distance to x-axis line is 2
        Decide.X[1] = 2.0; Decide.Y[1] = 2.0;

        // 2 < 3 -> False
        assertFalse("LIC 6 should be false when point is closer than DIST to line", Decide.checkLIC6());
    }

    @Test
    public void testLic6PositiveIdentical() {
        // Requirement: If first and last points are the same, compare distance to that point
        Decide.NUMPOINTS = 3;
        Decide.PARAMETERS.N_PTS = 3;
        Decide.PARAMETERS.DIST = 1.0;

        // Start and End are same (0,0)
        Decide.X[0] = 0.0; Decide.Y[0] = 0.0;
        Decide.X[2] = 0.0; Decide.Y[2] = 0.0;

        // Middle point at (2,0). Distance to (0,0) is 2
        Decide.X[1] = 2.0; Decide.Y[1] = 0.0;

        // 2 > 1 -> True
        assertTrue("LIC 6 should handle identical endpoints correctly", Decide.checkLIC6());
    }

    @Test
    public void testLic6NegativeIdentical() {
        // Requirement: If first and last points are the same, compare distance to that point
        Decide.NUMPOINTS = 3;
        Decide.PARAMETERS.N_PTS = 3;
        Decide.PARAMETERS.DIST = 3.0;

        // Start and End are same (0,0)
        Decide.X[0] = 0.0; Decide.Y[0] = 0.0;
        Decide.X[2] = 0.0; Decide.Y[2] = 0.0;

        // Middle point at (2,0). Distance to (0,0) is 2
        Decide.X[1] = 2.0; Decide.Y[1] = 0.0;

        // 2 < 3 -> False
        assertFalse("LIC 6 should handle identical endpoints correctly", Decide.checkLIC6());
    }
}
