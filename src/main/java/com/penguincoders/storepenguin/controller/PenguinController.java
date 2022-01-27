package com.penguincoders.storepenguin.controller;

import com.penguincoders.storepenguin.model.Penguin;
import com.penguincoders.storepenguin.service.PenguinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/penguin")
@CrossOrigin
public class PenguinController {

    @Autowired
    private PenguinService penguinService;

    @PostMapping("/add")
    public String add(@RequestBody Penguin penguin){
        penguinService.savePenguin(penguin);
        return "New penguin is added";
    }

    @GetMapping("/getAll")
    public List<Penguin> getAllPenguins(){
        return penguinService.getAllPenguins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Penguin> get(@PathVariable Integer id){
        try{
            Penguin penguin = penguinService.get(id);
            return new ResponseEntity<Penguin>(penguin,HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<Penguin>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Penguin> update(@RequestBody Penguin penguin, @PathVariable Integer id){
        try{
            Penguin existingPenguin = penguinService.get(id);

            penguinService.savePenguin(penguin);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        penguinService.delete(id);
        return "Deleted Penguin with id "+id;
    }
}
