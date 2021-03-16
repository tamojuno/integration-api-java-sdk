package br.com.juno.integration.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.fasterxml.jackson.core.type.TypeReference;

import org.junit.jupiter.api.Test;
import org.springframework.hateoas.Resource;

import br.com.juno.integration.api.services.response.Response;
import br.com.juno.test.AbstractTest;

public class PixRandomKeysTest extends AbstractTest {

    private static final String PIX_ID = "dct_4B611CF90EEAD1EA";
    private static final String PIX_KEY = "2878cf11-5d42-4c1b-8e0f-0f95f365ab3f";
    private static final String PIX_CREATION_DATE_TIME = "2021-03-15T11:41:02.603-03:00";
    private static final String PIX_OWNERSHIP_DATE_TIME = "2021-03-15T11:41:02.603-03:00";
    private static final String PIX_CLAIM_REQUEST_DATE_TIME = "2021-03-15T11:41:02.603-03:00";

    @Test
    public void constructors() {
        PixRandomKeys pixRandomKeys = new PixRandomKeys();
        assertNull(pixRandomKeys.getId());
        assertNull(pixRandomKeys.getKey());
        assertNull(pixRandomKeys.getCreationDateTime());
        assertNull(pixRandomKeys.getOwnershipDateTime());
        assertNull(pixRandomKeys.getClaimRequestDateTime());

        pixRandomKeys = new PixRandomKeys();
        pixRandomKeys.setId(PIX_ID);
        pixRandomKeys.setKey(PIX_KEY);
        pixRandomKeys.setCreationDateTime(PIX_CREATION_DATE_TIME);
        pixRandomKeys.setOwnershipDateTime(PIX_OWNERSHIP_DATE_TIME);
        pixRandomKeys.setClaimRequestDateTime(PIX_CLAIM_REQUEST_DATE_TIME);

        assertEquals(PIX_KEY, pixRandomKeys.getKey());
        assertEquals(PIX_CREATION_DATE_TIME, pixRandomKeys.getCreationDateTime());
        assertEquals(PIX_OWNERSHIP_DATE_TIME, pixRandomKeys.getOwnershipDateTime());
        assertEquals(PIX_CLAIM_REQUEST_DATE_TIME, pixRandomKeys.getClaimRequestDateTime());

    }

    @Test
    public void toStringComplete() {
        PixRandomKeys pixRandomKeys = new PixRandomKeys();
        pixRandomKeys.setId(PIX_ID);
        pixRandomKeys.setKey(PIX_KEY);
        pixRandomKeys.setCreationDateTime(PIX_CREATION_DATE_TIME);
        pixRandomKeys.setOwnershipDateTime(PIX_OWNERSHIP_DATE_TIME);
        pixRandomKeys.setClaimRequestDateTime(PIX_CLAIM_REQUEST_DATE_TIME);
        assertEquals(
                "PixRandomKeys[dct_4B611CF90EEAD1EA,2878cf11-5d42-4c1b-8e0f-0f95f365ab3f,2021-03-15T11:41:02.603-03:00,2021-03-15T11:41:02.603-03:00,2021-03-15T11:41:02.603-03:00]",
                pixRandomKeys.toString());
    }

    @Test
    public void toStringEmpty() {
        PixRandomKeys pixRandomKeys = new PixRandomKeys();
        assertEquals("PixRandomKeys[<null>,<null>,<null>,<null>,<null>]", pixRandomKeys.toString());
    }

    @Test
    public void jsonToObject() throws Exception {
        Response<PixRandomKeys> res = new Response<>(getObjectMapper().readValue(findOne(), new TypeReference<Resource<PixRandomKeys>>() {
            // NTD
        }));

        assertEquals(null, res.getHrefSelf());

        PixRandomKeys pixRandomKeys = res.getContent();
        System.out.println(res.getContent());

        assertEquals(PIX_KEY, pixRandomKeys.getKey());
        assertEquals(PIX_CREATION_DATE_TIME, pixRandomKeys.getCreationDateTime());
        assertEquals(PIX_OWNERSHIP_DATE_TIME, pixRandomKeys.getOwnershipDateTime());
        assertEquals(PIX_CLAIM_REQUEST_DATE_TIME, pixRandomKeys.getClaimRequestDateTime());

    }

    private String findOne() {
        return "{\"id\":\"dct_4B611CF90EEAD1EA\",\"key\":\"2878cf11-5d42-4c1b-8e0f-0f95f365ab3f\",\"creationDateTime\":\"2021-03-15T11:41:02.603-03:00\",\"ownershipDateTime\":\"2021-03-15T11:41:02.603-03:00\",\"claimRequestDateTime\":\"2021-03-15T11:41:02.603-03:00\"}";
    }
}
