package com.example.demo.Controllers;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.Services.*;
import com.example.demo.Entities.City;
import com.example.demo.Repositories.CityRepository;
import com.univocity.parsers.tsv.TsvParser;
import com. univocity.parsers.common.record.Record;
import com.univocity.parsers.tsv.TsvParserSettings;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/suggestions")
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    CityRepository cityRepository; 

    
    @PostMapping("/search")
    public String uploadData(@RequestParam("file") MultipartFile file) throws Exception{
        List<City> listaCiudades = new ArrayList<>();
        InputStream input = file.getInputStream();
        TsvParserSettings settings = new TsvParserSettings();
        settings.setHeaderExtractionEnabled(true);
        TsvParser parser = new TsvParser(settings);
        List<Record> parseAllRecords = parser.parseAllRecords(input);
        parseAllRecords.forEach(record -> {
            City ciudades = new City();
            ciudades.setId(Integer.parseInt(record.getString("id")));
            ciudades.setName(record.getString("name"));
            ciudades.setAscii(record.getString("ascii"));
            ciudades.setAltName(record.getString("alt_name"));
            ciudades.setLat(record.getString("lat"));
            ciudades.setLongi(record.getString("long"));
            ciudades.setFeatClass(record.getString("feat_class"));
            ciudades.setFeatCode(record.getString("feat_code"));
            ciudades.setCountry(record.getString("country"));
            ciudades.setCc2(record.getString("cc2"));
            ciudades.setAdmin1(record.getString("admin1"));
            ciudades.setAdmin2(record.getString("admin2"));
            ciudades.setAdmin3(record.getString("admin3"));
            ciudades.setAdmin4(record.getString("admin4"));
            ciudades.setPopulation(record.getString("population"));
            ciudades.setElevation(record.getString("elevation"));
            ciudades.setDem(record.getString("dem"));
            ciudades.setTz(record.getString("tz"));
            ciudades.setModifiedAt(record.getString("modified_at"));
            listaCiudades.add(ciudades);
        });
        cityRepository.saveAll(listaCiudades);
        return "Se ha cargado el tsv";
    }

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(cityService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(cityService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody City entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(cityService.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody City entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(cityService.update(id, entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(cityService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error\"}");
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String q){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(cityService.search(q));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }


}
