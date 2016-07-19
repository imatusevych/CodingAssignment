package org.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class KeyWordsServiceTest {
    private KeyWordsService target;
    private static String EMPTY_KEY_WORDS = "no KeyWords";
    @Before
    public void init(){
        Map<Integer, String> keywords = new HashMap<Integer, String>();
        keywords.put(13000,"13000_key1,13000_key2");
        keywords.put(13001,"13001_key1,13001_key2");

        target = new KeyWordsService(keywords);
    }

    @Test
    public void getValuesStub() throws Exception {
        String expectedResult = "13001_key1,13001_key2";
        String actualResult = target.getKeyWords(13001);

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void getValuesStubEmptyKeyWords() throws Exception {
        String actualResult = target.getKeyWords(134000);
        Assert.assertEquals(EMPTY_KEY_WORDS,actualResult);
    }

}