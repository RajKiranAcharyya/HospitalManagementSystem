package com.rajkiran.acharyya.HospitalManagementSystem;

import com.rajkiran.acharyya.HospitalManagementSystem.entity.*;
import com.rajkiran.acharyya.HospitalManagementSystem.repository.*;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@RequiredArgsConstructor
class HospitalManagementSystemApplicationTests {


	@Autowired
	private PatientRepository patientRepository;
    @Autowired
    private ListableBeanFactory listableBeanFactory;

    //	@Autowired
//	private patientservice ps;
//	@Test
//	public void patientviewtable_test(){
//		List<patient> ptlist= patientRepository.findAll();
//		System.out.println(ptlist);
//	}
//
//	@Test
//	public void patientbyid(){
//		System.out.println(ps.getpatientbyid(2));
//	}
    @Test
    public void patientbyDieaseAndAge () {
        System.out.println(patientRepository.findByDiseaseAndAge("Diabetes", 3));
    }
    @Test
    public void patientByNameContaining () {
        System.out.println(patientRepository.findByNameContaining("Ka"));
    }
    @Test
    void testFindByBirthDateOrderByIdDesc() {
        List<Patient> patients =
                patientRepository.findByBirthDateOrderByIdDesc(
                        LocalDate.of(1990, 5, 10)
                );
        System.out.println(patients);
    }
//    @Test
//    void findByGender(){
//        List<Patient> li=patientRepository.findByGender_By_JPQL("Male");
//        for(Patient lis: li){
//            System.out.println(lis);
//        }
//    }
    @Test
    void findByGenderByMe(){
        List<Patient> li=patientRepository.findByGender_By_Me("Male");
        for(Patient lis: li){
            System.out.println(lis);
        }
    }

    @Test
    void patientAfterDate(){
        List<Patient> li=patientRepository.findByBirthDateAfter(LocalDate.of(1992,1,1));
        for(Patient lis: li){
            System.out.println(lis);
        }
    }

    @Test
    void GROUPBloodGroups(){
        List<Object[]> li=patientRepository.countbybloodgroup();
        for(Object[] lis: li){
            System.out.println(lis[0]+" "+lis[1]);
        }
    }

    @Test
    void changename(){
//        System.out.println(patientRepository.updateName(2,"Diya Patel"));
        Patient pt1=patientRepository.findById(2).orElseThrow();
        pt1.setName("Diya Patel1");
        patientRepository.save(pt1);
        pt1.setAge(45);
    }

    @Test
    void watchPatientsByPage(){
        Page<Patient> ptm=patientRepository.findAllPatient(PageRequest.of(0,2));
        for(Patient lis: ptm){
            System.out.println(lis);
        }
    }
}