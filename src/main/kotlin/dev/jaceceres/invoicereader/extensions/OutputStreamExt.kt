package dev.jaceceres.invoicereader.extensions

import dev.jaceceres.invoicereader.models.InvoiceSummary
import java.io.OutputStream

fun OutputStream.writeCsv(invoices: List<InvoiceSummary>) {
    val writer = bufferedWriter()

    /// header
    writer.write("fecha, timbrado, ruc, numerofactura, iva5, iva10, exento, monto")
    writer.newLine()
    invoices.forEach {
        writer.write("${it.fecha},${it.timbrado},${it.ruc},${it.numeroFactura},${it.iva5},${it.iva10},${it.exento},${it.monto}")
        writer.newLine()
    }

    writer.flush()
}