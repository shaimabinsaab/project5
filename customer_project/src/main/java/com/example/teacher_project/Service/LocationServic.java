package com.example.teacher_project.Service;

import com.example.teacher_project.DTO.LocationDto;
import com.example.teacher_project.Exeption.Api;

import com.example.teacher_project.Model.Location;
import com.example.teacher_project.Model.Store;
import com.example.teacher_project.Repositry.LocationRepositry;
import com.example.teacher_project.Repositry.StoreReositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class LocationServic {
    private final StoreReositry storeReositry;
    private final LocationRepositry locationRepositry;
    public void addadlocationDetals(LocationDto locationDto){
        Store store=storeReositry.findStoreById(locationDto.getStore_id());
        if (store==null){
            throw new Api("store not found");

        }
        Location c= new Location(null, locationDto.getArea(), locationDto.getStreet(),store);
        locationRepositry.save(c);

    }

    public void UpdatelocationDetails(LocationDto LocationDto){
        Location k=locationRepositry.findLocationById(LocationDto.getStore_id());
        if (k==null){
            throw new Api("stoer not found");
        }
        k.setArea(LocationDto.getArea());
        k.setStreet(LocationDto.getStreet());

        locationRepositry.save(k);

    }

    public void deletelocationDetails(Integer id){
        Location l=locationRepositry.findLocationById(id);
        if (l==null){
            throw new Api("store not found");
        }
        locationRepositry.delete(l);
    }

    public Location getstoredetails(Integer id, LocationDto locationDto){
        Location L=locationRepositry.findLocationById(id);
        if (L==null){
            throw new Api("store not found");
        }

        return locationRepositry.findAllById(id);


    }
}
