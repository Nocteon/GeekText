package com.example.geektext.Feature1BookBrowsing;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/GeekText")
public class GeekTextAPI
{
    GeekText geekText;
    @GetMapping("{bookId}")
    public GeekText getGeekTextDetails(String bookId)
    {
        return geekText;
//                new GeekText("B1","Publisher 1" ,
//                "Genre 1", "X", "Y");

    }
    @PostMapping
    public String createGeekTextDetails(@RequestBody GeekText geekText)
    {
        this.geekText = geekText;
        return "Geek text Created Successfully";

    }

    @PutMapping
    public String updateGeekTextDetails(@RequestBody GeekText geekText)
    {
        this.geekText = geekText;
        return "Geek text Updated Successfully";

    }

    @DeleteMapping("{bookId}")
    public String deleteGeekTextDetails(String bookId)
    {
        this.geekText = null;
        return "Geek text Deleted Successfully";

    }
}
