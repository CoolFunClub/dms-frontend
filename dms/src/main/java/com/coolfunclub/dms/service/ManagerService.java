package com.coolfunclub.dms.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.coolfunclub.dms.model.Manager;
import com.coolfunclub.dms.repository.ManagerRepository;

@Service
public class ManagerService {

    @Autowired
    ManagerRepository managerRepository;

    //Constructor
    public ManagerService(){

    }

    public ResponseEntity<String> addManager(Manager manager){
        Optional <Manager> existingManager = managerRepository.findById(manager.getSSN());
        if(existingManager.isPresent()){
            return ResponseEntity.badRequest().body("Manager already exists with the provided SSN.");
        }
       managerRepository.save(manager);
       return ResponseEntity.ok("Manager added successfully");
    }

    public List<Manager> getAllManagers(){
        List<Manager> Managers = new LinkedList<>();
        managerRepository.findAll().forEach(Managers::add);
        return Managers;
    }

    public void deleteManager(int ssn){
        managerRepository.deleteById(ssn);
    }

    public Manager getManagerById(int ssn){
        return managerRepository.findById(ssn).orElse(null);
    }

    public void updateManager(Manager newManager){
        managerRepository.save(newManager);
    }
}
