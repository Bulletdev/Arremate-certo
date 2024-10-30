package org.apache.xmlbeans.impl.values;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaField;

public interface TypeStoreVisitor {
  boolean visit(b paramb);
  
  int get_elementflags();
  
  String get_default_text();
  
  SchemaField get_schema_field();
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\TypeStoreVisitor.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */