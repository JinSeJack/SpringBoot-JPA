package com.ibike.operator.service;

import com.ibike.operator.domain.Contact;
import com.ibike.operator.domain.Place;
import com.ibike.operator.repository.ContactRepository;
import com.ibike.operator.repository.PlaceRepository;
import com.ibike.support.jpa.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService implements JpaService<PlaceRepository> {
    @Override
    public PlaceRepository repository() {
        return placeRepository;
    }

    public PlaceService(PlaceRepository contactRepository) {
        this.placeRepository = contactRepository;
    }

    @Autowired
    private final PlaceRepository placeRepository;

    public List<Place> findAllPlacesByOperatorId(int id) {
        return placeRepository.getPlacesByOperatorId(id);
    }

    public void save(Place place) {
        placeRepository.save(place);
    }

    public void delete(int id){
        placeRepository.deleteById(id);
    }

    public void delete(Place place){
        placeRepository.delete(place);
    }

    public Place getById(int id){
         return placeRepository.getPlaceById(id);
    }
}
