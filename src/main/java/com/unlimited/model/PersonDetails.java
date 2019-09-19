package com.unlimited.model;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;

@Entity
@Table(name="person_details")
public class PersonDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @CsvBindByName(column = "Company Name")
    @Column(name = "company")
    private String company;

    @CsvBindByName(column = "Job Title")
    @Column(name = "job_title")
 private String jobTitle;

    @CsvBindByName(column = "Address 1")
    @Column(name = "address1")
 private String address1;

    @CsvBindByName(column = "Address 2")
 private String address2;

    @CsvBindByName(column = "City")
 private String city;
@CsvBindByName(column = "State Id")
 private String stateId;

@CsvBindByName(column = "Zip")
 private String zipCode;

@CsvBindByName(column = "Country Id")
 @Column(name = "country_id")
 private String countryId;

@CsvBindByName(column = "Phone Number")
 @Column(name = "phone_number")
 private String phoneNumber;

@CsvBindByName(column = "Phone 2 Number")
 @Column(name = "phone_number2")
 private String phoneNumber2;

@CsvBindByName(column = "Question")
private String questions;

@CsvBindByName(column = "Note")
private String  note;

@CsvBindByName(column = "Qualified/Disqualified")
@Column(name = "is_qualified")
private String qualified;

@CsvBindByName(column ="ScannedBy" )
    @Column(name = "scanned_by")
private String scannedBy;

@OneToOne(mappedBy = "personDetails",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
private  PersonGeneralInformation personGeneralInformation;

    public PersonGeneralInformation getPersonGeneralInformation() {
        return personGeneralInformation;
    }

    public void setPersonGeneralInformation(PersonGeneralInformation personGeneralInformation) {
        this.personGeneralInformation = personGeneralInformation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getQualified() {
        return qualified;
    }

    public void setQualified(String qualified) {
        this.qualified = qualified;
    }

    public String getScannedBy() {
        return scannedBy;
    }

    public void setScannedBy(String scannedBy) {
        this.scannedBy = scannedBy;
    }

    @Override
    public String toString() {
        return "PersonDetails{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", stateId='" + stateId + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", countryId='" + countryId + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", phoneNumber2=" + phoneNumber2 +
                ", questions='" + questions + '\'' +
                ", note='" + note + '\'' +
                ", qualifiedOrDisqualified='" + qualified + '\'' +
                ", scannedBy='" + scannedBy + '\'' +
                '}';
    }
}
