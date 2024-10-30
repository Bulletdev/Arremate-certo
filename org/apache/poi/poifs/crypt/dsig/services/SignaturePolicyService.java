package org.apache.poi.poifs.crypt.dsig.services;

public interface SignaturePolicyService {
  String getSignaturePolicyIdentifier();
  
  String getSignaturePolicyDescription();
  
  String getSignaturePolicyDownloadUrl();
  
  byte[] getSignaturePolicyDocument();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\dsig\services\SignaturePolicyService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */