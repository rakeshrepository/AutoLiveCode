package util;

import java.util.HashMap;
import java.util.Map;

public class StoreSecret<T, V> {

    private T key;
    private V secretValue;

    private Map<T, V> secretKeyMap = new HashMap<>();

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public V getSecretValue() {
        return secretValue;
    }

    public void setSecretValue(V secretValue) {
        this.secretValue = secretValue;
    }

    public T storeSecrets(T key, V value) {
        if (String.valueOf(key).length() <= 20) {
            secretKeyMap.put(key, value);
        } else {
            throw new IllegalArgumentException("Invalid length of key" + key);
        }
        return key;
    }

    public V getSecret(T key) {
        return secretKeyMap.get(key);
    }
}

