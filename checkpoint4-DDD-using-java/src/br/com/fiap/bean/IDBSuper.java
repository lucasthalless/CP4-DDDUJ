package br.com.fiap.bean;

import java.io.IOException;

// Lucas Thalles dos Santos
// RM 558886
public interface IDBSuper {
    DragonBallSuper ler(String path) throws IOException;
    String gravar(String path);
}