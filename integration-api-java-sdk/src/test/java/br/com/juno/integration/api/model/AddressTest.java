package br.com.juno.integration.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import br.com.juno.test.AbstractTest;

public class AddressTest extends AbstractTest {

    private static final String STREET = "Rua Mariano Torres";
    private static final String NUMBER = "729";
    private static final String COMPLEMENT = "Mariano Corporate";
    private static final String NEIGHBORHOOD = "Centro";
    private static final String CITY = "Curitiba";
    private static final String STATE = "PR";
    private static final String POSTCODE = "80060120";

    @Test
    public void constructors() {
        // NTD
        Address address = new Address();
        address = findIncompleteObject();
        assertEquals(findOneNull(), address.toString());
        address = findCompleteObject();
        assertEquals(findOne(), address.toString());
    }

    @Test
    public void toStringEmpty() {
        Address address = new Address();
        assertEquals(findOneNull(), address.toString());
    }

    @Test
    public void toStringComplete() {
        Address address = findCompleteObject();
        assertEquals(findOne(), address.toString());
    }

    @Test
    public void equality() {
        Address target = findCompleteObject();
        Address equal = target;
        Address diff1 = findIncompleteObject();
        Address diff2 = new Address(STREET, null, COMPLEMENT, NEIGHBORHOOD, CITY, STATE, POSTCODE);
        assertEquals(target, target);
        assertEquals(equal, target);
        assertFalse(target.equals(null));
        assertNotEquals(STREET, target);
        assertNotEquals(diff1, target);
        assertNotEquals(diff2, target);

    }

    public String findOne() {
        return "{\"street\":\"Rua Mariano Torres\",\"number\":\"729\",\"complement\":\"Mariano Corporate\",\"neighborhood\":\"Centro\",\"city\":\"Curitiba\",\"state\":\"PR\",\"postCode\":\"80060120\"}";
    }

    public String findOneNull() {
        return "{\"street\":null,\"number\":null,\"complement\":null,\"neighborhood\":null,\"city\":null,\"state\":null,\"postCode\":null}";
    }

    public Address findCompleteObject() {
        Address address = new Address();
        address.setStreet(STREET);
        address.setNumber(NUMBER);
        address.setComplement(COMPLEMENT);
        address.setNeighborhood(NEIGHBORHOOD);
        address.setCity(CITY);
        address.setState(STATE);
        address.setPostCode(POSTCODE);
        return address;
    }

    public Address findIncompleteObject() {
        Address address = new Address();
        address.getStreet();
        address.getNumber();
        address.getComplement();
        address.getNeighborhood();
        address.getCity();
        address.getState();
        address.getPostCode();
        return address;
    }

}
