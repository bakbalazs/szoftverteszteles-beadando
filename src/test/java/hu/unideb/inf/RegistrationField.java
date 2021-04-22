package hu.unideb.inf;

import java.util.Objects;

public class RegistrationField {

    private final String id;
    private final String value;
    private final Boolean select;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationField that = (RegistrationField) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }

    public RegistrationField(String id, String value) {
        this.id = id;
        this.value = value;
        this.select = false;
    }

    public RegistrationField(String id, String value, Boolean select) {
        this.id = id;
        this.value = value;
        this.select = select;
    }

    public Boolean isSelect() {
        return select;
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

}
