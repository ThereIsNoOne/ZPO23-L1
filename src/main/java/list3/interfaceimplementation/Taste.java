package list3.interfaceimplementation;

/**
 * Tastes with information about fruitiness.
 */
public enum Taste {
    APPLE(true),
    STRAWBERRY(true),
    CHERRY(true),
    LEMON(true),
    COCA_COLA(false),
    CHOCOLATE(false),
    MINT(false);

    Taste(boolean fruity) {
        this.fruity = fruity;
    }

    public final boolean fruity;
    }
