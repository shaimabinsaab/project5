package com.example.teacher_project.Controller;


import com.example.teacher_project.DTO.LocationDto;
import com.example.teacher_project.Model.Location;
import com.example.teacher_project.Model.Store;
import com.example.teacher_project.Service.LocationServic;
import com.example.teacher_project.Service.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/store")
public class StoreController {
    private final StoreService storeService;
    private final LocationServic locationServic;

    @GetMapping("/get")
    public ResponseEntity getstore(){
        List<Store> stores=storeService.getStore();
        return ResponseEntity.status(200).body(stores);
    }

    @PostMapping("/add")
    public ResponseEntity addstore(@Valid @RequestBody Store stores){
        storeService.addStore(stores);
        return ResponseEntity.status(200).body("store added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updatestore(@PathVariable Integer id, @Valid @RequestBody Store stores) {
        storeService.UpdateStore(id, stores);
        return ResponseEntity.status(200).body("store updated");

    }

    @DeleteMapping("/delet/{id}")
    public ResponseEntity deletstore(@PathVariable Integer id){
        storeService.deleteStore(id);

        return ResponseEntity.status(200).body("store deleted");


    }
    @PutMapping("/updatedetails")
    public ResponseEntity updateTeacherdetails(@RequestBody LocationDto locationDto) {
        locationServic.UpdatelocationDetails(locationDto);
        return ResponseEntity.status(200).body("store location updated");

    }
    @DeleteMapping("/deletdetails/{id}")
    public ResponseEntity deletTeacherDetails(@PathVariable Integer id){
        locationServic.deletelocationDetails(id);

        return ResponseEntity.status(200).body("store location deleted");


    }
    @GetMapping("/getdetails/{id}")
    public ResponseEntity getTeacherdetails(@PathVariable Integer id,@RequestBody LocationDto locationDto){
        Location location=locationServic.getstoredetails(id,locationDto);
        return ResponseEntity.status(200).body(location);
    }
    @GetMapping("/getallstoreinfo/{id}")
    public ResponseEntity getstoreinfo(@PathVariable Integer id){
        Store store=storeService.findStore(id);
        return ResponseEntity.status(200).body(store);
    }
    @GetMapping("/{storeId}/customers")
    public ResponseEntity getAllCustomersForStore(@PathVariable Integer storeId){
        return ResponseEntity.status(200).body(storeService.getAllCustomersForStore(storeId));
    }
}
