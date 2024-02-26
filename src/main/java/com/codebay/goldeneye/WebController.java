package com.codebay.goldeneye;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.codebay.goldeneye.domain.entity.Email;
import com.codebay.goldeneye.domain.valueObject.Department;
import com.codebay.goldeneye.domain.valueObject.Name;
import com.codebay.goldeneye.domain.valueObject.Office;
import com.codebay.goldeneye.domain.valueObject.Surname;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class WebController {  

    /**
     * Mostrar el formulario
     * @return
     */
    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    /**
     * Procesar el formulario
     * @param name
     * @param surname
     * @param office
     * @param department
     * @return
     */
    @PostMapping("/")
    public ModelAndView processForm(
            @RequestParam(name = "Name", required = true) String name,
            @RequestParam(name = "Surname", required = true) String surname,
            @RequestParam(name = "Office", required = true) String office,
            @RequestParam(name = "Department", required = true) String department) {

        try {
            // Procesar los datos del formulario
            Email email = new Email(new Name(name), new Surname(surname), 
                new Office(office, new Department(department)));
            
            // Devolver una respuesta exitosa con el mensaje
            
            ModelAndView modelAndView = new ModelAndView("index");


            modelAndView.addObject("email", email.getEmail());
            return modelAndView;

        } catch (Exception e) {
            // Manejar cualquier error que pueda ocurrir
            ModelAndView vista = new ModelAndView("index");
            vista.addObject("error", e.getMessage());
            return vista;
        }
    }
}