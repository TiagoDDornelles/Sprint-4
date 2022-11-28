package br.com.sprint.registro;

import br.com.sprint.modeloPartido.TipoIdeologia;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

public record UpdatePartido(
        @PathVariable
        Long id,
        String nomePartido,
        String sigla,
        TipoIdeologia tipoIdeologia,
        Date dataFundacao
)
{}
