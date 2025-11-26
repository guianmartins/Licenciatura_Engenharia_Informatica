xquery version "1.0";

<html>
  <head>
    <title>Países Fronteiriços</title>
    <style type="text/css"><![CDATA[
      body { font-family: Arial, sans-serif; background-color: #f4f4f4; text-align: center; }
      h1 { color: #333; }
      ul { list-style-type: none; padding: 0; }
      li { background-color: #fff; margin: 10px auto; padding: 10px; width: 300px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); }
      img { max-height: 20px; vertical-align: middle; margin-right: 10px; }
    ]]></style>
  </head>
  <body>
    {
      let $input := doc("input.xml")/input/text()
      let $pais := doc("paises.xml")//pais[@nome = $input]
      return (
		<table>
			<h1>Países Fronteiriços com { $input }</h1>,
			<ul>
			  {
				for $fronteira in $pais/paisesFronteira/paisFronteira
				let $dados := doc("paises.xml")//pais[@nome = $fronteira]
				let $bandeira := $dados/bandeira
				order by $fronteira
				return
				  <li>
					{$fronteira}
				  </li>
			  }
			</ul>
		</table>
      )
    }
  </body>
</html>
