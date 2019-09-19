package com.unlimited.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.unlimited.model.PersonDetails;
import com.unlimited.model.PersonGeneralInformation;
import com.unlimited.repository.PersonGeneralInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

@Service
public class ReadCsvFile {
@Autowired
    PersonGeneralInfoRepo personInfoRepo;
public void setCsvData()
{
    try {

        String fileName="src/main/resources/persons.csv";
        Path filePath= Paths.get(fileName);
        BufferedReader bufferedReader= Files.newBufferedReader(filePath, StandardCharsets.UTF_8);
        HeaderColumnNameMappingStrategy<PersonGeneralInformation> strategy=
                new HeaderColumnNameMappingStrategy<>();
        strategy.setType(PersonGeneralInformation.class);

        CsvToBean csvToBean=new CsvToBeanBuilder(bufferedReader).withType(PersonGeneralInformation.class)
                .withMappingStrategy(strategy).withIgnoreLeadingWhiteSpace(true).build();

        //this list may contain some of the null rows of csv file
        List<PersonGeneralInformation> personGeneralInformations=csvToBean.parse();


        //now for another class
        BufferedReader bufferedReader1= Files.newBufferedReader(filePath, StandardCharsets.UTF_8);

        HeaderColumnNameMappingStrategy<PersonDetails> strategy1=
                new HeaderColumnNameMappingStrategy<>();
        strategy1.setType(PersonDetails.class);

        CsvToBean csvToBean1=new CsvToBeanBuilder(bufferedReader1).withType(PersonDetails.class)
                .withMappingStrategy(strategy1).withIgnoreLeadingWhiteSpace(true).build();
//this list also may contain some of null values of csv file
        List<PersonDetails> personDetails=csvToBean1.parse();



//filtering the null rows and inserting to dataBase
        int i=0;
     for(PersonGeneralInformation personGeneralInformation:personGeneralInformations)
     {
         //filtering the null rows throuh name
         if(personGeneralInformation.getFirstName()!=null)
         {
             personGeneralInformation.setPersonDetails(personDetails.get(i));
            personInfoRepo.save(personGeneralInformation);
             i++;


         }
     }
    }
catch (IOException e)
{
    e.printStackTrace();

}
}

}
