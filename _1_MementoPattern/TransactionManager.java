package _1_MementoPattern;

import javax.xml.crypto.Data;

public class TransactionManager {
    private DatabaseMomento backup;

    public
        TransactionManager(){
            backup = null;
        }

        void beginTransaction(Database db)
        {
         System.out.println("Starting a new transaction.");
            if(backup != null){
                backup = null;
            }

            backup = db.createMomento();
        }

        void commitTransation(){
            System.out.println("Committing transaction.");
            if(backup != null){
                backup = null;
            }

            System.out.println("Transation commited Successfully");
        }

        void rollBack(Database db){
            System.out.println("Rolling back transaction.");
            if(backup != null){
                db.restoreFromMomento(backup);
                backup = null;
                System.out.println("Transaction rolled back Successfully");
            }else{
                System.out.println("No transaction to roll back.");
            }
        }
        
}
