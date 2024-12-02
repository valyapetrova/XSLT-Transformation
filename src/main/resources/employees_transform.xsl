<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:emp="http://example.com/employee">
    <xsl:output method="html" indent="yes"/>
    <xsl:template match="/emp:company">
        <html>
            <head>
                <title>Employee Report</title>
            </head>
            <body>
                <h1>Employee Details</h1>
                <table border="1">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Department</th>
                        <th>Salary</th>
                    </tr>
                    <xsl:for-each select="emp:employee">
                        <tr>
                            <td><xsl:value-of select="emp:id"/></td>
                            <td><xsl:value-of select="emp:name"/></td>
                            <td><xsl:value-of select="emp:department"/></td>
                            <td><xsl:value-of select="emp:salary"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
