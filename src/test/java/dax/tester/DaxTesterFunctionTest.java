package dax.tester;

import io.micronaut.context.ApplicationContext;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DaxTesterFunctionTest {

    @Test
    public void testFunction() throws Exception {
        EmbeddedServer server = ApplicationContext.run(EmbeddedServer.class);

        DaxTesterClient client = server.getApplicationContext().getBean(DaxTesterClient.class);

        assertEquals(client.index().blockingGet(), "dax-tester");
        server.stop();
    }
}
