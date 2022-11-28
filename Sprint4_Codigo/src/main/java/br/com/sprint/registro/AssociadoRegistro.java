package br.com.sprint.registro;

import br.com.sprint.modeloAssociados.CargoPolitico;
import br.com.sprint.modeloAssociados.TipoSexo;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.Date;

public record AssociadoRegistro(
        Long id,
        @NotBlank
        String nomeAssociado,
        @NotNull
        CargoPolitico cargoPolitico,
        @NotNull
        TipoSexo tipoSexo,
        @NotNull
        Date dataNascimento

)
{}
