package util;

import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class StoreKeySecret {

    private Map<String, String> secretKeyMap = new ConcurrentHashMap<>();

    public String storeSecrets(String key, String value) {
        if (key.length() <= 20) {
            secretKeyMap.put(key.toLowerCase(), value);
        } else {
            throw new IllegalArgumentException("Invalid length of key" + key);
        }
        return key;
    }


    public String getSecret(String key) {
        String value = null;
        String inputKey = key.toLowerCase();
        if (secretKeyMap.containsKey(inputKey)) {
            value = secretKeyMap.get(inputKey);
        } else {
            throw new IllegalArgumentException("Key doesn't found " + key);
        }
        return value;
    }

    public int storeSecrets(int key, String value) {
        String strKey = String.valueOf(key);
        if (strKey.length() <= 20) {
            secretKeyMap.put(strKey.toLowerCase(), value);
        } else {
            throw new IllegalArgumentException("Invalid length of key" + key);
        }
        return key;
    }

    public String getSecret(int key) {
        String strKey = String.valueOf(key);
        String value = null;
        String inputKey = strKey.toLowerCase();
        if (secretKeyMap.containsKey(inputKey)) {
            value = secretKeyMap.get(inputKey);
        } else {
            throw new IllegalArgumentException("Key doesn't found " + key);
        }
        return value;
    }

    public String generateRandomKey(int lengthOfKey) {
        String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < lengthOfKey; i++) {
            int randomNumber = random.nextInt(candidateChars.length());
            sb.append(candidateChars.charAt(randomNumber));
        }
        return sb.toString();
    }
}