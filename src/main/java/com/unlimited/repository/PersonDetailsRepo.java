package com.unlimited.repository;

import com.unlimited.model.PersonDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonDetailsRepo extends JpaRepository<PersonDetails,Integer>{
List<PersonDetails> getAllByCountryId(String Country);
List<PersonDetails>  getAllByQualified(String status);
List<PersonDetails> getAllByScannedBy(String name);
}
