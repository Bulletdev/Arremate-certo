package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPTabAlignment;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPTabLeader;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPTabRelativeTo;

public class CTPTabImpl extends XmlComplexContentImpl implements CTPTab {
  private static final b ALIGNMENT$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "alignment");
  
  private static final b RELATIVETO$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "relativeTo");
  
  private static final b LEADER$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "leader");
  
  public CTPTabImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STPTabAlignment.Enum getAlignment() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALIGNMENT$0);
      if (simpleValue == null)
        return null; 
      return (STPTabAlignment.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STPTabAlignment xgetAlignment() {
    synchronized (monitor()) {
      check_orphaned();
      STPTabAlignment sTPTabAlignment = null;
      sTPTabAlignment = (STPTabAlignment)get_store().find_attribute_user(ALIGNMENT$0);
      return sTPTabAlignment;
    } 
  }
  
  public void setAlignment(STPTabAlignment.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALIGNMENT$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ALIGNMENT$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetAlignment(STPTabAlignment paramSTPTabAlignment) {
    synchronized (monitor()) {
      check_orphaned();
      STPTabAlignment sTPTabAlignment = null;
      sTPTabAlignment = (STPTabAlignment)get_store().find_attribute_user(ALIGNMENT$0);
      if (sTPTabAlignment == null)
        sTPTabAlignment = (STPTabAlignment)get_store().add_attribute_user(ALIGNMENT$0); 
      sTPTabAlignment.set((XmlObject)paramSTPTabAlignment);
    } 
  }
  
  public STPTabRelativeTo.Enum getRelativeTo() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RELATIVETO$2);
      if (simpleValue == null)
        return null; 
      return (STPTabRelativeTo.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STPTabRelativeTo xgetRelativeTo() {
    synchronized (monitor()) {
      check_orphaned();
      STPTabRelativeTo sTPTabRelativeTo = null;
      sTPTabRelativeTo = (STPTabRelativeTo)get_store().find_attribute_user(RELATIVETO$2);
      return sTPTabRelativeTo;
    } 
  }
  
  public void setRelativeTo(STPTabRelativeTo.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RELATIVETO$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(RELATIVETO$2); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetRelativeTo(STPTabRelativeTo paramSTPTabRelativeTo) {
    synchronized (monitor()) {
      check_orphaned();
      STPTabRelativeTo sTPTabRelativeTo = null;
      sTPTabRelativeTo = (STPTabRelativeTo)get_store().find_attribute_user(RELATIVETO$2);
      if (sTPTabRelativeTo == null)
        sTPTabRelativeTo = (STPTabRelativeTo)get_store().add_attribute_user(RELATIVETO$2); 
      sTPTabRelativeTo.set((XmlObject)paramSTPTabRelativeTo);
    } 
  }
  
  public STPTabLeader.Enum getLeader() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LEADER$4);
      if (simpleValue == null)
        return null; 
      return (STPTabLeader.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STPTabLeader xgetLeader() {
    synchronized (monitor()) {
      check_orphaned();
      STPTabLeader sTPTabLeader = null;
      sTPTabLeader = (STPTabLeader)get_store().find_attribute_user(LEADER$4);
      return sTPTabLeader;
    } 
  }
  
  public void setLeader(STPTabLeader.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LEADER$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LEADER$4); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetLeader(STPTabLeader paramSTPTabLeader) {
    synchronized (monitor()) {
      check_orphaned();
      STPTabLeader sTPTabLeader = null;
      sTPTabLeader = (STPTabLeader)get_store().find_attribute_user(LEADER$4);
      if (sTPTabLeader == null)
        sTPTabLeader = (STPTabLeader)get_store().add_attribute_user(LEADER$4); 
      sTPTabLeader.set((XmlObject)paramSTPTabLeader);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTPTabImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */