package com.codeline.ccsb.requestObject;

import com.codeline.ccsb.Entity.Department;
import com.codeline.ccsb.helper.Constants;
import com.codeline.ccsb.helper.HelperUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class DepartmentCreateRequest {
    private String departmentName;
    private List<Integer> instructorsId;
    private List<Integer> courseId;

    public static Department ConvertToDepartment(DepartmentCreateRequest request) throws Exception {
        Department department = new Department();
        department.setDepartmentName(request.getDepartmentName());
        return department;
    }

    public static void validateDepartmentCreateRequest(DepartmentCreateRequest request) throws Exception {
        if (HelperUtils.isNull(request.getDepartmentName()) == null || request.getDepartmentName().isBlank() || request.getDepartmentName().isEmpty()) {
            throw new Exception(Constants.DEPARTMENT_CREATE_REQUEST_DEPARTMENT_NAME_NOT_VALID);
        } else if (HelperUtils.isNull(request.getInstructorsId()) || HelperUtils.isListEmpty(request.getInstructorsId())) {
            throw new Exception(Constants.DEPARTMENT_CREATE_REQUEST_INSTRUCTOR_ID_NOT_VALID);

        } else if (HelperUtils.isNull(request.getCourseId()) || HelperUtils.isListEmpty(request.getCourseId())) {
            throw new Exception(Constants.DEPARTMENT_CREATE_REQUEST_COURSE_ID_NOT_VALID);
        }
    }
}