package com.example.demo.Repositories;

import java.io.Serializable;

import com.example.demo.Entities.Base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<E extends Base, 
                                ID extends Serializable> extends JpaRepository<E, ID> {
    
}
