package br.com.api.utils

import java.io.Serializable

open class PgObject(

    var key : String,
    var value : String
     ) : Serializable {
}