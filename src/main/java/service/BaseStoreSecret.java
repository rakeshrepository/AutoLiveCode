package service;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class BaseStoreSecret implements IStoreSecretKey {

    private Map<String, String> secretKeyMap;

    public BaseStoreSecret() {
        secretKeyMap = new ConcurrentHashMap<>();
    }

    public Map<String, String> getSecretKeyMap() {
        return secretKeyMap;
    }

    public void setSecretKeyMap(Map<String, String> secretKeyMap) {
        this.secretKeyMap = secretKeyMap;
    }

    @Override
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
