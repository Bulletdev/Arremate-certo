package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.PageSheetType;
import com.microsoft.schemas.office.visio.x2012.main.PageType;
import com.microsoft.schemas.office.visio.x2012.main.RelType;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class PageTypeImpl extends XmlComplexContentImpl implements PageType {
  private static final b PAGESHEET$0 = new b("http://schemas.microsoft.com/office/visio/2012/main", "PageSheet");
  
  private static final b REL$2 = new b("http://schemas.microsoft.com/office/visio/2012/main", "Rel");
  
  private static final b ID$4 = new b("", "ID");
  
  private static final b NAME$6 = new b("", "Name");
  
  private static final b NAMEU$8 = new b("", "NameU");
  
  private static final b ISCUSTOMNAME$10 = new b("", "IsCustomName");
  
  private static final b ISCUSTOMNAMEU$12 = new b("", "IsCustomNameU");
  
  private static final b BACKGROUND$14 = new b("", "Background");
  
  private static final b BACKPAGE$16 = new b("", "BackPage");
  
  private static final b VIEWSCALE$18 = new b("", "ViewScale");
  
  private static final b VIEWCENTERX$20 = new b("", "ViewCenterX");
  
  private static final b VIEWCENTERY$22 = new b("", "ViewCenterY");
  
  private static final b REVIEWERID$24 = new b("", "ReviewerID");
  
  private static final b ASSOCIATEDPAGE$26 = new b("", "AssociatedPage");
  
  public PageTypeImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public PageSheetType getPageSheet() {
    synchronized (monitor()) {
      check_orphaned();
      PageSheetType pageSheetType = null;
      pageSheetType = (PageSheetType)get_store().find_element_user(PAGESHEET$0, 0);
      if (pageSheetType == null)
        return null; 
      return pageSheetType;
    } 
  }
  
  public boolean isSetPageSheet() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PAGESHEET$0) != 0);
    } 
  }
  
  public void setPageSheet(PageSheetType paramPageSheetType) {
    synchronized (monitor()) {
      check_orphaned();
      PageSheetType pageSheetType = null;
      pageSheetType = (PageSheetType)get_store().find_element_user(PAGESHEET$0, 0);
      if (pageSheetType == null)
        pageSheetType = (PageSheetType)get_store().add_element_user(PAGESHEET$0); 
      pageSheetType.set((XmlObject)paramPageSheetType);
    } 
  }
  
  public PageSheetType addNewPageSheet() {
    synchronized (monitor()) {
      check_orphaned();
      PageSheetType pageSheetType = null;
      pageSheetType = (PageSheetType)get_store().add_element_user(PAGESHEET$0);
      return pageSheetType;
    } 
  }
  
  public void unsetPageSheet() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PAGESHEET$0, 0);
    } 
  }
  
  public RelType getRel() {
    synchronized (monitor()) {
      check_orphaned();
      RelType relType = null;
      relType = (RelType)get_store().find_element_user(REL$2, 0);
      if (relType == null)
        return null; 
      return relType;
    } 
  }
  
  public void setRel(RelType paramRelType) {
    synchronized (monitor()) {
      check_orphaned();
      RelType relType = null;
      relType = (RelType)get_store().find_element_user(REL$2, 0);
      if (relType == null)
        relType = (RelType)get_store().add_element_user(REL$2); 
      relType.set((XmlObject)paramRelType);
    } 
  }
  
  public RelType addNewRel() {
    synchronized (monitor()) {
      check_orphaned();
      RelType relType = null;
      relType = (RelType)get_store().add_element_user(REL$2);
      return relType;
    } 
  }
  
  public long getID() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$4);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetID() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ID$4);
      return xmlUnsignedInt;
    } 
  }
  
  public void setID(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$4); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetID(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ID$4);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(ID$4); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public String getName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$6);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetName() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAME$6);
      return xmlString;
    } 
  }
  
  public boolean isSetName() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NAME$6) != null);
    } 
  }
  
  public void setName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$6); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetName(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAME$6);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(NAME$6); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetName() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NAME$6);
    } 
  }
  
  public String getNameU() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAMEU$8);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetNameU() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAMEU$8);
      return xmlString;
    } 
  }
  
  public boolean isSetNameU() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NAMEU$8) != null);
    } 
  }
  
  public void setNameU(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAMEU$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NAMEU$8); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetNameU(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAMEU$8);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(NAMEU$8); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetNameU() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NAMEU$8);
    } 
  }
  
  public boolean getIsCustomName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ISCUSTOMNAME$10);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetIsCustomName() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ISCUSTOMNAME$10);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetIsCustomName() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ISCUSTOMNAME$10) != null);
    } 
  }
  
  public void setIsCustomName(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ISCUSTOMNAME$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ISCUSTOMNAME$10); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetIsCustomName(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ISCUSTOMNAME$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ISCUSTOMNAME$10); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetIsCustomName() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ISCUSTOMNAME$10);
    } 
  }
  
  public boolean getIsCustomNameU() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ISCUSTOMNAMEU$12);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetIsCustomNameU() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ISCUSTOMNAMEU$12);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetIsCustomNameU() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ISCUSTOMNAMEU$12) != null);
    } 
  }
  
  public void setIsCustomNameU(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ISCUSTOMNAMEU$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ISCUSTOMNAMEU$12); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetIsCustomNameU(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ISCUSTOMNAMEU$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ISCUSTOMNAMEU$12); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetIsCustomNameU() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ISCUSTOMNAMEU$12);
    } 
  }
  
  public boolean getBackground() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BACKGROUND$14);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetBackground() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(BACKGROUND$14);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetBackground() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BACKGROUND$14) != null);
    } 
  }
  
  public void setBackground(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BACKGROUND$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BACKGROUND$14); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetBackground(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(BACKGROUND$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(BACKGROUND$14); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetBackground() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BACKGROUND$14);
    } 
  }
  
  public long getBackPage() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BACKPAGE$16);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetBackPage() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(BACKPAGE$16);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetBackPage() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BACKPAGE$16) != null);
    } 
  }
  
  public void setBackPage(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BACKPAGE$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BACKPAGE$16); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetBackPage(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(BACKPAGE$16);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(BACKPAGE$16); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetBackPage() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BACKPAGE$16);
    } 
  }
  
  public double getViewScale() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VIEWSCALE$18);
      if (simpleValue == null)
        return 0.0D; 
      return simpleValue.getDoubleValue();
    } 
  }
  
  public XmlDouble xgetViewScale() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(VIEWSCALE$18);
      return xmlDouble;
    } 
  }
  
  public boolean isSetViewScale() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VIEWSCALE$18) != null);
    } 
  }
  
  public void setViewScale(double paramDouble) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VIEWSCALE$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VIEWSCALE$18); 
      simpleValue.setDoubleValue(paramDouble);
    } 
  }
  
  public void xsetViewScale(XmlDouble paramXmlDouble) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(VIEWSCALE$18);
      if (xmlDouble == null)
        xmlDouble = (XmlDouble)get_store().add_attribute_user(VIEWSCALE$18); 
      xmlDouble.set((XmlObject)paramXmlDouble);
    } 
  }
  
  public void unsetViewScale() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VIEWSCALE$18);
    } 
  }
  
  public double getViewCenterX() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VIEWCENTERX$20);
      if (simpleValue == null)
        return 0.0D; 
      return simpleValue.getDoubleValue();
    } 
  }
  
  public XmlDouble xgetViewCenterX() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(VIEWCENTERX$20);
      return xmlDouble;
    } 
  }
  
  public boolean isSetViewCenterX() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VIEWCENTERX$20) != null);
    } 
  }
  
  public void setViewCenterX(double paramDouble) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VIEWCENTERX$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VIEWCENTERX$20); 
      simpleValue.setDoubleValue(paramDouble);
    } 
  }
  
  public void xsetViewCenterX(XmlDouble paramXmlDouble) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(VIEWCENTERX$20);
      if (xmlDouble == null)
        xmlDouble = (XmlDouble)get_store().add_attribute_user(VIEWCENTERX$20); 
      xmlDouble.set((XmlObject)paramXmlDouble);
    } 
  }
  
  public void unsetViewCenterX() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VIEWCENTERX$20);
    } 
  }
  
  public double getViewCenterY() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VIEWCENTERY$22);
      if (simpleValue == null)
        return 0.0D; 
      return simpleValue.getDoubleValue();
    } 
  }
  
  public XmlDouble xgetViewCenterY() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(VIEWCENTERY$22);
      return xmlDouble;
    } 
  }
  
  public boolean isSetViewCenterY() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(VIEWCENTERY$22) != null);
    } 
  }
  
  public void setViewCenterY(double paramDouble) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(VIEWCENTERY$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(VIEWCENTERY$22); 
      simpleValue.setDoubleValue(paramDouble);
    } 
  }
  
  public void xsetViewCenterY(XmlDouble paramXmlDouble) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDouble xmlDouble = null;
      xmlDouble = (XmlDouble)get_store().find_attribute_user(VIEWCENTERY$22);
      if (xmlDouble == null)
        xmlDouble = (XmlDouble)get_store().add_attribute_user(VIEWCENTERY$22); 
      xmlDouble.set((XmlObject)paramXmlDouble);
    } 
  }
  
  public void unsetViewCenterY() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(VIEWCENTERY$22);
    } 
  }
  
  public long getReviewerID() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REVIEWERID$24);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetReviewerID() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(REVIEWERID$24);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetReviewerID() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(REVIEWERID$24) != null);
    } 
  }
  
  public void setReviewerID(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REVIEWERID$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(REVIEWERID$24); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetReviewerID(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(REVIEWERID$24);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(REVIEWERID$24); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetReviewerID() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(REVIEWERID$24);
    } 
  }
  
  public long getAssociatedPage() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ASSOCIATEDPAGE$26);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetAssociatedPage() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ASSOCIATEDPAGE$26);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetAssociatedPage() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ASSOCIATEDPAGE$26) != null);
    } 
  }
  
  public void setAssociatedPage(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ASSOCIATEDPAGE$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ASSOCIATEDPAGE$26); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetAssociatedPage(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ASSOCIATEDPAGE$26);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(ASSOCIATEDPAGE$26); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetAssociatedPage() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ASSOCIATEDPAGE$26);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\impl\PageTypeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */