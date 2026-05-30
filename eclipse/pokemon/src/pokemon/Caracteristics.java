package pokemon;

public class Caracteristics {
    private String name;
    private double effect;
    private boolean isAttacking;

    public Caracteristics(String name, double effect, boolean isAttacking) {
        this.name = name;
        this.effect = effect;
        this.isAttacking = isAttacking;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEffect() {
        return effect;
    }

    public void setEffect(double effect) {
        this.effect = effect;
    }

    public boolean isAttacking() {
        return isAttacking;
    }

    public void setAttacking(boolean isAttacking) {
        this.isAttacking = isAttacking;
    }
}
