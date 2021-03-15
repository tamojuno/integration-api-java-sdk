package br.com.juno.integration.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.juno.test.AbstractTest;

public class LegalRepresentativeTest extends AbstractTest {

    @Test
    public void constructors() {
        assertEquals(findOneNull(), findIncompleteObject());
    }

    @Test
    public void toStringEmpty() {
        assertEquals(findOneNull(), findIncompleteObject());
    }

    @Test
    public void toStringFull() {
        assertEquals(findOneComplete(), findCompleteObject());
    }

    public String findOneNull() {
        return "{\"name\":null,\"document\":null,\"birthDate\":null,\"motherName\":null,\"type\":null}";
    }

    public String findOneComplete() {
        return "{\"name\":\"John Doe\",\"document\":\"06085371950\",\"birthDate\":\"1994-12-12\",\"motherName\":\"Alfredina\",\"type\":\"INDIVIDUAL\"}";
    }

    public String findCompleteObject() {
        LegalRepresentative legalRepresentative = new LegalRepresentative(HOLDER_NAME, HOLDER_CPF, LocalDate.of(1994, 12, 12), "Alfredina",
                "INDIVIDUAL");
        return legalRepresentative.toString();
    }

    public String findIncompleteObject() {
        LegalRepresentative legalRepresentative = new LegalRepresentative();
        legalRepresentative.getName();
        legalRepresentative.getDocument();
        legalRepresentative.getBirthDate();
        return legalRepresentative.toString();
    }
}
