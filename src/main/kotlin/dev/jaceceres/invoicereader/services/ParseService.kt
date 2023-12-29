package dev.jaceceres.invoicereader.services

import dev.jaceceres.invoicereader.models.Invoice
import dev.jaceceres.invoicereader.models.InvoiceSummary

interface ParseService {

    fun parseInvoice(filePath: String): Invoice

    fun parseInvoicesInFolder(folderPath: String): List<Invoice>

    fun summarizeInvoices(invoices: List<Invoice>): List<InvoiceSummary>
}