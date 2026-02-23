package com.wipro.ddvs.main;

import java.util.ArrayList;

import com.wipro.ddvs.entity.*;
import com.wipro.ddvs.service.VerificationService;

public class Main {

    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("U001", "Amit Shah", "amit@gmail.com"));

        ArrayList<Document> documents = new ArrayList<>();
        ArrayList<Officer> officers = new ArrayList<>();
        officers.add(new Officer("O001", "Neha Joshi", "Admissions"));

        ArrayList<VerificationLog> logs = new ArrayList<>();

        VerificationService service = new VerificationService(users, documents, officers, logs);

        try {

           
            Document d1 = new Document(
                    "D001",
                    "U001",
                    "marksheet.pdf",
                    "Education Proof",
                    "PENDING",
                    null
            );
            service.uploadDocument(d1);

            service.assignOfficer("D001", "O001");

            
            service.addVerificationLog(
                    "L001",
                    "D001",
                    "O001",
                    "2025-08-12",
                    "Verified marksheet, details match."
            );

          
            service.updateStatus("D001", "VERIFIED");

         
            System.out.println(service.generateVerificationReport("D001"));

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}