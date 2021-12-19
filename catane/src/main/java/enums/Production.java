package enums;

public enum Production {
    BOIS(0, "Bois"),
    ARGILE(1, "Argile"),
    LAINE(2, "Laine"),
    BLE(3, "Ble"),
    MINERAI(4, "Minerai"),
    RIEN(99, "Rien");

    private int idProduction;
    private String labelProduction;

    private Production(int idProduction, String labelProduction) {
        this.idProduction = idProduction;
        this.labelProduction = labelProduction;
    }

    public int getIdProduction() {
        return idProduction;
    }

    public String getLabelProduction() {
        return labelProduction;
    }

    public static Production getProductionParId(int idProduction) {
        for (Production production : Production.values()) {
            if (production.getIdProduction() == idProduction) {
                return production;
            }
        }
        return null;
    }

}
