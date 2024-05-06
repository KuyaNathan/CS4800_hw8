public interface StateOfVendingMachine {
    void selectSnack(VendingMachine machine, String snackName);
    void insertMoney(VendingMachine machine, double payment);
    void dispenseSnack(VendingMachine machine);
}
