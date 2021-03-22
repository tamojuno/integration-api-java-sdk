package br.com.juno.integration.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.fasterxml.jackson.core.type.TypeReference;

import org.junit.jupiter.api.Test;
import org.springframework.hateoas.Resource;

import br.com.juno.integration.api.services.response.Response;
import br.com.juno.test.AbstractTest;

public class CompanyTypeTest extends AbstractTest {

    private static final String MEI = "MEI";

    @Test
    public void constructors() {
        CompanyType companyType = new CompanyType();
        assertNull(companyType.getType());
        companyType = new CompanyType(MEI);
        assertEquals(MEI, companyType.getType());
    }

    @Test
    public void toStringEmpty() {
        CompanyType companyType = new CompanyType();
        assertEquals("CompanyType[<null>]", companyType.toString());
    }

    @Test
    public void toStringComplete() {
        CompanyType companyType = new CompanyType(MEI);
        assertEquals("CompanyType[MEI]", companyType.toString());
    }

    @Test
    public void equality() {
        CompanyType target = new CompanyType(MEI);
        CompanyType equal = new CompanyType(MEI);
        CompanyType diff1 = new CompanyType();
        CompanyType diff2 = new CompanyType("EIRELLI");
        assertEquals(target, target);
        assertEquals(equal, target);
        assertFalse(target.equals(null));
        assertNotEquals(MEI, target);
        assertNotEquals(diff1, target);
        assertNotEquals(diff2, target);
    }

    @Test
    public void jsonToObject() throws Exception {
        Response<CompanyType> res = new Response<>(getObjectMapper().readValue(findOne(), new TypeReference<Resource<CompanyType>>() {
            // NTD
        }));
        assertNull(res.getHrefSelf());
        CompanyType companyType = res.getContent();
        assertEquals(MEI, companyType.getType());
    }

    public String findOne() {
        return "{\"type\":\"MEI\"}";
    }
}
