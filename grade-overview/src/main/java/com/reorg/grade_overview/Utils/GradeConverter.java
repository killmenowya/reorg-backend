package com.reorg.grade_overview.Utils;

import java.util.HashMap;
import java.util.Map;

public class GradeConverter {

    private static final Map<String, Double> gradePoints;

    static {
        gradePoints = new HashMap<>();
        gradePoints.put("A+", 5.0);
        gradePoints.put("A", 5.0);
        gradePoints.put("A-", 4.5);
        gradePoints.put("B+", 4.0);
        gradePoints.put("B", 3.5);
        gradePoints.put("B-", 3.0);
        gradePoints.put("C+", 2.5);
        gradePoints.put("C", 2.0);
        gradePoints.put("D+", 1.5);
        gradePoints.put("D", 1.0);
        gradePoints.put("F", 0.0);
        gradePoints.put("S", 0.0);
        gradePoints.put("U", 0.0);

    }

    public static double gradeToPoints(String grade) {
        // Convert the input grade to uppercase to handle lowercase inputs
        grade = grade.toUpperCase();
        
        // Get the corresponding points for the grade
        Double points = gradePoints.get(grade);
        
        // Handle the case where the grade is not in the defined mapping
        if (points == null) {
            throw new IllegalArgumentException("Invalid grade: " + grade);
        }
        
        return points;
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println(gradeToPoints("A")); // Output: 5.0
        System.out.println(gradeToPoints("B")); // Output: 4.0
        System.out.println(gradeToPoints("C")); // Output: 3.0
    }
}
