package PageObjects;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
public class ExcelData1 {
    public ArrayList<String> getData(String testcasename) throws IOException {
        ArrayList<String>a=new ArrayList<String>();
        FileInputStream fis= new FileInputStream("C:\\Users\\india\\Documents\\MakeMytrip.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        int sheets=workbook.getNumberOfSheets();
        for(int i=0;i<sheets;i++){
            if(workbook.getSheetName(i).equalsIgnoreCase("Location")){
                XSSFSheet sheet= workbook.getSheetAt(i);
                Iterator<Row> rows=sheet.iterator();
                Row firstrow= rows.next();
                Iterator<Cell>ce= firstrow.cellIterator();
                int k=0,colum=0;
                while(ce.hasNext()){
                    Cell value= ce.next();
                    if(value.getStringCellValue().equalsIgnoreCase("LocationsData")){
                        colum=k;
                    }
                    k++;
                }
                while(rows.hasNext()){
                    Row r= rows.next();
                    if(r.getCell(colum).getStringCellValue().equalsIgnoreCase(testcasename)){
                        Iterator<Cell>cv=r.cellIterator();
                        while(cv.hasNext()){
                            a.add(cv.next().getStringCellValue());
                        }
                    }
                }
            }
        }
        return a;
    }
}
