package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STSignedTwipsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTabJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTabTlc;

public class CTTabStopImpl extends XmlComplexContentImpl implements CTTabStop {
  private static final b VAL$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "val");
  
  private static final b LEADER$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "leader");
  
  private static final b POS$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pos");
  
  public CTTabStopImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STTabJc.Enum getVal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        return null; 
      return (STTabJc.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTabJc xgetVal() {
    synchronized (monitor()) {
      check_orphaned();
      STTabJc sTTabJc = null;
      sTTabJc = (STTabJc)get_store().find_attribute_user(VAL$0);
      return sTTabJc;
    } 
  }
  
  public void setVal(STTabJc.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VAL$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVal(STTabJc paramSTTabJc) {
    synchronized (monitor()) {
      check_orphaned();
      STTabJc sTTabJc = null;
      sTTabJc = (STTabJc)get_store().find_attribute_user(VAL$0);
      if (sTTabJc == null)
        sTTabJc = (STTabJc)get_store().add_attribute_user(VAL$0); 
      sTTabJc.set((XmlObject)paramSTTabJc);
    } 
  }
  
  public STTabTlc.Enum getLeader() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LEADER$2);
      if (simpleValue == null)
        return null; 
      return (STTabTlc.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STTabTlc xgetLeader() {
    synchronized (monitor()) {
      check_orphaned();
      STTabTlc sTTabTlc = null;
      sTTabTlc = (STTabTlc)get_store().find_attribute_user(LEADER$2);
      return sTTabTlc;
    } 
  }
  
  public boolean isSetLeader() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(LEADER$2) != null);
    } 
  }
  
  public void setLeader(STTabTlc.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(LEADER$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(LEADER$2); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetLeader(STTabTlc paramSTTabTlc) {
    synchronized (monitor()) {
      check_orphaned();
      STTabTlc sTTabTlc = null;
      sTTabTlc = (STTabTlc)get_store().find_attribute_user(LEADER$2);
      if (sTTabTlc == null)
        sTTabTlc = (STTabTlc)get_store().add_attribute_user(LEADER$2); 
      sTTabTlc.set((XmlObject)paramSTTabTlc);
    } 
  }
  
  public void unsetLeader() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(LEADER$2);
    } 
  }
  
  public BigInteger getPos() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(POS$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getBigIntegerValue();
    } 
  }
  
  public STSignedTwipsMeasure xgetPos() {
    synchronized (monitor()) {
      check_orphaned();
      STSignedTwipsMeasure sTSignedTwipsMeasure = null;
      sTSignedTwipsMeasure = (STSignedTwipsMeasure)get_store().find_attribute_user(POS$4);
      return sTSignedTwipsMeasure;
    } 
  }
  
  public void setPos(BigInteger paramBigInteger) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(POS$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(POS$4); 
      simpleValue.setBigIntegerValue(paramBigInteger);
    } 
  }
  
  public void xsetPos(STSignedTwipsMeasure paramSTSignedTwipsMeasure) {
    synchronized (monitor()) {
      check_orphaned();
      STSignedTwipsMeasure sTSignedTwipsMeasure = null;
      sTSignedTwipsMeasure = (STSignedTwipsMeasure)get_store().find_attribute_user(POS$4);
      if (sTSignedTwipsMeasure == null)
        sTSignedTwipsMeasure = (STSignedTwipsMeasure)get_store().add_attribute_user(POS$4); 
      sTSignedTwipsMeasure.set((XmlObject)paramSTSignedTwipsMeasure);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTTabStopImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */