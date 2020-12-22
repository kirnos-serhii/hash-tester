package com.khpi.demo.controller;

import com.khpi.demo.dto.CalculateDTO;
import com.khpi.demo.service.CalculateService;
import com.khpi.demo.util.Validator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/calculate")
@AllArgsConstructor
public class Calculate {

    private CalculateService calculateService;

    private Validator validator;

    @PostMapping()
    public ResponseEntity calculate(@RequestBody CalculateDTO calculateDTO) {
        List<String> errors = validator.validate(calculateDTO);
        if (errors.size() > 0) {
            return ResponseEntity.badRequest().body(errors);
        }
        return ResponseEntity.ok().body(calculateService.calculate(calculateDTO));
    }

}
