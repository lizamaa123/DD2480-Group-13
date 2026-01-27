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

    // LIC 4 TEST

    @Test
    public void testLic4Positive() {
        // Requires consecutive points in more than QUADS quadrants
        Decide.NUMPOINTS = 4;
        Decide.PARAMETERS.Q_PTS = 3;
        Decide.PARAMETERS.QUADS = 2;

        Decide.X[0] = 1.0; Decide.Y[0] = 1.0;  // Point 1 in quad 1
        Decide.X[1] = -1.0; Decide.Y[1] = 1.0;  // Point 2 in quad 2
        Decide.X[2] = -1.0; Decide.Y[2] = -1.0;  // Point 3 in quad 3

        // Window of points {0,1,2} occupies 3 quadrants, 3 > 2 is True so the LIC is met.
        assertTrue(Decide.lic4(), "LIC 4 should be true when points are in more than QUADS quadrants");
    }

    @Test
    public void testLic4Negative() {
        Decide.NUMPOINTS = 4;
        Decide.PARAMETERS.Q_PTS = 3;
        Decide.PARAMETERS.QUADS = 2;

        // All points in quad 1 or on boundary
        Decide.X[0] = 1.0; Decide.Y[0] = 1.0;
        Decide.X[1] = 0.0; Decide.Y[1] = 0.0;
        Decide.X[2] = 0.0; Decide.Y[2] = 1.0;

        // Window occupies only 1 quadrant, 1 > 2 is False so LIC is not met.
        assertFalse(Decide.lic4(), "LIC 4 should be false when points are in same quadrant");
    }
}
