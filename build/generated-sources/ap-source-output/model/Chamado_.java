package model;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Atendente;
import model.Categoria;
import model.Classificacao;
import model.Equipe;
import model.Situacao;
import model.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T20:25:54")
@StaticMetamodel(Chamado.class)
public class Chamado_ { 

    public static volatile SingularAttribute<Chamado, Situacao> situacao;
    public static volatile SingularAttribute<Chamado, Usuario> criador;
    public static volatile SingularAttribute<Chamado, Categoria> categoria;
    public static volatile SingularAttribute<Chamado, String> titulo;
    public static volatile SingularAttribute<Chamado, LocalDateTime> dataDeCriacao;
    public static volatile SingularAttribute<Chamado, Usuario> solicitador;
    public static volatile SingularAttribute<Chamado, String> descricao;
    public static volatile SingularAttribute<Chamado, Atendente> atendente;
    public static volatile SingularAttribute<Chamado, String> resolucao;
    public static volatile SingularAttribute<Chamado, Classificacao> classificacao;
    public static volatile SingularAttribute<Chamado, LocalDateTime> dataLimite;
    public static volatile SingularAttribute<Chamado, Integer> id;
    public static volatile SingularAttribute<Chamado, Equipe> equipeResponsavel;

}