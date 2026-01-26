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

    @Test
    @DisplayName("LIC 10 should be positive when area is smaller than AREA1 with correct spacing")
    void testLic10Positive() {
        Decide.PARAMETERS.AREA1 = 5;
        Decide.PARAMETERS.E_PTS = 1;
        Decide.PARAMETERS.F_PTS = 1;
        Decide.NUMPOINTS = 5;

        // Triangle coords: (0,0), (4,0), (0,4) -> Area = 8.0
        Decide.X = new double[]{0.0, 99.0, 4.0, 99.0, 0.0};
        Decide.Y = new double[]{0.0, 99.0, 0.0, 99.0, 4.0};

        assertTrue(Decide.lic10(), "Expected LIC10 to be true (Area 8.0 > AREA1 5.0)");
    }

    @Test
    @DisplayName("LIC 10 Negative: Triangle area < AREA1")
    void testLic10Negative() {
        Decide.PARAMETERS.AREA1 = 10.0;
        Decide.PARAMETERS.E_PTS = 1;
        Decide.PARAMETERS.F_PTS = 1;
        Decide.NUMPOINTS = 5;

        // Same triangle (Area = 8.0), but requirement is AREA1 = 10.0
        Decide.X = new double[]{0.0, 99.0, 4.0, 99.0, 0.0};
        Decide.Y = new double[]{0.0, 99.0, 0.0, 99.0, 4.0};

        assertFalse(Decide.lic10(), "Expected LIC10 to be false (Area 8.0 < AREA1 10.0)");
    }

    @Test
    @DisplayName("LIC 10 Negative: Not enough data points")
    void testLic10InsufficientPoints() {
        Decide.NUMPOINTS = 4;
        assertFalse(Decide.lic10(), "Expected LIC10 to be false when NUMPOINTS < 5");
    }
}
