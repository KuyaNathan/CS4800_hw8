public class SnackDispenseHandler {
    private SnackDispenseHandler next;
    private String handledSnackName;

    public SnackDispenseHandler(String handledSnackName, SnackDispenseHandler next){
        this.next = next;
        this.handledSnackName = handledSnackName;
    }

    public void handleRequest(VendingMachine machine, String snackName){
        if(handledSnackName.equalsIgnoreCase(snackName) &&
            machine.getSelectedSnack().getName().equalsIgnoreCase(snackName)){
            machine.dispenseSnack();
            return;
        }
        if(next != null){
            System.out.println("Searching for snack...");
            next.handleRequest(machine, snackName);
        }
    }

}
