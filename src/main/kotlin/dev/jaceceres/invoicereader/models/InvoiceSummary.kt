package dev.jaceceres.invoicereader.models

import java.math.BigDecimal

data class InvoiceSummary(
    val timbrado: String? = null,
    val ruc: String? = null,
    val numeroFactura: String? = null,
    val iva5: BigDecimal? = null,
    val iva10: BigDecimal? = null,
    val exento: BigDecimal? = null,
    val monto: BigDecimal? = null,
    val fecha: String? = null
)