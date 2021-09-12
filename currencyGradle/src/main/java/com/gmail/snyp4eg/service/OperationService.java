package com.gmail.snyp4eg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmail.snyp4eg.dao.OperationDao;
import com.gmail.snyp4eg.model.Operation;
import com.gmail.snyp4eg.service.interfaces.OperationExtendedService;

@Service
public class OperationService implements OperationExtendedService{
    private OperationDao operationDao;
    
    @Autowired
    public OperationService (OperationDao operationDao) {
	this.operationDao = operationDao;
    }
    @Override
    public void saveAll(List<Operation> operations) {
	operations.stream().forEach(operation -> operationDao.insert(operation));
    }

    @Override
    public List<Operation> getAll() {
	return operationDao.getAll();
    }
}
