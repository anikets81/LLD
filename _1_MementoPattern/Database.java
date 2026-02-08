package _1_MementoPattern;

import java.util.HashMap;
import java.util.Map;

public class Database {
    private Map<String, String>records;

    public
        Database(){
            records = new HashMap<>();
        }
        void insert(String key, String value){
            records.put(key, value);
            System.out.println("Inserted Record: " + key + " = " + value);
        }

        void update(String key, String value){
            if(records.containsKey(key)){
                records.put(key, value);
                System.out.println("Updated Record: " + key + " = " + value);
            }else{
                System.out.println("Record not found");
            }
        }

        void remove(String key){
            if(records.containsKey(key)){
                records.remove(key);
                System.out.println("Removed Record: " + key);
            }else{
                System.out.println("Record not found");
            }
        }


        DatabaseMomento createMomento(){
            System.out.println("Creating Memento for Database");
            return new DatabaseMomento(records);
        }

        void restoreFromMomento(DatabaseMomento momento){
            this.records = momento.getState();
            System.out.println("Restored Database from Memento");
        }

        void displayRecords(){
            System.out.println("Records: " + records);
        }

        
}
