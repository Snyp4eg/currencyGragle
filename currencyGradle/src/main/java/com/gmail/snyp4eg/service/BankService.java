package com.gmail.snyp4eg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gmail.snyp4eg.dao.BankDao;
import com.gmail.snyp4eg.model.Bank;
import com.gmail.snyp4eg.service.interfaces.BankExtendedService;

@Service
public class BankService implements BankExtendedService {
    private BankDao bankDao;

    @Autowired
    public BankService(BankDao bankDao) {
	this.bankDao = bankDao;
    }

    @Override
    public void saveAll(List<Bank> banks) {
	banks.stream().forEach(bank -> bankDao.insert(bank));
    }

    @Override
    public List<Bank> getAll() {
	return bankDao.getAll();
    }

}
