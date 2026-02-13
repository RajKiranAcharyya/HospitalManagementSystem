package com.rajkiran.acharyya.HospitalManagementSystem.repository;
import com.rajkiran.acharyya.HospitalManagementSystem.entity.Insurance;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance,Long> {

}