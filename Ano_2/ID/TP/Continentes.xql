xquery version "1.0";


<Continentes>
  {
    for $continente in distinct-values(doc("paises.xml")//continente)
    let $count := count(doc("paises.xml")//pais[continente = $continente])
    return
      <continente nome = "{$continente}">
        <numeroDePaises>{$count}</numeroDePaises>
		<Paises> 
			{	
				for $r in doc("paises.xml")//pais
				where $r/continente = $continente
				order by $r/@nome
				return
					<Pais>{data($r/@nome)}</Pais>
			}	
		</Paises>
      </continente>
  }
</Continentes>