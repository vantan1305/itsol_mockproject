package itsol_project.itsolwebserver.controller;

import itsol_project.itsolwebserver.dto.BrandDto;
import itsol_project.itsolwebserver.service.iservice.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/brands")
@CrossOrigin("http://localhost:4200")
public class BrandController {
    @Autowired
    BrandService brandService;

    @GetMapping("/all")
    public ResponseEntity findAll(){
        return ResponseEntity.ok().body(brandService.findAll());
    }

    @GetMapping("/search")
    public ResponseEntity search(HttpServletRequest request, BrandDto dto){
        return ResponseEntity.ok().body(brandService.search(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(HttpServletRequest request, @PathVariable Long id){
        return ResponseEntity.ok().body(brandService.findById(request, id));
    }
    @PostMapping("")
    public ResponseEntity saveOrUpdate(HttpServletRequest request, @RequestBody BrandDto dto){
        return ResponseEntity.ok().body(brandService.saveOrUpdate(request, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(HttpServletRequest request, @PathVariable Long id){
        String message;
        Boolean result = brandService.delete(request, id);
        if (result){
            message = "Delete success!";
            return ResponseEntity.ok().body(message);
        }
        return ResponseEntity.notFound().build();
    }
}
