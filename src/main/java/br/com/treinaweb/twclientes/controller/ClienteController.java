package br.com.treinaweb.twclientes.controller;

import br.com.treinaweb.twclientes.model.Cliente;
import br.com.treinaweb.twclientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public ModelAndView listar() {

        ModelAndView modelAndView = new ModelAndView("cliente/listar.html");
        List<Cliente> clientes = clienteRepository.findAll();
        modelAndView.addObject("clientes", clientes);

        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView detalhar(@PathVariable Long id) {

        ModelAndView modelAndView = new ModelAndView("cliente/detalhar.html");
        Optional<Cliente> cliente = clienteRepository.findById(id);
        modelAndView.addObject("cliente", cliente.get());

        return modelAndView;
    }

    @GetMapping("/{id}/excluir")
    public ModelAndView excluir(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/cliente");

        clienteRepository.deleteById(id);

        return modelAndView;

    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {

        ModelAndView modelAndView = new ModelAndView("cliente/formulario");
        modelAndView.addObject("cliente", new Cliente());
        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public ModelAndView cadastrar(Cliente cliente){

        ModelAndView modelAndView = new ModelAndView("redirect:/cliente");
        clienteRepository.save(cliente);
        return modelAndView;
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {

        ModelAndView modelAndView = new ModelAndView("cliente/formulario");
        Optional<Cliente> cliente = clienteRepository.findById(id);
        modelAndView.addObject("cliente", cliente.get());

        return modelAndView;
    }

    @PostMapping("/{id}/editar")
    public ModelAndView editar(Cliente cliente) {
        ModelAndView modelAndView = new ModelAndView("redirect:/cliente");
        clienteRepository.save(cliente);

        return modelAndView;
    }
}
