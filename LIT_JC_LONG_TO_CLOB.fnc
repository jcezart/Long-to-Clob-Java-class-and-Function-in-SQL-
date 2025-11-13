CREATE OR REPLACE FUNCTION LIT_JC_LONG_TO_CLOB (OWNER_P VARCHAR2, TABELA_P VARCHAR2, COLUNA_P VARCHAR2, ROWID_P VARCHAR2) RETURN CLOB


AS LANGUAGE JAVA
NAME 'LongToClob.byRowId(java.lang.String, java.lang.String, java.lang.String, java.lang.String) return oracle.sql.CLOB';
/
