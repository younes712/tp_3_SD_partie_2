package com.younes.hospital2.web;

import com.younes.hospital2.entities.Patient;
import com.younes.hospital2.repository.PatientRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;
    @GetMapping("/index2")
    public String index2(Model model,
                         @RequestParam(name ="page",defaultValue = "0") int page,
                         @RequestParam(name ="size",defaultValue = "5") int size,
                         @RequestParam(name ="keyword",defaultValue = "") String kw) {
        //Page<Patient> pagePatients = patientRepository.findAll(PageRequest.of(page, size));
        Page<Patient> pagePatients   = patientRepository.findByNomContains(kw,PageRequest.of(page,size));
        model.addAttribute("patients", pagePatients.getContent());
        model.addAttribute("pages", new int [pagePatients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", kw);
        return "patients";
    }
    @GetMapping("/delete")
    public String delete(Model model,
                        @RequestParam(name ="id") Long id,
                        @RequestParam(name="keyword") String keyword,
                        @RequestParam(name="page" ) int page ) {
        patientRepository.deleteById(id);
//        model.addAttribute("patients", patientRepository.findAll());
        return "redirect:/index2?page=" +page+"&keyword="+keyword;
    }
    @GetMapping("/")
    public String home(){
        return "patients";
    }

    @GetMapping("/formPatients")
    public String formPatients(Model model) {
        model.addAttribute("patient", new Patient());
        return "formPatients";
    }
    @PostMapping(path="/save")
    public String save(@Valid Patient patient, BindingResult bindingResult,
                       @RequestParam(name="page",defaultValue = "0") int page,
                       @RequestParam(name="keyword", defaultValue = "") String keyword) {
        if(bindingResult.hasErrors()) return "formPatients";
        patientRepository.save(patient);
        return "redirect:/index2?page=" +page+"&keyword="+keyword;
    }

    @GetMapping("/editPatient")
    public String editPatient(Model model,
                              @RequestParam(name="id" )Long id ) {
        Patient patient = patientRepository.findById(id).orElse(null);
        if (patient == null) throw new RuntimeException("Patient not found");
        model.addAttribute("patient", patient);
        return "editPatient";
    }
}
