package sealedClasses;

public sealed class Contract permits RecurrenceContract, ManagedServicesContract, FixedPriceContract {
    private final String name;

    public Contract(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[name='" + name + "\']";
    }
}
