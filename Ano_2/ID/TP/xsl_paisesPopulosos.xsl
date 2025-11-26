<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" 
      xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:output method="xml" indent="yes" encoding="UTF-8"/>

  <xsl:template match="Paises">
    <Top5>
      <xsl:for-each select="pais">
        <xsl:sort select="populacao" data-type="number" order="descending"/>
        <xsl:if test="position() &lt;= 5">
          <pais>
            <xsl:attribute name="nome">
              <xsl:value-of select="@nome"/>
            </xsl:attribute>
            <populacao><xsl:value-of select="populacao"/></populacao>
          </pais>
        </xsl:if>
      </xsl:for-each>
    </Top5>
  </xsl:template>

</xsl:stylesheet>
