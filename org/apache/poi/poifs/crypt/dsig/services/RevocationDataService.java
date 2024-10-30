package org.apache.poi.poifs.crypt.dsig.services;

import java.security.cert.X509Certificate;
import java.util.List;

public interface RevocationDataService {
  RevocationData getRevocationData(List<X509Certificate> paramList);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\dsig\services\RevocationDataService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */