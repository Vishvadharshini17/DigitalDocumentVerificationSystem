package com.wipro.ddvs.service;

import java.util.ArrayList;

import com.wipro.ddvs.entity.*;
import com.wipro.ddvs.util.*;

public class VerificationService {

    private ArrayList<User> users;
    private ArrayList<Document> documents;
    private ArrayList<Officer> officers;
    private ArrayList<VerificationLog> logs;

    public VerificationService(ArrayList<User> users, 
                               ArrayList<Document> documents,
                               ArrayList<Officer> officers,
                               ArrayList<VerificationLog> logs) {
        this.users = users;
        this.documents = documents;
        this.officers = officers;
        this.logs = logs;
    }

    public User findUser(String userId) throws UserNotFoundException {
        for (User u : users)
            if (u.getUserId().equals(userId))
                return u;
        throw new UserNotFoundException("User not found");
    }

    public Officer findOfficer(String officerId) throws OfficerNotFoundException {
        for (Officer o : officers)
            if (o.getOfficerId().equals(officerId))
                return o;
        throw new OfficerNotFoundException("Officer not found");
    }

    public Document findDocument(String documentId) throws DocumentNotFoundException {
        for (Document d : documents)
            if (d.getDocumentId().equals(documentId))
                return d;
        throw new DocumentNotFoundException("Document not found");
    }

    public void uploadDocument(Document d) throws UserNotFoundException {
        findUser(d.getUserId());
        d.setStatus("PENDING");
        documents.add(d);
    }

    public void assignOfficer(String documentId, String officerId)
            throws Exception {

        Document d = findDocument(documentId);
        findOfficer(officerId);

        if (d.getAssignedOfficerId() != null)
            throw new InvalidVerificationException("Already assigned");

        d.setAssignedOfficerId(officerId);
        d.setStatus("UNDER_REVIEW");
    }

    public void updateStatus(String documentId, String newStatus)
            throws Exception {

        Document d = findDocument(documentId);

        if (d.getStatus().equals("VERIFIED") ||
            d.getStatus().equals("REJECTED"))
            throw new InvalidVerificationException("Final status cannot change");

        d.setStatus(newStatus);
    }

    public void addVerificationLog(String logId, String documentId,
                                   String officerId, String date,
                                   String notes) throws Exception {

        if (notes == null || notes.isEmpty())
            throw new InvalidVerificationException("Notes cannot be empty");

        findDocument(documentId);
        findOfficer(officerId);

        logs.add(new VerificationLog(logId, documentId,
                                     officerId, date, notes));
    }

    public String generateVerificationReport(String documentId)
            throws Exception {

        Document d = findDocument(documentId);
        StringBuilder sb = new StringBuilder();

        sb.append("\n--- Verification Report ---\n");
        sb.append("Document ID: ").append(d.getDocumentId()).append("\n");
        sb.append("File Name: ").append(d.getFileName()).append("\n");
        sb.append("Type: ").append(d.getDocType()).append("\n");
        sb.append("Status: ").append(d.getStatus()).append("\n\n");

        sb.append("Logs:\n");
        for (VerificationLog log : logs)
            if (log.getDocumentId().equals(documentId))
                sb.append(log.getDate())
                  .append(" - ")
                  .append(log.getNotes())
                  .append("\n");

        return sb.toString();
    }
}