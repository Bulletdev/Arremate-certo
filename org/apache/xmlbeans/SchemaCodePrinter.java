package org.apache.xmlbeans;

import java.io.IOException;
import java.io.Writer;

public interface SchemaCodePrinter {
  void printTypeImpl(Writer paramWriter, SchemaType paramSchemaType) throws IOException;
  
  void printType(Writer paramWriter, SchemaType paramSchemaType) throws IOException;
  
  void printLoader(Writer paramWriter, SchemaTypeSystem paramSchemaTypeSystem) throws IOException;
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\SchemaCodePrinter.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */