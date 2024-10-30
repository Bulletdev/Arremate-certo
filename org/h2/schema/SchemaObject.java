package org.h2.schema;

import org.h2.engine.DbObject;

public interface SchemaObject extends DbObject {
  Schema getSchema();
  
  boolean isHidden();
}


/* Location:              C:\Arremate\Arremate.jar!\org\h2\schema\SchemaObject.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */