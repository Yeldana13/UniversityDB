package com.example.sweater.REST;


import com.example.sweater.Repository.BasicRepository;
import com.example.sweater.Repository.Basic_rRepository;
import com.example.sweater.Repository.ProfessionRepository;
import com.example.sweater.domain.Basic;
import com.example.sweater.domain.Basic_r;
import com.example.sweater.domain.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/rest")
public class MainResource {
    @Autowired
    BasicRepository basicRepository;

    @Autowired
    Basic_rRepository basic_rRepository;

    @Autowired
    ProfessionRepository professionRepository;

    @PostMapping(value = "/getSpecionalitiesByProfessions")
    public List<Profession> getSpecionalitiesByProfessions(@RequestParam(value = "prof1") String prof1, @RequestParam(value = "prof2") String prof2){
        List<Basic_r> basic_rList = basic_rRepository.findByProf1orProf2(prof1,prof2);
        List<Profession> specianalities = new ArrayList<Profession>();
        for (Basic_r basic_r: basic_rList) {
            specianalities.addAll(professionRepository.findBySp(basic_r.getSpeciality_id()));
        }
        return specianalities;
    }

    @PostMapping(value = "/getUniversitiesByProfessions")
    public List<Basic> getUniversityBySpeciality(@RequestParam(value = "sp") String key){
        List<Basic> basic_List = basicRepository.findBySp(key);
        return basic_List;
    }
}
