package br.com.juno.integration.api.model;

import static br.com.juno.test.FixtureHelper.BASE_URI;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import org.junit.jupiter.api.Test;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

import br.com.juno.integration.api.services.response.Response;
import br.com.juno.integration.api.services.response.Responses;
import br.com.juno.test.AbstractTest;

public class BusinessAreaTest extends AbstractTest {

    private static final Long BUSINESS_CODE = 1000L;
    private static final String BUSINESS_ACTIVITY = "Produtos";
    private static final String BUSINESS_CATEGORY = "Acessorios automotivos";

    public void constructors() {
        BusinessArea businessArea = new BusinessArea();
        assertNull(businessArea.getCode());
        assertNull(businessArea.getActivity());
        assertNull(businessArea.getCategory());

        businessArea = new BusinessArea();
        businessArea.setCode(BUSINESS_CODE);
        businessArea.setActivity(BUSINESS_ACTIVITY);
        businessArea.setCategory(BUSINESS_CATEGORY);

        assertEquals(BUSINESS_CODE, businessArea.getCode());
        assertEquals(BUSINESS_ACTIVITY, businessArea.getActivity());
        assertEquals(BUSINESS_CATEGORY, businessArea.getCategory());
    }

    @Test
    public void toStringComplete() {
        BusinessArea businessArea = new BusinessArea();
        businessArea.setCode(BUSINESS_CODE);
        businessArea.setActivity(BUSINESS_ACTIVITY);
        businessArea.setCategory(BUSINESS_CATEGORY);
        assertEquals("BusinessArea[1000,Produtos,Acessorios automotivos]", businessArea.toString());
    }

    @Test
    public void toStringEmpty() {
        BusinessArea businessArea = new BusinessArea();
        assertEquals("BusinessArea[<null>,<null>,<null>]", businessArea.toString());
    }

    @Test
    public void jsonToObject() throws Exception {
        Response<BusinessArea> res = new Response<>(getObjectMapper().readValue(findOne(), new TypeReference<Resource<BusinessArea>>() {
            // NTD
        }));

        assertEquals(null, res.getHrefSelf());

        BusinessArea businessArea = res.getContent();

        assertEquals(1000L, businessArea.getCode());
        assertEquals("Produtos", businessArea.getActivity());
        assertEquals("Acessorios automotivos", businessArea.getCategory());

    }

    @Test
    public void jsonToCollection() throws Exception {
        Responses<BusinessArea> res = new Responses<>(getObjectMapper().readValue(findAll(), new TypeReference<Resources<Resource<BusinessArea>>>() {
            // NTD
        }));

        assertEquals(BASE_URI + "/data/business-areas", res.getHrefSelf());
        assertEquals(null, res.getHrefNext());
        assertEquals(null, res.getHrefPrevious());

        List<Response<BusinessArea>> list = res.getContent();

        System.out.print(list);

        assertEquals(null, list.get(0).getHrefSelf());
        assertEquals(1000L, list.get(0).getContent().getCode());
        assertEquals("Produtos", list.get(0).getContent().getActivity());
        assertEquals("Acessorios automotivos", list.get(0).getContent().getCategory());

        assertEquals(null, list.get(1).getHrefSelf());
        assertEquals(1001L, list.get(1).getContent().getCode());
        assertEquals("Produtos", list.get(1).getContent().getActivity());
        assertEquals("Agronomia e agricultura", list.get(1).getContent().getCategory());

    }

    private String findOne() {
        return "{\"code\":1000,\"activity\":\"Produtos\",\"category\":\"Acessorios automotivos\"}";
    }

    private String findAll() {
        return "{\"_embedded\":{\"businessAreas\":[{\"code\":1000,\"activity\":\"Produtos\",\"category\":\"Acessorios automotivos\"},{\"code\":1001,\"activity\":\"Produtos\",\"category\":\"Agronomia e agricultura\"}]},\"_links\":{\"self\":{\"href\":\"https://sandbox.boletobancario.com/api-integration/data/business-areas\"}}}";
    }
}
