![Travis (.com)](https://app.travis-ci.com/gustavo-veiga/iti-backend-challenge.svg?branch=master)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=gustavo-veiga_iti-backend-challenge&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=gustavo-veiga_iti-backend-challenge)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=gustavo-veiga_iti-backend-challenge&metric=coverage)](https://sonarcloud.io/summary/new_code?id=gustavo-veiga_iti-backend-challenge)

# Descrição

Considere uma senha sendo válida quando a mesma possuir as seguintes definições:

- Nove ou mais caracteres
- Ao menos 1 dígito
- Ao menos 1 letra minúscula
- Ao menos 1 letra maiúscula
- Ao menos 1 caractere especial
  - Considere como especial os seguintes caracteres: !@#$%^&*()-+
- Não possuir caracteres repetidos dentro do conjunto

Exemplo:  

```c#
IsValid("") // false  
IsValid("aa") // false  
IsValid("ab") // false  
IsValid("AAAbbbCc") // false  
IsValid("AbTp9!foo") // false  
IsValid("AbTp9!foA") // false
IsValid("AbTp9 fok") // false
IsValid("AbTp9!fok") // true
```

> **_Nota:_**  Espaços em branco não devem ser considerados como caracteres válidos.

## Problema

Construa uma aplicação que exponha uma api web que valide se uma senha é válida.

Input: Uma senha (string).  
Output: Um boolean indicando se a senha é válida.

## Como executar

Com Gradle:
```bash
./gradlew run
```

Com Docker:
```bash
docker run -d -it --name iti -p 8080:8080 gustaveiga/iti-challenge:0.0.1
```

## Solução
O Uso de beans validation para validação dos dados,  possibilitando a consistência das informações em diferentes camadas.
Foram criadas validações customizadas para cada cenário de validação:
- **@LowerCase**, valida se uma string contém ao menos, um caractere minusculo.
- **@UpperCase**, valida se uma string contém ao menos, um caractere maiúsculo.
- **@NoWhitespaces**, valida se uma string contém um ou mais caractere em branco ou similar (como tabulação, retorno de carro, quebra de linha, outros espaçamentos unicode, etc)
- **@SpecialCharacters**, valida se uma string contém pelo menos um caractere especial dos previamente definidos ou customizado.
- **@NoRepeatedCharacters**, valida se uma string contém caracteres repetidos.
- **@Password**, composição do tipo "AND" de todas as anteriores, mais a validação de no mínimo 9 caracteres.
