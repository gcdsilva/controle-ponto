## Usuario

### GET - /usuarios
Exibe a lista de usuarios cadastrado com todas as informações.

**Response 200**

[
    {
        "id": 1,
        "nome": "Natan",
        "cpf": "12345678911",
        "email": "teste@teste.com",
        "dataCadastro": "2020-02-26T10:00:00.000+0000"
    },
    {
        "id": 2,
        "nome": "Guilherme",
        "cpf": "12345678901",
        "email": "teste123@testecom",
        "dataCadastro": "2020-02-27T10:00:00.000+0000"
    }
]



### POST /usuarios
Cadastra um novo usuario


**Request Body**

	{  "nome":"Guilherme",
	   "cpf":"12345678901",
	   "email":"test1@teste.com",
	   "dataCadastro":"2020-02-27T10:00:00.000Z"
	}


**Response 201**

{
    "id": 1,
    "nome": "Guilherme",
    "cpf": "12345678901",
    "email": "test1@teste.com",
    "dataCadastro": "2020-02-27T10:00:00.000+0000"
}


### PATCH /usuarios
Atualiza os dados de um cliente. 

**Request Body**

{
"id":"1","nome":"Guilherme",
"cpf":"12345678901",
"email":"alteradoEmail@teste.com",
"dataCadastro":"2020-02-27T10:00:00.000Z"
}

**Response 200**

{"id":"1","nome":"Guilherme",
"cpf":"12345678901",
"email":"alteradoEmail@teste.com",
"dataCadastro":"2020-02-27T10:00:00.000Z"
}


## Ponto

### GET /ponto/{idUsuario}
Exibe a lista de apontamento de um usuário com todas as informações e total de horas


[
    [
        {
            "id": 2,
            "usuario": {
                "id": 1,
                "nome": "Guilherme",
                "cpf": "12345678901",
                "email": "test1@com",
                "dataCadastro": "2020-02-27T10:00:00.000+0000"
            },
            "dataMarcacao": "2020-02-27T14:00:00.000+0000",
            "tipoMarcacao": "ENTRADA"
        },
        {
            "id": 3,
            "usuario": {
                "id": 1,
                "nome": "Guilherme",
                "cpf": "12345678901",
                "email": "test1@com",
                "dataCadastro": "2020-02-27T10:00:00.000+0000"
            },
            "dataMarcacao": "2020-02-27T16:00:00.000+0000",
            "tipoMarcacao": "SAIDA"
        }
    ],
    "Total Horas: 2"
]

### POST /ponto
Cadastro um novo lançamento de ponto eletrônico

**Request Body**

	{
		"usuario":{
		"id": "1",
		  "nome": "Guilherme",
			"cpf": "12345678901",
			"email": "teste@com",
			"dataCadastro": "2020-02-27T10:00:00.000+0000"
		},
		"dataMarcacao":"2020-02-27T16:00:00.000+0000",
		"tipoMarcacao":"SAIDA"
	}


**Response 201**

{
    "id": 3,
    "usuario": {
        "id": 1,
        "nome": "Guilherme",
        "cpf": "12345678901",
        "email": "teste@com",
        "dataCadastro": "2020-02-27T10:00:00.000+0000"
    },
    "dataMarcacao": "2020-02-27T16:00:00.000+0000",
    "tipoMarcacao": "SAIDA"
}

