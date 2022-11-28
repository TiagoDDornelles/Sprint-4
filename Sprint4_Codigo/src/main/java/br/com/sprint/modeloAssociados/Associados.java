package br.com.sprint.modeloAssociados;

import br.com.sprint.registro.AssociadoRegistro;
import br.com.sprint.registro.UpdateAssociados;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


@Table(name = "associado")
@Entity(name = "Associados")
@Getter

@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Associados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeAssociado;

    @Enumerated(EnumType.STRING)
    private CargoPolitico CargoPolitico;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento ;

    @Enumerated(EnumType.STRING)
    private TipoSexo TipoSexo;


    public Associados(){

    }

    public Associados(AssociadoRegistro associadoRegistro) {
        this.nomeAssociado = associadoRegistro.nomeAssociado();
        this.CargoPolitico = associadoRegistro.cargoPolitico();
        this.dataNascimento = associadoRegistro.dataNascimento();
        this.TipoSexo = associadoRegistro.tipoSexo();

    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Associados other = (Associados) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public void atualizarDadosAssociado(UpdateAssociados dados) {

        if (dados.nomeAssociado() != null) {
            this.nomeAssociado = dados.nomeAssociado();
        }
        if (dados.cargoPolitico() != null) {
            this.CargoPolitico = dados.cargoPolitico();
        }
        if (dados.dataNascimento() != null) {
            this.dataNascimento = dados.dataNascimento();
        }
        if (dados.tipoSexo() != null) {
            this.TipoSexo = dados.tipoSexo();
        }
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeAssociado() {
        return nomeAssociado;
    }

    public void setNomeAssociado(String nomeAssociado) {
        this.nomeAssociado = nomeAssociado;
    }

    public br.com.sprint.modeloAssociados.CargoPolitico getCargoPolitico() {
        return CargoPolitico;
    }

    public void setCargoPolitico(br.com.sprint.modeloAssociados.CargoPolitico cargoPolitico) {
        CargoPolitico = cargoPolitico;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public br.com.sprint.modeloAssociados.TipoSexo getTipoSexo() {
        return TipoSexo;
    }

    public void setTipoSexo(br.com.sprint.modeloAssociados.TipoSexo tipoSexo) {
        TipoSexo = tipoSexo;
    }
}
