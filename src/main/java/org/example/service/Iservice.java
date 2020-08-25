package org.example.service;

import java.util.List;

public interface Iservice<T,t> {
    T create(T t);
    T update(T t);
    T read(String id);
    Boolean delete(String id);
    List<T> readAll();
}
