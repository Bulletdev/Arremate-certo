package org.apache.poi.poifs.crypt;

import java.io.IOException;
import org.apache.poi.util.LittleEndianInput;

public interface EncryptionInfoBuilder {
  void initialize(EncryptionInfo paramEncryptionInfo, LittleEndianInput paramLittleEndianInput) throws IOException;
  
  void initialize(EncryptionInfo paramEncryptionInfo, CipherAlgorithm paramCipherAlgorithm, HashAlgorithm paramHashAlgorithm, int paramInt1, int paramInt2, ChainingMode paramChainingMode);
  
  EncryptionHeader getHeader();
  
  EncryptionVerifier getVerifier();
  
  Decryptor getDecryptor();
  
  Encryptor getEncryptor();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\EncryptionInfoBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */