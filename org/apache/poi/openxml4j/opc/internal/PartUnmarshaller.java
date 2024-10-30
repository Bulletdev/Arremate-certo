package org.apache.poi.openxml4j.opc.internal;

import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.internal.unmarshallers.UnmarshallContext;

public interface PartUnmarshaller {
  PackagePart unmarshall(UnmarshallContext paramUnmarshallContext, InputStream paramInputStream) throws InvalidFormatException, IOException;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\internal\PartUnmarshaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */