/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author Pichau
 * @param <T>
 */
public interface Dao<T> {
    
    public void incluir(T entidade);
    public void atualizar(T entidade);
    public void excluir(T entidade);
    public T getEntidadeById(Integer id);
    public List<T> getAllEntidades();
    
}
