package com.example.tarea2p2.Config

class Personas {
    var id: String? = null
    var nombre: String? = null
    var apellido: String? = null
    var telefono: String? = null
    var fechanac: String? = null
    var foto: String? = null

    constructor()
    constructor(
        id: String?,
        nombres: String?,
        apellidos: String?,
        telefono: String?,
        fechanac: String?,
        foto: String?
    ) {
        this.id = id
        this.nombre = nombres
        this.apellido = apellidos
        this.telefono = telefono
        this.fechanac = fechanac
        this.foto = foto
    }
}
