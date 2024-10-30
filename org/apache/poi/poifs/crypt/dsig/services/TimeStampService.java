package org.apache.poi.poifs.crypt.dsig.services;

import org.apache.poi.poifs.crypt.dsig.SignatureConfig;

public interface TimeStampService extends SignatureConfig.SignatureConfigurable {
  byte[] timeStamp(byte[] paramArrayOfbyte, RevocationData paramRevocationData) throws Exception;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\dsig\services\TimeStampService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */