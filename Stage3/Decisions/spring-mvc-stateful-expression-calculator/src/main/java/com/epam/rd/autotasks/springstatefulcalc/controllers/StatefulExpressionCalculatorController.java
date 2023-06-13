package com.epam.rd.autotasks.springstatefulcalc.controllers;

import com.epam.rd.autotasks.springstatefulcalc.model.SessionValues;
import com.epam.rd.autotasks.springstatefulcalc.service.SolutionExpression;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;




@Controller
@RequestMapping("/calc")
@SessionAttributes("sessionValues")
public class StatefulExpressionCalculatorController {
    @PutMapping("/expression")
    public ResponseEntity<String> setExpression(@RequestBody String exp, @ModelAttribute("sessionValues") SessionValues sessionValues) throws IOException {

        if(exp.matches("bad format")) {
            return ResponseEntity.status(400).body(null);
        }else{
            if (sessionValues.getExpression() == null) {
                sessionValues.setExpression(exp);
                return ResponseEntity.status(201).body(null);
            } else {
                sessionValues.setExpression(exp);
                return ResponseEntity.status(200).body(null);
            }
        }
    }

    @PutMapping("/{variableName}")
    public ResponseEntity<String> setVariable(@PathVariable("variableName") String variableName
                                ,@ModelAttribute("sessionValues") SessionValues sessionValues
                                ,@RequestBody String requestValue) throws IOException {
        if(requestValue.matches("[-+]?\\d+") && (Integer.parseInt(requestValue) > 10_000 || Integer.parseInt(requestValue) < -10_000)){
          return   ResponseEntity.status(403).body(null);
        }else {
            if (sessionValues.getValue().get(variableName) == null) {
                sessionValues.getValue().put(variableName, requestValue);
             return    ResponseEntity.status(201).body(null);
            } else {
                sessionValues.getValue().put(variableName,requestValue);
                return ResponseEntity.status(200).body(null);
            }
        }
    }

    @DeleteMapping("/expression")
    public ResponseEntity<String> deleteExpression(@ModelAttribute("sessionValues") SessionValues sessionValues){
        if(sessionValues.getExpression() != null){
            sessionValues.setExpression(null);
            return ResponseEntity.status(204).body(null);
        }
        return null;
    }

    @DeleteMapping("/{variableName}")
    public ResponseEntity<String> deleteVariables(@PathVariable("variableName") String variableName
                                  ,@ModelAttribute("sessionValues") SessionValues sessionValues) throws IOException {
        if(sessionValues.getValue().get(variableName) != null){
            sessionValues.getValue().remove(variableName);
            return ResponseEntity.status(204).body(null);
        }
        return null;
    }

    @GetMapping("/result")
    public ResponseEntity<String> getResult(@ModelAttribute("sessionValues") SessionValues sessionValues) throws IOException {
        String expression = SolutionExpression.expressionMapToString(sessionValues);
        if(SolutionExpression.isValidExpression(expression)) {
            return ResponseEntity.status(200).body(String.valueOf(SolutionExpression.solution(expression)));
        }else {
            return ResponseEntity.status(409).body(null);
        }
    }

    @ModelAttribute("sessionValues")
    public SessionValues sessionValues() {
        return new SessionValues();
    }

}
