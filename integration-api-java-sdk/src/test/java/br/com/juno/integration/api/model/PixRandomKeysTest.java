package br.com.juno.integration.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.juno.test.AbstractTest;

public class PixRandomKeysTest extends AbstractTest {

    @Test
    public void constructors() {
        // NTD
        assertEquals(findOneComplete(), findCompleteObject());
    }

    @Test
    public void toStringEmpty() {
        // NTD
        assertEquals(findOneNull(), findIncompleteObject());
    }

    @Test
    public void toStringComplete() {
        // NTD
        assertEquals(findOneComplete(), findCompleteObject());
    }

    @Test
    public void equality() {
        // NTD
    }

    public String findOneComplete() {
        // NTD
        return "{\"id\":\"dct_4B611CF90EEAD1EA\",\"key\":\"2878cf11-5d42-4c1b-8e0f-0f95f365ab3f\",\"creationDateTime\":\"2021-03-15T11:41:02.603-03:00\",\"ownershipDateTime\":\"2021-03-15T11:41:02.603-03:00\",\"claimRequestDateTime\":\"2021-03-15T11:41:02.603-03:00\"}";
    }

    public String findOneNull() {
        // NTD
        return "{\"id\":null,\"key\":null,\"creationDateTime\":null,\"ownershipDateTime\":null,\"claimRequestDateTime\":null}";
    }

    public String findCompleteObject() {
        // NTD
        PixRandomKeys pixRandomKeys = new PixRandomKeys();
        pixRandomKeys.setId("dct_4B611CF90EEAD1EA");
        pixRandomKeys.setKey("2878cf11-5d42-4c1b-8e0f-0f95f365ab3f");
        pixRandomKeys.setCreationDateTime("2021-03-15T11:41:02.603-03:00");
        pixRandomKeys.setOwnershipDateTime("2021-03-15T11:41:02.603-03:00");
        pixRandomKeys.setClaimRequestDateTime("2021-03-15T11:41:02.603-03:00");
        return pixRandomKeys.toString();

    }

    public String findIncompleteObject() {
        // NTD
        PixRandomKeys pixRandomKeys = new PixRandomKeys();
        pixRandomKeys.getId();
        pixRandomKeys.getKey();
        pixRandomKeys.getCreationDateTime();
        pixRandomKeys.getOwnershipDateTime();
        pixRandomKeys.getClaimRequestDateTime();
        return pixRandomKeys.toString();
    }
}
