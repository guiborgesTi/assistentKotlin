package br.com.api.repositories

import br.com.api.entities.LoginEntitie
import org.springframework.data.jpa.repository.JpaRepository

interface LoginRepositorie : JpaRepository<LoginEntitie, Long> {}