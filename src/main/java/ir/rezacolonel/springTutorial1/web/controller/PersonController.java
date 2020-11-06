package ir.rezacolonel.springTutorial1.web.controller;

import ir.rezacolonel.springTutorial1.exception.ServiceException;
import ir.rezacolonel.springTutorial1.model.Persons;
import ir.rezacolonel.springTutorial1.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/person")
@SessionAttributes("person")
public class PersonController {
    private PersonRepository personRepository;

    /*@ModelAttribute
    public Persons person() {
        return new Persons();
    }*/

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/detail/{id}")
    public String showPersonDetail(@PathVariable Long id,
                                   Model model,
                                   @ModelAttribute("message") String message,
                                   @ModelAttribute(value = "errors") ArrayList errors) {
        Persons person = personRepository.findById(id).orElseThrow(SecurityException::new);
        model.addAttribute("person", person);
        model.addAttribute("message", message);
        return "person/detail";
    }

    @PostMapping("/update")
    public String update(@Valid Persons person, Errors errors, ModelMap modelMap) {
        if (errors.hasErrors()) {
            modelMap.addAttribute("errors", errors.getAllErrors());
            return "person/detail" + person.getId();
        }

        personRepository.updatePersonByFirstName(person.getFirstName(), person.getId());
        modelMap.addAttribute("message", "Operation Done successfully");
        return "redirect:/person/detail/" + person.getId();
    }

    @GetMapping("/step1")
    public void step1(ModelMap modelMap) {
        modelMap.addAttribute("person", new Persons());
    }

    @PostMapping("/step2")
    public void step2(Persons person) {
        System.out.println(person);
        //modelMap.addAttribute("person", person);
        //sessionStatus.setComplete();
    }

    @GetMapping("/salam")
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String salam() {
        return "salam";
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView serviceExceptionHandler(HttpServletRequest httpRequest, ServiceException serviceException) {
        ModelAndView modelAndView = new ModelAndView("handler");
        modelAndView.addObject("exception", serviceException);
        modelAndView.addObject("url", httpRequest.getRequestURI());
        return modelAndView;
    }
}
