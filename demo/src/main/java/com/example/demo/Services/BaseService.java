package com.example.demo.Services;

import java.io.Serializable;
import java.util.List;

import com.example.demo.Entities.Base;
import com.example.demo.Entities.City;

public interface BaseService<E> {
    public List<E> findAll() throws Exception;
    public E findById(Integer id) throws Exception;
    public E save(E entity) throws Exception;
    public E update(Integer id, E entity) throws Exception;
    public boolean delete(Integer id) throws Exception;
    public List<City> search(String q) throws Exception; 
}
