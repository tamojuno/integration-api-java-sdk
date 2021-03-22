package br.com.juno.integration.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.fasterxml.jackson.core.type.TypeReference;

import org.junit.jupiter.api.Test;
import org.springframework.hateoas.Resource;

import br.com.juno.integration.api.services.response.Response;
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
        Address address = new Address();
        assertNull(address.getStreet());
        assertNull(address.getNumber());
        assertNull(address.getComplement());
        assertNull(address.getNeighborhood());
        assertNull(address.getCity());
        assertNull(address.getState());
        assertNull(address.getPostCode());

        address = buildCompleteObject();
        assertEquals(address, address);

    }

    @Test
    public void toStringComplete() {
        assertEquals("Address[Rua Mariano Torres,729,Mariano Corporate,Centro,Curitiba,PR,80060120]", buildCompleteObject().toString());
    }

    @Test
    public void toStringEmpty() {
        Address address = new Address();
        assertEquals("Address[<null>,<null>,<null>,<null>,<null>,<null>,<null>]", address.toString());
    }

    //TODO: create equality test

    @Test
    public void jsonToObject() throws Exception {
        Response<Address> res = new Response<>(getObjectMapper().readValue(findOne(), new TypeReference<Resource<Address>>() {
            // NTD
        }));

        assertEquals(null, res.getHrefSelf());

        Address address = res.getContent();

        assertEquals(STREET, address.getStreet());
        assertEquals(NUMBER, address.getNumber());
        assertEquals(COMPLEMENT, address.getComplement());
        assertEquals(NEIGHBORHOOD, address.getNeighborhood());
        assertEquals(CITY, address.getCity());
        assertEquals(STATE, address.getState());
        assertEquals(POSTCODE, address.getPostCode());

    }

    private String findOne() {
        return "{\"street\":\"Rua Mariano Torres\",\"number\":\"729\",\"complement\":\"Mariano Corporate\",\"neighborhood\":\"Centro\",\"city\":\"Curitiba\",\"state\":\"PR\",\"postCode\":\"80060120\"}";
    }

    private Address buildCompleteObject() {
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

}
