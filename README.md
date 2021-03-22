# Java SDK para Integração Juno 

Esta SDK foi desenvolvida para abstrair aos desenvolvedores os principais detalhes da comunicação com nossa API v2 tanto em [produção](https://juno.com.br/#) quanto em ambiente [sandbox](https://sandbox.juno.com.br/#).

Você pode acessar a documentação base aqui:  
dev.juno.com.br/api/v2

# Requisitos

- Java 11 ou superior 

## Guia de uso

Para utilizar a SDK é necessário:

1. Possuir uma conta Juno em produção e/ou sandbox.
2. Gerar credenciais de acesso à API.

**Lembrando:** Deve ser criado uma conta por ambiente e para cada ambiente as credenciais são diferentes. 

Você deve definir que ambiente irá utilizar e inserir suas credenciais para autenticação e assim poder consumir todos os recursos disponíveis.

``` 
JunoApiManager.config()
    .clientId("CLIENTID")
    .clientSecret("SECRET")
    .resourceToken("X-RESOURCE-TOKEN")
    .publicToken("PUBLIC-TOKEN")
    .sandbox();
````

Veja mais em: \
:link: &nbsp; [Dev Juno](https://dev.juno.com.br/api/v2#tag/Componentes)

## Suporte

Em caso de dúvidas, problemas ou sugestões:
falecom@juno.com.br


