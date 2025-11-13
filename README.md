# 🔄 Long-to-CLOB Java Class and PL/SQL Function for Oracle Database

**Propósito:** Converter colunas do tipo `LONG` em `CLOB` dentro do Oracle, utilizando Java armazenado (Java Stored Procedure).  
**Repositório:** [Long-to-Clob-Java-class-and-Function-in-SQL](https://github.com/jcezart/Long-to-Clob-Java-class-and-Function-in-SQL-)

---

## 🧠 Contexto

Algumas tabelas legadas em bancos Oracle ainda armazenam grandes blocos de texto em colunas do tipo `LONG`.  
Porém, esse tipo de dado é **obsoleto e incompatível com várias funções modernas do Oracle**, como JSON, manipulação de texto via `REGEXP`, e consultas dinâmicas.

Este projeto apresenta uma **solução segura e performática** para **converter dados LONG em CLOB**, diretamente dentro do banco de dados, sem precisar exportar os dados.

---

## ⚙️ Como usar

SELECT
  LIT_JC_LONG_TO_CLOB('OWNER', 'NOME_TABELA', 'NOME_COLUNA', ROWID) AS TEXTO_CLOB
FROM NOME_TABELA
WHERE ROWNUM = 1;

---


🧑‍💻 Autor

Julio Cezar Grassi Teixeira
Healthcare IT & Android Developer


