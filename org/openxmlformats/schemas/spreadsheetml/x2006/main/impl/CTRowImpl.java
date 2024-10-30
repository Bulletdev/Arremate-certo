package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedByte;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRow;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STCellSpans;

public class CTRowImpl extends XmlComplexContentImpl implements CTRow {
  private static final b C$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "c");
  
  private static final b EXTLST$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  private static final b R$4 = new b("", "r");
  
  private static final b SPANS$6 = new b("", "spans");
  
  private static final b S$8 = new b("", "s");
  
  private static final b CUSTOMFORMAT$10 = new b("", "customFormat");
  
  private static final b HT$12 = new b("", "ht");
  
  private static final b HIDDEN$14 = new b("", "hidden");
  
  private static final b CUSTOMHEIGHT$16 = new b("", "customHeight");
  
  private static final b OUTLINELEVEL$18 = new b("", "outlineLevel");
  
  private static final b COLLAPSED$20 = new b("", "collapsed");
  
  private static final b THICKTOP$22 = new b("", "thickTop");
  
  private static final b THICKBOT$24 = new b("", "thickBot");
  
  private static final b PH$26 = new b("", "ph");
  
  public CTRowImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CTCell> getCList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTCell>)new CList(this);
    } 
  }
  
  public CTCell[] getCArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(C$0, arrayList);
      CTCell[] arrayOfCTCell = new CTCell[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTCell);
      return arrayOfCTCell;
    } 
  }
  
  public CTCell getCArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCell cTCell = null;
      cTCell = (CTCell)get_store().find_element_user(C$0, paramInt);
      if (cTCell == null)
        throw new IndexOutOfBoundsException(); 
      return cTCell;
    } 
  }
  
  public int sizeOfCArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(C$0);
    } 
  }
  
  public void setCArray(CTCell[] paramArrayOfCTCell) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTCell, C$0);
    } 
  }
  
  public void setCArray(int paramInt, CTCell paramCTCell) {
    synchronized (monitor()) {
      check_orphaned();
      CTCell cTCell = null;
      cTCell = (CTCell)get_store().find_element_user(C$0, paramInt);
      if (cTCell == null)
        throw new IndexOutOfBoundsException(); 
      cTCell.set((XmlObject)paramCTCell);
    } 
  }
  
  public CTCell insertNewC(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTCell cTCell = null;
      cTCell = (CTCell)get_store().insert_element_user(C$0, paramInt);
      return cTCell;
    } 
  }
  
  public CTCell addNewC() {
    synchronized (monitor()) {
      check_orphaned();
      CTCell cTCell = null;
      cTCell = (CTCell)get_store().add_element_user(C$0);
      return cTCell;
    } 
  }
  
  public void removeC(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(C$0, paramInt);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$2, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$2) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$2, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$2); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$2);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$2, 0);
    } 
  }
  
  public long getR() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(R$4);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetR() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(R$4);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetR() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(R$4) != null);
    } 
  }
  
  public void setR(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(R$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(R$4); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetR(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(R$4);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(R$4); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetR() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(R$4);
    } 
  }
  
  public List getSpans() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SPANS$6);
      if (simpleValue == null)
        return null; 
      return simpleValue.getListValue();
    } 
  }
  
  public STCellSpans xgetSpans() {
    synchronized (monitor()) {
      check_orphaned();
      STCellSpans sTCellSpans = null;
      sTCellSpans = (STCellSpans)get_store().find_attribute_user(SPANS$6);
      return sTCellSpans;
    } 
  }
  
  public boolean isSetSpans() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SPANS$6) != null);
    } 
  }
  
  public void setSpans(List paramList) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SPANS$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SPANS$6); 
      simpleValue.setListValue(paramList);
    } 
  }
  
  public void xsetSpans(STCellSpans paramSTCellSpans) {
    synchronized (monitor()) {
      check_orphaned();
      STCellSpans sTCellSpans = null;
      sTCellSpans = (STCellSpans)get_store().find_attribute_user(SPANS$6);
      if (sTCellSpans == null)
        sTCellSpans = (STCellSpans)get_store().add_attribute_user(SPANS$6); 
      sTCellSpans.set((XmlObject)paramSTCellSpans);
    } 
  }
  
  public void unsetSpans() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SPANS$6);
    } 
  }
  
  public long getS() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(S$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(S$8); 
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetS() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(S$8);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_default_attribute_value(S$8); 
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetS() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(S$8) != null);
    } 
  }
  
  public void setS(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(S$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(S$8); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetS(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(S$8);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(S$8); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetS() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(S$8);
    } 
  }
  
  public boolean getCustomFormat() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CUSTOMFORMAT$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(CUSTOMFORMAT$10); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetCustomFormat() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CUSTOMFORMAT$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(CUSTOMFORMAT$10); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetCustomFormat() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CUSTOMFORMAT$10) != null);
    } 
  }
  
  public void setCustomFormat(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CUSTOMFORMAT$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CUSTOMFORMAT$10); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetCustomFormat(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CUSTOMFORMAT$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(CUSTOMFORMAT$10); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetCustomFormat() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CUSTOMFORMAT$10);
    } 
  }
  
  public double getHt() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HT$12);
      if (simpleValue == null)
        return 0.0D; 
      return simpleValue.getDoubleValue();
    } 
  }
  
  public XmlDouble xgetHt() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(HT$12);
      return xmlDouble;
    } 
  }
  
  public boolean isSetHt() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HT$12) != null);
    } 
  }
  
  public void setHt(double paramDouble) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HT$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HT$12); 
      simpleValue.setDoubleValue(paramDouble);
    } 
  }
  
  public void xsetHt(XmlDouble paramXmlDouble) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(HT$12);
      if (xmlDouble == null)
        xmlDouble = (XmlDouble)get_store().add_attribute_user(HT$12); 
      xmlDouble.set((XmlObject)paramXmlDouble);
    } 
  }
  
  public void unsetHt() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HT$12);
    } 
  }
  
  public boolean getHidden() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HIDDEN$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(HIDDEN$14); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetHidden() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HIDDEN$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(HIDDEN$14); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetHidden() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HIDDEN$14) != null);
    } 
  }
  
  public void setHidden(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HIDDEN$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HIDDEN$14); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetHidden(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HIDDEN$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(HIDDEN$14); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetHidden() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HIDDEN$14);
    } 
  }
  
  public boolean getCustomHeight() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CUSTOMHEIGHT$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(CUSTOMHEIGHT$16); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetCustomHeight() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CUSTOMHEIGHT$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(CUSTOMHEIGHT$16); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetCustomHeight() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CUSTOMHEIGHT$16) != null);
    } 
  }
  
  public void setCustomHeight(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CUSTOMHEIGHT$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CUSTOMHEIGHT$16); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetCustomHeight(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CUSTOMHEIGHT$16);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(CUSTOMHEIGHT$16); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetCustomHeight() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CUSTOMHEIGHT$16);
    } 
  }
  
  public short getOutlineLevel() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OUTLINELEVEL$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(OUTLINELEVEL$18); 
      if (simpleValue == null)
        return 0; 
      return simpleValue.getShortValue();
    } 
  }
  
  public XmlUnsignedByte xgetOutlineLevel() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedByte xmlUnsignedByte = null;
      xmlUnsignedByte = (XmlUnsignedByte)get_store().find_attribute_user(OUTLINELEVEL$18);
      if (xmlUnsignedByte == null)
        xmlUnsignedByte = (XmlUnsignedByte)get_default_attribute_value(OUTLINELEVEL$18); 
      return xmlUnsignedByte;
    } 
  }
  
  public boolean isSetOutlineLevel() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(OUTLINELEVEL$18) != null);
    } 
  }
  
  public void setOutlineLevel(short paramShort) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(OUTLINELEVEL$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(OUTLINELEVEL$18); 
      simpleValue.setShortValue(paramShort);
    } 
  }
  
  public void xsetOutlineLevel(XmlUnsignedByte paramXmlUnsignedByte) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedByte xmlUnsignedByte = null;
      xmlUnsignedByte = (XmlUnsignedByte)get_store().find_attribute_user(OUTLINELEVEL$18);
      if (xmlUnsignedByte == null)
        xmlUnsignedByte = (XmlUnsignedByte)get_store().add_attribute_user(OUTLINELEVEL$18); 
      xmlUnsignedByte.set((XmlObject)paramXmlUnsignedByte);
    } 
  }
  
  public void unsetOutlineLevel() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(OUTLINELEVEL$18);
    } 
  }
  
  public boolean getCollapsed() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COLLAPSED$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(COLLAPSED$20); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetCollapsed() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(COLLAPSED$20);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(COLLAPSED$20); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetCollapsed() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(COLLAPSED$20) != null);
    } 
  }
  
  public void setCollapsed(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(COLLAPSED$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(COLLAPSED$20); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetCollapsed(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(COLLAPSED$20);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(COLLAPSED$20); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetCollapsed() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(COLLAPSED$20);
    } 
  }
  
  public boolean getThickTop() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(THICKTOP$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(THICKTOP$22); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetThickTop() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(THICKTOP$22);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(THICKTOP$22); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetThickTop() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(THICKTOP$22) != null);
    } 
  }
  
  public void setThickTop(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(THICKTOP$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(THICKTOP$22); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetThickTop(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(THICKTOP$22);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(THICKTOP$22); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetThickTop() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(THICKTOP$22);
    } 
  }
  
  public boolean getThickBot() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(THICKBOT$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(THICKBOT$24); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetThickBot() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(THICKBOT$24);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(THICKBOT$24); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetThickBot() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(THICKBOT$24) != null);
    } 
  }
  
  public void setThickBot(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(THICKBOT$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(THICKBOT$24); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetThickBot(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(THICKBOT$24);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(THICKBOT$24); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetThickBot() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(THICKBOT$24);
    } 
  }
  
  public boolean getPh() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PH$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(PH$26); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetPh() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PH$26);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(PH$26); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetPh() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PH$26) != null);
    } 
  }
  
  public void setPh(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PH$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PH$26); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetPh(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PH$26);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(PH$26); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetPh() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PH$26);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTRowImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */