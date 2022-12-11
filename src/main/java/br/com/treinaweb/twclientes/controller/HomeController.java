package br.com.treinaweb.twclientes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String home(ModelMap model) {
        model.addAttribute("boasVindas", "Bem Vindo ao curso de Spring com Thymeleaf");

        List<String> aulas = new ArrayList<>();
        aulas.add("Java");
        aulas.add("Javascript");
        aulas.add("HTML");
        aulas.add("CSS");

        model.addAttribute("aulas", aulas);

        return "home";
    }


//    @GetMapping("/mensagem") -> Com assinatura Model
//    public String mensagem(Model model) {
//        model.addAttribute("mensagem", "Mensagem vinda do servidor!");
//        return "mensagem";
//    }

//    @GetMapping("/mensagem") -> Com  ModelMap
//    public String mensagem(ModelMap modelMap) {
//        modelMap.addAttribute("mensagem", "Mensagem com ModelMap");
//        return "mensagem";
//    }

    @GetMapping("/mensagem")
    public ModelAndView mensagem() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mensagem");
        modelAndView.addObject("mensagem", "Mensagem vinda do ModelAndView/Servidor");

        return modelAndView;
    }

//    @GetMapping("/saudacao/{nome}") -> Com PathVariable
//    public ModelAndView saudacao(@PathVariable String nome) {
//
//        ModelAndView modelAndView = new ModelAndView();
//
//        modelAndView.setViewName("saudacao");
//        modelAndView.addObject("nome", nome);
//        return modelAndView;
//    }

    @GetMapping("/saudacao")
    public ModelAndView saudacao(@RequestParam(required = false, defaultValue = "TreinaWeb")
                                     String nome) {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("saudacao");
        modelAndView.addObject("nome", nome);
        return modelAndView;
    }

}
