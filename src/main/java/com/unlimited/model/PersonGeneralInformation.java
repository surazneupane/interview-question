package com.unlimited.model;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;

@Entity
@Table(name = "person_info")
public class PersonGeneralInformation {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
    private int id;

@CsvBindByName(column = "First Name")
@Column(name = "first_name")
private String firstName;

@CsvBindByName(column = "Last Name")
@Column(name = "last_name")
private String lastName;

@CsvBindByName(column = "Middle Initial")
@Column(name = "middle_name")
private String middleInitial;

@CsvBindByName(column = "Email")
@Column(name = "email_add")
private String email;

@CsvBindByName(column = "Email 2")
@Column(name = "email_aad2")
private String email2;



@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "person_details_id")
private PersonDetails personDetails;

    public PersonDetails getPersonDetails() {
        return personDetails;
    }

    public void setPersonDetails(PersonDetails personDetails) {
        this.personDetails = personDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    @Override
    public String toString() {
        return "PersonGeneralInformation{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleInitial='" + middleInitial + '\'' +
                ", email='" + email + '\'' +
                ", email2='" + email2 + '\'' +
                '}';
    }
}
