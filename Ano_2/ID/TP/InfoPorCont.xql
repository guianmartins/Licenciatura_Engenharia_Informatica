xquery version "1.0";

let $cont := doc("input.xml")/input/text()
return
<html>
  <head>
    <style type="text/css"><![CDATA[
      body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f9f9f9;
        color: #444;
        margin: 0;
        padding: 0;
        box-sizing: border-box;
      }

      h2 {
        color: #567572;
        margin-top: 50px;
        text-align: center;
        font-size: 2.5em;
      }

      table {
        margin: 50px auto;
        width: 80%;
        border-collapse: collapse;
        background-color: #ffffff;
        box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
      }

      th, td {
        padding: 15px;
        text-align: center;
        border: 1px solid #e0e0e0;
      }

      th {
        background-color: #696667;
        color: #ffffff;
        font-size: 1.2em;
      }


      img {
        max-height: 40px;
        max-width: 60px;
        object-fit: contain;
      }

      td, th {
        font-size: 1.1em;
        font-weight: normal;
      }

      h2 {
        text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2);
      }
	  
    ]]></style>
  </head>
  <body>
    <h2>Países da {$cont}</h2>
    <table>
      <tr>
        <th>Nome</th>
        <th>Capital</th>
        <th>Bandeira</th>
      </tr>
      {
        for $p in doc("paises.xml")//pais
        where $p/continente = $cont
        return 
          <tr>
            <td>{data($p/@nome)}</td>
            <td>{$p/capital}</td>
            <td><img src="https:{$p/bandeira}"/></td>
          </tr>
      }
    </table>
  </body>
</html>
