package org.service;

import org.entity.InputDataEntity;
import org.entity.OutputDataEntity;

import java.util.ArrayList;
import java.util.List;
/*
* Do to use interface as that:
* - there is only one instance
* - in future app is not supported
*/
public class DataService {
    private KeyWordsService keyWordsService;

    public DataService(KeyWordsService keyWordsService) {
        this.keyWordsService = keyWordsService;
    }

    public List<OutputDataEntity> generate(List<InputDataEntity> inputDataEntities) {
        List<OutputDataEntity> outputDataEntities = new ArrayList<OutputDataEntity>();
        for(InputDataEntity inputDataEntity:inputDataEntities){
            OutputDataEntity outputDataEntity = new OutputDataEntity();
            outputDataEntity.setId(inputDataEntity.getId());
            outputDataEntity.setName(inputDataEntity.getName());
            outputDataEntity.setMobile(inputDataEntity.getMobile() ? 1 : 0);
            outputDataEntity.setKeywords(keyWordsService.getKeyWords(inputDataEntity.getId()));
            outputDataEntity.setScore(inputDataEntity.getScore());
            outputDataEntities.add(outputDataEntity);
        }
        return outputDataEntities;
    }
}
