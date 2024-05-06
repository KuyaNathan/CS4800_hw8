import java.util.List;

public class VendingMachine {
    private List<Snack> inventory;
    private StateOfVendingMachine state;
    private SnackDispenseHandler dispenser;
    private Snack selectedSnack;

    public VendingMachine(List<Snack> inventory, SnackDispenseHandler dispenser){
        this.inventory = inventory;
        this.state = new IdleState();
        this.dispenser = dispenser;
    }

    public List<Snack> getInventory(){
        return inventory;
    }

    public StateOfVendingMachine getState(){
        return state;
    }

    public void setState(StateOfVendingMachine state){
        this.state = state;
    }

    public Snack getSelectedSnack(){
        return selectedSnack;
    }

    public void setSelectedSnack(String wantedSnackName){
        if(wantedSnackName.equalsIgnoreCase("null")){
            this.selectedSnack = null;
        }
        else {
            for (Snack snack : inventory) {
                if (snack.getName().equalsIgnoreCase(wantedSnackName)) {
                    this.selectedSnack = snack;
                    break;
                }
            }
            if (selectedSnack == null) {
                System.out.println("Snack not found");
            }
        }
    }

    public SnackDispenseHandler getDispenser(){
        return dispenser;
    }

    public void setDispenser(SnackDispenseHandler dispenser){
        this.dispenser = dispenser;
    }

    public void selectSnack(String snackName){
        getState().selectSnack(this, snackName);
    }

    public void insertMoney(double payment){
        getState().insertMoney(this, payment);
    }

    public void dispenseSnack(){
        getState().dispenseSnack(this);
    }

    public void showInventory(){
        System.out.println("---Current Invetory Stock---");
        for(Snack snack: inventory){
            System.out.println(snack.getName() + ", stock: " + snack.getQuantity() + ",");
        }
        System.out.println();
    }
}
