package br.com.api.repositories

import br.com.api.entities.UserEntitie
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface UserRepositorie : JpaRepository<UserEntitie, Long> {
    @Query(value = "select user from UserEntitie user where user.userName=:userName")
    fun getUser(@Param ("userName") userName : String) : UserEntitie
}