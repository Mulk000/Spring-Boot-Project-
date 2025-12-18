package com.codeline.ccsb.Services;

import com.codeline.ccsb.Entity.Course;
import com.codeline.ccsb.Entity.Mark;
import com.codeline.ccsb.helper.Constants;
import com.codeline.ccsb.helper.HelperUtils;
import com.codeline.ccsb.repositories.CourseRepository;
import com.codeline.ccsb.repositories.MarkRepository;
import com.codeline.ccsb.requestObject.MarkCreateRequest;
import com.codeline.ccsb.responseObjects.InstructorCreateResponse;
import com.codeline.ccsb.responseObjects.MarkCreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MarkServices {

    @Autowired
    MarkRepository markRepository;

    @Autowired
    CourseRepository courseRepository;

    public MarkCreateResponse saveMarks(MarkCreateRequest request) throws Exception {
        Mark mark = MarkCreateRequest.ConvertToMark(request);
        mark.setCreatedDate(new Date());
        mark.setIsActive(Boolean.TRUE);

        return MarkCreateResponse.convertToMarkResponse(markRepository.save(mark));


}
    public List<Mark> getAllMarks(){
        return markRepository.findAll();
    }
    public Mark getMarksById(Integer id)throws Exception {
        Mark existingMark = markRepository.findById(id).get();
        if (existingMark != null && existingMark.getIsActive()) {
            return existingMark;
        } else {
            throw new Exception("Bad Request");
        }
    }
        public Mark updateMarks(Mark mark)throws Exception {
            Mark existingMark = markRepository.findById(mark.getId()).get();
            if (existingMark != null && existingMark.getIsActive()) {
                mark.setIsActive(Boolean.FALSE);
                return markRepository.save(mark);
            } else {
                throw new Exception("Bad Request");
            }
        }
        public void deleteMarks(Integer id)throws Exception {
        Mark existingMark = markRepository.findById(id).get();
        if (existingMark != null && existingMark.getIsActive()) {
            existingMark.setIsActive(Boolean.FALSE);
             markRepository.save(existingMark);
        }else {
            throw new Exception("Bad Request");
        }

    }

}
