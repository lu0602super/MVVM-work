package com.example.mapper;

import com.example.entity.Student;

import java.util.List;

public interface StudentMapper {
    void insert(Student student);

    void updateById(Student student);

    void deleteById(Integer id);

    Student selectById(Integer id);

    List<Student> selectAll(Student student);

}
