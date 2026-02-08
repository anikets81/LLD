package _1_MementoPattern;

import java.util.Map;

class DatabaseMomento{
    private Map<String, String> records;

    DatabaseMomento(Map<String, String> records){
        this.records = records ;
    }

    Map<String, String> getState(){
        return records;
    }
}