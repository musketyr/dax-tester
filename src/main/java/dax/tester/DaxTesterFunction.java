package dax.tester;

import io.micronaut.function.FunctionBean;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Objects;
import java.util.function.Supplier;

@FunctionBean("dax-tester")
public class DaxTesterFunction implements Supplier<String> {

    private final DaxTestEntityService testEntityService;

    public DaxTesterFunction(DaxTestEntityService testEntityService) {
        this.testEntityService = testEntityService;
    }

    @Override
    public String get() {
        long start = System.currentTimeMillis();

        InetSocketAddress address = new InetSocketAddress("testcluster.fdble5.clustercfg.dax.euw1.cache.amazonaws.com", 8111);

        try (Socket socket = new Socket()) {
            socket.connect(address, 10000);
        } catch (IOException e) {
            return "cannot connect to the cluster";
        }

        testEntityService.save(new DaxTestEntity().withHashKey("hash").withRange("range"));

        for (int i = 0; i < 1000 ; i++) {
            Objects.requireNonNull(testEntityService.load("hash", "range"));
        }

        long finish = System.currentTimeMillis();

        return "Loaded same entity for 1000 times in " + (finish - start) + " ms.";
    }
}
