package hello;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class test {

    @Autowired
    private PaperListRepository paperListRepository;

    @RequestMapping(value = "/api/live",method = RequestMethod.GET)
    public List<PaperList> getPaperListRepository() {
        List<PaperList> all = paperListRepository.findAll();
        return all;
    }
    //  /live/1
    @RequestMapping(value = "/api/live/{id}",method = RequestMethod.GET)
    public PaperList getOne(@PathVariable("id") long id) {
        return paperListRepository.findOne(id);
    }

    @PostMapping(value = "/api/save")
    public void postPaperListRepository(@RequestBody PaperList paperList) {
        System.out.println(paperList.getCreate_time());
        paperListRepository.save(paperList);
    }

}
