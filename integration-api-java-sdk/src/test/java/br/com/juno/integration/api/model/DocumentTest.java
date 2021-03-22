package br.com.juno.integration.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.fasterxml.jackson.core.type.TypeReference;

import org.junit.jupiter.api.Test;
import org.springframework.hateoas.Resource;

import br.com.juno.integration.api.services.response.Response;
import br.com.juno.test.AbstractTest;

public class DocumentTest extends AbstractTest {

    private static final String TYPE = "ID";
    private static final String DESCRIPTION = "Documento de identificação (RG ou CNH)";
    private static final String APPROVAL_STATUS = "VERIFYING";

    @Test
    public void constructor() {
        Document document = new Document();
        assertNull(document.getType());
        assertNull(document.getDescription());
        assertNull(document.getApprovalStatus());
        assertNull(document.getRejectionReason());
        assertNull(document.getDetails());

        document = new Document();
        document.setId("doc_8F9E38517610B987");
        document.setType(TYPE);
        document.setDescription(DESCRIPTION);
        document.setApprovalStatus(APPROVAL_STATUS);
        document.setRejectionReason(null);
        document.setDetails(null);

        assertEquals(TYPE, document.getType());
        assertEquals(DESCRIPTION, document.getDescription());
        assertEquals(APPROVAL_STATUS, document.getApprovalStatus());
        assertEquals(null, document.getRejectionReason());
        assertEquals(null, document.getDetails());
    }

    @Test
    public void toStringComplete() {
        Document document = new Document();
        document.setId("doc_8F9E38517610B987");
        document.setType(TYPE);
        document.setDescription(DESCRIPTION);
        document.setApprovalStatus(APPROVAL_STATUS);
        document.setRejectionReason(null);
        document.setDetails(null);

        assertEquals("Document[doc_8F9E38517610B987,ID,Documento de identificação (RG ou CNH),VERIFYING,<null>,<null>]", document.toString());
    }

    @Test
    public void toStringEmpty() {
        Document document = new Document();
        assertEquals("Document[<null>,<null>,<null>,<null>,<null>,<null>]", document.toString());
    }

    //TODO: create equality test

    @Test
    public void jsonToObject() throws Exception {
        Response<Document> res = new Response<>(getObjectMapper().readValue(findOne(), new TypeReference<Resource<Document>>() {
            // NTD
        }));

        assertEquals(null, res.getHrefSelf());

        Document document = res.getContent();

        assertEquals(TYPE, document.getType());
        assertEquals(DESCRIPTION, document.getDescription());
        assertEquals(APPROVAL_STATUS, document.getApprovalStatus());
        assertEquals(null, document.getRejectionReason());
        assertEquals(null, document.getDetails());

    }

    private String findOne() {
        return "{\"id\":\"doc_8F9E38517610B987\",\"type\":\"ID\",\"description\":\"Documento de identificação (RG ou CNH)\",\"approvalStatus\":\"VERIFYING\",\"rejectionStatus\":null,\"details\":null}";
    }
}
