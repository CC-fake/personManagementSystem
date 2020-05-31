package com.javaproject.personnelmanagementsystem_jpa.controller;

import com.javaproject.personnelmanagementsystem_jpa.entity.Dept;
import com.javaproject.personnelmanagementsystem_jpa.repository.DeptResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptHandler
{
    @Autowired
    private DeptResponsitory deptResponsitory;

    @GetMapping("/query/{page}/{size}")
    public Page<Dept> query(@PathVariable("page") Integer page, @PathVariable("size") Integer size)
    {
        Pageable pageable = PageRequest.of(page - 1,size);
        return deptResponsitory.findAll(pageable);
    }

    @GetMapping("/query")
    public List<Dept> queryAll()
    {
        return deptResponsitory.findAll();
    }

    @GetMapping("/query/findMax")
    public long findMax()
    {
        return deptResponsitory.findMax();
    }

    @PostMapping("/add")
    public String add(@RequestBody Dept dept)
    {
        Dept result = deptResponsitory.save(dept);
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
        deptResponsitory.deleteById(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody Dept dept)
    {
        Dept result = deptResponsitory.save(dept);
        if (result != null)
        {
            return "success";
        }
        else
        {
            return "error";
        }
    }

}
