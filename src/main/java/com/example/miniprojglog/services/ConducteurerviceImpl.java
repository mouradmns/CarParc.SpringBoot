package com.example.miniprojglog.services;

import com.example.miniprojglog.entities.Conducteur;
import com.example.miniprojglog.repository.ConducteurRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class ConducteurerviceImpl implements ConducteurService {

    ConducteurRepo conducteurRepo;

    @Override
    public Conducteur saveConducteur(Conducteur conducteur) {

        return conducteurRepo.save(conducteur);
    }

    @Override
    public Conducteur updateConducteur(Conducteur conducteur) {
        return conducteurRepo.save(conducteur);
    }

    @Override
    public Conducteur deleteConducteur(Long matriculeC) {
        Conducteur toDeleteCOnd=conducteurRepo.getReferenceById(matriculeC);
        conducteurRepo.delete(toDeleteCOnd);
        return toDeleteCOnd;
    }

    @Override
    public Conducteur getConducteurById(Long matriculeC) {
        return conducteurRepo.getReferenceById(matriculeC);
    }

    @Override
    public List<Conducteur> listConducteurs() {
        return conducteurRepo.findAll();
    }
}
