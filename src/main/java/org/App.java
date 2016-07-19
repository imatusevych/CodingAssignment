package org;

import org.entity.InputDataEntity;
import org.entity.OutputDataEntity;
import org.processor.DataProcessor;
import org.service.DataService;
import org.service.KeyWordsService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Iryna on 7/18/2016.
 */
public class App {

    public static void main(String[] args) {

        String statusMessage = "successful";

        if(args.length > 1){
            //there is more intelligent way for reading cmd arg.But time its time
            String pathToDir = args[0];
            String fileName = args[1];

            //stub for keywords
            Map<Integer, String> keywords = new HashMap<Integer, String>();
            keywords.put(13000,"13000_key1,13000_key2");
            keywords.put(13001,"13001_key1,13001_key2");

            DataService dataService = new DataService(new KeyWordsService(keywords));
            try {

                List<InputDataEntity> inputDataEntities = DataProcessor.read(pathToDir);
                List<OutputDataEntity> outputDataEntities = dataService.generate(inputDataEntities);
                DataProcessor.write(fileName,outputDataEntities);

            } catch (Exception e) {
                statusMessage = "failure";
                System.out.println(e.getMessage());
            }
        }
        else{
            statusMessage = "failure";
            System.out.println("Please type as arguments 'pathToFiles', 'outputfileName'");
        }
        System.out.println("----File processing finished. Status "+statusMessage+"----");
    }
}
