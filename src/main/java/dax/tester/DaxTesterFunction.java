package dax.tester;

import io.micronaut.function.FunctionBean;

import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;

@FunctionBean("dax-tester")
public class DaxTesterFunction implements Supplier<String> {

    private final DaxTestEntityService testEntityService;

    public DaxTesterFunction(DaxTestEntityService testEntityService) {
        this.testEntityService = testEntityService;
    }

    @Override
    public String get() {
        long start = System.currentTimeMillis();


        DaxTestEntity entity = new DaxTestEntity().withHashKey("hash").withRange("range");
        testEntityService.save(entity);

        for (int i = 0; i < 1000 ; i++) {
            requireNonNull(testEntityService.load("hash", "range"));
        }

        long finish = System.currentTimeMillis();

        return "Loaded same entity for 1000 times in " + (finish - start) + " ms.";
    }
}
