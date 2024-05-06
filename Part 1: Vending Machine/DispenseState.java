public class DispenseState implements StateOfVendingMachine{

    @Override
    public void selectSnack(VendingMachine machine, String snackName) {

    }

    @Override
    public void insertMoney(VendingMachine machine, double payment) {

    }

    @Override
    public void dispenseSnack(VendingMachine machine) {
        Snack toDispense = machine.getSelectedSnack();
        System.out.println("Now dispensing: " + toDispense.getName());
        toDispense.decreaseQuantity(1);
        System.out.println("Thank you\n");
        machine.setState(new IdleState());
    }
}
