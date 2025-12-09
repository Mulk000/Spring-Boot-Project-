package com.codeline.ccsb.Controller;

import com.codeline.ccsb.Entity.Mark;
import com.codeline.ccsb.Services.MarkServices;
import com.codeline.ccsb.requestObject.MarkCreateRequest;
import com.codeline.ccsb.responseObjects.MarkCreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/marks")
public class MarkController {

    @Autowired
    MarkServices markServices;

    @PostMapping("/create")
    public MarkCreateResponse createMarks(@RequestBody MarkCreateRequest requestedObj) throws Exception {
       MarkCreateRequest.validCreatesMarkRequestObject(requestedObj);
       return markServices.saveMarks(requestedObj);

    }
    @GetMapping("/getAll")
    public List<Mark> getAllMarks(){
      List<Mark> markList = markServices.getAllMarks();
      return markList;

    }
    @GetMapping("/getMarksById")
    public Mark getMarksById(@RequestParam Integer id)throws Exception{
        return markServices.getMarksById(id);
    }
    @PutMapping("/update")
    public Mark updateMarks(@RequestBody Mark updatedObjFromUser)throws Exception{
        return markServices.updateMarks(updatedObjFromUser);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMarks(@PathVariable Integer id)throws Exception{
        markServices.deleteMarks(id);
        return "Marks deleted successfully";
    }


}
