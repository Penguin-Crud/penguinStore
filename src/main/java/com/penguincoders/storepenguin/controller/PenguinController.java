package com.penguincoders.storepenguin.controller;

import com.penguincoders.storepenguin.model.Penguin;
import com.penguincoders.storepenguin.service.PenguinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/penguin")
public class PenguinController {

    @Autowired
    private PenguinService penguinService;

    @PostMapping("/add")
    public String add(@RequestBody Penguin penguin){
        penguinService.savePenguin(penguin);
        return "New penguin is added";
    }

}
