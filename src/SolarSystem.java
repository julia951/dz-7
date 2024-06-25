public enum SolarSystem {
    MERCURY(0, 2440, null),
    VENUS(50, 6052, MERCURY),
    EARTH(40, 6371, VENUS),
    MARS(60, 3396, EARTH),
    JUPITER(550, 71492, MARS),
    SATURN(650, 60232, JUPITER),
    URANUS(1200, 25559, SATURN),
    NEPTUNE(1600, 24624, URANUS);

    private final int order;
    private final int prevDistance;
    private final int distanceFromSun;
    private final int radius;
    private final SolarSystem previous;
    private SolarSystem next;

    static {
        for (SolarSystem planet : SolarSystem.values()) {
            if (planet.previous != null) {
                planet.previous.setNext(planet);
            }
        }
    }

    SolarSystem(int prevDistance, int radius, SolarSystem previous) {
        this.order = this.ordinal() + 1;
        this.prevDistance = prevDistance;
        this.radius = radius;
        this.previous = previous;
        this.distanceFromSun = (previous == null) ? 0 : previous.distanceFromSun + prevDistance;
    }

    public int getOrder() {
        return order;
    }

    public int getPrevDistance() {
        return prevDistance;
    }

    public int getDistanceFromSun() {
        return distanceFromSun;
    }

    public int getRadius() {
        return radius;
    }

    public SolarSystem getPrevious() {
        return previous;
    }

    public SolarSystem getNext() {
        return next;
    }

    private void setNext(SolarSystem next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return String.format("Планета: %s, Порядковий номер планети від Сонця: %d, відстань від попередньої планети: %d, відстань від Сонця: %d, Радіус планети: %d, попередня планета: %s, наступна планета: %s",
                this.name(), order, prevDistance, distanceFromSun, radius,
                (previous != null ? previous.name() : "Відсутня"),
                (next != null ? next.name() : "Відсутня"));
    }

    public static void main(String[] args) {
        for (SolarSystem planet : SolarSystem.values()) {
            System.out.println(planet);
        }
    }
}
