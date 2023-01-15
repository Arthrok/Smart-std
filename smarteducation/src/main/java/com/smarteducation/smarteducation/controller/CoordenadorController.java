package com.smarteducation.smarteducation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import com.smarteducation.smarteducation.model.CRUD.CoordenadorService;
import com.smarteducation.smarteducation.model.Schema.Departamento;
import com.smarteducation.smarteducation.model.Schema.Materias;
import com.smarteducation.smarteducation.model.Schema.Professor;

import jakarta.websocket.server.PathParam;

@Controller
@ControllerAdvice
@RequestMapping("/coordenador")
public class CoordenadorController {
    @Autowired
    CoordenadorService coordenadorService;


    @GetMapping("")
    public String painel(){
        return "coordenador/painelGeral";
    }
    
    @GetMapping("/cadastrar-professor")
    public String cadProf(Model model){
        List<Departamento> listarDepartamentos = this.coordenadorService.lsitarDepartamentos();
        model.addAttribute("listarDepartamentos", listarDepartamentos);
        return "coordenador/criarProfessor";
    }

    @PostMapping("/process-prof")
    public String createProf(Professor prof){
        this.coordenadorService.criaProfessor(prof);
        return "redirect:/coordenador";
    }


    @GetMapping("/ver-professor")
    public String verProf(Model model){
        List<Professor> listarProfessores = this.coordenadorService.listarProfessores();
        model.addAttribute("listarProfessores", listarProfessores);
        return "coordenador/verProfessores";
    }

    @GetMapping("/ver-professor/{id}")
    public String seila(@PathVariable("id") String id, Model model){
        Professor prof = this.coordenadorService.findId(id);
        model.addAttribute("prof", prof);
        List<Departamento> listarDepartamentos = this.coordenadorService.lsitarDepartamentos();
        model.addAttribute("listarDepartamentos", listarDepartamentos);
        return "coordenador/editarProfessor";
    }

    @PostMapping("/process-edit-prof")
    public String edit(Professor professor){
        this.coordenadorService.alterar(professor);
        return "redirect:/coordenador/ver-professor";
    }
    
    @GetMapping("/ver-professor/delete/{id}")
    public String deleteProf(@PathVariable String id){
        this.coordenadorService.deletarProfessor(id);
        return "redirect:/coordenador/ver-professor";
    }

    @GetMapping("/ver-departamento")
    public String verDep(Model model){
        List<Departamento> listarDepartamentos = this.coordenadorService.lsitarDepartamentos();
        model.addAttribute("listarDepartamentos", listarDepartamentos);
        return("coordenador/verDepartamento");
    }

    @GetMapping("/criar-departamento")
    public String criarDep(){
        return("coordenador/criarDepartamento");
    }

    @PostMapping("/process-dep")
    public String criarDept(Departamento departamento){
        this.coordenadorService.criarDepartamento(departamento);
        return "redirect:/coordenador/ver-departamento";
    }

    @GetMapping("/ver-departamento/{id}")
    public String depEsp(@PathVariable String id, Model model){;
        List<Materias> materias = this.coordenadorService.materiaDep(id);
        List<Professor> professores = this.coordenadorService.professores(id);
        model.addAttribute("professores", professores);
        model.addAttribute("materias", materias);
        return "coordenador/vermaisDepartamento";
    }

    // @ResponseBody
    // @GetMapping("/ver-departamento/{id}")
    // public List<Professor> depEsp2(@PathVariable String id){
    //     List<Professor> professores = this.coordenadorService.professores(id);
    //     return professores;
    // }

    @GetMapping("/ver-departamento/editar/{id}")
    public String editDep(@PathVariable String id, Model model){
        Departamento departamento = this.coordenadorService.findDepId(id);
        model.addAttribute("departamento", departamento);
        return "coordenador/editarDepartamento";
    }

    @PostMapping("/process-edit-dep")
    public String editDep(Departamento departamento){
        this.coordenadorService.alterarDepartamento(departamento);
        return "redirect:/coordenador/ver-departamento";
    }

    @GetMapping("/ver-departamento/delete/{id}")
    public String delDep(@PathVariable String id){
        this.coordenadorService.deletarDepartamento(id);
        return "redirect:/coordenador/ver-departamento";
    }
    @GetMapping("/criar-materia")
    public String criarMat(Model model){
        List<Departamento> listarDepartamentos = this.coordenadorService.lsitarDepartamentos();
        model.addAttribute("listarDepartamentos", listarDepartamentos);
        List<Professor> listarProfessores = this.coordenadorService.listarProfessores();
        model.addAttribute("listarProfessores", listarProfessores);
        List<Materias> listarMaterias = this.coordenadorService.listarMaterias();
        model.addAttribute("listarMaterias", listarMaterias);
        return "coordenador/criarMateria";
    }

    @PostMapping("/process-materia")
    public String criarMateria(Materias materia){
        this.coordenadorService.criarMateria(materia);
        return "redirect:/coordenador";
    }

    @GetMapping("/ver-materia")
    public String verMaterias(Model model){
        List<Materias> listaMaterias = this.coordenadorService.listarMaterias();
        model.addAttribute("listaMaterias", listaMaterias);
        return "coordenador/verMaterias";
    }

    @GetMapping("/materia/editar/{id}")
    public String editarMaterias(@PathVariable String id, Model model){
        Materias materia = this.coordenadorService.acharMateria(id);
        model.addAttribute("materia", materia);
        List<Departamento> listarDepartamentos = this.coordenadorService.lsitarDepartamentos();
        model.addAttribute("listarDepartamentos", listarDepartamentos);
        List<Professor> listarProfessores = this.coordenadorService.listarProfessores();
        model.addAttribute("listarProfessores", listarProfessores);
        List<Materias> listarMaterias = this.coordenadorService.listarMaterias();
        model.addAttribute("listarMaterias", listarMaterias);
        return "coordenador/editarMateria";
    }

    @PostMapping("/process-edit-materia")
    public String editMat(Materias materia){
        this.coordenadorService.criarMateria(materia);
        return "redirect:/coordenador/ver-departamento";
    }

    @GetMapping("/materia/delete/{id}")
    public String deleteMateria(@PathVariable String id){
        this.coordenadorService.deleteMateria(id);
        return "redirect:/coordenador/ver-departamento";
    }
}
