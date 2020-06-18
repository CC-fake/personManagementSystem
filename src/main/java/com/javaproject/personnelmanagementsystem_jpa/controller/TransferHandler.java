package com.javaproject.personnelmanagementsystem_jpa.controller;


import com.javaproject.personnelmanagementsystem_jpa.entity.*;
import com.javaproject.personnelmanagementsystem_jpa.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/transfer")
public class TransferHandler
{
    @Autowired
    private TransferHistoryResponsitory transferHistoryResponsitory;

    @Autowired
    private PersonTransferResponsitory personTransferResponsitory;

    @Autowired
    private PersonResponsitory personResponsitory;

    @Autowired
    private HistrjnResponsitory histrjnResponsitory;


    @GetMapping("/person/{page}/{size}")    //人员调动列表
    public Page<PersonTransfer> transferPersonQuery(@PathVariable("page") Integer page,@PathVariable("size") Integer size)
    {
        Pageable pageable = PageRequest.of(page - 1,size);
        return  personTransferResponsitory.findAll(pageable);
    }

    @GetMapping("frequency/{name}/{fromAcc}") //按姓名和操作类型查询次数
    public long queryFrequency(@PathVariable("name") String name, @PathVariable("fromAcc") String fromAcc)
    {
        if (transferHistoryResponsitory.findFrequency(name, fromAcc).get(0) == null)
        {
            return 0;
        }
        else
        {
            return transferHistoryResponsitory.findFrequency(name,fromAcc).get(0);
        }
    }


    @PutMapping("/excuteTransfer")  //执行调动
    public String transferPerson(@RequestBody Person person)
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

    @PostMapping("/addTransferHistory") //增加调动历史
    public String addTransferHistory(@RequestBody Histrjn histrjn)
    {
        Histrjn result = histrjnResponsitory.save(histrjn);
        if (result != null)
        {
            return "success";
        }
        else
        {
            return "error";
        }
    }

    @GetMapping("/transferhistoryquery/{page}/{size}")    //调动历史查询
    public Page<TransferHistory> queryTransferHistory(@PathVariable("page") Integer page,@PathVariable("size") Integer size)
    {
        Pageable pageable = PageRequest.of(page - 1, size);
        return transferHistoryResponsitory.findAllByFromAcc("0",pageable);
    }

    @GetMapping("/assesshistoryquery/{page}/{size}")    //考核历史查询
    public Page<TransferHistory> queryAssessHistory(@PathVariable("page") Integer page,@PathVariable("size") Integer size)
    {
        Pageable pageable = PageRequest.of(page - 1, size);
        return transferHistoryResponsitory.findAllByFromAcc("1",pageable);
    }

    @GetMapping("/salaryhistoryquery/{page}/{size}")    //劳资分配历史查询
    public Page<TransferHistory> querySalaryHistory(@PathVariable("page") Integer page,@PathVariable("size") Integer size)
    {
        Pageable pageable = PageRequest.of(page - 1, size);
        return transferHistoryResponsitory.findAllByFromAcc("2",pageable);
    }
}
