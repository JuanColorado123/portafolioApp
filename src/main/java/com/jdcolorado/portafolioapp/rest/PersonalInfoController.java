//package com.jdcolorado.portafolioapp.rest;
//
//import com.jdcolorado.portafolioapp.model.PersonalInfo;
//import com.jdcolorado.portafolioapp.service.IPersonalInfoService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/test-personal-info")
//@RequiredArgsConstructor
//public class PersonalInfoController {
//
//    private final IPersonalInfoService service;
//
//    @GetMapping("/all")
//    public List<PersonalInfo> getAllPersonalInfo(){
//        return service.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public PersonalInfo getPersonalInfoById(@PathVariable Long id){
//        Optional<PersonalInfo> info = service.findById(id);
//
//        if (info.isPresent()){
//            return info.get();
//        }else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PostMapping("/save")
//    public ResponseEntity<PersonalInfo> savePersonalInfo(@RequestBody PersonalInfo personalInfo){
//
//        PersonalInfo save = service.save(personalInfo);
//
//        return new ResponseEntity<>(save, HttpStatus.CREATED);
//    }
//}
