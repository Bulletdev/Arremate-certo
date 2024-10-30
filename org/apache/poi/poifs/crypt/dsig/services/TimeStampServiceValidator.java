package org.apache.poi.poifs.crypt.dsig.services;

import java.security.cert.X509Certificate;
import java.util.List;

public interface TimeStampServiceValidator {
  void validate(List<X509Certificate> paramList, RevocationData paramRevocationData) throws Exception;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\dsig\services\TimeStampServiceValidator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */