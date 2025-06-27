package com.collect.fond.controller;

import com.collect.fond.facade.MarieFacade;
import com.collect.fond.presentation.dto.MarieDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ws/marie")
public class MarieController {

    private final MarieFacade marieFacade;

    public MarieController(MarieFacade marieFacade) {
        this.marieFacade = marieFacade;
    }

    @GetMapping("/lister")
    public List<MarieDto> lister() {
        return marieFacade.lister();
    }

    @PostMapping("/enregistrer")
    public void enregistrer(@RequestBody MarieDto dto) {
        marieFacade.enregistrer(dto);
    }
}
