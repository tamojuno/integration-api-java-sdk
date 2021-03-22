package br.com.juno.integration.api.model;

import static br.com.juno.test.FixtureHelper.HOLDER_DOCUMENT;
import static br.com.juno.test.FixtureHelper.HOLDER_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;

import com.fasterxml.jackson.core.type.TypeReference;

import org.junit.jupiter.api.Test;
import org.springframework.hateoas.Resource;

import br.com.juno.integration.api.services.response.Response;
import br.com.juno.test.AbstractTest;
import br.com.juno.test.FixtureHelper;

public class LegalRepresentativeTest extends AbstractTest {

    private static final String MOTHER_NAME = "Alfredina";
    private static final String TYPE = "INDIVIDUAL";
    private static final LocalDate BIRTH_DATE = LocalDate.of(1994, 12, 12);

    @Test
    public void constructors() {
        LegalRepresentative legalRepresentative = new LegalRepresentative();
        assertNull(legalRepresentative.getName());
        assertNull(legalRepresentative.getDocument());
        assertNull(legalRepresentative.getBirthDate());
        assertNull(legalRepresentative.getMotherName());
        assertNull(legalRepresentative.getType());

        legalRepresentative = new LegalRepresentative();
        legalRepresentative.setName(HOLDER_NAME);
        legalRepresentative.setDocument(HOLDER_DOCUMENT);
        legalRepresentative.setBirthDate(BIRTH_DATE);
        legalRepresentative.setMotherName(MOTHER_NAME);
        legalRepresentative.setType(TYPE);

        assertEquals(HOLDER_NAME, legalRepresentative.getName());
        assertEquals(HOLDER_DOCUMENT, legalRepresentative.getDocument());
        assertEquals(BIRTH_DATE, legalRepresentative.getBirthDate());
        assertEquals(MOTHER_NAME, legalRepresentative.getMotherName());
        assertEquals(TYPE, legalRepresentative.getType());
    }

    @Test
    public void toStringComplete() {
        LegalRepresentative legalRepresentative = new LegalRepresentative();
        legalRepresentative.setName(FixtureHelper.HOLDER_NAME);
        legalRepresentative.setDocument(FixtureHelper.HOLDER_DOCUMENT);
        legalRepresentative.setBirthDate(BIRTH_DATE);
        legalRepresentative.setMotherName(MOTHER_NAME);
        legalRepresentative.setType(TYPE);
        assertEquals("LegalRepresentative[John Doe,06085371950,1994-12-12,Alfredina,INDIVIDUAL]", legalRepresentative.toString());
    }

    @Test
    public void toStringEmpty() {
        LegalRepresentative legalRepresentative = new LegalRepresentative();
        assertEquals("LegalRepresentative[<null>,<null>,<null>,<null>,<null>]", legalRepresentative.toString());
    }

    //TODO: create equality test

    @Test
    public void jsonToObject() throws Exception {
        Response<LegalRepresentative> res = new Response<>(getObjectMapper().readValue(findOne(), new TypeReference<Resource<LegalRepresentative>>() {
            // NTD
        }));

        assertEquals(null, res.getHrefSelf());

        LegalRepresentative legalRepresentative = res.getContent();

        assertEquals(HOLDER_NAME, legalRepresentative.getName());
        assertEquals(HOLDER_DOCUMENT, legalRepresentative.getDocument());
        assertEquals(BIRTH_DATE, legalRepresentative.getBirthDate());
        assertEquals(MOTHER_NAME, legalRepresentative.getMotherName());
        assertEquals(TYPE, legalRepresentative.getType());

    }

    private String findOne() {
        return "{\"name\":\"John Doe\",\"document\":\"06085371950\",\"birthDate\":\"1994-12-12\",\"motherName\":\"Alfredina\",\"type\":\"INDIVIDUAL\"}";
    }
}
