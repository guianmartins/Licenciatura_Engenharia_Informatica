<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="text" encoding="UTF-8"/>
  
  <xsl:template match="Paises">
    <xsl:for-each select="pais">
      <xsl:value-of select="@nome"/>:<xsl:text>&#10;</xsl:text>
      <xsl:text>- Línguas: </xsl:text>
      <xsl:for-each select="linguasOficiais/lingua">
        <xsl:value-of select="."/>
        <xsl:if test="position() != last()">, </xsl:if>
      </xsl:for-each>
      <xsl:text>&#10;</xsl:text>
      <xsl:text>- Religiões: </xsl:text>
      <xsl:for-each select="religioes/religiao">
        <xsl:value-of select="."/>
        <xsl:if test="position() != last()">, </xsl:if>
      </xsl:for-each>
      <xsl:text>&#10;&#10;</xsl:text>
    </xsl:for-each>
  </xsl:template>
</xsl:stylesheet>
