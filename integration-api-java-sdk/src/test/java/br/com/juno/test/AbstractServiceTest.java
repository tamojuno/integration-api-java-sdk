package br.com.juno.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.junit.jupiter.MockServerExtension;
import org.mockserver.junit.jupiter.MockServerSettings;

@ExtendWith(MockServerExtension.class)
@MockServerSettings(perTestSuite = true, ports = 8888)
public abstract class AbstractServiceTest extends AbstractTest {

    @BeforeEach
    public void startMockServer(ClientAndServer client) {
        this.mockServer = new MockServerManager(client);
    }

    protected MockServerManager mockServer() {
        return mockServer;
    }

    private MockServerManager mockServer;
}
