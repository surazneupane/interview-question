package com.unlimited.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.unlimited.model.PersonDetails;
import com.unlimited.repository.PersonDetailsRepo;
import com.unlimited.repository.PersonGeneralInfoRepo;
import com.unlimited.service.ReadCsvFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    ReadCsvFile readCsvFile;
    @Autowired
    PersonGeneralInfoRepo generalInfoRepo;
    @Autowired
    PersonDetailsRepo personDetailsRepo;

    @RequestMapping("/")
    public String getIndexPage()
    {

        return "index";
    }


    @RequestMapping("/loadDatabase")
    public String loadDatabase()
    {
        readCsvFile.setCsvData();
return "mainpage";
    }

    @RequestMapping("/listPersonUS")
    public ModelAndView getAllList(ModelAndView modelAndView)
    {
        List<PersonDetails>personDetailsList;
        //we want the list of persons from UnitedState
        personDetailsList=personDetailsRepo.getAllByCountryId("United States");

    modelAndView.setViewName("listpersons");
    modelAndView.addObject("Data",personDetailsList);
        modelAndView.addObject("size",personDetailsList.size());

    return modelAndView;

    }
@RequestMapping("/filter")
    public ModelAndView showFilteredResult(@RequestParam("status") String status)
{
    System.out.println(status);
List<PersonDetails> personDetails;
personDetails=personDetailsRepo.getAllByQualified(status);
ModelAndView modelAndView=new ModelAndView();
modelAndView.setViewName("listpersons");
modelAndView.addObject("Data",personDetails);
modelAndView.addObject("size",personDetails.size());
return modelAndView;


}

@RequestMapping("/search")
    public ModelAndView showSearchResult(@RequestParam("name") String name)
{
List<PersonDetails> personDetails;
personDetails=personDetailsRepo.getAllByScannedBy(name);
    ModelAndView modelAndView=new ModelAndView();
    modelAndView.setViewName("listpersons");
    modelAndView.addObject("Data",personDetails);
    modelAndView.addObject("size",personDetails.size());

    return modelAndView;

}

}
