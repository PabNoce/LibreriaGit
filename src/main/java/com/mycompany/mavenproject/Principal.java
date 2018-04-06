/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject;

import java.io.IOException;
import org.kohsuke.github.GHCreateRepositoryBuilder;
import org.kohsuke.github.GitHub;

/**
 *
 * @author pnocedalopez
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    static GitHub github;

    public static void main(String[] args) throws IOException {
        github = GitHub.connect();
        nuevoRepositorio("MavenNewRepository");
    }

    /**
     * Crea un repositorio en github
     *
     * @param repoNombre nombre del repositorio
     * @throws IOException
     */
    public static void nuevoRepositorio(String repoNombre) throws IOException {
        GHCreateRepositoryBuilder repo = github.createRepository(repoNombre);
        repo.autoInit(true).create();
        System.out.println("Listo");
    }
}


