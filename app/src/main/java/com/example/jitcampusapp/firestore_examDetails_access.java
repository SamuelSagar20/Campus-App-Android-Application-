package com.example.jitcampusapp;

public class firestore_examDetails_access {

    private String examName;
    private String examDate;
    private String examTime;
    private String registerNumber;
    private String registerNumber2;
    private String registerNumber3;
    private String registerNumber4;
    private String roomNumber;
    private String roomNumber2;
    private String roomNumber3;
    private String roomNumber4;

    private firestore_examDetails_access() {}

    private firestore_examDetails_access(String name, long price){
        this.examName = examName;
        this.examDate = examDate;
        this.examTime = examTime;
        this.registerNumber = registerNumber;
        this.registerNumber2 = registerNumber2;
        this.registerNumber3 = registerNumber3;
        this.registerNumber4 = registerNumber4;
        this.roomNumber = roomNumber;
        this.roomNumber2 = roomNumber2;
        this.roomNumber3 = roomNumber3;
        this.roomNumber4 = roomNumber4;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getRegisterNumber2() {
        return registerNumber2;
    }

    public void setRegisterNumber2(String registerNumber2) {
        this.registerNumber2 = registerNumber2;
    }

    public String getRegisterNumber3() {
        return registerNumber3;
    }

    public void setRegisterNumber3(String registerNumber3) {
        this.registerNumber3 = registerNumber3;
    }

    public String getRegisterNumber4() {
        return registerNumber4;
    }

    public void setRegisterNumber4(String registerNumber4) {
        this.registerNumber4 = registerNumber4;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber2() {
        return roomNumber2;
    }

    public void setRoomNumber2(String roomNumber2) {
        this.roomNumber2 = roomNumber2;
    }

    public String getRoomNumber3() {
        return roomNumber3;
    }

    public void setRoomNumber3(String roomNumber3) {
        this.roomNumber3 = roomNumber3;
    }

    public String getRoomNumber4() {
        return roomNumber4;
    }

    public void setRoomNumber4(String roomNumber4) {
        this.roomNumber4 = roomNumber4;
    }
}
