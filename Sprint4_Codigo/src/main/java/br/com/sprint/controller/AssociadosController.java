package br.com.sprint.controller;



import br.com.sprint.modeloAssociados.Associados;
import br.com.sprint.modeloAssociados.AssociadosRepository;
import br.com.sprint.registro.AssociadoRegistro;
import br.com.sprint.registro.UpdateAssociados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/associados")
public class AssociadosController {

    @Autowired
    private AssociadosRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid AssociadoRegistro associadoRegistro) {
        repository.save(new Associados(associadoRegistro));
    }

    @GetMapping
    public Page<Associados> listar(@PageableDefault(sort = {"nome_associado", "CargoPolitico", "data_nascimento","tipo_sexo"}, direction = Sort.Direction.DESC) Pageable paginacao) {
        return repository.findAll(paginacao);
    }

    @GetMapping("/{id}")
    public Optional<Associados> detalhes(@PathVariable Long id) {
        return repository.findById(id);

    }


    @PutMapping("/{id}")
    @Transactional
    public void update(@PathVariable Long id,@RequestBody @Valid UpdateAssociados dados) {
        var associado = repository.getReferenceById(id);
        associado.atualizarDadosAssociado(dados);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
