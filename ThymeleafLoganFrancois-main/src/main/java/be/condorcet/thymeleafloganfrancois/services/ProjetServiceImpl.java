package be.condorcet.thymeleafloganfrancois.services;
import be.condorcet.thymeleafloganfrancois.entities.Employe;
import be.condorcet.thymeleafloganfrancois.entities.Projet;

import java.math.BigDecimal;
import java.util.List;

import be.condorcet.thymeleafloganfrancois.repositories.EmployeRepository;
import be.condorcet.thymeleafloganfrancois.repositories.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
//@Service
@Transactional(rollbackOn = Exception.class)
public class ProjetServiceImpl implements InterfProjetService{

    @Autowired
    private ProjetRepository projetRepository;

    @Autowired
    private EmployeRepository employeRepository;


    @Override
    public Projet create(Projet projet) throws Exception {
        projetRepository.save(projet);
        return projet;
    }
    @Override
    public Projet read(Integer id) throws Exception {
        return projetRepository.findById(id).get();
    }
    @Override
    public Projet update(Projet projet) throws Exception {
        projetRepository.save(projet);
        return projet;
    }
    @Override
    public void delete(Projet projet) throws Exception {
        projetRepository.deleteById(projet.getIdprojet());
    }
    @Override
    public List<Projet> all() throws Exception {
        return projetRepository.findAll();
    }

  @Override
    public List<Projet> getProjets(Employe emp) {
        List<Projet> lp = projetRepository.findProjetByEmploye(emp);
        return lp;
    }


    @Override
    public List<Projet> getProjetsByNom(String nom) {
        List<Projet> lp = projetRepository.findProjetByNomprojStartingWith(nom);
        return lp;
    }

    @Override
    public List<Projet>getProjetsByCout(BigDecimal cout){
        List<Projet> lp = projetRepository.findProjetByCoutGreaterThanEqual(cout);
        return lp;
    }
}



