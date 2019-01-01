package br.com.api.entities

import java.util.*
import javax.persistence.*

@Entity
@Table(name="login")
data class LoginEntitie(

    @Id
    @GeneratedValue(generator = "loginSequence")
    @SequenceGenerator(name = "loginSequence", sequenceName = "id_sequence_login")
    val idLogin : Long?,

    @JoinColumn(name = "id_user_assistent")
    @ManyToOne(fetch = FetchType.EAGER)
    var user : UserEntitie? = null,

    @Column(name = "hora_login")
    var horaLogin : Date?
)
{
}
