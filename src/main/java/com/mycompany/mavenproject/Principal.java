/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject;

import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

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

    public static void main(String[] args) throws IOException, GitAPIException {
        github = GitHub.connect();
        int option;
        nuevoRepositorio("MavenNewRepository");
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("--------Menú--------"
                    + "\nPulsa 1 Para crear repositorio"
                    + "\nPulsa 2 Para borrar un repositorio"
                    + "\nPulsa 3 Para hacer un commit"
                    + "\nPulsa 4 Para clonar un repositorio"
            ));
            switch (option) {
                case 1: {
                    nuevoRepositorio(JOptionPane.showInputDialog("Introduce nombre del repositorio"));
                    break;
                }
                //Falta borrar repositorio
                //Falta hacer commit
                case 4: {
                    Git.cloneRepository().setURI("https://github.com/PabNoce/MaquinaCafeCD.git")
                            .setDirectory(new File("/home/local/DANIELCASTELAO/pnocedalopez/NetBeansProjects/MavenProject/.git/"))
                            .call();
                }
            }
        } while (option == 0);
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
