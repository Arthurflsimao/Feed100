package sptech.projetojpa.repositorio

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.rest.core.annotation.RestResource
import org.springframework.transaction.annotation.Transactional
import sptech.projetojpa.dto.PostSimplesResponse
import sptech.projetojpa.dominio.Post
import java.util.Optional

interface PostRepository : JpaRepository<Post, Int> {

    @Query("select m.urlFoto from Post m where m.id = ?1")
    @RestResource(path = "/foto")
    fun findUrl(codigo:Int): Optional<String>
    /*
    Quando um método da Repository retorna Optional<?>
    Caso o resultado vazio, o Endpoint retorna automaticamente 404
     */

    /*
@Query -> permite a execução de instruções JPQL
JPQL permite select, update e delete.
NÃO permite insert
     */
    @Query("""
    select  
    new sptech.projetojpa.dto.PostSimplesResponse(m.codigo, m.nome) 
    from Post m
    """)
    @RestResource(exported = false)
    fun findSimples(): List<PostSimplesResponse>

/*
Sempre que houver UPDATE ou DELETE na @Query
são necessárias as anotações @Modifying e @Transactional
 */
   /* @Query("update Musica m set m.infantil = ?2 where m.codigo = ?1")
    @Modifying
    @Transactional
    @RestResource(exported = false)
    fun setInfantil(codigo:Int, valor:Boolean)

    @Query("""
        select m from Musica m where m.infantil = true
        and m.genero.codigo = ?1
    """)
    fun findInfantilGenero(codigoGenero:Int): List<Post>
  */


}





