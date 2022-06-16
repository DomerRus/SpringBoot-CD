package ru.itmo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.itmo.model.Organization;
import ru.itmo.model.enums.OrganizationType;

import javax.ejb.EJB;
import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

    Optional<Organization> findByNameAndFullNameAndAndEmployeesCountAndType(String name,
                                                                            String fullName,
                                                                            Long emplCount,
                                                                            OrganizationType organizationType);
}
