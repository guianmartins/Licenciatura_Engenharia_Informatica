xquery version "1.0";


let $nome := doc("input.xml")/input
for $x in doc("paises.xml")//pais
let $lista := $x/cidadesImportantes/cidade
where $x/@nome = $nome
return 
	(
	  "Cidades Importantes:",
	  "&#10;",
	  for $cid at $i in $x/cidadesImportantes/cidade
	  return (
		concat($i, ". ", $cid/text()),
		"&#10;"
	  )
	)
