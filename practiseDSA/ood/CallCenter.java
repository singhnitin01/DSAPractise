package ood;

import java.util.List;
import java.util.ArrayList;



/*

Problem statement

Design a call center such that:

1. There are three kinds of employees: Respondants, Managers and Directors
2. When a call comes then it is allocated to the Respondants first
3. If no Respondant is free or not able to handle it then its escalated to Managers.
4. If no Manager is free or not able to handle it then its escalated to Directors.

*/

/*
  My thought process

  Discovering core objects
  -------------------------
  Employee (Respondant, Manager, Director), Call, Caller, CallManager

  Discovering relationship
  -------------------------
  CallManager has many employees
  There can be only one call per Employee
  There can be only one caller per caller
  An Employee can manage only one caller at a time

  Go for most basic design i.e. CallManager managine everything
*/

public class CallCenter {
    public static void main(String[] args) {
        System.out.println("Hello World");
        CallManager manager = new CallManager();

        manager.addRespondant(new Employee("R1", manager));
        manager.addRespondant(new Employee("R2", manager));
        manager.addRespondant(new Employee("R3", manager));

        manager.addManager(new Employee("M1", manager));
        manager.addManager(new Employee("M2", manager));
        manager.addManager(new Employee("M3", manager));

        manager.addDirector(new Employee("D1", manager));
        manager.addDirector(new Employee("D2", manager));

        Caller foo = new Caller("foo");

        manager.dispatch(foo); // should be R1
        manager.dispatch(new Call()); // should be R2
        manager.dispatch(new Call()); // should be R3
        manager.dispatch(new Call()); // should be M1
    }
}

class CallManager {
    List<List<Employee>> employeeLevels;
    List<List<Call>> waitQueue;

    CallManager() {
        this.employeeLevels = new ArrayList<>();
        this.employeeLevels.add(new ArrayList<>());
        this.employeeLevels.add(new ArrayList<>());
        this.employeeLevels.add(new ArrayList<>());
        this.waitQueue = new ArrayList<List<Call>>();
    }

    private Employee getCallHandler(Call call) {
        /* check all respondants */
        for (Employee respondant: employeeLevels.get(0)) {
            if (respondant.isFree()) return respondant;
        }

        /* check all managers */
        for (Employee manager: employeeLevels.get(1)) {
            if (manager.isFree()) return manager;
        }

        /* check all directors */
        for (Employee director: employeeLevels.get(2)) {
            if (director.isFree()) return director;
        }

        // No one is free
        return null; // returning null is not a good idea
    }

    public void addRespondant(Employee emp) {
        employeeLevels.get(0).add(emp);
    }

    public void addManager(Employee emp) {
        employeeLevels.get(1).add(emp);
    }

    public void addDirector(Employee emp) {
        employeeLevels.get(2).add(emp);
    }

    public void dispatch(Caller caller) {
        dispatch(new Call(caller));
    }

    public void dispatch(Call call) {
        /* check if any respondant is free */
        Employee handler = getCallHandler(call);
        if (handler == null) {
            System.out.println("Sorry, the line is busy, your call is going in wait queue");
            putCallInWaitQueue(call);
            return;
        }
        handler.assignCall(call);
        call.setEmployee(handler);
    }

    public void putCallInWaitQueue(Call call) {
        waitQueue.get(call.getRank()).add(call);
    }
}


class Employee {
    private String name;
    private Call currentCall;
    private CallManager callManager;

    Employee(String name, CallManager callManager) {
        this.name = name;
        this.callManager = callManager; // this is the required depedency hence must be there in constructor
    }

    public boolean isFree() {
        return this.currentCall == null;
    }

    private void escalateCall() {
        if (!isFree()) {
            currentCall.incrementRank();
            callManager.putCallInWaitQueue(currentCall);
        }
    }

    public void assignCall(Call call) {
        System.out.println(name + " Received call!");
        currentCall = call;
    }
}

final class Call { // final by default
    private int rank;
    private Caller caller;
    private Employee employee;

    Call() {
        this.rank = 0;
    }

    Call(Caller caller) {
        super();
        this.caller = caller;
    }

    public int getRank() {
        return rank;
    }

    public void incrementRank() {
        this.rank += 1;
    }

    public void setCaller(Caller caller) {
        this.caller = caller;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

final class Caller {
    private String name;

    Caller(String name) {
        this.name = name;
    }
}
