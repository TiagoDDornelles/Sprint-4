package br.com.sprint.registro;


import br.com.sprint.modeloAssociados.CargoPolitico;
import br.com.sprint.modeloAssociados.TipoSexo;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Date;

public record UpdateAssociados(
        @PathVariable
        Long id,
        String nomeAssociado,
        CargoPolitico cargoPolitico,
        TipoSexo tipoSexo,
        Date dataNascimento

) {

}



