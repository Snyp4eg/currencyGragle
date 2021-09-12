package com.gmail.snyp4eg.service.interfaces;

import java.util.List;

public interface GenericService<T> {
    void saveAll(List<T> t);
    List<T> getAll();
}