package com.example.StudySpringBoot.service;

import com.example.StudySpringBoot.repository.CountryDAO;
import com.example.StudySpringBoot.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryDAO countryDAO;

    public List<Country> getAllCountries() {
        return countryDAO.findAll();
    }

    public Country getCountryById(Long id) {
        return countryDAO.findById(id);
    }

    public void createCountry(Country country) {
        countryDAO.save(country);
    }

    public void updateCountry(Long id, Country countryDetails) {
        Country country = countryDAO.findById(id);
        country.setName(countryDetails.getName());
        country.setPopulation(countryDetails.getPopulation());
        country.setRegion(countryDetails.getRegion());
        countryDAO.update(country);
    }

    public void deleteCountry(Long id) {
        countryDAO.deleteById(id);
    }
}