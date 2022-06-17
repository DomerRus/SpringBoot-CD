package ru.itmo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.model.Organization;
import ru.itmo.model.enums.OrganizationType;

import java.util.Optional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

    Optional<Organization> findByNameAndFullNameAndAndEmployeesCountAndType(String name,
                                                                            String fullName,
                                                                            Long emplCount,
                                                                            OrganizationType organizationType);
}
