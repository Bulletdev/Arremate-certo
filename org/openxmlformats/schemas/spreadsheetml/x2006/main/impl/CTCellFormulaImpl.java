package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.JavaStringHolderEx;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellFormula;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellFormulaType;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellRef;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STRef;

public class CTCellFormulaImpl extends JavaStringHolderEx implements CTCellFormula {
  private static final b T$0 = new b("", "t");
  
  private static final b ACA$2 = new b("", "aca");
  
  private static final b REF$4 = new b("", "ref");
  
  private static final b DT2D$6 = new b("", "dt2D");
  
  private static final b DTR$8 = new b("", "dtr");
  
  private static final b DEL1$10 = new b("", "del1");
  
  private static final b DEL2$12 = new b("", "del2");
  
  private static final b R1$14 = new b("", "r1");
  
  private static final b R2$16 = new b("", "r2");
  
  private static final b CA$18 = new b("", "ca");
  
  private static final b SI$20 = new b("", "si");
  
  private static final b BX$22 = new b("", "bx");
  
  public CTCellFormulaImpl(SchemaType paramSchemaType) {
    super(paramSchemaType, true);
  }
  
  protected CTCellFormulaImpl(SchemaType paramSchemaType, boolean paramBoolean) {
    super(paramSchemaType, paramBoolean);
  }
  
  public STCellFormulaType.Enum getT() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(T$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(T$0); 
      if (simpleValue == null)
        return null; 
      return (STCellFormulaType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STCellFormulaType xgetT() {
    synchronized (monitor()) {
      check_orphaned();
      STCellFormulaType sTCellFormulaType = null;
      sTCellFormulaType = (STCellFormulaType)get_store().find_attribute_user(T$0);
      if (sTCellFormulaType == null)
        sTCellFormulaType = (STCellFormulaType)get_default_attribute_value(T$0); 
      return sTCellFormulaType;
    } 
  }
  
  public boolean isSetT() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(T$0) != null);
    } 
  }
  
  public void setT(STCellFormulaType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(T$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(T$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetT(STCellFormulaType paramSTCellFormulaType) {
    synchronized (monitor()) {
      check_orphaned();
      STCellFormulaType sTCellFormulaType = null;
      sTCellFormulaType = (STCellFormulaType)get_store().find_attribute_user(T$0);
      if (sTCellFormulaType == null)
        sTCellFormulaType = (STCellFormulaType)get_store().add_attribute_user(T$0); 
      sTCellFormulaType.set((XmlObject)paramSTCellFormulaType);
    } 
  }
  
  public void unsetT() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(T$0);
    } 
  }
  
  public boolean getAca() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ACA$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ACA$2); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetAca() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ACA$2);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(ACA$2); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetAca() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ACA$2) != null);
    } 
  }
  
  public void setAca(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ACA$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ACA$2); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetAca(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ACA$2);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ACA$2); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetAca() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ACA$2);
    } 
  }
  
  public String getRef() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REF$4);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STRef xgetRef() {
    synchronized (monitor()) {
      check_orphaned();
      STRef sTRef = null;
      sTRef = (STRef)get_store().find_attribute_user(REF$4);
      return sTRef;
    } 
  }
  
  public boolean isSetRef() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(REF$4) != null);
    } 
  }
  
  public void setRef(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REF$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(REF$4); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetRef(STRef paramSTRef) {
    synchronized (monitor()) {
      check_orphaned();
      STRef sTRef = null;
      sTRef = (STRef)get_store().find_attribute_user(REF$4);
      if (sTRef == null)
        sTRef = (STRef)get_store().add_attribute_user(REF$4); 
      sTRef.set((XmlObject)paramSTRef);
    } 
  }
  
  public void unsetRef() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(REF$4);
    } 
  }
  
  public boolean getDt2D() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DT2D$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(DT2D$6); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDt2D() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DT2D$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(DT2D$6); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDt2D() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DT2D$6) != null);
    } 
  }
  
  public void setDt2D(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DT2D$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DT2D$6); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDt2D(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DT2D$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DT2D$6); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDt2D() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DT2D$6);
    } 
  }
  
  public boolean getDtr() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DTR$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(DTR$8); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDtr() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DTR$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(DTR$8); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDtr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DTR$8) != null);
    } 
  }
  
  public void setDtr(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DTR$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DTR$8); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDtr(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DTR$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DTR$8); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDtr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DTR$8);
    } 
  }
  
  public boolean getDel1() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEL1$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(DEL1$10); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDel1() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DEL1$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(DEL1$10); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDel1() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DEL1$10) != null);
    } 
  }
  
  public void setDel1(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEL1$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DEL1$10); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDel1(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DEL1$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DEL1$10); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDel1() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DEL1$10);
    } 
  }
  
  public boolean getDel2() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEL2$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(DEL2$12); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDel2() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DEL2$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(DEL2$12); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDel2() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DEL2$12) != null);
    } 
  }
  
  public void setDel2(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEL2$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DEL2$12); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDel2(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DEL2$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DEL2$12); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDel2() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DEL2$12);
    } 
  }
  
  public String getR1() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(R1$14);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STCellRef xgetR1() {
    synchronized (monitor()) {
      check_orphaned();
      STCellRef sTCellRef = null;
      sTCellRef = (STCellRef)get_store().find_attribute_user(R1$14);
      return sTCellRef;
    } 
  }
  
  public boolean isSetR1() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(R1$14) != null);
    } 
  }
  
  public void setR1(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(R1$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(R1$14); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetR1(STCellRef paramSTCellRef) {
    synchronized (monitor()) {
      check_orphaned();
      STCellRef sTCellRef = null;
      sTCellRef = (STCellRef)get_store().find_attribute_user(R1$14);
      if (sTCellRef == null)
        sTCellRef = (STCellRef)get_store().add_attribute_user(R1$14); 
      sTCellRef.set((XmlObject)paramSTCellRef);
    } 
  }
  
  public void unsetR1() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(R1$14);
    } 
  }
  
  public String getR2() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(R2$16);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STCellRef xgetR2() {
    synchronized (monitor()) {
      check_orphaned();
      STCellRef sTCellRef = null;
      sTCellRef = (STCellRef)get_store().find_attribute_user(R2$16);
      return sTCellRef;
    } 
  }
  
  public boolean isSetR2() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(R2$16) != null);
    } 
  }
  
  public void setR2(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(R2$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(R2$16); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetR2(STCellRef paramSTCellRef) {
    synchronized (monitor()) {
      check_orphaned();
      STCellRef sTCellRef = null;
      sTCellRef = (STCellRef)get_store().find_attribute_user(R2$16);
      if (sTCellRef == null)
        sTCellRef = (STCellRef)get_store().add_attribute_user(R2$16); 
      sTCellRef.set((XmlObject)paramSTCellRef);
    } 
  }
  
  public void unsetR2() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(R2$16);
    } 
  }
  
  public boolean getCa() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CA$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(CA$18); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetCa() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CA$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(CA$18); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetCa() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CA$18) != null);
    } 
  }
  
  public void setCa(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CA$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CA$18); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetCa(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CA$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(CA$18); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetCa() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CA$18);
    } 
  }
  
  public long getSi() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SI$20);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetSi() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(SI$20);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetSi() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SI$20) != null);
    } 
  }
  
  public void setSi(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SI$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SI$20); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetSi(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(SI$20);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(SI$20); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetSi() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SI$20);
    } 
  }
  
  public boolean getBx() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BX$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(BX$22); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetBx() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(BX$22);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(BX$22); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetBx() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BX$22) != null);
    } 
  }
  
  public void setBx(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BX$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BX$22); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetBx(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(BX$22);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(BX$22); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetBx() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BX$22);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTCellFormulaImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */