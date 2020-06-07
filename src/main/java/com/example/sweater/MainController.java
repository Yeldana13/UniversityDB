package com.example.sweater;

import com.example.sweater.Repository.Basic_rRepository;
import com.example.sweater.Repository.ProfessionRepository;
import com.example.sweater.domain.Basic;
import com.example.sweater.Repository.BasicRepository;
import com.example.sweater.domain.Basic_r;
import com.example.sweater.domain.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    BasicRepository basicRepo;
    @Autowired
    Basic_rRepository basic_rRepository;

    @Autowired
    ProfessionRepository professionRepository;

    @GetMapping(value="/greeting")
    public String greeting(){
        return "greeting";
    }

    @GetMapping(value = "/home")
    public String main(Map<String, Object> model) {
        List<Profession> specianalities = professionRepository.findAll();
        model.put("specianalities", specianalities);
        return "main";
    }

    @GetMapping(value = "/prof")
    public String prof(Map<String, Object> model) {
        List<Basic> basics = basicRepo.findAll();
        model.put("prof", basics);
        return "prof";
    }
    @PostMapping(value = "/prof")
    public String profPost(@RequestParam(name = "sp") String sp,Map<String, Object> model) {
        List<Basic> basics = basicRepo.findBySp(sp);
        model.put("prof", basics);
        return "prof";
    }

    @PostMapping(value = "profSearch")
    public String profSearch(@RequestParam(name = "value") String value,Map<String, Object> model) {
        List<Basic> basics = basicRepo.findByAll(value);
        model.put("prof", basics);
        return "prof";
    }

    @PostMapping("request")
    public String request(@RequestParam(name = "prof1") String prof1, @RequestParam(name = "prof2") String prof2, Map<String, Object> model) {
        List<Basic_r> basic_rList = basic_rRepository.findByProf1orProf2(prof1,prof2);
        List<Profession> specianalitiesTemp = new ArrayList<>();

        for (Basic_r basic_r: basic_rList) {
            specianalitiesTemp.addAll(professionRepository.findBySp(basic_r.getSpeciality_id()));
        }
        List<Profession> specianalities = specianalitiesTemp;
        model.put("specianalities", specianalities);
        return "main";

    }
}
//    @GetMapping("requests")
//    public String requests (@RequestParam String id_sp,@RequestParam String city Map<String, Object> model){
//        System.out.println(id_sp);
//        if(id_sp!=""){
//            Iterable<Basic> basics= basicRepo.findBySpecialityAndCity(id_sp, city);
//            model.put("basics",basics);
//            return "main";
//        }
//        else{
//
//
//        }
////        Iterable<Basic> basics= basicRepo.findBySpeciality(id_sp);
////        model.put("basics",basics);
////        return "main";
//    }

