package dax.tester;

import io.micronaut.function.client.FunctionClient;
import io.reactivex.Single;

import javax.inject.Named;

@FunctionClient
public interface DaxTesterClient {

    @Named("dax-tester")
    Single<String> index();

}
