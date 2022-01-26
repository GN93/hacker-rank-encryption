package com.github.gnajduch.encryption;

import com.github.gnajduch.encryption.exception.InputSizeExceededException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EncryptionTest {

    @Test
    void testInstructionSamples() throws InputSizeExceededException {
        String sample1 = "ifmanwasmeanttostayonthegroundgodwouldhavegivenusroots";
        String expectedCipher1 = "imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau";
        Assertions.assertEquals(expectedCipher1, Encryption.encrypt(sample1));

        String sample2 = "haveaniceday";
        String expectedCipher2 = "hae and via ecy";
        Assertions.assertEquals(expectedCipher2, Encryption.encrypt(sample2));

        String sample3 = "feedthedog";
        String expectedCipher3 = "fto ehg ee dd";
        Assertions.assertEquals(expectedCipher3, Encryption.encrypt(sample3));

        String sample4 = "chillout";
        String expectedCipher4 = "clu hlt io";
        Assertions.assertEquals(expectedCipher4, Encryption.encrypt(sample4));
    }

    @Test()
    void testCornerCases() throws InputSizeExceededException {
        Assertions.assertEquals("", Encryption.encrypt(""));

        String singleCharInput = "a";
        String expectedCipher = "a";
        Assertions.assertEquals(expectedCipher, Encryption.encrypt(singleCharInput));


        String maxLengthString = "godwouldhavegivenusrootsifmanwasmeanttostayonthegroundgodwouldhavegivenusrootsiff";
        String expectedCipher2 = "gasattgas ovrnthovr deowoedeo wgoasgwgo oitstroit uvsmaouvs leieyulei dnfaondnf humnndhuf";

        Assertions.assertEquals(81, maxLengthString.length());
        Assertions.assertEquals(expectedCipher2, Encryption.encrypt(maxLengthString));
    }

    @Test
    void testStringContainingSpecialCharacters() throws InputSizeExceededException {
        String specialCharsInput = "TeSt?!-";
        String expectedCipher = "Tt- e? S!";
        Assertions.assertEquals(expectedCipher, Encryption.encrypt(specialCharsInput));
    }

    @Test
    void testExceptionThrownOnInputSizeExceeded() {
        String longSample = "Loremipsumdolorsitamet,consecteturadipiscingelit,seddoeiusmodtempor.Loremipsumdolorsitamet";
        Assertions.assertThrows(InputSizeExceededException.class, () -> Encryption.encrypt(longSample));
    }

}
