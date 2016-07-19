package org.service;

import java.util.HashMap;
import java.util.Map;

/*
* Do to use interface as that:
* - there is only one instance
* - in future app is not supported
*/
public class KeyWordsService {
    private Map<Integer,String> valuesStub = new HashMap<Integer, String>();
    private static String EMPTY_KEY_WORDS = "no KeyWords";

    public KeyWordsService() {
    }

    public KeyWordsService(Map<Integer, String> valuesStub) {
        this.valuesStub = valuesStub;
    }

    public String getKeyWords(Integer siteId) {
        if(getValuesStub().containsKey(siteId)){
            return valuesStub.get(siteId);
        }
        return EMPTY_KEY_WORDS;
    }

    public Map<Integer, String> getValuesStub() {
        return valuesStub;
    }

    public void setValuesStub(Map<Integer, String> valuesStub) {
        this.valuesStub = valuesStub;
    }
}
