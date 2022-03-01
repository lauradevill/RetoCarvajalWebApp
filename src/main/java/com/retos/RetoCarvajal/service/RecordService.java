package com.retos.RetoCarvajal.service;
import com.retos.RetoCarvajal.model.Record;
import com.retos.RetoCarvajal.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
/**
 * This class defines business restrictions to the methods brought from repository for the entity-table Record
 * @author: Laura De Villeros
 */
public class RecordService {
    /**
     * RecordRepository instance
     */
    @Autowired
    private RecordRepository recordRepository;

    /**
     * Methods from the business to get all items, save an item
     */
    public List<Record> getAll(){ return recordRepository.getAll(); }

    public Record save(Record record){ return recordRepository.save(record); }

}
