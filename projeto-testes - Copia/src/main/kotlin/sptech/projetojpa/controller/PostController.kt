package sptech.projetojpa.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import sptech.projetojpa.dto.PostSimplesResponse
import sptech.projetojpa.repositorio.PostRepository

@RestController
@RequestMapping("/feed")
class PostController(val repository: PostRepository) {

    @GetMapping("/foto/{id}")
    fun getFoto(@PathVariable id:Int): ResponseEntity<String> {
        val url = repository.findById(id).get().urlFotoRevendedor
        return ResponseEntity.status(200).body(url)
    }

    // Se o repository não estivesse no construtor,
    // declararíamos ele como atributo de instância:
    /*@Autowired
    lateinit var repository: MusicaRepository*/

    @GetMapping("/simples")
    fun getSimples():ResponseEntity<List<PostSimplesResponse>> {
        val lista = repository.findSimples()

        if (lista.isNotEmpty()) {
            return ResponseEntity.status(200).body(lista)
        }
        return ResponseEntity.status(204).build()
    }


}