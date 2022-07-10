package service;

public class StoreKeySecretString extends BaseStoreSecret {

    public String storeSecrets(String key, String value) {
        if (key.length() <= 20) {
            getSecretKeyMap().put(key.toLowerCase(), value);
        } else {
            throw new IllegalArgumentException("Invalid length of key" + key);
        }
        return key;
    }

    public String getSecret(String key) {
        String value = null;
        String inputKey = key.toLowerCase();
        if (getSecretKeyMap().containsKey(inputKey)) {
            value = getSecretKeyMap().get(inputKey);
        } else {
            throw new IllegalArgumentException("Key doesn't found " + key);
        }
        return value;
    }

}
