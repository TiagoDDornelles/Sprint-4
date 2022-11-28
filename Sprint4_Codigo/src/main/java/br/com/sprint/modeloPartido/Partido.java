package br.com.sprint.modeloPartido;


import br.com.sprint.registro.PartidoRegistro;
import br.com.sprint.registro.UpdatePartido;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "partido")
@Entity(name = "Partido")
@Getter

@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomePartido;

    private String sigla;
    @Enumerated(EnumType.STRING)
    private  TipoIdeologia tipoIdeologia;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataFundacao;


    public Partido(){

    }

    public Partido(PartidoRegistro partidoRegistro) {
        this.nomePartido = partidoRegistro.nomePartido();
        this.sigla = partidoRegistro.sigla();
        this.tipoIdeologia = partidoRegistro.tipoIdeologia();
        this.dataFundacao = partidoRegistro.dataFundacao();

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
        Partido other = (Partido) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public void atualizarDadosPartido(UpdatePartido dados) {

        if (dados.nomePartido() != null) {
            this.nomePartido = dados.nomePartido();
        }
        if (dados.sigla() != null) {
            this.sigla = dados.sigla();
        }
        if (dados.tipoIdeologia() != null) {
            this.tipoIdeologia = dados.tipoIdeologia();
        }
        if (dados.dataFundacao() != null) {
            this.dataFundacao = dados.dataFundacao();
        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePartido() {
        return nomePartido;
    }

    public void setNomePartido(String nomePartido) {
        nomePartido = nomePartido;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public TipoIdeologia getTipoIdeologia() {
        return tipoIdeologia;
    }

    public void setTipoIdeologia(TipoIdeologia tipoIdeologia) {
        this.tipoIdeologia = tipoIdeologia;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
}
