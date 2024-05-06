import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VendingMachineDriver {
    public static void main(String[] args){
        Snack coke = new Snack("Coke", 2.00, 8);
        Snack pepsi = new Snack("Pepsi", 2.00, 5);
        Snack cheetos = new Snack("Cheetos", 3.00, 10);
        Snack doritos = new Snack("Doritos", 3.50, 7);
        Snack kitkat = new Snack("KitKat", 1.75, 5);
        Snack snickers = new Snack("Snickers", 1.50, 1);

        List<Snack> inventory = new ArrayList<Snack>(Arrays.asList(coke, pepsi, cheetos, doritos, kitkat, snickers));
        SnackDispenseHandler cokeHandler = new SnackDispenseHandler("Coke", null);
        SnackDispenseHandler pepsiHandler = new SnackDispenseHandler("Pepsi", cokeHandler);
        SnackDispenseHandler cheetosHandler = new SnackDispenseHandler("Cheetos", pepsiHandler);
        SnackDispenseHandler doritosHandler = new SnackDispenseHandler("Doritos", cheetosHandler);
        SnackDispenseHandler kitkatHandler = new SnackDispenseHandler("KitKat", doritosHandler);
        SnackDispenseHandler snickersHandler = new SnackDispenseHandler("Snickers", kitkatHandler);

        VendingMachine vendingMachine = new VendingMachine(inventory, snickersHandler);

        System.out.println("Showing inventory of the vending machine before transactions:");
        vendingMachine.showInventory();

        System.out.println("Selecting, buying, and dispensing every snack in order of the chain of responsibility");
        vendingMachine.selectSnack("");
        vendingMachine.selectSnack("Coke");
        vendingMachine.insertMoney(3.00);
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack("");
        vendingMachine.selectSnack("Pepsi");
        vendingMachine.insertMoney(2.00);
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack("");
        vendingMachine.selectSnack("Cheetos");
        vendingMachine.insertMoney(3.00);
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack("");
        vendingMachine.selectSnack("Doritos");
        vendingMachine.insertMoney(4.00);
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack("");
        vendingMachine.selectSnack("KitKat");
        vendingMachine.insertMoney(2.00);
        vendingMachine.dispenseSnack();

        vendingMachine.selectSnack("snickers");
        vendingMachine.insertMoney(1.50);
        vendingMachine.dispenseSnack();

        System.out.println("Attempting to select and buy a snickers when they are out of stock (quantity: 0)");
        vendingMachine.selectSnack("snickers");

        System.out.println();
        System.out.println("Showing inventory of the vending machine after all transactions:");
        vendingMachine.showInventory();
    }
}
