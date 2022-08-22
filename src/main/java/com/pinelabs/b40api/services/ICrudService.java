package com.pinelabs.b40api.services;

import com.pinelabs.b40api.dtos.CreateFamilyDto;

import java.util.List;

public interface ICrudService<T> {
    T getById(Long id);

    List<T> getAll();

    T create(CreateFamilyDto dto);

    T deleteById(Long id);

    T updateById(T update, Long id);
}
