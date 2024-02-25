package com.example.simpleboard.crud;

import com.example.simpleboard.common.Api;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public abstract class CRUDAbsApiController<DTO, ENTITY> implements CRUDinterface<DTO> {
    @Autowired(required = false)
    private CRUDAbsService<DTO,ENTITY> crudAbsService;

    @PostMapping("")
    @Override
    public DTO create(@RequestBody
            @Valid
            DTO dto) {
        return crudAbsService.create(dto);
    }

    @GetMapping("/id/{id}")
    @Override
    public Optional<DTO> read(@PathVariable Long id) {
        return crudAbsService.read(id);
    }

    @PutMapping("")
    @Override
    public DTO update(@RequestBody
            @Valid
            DTO dto) {
        return crudAbsService.update(dto);
    }

    @DeleteMapping("/delete")
    @Override
    public void delete(@PathVariable Long id) {
        crudAbsService.delete(id);
    }

    @GetMapping("/all")
    @Override
    public Api<List<DTO>> list(@PageableDefault  Pageable pageable) {
        return crudAbsService.list(pageable);
    }


}
