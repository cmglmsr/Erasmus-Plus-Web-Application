package com.crackware.erasmus.data.services.helper;

import com.crackware.erasmus.data.model.Course;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "Erasmus/Bileteral", "Host University's Name", "Host University's Department/Program",
            "Host University's Course Code", "Host University's Course name" };
    static String SHEET = "Sheet1";

    public static boolean hasExcelFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType());
    }

    public static List<Course> excelToCourses(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);
            System.out.println("imdat12312341234");
            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<Course> courses = new ArrayList<>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                Course course = new Course();

                int cellIdx = 1;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
                        case 0:
                            course.setHostUniversityName(currentCell.getStringCellValue());
                            break;

                        case 1:
                            course.setDepartment(currentCell.getStringCellValue());
                            break;

                        case 2:
                            course.setCourseCode(currentCell.getStringCellValue());
                            break;

                        case 3:
                            course.setCourseName(currentCell.getStringCellValue());
                            break;

                        default:
                            break;
                    }

                    cellIdx++;
                }

                courses.add(course);
            }

            workbook.close();

            return courses;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}