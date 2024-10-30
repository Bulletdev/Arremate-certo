package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCellAlignment;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STHorizontalAlignment;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STVerticalAlignment;

public class CTCellAlignmentImpl extends XmlComplexContentImpl implements CTCellAlignment {
  private static final b HORIZONTAL$0 = new b("", "horizontal");
  
  private static final b VERTICAL$2 = new b("", "vertical");
  
  private static final b TEXTROTATION$4 = new b("", "textRotation");
  
  private static final b WRAPTEXT$6 = new b("", "wrapText");
  
  private static final b INDENT$8 = new b("", "indent");
  
  private static final b RELATIVEINDENT$10 = new b("", "relativeIndent");
  
  private static final b JUSTIFYLASTLINE$12 = new b("", "justifyLastLine");
  
  private static final b SHRINKTOFIT$14 = new b("", "shrinkToFit");
  
  private static final b READINGORDER$16 = new b("", "readingOrder");
  
  public CTCellAlignmentImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public STHorizontalAlignment.Enum getHorizontal() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HORIZONTAL$0);
      if (simpleValue == null)
        return null; 
      return (STHorizontalAlignment.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STHorizontalAlignment xgetHorizontal() {
    synchronized (monitor()) {
      check_orphaned();
      STHorizontalAlignment sTHorizontalAlignment = null;
      sTHorizontalAlignment = (STHorizontalAlignment)get_store().find_attribute_user(HORIZONTAL$0);
      return sTHorizontalAlignment;
    } 
  }
  
  public boolean isSetHorizontal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HORIZONTAL$0) != null);
    } 
  }
  
  public void setHorizontal(STHorizontalAlignment.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HORIZONTAL$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HORIZONTAL$0); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetHorizontal(STHorizontalAlignment paramSTHorizontalAlignment) {
    synchronized (monitor()) {
      check_orphaned();
      STHorizontalAlignment sTHorizontalAlignment = null;
      sTHorizontalAlignment = (STHorizontalAlignment)get_store().find_attribute_user(HORIZONTAL$0);
      if (sTHorizontalAlignment == null)
        sTHorizontalAlignment = (STHorizontalAlignment)get_store().add_attribute_user(HORIZONTAL$0); 
      sTHorizontalAlignment.set((XmlObject)paramSTHorizontalAlignment);
    } 
  }
  
  public void unsetHorizontal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HORIZONTAL$0);
    } 
  }
  
  public STVerticalAlignment.Enum getVertical() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VERTICAL$2);
      if (simpleValue == null)
        return null; 
      return (STVerticalAlignment.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STVerticalAlignment xgetVertical() {
    synchronized (monitor()) {
      check_orphaned();
      STVerticalAlignment sTVerticalAlignment = null;
      sTVerticalAlignment = (STVerticalAlignment)get_store().find_attribute_user(VERTICAL$2);
      return sTVerticalAlignment;
    } 
  }
  
  public boolean isSetVertical() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VERTICAL$2) != null);
    } 
  }
  
  public void setVertical(STVerticalAlignment.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VERTICAL$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VERTICAL$2); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetVertical(STVerticalAlignment paramSTVerticalAlignment) {
    synchronized (monitor()) {
      check_orphaned();
      STVerticalAlignment sTVerticalAlignment = null;
      sTVerticalAlignment = (STVerticalAlignment)get_store().find_attribute_user(VERTICAL$2);
      if (sTVerticalAlignment == null)
        sTVerticalAlignment = (STVerticalAlignment)get_store().add_attribute_user(VERTICAL$2); 
      sTVerticalAlignment.set((XmlObject)paramSTVerticalAlignment);
    } 
  }
  
  public void unsetVertical() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VERTICAL$2);
    } 
  }
  
  public long getTextRotation() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TEXTROTATION$4);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetTextRotation() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(TEXTROTATION$4);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetTextRotation() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TEXTROTATION$4) != null);
    } 
  }
  
  public void setTextRotation(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TEXTROTATION$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TEXTROTATION$4); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetTextRotation(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(TEXTROTATION$4);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(TEXTROTATION$4); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetTextRotation() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TEXTROTATION$4);
    } 
  }
  
  public boolean getWrapText() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(WRAPTEXT$6);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetWrapText() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(WRAPTEXT$6);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetWrapText() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(WRAPTEXT$6) != null);
    } 
  }
  
  public void setWrapText(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(WRAPTEXT$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(WRAPTEXT$6); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetWrapText(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(WRAPTEXT$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(WRAPTEXT$6); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetWrapText() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(WRAPTEXT$6);
    } 
  }
  
  public long getIndent() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INDENT$8);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetIndent() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(INDENT$8);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetIndent() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(INDENT$8) != null);
    } 
  }
  
  public void setIndent(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(INDENT$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(INDENT$8); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetIndent(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(INDENT$8);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(INDENT$8); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetIndent() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(INDENT$8);
    } 
  }
  
  public int getRelativeIndent() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RELATIVEINDENT$10);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlInt xgetRelativeIndent() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_attribute_user(RELATIVEINDENT$10);
      return xmlInt;
    } 
  }
  
  public boolean isSetRelativeIndent() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(RELATIVEINDENT$10) != null);
    } 
  }
  
  public void setRelativeIndent(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(RELATIVEINDENT$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(RELATIVEINDENT$10); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetRelativeIndent(XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_attribute_user(RELATIVEINDENT$10);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_store().add_attribute_user(RELATIVEINDENT$10); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
  
  public void unsetRelativeIndent() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(RELATIVEINDENT$10);
    } 
  }
  
  public boolean getJustifyLastLine() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(JUSTIFYLASTLINE$12);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetJustifyLastLine() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(JUSTIFYLASTLINE$12);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetJustifyLastLine() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(JUSTIFYLASTLINE$12) != null);
    } 
  }
  
  public void setJustifyLastLine(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(JUSTIFYLASTLINE$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(JUSTIFYLASTLINE$12); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetJustifyLastLine(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(JUSTIFYLASTLINE$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(JUSTIFYLASTLINE$12); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetJustifyLastLine() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(JUSTIFYLASTLINE$12);
    } 
  }
  
  public boolean getShrinkToFit() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHRINKTOFIT$14);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShrinkToFit() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHRINKTOFIT$14);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShrinkToFit() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHRINKTOFIT$14) != null);
    } 
  }
  
  public void setShrinkToFit(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHRINKTOFIT$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHRINKTOFIT$14); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShrinkToFit(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHRINKTOFIT$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHRINKTOFIT$14); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShrinkToFit() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHRINKTOFIT$14);
    } 
  }
  
  public long getReadingOrder() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(READINGORDER$16);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetReadingOrder() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(READINGORDER$16);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetReadingOrder() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(READINGORDER$16) != null);
    } 
  }
  
  public void setReadingOrder(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(READINGORDER$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(READINGORDER$16); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetReadingOrder(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(READINGORDER$16);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(READINGORDER$16); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetReadingOrder() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(READINGORDER$16);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTCellAlignmentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */