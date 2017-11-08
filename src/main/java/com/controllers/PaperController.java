package com.controllers;

import com.entities.PaperList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.repositories.PaperListRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PaperController {

    @Autowired
    private PaperListRepository paperListRepository;

    @RequestMapping(value = "/api/getPaperList", method = RequestMethod.GET)
    public Map getPaperList() {
        Map<String, Object> result = new HashMap<>();
        result.put("result", paperListRepository.findAll());

        return result;
    }

    @RequestMapping(value = "/api/update", method = RequestMethod.PUT)
    public Map update(@RequestBody PaperList paperList) {
        Map<String, Object> result = new HashMap<>();
        PaperList paper = paperListRepository.findOne(paperList.getId());
        paper.setName(paperList.getName());
        paperListRepository.save(paper);
        result.put("data", paperListRepository.findAll());

        return result;
    }


    @RequestMapping(value = "/api/delete/{id}", method = RequestMethod.DELETE)
    public Map delete(@PathVariable("id") int id) {
        Map<String, String> result = new HashMap<>();
        paperListRepository.delete(id);
        result.put("result", "删除成功");

        return result;
    }

    @PostMapping(value = "/api/save")
    public Map postPaperListRepository(@RequestBody PaperList paperList) {
        Map<String, String> result = new HashMap<>();
        paperListRepository.save(paperList);
        result.put("result", "添加成功");

        return result;
    }

}
