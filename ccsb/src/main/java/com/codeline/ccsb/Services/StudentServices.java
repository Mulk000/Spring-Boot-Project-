package com.codeline.ccsb.Services;

import com.codeline.ccsb.Entity.Address;
import com.codeline.ccsb.Entity.Course;
import com.codeline.ccsb.Entity.PhoneNumber;
import com.codeline.ccsb.Entity.Student;
import com.codeline.ccsb.helper.Constants;
import com.codeline.ccsb.helper.HelperUtils;
import com.codeline.ccsb.repositories.AddressRepository;
import com.codeline.ccsb.repositories.PhoneNumberRepository;
import com.codeline.ccsb.repositories.StudentRepository;
import com.codeline.ccsb.requestObject.StudentCreateRequest;
import com.codeline.ccsb.responseObjects.StudentCreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentServices {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    PhoneNumberRepository phoneNumberRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public StudentCreateResponse saveStudent(StudentCreateRequest request) throws Exception {
        Student student = StudentCreateRequest.convertToStudent(request);
        student.setCreatedDate(new Date());
        student.setIsActive(Boolean.TRUE);

        Address address = addressRepository.getAddressById(request.getAddressId());
        if (HelperUtils.isNotNull(address)) {
            student.setAddress(address);
        } else {
            throw new Exception(Constants.STUDENT_CREATE_REQUEST_ADDRESS_NOT_VALID);

        }
        List<PhoneNumber> phoneNumbers = phoneNumberRepository.getPhoneNumberById(request.getPhoneNumbersId());
        if (HelperUtils.isNotNull(phoneNumbers) && !HelperUtils.isListEmpty(phoneNumbers)) {
            student.setPhoneNumbers(phoneNumbers);
        } else {
            throw new Exception(Constants.STUDENT_CREATE_REQUEST_PHONE_NUMBER_ID_NOT_VALID);
        }
        return StudentCreateResponse.ConvertToStudentResponse(studentRepository.save(student));

    }
        public Student updateStudent(Student student) throws Exception {
            Student existingStudent = studentRepository.findById(student.getId()).get();
            if (existingStudent != null && existingStudent.getIsActive()) {
                student.setUpdatedDate(new Date());
                return studentRepository.save(student);
            } else {
                throw new Exception("BAD REQUEST");
            }
        }

        public void deleteStudent(Integer id) throws Exception {
            Student existingStudent = studentRepository.findById(id).get();
            if (existingStudent != null && existingStudent.getIsActive()) {
                existingStudent.setUpdatedDate(new Date());
                existingStudent.setIsActive(Boolean.FALSE);
                studentRepository.save(existingStudent);
            } else {
                throw new Exception("BAD REQUEST");
            }
        }

        public Student getStudentById(Integer id) throws Exception {
            Student existingStudent = studentRepository.findById(id).get();
            if (existingStudent != null && existingStudent.getIsActive()) {
                return existingStudent;
            } else {
                throw new Exception("BAD REQUEST");
            }

    }
}
