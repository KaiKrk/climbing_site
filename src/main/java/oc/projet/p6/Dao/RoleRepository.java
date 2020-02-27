package oc.projet.p6.Dao;

import oc.projet.p6.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository des roles
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
    /**
     * methode qui retourne le nom du role du membre
     * @param name
     * @return
     */
    Role findByName(String name);
}
