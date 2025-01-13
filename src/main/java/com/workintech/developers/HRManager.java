package com.workintech.developers;

import com.workintech.developers.Employee;

public class HRManager extends Employee {
    private Employee[] juniorDevelopers;
    private Employee[] midDevelopers;
    private Employee[] seniorDevelopers;

    // Constructor
    public HRManager(int id, String name,int salary) {
        super(id, name, salary);
   /*     this.juniorDevelopers = new Employee[juniorCapacity];
        this.midDevelopers = new Employee[midCapacity];
        this.seniorDevelopers = new Employee[seniorCapacity];*/
    }

    // Getter metotları
    public Employee[] getJuniorDevelopers() {
        return juniorDevelopers;
    }

    public Employee[] getMidDevelopers() {
        return midDevelopers;
    }

    public Employee[] getSeniorDevelopers() {
        return seniorDevelopers;
    }

    // Override work metodu
    @Override
    public void work() {
        System.out.println("HRManager is managing employees.");
        setSalary(7000); // Maaşı %10 artır
    }

    // Geliştirici ekleme metodunu switch-case ile yapma
    public String addEmployee(int index, Employee developer, String level) {
        switch (level.toUpperCase()) {
            case "JUNIOR":
                return addToArray(juniorDevelopers, index, developer, "Junior Developer");
            case "MID":
                return addToArray(midDevelopers, index, developer, "Mid Developer");
            case "SENIOR":
                return addToArray(seniorDevelopers, index, developer, "Senior Developer");
            default:
                return "Geçersiz geliştirici seviyesi!";
        }
    }

    // Dizilere eleman ekleme işlemi yapan yardımcı metod
    private String addToArray(Employee[] developers, int index, Employee developer, String developerType) {
        if (index < 0 || index >= developers.length) {
            return developerType + " dizisinde geçersiz bir index!";
        }
        if (developers[index] != null) {
            return developerType + " dizisinde index " + index + " zaten dolu!";
        }
        developers[index] = developer;
        return developerType + " başarıyla eklendi: " + developer.getName();
    }
}
