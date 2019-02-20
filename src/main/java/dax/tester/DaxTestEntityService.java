package dax.tester;

import com.agorapulse.micronaut.aws.dynamodb.annotation.Service;

@Service(DaxTestEntity.class)
public interface DaxTestEntityService {

    DaxTestEntity save(DaxTestEntity entity);
    DaxTestEntity load(String hashKey, String rangeKey);

}
