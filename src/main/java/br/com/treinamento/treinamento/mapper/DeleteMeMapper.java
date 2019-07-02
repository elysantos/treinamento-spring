package br.com.treinamento.treinamento.mapper;

import br.com.treinamento.treinamento.model.DeleteMe;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DeleteMeMapper {

  DeleteMe recuperar();

}