package ir.rezacolonel.springTutorial1.service;


import ir.rezacolonel.springTutorial1.aop.Log;

public class EmployeeDAD {
    public void doSomething() {
        System.out.println("Salam " + getClass().getName());
    }

    public void init() {
        System.out.println("EmployeeDAD initialized");
    }

    public void destroyed() {
        System.out.println("EmployeeDAD destroyed");
    }
    @Log
    public String callThisMethod(){
        System.out.println("IN callThisMethod");
        return "Hello aspect";
    }
}
