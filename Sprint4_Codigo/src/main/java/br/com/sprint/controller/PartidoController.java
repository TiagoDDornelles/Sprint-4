package br.com.sprint.controller;


import br.com.sprint.modeloPartido.Partido;
import br.com.sprint.modeloPartido.PartidoRepository;
import br.com.sprint.registro.PartidoRegistro;
import br.com.sprint.registro.UpdatePartido;
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
@RequestMapping("/partidos")
public class PartidoController {


    @Autowired
    private PartidoRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid PartidoRegistro partidoRegistro) {
        repository.save(new Partido(partidoRegistro));
    }


    @GetMapping
    public Page<Partido> listar(@PageableDefault(sort = {"nome_partido", "sigla", "tipo_ideologia","data_fundacao"}, direction = Sort.Direction.DESC) Pageable paginacao) {
        return repository.findAll(paginacao);
    }

    @GetMapping("/{id}")
    public Optional<Partido> detalhes(@PathVariable Long id) {
        return repository.findById(id);

    }

    @PutMapping("/{id}")
    @Transactional
    public void update(@PathVariable Long id,@RequestBody @Valid UpdatePartido dados) {
        var partido = repository.getReferenceById(id);
        partido.atualizarDadosPartido(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
