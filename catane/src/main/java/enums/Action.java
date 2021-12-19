package enums;

public enum Action {
    PASSE(0, "Passer votre tour"),
    ROUTE(1, "Acheter une route"),
    COLONIE(2, "Acheter une colonie"),
    VILLE(3, "Acheter une ville"),
    COMMERCESANSPORT (4, "Faire du commerce sans port");

    private int idAction;
    private String labelAction;

    private Action(int idAction, String labelAction) {
        this.idAction = idAction;
        this.labelAction = labelAction;
    }

    public int getIdAction() {
        return idAction;
    }

    public String getLabelAction() {
        return labelAction;
    }

    public static Action getActionParId(int idAction) {
        for (Action action : Action.values()) {
            if (action.getIdAction() == idAction) {
                return action;
            }
        }
        return null;
    }
    





}
