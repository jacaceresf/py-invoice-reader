package dev.jaceceres.invoicereader.utils

import dev.jaceceres.invoicereader.models.Factura
import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object InvoiceUtils {

    private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")

    /// nro factura = dEst-dPunExp-dNumDoc
    fun buildInvoiceNumber(factura: Factura?): String {
        return "${factura?.dEst}-${factura?.dPunExp}-${factura?.dNumDoc}"
    }

    fun formatAmount(amount: BigDecimal?): BigDecimal? {
        return amount?.setScale(0, RoundingMode.UP)
    }

    fun formatDatetime(invoiceDateTime: LocalDateTime?): String? {
        return invoiceDateTime?.format(formatter)
    }
}