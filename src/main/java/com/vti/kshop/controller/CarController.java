package com.vti.kshop.controller;

import com.vti.kshop.dto.CarDto;
import com.vti.kshop.form.CarCreateForm;
import com.vti.kshop.form.CarUpdateForm;
import com.vti.kshop.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@CrossOrigin("http://127.0.0.1:5500/")
public class CarController {
    private CarService carService;

    @GetMapping("/api/v1/cars")
    public Page<CarDto> findAll(Pageable pageable) {
        return carService.findAll(pageable);
    }

    @GetMapping("/api/v1/cars/{id}")
    public CarDto findById(@PathVariable("id") Long id) {
        return carService.findById(id);
    }

    @PostMapping("/api/v1/cars")
    @ResponseStatus(HttpStatus.CREATED)
    public CarDto create(@RequestBody CarCreateForm form) {
        return carService.create(form);
    }

    @PutMapping("/api/v1/cars/{id}")
    public CarDto update(
            @PathVariable("id") Long id,
            @RequestBody CarUpdateForm form
    ) {
        return carService.update(id, form);
    }

    @DeleteMapping("/api/v1/cars/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        carService.deleteById(id);
    }
}
