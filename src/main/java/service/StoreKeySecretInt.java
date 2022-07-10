package service;

public class StoreKeySecretInt extends BaseStoreSecret {

    public int storeSecrets(int key, String value) {
        String strKey = String.valueOf(key);
        if (strKey.length() <= 20) {
            getSecretKeyMap().put(strKey.toLowerCase(), value);
        } else {
            throw new IllegalArgumentException("Invalid length of key" + key);
        }
        return key;
    }

    public String getSecret(int key) {
        String strKey = String.valueOf(key);
        String value = null;
        String inputKey = strKey.toLowerCase();
        if (getSecretKeyMap().containsKey(inputKey)) {
            value = getSecretKeyMap().get(inputKey);
        } else {
            throw new IllegalArgumentException("Key doesn't found " + key);
        }
        return value;
    }
}
