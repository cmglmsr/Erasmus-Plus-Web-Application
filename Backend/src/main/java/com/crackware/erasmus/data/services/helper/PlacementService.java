package com.crackware.erasmus.data.services.helper;

import com.crackware.erasmus.data.model.*;
import com.crackware.erasmus.data.model.enums.Department;
import com.crackware.erasmus.data.model.enums.Status;
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

    public PlacementService(ApplicationService applicationService, PlacementListService placementListService,
                            WaitListService waitListService, SchoolService schoolService, DepartmentQuotaService departmentQuotaService) {
        this.applicationService = applicationService;
        this.placementListService = placementListService;
        this.waitListService = waitListService;
        this.schoolService = schoolService;
        this.departmentQuotaService = departmentQuotaService;
    }

    public void finalizePlacements(){
        ArrayList<Application> applications = new ArrayList<>(applicationService.findAll());

        //Sorts from highest to lowest
        Collections.sort(applications, (lhs, rhs) -> Double.compare(rhs.getPoints(), lhs.getPoints()));

        // Reset department quotas of each school
        ArrayList<School> schools = new ArrayList<>(schoolService.findAll());
        resetQuotas(schools);

        for (int i = 0; i < applications.size(); i++) {
            Application current = applications.get(i);
            Department currentDepartment = current.getDepartment();

            if (checkAvailabilityByDepartment(currentDepartment, current.getSchool1().getDepartmentQuotas())){
                changeQuota(currentDepartment, current.getSchool1().getDepartmentQuotas());
                current.setFinalSchool(current.getSchool1());
                current.setStatus(Status.APPROVED);
                schoolService.save(current.getSchool1());
                applicationService.save(current);

            } else if (checkAvailabilityByDepartment(currentDepartment, current.getSchool2().getDepartmentQuotas())) {
                changeQuota(currentDepartment, current.getSchool2().getDepartmentQuotas());
                current.setFinalSchool(current.getSchool2());
                current.setStatus(Status.APPROVED);
                schoolService.save(current.getSchool2());
                applicationService.save(current);


            } else if (checkAvailabilityByDepartment(currentDepartment, current.getSchool3().getDepartmentQuotas())){
                changeQuota(currentDepartment, current.getSchool3().getDepartmentQuotas());
                current.setFinalSchool(current.getSchool3());
                current.setStatus(Status.APPROVED);
                schoolService.save(current.getSchool3());
                applicationService.save(current);


            } else if (checkAvailabilityByDepartment(currentDepartment, current.getSchool4().getDepartmentQuotas())) {
                changeQuota(currentDepartment, current.getSchool4().getDepartmentQuotas());
                current.setFinalSchool(current.getSchool4());
                current.setStatus(Status.APPROVED);
                schoolService.save(current.getSchool4());
                applicationService.save(current);


            } else if (checkAvailabilityByDepartment(currentDepartment, current.getSchool5().getDepartmentQuotas())) {
                changeQuota(currentDepartment, current.getSchool5().getDepartmentQuotas());
                current.setFinalSchool(current.getSchool5());
                current.setStatus(Status.APPROVED);
                schoolService.save(current.getSchool5());
                applicationService.save(current);
            }
        }
        ArrayList<Application> applications2 = new ArrayList<>(applicationService.findAll());
        ArrayList<Application> finalizedOnes = new ArrayList<>();
        ArrayList<Application> waitingList = new ArrayList<>();
        for (Application application : applications2) {
            if (application.getFinalSchool() != null) {
                finalizedOnes.add(application);
            }else {
                waitingList.add(application);
            }
        }

        // Gets the current one and overwrites it to prevent multiple occurences (SINGLETON).
        if(placementListService.findAll()!=null&&!placementListService.findAll().isEmpty()) {
            Set<PlacementList> pls = placementListService.findAll();
            ArrayList<PlacementList> apls = new ArrayList<>(pls);
            PlacementList pl = apls.get(0);
            pl.setApplications(new HashSet<>(finalizedOnes));
            placementListService.save(pl);
        } else {
            PlacementList placementList = new PlacementList();
            placementList.setApplications(new HashSet<>(finalizedOnes));
            placementListService.save(placementList);}
        if(waitListService.findAll()!=null&&!waitListService.findAll().isEmpty()) {
            Set<WaitList> wls = waitListService.findAll();
            ArrayList<WaitList> awls = new ArrayList<>(wls);
            WaitList wl = awls.get(0);
            wl.setApplications(new HashSet<>(waitingList));
            waitListService.save(wl);
        } else {
            WaitList waitList = new WaitList();
            waitList.setApplications(new HashSet<>(waitingList));
            waitListService.save(waitList);}
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
                return;
            }
        }
    }

    private void resetQuotas(ArrayList<School> schools) {
        for(School s : schools) {
            Set<DepartmentQuota> departmentQuotas = s.getDepartmentQuotas();
            for(DepartmentQuota q: departmentQuotas) {
                q.setQuota(2);
                departmentQuotaService.save(q);
            }
            schoolService.save(s);
        }
    }


}
