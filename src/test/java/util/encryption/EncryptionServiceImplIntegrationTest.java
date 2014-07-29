package util.encryption;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Author: Piyush Bedi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:encryption-config.xml")
public class EncryptionServiceImplIntegrationTest {

    @Resource
    private EncryptionService encryptionService;

    @Test
    public void encryptAndDecrypt() {

        // Given
        String data = "data";

        // When
        String encryptedData = encryptionService.encrypt(data);
        String decryptedData = encryptionService.decrypt(encryptedData);

        // Then
        assertThat(encryptedData, is(not(data)));
        assertThat(decryptedData, is(data));
    }

    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }
}
