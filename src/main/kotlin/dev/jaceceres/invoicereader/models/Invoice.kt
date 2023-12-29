package dev.jaceceres.invoicereader.models

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import java.math.BigDecimal
import java.time.LocalDateTime

@JacksonXmlRootElement(localName = "rDE")
data class Invoice(
    @field:JacksonXmlProperty(localName = "DE")
    var details: InvoiceDetails? = null,
    var fileName: String? = null
)

data class InvoiceDetails(
    @field:JacksonXmlProperty(localName = "gTimb")
    var timbrado: Factura? = null,
    @field:JacksonXmlProperty(localName = "gDatGralOpe")
    var operacion: Operacion? = null,
    @field:JacksonXmlProperty(localName = "gTotSub")
    var transaccion: Transaccion? = null
)

data class Operacion(
    @field:JacksonXmlProperty(localName = "dFeEmiDE")
    var fechaEmision: LocalDateTime? = null,
    @field:JacksonXmlProperty(localName = "gEmis")
    var emisor: Emisor? = null
)

data class Emisor(
    @field:JacksonXmlProperty(localName = "dRucEm")
    var ruc: String? = null,
    @field:JacksonXmlProperty(localName = "dDVEmi")
    var dv: String? = null,
    @field:JacksonXmlProperty(localName = "dNomEmi")
    var nombre: String? = null
)

data class Factura(
    @field:JacksonXmlProperty(localName = "dNumTim")
    var numero: String? = null,
    @field:JacksonXmlProperty(localName = "dEst")
    var dEst: String? = null,
    @field:JacksonXmlProperty(localName = "dPunExp")
    var dPunExp: String? = null,
    @field:JacksonXmlProperty(localName = "dNumDoc")
    var dNumDoc: String? = null
)

data class Transaccion(
    @field:JacksonXmlProperty(localName = "dSubExo")
    var exento: BigDecimal = BigDecimal.ZERO,
    @field:JacksonXmlProperty(localName = "dIVA5")
    var iva5: BigDecimal = BigDecimal.ZERO,
    @field:JacksonXmlProperty(localName = "dIVA10")
    var iva10: BigDecimal = BigDecimal.ZERO,
    @field:JacksonXmlProperty(localName = "dTotGralOpe")
    var total: BigDecimal = BigDecimal.ZERO
)