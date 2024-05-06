public class PaymentState implements StateOfVendingMachine {
    double insertedAmount = 0;

    @Override
    public void selectSnack(VendingMachine machine, String snackName) {

    }

    @Override
    public void insertMoney(VendingMachine machine, double payment) {
        double cost = machine.getSelectedSnack().getPrice();
        insertedAmount += payment;

        System.out.println("Cost: $" + cost);
        System.out.println("Amount Inserted: $" + insertedAmount);
        if(insertedAmount >= cost){
            System.out.println("Transaction successful");
            System.out.println("Change Due: $" + (payment - cost));
            machine.setState(new DispenseState());
        } else{
            System.out.println("Price not met, please insert more money");
        }
    }

    @Override
    public void dispenseSnack(VendingMachine machine) {

    }
}
