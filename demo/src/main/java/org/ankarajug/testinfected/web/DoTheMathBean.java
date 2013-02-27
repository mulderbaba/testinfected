package org.ankarajug.testinfected.web;

import org.ankarajug.testinfected.domain.CalculationResult;
import org.ankarajug.testinfected.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * User: mertcaliskan
 * Date: 2/23/13
 */
@Controller
@RequestScoped
public class DoTheMathBean {

    @Autowired
    private CalculatorService service;

    private List<CalculationResult> results = new ArrayList<CalculationResult>();

    private Integer param1;
    private Integer param2;

    @PostConstruct
    public void setup() {
        results.addAll(service.getAll());
    }

    public String add() {
        CalculationResult result = service.add(param1, param2);
        results.add(result);

        return null;
    }

    public String subtract() {
        CalculationResult result = service.subtract(param1, param2);
        results.add(result);

        return null;
    }

    public String multiply() {
        CalculationResult result = service.multiply(param1, param2);
        results.add(result);

        return null;
    }

    public String divide() {
        CalculationResult result = service.divide(param1, param2);
        results.add(result);

        return null;
    }

    public List<CalculationResult> getResults() {
        return results;
    }

    public void setResults(List<CalculationResult> results) {
        this.results = results;
    }

    public Integer getParam1() {
        return param1;
    }

    public void setParam1(Integer param1) {
        this.param1 = param1;
    }

    public Integer getParam2() {
        return param2;
    }

    public void setParam2(Integer param2) {
        this.param2 = param2;
    }
}