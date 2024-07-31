package com.vti.kshop.controller;

import com.vti.kshop.dto.AccessoryDto;
import com.vti.kshop.form.AccessoryCreateForm;
import com.vti.kshop.form.AccessoryUpdateForm;
import com.vti.kshop.service.AccessoryService;
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
@CrossOrigin("*")
public class AccessoryController {
    private AccessoryService accessoryService;

    @GetMapping("/api/v1/accessories")
    public Page<AccessoryDto> findAll(Pageable pageable) {
        return accessoryService.findAll(pageable);
    }

    @GetMapping("/api/v1/accessories/{id}")
    public AccessoryDto findById(@PathVariable("id") Long id) {
        return accessoryService.findById(id);
    }

    @PostMapping("/api/v1/accessories")
    @ResponseStatus(HttpStatus.CREATED)
    public AccessoryDto create(@RequestBody AccessoryCreateForm form) {
        return accessoryService.create(form);
    }

    @PutMapping("/api/v1/accessories/{id}")
    public AccessoryDto update(
            @PathVariable("id") Long id,
            @RequestBody AccessoryUpdateForm form
    ) {
        return accessoryService.update(id, form);
    }

    @DeleteMapping("/api/v1/accessories/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) {
        accessoryService.deleteById(id);
    }
}
