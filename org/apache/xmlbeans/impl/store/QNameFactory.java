package org.apache.xmlbeans.impl.store;

import javax.xml.namespace.b;

public interface QNameFactory {
  b getQName(String paramString1, String paramString2);
  
  b getQName(String paramString1, String paramString2, String paramString3);
  
  b getQName(char[] paramArrayOfchar1, int paramInt1, int paramInt2, char[] paramArrayOfchar2, int paramInt3, int paramInt4);
  
  b getQName(char[] paramArrayOfchar1, int paramInt1, int paramInt2, char[] paramArrayOfchar2, int paramInt3, int paramInt4, char[] paramArrayOfchar3, int paramInt5, int paramInt6);
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\store\QNameFactory.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */