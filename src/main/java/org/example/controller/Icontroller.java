package org.example.controller;

import java.util.List;

public interface Icontroller<T,t> {
    T create(T t);
    T update(T t);
    T read(String id);
    Boolean delete(String id);
    List<T> readAll();
    Long count();
}
