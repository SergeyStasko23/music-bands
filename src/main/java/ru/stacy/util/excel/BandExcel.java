package ru.stacy.util.excel;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.data.domain.Page;
import ru.stacy.business.entity.Band;
import ru.stacy.util.exception.ErrorWritingDataToExcelFileException;
import ru.stacy.web.dto.BandDTO;

import java.io.File;
import java.io.IOException;

@Slf4j
public class BandExcel {
    private static String[] titles = {"Название группы", "Жанр", "Количество альбомов", "Дата образования"};
    private static final String PATH_FILE = "./src/main/resources/xlsx/bands.xlsx";
    private static final String SHEET_NAME = "Музыкальные группы";
    private static final int DATA_ROWS_START_INDEX = 1;

    private BandExcel() {
        throw new IllegalStateException("Utility class");
    }

    public static File generateExcelFile(Page<BandDTO> bandDTOPage) {
        log.info("Generate excel file");
        Workbook workbook;
        try {
            workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet(SHEET_NAME);
            CellStyle titleStyle = XlsUtil.setWorkbookStyle(workbook);
            XlsUtil.createTitles(titleStyle, sheet, titles);
            int rowNum = DATA_ROWS_START_INDEX;
            for (BandDTO bandDTO : bandDTOPage) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(bandDTO.getName());
                row.createCell(1).setCellValue(bandDTO.getGenre());
                row.createCell(2).setCellValue(bandDTO.getAlbums().size());
                row.createCell(3).setCellValue(bandDTO.getCreatedDate().toString());
            }
            XlsUtil.autoColumnSize(sheet, titles);
            return XlsUtil.saveExcelFile(workbook, PATH_FILE);
        } catch (IOException e) {
            throw new ErrorWritingDataToExcelFileException();
        }
    }
}
