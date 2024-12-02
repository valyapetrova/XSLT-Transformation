package com.example.employee;

import org.springframework.stereotype.Service;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

@Service
public class EmployeeTransformer {
    public String transformEmployeeXml() throws TransformerException, IOException {
        // Load XML and XSLT files
        try (InputStream xmlStream = getClass().getResourceAsStream("/employees.xml");
             InputStream xsltStream = getClass().getResourceAsStream("/employees_transform.xsl")) {

            if (xmlStream == null || xsltStream == null) {
                throw new FileNotFoundException("XML or XSLT file not found.");
            }

            // Prepare transformation
            TransformerFactory factory = TransformerFactory.newInstance();
            Source xslt = new StreamSource(xsltStream);
            Transformer transformer = factory.newTransformer(xslt);

            Source xml = new StreamSource(xmlStream);

            // Transform XML to String
            StringWriter writer = new StringWriter();
            transformer.transform(xml, new StreamResult(writer));

            return writer.toString();
        }
    }
}
