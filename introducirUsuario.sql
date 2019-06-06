CREATE LOGIN administrador with password = '1234',
DEFAULT_DATABASE = Colegio
USE Colegio
CREATE USER administrador FOR LOGIN administrador
GRANT EXECUTE, INSERT, UPDATE, DELETE, SELECT TO administrador