package br.com.api.br.com.api.entities

import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull


@Entity
@Table(name = "user_assistent")
data class UserEntitie (

        @Id
        @GeneratedValue(generator = "user_sequence")
        @SequenceGenerator(name = "user_sequence", sequenceName = "id_user", initialValue = 1, allocationSize = 1)
        var idUserAssistent: Long,

        @Column(name = "user_name")
        @get: NotBlank
        var userName: String = "",

        @Column(name = "password")
        @NotNull
        var password: String = "",

        @Column(name = "user_level")
        var userLevel:  Character,

        @Column(name = "active")
        var active: Boolean = false
    )
{

}
