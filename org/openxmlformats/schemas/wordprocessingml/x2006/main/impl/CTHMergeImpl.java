package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;

public class CTHMergeImpl extends XmlComplexContentImpl implements CTHMerge {
  private static final b VAL$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");
  
  public CTHMergeImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STMerge.Enum getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        return null; 
      return (STMerge.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STMerge xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STMerge sTMerge = null;
      sTMerge = (STMerge)get_store().find_attribute_user(VAL$0);
      return sTMerge;
    } 
  }
  
  public boolean isSetVal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VAL$0) != null);
    } 
  }
  
  public void setVal(STMerge.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVal(STMerge paramSTMerge) {
    synchronized (monitor()) {
      check_orphaned();
      STMerge sTMerge = null;
      sTMerge = (STMerge)get_store().find_attribute_user(VAL$0);
      if (sTMerge == null)
        sTMerge = (STMerge)get_store().add_attribute_user(VAL$0); 
      sTMerge.set((XmlObject)paramSTMerge);
    } 
  }
  
  public void unsetVal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VAL$0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTHMergeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */