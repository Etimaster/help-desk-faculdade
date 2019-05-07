package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Equipe;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-04T20:25:54")
@StaticMetamodel(Atendente.class)
public class Atendente_ extends Usuario_ {

    public static volatile SingularAttribute<Atendente, Integer> chamadosResolvidos;
    public static volatile SingularAttribute<Atendente, Integer> classificacao;
    public static volatile SingularAttribute<Atendente, Equipe> equipe;

}