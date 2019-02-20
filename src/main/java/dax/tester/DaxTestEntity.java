package dax.tester;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "DaxTestEntity")
public class DaxTestEntity {

    @DynamoDBHashKey
    private String hashKey;

    @DynamoDBRangeKey
    private String range;

    public String getHashKey() {
        return hashKey;
    }

    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }

    public DaxTestEntity withHashKey(String hashKey) {
        this.hashKey = hashKey;
        return this;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public DaxTestEntity withRange(String range) {
        this.range = range;
        return this;
    }
}
