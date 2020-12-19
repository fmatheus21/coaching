package com.firecode.app.controller.rule;

import com.firecode.app.controller.dto.CoacheeDto;
import com.firecode.app.model.service.CoacheeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 *
 * @author fmatheus
 */

@Component
public class ApiRule {

    @Autowired
    private CoacheeService coacheeService;

    public ResponseEntity<?> findById(int id) {
        CoacheeDto coacheeDto = CoacheeDto.converterObject(coacheeService.findById(id));
        return coacheeDto != null ? ResponseEntity.ok(coacheeDto) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

}
