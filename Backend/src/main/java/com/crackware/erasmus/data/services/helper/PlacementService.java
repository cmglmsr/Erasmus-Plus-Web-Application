package com.crackware.erasmus.data.services.helper;

import com.crackware.erasmus.data.model.Application;
import com.crackware.erasmus.data.model.DepartmentQuota;
import com.crackware.erasmus.data.model.PlacementList;
import com.crackware.erasmus.data.model.WaitList;
import com.crackware.erasmus.data.model.enums.Department;
import com.crackware.erasmus.data.services.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PlacementService {

    private final ApplicationService applicationService;

    private final PlacementListService placementListService;

    private final WaitListService waitListService;

    private final SchoolService schoolService;

    private final DepartmentQuotaService departmentQuotaService;

    private final StudentService studentService;

    public PlacementService(ApplicationService applicationService, PlacementListService placementListService,
                            WaitListService waitListService, SchoolService schoolService, DepartmentQuotaService departmentQuotaService, StudentService studentService) {
        this.applicationService = applicationService;
        this.placementListService = placementListService;
        this.waitListService = waitListService;
        this.schoolService = schoolService;
        this.departmentQuotaService = departmentQuotaService;
        this.studentService = studentService;
    }

    public void finalizePlacements(){
        ArrayList<Application> applications = new ArrayList<>(applicationService.findAll());
        Collections.sort(applications, (lhs, rhs) -> Double.compare(rhs.getPoints(), lhs.getPoints()));

        for (int i = 0; i < applications.size(); i++) {
            Application current = applications.get(i);
            Department currentDepartment = current.getDepartment();
            System.out.println(current.getStudent().getName());
            System.out.println(current.getSchool1().getName());

            if (checkAvailabilityByDepartment(currentDepartment, current.getSchool1().getDepartmentQuotas())){
                changeQuota(currentDepartment, current.getSchool1().getDepartmentQuotas());
                current.setFinalSchool(current.getSchool1());
                schoolService.save(current.getSchool1());
                studentService.save(current.getStudent());

            } else if (checkAvailabilityByDepartment(currentDepartment, current.getSchool2().getDepartmentQuotas())) {
                changeQuota(currentDepartment, current.getSchool2().getDepartmentQuotas());
                current.setFinalSchool(current.getSchool2());
                schoolService.save(current.getSchool2());
                studentService.save(current.getStudent());


            } else if (checkAvailabilityByDepartment(currentDepartment, current.getSchool3().getDepartmentQuotas())){
                changeQuota(currentDepartment, current.getSchool3().getDepartmentQuotas());
                current.setFinalSchool(current.getSchool3());
                schoolService.save(current.getSchool3());
                studentService.save(current.getStudent());


            } else if (checkAvailabilityByDepartment(currentDepartment, current.getSchool4().getDepartmentQuotas())) {
                changeQuota(currentDepartment, current.getSchool4().getDepartmentQuotas());
                current.setFinalSchool(current.getSchool4());
                schoolService.save(current.getSchool4());
                studentService.save(current.getStudent());


            } else if (checkAvailabilityByDepartment(currentDepartment, current.getSchool5().getDepartmentQuotas())) {
                changeQuota(currentDepartment, current.getSchool5().getDepartmentQuotas());
                current.setFinalSchool(current.getSchool5());
                schoolService.save(current.getSchool5());
                studentService.save(current.getStudent());

            }
        }
        ArrayList<Application> finalizedOnes = new ArrayList<>();
        ArrayList<Application> waitingList = new ArrayList<>();
        for (Application application : applications) {
            if (application.getFinalSchool() != null) {
                finalizedOnes.add(application);
            }else {
                waitingList.add(application);
            }
        }
        PlacementList placementList = new PlacementList();
        placementList.setApplications(new HashSet<>(finalizedOnes));

        WaitList waitList = new WaitList();
        waitList.setApplications(new HashSet<>(waitingList));

        placementListService.deleteAll();
        waitListService.deleteAll();
        placementListService.save(placementList);
        waitListService.save(waitList);
    }

    private boolean checkAvailabilityByDepartment(Department department, Set<DepartmentQuota> departmentQuota){
        HashSet<DepartmentQuota> departmentQuotas = new HashSet<>(departmentQuota);
        for (DepartmentQuota current : departmentQuotas) {
            if (current.getDepartment() == department) {
                if (current.getQuota() > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private void changeQuota(Department department, Set<DepartmentQuota> departmentQuota){
        HashSet<DepartmentQuota> departmentQuotas = new HashSet<>(departmentQuota);
        for (DepartmentQuota current : departmentQuotas) {
            if (current.getDepartment() == department) {
                current.setQuota(current.getQuota() - 1);
                departmentQuotaService.save(current);
            }
        }
    }


}
