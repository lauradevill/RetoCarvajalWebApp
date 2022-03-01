package com.retos.RetoCarvajal.controller;
import com.retos.RetoCarvajal.model.Record;
import com.retos.RetoCarvajal.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/Record")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
/**
 * This class allows mapping the entity Record
 * @author: Laura De Villeros
 */
public class RecordController {
    @Autowired
    private RecordService recordService;

    @GetMapping("/all")
    public List<Record> getAllRecords() { return recordService.getAll(); }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Record save(@RequestBody Record record) { return recordService.save(record); }
}
