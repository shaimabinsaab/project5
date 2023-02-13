package com.example.teacher_project.Controller;

import com.example.teacher_project.Model.Customer;
import com.example.teacher_project.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping("/get")
    public ResponseEntity getCustomer(){
        List<Customer> Customers = customerService.getCustomer();
        return ResponseEntity.status(200).body(Customers);
    }

    @PostMapping("/add")
    public ResponseEntity addCustomer(@Valid @RequestBody Customer Customer){
        customerService.addCustomer(Customer);
        return ResponseEntity.status(200).body("Customer added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCustomer(@PathVariable Integer id, @Valid @RequestBody Customer Customer) {
        customerService.UpdateCustomer(id, Customer);
        return ResponseEntity.status(200).body("Customer updated");

    }

    @DeleteMapping("/delet/{id}")
    public ResponseEntity deletCustomer(@PathVariable Integer id){
        customerService.deletecustomer(id);

        return ResponseEntity.status(200).body("Customer deleted");


    }

    @PutMapping("/assign/{s_id}/{c_id}")
    public ResponseEntity assign(@PathVariable Integer s_id,@PathVariable Integer c_id){
        customerService.assign(s_id,c_id);
        return ResponseEntity.status(200).body(" assign completed");

    }

}
