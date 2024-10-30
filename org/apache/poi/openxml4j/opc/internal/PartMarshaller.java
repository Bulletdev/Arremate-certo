package org.apache.poi.openxml4j.opc.internal;

import java.io.OutputStream;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.PackagePart;

public interface PartMarshaller {
  boolean marshall(PackagePart paramPackagePart, OutputStream paramOutputStream) throws OpenXML4JException;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\internal\PartMarshaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */