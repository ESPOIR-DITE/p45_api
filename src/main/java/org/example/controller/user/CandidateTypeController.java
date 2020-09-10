package org.example.controller.user;

import org.example.controller.Icontroller;
import org.example.domain.user.CandidateType;
import org.example.service.user.CandidateTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("p45_api/candidate_type")
public class CandidateTypeController implements Icontroller<CandidateType,String> {
    @Autowired
    private CandidateTypeService candidateTypeService;

    @PostMapping("create")
    @Override
    public CandidateType create(@RequestBody CandidateType candidateType) {
        return candidateTypeService.create(candidateType);
    }

    @PostMapping("update")
    @Override
    public CandidateType update(@RequestBody CandidateType candidateType) {
        return candidateTypeService.update(candidateType);
    }

    @GetMapping("read")
    @Override
    public CandidateType read(@RequestParam("id") String id) {
        return candidateTypeService.read(id);
    }

    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return candidateTypeService.delete(id);
    }

    @GetMapping("reads")
    @Override
    public List<CandidateType> readAll() {
        return candidateTypeService.readAll();
    }

    @Override
    public Long count() {
        return null;
    }
}
