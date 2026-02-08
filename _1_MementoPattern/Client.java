package _1_MementoPattern;

import javax.xml.crypto.Data;

public class Client {
    public static void main(String[] args) {
        Database db = new Database();
        TransactionManager tm = new TransactionManager();

        tm.beginTransaction(db);

        db.insert("Aniket", "1234567890");
        db.insert("Dheeraj", "9876542121");

        tm.commitTransation();

        db.displayRecords();

        tm.beginTransaction(db);
        db.insert("Aditya", "123456sf7890");
        db.insert("Utkarsh", "98765fdsa42121");

        db.displayRecords();
        System.out.println("Rollback please");
        tm.rollBack(db);

        db.displayRecords();

    }
}
