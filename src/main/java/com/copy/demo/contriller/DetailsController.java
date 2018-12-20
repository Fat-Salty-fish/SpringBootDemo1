package com.copy.demo.contriller;


import com.copy.demo.model.Detail;
import com.copy.demo.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/detail")
public class DetailsController {

    @Autowired
    private DetailService detailService;

    @GetMapping("/{id}")
    public Object getOne(@PathVariable("id") Integer id )
    {
        return detailService.getOneById(id);
    }

    @PostMapping("/")
    public Object createOrUpdate(@RequestBody Detail detail)
    {
        return detailService.saveOneDetail(detail);
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable("id") Integer id)
    {
        return detailService.deleteById(id);
    }

    @DeleteMapping("")
    public Object delete(@RequestBody Collection<Integer> ids)
    {
        return detailService.deleteByIds(ids);
    }
}
