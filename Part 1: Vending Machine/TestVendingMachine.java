import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

public class TestVendingMachine {
    private VendingMachine vendingMachine;
    private List<Snack> inventory;

    Snack one = new Snack("one", 1.00, 1);
    Snack two = new Snack("two", 2.00, 2);
    Snack three = new Snack("three", 3.00, 3);

    SnackDispenseHandler oneHandler = new SnackDispenseHandler("one", null);
    SnackDispenseHandler twoHandler = new SnackDispenseHandler("two", oneHandler);
    SnackDispenseHandler threehandler = new SnackDispenseHandler("three", twoHandler);


    @Test
    public void testSelectSnack(){
        System.out.println("\nTesting selectSnack()");
        inventory = new ArrayList<>(List.of(one, two, three));
        vendingMachine = new VendingMachine(inventory, threehandler);
        vendingMachine.selectSnack("two");
        assertEquals("two", vendingMachine.getSelectedSnack().getName());
    }

    @Test
    public void testInsertMoney(){
        System.out.println("\nTesting insertMoney()");
        inventory = new ArrayList<>(List.of(one, two, three));
        vendingMachine = new VendingMachine(inventory, threehandler);
        vendingMachine.selectSnack("three");
        vendingMachine.insertMoney(3.00);
        assertEquals(3.00, vendingMachine.getSelectedSnack().getPrice(), 0.0001);
        vendingMachine.insertMoney(2.50);
        assertTrue(vendingMachine.getSelectedSnack().getPrice() > 2.50);
        vendingMachine.insertMoney(4.00);
        assertTrue(vendingMachine.getSelectedSnack().getPrice() < 4.00);
    }

    @Test
    public void testDispenseSnack(){
        System.out.println("\nTesting dispenseSnack()");
        inventory = new ArrayList<>(List.of(one, two, three));
        vendingMachine = new VendingMachine(inventory, threehandler);
        vendingMachine.selectSnack("one");
        vendingMachine.insertMoney(1.00);
        vendingMachine.dispenseSnack();
        assertEquals(0, vendingMachine.getSelectedSnack().getQuantity());
    }

    @Test
    public void testSoldOutSnacks(){
        System.out.println("\nTesting when a snack is sold out");
        inventory = new ArrayList<>(List.of(one, two, three));
        vendingMachine = new VendingMachine(inventory, threehandler);

        one.setQuantity(0);
        vendingMachine.selectSnack("one");
        assertNull(vendingMachine.getSelectedSnack());
    }
}
