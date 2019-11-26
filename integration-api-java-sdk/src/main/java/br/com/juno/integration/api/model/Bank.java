package br.com.juno.integration.api.model;

public final class Bank extends BaseModel {

    private static final long serialVersionUID = -3918516666752671116L;

    private String number;
    private String name;

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    protected void setNumber(String number) {
        this.number = number;
    }

    protected void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bank [number=" + number + ", name=" + name + "]";
    }
}