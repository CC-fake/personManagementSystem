package com.javaproject.personnelmanagementsystem_jpa.controller;

import com.javaproject.personnelmanagementsystem_jpa.entity.Person;
import com.javaproject.personnelmanagementsystem_jpa.entity.PersonQuery;
import com.javaproject.personnelmanagementsystem_jpa.repository.PersonQueryResponsity;
import com.javaproject.personnelmanagementsystem_jpa.repository.PersonResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonHandler
{
    @Autowired
    private PersonQueryResponsity personQueryResponsity;

    @Autowired
    PersonResponsitory personResponsitory;


    @GetMapping("/query/{page}/{size}")
    public Page<PersonQuery> query(@PathVariable("page") Integer page, @PathVariable("size") Integer size)
    {
        Pageable pageable = PageRequest.of(page - 1,size);
        return personQueryResponsity.findAll(pageable);
    }

    @GetMapping("/query")
    public List<Person> findAll()
    {
        return personResponsitory.findAll();
    }

    @GetMapping("/query/biggestID")
    public long query()
    {
        return personResponsitory.findMax();
    }

    @PostMapping("/add")
    public String add(@RequestBody Person person)
    {
        Person result = personResponsitory.save(person);
        if (result != null)
        {
            return "success";
        }
        else
        {
            return "error";
        }
    }

    @PutMapping("/update")
    public String update(@RequestBody Person person)
    {
        Person result = personResponsitory.save(person);
        if (result != null)
        {
            return "success";
        }
        else
        {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id)
    {
        personResponsitory.deleteById(id);
    }


}
