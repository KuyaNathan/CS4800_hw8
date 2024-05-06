public class IdleState implements StateOfVendingMachine{

    @Override
    public void selectSnack(VendingMachine machine, String snackName) {
        if(snackName.isBlank()){
            System.out.println("Please select a snack");
        } else{
            System.out.println("Selected: " + snackName);
            machine.setSelectedSnack(snackName);
            Snack selected = machine.getSelectedSnack();
            if(selected.getQuantity() > 0) {
                machine.getDispenser().handleRequest(machine, selected.getName());
                machine.setState(new PaymentState());
            }
            else{
                System.out.println("That snack is not currently available");
                machine.setSelectedSnack("null");
            }
        }

    }

    @Override
    public void insertMoney(VendingMachine machine, double payment) {

    }

    @Override
    public void dispenseSnack(VendingMachine machine) {

    }
}
