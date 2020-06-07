package com.example.sweater.REST;


import com.example.sweater.domain.Basic;
import com.example.sweater.Repository.BasicRepository;
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
@RequestMapping(value = "/basic")
public class BasicController {
    @Autowired
    BasicRepository basicRepo;

    @GetMapping(value = "/all")
    public List<Basic> getall(){
        return basicRepo.findAll();
    }

    @PostMapping(value="/load")
    public String persist(@RequestParam String id_sp,
                          @RequestParam String sp,
                          @RequestParam String uni,
                          @RequestParam String un_id,
                          @RequestParam String city,
                          @RequestParam String street,
                          @RequestParam String number,
                          @RequestParam String url){
        basicRepo.save(new Basic(id_sp,sp,uni,un_id,city,street,number,url));
        return "";
    }

    @PostMapping(value = "/getBySpecName")
    public List<Basic> getByName(@RequestParam String name){
        return basicRepo.findByName(name);
    }

    @GetMapping(value = "/doIt")
    public String test(){
        try {
            File file = new File("C:\\Users\\Fixer\\Downloads\\Telegram Desktop\\rusData (3).xlsx");   //creating a new file instance
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
                String column7 = "";
                String column8 = "";
                String column9 = "";
                String column10 = "";
                String column11 = "";

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
                            }if (column == 6){
                                column6 = cell.getStringCellValue().trim();
                            }if (column == 7){
                                column7 = cell.getStringCellValue().trim();
                            }if (column == 8){
                                column8 = cell.getStringCellValue().trim();
                            }if (column == 9){
                                column9 = cell.getStringCellValue().trim();
                            }if (column == 10){
                                column10 = cell.getStringCellValue().trim();
                            }if (column == 11){
                                column11 = cell.getStringCellValue().trim();
                            }
                            // System.out.print(cell.getStringCellValue() + "\t\t\t");
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
                            }if (column == 7){
                                column7 = URLEncoder.encode(ss,"UTF-8");
                            }if (column == 8){
                                column8 = URLEncoder.encode(ss,"UTF-8");
                            }if (column == 9){
                                column9 = URLEncoder.encode(ss,"UTF-8");
                            }if (column == 10){
                                column10 = URLEncoder.encode(ss,"UTF-8");
                            }if (column == 11){
                                column11 = URLEncoder.encode(ss,"UTF-8");
                            }
                            //System.out.print(cell.getNumericCellValue() + "\t\t\t");
                            break;
                        default:
                    }
                }
                if (temp.contains("шифр")){continue;}
                Basic tempBasic = new Basic(column1,column2,column3,column4,column8,column9,column10,column11);
                basicRepo.save(tempBasic);
            }
            System.out.println(rows);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "Done";
    }
}
