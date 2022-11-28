package br.com.sprint.registro;

import br.com.sprint.modeloPartido.TipoIdeologia;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public record PartidoRegistro(

        Long id,
        @NotBlank
        String nomePartido,

        @NotBlank
        String sigla,
        @NotNull
        TipoIdeologia tipoIdeologia,
        @NotNull
        Date dataFundacao

)
{}