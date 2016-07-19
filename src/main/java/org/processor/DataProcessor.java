package org.processor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FilenameUtils;
import org.entity.InputDataEntity;
import org.entity.OutputDataEntity;
import org.reader.DataReaderFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataProcessor {

    private DataProcessor(){}

    public static List<InputDataEntity> read(String pathToDir) throws Exception {
        List<InputDataEntity> inputDataFromDir = new ArrayList<InputDataEntity>();
        File folder = new File(pathToDir);
        if(folder.isDirectory()){
            File[] listOfFiles = folder.listFiles();
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    String dataType = FilenameUtils.getExtension(file.getName()).toLowerCase();
                    List<InputDataEntity> inputDataFromFile = DataReaderFactory.getInstance(dataType).read(file.getAbsolutePath());
                    inputDataFromDir.addAll(inputDataFromFile);
                }
            }
            return inputDataFromDir;
        }
        else{
            throw new Exception(pathToDir + " is not directory");
        }
    }

    public static void write(String pathToFile, List<OutputDataEntity> OutputDataEntities) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(pathToFile), OutputDataEntities);
    }

}
