package com.ibike.operator.repository;

import com.ibike.operator.domain.Contact;
import com.ibike.operator.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Integer> {

    Place getPlaceById(int id);

    List<Place> getPlacesByOperatorId(int id);
}
