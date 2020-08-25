package org.example.repository;

import java.util.List;

public interface Irepository<T,t> {
    T create(T t);
    T update(T t);
    T read(String id);
    Boolean delete(String id);
    List<t> readAll();
}
