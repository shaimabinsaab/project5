package com.example.teacher_project.Service;

import com.example.teacher_project.Exeption.Api;
import com.example.teacher_project.Model.Book;
import com.example.teacher_project.Model.Customer;
import com.example.teacher_project.Model.Store;
import com.example.teacher_project.Repositry.StoreReositry;

import com.example.teacher_project.Repositry.CustomerRepositry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepositry customerRepositry;
    private final StoreReositry storeReositry;

    public List<Customer> getCustomer() {
        return customerRepositry.findAll();
    }

    public void addCustomer(Customer Customer) {
        customerRepositry.save(Customer);
    }

    public void UpdateCustomer(Integer id, Customer Customer) {
        Customer m = customerRepositry.findCustomerById(id);

        if (m == null) {
            throw new Api("this id is not here");
        }


    }

    public void deletecustomer(Integer id) {
        Customer m = customerRepositry.findCustomerById(id);

        if (m == null) {
            throw new Api("id not here");

        }

        customerRepositry.delete(m);

    }
    public void assign(Integer s_id,Integer c_id){
        Store store= storeReositry.findStoreById(s_id);
        Customer customer=customerRepositry.findCustomerById(c_id);
        if (store==null||customer==null){
            throw new Api("id not here");
        }
        customer.getStores().add(store);
        store.getCustomers().add(customer);
        customerRepositry.save(customer);
        storeReositry.save(store);
    }




}

