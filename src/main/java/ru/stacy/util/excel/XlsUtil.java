package ru.stacy.util.excel;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

class XlsUtil {
    private XlsUtil() {
        throw new IllegalStateException("Utility class");
    }

    private static final int TITLE_ROW_INDEX = 0;
    private static final boolean FONT_BOLD = true;
    private static final short FONT_SIZE = 14;

    static CellStyle setWorkbookStyle(Workbook workbook) {
        Font headerFont = workbook.createFont();
        headerFont.setBold(FONT_BOLD);
        headerFont.setFontHeightInPoints(FONT_SIZE);
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        return headerCellStyle;
    }

    static void autoColumnSize(Sheet sheet, String[] titles) {
        for(int i = 0; i < titles.length; i++) {
            sheet.autoSizeColumn(i);
        }
    }

    static File saveExcelFile(Workbook workbook, String pathFile) throws IOException {
        File file = new File(pathFile);
        try(FileOutputStream fos = new FileOutputStream(file)) {
            workbook.write(fos);
        }
        return file;
    }

    static void createTitles(CellStyle headerCellStyle, Sheet sheet, String[] titles) {
        Row headerRow = sheet.createRow(TITLE_ROW_INDEX);
        for(int i = 0; i < titles.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(titles[i]);
            cell.setCellStyle(headerCellStyle);
        }
    }
}
