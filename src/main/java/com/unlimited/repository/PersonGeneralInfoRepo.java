package com.unlimited.repository;

import com.unlimited.model.PersonGeneralInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonGeneralInfoRepo extends JpaRepository<PersonGeneralInformation,Integer> {


}
