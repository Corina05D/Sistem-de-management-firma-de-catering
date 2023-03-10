package controllerLayer;

import businessLayer.DeliveryService;
import viewLayer.GenerateReportsView;

import java.io.IOException;
import java.time.LocalDate;

public class GenerateReportsController {
    private DeliveryService deliveryService;
    private GenerateReportsView generateReportsView;

    public GenerateReportsController(GenerateReportsView generateReportsView, DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
        this.generateReportsView = generateReportsView;
        this.generateReportsView.addGenerateReport1BtnActionListener(e -> {
            int startHour = generateReportsView.getStartHour();
            int endHour = generateReportsView.getEndHour();
            try {
                deliveryService.generateTimeReport(startHour, endHour);
                generateReportsView.showError("Raport 1 generat cu succes!");
            } catch (IOException exception) {
                exception.printStackTrace();
            }

        });
        this.generateReportsView.addGenerateReport2BtnActionListener(e -> {
            int numberOfTimesOrdered = generateReportsView.getProductsTimesOrdered();
            try {
                deliveryService.generateFrequencyReport(numberOfTimesOrdered);
                generateReportsView.showError("Raport 2 generat cu succes!");
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
        this.generateReportsView.addGenerateReport3BtnActionListener(e -> {
            int numberOfTimesOrdered = generateReportsView.getClientsTimesOrdered();
            int amount = generateReportsView.getAmount();
            try {
                deliveryService.generateFrequencyAndValueReport(numberOfTimesOrdered, amount);
                generateReportsView.showError("Raport 3 generat cu succes!");
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
        this.generateReportsView.addGenerateReport4BtnActionListener(e -> {
            int day = generateReportsView.getDay();
            int month = generateReportsView.getMonth();
            int year = generateReportsView.getYear();
            LocalDate date = LocalDate.of(year, month, day);
            try {
                deliveryService.generateDateReport(date);
                generateReportsView.showError("Raport 4 generat cu succes!");
            } catch (IOException exception) {
                exception.printStackTrace();
            }

        });

    }
}
