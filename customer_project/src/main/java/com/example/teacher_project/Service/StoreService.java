package com.example.teacher_project.Service;


import com.example.teacher_project.Exeption.Api;
import com.example.teacher_project.Model.Customer;
import com.example.teacher_project.Model.Store;
import com.example.teacher_project.Repositry.CustomerRepositry;
import com.example.teacher_project.Repositry.StoreReositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class StoreService {
    private final StoreReositry storeReositry;
    private final CustomerRepositry customerRepositry;
    public List<Store> getStore(){
        return storeReositry.findAll();
    }

    public void addStore(Store store){
        storeReositry.save(store);
    }

    public void UpdateStore(Integer id,Store store){
        Store m=storeReositry.findStoreById(id);

        if(m==null){
            throw new Api("this id is not here");
        }


    }
    public void deleteStore(Integer id) {
        Store m = storeReositry.findStoreById(id);

        if (m == null) {
            throw new Api("id not here");

        }

        storeReositry.delete(m);

    }
    public Store findStore(Integer id){
        Store m=storeReositry.findAllById(id);
        if (m == null) {
            throw new Api("id not here");

        }
        return m;
    }
    public Set<Customer> getAllCustomersForStore(Integer storeId){
        Store store = storeReositry.findStoreById(storeId);
        return store.getCustomers();
    }
}
