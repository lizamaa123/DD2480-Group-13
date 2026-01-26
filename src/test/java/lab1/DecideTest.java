package lab1;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
    @DisplayName("Lic 8 should be true when radius is greater than RADIUS1")
    void testLic8Positive() {
        Decide.PARAMETERS.RADIUS1 = 1.0;
        Decide.NUMPOINTS = 5;
        Decide.X = new double[]{0.0, 1.0, 0.0, 2.0, 0.0};
        Decide.Y = new double[]{0.0, 0.0, 1.0, 0.0, 2.0};

        assertTrue(Decide.lic8(), "Expected Lic 8 to be true for radius > RADIUS1");
    }

    @Test
    @DisplayName("Lic 8 should be false when radius is less than or equal to RADIUS1")
    void testLic8Negative() {
        Decide.PARAMETERS.RADIUS1 = 1.0;
        Decide.NUMPOINTS = 5;
        Decide.X = new double[]{0.0, 0.0, 2.5, 0.0, 0.0};
        Decide.Y = new double[]{0.0, 0.0, 0.0, 0.0, 2.5};

        assertTrue(Decide.lic8(), "Expected Lic 8 to be false for radius <= RADIUS1");
    }
}
