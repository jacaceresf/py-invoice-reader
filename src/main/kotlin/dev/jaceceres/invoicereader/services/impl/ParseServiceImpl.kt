package dev.jaceceres.invoicereader.services.impl

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import dev.jaceceres.invoicereader.models.Invoice
import dev.jaceceres.invoicereader.models.InvoiceSummary
import dev.jaceceres.invoicereader.services.ParseService
import dev.jaceceres.invoicereader.utils.InvoiceUtils
import java.io.File

class ParseServiceImpl(private val xmlMapper: XmlMapper) : ParseService {


    override fun parseInvoice(filePath: String): Invoice {

        require(filePath.isNotBlank()) {
            "File path cannot be null or blank"
        }

        val invoiceFile = File(filePath)

        val invoice = xmlMapper.readValue(
            invoiceFile,
            Invoice::class.java
        );

        invoice.fileName = invoiceFile.nameWithoutExtension;
        return invoice;
    }

    override fun parseInvoicesInFolder(folderPath: String): List<Invoice> {
        require(folderPath.isNotBlank()) {
            "Folder path cannot be null or blank"
        }

        val invoices = ArrayList<Invoice>()
        File(folderPath).walkTopDown().forEach {
            if (it.isFile && it.extension == "xml") {
                invoices.add(parseInvoice(it.absolutePath))
            }
        }

        invoices.sortBy { it.details?.operacion?.fechaEmision }

        return invoices
    }

    override fun summarizeInvoices(invoices: List<Invoice>): List<InvoiceSummary> {

        val invoiceSummary = ArrayList<InvoiceSummary>()

        invoices.forEach {
            invoiceSummary.add(
                InvoiceSummary(
                    it.details?.timbrado?.numero,
                    "${it.details?.operacion?.emisor?.ruc}-${it.details?.operacion?.emisor?.dv}",
                    InvoiceUtils.buildInvoiceNumber(it.details?.timbrado),
                    InvoiceUtils.formatAmount(it.details?.transaccion?.iva5),
                    InvoiceUtils.formatAmount(it.details?.transaccion?.iva10),
                    InvoiceUtils.formatAmount(it.details?.transaccion?.exento),
                    InvoiceUtils.formatAmount(it.details?.transaccion?.total),
                    InvoiceUtils.formatDatetime(it.details?.operacion?.fechaEmision)
                )
            )
        }

        return invoiceSummary

    }
}