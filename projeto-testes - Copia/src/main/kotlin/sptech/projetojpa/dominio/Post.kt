package sptech.projetojpa.dominio

import org.hibernate.validator.constraints.URL
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.validation.constraints.NotBlank
import javax.validation.constraints.PastOrPresent

@Entity
data class Post(
    @field:Id  @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var codigo:Int?,

    @field:NotBlank var nome:String?,
    @field:PastOrPresent var dataPostagem:LocalDate?,
    @field:NotBlank var revendedor: String?,
    @field:URL var urlFoto:String?,
    @field:URL var urlFotoRevendedor:String?,

/*
@ManyToOne -> formaliza o relacionamento entre as entidades
@JoinColumn(name = "fk_genero") -> usamos para definir o nome do campo de FK
se não, um nome automático é definido
 */
    @ManyToOne
//    @JoinColumn(name = "fk_genero")
    var genero: Genero?
) {


}