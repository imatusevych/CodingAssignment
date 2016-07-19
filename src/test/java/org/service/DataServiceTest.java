package org.service;

import org.entity.InputDataEntity;
import org.entity.OutputDataEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.reader.CSVDataReader;
import org.reader.DataReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DataServiceTest {
    private DataService target;
    private KeyWordsService keyWordsService;

    @Before
    public void init(){
        keyWordsService = mock(KeyWordsService.class);
        target = new DataService(keyWordsService);
    }

    @Test
    public void generate() throws Exception {
        //given
        List<InputDataEntity> inputDataEntities = new ArrayList<InputDataEntity>();
        inputDataEntities.add(new InputDataEntity(13000,"example.com/csv1", true, 454));
        inputDataEntities.add(new InputDataEntity(13001,"example.com/csv2", false, 455));

        //when
        when(keyWordsService.getKeyWords(13000)).thenReturn("13000_key1,13000_key2");
        when(keyWordsService.getKeyWords(13001)).thenReturn("EMPTY_KEY_WORDS");

        //than
        List<OutputDataEntity> expectedResult = new ArrayList<OutputDataEntity>();
        expectedResult.add(new OutputDataEntity(13000, "example.com/csv1", 1, "13000_key1,13000_key2", 454));
        expectedResult.add(new OutputDataEntity(13001, "example.com/csv2", 0, "EMPTY_KEY_WORDS", 455));

        List<OutputDataEntity> actualResult = target.generate(inputDataEntities);
        Assert.assertEquals(expectedResult,actualResult);
    }

}