package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ScholarshipCalculatorTest {

    private final ScholarshipCalculator calculator = new ScholarshipCalculator();

    @Test
    void letterGradeReturnsAForExcellentScore() {
        assertEquals("A", calculator.letterGrade(95));
    }

    @Test
    void letterGradeReturnsBForGoodScore() {
        assertEquals("B", calculator.letterGrade(85));
    }

    @Test
    void gpaCalculatesAverageForTwoScores() {
        assertEquals(3.5, calculator.gpa(new double[]{95, 85}));
    }

    @Test
    void scholarshipReturnsFullAmountForHighGpaAndCredits() {
        assertEquals(100, calculator.scholarship(3.9, 16, false));
    }

    @Test
    void scholarshipReturnsZeroWhenStudentHasViolation() {
        assertEquals(0, calculator.scholarship(3.9, 16, true));
    }

    @Test
    void letterGradeCoversAllGradeRangesAndInvalidScores() {
        assertEquals("C", calculator.letterGrade(75));
        assertEquals("D", calculator.letterGrade(60.01));
        assertEquals("F", calculator.letterGrade(60));
        assertEquals("F", calculator.letterGrade(0));
        assertThrows(IllegalArgumentException.class, () -> calculator.letterGrade(-1));
        assertThrows(IllegalArgumentException.class, () -> calculator.letterGrade(101));
    }

    @Test
    void gpaCoversEveryGradeAndInvalidInputs() {
        assertEquals(2.0, calculator.gpa(new double[]{95, 85, 75, 65, 55}));
        assertThrows(IllegalArgumentException.class, () -> calculator.gpa(null));
        assertThrows(IllegalArgumentException.class, () -> calculator.gpa(new double[]{}));
    }

    @Test
    void scholarshipCoversAllAwardBranches() {
        assertEquals(70, calculator.scholarship(3.9, 14, false));
        assertEquals(70, calculator.scholarship(3.5, 12, false));
        assertEquals(50, calculator.scholarship(3.5, 11, false));
        assertEquals(50, calculator.scholarship(3.2, 0, false));
        assertEquals(0, calculator.scholarship(2.9, 0, false));
    }

    @Test
    void scholarshipRejectsEachInvalidArgument() {
        assertThrows(IllegalArgumentException.class, () -> calculator.scholarship(-0.1, 0, false));
        assertThrows(IllegalArgumentException.class, () -> calculator.scholarship(4.1, 0, false));
        assertThrows(IllegalArgumentException.class, () -> calculator.scholarship(3.0, -1, false));
    }

    @Test
    void gpaRejectsAnEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> calculator.gpa(new double[]{}));
    }

    @Test
    void gpaHandlesOneScore() {
        assertEquals(4.0, calculator.gpa(new double[]{95}));
    }

    @Test
    void gpaHandlesTwoOrMoreScores() {
        assertEquals(2.5, calculator.gpa(new double[]{95, 85, 75, 65}));
    }
}
