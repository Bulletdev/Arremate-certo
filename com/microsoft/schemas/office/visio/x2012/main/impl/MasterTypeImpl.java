package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.IconType;
import com.microsoft.schemas.office.visio.x2012.main.MasterType;
import com.microsoft.schemas.office.visio.x2012.main.PageSheetType;
import com.microsoft.schemas.office.visio.x2012.main.RelType;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.XmlUnsignedShort;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class MasterTypeImpl extends XmlComplexContentImpl implements MasterType {
  private static final b PAGESHEET$0 = new b("http://schemas.microsoft.com/office/visio/2012/main", "PageSheet");
  
  private static final b REL$2 = new b("http://schemas.microsoft.com/office/visio/2012/main", "Rel");
  
  private static final b ICON$4 = new b("http://schemas.microsoft.com/office/visio/2012/main", "Icon");
  
  private static final b ID$6 = new b("", "ID");
  
  private static final b BASEID$8 = new b("", "BaseID");
  
  private static final b UNIQUEID$10 = new b("", "UniqueID");
  
  private static final b MATCHBYNAME$12 = new b("", "MatchByName");
  
  private static final b NAME$14 = new b("", "Name");
  
  private static final b NAMEU$16 = new b("", "NameU");
  
  private static final b ISCUSTOMNAME$18 = new b("", "IsCustomName");
  
  private static final b ISCUSTOMNAMEU$20 = new b("", "IsCustomNameU");
  
  private static final b ICONSIZE$22 = new b("", "IconSize");
  
  private static final b PATTERNFLAGS$24 = new b("", "PatternFlags");
  
  private static final b PROMPT$26 = new b("", "Prompt");
  
  private static final b HIDDEN$28 = new b("", "Hidden");
  
  private static final b ICONUPDATE$30 = new b("", "IconUpdate");
  
  private static final b ALIGNNAME$32 = new b("", "AlignName");
  
  private static final b MASTERTYPE$34 = new b("", "MasterType");
  
  public MasterTypeImpl(SchemaType paramSchemaType) {
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
  
  public IconType getIcon() {
    synchronized (monitor()) {
      check_orphaned();
      IconType iconType = null;
      iconType = (IconType)get_store().find_element_user(ICON$4, 0);
      if (iconType == null)
        return null; 
      return iconType;
    } 
  }
  
  public boolean isSetIcon() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ICON$4) != 0);
    } 
  }
  
  public void setIcon(IconType paramIconType) {
    synchronized (monitor()) {
      check_orphaned();
      IconType iconType = null;
      iconType = (IconType)get_store().find_element_user(ICON$4, 0);
      if (iconType == null)
        iconType = (IconType)get_store().add_element_user(ICON$4); 
      iconType.set((XmlObject)paramIconType);
    } 
  }
  
  public IconType addNewIcon() {
    synchronized (monitor()) {
      check_orphaned();
      IconType iconType = null;
      iconType = (IconType)get_store().add_element_user(ICON$4);
      return iconType;
    } 
  }
  
  public void unsetIcon() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ICON$4, 0);
    } 
  }
  
  public long getID() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$6);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetID() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ID$6);
      return xmlUnsignedInt;
    } 
  }
  
  public void setID(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$6); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetID(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(ID$6);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(ID$6); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public String getBaseID() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BASEID$8);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetBaseID() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(BASEID$8);
      return xmlString;
    } 
  }
  
  public boolean isSetBaseID() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BASEID$8) != null);
    } 
  }
  
  public void setBaseID(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BASEID$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BASEID$8); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetBaseID(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(BASEID$8);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(BASEID$8); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetBaseID() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BASEID$8);
    } 
  }
  
  public String getUniqueID() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UNIQUEID$10);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetUniqueID() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(UNIQUEID$10);
      return xmlString;
    } 
  }
  
  public boolean isSetUniqueID() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(UNIQUEID$10) != null);
    } 
  }
  
  public void setUniqueID(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UNIQUEID$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(UNIQUEID$10); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetUniqueID(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(UNIQUEID$10);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(UNIQUEID$10); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetUniqueID() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(UNIQUEID$10);
    } 
  }
  
  public boolean getMatchByName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MATCHBYNAME$12);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetMatchByName() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(MATCHBYNAME$12);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetMatchByName() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MATCHBYNAME$12) != null);
    } 
  }
  
  public void setMatchByName(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MATCHBYNAME$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MATCHBYNAME$12); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetMatchByName(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(MATCHBYNAME$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(MATCHBYNAME$12); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetMatchByName() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MATCHBYNAME$12);
    } 
  }
  
  public String getName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$14);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetName() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAME$14);
      return xmlString;
    } 
  }
  
  public boolean isSetName() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NAME$14) != null);
    } 
  }
  
  public void setName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$14); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetName(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAME$14);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(NAME$14); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetName() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NAME$14);
    } 
  }
  
  public String getNameU() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAMEU$16);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetNameU() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAMEU$16);
      return xmlString;
    } 
  }
  
  public boolean isSetNameU() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(NAMEU$16) != null);
    } 
  }
  
  public void setNameU(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(NAMEU$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(NAMEU$16); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetNameU(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(NAMEU$16);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(NAMEU$16); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetNameU() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(NAMEU$16);
    } 
  }
  
  public boolean getIsCustomName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ISCUSTOMNAME$18);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetIsCustomName() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ISCUSTOMNAME$18);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetIsCustomName() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ISCUSTOMNAME$18) != null);
    } 
  }
  
  public void setIsCustomName(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ISCUSTOMNAME$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ISCUSTOMNAME$18); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetIsCustomName(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ISCUSTOMNAME$18);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ISCUSTOMNAME$18); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetIsCustomName() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ISCUSTOMNAME$18);
    } 
  }
  
  public boolean getIsCustomNameU() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ISCUSTOMNAMEU$20);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetIsCustomNameU() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ISCUSTOMNAMEU$20);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetIsCustomNameU() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ISCUSTOMNAMEU$20) != null);
    } 
  }
  
  public void setIsCustomNameU(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ISCUSTOMNAMEU$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ISCUSTOMNAMEU$20); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetIsCustomNameU(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ISCUSTOMNAMEU$20);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ISCUSTOMNAMEU$20); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetIsCustomNameU() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ISCUSTOMNAMEU$20);
    } 
  }
  
  public int getIconSize() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ICONSIZE$22);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlUnsignedShort xgetIconSize() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedShort xmlUnsignedShort = null;
      xmlUnsignedShort = (XmlUnsignedShort)get_store().find_attribute_user(ICONSIZE$22);
      return xmlUnsignedShort;
    } 
  }
  
  public boolean isSetIconSize() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ICONSIZE$22) != null);
    } 
  }
  
  public void setIconSize(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ICONSIZE$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ICONSIZE$22); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetIconSize(XmlUnsignedShort paramXmlUnsignedShort) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedShort xmlUnsignedShort = null;
      xmlUnsignedShort = (XmlUnsignedShort)get_store().find_attribute_user(ICONSIZE$22);
      if (xmlUnsignedShort == null)
        xmlUnsignedShort = (XmlUnsignedShort)get_store().add_attribute_user(ICONSIZE$22); 
      xmlUnsignedShort.set((XmlObject)paramXmlUnsignedShort);
    } 
  }
  
  public void unsetIconSize() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ICONSIZE$22);
    } 
  }
  
  public int getPatternFlags() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PATTERNFLAGS$24);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlUnsignedShort xgetPatternFlags() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedShort xmlUnsignedShort = null;
      xmlUnsignedShort = (XmlUnsignedShort)get_store().find_attribute_user(PATTERNFLAGS$24);
      return xmlUnsignedShort;
    } 
  }
  
  public boolean isSetPatternFlags() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PATTERNFLAGS$24) != null);
    } 
  }
  
  public void setPatternFlags(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PATTERNFLAGS$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PATTERNFLAGS$24); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetPatternFlags(XmlUnsignedShort paramXmlUnsignedShort) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedShort xmlUnsignedShort = null;
      xmlUnsignedShort = (XmlUnsignedShort)get_store().find_attribute_user(PATTERNFLAGS$24);
      if (xmlUnsignedShort == null)
        xmlUnsignedShort = (XmlUnsignedShort)get_store().add_attribute_user(PATTERNFLAGS$24); 
      xmlUnsignedShort.set((XmlObject)paramXmlUnsignedShort);
    } 
  }
  
  public void unsetPatternFlags() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PATTERNFLAGS$24);
    } 
  }
  
  public String getPrompt() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PROMPT$26);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetPrompt() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(PROMPT$26);
      return xmlString;
    } 
  }
  
  public boolean isSetPrompt() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PROMPT$26) != null);
    } 
  }
  
  public void setPrompt(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PROMPT$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PROMPT$26); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetPrompt(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(PROMPT$26);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(PROMPT$26); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetPrompt() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PROMPT$26);
    } 
  }
  
  public boolean getHidden() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HIDDEN$28);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetHidden() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HIDDEN$28);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetHidden() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HIDDEN$28) != null);
    } 
  }
  
  public void setHidden(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HIDDEN$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HIDDEN$28); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetHidden(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HIDDEN$28);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(HIDDEN$28); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetHidden() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HIDDEN$28);
    } 
  }
  
  public boolean getIconUpdate() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ICONUPDATE$30);
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetIconUpdate() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ICONUPDATE$30);
      return xmlBoolean;
    } 
  }
  
  public boolean isSetIconUpdate() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ICONUPDATE$30) != null);
    } 
  }
  
  public void setIconUpdate(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ICONUPDATE$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ICONUPDATE$30); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetIconUpdate(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ICONUPDATE$30);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ICONUPDATE$30); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetIconUpdate() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ICONUPDATE$30);
    } 
  }
  
  public int getAlignName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALIGNNAME$32);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlUnsignedShort xgetAlignName() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedShort xmlUnsignedShort = null;
      xmlUnsignedShort = (XmlUnsignedShort)get_store().find_attribute_user(ALIGNNAME$32);
      return xmlUnsignedShort;
    } 
  }
  
  public boolean isSetAlignName() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ALIGNNAME$32) != null);
    } 
  }
  
  public void setAlignName(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALIGNNAME$32);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ALIGNNAME$32); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetAlignName(XmlUnsignedShort paramXmlUnsignedShort) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedShort xmlUnsignedShort = null;
      xmlUnsignedShort = (XmlUnsignedShort)get_store().find_attribute_user(ALIGNNAME$32);
      if (xmlUnsignedShort == null)
        xmlUnsignedShort = (XmlUnsignedShort)get_store().add_attribute_user(ALIGNNAME$32); 
      xmlUnsignedShort.set((XmlObject)paramXmlUnsignedShort);
    } 
  }
  
  public void unsetAlignName() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ALIGNNAME$32);
    } 
  }
  
  public int getMasterType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MASTERTYPE$34);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlUnsignedShort xgetMasterType() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedShort xmlUnsignedShort = null;
      xmlUnsignedShort = (XmlUnsignedShort)get_store().find_attribute_user(MASTERTYPE$34);
      return xmlUnsignedShort;
    } 
  }
  
  public boolean isSetMasterType() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(MASTERTYPE$34) != null);
    } 
  }
  
  public void setMasterType(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(MASTERTYPE$34);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(MASTERTYPE$34); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetMasterType(XmlUnsignedShort paramXmlUnsignedShort) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedShort xmlUnsignedShort = null;
      xmlUnsignedShort = (XmlUnsignedShort)get_store().find_attribute_user(MASTERTYPE$34);
      if (xmlUnsignedShort == null)
        xmlUnsignedShort = (XmlUnsignedShort)get_store().add_attribute_user(MASTERTYPE$34); 
      xmlUnsignedShort.set((XmlObject)paramXmlUnsignedShort);
    } 
  }
  
  public void unsetMasterType() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(MASTERTYPE$34);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\impl\MasterTypeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */