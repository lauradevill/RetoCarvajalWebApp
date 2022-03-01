package com.retos.RetoCarvajal.repository;
import com.retos.RetoCarvajal.model.Record;
import com.retos.RetoCarvajal.repository.crud.IRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
/**
 * This class defines methods brought from repository for the entity-table Record
 * @author: Laura De Villeros
 */
public class RecordRepository {
    @Autowired
    private IRecordRepository iRecordRepository;

    /**
     * Methods to bring and save information in record table in DB
     */
    public List<Record> getAll() { return (List<Record>) iRecordRepository.findAll(); }
    public Record save(Record record) { return iRecordRepository.save(record); }
}
