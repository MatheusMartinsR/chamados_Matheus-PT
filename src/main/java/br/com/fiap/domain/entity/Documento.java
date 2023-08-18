package br.com.fiap.domain.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "TB_DOCUMENTO")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DOCUMENTO")
    @Column(name = "ID_DOCUMENTO")
    private Long Id;

    @Column(name = "NR_DOCUMENTO")
    private String numero;

    @ManyToOne
    @JoinColumn(name = "ID_TP_DOCUMENTO",
            referencedColumnName = "ID_TP_DOCUMENTO",
            foreignKey = @ForeignKey(name = "FK_TP_DOCUMENTO"))
    private TipoDocumento tipo;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.ALL})
    @JoinColumn(
            name = "ID_PESSOA",
            referencedColumnName = "ID_PESSOA",
            foreignKey = @ForeignKey(name = "FK_PESSOA_DOCUMENTO")
    )
    private Pessoa pessoa;

    public Documento(Long id, String numero, TipoDocumento tipo, Pessoa pessoa) {
        Id = id;
        this.numero = numero;
        this.tipo = tipo;
        this.pessoa = pessoa;
    }

    public Documento() {
    }

    public Long getId() {
        return Id;
    }

    public Documento setId(Long id) {
        Id = id;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Documento setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public TipoDocumento getTipo() {
        return tipo;
    }

    public Documento setTipo(TipoDocumento tipo) {
        this.tipo = tipo;
        return this;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Documento setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        return this;
    }

    @Override
    public String toString() {
        return "Documento{" +
                "Id=" + Id +
                ", numero='" + numero + '\'' +
                ", tipo=" + tipo +
                ", pessoa=" + pessoa +
                '}';
    }
}
