package util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

public class StoreKeySecretTest {

    @Mock
    private StoreKeySecret storeKeySecret;

    @BeforeEach
    void setup() {
        storeKeySecret = new StoreKeySecret();
    }

    @Test
    @DisplayName("Successful store of secret and value")
    public void storeSecretsTest() {
        String key = "mY-cUsTom-kEy";
        String value = "My secret";
        String secretValue = storeKeySecret.storeSecrets(key, value);
        assertEquals(key, secretValue);
    }

    @Test
    @DisplayName("Key is >= 20 IllegalArgument exception")
    public void invalidKeyTest() {
        String key = "mY-cUsTom-kEy-mY-cUsTom-kEy-mY-cUsTom-kEy-mY-cUsTom-kEy-";
        String value = "My secret";
        assertThrows(IllegalArgumentException.class, () -> storeKeySecret.storeSecrets(key, value));
    }

    @Test
    @DisplayName("Key not found exeption scenario")
    public void getSecretNotFoundTest() {
        String key = "not_exits";
        assertThrows(IllegalArgumentException.class, () ->
                storeKeySecret.getSecret(key));
    }

    @Test
    @DisplayName("Get secret value for the key")
    public void getSecretTest() {
        String key = "mY-cUsTom-kEy";
        String value = "My secret";
        storeKeySecret.storeSecrets(key, value);
        String secValue = storeKeySecret.getSecret(key);
        assertEquals(value, secValue);
    }

    @Test
    @DisplayName("In case sensitive key scenario")
    public void keyCaseInsensitiveTest() {
        String key = "my-custom-key";
        String value = "case insensitive secret value";
        storeKeySecret.storeSecrets(key, value);

        String inputKey = "mY-cUsTom-kEy";
        String secValue = storeKeySecret.getSecret(inputKey);
        assertEquals(value, secValue);
    }

    @Test
    @DisplayName("In case sensitive key scenario")
    public void intStoreSecretTest() {
        int key = 255;
        String value = "case insensitive secret value";
        storeKeySecret.storeSecrets(key, value);
        String secValue = storeKeySecret.getSecret("255");
        String inpValue = storeKeySecret.getSecret(255);
        assertEquals(value, secValue);
    }

    @Test
    @DisplayName("Random key generate test case")
    public void generateRandomKeyTest() {
        assertNotNull(storeKeySecret.generateRandomKey());
    }

    @Test
    @DisplayName("Random key generate test case")
    public void generateRandomKeyToStoreTest() {
        String key = storeKeySecret.generateRandomKey();
        String value = "random key value";
        storeKeySecret.storeSecrets(key, value);
        String secValue = storeKeySecret.getSecret(key);
        assertEquals(value, secValue);

    }


}
