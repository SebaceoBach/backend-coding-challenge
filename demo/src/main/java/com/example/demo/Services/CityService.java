package com.example.demo.Services;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.demo.Entities.City;
import com.example.demo.Repositories.CityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService implements BaseService<City> {

    @Autowired
    private CityRepository cityRepository;

    @Override
    @Transactional
    public List<City> findAll() throws Exception {
        try {
            List<City> entities = cityRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public City findById(Integer id) throws Exception {
        try {
            Optional<City> entityOp = cityRepository.findById(id);
            return entityOp.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
            
        }
    }


    @Override
    @Transactional
    public City save(City entity) throws Exception {
        try {
            entity = cityRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
            
        }
    }

    @Override
    @Transactional
    public City update(Integer id, City entity) throws Exception {
        try {
            Optional<City> entityOp = cityRepository.findById(id);
            City city = entityOp.get();
            city = cityRepository.save(entity);
            return city;
        } catch (Exception e) {
            throw new Exception(e.getMessage()); 
        }
    }

    @Override
    @Transactional
    public boolean delete(Integer id) throws Exception {
        try {
            if(cityRepository.existsById(id)){
                cityRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<City> search(String q) throws Exception {
        try {
            List<City> cities = cityRepository.search(q);
            return cities;
        } catch (Exception e) {
           throw new Exception(e.getMessage());
        }
    }
}