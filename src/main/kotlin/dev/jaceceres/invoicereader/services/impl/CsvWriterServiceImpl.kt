package dev.jaceceres.invoicereader.services.impl

import dev.jaceceres.invoicereader.extensions.writeCsv
import dev.jaceceres.invoicereader.models.InvoiceSummary
import dev.jaceceres.invoicereader.services.CsvWriterService
import java.io.FileOutputStream

class CsvWriterServiceImpl : CsvWriterService {

    override fun generateCsvFile(invoices: List<InvoiceSummary>) {

        if (invoices.isEmpty()) {
            println("Invoices are empty")
        }

        FileOutputStream("/Users/jcaceresf/Documents/work/kenect/dev/invoice-reader/invoices.csv").apply { writeCsv(invoices) }
    }
}