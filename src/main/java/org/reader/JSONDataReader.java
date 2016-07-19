package org.reader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.entity.InputDataEntity;
import org.entity.InputDataEntityJSON;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JSONDataReader implements DataReader {

    public List<InputDataEntity> read(String fileNamePath) throws Exception{

        List<InputDataEntity> inputDataEntities = new ArrayList<InputDataEntity>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<InputDataEntityJSON>  jsonEntities = objectMapper.readValue(new FileInputStream(fileNamePath), new TypeReference<List<InputDataEntityJSON>>(){});
            for(InputDataEntityJSON jsonEntity : jsonEntities){
                InputDataEntity inputDataEntity = new InputDataEntity();
                inputDataEntity.setId(jsonEntity.getSite_id());
                inputDataEntity.setMobile(jsonEntity.getMobile());
                inputDataEntity.setName(jsonEntity.getName());
                inputDataEntity.setScore(jsonEntity.getScore());
                inputDataEntities.add(inputDataEntity);
            }
            return inputDataEntities;
        }
        catch (IOException e) {
            throw new Exception("Error while reading file "+fileNamePath);
        }
    }

}
