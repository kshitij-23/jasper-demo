package com.ksh.jasperdemo;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJasper {

    public static void main(String[] args) throws IOException, JRException {
        ClassPathResource resource = new ClassPathResource("Orders.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(resource.getInputStream());
        JRBeanCollectionDataSource list = new JRBeanCollectionDataSource(getOrders());
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("imagesDir", "D:\\Temp\\");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, list);
        JasperExportManager.exportReportToHtmlFile(jasperPrint, "D:\\Temp\\orders.html");
        JasperExportManager.exportReportToPdfFile(jasperPrint, "D:\\Temp\\orders.pdf");
        JasperExportManager.exportReportToXmlFile(jasperPrint, "D:\\Temp\\orders.xml", false);
        System.out.println("Report Compiled Successful...");
    }

    public static List<Order> getOrders() {
        Order order1 = new Order(1, LocalDateTime.now(), "Kshitij-1", 23.00, "Nadiad");
        Order order2 = new Order(2, LocalDateTime.now(), "Kshitij-2", 24.00, "Nadiad");
        Order order3 = new Order(3, LocalDateTime.now(), "Kshitij-3", 25.00, "Nadiad");
        Order order4 = new Order(4, LocalDateTime.now(), "Kshitij-4", 26.00, "Nadiad");
        Order order5 = new Order(5, LocalDateTime.now(), "Kshitij-5", 27.00, "Nadiad");
        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);
        return orders;
    }

}
