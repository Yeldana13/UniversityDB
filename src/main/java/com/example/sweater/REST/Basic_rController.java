package com.example.sweater.REST;
import com.example.sweater.Repository.BasicRepository;
import com.example.sweater.Repository.Basic_rRepository;
import com.example.sweater.domain.Basic_r;
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
@RequestMapping(value = "/basic_prof")
public class Basic_rController {
    @Autowired
    Basic_rRepository basic_r_Repo;
    @Autowired
    BasicRepository basicRRepo;

    @GetMapping(value = "/getProf")
    public List<Basic_r> getProf(@RequestParam(name = "prof1") String prof1, @RequestParam(name = "prof2") String prof2){
        return  basic_r_Repo.findByProf1orProf2(prof1,prof2);
    }


    @GetMapping(value = "/all_prof")
    public List<Basic_r> getall(){
        return basic_r_Repo.findAll();
    }
    @GetMapping(value = "/doIt_prof")
    public String test(){
        try {
            File file = new File("C:\\Users\\Fixer\\Downloads\\Telegram Desktop\\Prof. subjects .xlsx");   //creating a new file instance
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
                int column1 = 0;
                String column2 = "";
                String column3 = "";
                String column4 = "";
                String column5 = "";

                while (cellIterator.hasNext()) {

                    column++;
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {

                        case Cell.CELL_TYPE_STRING:    //field that represents string cell type
//                            if(cell.getStringCellValue() == "№"){break;}
                            if (column == 1){
                                //column1 = cell.getStringCellValue().trim();
                            }if (column == 2){
                            column2 = cell.getStringCellValue().trim();
                        }if (column == 3){
                            column3 = cell.getStringCellValue().trim();
                        }if (column == 4){
                            column4 = cell.getStringCellValue().trim();
                        }if (column == 5){
                            column5 = cell.getStringCellValue().trim();
                        }
                            // System.out.print(cell.getStringCellValue() + "\t\t\t");
                            break;
                        case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type
                            String ss = ""  +  cell.getNumericCellValue();
                            if (column == 1){
                                column1 = (int)cell.getNumericCellValue();//URLEncoder.encode(ss,"UTF-8");
                            }if (column == 2){
                            column2 = URLEncoder.encode(ss,"UTF-8");
                        }if (column == 3){
                            column3 = URLEncoder.encode(ss,"UTF-8");
                        }if (column == 4){
                            column4 = URLEncoder.encode(ss,"UTF-8");
                        }if (column == 5){
                            column5 = URLEncoder.encode(ss,"UTF-8");
                        }
                            //System.out.print(cell.getNumericCellValue() + "\t\t\t");
                            break;
                        default:
                    }
                }
                if (temp.contains("шифр")){continue;}
                Basic_r tempBasic = new Basic_r(column1,column2,column3,column4,column5);
                basic_r_Repo.save(tempBasic);
            }
            System.out.println(rows);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "Done";
    }

}
