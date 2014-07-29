package util.encryption;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

/**
 * Author: Piyush Bedi
 */
public class EncryptionServiceImplTest {

    EncryptionServiceImpl service;

    @Before
    public void setUp() throws Exception {
        // secret key generated from EncryptionUtilsImpl
        service = new EncryptionServiceImpl("baL9XqOKgQf0e0udiK/rOg==");
    }

    @Test
    public void encryptGeneratesEncryptedValueThatDoesNotEqualOrContainOriginal() throws Exception {
        // Given
        String value = "helloString";

        // When
        String encryptedValue = service.encrypt(value);

        // Then
        assertThat(encryptedValue, is(not(value)));
        assertThat(encryptedValue, not(containsString(value)));
    }

    @Test
    public void decryptEncryptedValueWillReturnOriginalValue() throws Exception {
        // Given
        String value = "valueToBeEncrypted";
        String encryptedCookieValue = service.encrypt(value);

        // When
        String decryptedValue = service.decrypt(encryptedCookieValue);

        // Then
        assertThat(decryptedValue, is(value));
    }
}
