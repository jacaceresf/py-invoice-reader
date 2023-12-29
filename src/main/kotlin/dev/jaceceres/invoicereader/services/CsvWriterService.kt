package dev.jaceceres.invoicereader.services

import dev.jaceceres.invoicereader.models.InvoiceSummary

fun interface CsvWriterService {

    fun generateCsvFile(invoices: List<InvoiceSummary>)

}