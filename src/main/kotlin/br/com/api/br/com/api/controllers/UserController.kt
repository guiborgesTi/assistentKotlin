package br.com.api.br.com.api.controllers

import br.com.api.br.com.api.br.com.api.repositories.UserRepositorie
import br.com.api.br.com.api.entities.UserEntitie
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI
import java.util.*
import javax.jws.soap.SOAPBinding
import javax.servlet.http.HttpServletResponse
import javax.websocket.server.PathParam

@RestController
@RequestMapping("/user")
open class UserController(
    @Autowired
    var userRepositorie : UserRepositorie
)
    {
    @GetMapping("/findById/{id}")
    fun findById(@PathVariable("id") id: Long) : ResponseEntity<UserEntitie>?{
        return userRepositorie.findById(id).map { userEntitie ->
            ResponseEntity.ok(userEntitie)
        }.orElse(ResponseEntity.notFound().build())
    }

    @GetMapping("/findAll")
    fun findAll() : List<UserEntitie> {

       val users: List<UserEntitie>? = userRepositorie.findAll()
        return users.orEmpty()
    }



    @DeleteMapping("deleteAll")
    fun deleteAll() : ResponseEntity<UserEntitie> {
        userRepositorie.deleteAll()
        return ResponseEntity.status(200).build()
    }


    @DeleteMapping("deleteById/{id}")
    fun deleteById(@PathVariable("id") id : Long?) : ResponseEntity<UserEntitie> {
        val user : Optional<UserEntitie> = userRepositorie.findById(id!!)
        if (user.isPresent()) {
            userRepositorie.deleteById(id!!)
            return ResponseEntity.status(200).build()
        }
        return ResponseEntity.noContent().build()
    }

    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    fun insertUser(@RequestBody user : UserEntitie, response : HttpServletResponse) : ResponseEntity<UserEntitie>{
        val userEntitie : UserEntitie? = userRepositorie.save(user)
        val uri : URI? =
                ServletUriComponentsBuilder.fromCurrentRequestUri()
                        .path("/findById/{id}").buildAndExpand(userEntitie?.idUserAssistent ).toUri()
                response.setHeader("Location", uri?.toASCIIString())
        return ResponseEntity.created(uri!!).body(userEntitie)
    }

    @PutMapping("edit")
    fun editUser(@RequestBody user : UserEntitie?) {
        userRepositorie.saveAndFlush(user!!)
    }
}


