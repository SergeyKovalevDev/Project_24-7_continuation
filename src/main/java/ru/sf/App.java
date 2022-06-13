package ru.sf;

import ru.sf.enums.StudentComparatorEnum;
import ru.sf.enums.UniversityComparatorEnum;
import ru.sf.models.Student;
import ru.sf.models.University;
import ru.sf.parser.XLSXParser;
import ru.sf.utils.ComparatorSelector;
import ru.sf.utils.JsonUtil;
import ru.sf.utils.PropertiesReader;

import java.util.Comparator;
import java.util.Properties;

public class App {
    public static Properties properties;

    public static void main(String[] args) {
        String sourceFilename = "src/main/resources/universityInfo.xlsx";
        String propertiesFilename = "app.properties";
        properties = new PropertiesReader().loadProperties(propertiesFilename);

        Student student = new Student.Builder()
                .withUniversityId("Id")
                .withFullName("FullName")
                .withCurrentCourseNumber(1)
                .withAvgExamScore(4.0F)
                .build();

        System.out.println(JsonUtil.studentToJson(student));

/*
        if (properties != null) {
            XLSXParser xlsxParser = XLSXParser.getInstance();
            Comparator<Student> studentComparator = ComparatorSelector.getStudentComparator(StudentComparatorEnum.FULL_NAME);
            Comparator<University> universityComparator = ComparatorSelector.getUniversityComparator(UniversityComparatorEnum.YEAR_OF_FOUNDATION);

            xlsxParser.getAllStudentsFromXLSX(sourceFilename)
                    .stream()
                    .sorted(studentComparator)
                    .forEach(System.out::println);

            xlsxParser.getAllUniversitiesFromXLSX(sourceFilename)
                    .stream()
                    .sorted(universityComparator)
                    .forEach(System.out::println);
        }
*/
    }
}
