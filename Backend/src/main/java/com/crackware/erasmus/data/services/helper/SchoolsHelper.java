package com.crackware.erasmus.data.services.helper;

import com.crackware.erasmus.data.model.DepartmentQuota;
import com.crackware.erasmus.data.model.School;
import com.crackware.erasmus.data.model.enums.Department;
import com.crackware.erasmus.data.repositories.DepartmentQuotaRepository;
import com.crackware.erasmus.data.repositories.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;

@Service
public class SchoolsHelper {
    private final SchoolRepository schoolRepository;
    private final DepartmentQuotaRepository departmentQuotaRepository;

    public SchoolsHelper(SchoolRepository schoolRepository, DepartmentQuotaRepository departmentQuotaRepository) {
        this.schoolRepository = schoolRepository;
        this.departmentQuotaRepository = departmentQuotaRepository;
    }

    private HashSet<DepartmentQuota> newSet() {
        DepartmentQuota dqcs = new DepartmentQuota();
        DepartmentQuota dqie = new DepartmentQuota();
        DepartmentQuota dqeee = new DepartmentQuota();
        DepartmentQuota dqme = new DepartmentQuota();
        dqcs.setDepartment(Department.CS);
        dqcs.setQuota(2);
        dqie.setDepartment(Department.IE);
        dqie.setQuota(2);
        dqeee.setDepartment(Department.EE);
        dqeee.setQuota(2);
        dqme.setDepartment(Department.ME);
        dqme.setQuota(2);
        HashSet<DepartmentQuota> s = new HashSet<>();
        s.add(dqcs); s.add(dqeee); s.add(dqie); s.add(dqme);
        return s;
    }

    public ArrayList<School> getSchools() {
        return (ArrayList<School>) schoolRepository.findAll();
    }

    public void setSchoolRepository() {
        // TODO delete quotas, department quotas, schools
        departmentQuotaRepository.deleteAll();
        schoolRepository.deleteAll();
        School s1 = new School();
        School s2 = new School();
        School s3 = new School();
        School s4 = new School();
        School s5 = new School();
        School s6 = new School();
        School s7 = new School();
        School s8 = new School();
        School s9 = new School();
        School s10 = new School();
        School s11 = new School();
        School s12 = new School();
        School s13 = new School();
        School s14 = new School();
        School s15 = new School();
        s1.setName("Ecole Nationale Superieure Des Techniques Industrielles et des Mines DAlbi-Carmaux - France");
        s2.setName("Kingston University - U.K.");
        s3.setName("Roskilde University - Denmark");
        s4.setName("TELECOM ParisTech  - France");
        s5.setName("TU Universitat Dortmund - Germany");
        s6.setName("TU Universitat Berlin - Germany");
        s7.setName("Vrije Universiteit Amsterdam - The Netherlands");
        s8.setName("Ecole Polytechnique Federale de Lausanne (EPFL) - Switzerland");
        s9.setName("Ecole Pour Linformatique Et Les Techniques Avancees (EPITA) - France");
        s10.setName("AGH University of Science and Technology - Poland");
        s11.setName("University of Saarland - Germany");
        s12.setName("University of l'Aquila - Italy");
        s13.setName("École d'ingénieurs du numérique ESIEA - France");
        s14.setName("ESIEE Paris - France");
        s15.setName("Bamberg University");

        HashSet<DepartmentQuota> se1 = newSet();
        HashSet<DepartmentQuota> se2 = newSet();
        HashSet<DepartmentQuota> se3 = newSet();
        HashSet<DepartmentQuota> se4 = newSet();
        HashSet<DepartmentQuota> se5 = newSet();
        HashSet<DepartmentQuota> se6 = newSet();
        HashSet<DepartmentQuota> se7 = newSet();
        HashSet<DepartmentQuota> se8 = newSet();
        HashSet<DepartmentQuota> se9 = newSet();
        HashSet<DepartmentQuota> se10 = newSet();
        HashSet<DepartmentQuota> se11 = newSet();
        HashSet<DepartmentQuota> se12 = newSet();
        HashSet<DepartmentQuota> se13 = newSet();
        HashSet<DepartmentQuota> se14 = newSet();
        HashSet<DepartmentQuota> se15 = newSet();

        s1.setDepartmentQuotas(se1);
        s2.setDepartmentQuotas(se2);
        s3.setDepartmentQuotas(se3);
        s4.setDepartmentQuotas(se4);
        s5.setDepartmentQuotas(se5);
        s6.setDepartmentQuotas(se6);
        s7.setDepartmentQuotas(se7);
        s8.setDepartmentQuotas(se8);
        s9.setDepartmentQuotas(se9);
        s10.setDepartmentQuotas(se10);
        s11.setDepartmentQuotas(se11);
        s12.setDepartmentQuotas(se12);
        s13.setDepartmentQuotas(se13);
        s14.setDepartmentQuotas(se14);
        s15.setDepartmentQuotas(se15);

        schoolRepository.save(s1);
        schoolRepository.save(s2);
        schoolRepository.save(s3);
        schoolRepository.save(s4);
        schoolRepository.save(s5);
        schoolRepository.save(s6);
        schoolRepository.save(s7);
        schoolRepository.save(s8);
        schoolRepository.save(s9);
        schoolRepository.save(s10);
        schoolRepository.save(s11);
        schoolRepository.save(s12);
        schoolRepository.save(s13);
        schoolRepository.save(s14);
        schoolRepository.save(s15);
    }
}
