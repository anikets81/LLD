package _1_MementoPattern;

import java.util.HashMap;
import java.util.Map;

class DatabaseMomento{
    private Map<String, String> records;

    DatabaseMomento(Map<String, String> records){
        this.records = new HashMap<>(records) ;
    }

    Map<String, String> getState(){
        return new HashMap<>(records);
    }
}