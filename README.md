# Compactador e Descompactador de Arquivos
Projeto da Matéria Estrutura de Dados

Proposta:

Um	esquema	simples	para	criar	uma	versão	compactada	de	um	arquivo	texto	pode	ser	utilizado	para	
arquivos	que	não	possuem	caracteres	numéricos	(dígitos).	O	esquema	de	compressão	requer	que	seja	
criada	 uma	 lista	 de	 palavras	 do	 arquivo	 não	 compactado.	 Quando	 um	 caractere não	 alfabético
(diferente	 de	 letra)	 é encontrado	 no	 arquivo	 não	 compactado,	 ele	 é copiado	 diretamente	 para	 o	
arquivo	compactado.	Quando	uma	palavra	é encontrada	no	arquivo	não	compactado,	ela	é copiada	
diretamente	para	o	arquivo	compactado	apenas	se	esta	 for	a	primeira	ocorrência	da	palavra.	Nesse	
caso,	a	palavra	é colocada	no	início da	lista.	Se	não	for	a	primeira	ocorrência,	a	palavra	não	é copiada	
para	o	arquivo	compactado.	Ao	invés	disso,	sua	posição	na	lista	é copiada	no	arquivo	compactado	e	a	
palavra	é movida	para	o	início da	lista.	A	numeração	da	lista	começa	em	1.
Para	os	propósitos	deste	problema,	você pode	assumir	que	nenhuma	palavra	contém	mais	do	que	50	
caracteres	e	que	o	arquivo	original	não	compactado	não	possui	caracteres	numéricos.	Uma palavra	é
definida	como	uma	sequência	máxima	de	letras	maiúsculas	e/ou	minúsculas.	Palavras	são	sensíveis	ao	
caso,	a	palavra	abc é diferente	da	palavra	Abc.
Para	armazenar	as palavras	do	arquivo	utilize	uma	lista	encadeada como	estrutura	de	dados.
