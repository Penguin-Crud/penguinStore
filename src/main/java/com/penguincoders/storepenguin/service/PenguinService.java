package com.penguincoders.storepenguin.service;


import com.penguincoders.storepenguin.model.Penguin;

import java.util.List;

public interface PenguinService {

    public Penguin savePenguin(Penguin penguin);

    public Penguin get(Integer id);

    List<Penguin> getAllPenguins();

    public void delete(Integer id);
}