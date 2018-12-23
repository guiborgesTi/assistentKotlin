package br.com.api.br.com.api.br.com.api.repositories

import br.com.api.br.com.api.entities.UserEntitie
import org.springframework.data.jpa.repository.JpaRepository
import java.io.Serializable

interface UserRepositorie : JpaRepository<UserEntitie, Long> { }