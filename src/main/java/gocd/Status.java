package gocd;

public enum Status {
    FAILED("rgb(225,86,74)", "failed"),
    PASSED("rgb(0,197,64)", "passed"),
    UNKNOWN("rgb(161,161,161)", "unknown"),
    CANCELLED("rgb(255,205,72)", "cancelled");

    private String colour;
    private String label;

    Status(String colour, String label) {
        this.colour = colour;
        this.label = label;
    }

    public String getColour() {
        return colour;
    }

    public String getLabel() {
        return label;
    }
}
