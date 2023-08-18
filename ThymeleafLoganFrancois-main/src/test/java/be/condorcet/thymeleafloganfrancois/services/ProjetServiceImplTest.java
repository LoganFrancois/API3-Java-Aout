package be.condorcet.thymeleafloganfrancois.services;

import be.condorcet.thymeleafloganfrancois.entities.Employe;
import be.condorcet.thymeleafloganfrancois.entities.Projet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import be.condorcet.thymeleafloganfrancois.services.InterfEmployeService;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootTest
class ProjetServiceImplTest {

    @Autowired
    private EmployeServiceImpl empServiceImpl;
    Projet projet;
    Employe emp;
@Autowired
private ProjetServiceImpl projetServiceImpl;


    @BeforeEach
    void setUp() {
        try{
            emp = new Employe(null, "MataTest", "NTest", "PaTest", "TaTest", "ta@test.be",new ArrayList<>());
            empServiceImpl.create(emp);

            projet = new Projet(null,"Salutss",Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.now()),new BigDecimal(1000),emp);
            projetServiceImpl.create(projet);
            System.out.println("création du projet : "+projet);
        }
        catch (Exception e){
            System.out.println("erreur de création de commande "+e);
        }
    }

    @AfterEach
    void tearDown() {
        try{
            projetServiceImpl.delete(projet);
        }
        catch(Exception e){
            System.out.println("erreur d'effacement de projet "+e);
        }
        try{
            empServiceImpl.delete(emp);
        }
        catch(Exception e){
            System.out.println("erreur d'effacement de l'employe "+e);
        }
    }

    @Test
    void create() {
    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void all() {
    }

    @Test
    void getProjets() {
    }
}