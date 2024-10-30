package ExamPreparation.Implementation.CafeManagement.System;

public class Table {
    private String tableId;
    private int capacity;
    private boolean isOccupied;
    private static int tableCount;

    public Table(int capacity) {
        this.tableId = "T" + tableCount++;
        this.capacity = capacity;
        this.isOccupied = false;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public void occupyTable() {
        this.isOccupied = true;
    }

    public void releaseTable() {
        this.isOccupied = false;
    }
}