package dev.jaceceres.invoicereader

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import dev.jaceceres.invoicereader.services.impl.CsvWriterServiceImpl
import dev.jaceceres.invoicereader.services.impl.ParseServiceImpl

fun main() {

    val pathFolder = "/Users/jcaceresf/Documents/personal-documents/invoices-2023/xml-invoices"

    val xmlMapper = XmlMapper(
        JacksonXmlModule().apply { setDefaultUseWrapper(false) }
    ).apply {
        enable(SerializationFeature.INDENT_OUTPUT)
        enable(SerializationFeature.WRAP_ROOT_VALUE)
        disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        registerModule(JavaTimeModule())
    }

    val parserService = ParseServiceImpl(xmlMapper)
    val csvWriterService = CsvWriterServiceImpl()
    val invoices = parserService.parseInvoicesInFolder(pathFolder)

    val summary = parserService.summarizeInvoices(invoices)

    csvWriterService.generateCsvFile(summary)
}