package br.com.juno.integration.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;

import com.fasterxml.jackson.core.type.TypeReference;

import org.junit.jupiter.api.Test;
import org.springframework.hateoas.Resource;

import br.com.juno.integration.api.services.response.Response;
import br.com.juno.test.AbstractTest;

public class BalanceTest extends AbstractTest {

    private static final BigDecimal BALANCE = BigDecimal.valueOf(36424.02D);
    private static final BigDecimal WITHHELD = BigDecimal.valueOf(1434.63D);
    private static final BigDecimal TRANSFERABLE = BigDecimal.valueOf(34989.39D);

    @Test
    public void constructors() {
        Balance balance = new Balance();
        assertNull(balance.getBalance());
        assertNull(balance.getWithheldBalance());
        assertNull(balance.getTransferableBalance());

        balance = new Balance();
        balance.setBalance(BALANCE);
        balance.setWithheldBalance(WITHHELD);
        balance.setTransferableBalance(TRANSFERABLE);

        assertEquals(BALANCE, balance.getBalance());
        assertEquals(WITHHELD, balance.getWithheldBalance());
        assertEquals(TRANSFERABLE, balance.getTransferableBalance());
    }

    @Test
    public void toStringComplete() {
        Balance balance = new Balance();
        balance.setBalance(BALANCE);
        balance.setWithheldBalance(WITHHELD);
        balance.setTransferableBalance(TRANSFERABLE);
        assertEquals("Balance[36424.02,1434.63,34989.39]", balance.toString());
    }

    @Test
    public void toStringEmpty() {
        Balance balance = new Balance();
        assertEquals("Balance[<null>,<null>,<null>]", balance.toString());
    }

    //TODO: create equality test

    @Test
    public void jsonToObject() throws Exception {
        Response<Balance> res = new Response<>(getObjectMapper().readValue(findOne(), new TypeReference<Resource<Balance>>() {
            // NTD
        }));

        assertEquals(null, res.getHrefSelf());

        Balance balance = res.getContent();

        assertEquals(BigDecimal.valueOf(36424.02D), balance.getBalance());
        assertEquals(BigDecimal.valueOf(1434.63D), balance.getWithheldBalance());
        assertEquals(BigDecimal.valueOf(34989.39D), balance.getTransferableBalance());
    }

    private String findOne() {
        return "{\"balance\":36424.02,\"withheldBalance\":1434.63,\"transferableBalance\":34989.39}";
    }

}
