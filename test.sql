
CREATE DATABASE test;

USE test;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(50) NOT NULL,
    senha VARCHAR(50) NOT NULL,
    nome VARCHAR(100) NOT NULL
);

INSERT INTO usuarios (login, senha, nome) VALUES
('usuario1', 'senha1', 'João Silva'),
('usuario2', 'senha2', 'Maria Oliveira'),
('usuario3', 'senha3', 'Pedro Santos');
