<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
      xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:output method="html" encoding="UTF-8" indent="yes"/>

  <xsl:template match="Paises">
    <html>
      <head>
        <title>Fotos dos Países</title>
        <style>
          body {
            font-family: Arial, sans-serif;
            background-color: #f4f7f9;
            margin: 0;
            padding: 0;
          }

          h2 {
            text-align: center;
            margin-top: 30px;
            color: #333;
          }

          table {
            border-collapse: collapse;
            width: 90%;
            max-width: 1000px;
            margin: 30px auto;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            background-color: white;
            border-radius: 8px;
            overflow: hidden;
          }

          th, td {
            padding: 15px;
            text-align: center;
          }

          th {
            background-color: #007acc;
            color: white;
            font-size: 18px;
          }

         

          img {
            max-height: 120px;
            border-radius: 4px;
            box-shadow: 0 1px 4px rgba(0,0,0,0.2);
          }
        </style>
      </head>
      <body>
        <h2>Bandeiras dos Países</h2>
        <table>
          <tr>
            <th>País</th>
            <th>Bandeira</th>
          </tr>
          <xsl:for-each select="pais">
            <xsl:sort select="@nome" data-type="text" order="ascending"/>
            <tr>
              <td><xsl:value-of select="@nome"/></td>
              <td>
                <img>
                  <xsl:attribute name="src">
                    https:<xsl:value-of select="bandeira"/>
                  </xsl:attribute>
                  <xsl:attribute name="alt">
                    Bandeira de <xsl:value-of select="@nome"/>
                  </xsl:attribute>
                </img>
              </td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>

</xsl:stylesheet>
