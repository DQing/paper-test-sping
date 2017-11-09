package com.controllers;

import com.entities.PaperList;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.repositories.PaperListRepository;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PaperListController {

    @Autowired
    private PaperListRepository paperListRepository;

    @RequestMapping(value = "/api/papers", method = RequestMethod.GET)
    public Map getPaperList() {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("code", 200);
            result.put("data", paperListRepository.findAll());
        } catch (Exception ex) {
            result.put("exception", "查询异常");
        }
        return result;
    }

    @RequestMapping(value = "/api/paper", method = RequestMethod.PUT)
    public Map update(@RequestBody PaperList paperList) {
        Map<String, Object> result = new HashMap<>();
        try {
            PaperList paper = paperListRepository.findOne(paperList.getId());
            paper.setName(paperList.getName());
            paperListRepository.save(paper);
            result.put("code", 200);
        } catch (Exception ex) {
            result.put("exception", "修改名字錯誤");
        }

        return result;
    }


    @RequestMapping(value = "/api/paper/{id}", method = RequestMethod.DELETE)
    public Map delete(@PathVariable("id") int id) {
        Map<String, Object> result = new HashMap<>();
        try {
            paperListRepository.delete(id);
            result.put("code", 200);
        } catch (Exception e) {
            result.put("exception", "删除失败");
        }

        return result;
    }

    @PostMapping(value = "/api/paper")
    public Map postPaperListRepository(@RequestBody PaperList paperList) {
        Map<String, Object> result = new HashMap<>();
        try {

            paperListRepository.save(paperList);
            result.put("code", 200);
        } catch (Exception e) {
            result.put("exception", "添加失败");
        }

        return result;
    }

}
