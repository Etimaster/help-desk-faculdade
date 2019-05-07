package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Atendente;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T20:25:54")
@StaticMetamodel(Equipe.class)
public class Equipe_ { 

    public static volatile ListAttribute<Equipe, Atendente> atendentes;
    public static volatile SingularAttribute<Equipe, String> nome;
    public static volatile SingularAttribute<Equipe, Integer> id;

}