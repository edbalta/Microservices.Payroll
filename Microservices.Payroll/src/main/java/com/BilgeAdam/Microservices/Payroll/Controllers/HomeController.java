package com.BilgeAdam.Microservices.Payroll.Controllers;

import com.BilgeAdam.Microservices.Payroll.Entities.Payroll;
import com.BilgeAdam.Microservices.Payroll.Feign.SsiDeclarationClient;
import com.BilgeAdam.Microservices.Payroll.Repositories.PayrollRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@AllArgsConstructor
public class HomeController {
    private PayrollRepository payrollRepository;
    private SsiDeclarationClient ssiDeclarationClient;

    //Postgreye kayıt
    @GetMapping("/save")
    public String save(){
        var p = new Payroll();
        p.setYear(2023);
        p.setMonth(10);
        payrollRepository.save(p);

        return "test";
    }
    // feign ile ssi declaration servisine istek atar
    @GetMapping("withFeign")
    public String getSsiDeclarationTestWithFeign(){
        var result = ssiDeclarationClient.getTest();

        return result;
    }

    //feign kullanmadan ssi declaration servisine istek atar
    @GetMapping("withoutFeign")
    public String getSsiDeclarationTestWithoutFeign(){
        var restTemplate = new RestTemplate();
        var result = restTemplate.getForObject(
                "http://localhost:8081/test",
                String.class);

        return result;
    }

}