package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STString;

public class CTBookmarkImpl extends CTBookmarkRangeImpl implements CTBookmark {
  private static final b NAME$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "name");
  
  public CTBookmarkImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STString xgetName() {
    synchronized (monitor()) {
      check_orphaned();
      STString sTString = null;
      sTString = (STString)get_store().find_attribute_user(NAME$0);
      return sTString;
    } 
  }
  
  public void setName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetName(STString paramSTString) {
    synchronized (monitor()) {
      check_orphaned();
      STString sTString = null;
      sTString = (STString)get_store().find_attribute_user(NAME$0);
      if (sTString == null)
        sTString = (STString)get_store().add_attribute_user(NAME$0); 
      sTString.set((XmlObject)paramSTString);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTBookmarkImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */