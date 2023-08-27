package sptech.projetojpa.dominio

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
data class Genero(
    @field:Id @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    var codigo:Int?,

    @field:NotBlank var nome:String?
)  {
}