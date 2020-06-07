package com.example.sweater.REST;

import com.example.sweater.domain.Basic;
import com.example.sweater.domain.Profession;
import com.example.sweater.Repository.ProfessionRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(value = "/profession")
public class ProfessionController {

    @Autowired
    private ProfessionRepository professionRepository;

    @GetMapping(value = "/all")
    public List<Profession> getall(){
        return professionRepository.findAll();
    }

    @PostMapping(value="/load")
    public String persist(@RequestParam String key,
                          @RequestParam String speciality,
                          @RequestParam String profession){
        professionRepository.save(new Profession(key,speciality,profession));
        return "";
    }

    @GetMapping(value = "/getBySp")
    public List<Profession> getBySp(@RequestParam String sp){
        return professionRepository.findBySp(sp);
    }

    @GetMapping(value = "/doIt")
    public String test(){
        try {
            File file = new File("C:\\Users\\Fixer\\Downloads\\Telegram Desktop\\Специальности.xlsx");   //creating a new file instance
            FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file
            //creating Workbook instance that refers to .xlsx file
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object
            Iterator<Row> itr = sheet.iterator();    //iterating over excel
            int countt = 0;
            int rows = 1;
            while (itr.hasNext()) {
                countt++;
                if (countt == 1){
                    continue;
                }
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column
                int column= 0;
                String temp = "";
                rows++;
                String column1 = "";
                String column2 = "";
                String column3 = "";
                String column4 = "";
                String column5 = "";
                String column6 = "";

                while (cellIterator.hasNext()) {

                    column++;
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {

                        case Cell.CELL_TYPE_STRING:    //field that represents string cell type
                         if(cell.getStringCellValue() == "шифр"){break;}
                            if (column == 1){
                                column1 = cell.getStringCellValue().trim();
                            }if (column == 2){
                            column2 = cell.getStringCellValue().trim();
                        }if (column == 3){
                            column3 = cell.getStringCellValue().trim();
                        }if (column == 4){
                            column4 = cell.getStringCellValue().trim();
                        }if (column == 5){
                            column5 = cell.getStringCellValue().trim();
                            System.out.print(cell.getStringCellValue() + "\t\t\t");
                        }if (column == 6){
                            column6 = cell.getStringCellValue().trim();
                        }
                            break;
                        case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type
                            String ss = ""  +  cell.getNumericCellValue();
                            if (column == 1){
                                column1 = URLEncoder.encode(ss,"UTF-8");
                            }if (column == 2){
                            column2 = URLEncoder.encode(ss,"UTF-8");
                        }if (column == 3){
                            column3 = URLEncoder.encode(ss,"UTF-8");
                        }if (column == 4){
                            column4 = URLEncoder.encode(ss,"UTF-8");
                        }if (column == 5){
                            column5 = URLEncoder.encode(ss,"UTF-8");
                        }if (column == 6){
                            column6 = URLEncoder.encode(ss,"UTF-8");
                        }
                            break;
                        default:
                    }
                }
                if (temp.contains("шифр")){continue;}
                Profession tempBasic = new Profession(column1,column2,column6);
                professionRepository.save(tempBasic);
            }
            System.out.println(rows);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "Done";
    }
}
