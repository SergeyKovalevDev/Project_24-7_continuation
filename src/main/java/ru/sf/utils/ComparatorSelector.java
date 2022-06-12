package ru.sf.utils;

import ru.sf.comparators.*;
import ru.sf.enums.StudentComparatorEnum;
import ru.sf.enums.UniversityComparatorEnum;
import ru.sf.models.Student;
import ru.sf.models.University;

import java.util.Comparator;

public class ComparatorSelector {

    private ComparatorSelector() {}

    public static Comparator<Student> getStudentComparator(StudentComparatorEnum studentComparatorEnum) {

        return switch (studentComparatorEnum) {
            case FULL_NAME -> new StudentFullNameComparator();
            case UNIVERSITY_ID -> new StudentUniversityIdComparator();
            case CURRENT_COURSE_NUMBER -> new StudentCurrentCourseNumberComparator();
            case AVG_EXAM_SCORE -> new StudentAvgExamScoreComparator();
            case DATE_OF_BIRTH -> new StudentDateOfBirthComparator();
        };
    }

    public static Comparator<University> getUniversityComparator(UniversityComparatorEnum universityComparatorEnum) {

        return switch (universityComparatorEnum) {
            case ID -> new UniversityIdComparator();
            case FULL_NAME -> new UniversityFullNameComparator();
            case SHORT_NAME -> new UniversityShortNameComparator();
            case MAIN_PROFILE -> new UniversityMainProfileComparator();
            case YEAR_OF_FOUNDATION -> new UniversityYearOfFoundationComparator();
            case WEBSITE -> new UniversityWebsiteComparator();
        };
    }
}
