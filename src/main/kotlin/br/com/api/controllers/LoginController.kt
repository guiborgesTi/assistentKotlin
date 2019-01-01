package br.com.api.controllers

import br.com.api.entities.LoginEntitie
import br.com.api.entities.UserEntitie
import br.com.api.repositories.LoginRepositorie
import br.com.api.repositories.UserRepositorie
import br.com.api.utils.DateUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/login")
 open class LoginController(

        @Autowired
        val loginRepositorie : LoginRepositorie,

        @Autowired
        val userRepositorie: UserRepositorie
)
{
    @PostMapping(value = "/efetuarLogin")
    fun efetuarLogin (@RequestBody userEntitie : UserEntitie?) : ResponseEntity<LoginEntitie> {

       val hora = DateUtil().parseDate("hh:mm:ss")
       val user = userRepositorie.getUser(userEntitie!!.userName)
        user.login = emptyList()

        var login : LoginEntitie = LoginEntitie(null, user, hora)
        val response : ResponseEntity<LoginEntitie>
        var loginEntitie : LoginEntitie = loginRepositorie.save(login)
        return loginRepositorie.findById(loginEntitie.idLogin!!).map {resp ->
                ResponseEntity.ok(resp)
             }.orElse(ResponseEntity.ok().build())
    }
}
