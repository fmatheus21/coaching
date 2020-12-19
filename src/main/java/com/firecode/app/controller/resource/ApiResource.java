package com.firecode.app.controller.resource;

import com.firecode.app.controller.rule.ApiRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fmatheus
 */
@RestController
@RequestMapping("/api")
public class ApiResource {

    @Autowired
    private ApiRule apiRule;

    @GetMapping("/coachees/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        return apiRule.findById(id);
    }

}
