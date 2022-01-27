package com.penguincoders.storepenguin.service;

import com.penguincoders.storepenguin.model.Penguin;
import com.penguincoders.storepenguin.repository.PenguinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class PenguinServiceImpl implements PenguinService{

    @Autowired
    private PenguinRepository penguinRepository;

    @Override
    public Penguin savePenguin(Penguin penguin) {

        return penguinRepository.save(penguin);
    }

    @Override
    public List<Penguin> getAllPenguins() {

        return penguinRepository.findAll();
    }

    @Override
    public Penguin get(Integer id) {

        return penguinRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id){
        penguinRepository.deleteById(id);
    }


}

