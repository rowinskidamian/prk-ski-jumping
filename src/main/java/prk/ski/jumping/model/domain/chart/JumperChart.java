package prk.ski.jumping.model.domain.chart;

import java.util.Objects;

/**
 * @author DamianRowinski
 */

public class JumperChart {

    private String label;
    private double data;

    public JumperChart(String label, double data) {
        this.label = label;
        this.data = data;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JumperChart that = (JumperChart) o;
        return Double.compare(that.data, data) == 0 && Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, data);
    }

    @Override
    public String toString() {
        return "JumperChart{" +
                "label='" + label + '\'' +
                ", data=" + data +
                '}';
    }
}
