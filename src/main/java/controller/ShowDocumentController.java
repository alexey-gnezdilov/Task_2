package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.document.BaseDocumentController;
import entitiy.documents.Document;
import manager.Manager;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

public class ShowDocumentController extends BaseDocumentController {

    public void showAllDocumentsByAuthor() {

    if (Manager.DOCUMENTS_REPO.documentListIsEmpty()) {
        System.out.println(LIST_IS_EMPTY);
        Manager.CUSTOM_SYSTEM_UTIL.delay();
    } else {
        Manager.DOCUMENTS_REPO.getDocuments()
                .stream()
                .sorted()
                .collect(Collectors.groupingBy(Document::getDocumentAuthor))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(obj -> {
                    System.out.println("-" + obj.getKey().getFullName());
                    for(Document doc : obj.getValue()){
                        System.out.println(" •" + doc);
                    }
                    System.out.println();
                });
    }
    }

    public void createDocumentReports() {
        if (Manager.DOCUMENTS_REPO.documentListIsEmpty()) {
            System.out.println(LIST_IS_EMPTY);
            Manager.CUSTOM_SYSTEM_UTIL.delay();
        } else {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Manager.DOCUMENTS_REPO.getDocuments()
                    .stream()
                    .collect(Collectors.groupingBy(Document::getDocumentAuthor))
                    .forEach((key, value) -> {
                        String file = String.format("src/reports/%s.json", key.getFullName());
                        try (FileWriter fileWriter = new FileWriter(file)) {
                            gson.toJson(value, fileWriter);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }
}