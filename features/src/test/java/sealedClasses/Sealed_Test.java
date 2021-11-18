package sealedClasses;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Sealed_Test {

    @Tag("java17")
    @Test
    public void givenASpecificStructureOfContract_whenInstantiateAndPrintThem_thenShowWhatIsTheStructureAndLimitations() {
        Contract contract = new Contract("contract");
        Contract recurrenceContract = new RecurrenceContract("recurrence");
        Contract fixedPriceContract = new FixedPriceContract("fixed-price");
        Contract managedServicesContract = new ManagedServicesContract("managed-services");
        Contract specificManagedServicesContract = new SpecificManagedServicesContract("specific-managed-services");

        assertEquals("Contract[name='contract']", contract.toString());
        assertEquals("RecurrenceContract[name='recurrence']", recurrenceContract.toString());
        assertEquals("FixedPriceContract[name='fixed-price']", fixedPriceContract.toString());
        assertEquals("ManagedServicesContract[name='managed-services']", managedServicesContract.toString());
        assertEquals("SpecificManagedServicesContract[name='specific-managed-services']", specificManagedServicesContract.toString());

        printIt(contract,
                recurrenceContract,
                fixedPriceContract,
                managedServicesContract,
                specificManagedServicesContract);
    }

    private void printIt(Contract contract, Contract recurrenceContract,
                         Contract fixedPriceContract, Contract managedServicesContract,
                         Contract specificManagedServicesContract) {
        log("Sealed");
        log("=================================");
        log("Sealed class: %s", contract);
        log("\tfinal subclass: %s", recurrenceContract);
        log("\tfinal subclass: %s", fixedPriceContract);
        log("\tnon-sealed subclass: %s", managedServicesContract);
        log("\t\tmanage-service subclass: %s", specificManagedServicesContract);
        log("=================================");
    }

    private void log(String message, Object ... parameters) {
        System.out.println(message.formatted(parameters));
    }


    private class SpecificManagedServicesContract extends ManagedServicesContract {
        public SpecificManagedServicesContract(String name) {
            super(name);
        }
    }
}
