package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
