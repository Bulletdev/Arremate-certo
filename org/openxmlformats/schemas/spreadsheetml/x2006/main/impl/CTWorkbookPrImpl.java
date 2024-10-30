package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STObjects;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.STUpdateLinks;

public class CTWorkbookPrImpl extends XmlComplexContentImpl implements CTWorkbookPr {
  private static final b DATE1904$0 = new b("", "date1904");
  
  private static final b SHOWOBJECTS$2 = new b("", "showObjects");
  
  private static final b SHOWBORDERUNSELECTEDTABLES$4 = new b("", "showBorderUnselectedTables");
  
  private static final b FILTERPRIVACY$6 = new b("", "filterPrivacy");
  
  private static final b PROMPTEDSOLUTIONS$8 = new b("", "promptedSolutions");
  
  private static final b SHOWINKANNOTATION$10 = new b("", "showInkAnnotation");
  
  private static final b BACKUPFILE$12 = new b("", "backupFile");
  
  private static final b SAVEEXTERNALLINKVALUES$14 = new b("", "saveExternalLinkValues");
  
  private static final b UPDATELINKS$16 = new b("", "updateLinks");
  
  private static final b CODENAME$18 = new b("", "codeName");
  
  private static final b HIDEPIVOTFIELDLIST$20 = new b("", "hidePivotFieldList");
  
  private static final b SHOWPIVOTCHARTFILTER$22 = new b("", "showPivotChartFilter");
  
  private static final b ALLOWREFRESHQUERY$24 = new b("", "allowRefreshQuery");
  
  private static final b PUBLISHITEMS$26 = new b("", "publishItems");
  
  private static final b CHECKCOMPATIBILITY$28 = new b("", "checkCompatibility");
  
  private static final b AUTOCOMPRESSPICTURES$30 = new b("", "autoCompressPictures");
  
  private static final b REFRESHALLCONNECTIONS$32 = new b("", "refreshAllConnections");
  
  private static final b DEFAULTTHEMEVERSION$34 = new b("", "defaultThemeVersion");
  
  public CTWorkbookPrImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public boolean getDate1904() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DATE1904$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(DATE1904$0); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetDate1904() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DATE1904$0);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(DATE1904$0); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetDate1904() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DATE1904$0) != null);
    } 
  }
  
  public void setDate1904(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DATE1904$0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DATE1904$0); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetDate1904(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(DATE1904$0);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(DATE1904$0); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetDate1904() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DATE1904$0);
    } 
  }
  
  public STObjects.Enum getShowObjects() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWOBJECTS$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWOBJECTS$2); 
      if (simpleValue == null)
        return null; 
      return (STObjects.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STObjects xgetShowObjects() {
    synchronized (monitor()) {
      check_orphaned();
      STObjects sTObjects = null;
      sTObjects = (STObjects)get_store().find_attribute_user(SHOWOBJECTS$2);
      if (sTObjects == null)
        sTObjects = (STObjects)get_default_attribute_value(SHOWOBJECTS$2); 
      return sTObjects;
    } 
  }
  
  public boolean isSetShowObjects() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWOBJECTS$2) != null);
    } 
  }
  
  public void setShowObjects(STObjects.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWOBJECTS$2);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWOBJECTS$2); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetShowObjects(STObjects paramSTObjects) {
    synchronized (monitor()) {
      check_orphaned();
      STObjects sTObjects = null;
      sTObjects = (STObjects)get_store().find_attribute_user(SHOWOBJECTS$2);
      if (sTObjects == null)
        sTObjects = (STObjects)get_store().add_attribute_user(SHOWOBJECTS$2); 
      sTObjects.set((XmlObject)paramSTObjects);
    } 
  }
  
  public void unsetShowObjects() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWOBJECTS$2);
    } 
  }
  
  public boolean getShowBorderUnselectedTables() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWBORDERUNSELECTEDTABLES$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWBORDERUNSELECTEDTABLES$4); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowBorderUnselectedTables() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWBORDERUNSELECTEDTABLES$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWBORDERUNSELECTEDTABLES$4); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowBorderUnselectedTables() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWBORDERUNSELECTEDTABLES$4) != null);
    } 
  }
  
  public void setShowBorderUnselectedTables(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWBORDERUNSELECTEDTABLES$4);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWBORDERUNSELECTEDTABLES$4); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowBorderUnselectedTables(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWBORDERUNSELECTEDTABLES$4);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWBORDERUNSELECTEDTABLES$4); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowBorderUnselectedTables() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWBORDERUNSELECTEDTABLES$4);
    } 
  }
  
  public boolean getFilterPrivacy() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FILTERPRIVACY$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(FILTERPRIVACY$6); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetFilterPrivacy() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FILTERPRIVACY$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(FILTERPRIVACY$6); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetFilterPrivacy() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(FILTERPRIVACY$6) != null);
    } 
  }
  
  public void setFilterPrivacy(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(FILTERPRIVACY$6);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(FILTERPRIVACY$6); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetFilterPrivacy(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(FILTERPRIVACY$6);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(FILTERPRIVACY$6); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetFilterPrivacy() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(FILTERPRIVACY$6);
    } 
  }
  
  public boolean getPromptedSolutions() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PROMPTEDSOLUTIONS$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(PROMPTEDSOLUTIONS$8); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetPromptedSolutions() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PROMPTEDSOLUTIONS$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(PROMPTEDSOLUTIONS$8); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetPromptedSolutions() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PROMPTEDSOLUTIONS$8) != null);
    } 
  }
  
  public void setPromptedSolutions(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PROMPTEDSOLUTIONS$8);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PROMPTEDSOLUTIONS$8); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetPromptedSolutions(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PROMPTEDSOLUTIONS$8);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(PROMPTEDSOLUTIONS$8); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetPromptedSolutions() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PROMPTEDSOLUTIONS$8);
    } 
  }
  
  public boolean getShowInkAnnotation() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWINKANNOTATION$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWINKANNOTATION$10); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowInkAnnotation() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWINKANNOTATION$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWINKANNOTATION$10); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowInkAnnotation() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWINKANNOTATION$10) != null);
    } 
  }
  
  public void setShowInkAnnotation(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWINKANNOTATION$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWINKANNOTATION$10); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowInkAnnotation(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWINKANNOTATION$10);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWINKANNOTATION$10); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowInkAnnotation() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWINKANNOTATION$10);
    } 
  }
  
  public boolean getBackupFile() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BACKUPFILE$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(BACKUPFILE$12); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetBackupFile() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(BACKUPFILE$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(BACKUPFILE$12); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetBackupFile() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(BACKUPFILE$12) != null);
    } 
  }
  
  public void setBackupFile(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(BACKUPFILE$12);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(BACKUPFILE$12); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetBackupFile(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(BACKUPFILE$12);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(BACKUPFILE$12); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetBackupFile() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(BACKUPFILE$12);
    } 
  }
  
  public boolean getSaveExternalLinkValues() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SAVEEXTERNALLINKVALUES$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SAVEEXTERNALLINKVALUES$14); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetSaveExternalLinkValues() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SAVEEXTERNALLINKVALUES$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SAVEEXTERNALLINKVALUES$14); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetSaveExternalLinkValues() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SAVEEXTERNALLINKVALUES$14) != null);
    } 
  }
  
  public void setSaveExternalLinkValues(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SAVEEXTERNALLINKVALUES$14);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SAVEEXTERNALLINKVALUES$14); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetSaveExternalLinkValues(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SAVEEXTERNALLINKVALUES$14);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SAVEEXTERNALLINKVALUES$14); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetSaveExternalLinkValues() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SAVEEXTERNALLINKVALUES$14);
    } 
  }
  
  public STUpdateLinks.Enum getUpdateLinks() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UPDATELINKS$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(UPDATELINKS$16); 
      if (simpleValue == null)
        return null; 
      return (STUpdateLinks.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STUpdateLinks xgetUpdateLinks() {
    synchronized (monitor()) {
      check_orphaned();
      STUpdateLinks sTUpdateLinks = null;
      sTUpdateLinks = (STUpdateLinks)get_store().find_attribute_user(UPDATELINKS$16);
      if (sTUpdateLinks == null)
        sTUpdateLinks = (STUpdateLinks)get_default_attribute_value(UPDATELINKS$16); 
      return sTUpdateLinks;
    } 
  }
  
  public boolean isSetUpdateLinks() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(UPDATELINKS$16) != null);
    } 
  }
  
  public void setUpdateLinks(STUpdateLinks.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(UPDATELINKS$16);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(UPDATELINKS$16); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetUpdateLinks(STUpdateLinks paramSTUpdateLinks) {
    synchronized (monitor()) {
      check_orphaned();
      STUpdateLinks sTUpdateLinks = null;
      sTUpdateLinks = (STUpdateLinks)get_store().find_attribute_user(UPDATELINKS$16);
      if (sTUpdateLinks == null)
        sTUpdateLinks = (STUpdateLinks)get_store().add_attribute_user(UPDATELINKS$16); 
      sTUpdateLinks.set((XmlObject)paramSTUpdateLinks);
    } 
  }
  
  public void unsetUpdateLinks() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(UPDATELINKS$16);
    } 
  }
  
  public String getCodeName() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CODENAME$18);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetCodeName() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(CODENAME$18);
      return xmlString;
    } 
  }
  
  public boolean isSetCodeName() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CODENAME$18) != null);
    } 
  }
  
  public void setCodeName(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CODENAME$18);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CODENAME$18); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetCodeName(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_attribute_user(CODENAME$18);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_attribute_user(CODENAME$18); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetCodeName() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CODENAME$18);
    } 
  }
  
  public boolean getHidePivotFieldList() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HIDEPIVOTFIELDLIST$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(HIDEPIVOTFIELDLIST$20); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetHidePivotFieldList() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HIDEPIVOTFIELDLIST$20);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(HIDEPIVOTFIELDLIST$20); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetHidePivotFieldList() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(HIDEPIVOTFIELDLIST$20) != null);
    } 
  }
  
  public void setHidePivotFieldList(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(HIDEPIVOTFIELDLIST$20);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(HIDEPIVOTFIELDLIST$20); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetHidePivotFieldList(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(HIDEPIVOTFIELDLIST$20);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(HIDEPIVOTFIELDLIST$20); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetHidePivotFieldList() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(HIDEPIVOTFIELDLIST$20);
    } 
  }
  
  public boolean getShowPivotChartFilter() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWPIVOTCHARTFILTER$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(SHOWPIVOTCHARTFILTER$22); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetShowPivotChartFilter() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWPIVOTCHARTFILTER$22);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(SHOWPIVOTCHARTFILTER$22); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetShowPivotChartFilter() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(SHOWPIVOTCHARTFILTER$22) != null);
    } 
  }
  
  public void setShowPivotChartFilter(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(SHOWPIVOTCHARTFILTER$22);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(SHOWPIVOTCHARTFILTER$22); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetShowPivotChartFilter(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(SHOWPIVOTCHARTFILTER$22);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(SHOWPIVOTCHARTFILTER$22); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetShowPivotChartFilter() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(SHOWPIVOTCHARTFILTER$22);
    } 
  }
  
  public boolean getAllowRefreshQuery() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALLOWREFRESHQUERY$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(ALLOWREFRESHQUERY$24); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetAllowRefreshQuery() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ALLOWREFRESHQUERY$24);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(ALLOWREFRESHQUERY$24); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetAllowRefreshQuery() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ALLOWREFRESHQUERY$24) != null);
    } 
  }
  
  public void setAllowRefreshQuery(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ALLOWREFRESHQUERY$24);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ALLOWREFRESHQUERY$24); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetAllowRefreshQuery(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ALLOWREFRESHQUERY$24);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ALLOWREFRESHQUERY$24); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetAllowRefreshQuery() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ALLOWREFRESHQUERY$24);
    } 
  }
  
  public boolean getPublishItems() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PUBLISHITEMS$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(PUBLISHITEMS$26); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetPublishItems() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PUBLISHITEMS$26);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(PUBLISHITEMS$26); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetPublishItems() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(PUBLISHITEMS$26) != null);
    } 
  }
  
  public void setPublishItems(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(PUBLISHITEMS$26);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(PUBLISHITEMS$26); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetPublishItems(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(PUBLISHITEMS$26);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(PUBLISHITEMS$26); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetPublishItems() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(PUBLISHITEMS$26);
    } 
  }
  
  public boolean getCheckCompatibility() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CHECKCOMPATIBILITY$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(CHECKCOMPATIBILITY$28); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetCheckCompatibility() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CHECKCOMPATIBILITY$28);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(CHECKCOMPATIBILITY$28); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetCheckCompatibility() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CHECKCOMPATIBILITY$28) != null);
    } 
  }
  
  public void setCheckCompatibility(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CHECKCOMPATIBILITY$28);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CHECKCOMPATIBILITY$28); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetCheckCompatibility(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(CHECKCOMPATIBILITY$28);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(CHECKCOMPATIBILITY$28); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetCheckCompatibility() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CHECKCOMPATIBILITY$28);
    } 
  }
  
  public boolean getAutoCompressPictures() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AUTOCOMPRESSPICTURES$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(AUTOCOMPRESSPICTURES$30); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetAutoCompressPictures() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(AUTOCOMPRESSPICTURES$30);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(AUTOCOMPRESSPICTURES$30); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetAutoCompressPictures() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(AUTOCOMPRESSPICTURES$30) != null);
    } 
  }
  
  public void setAutoCompressPictures(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(AUTOCOMPRESSPICTURES$30);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(AUTOCOMPRESSPICTURES$30); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetAutoCompressPictures(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(AUTOCOMPRESSPICTURES$30);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(AUTOCOMPRESSPICTURES$30); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetAutoCompressPictures() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(AUTOCOMPRESSPICTURES$30);
    } 
  }
  
  public boolean getRefreshAllConnections() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REFRESHALLCONNECTIONS$32);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_default_attribute_value(REFRESHALLCONNECTIONS$32); 
      if (simpleValue == null)
        return false; 
      return simpleValue.getBooleanValue();
    } 
  }
  
  public XmlBoolean xgetRefreshAllConnections() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(REFRESHALLCONNECTIONS$32);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_default_attribute_value(REFRESHALLCONNECTIONS$32); 
      return xmlBoolean;
    } 
  }
  
  public boolean isSetRefreshAllConnections() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(REFRESHALLCONNECTIONS$32) != null);
    } 
  }
  
  public void setRefreshAllConnections(boolean paramBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(REFRESHALLCONNECTIONS$32);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(REFRESHALLCONNECTIONS$32); 
      simpleValue.setBooleanValue(paramBoolean);
    } 
  }
  
  public void xsetRefreshAllConnections(XmlBoolean paramXmlBoolean) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBoolean xmlBoolean = null;
      xmlBoolean = (XmlBoolean)get_store().find_attribute_user(REFRESHALLCONNECTIONS$32);
      if (xmlBoolean == null)
        xmlBoolean = (XmlBoolean)get_store().add_attribute_user(REFRESHALLCONNECTIONS$32); 
      xmlBoolean.set((XmlObject)paramXmlBoolean);
    } 
  }
  
  public void unsetRefreshAllConnections() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(REFRESHALLCONNECTIONS$32);
    } 
  }
  
  public long getDefaultThemeVersion() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFAULTTHEMEVERSION$34);
      if (simpleValue == null)
        return 0L; 
      return simpleValue.getLongValue();
    } 
  }
  
  public XmlUnsignedInt xgetDefaultThemeVersion() {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(DEFAULTTHEMEVERSION$34);
      return xmlUnsignedInt;
    } 
  }
  
  public boolean isSetDefaultThemeVersion() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DEFAULTTHEMEVERSION$34) != null);
    } 
  }
  
  public void setDefaultThemeVersion(long paramLong) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFAULTTHEMEVERSION$34);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DEFAULTTHEMEVERSION$34); 
      simpleValue.setLongValue(paramLong);
    } 
  }
  
  public void xsetDefaultThemeVersion(XmlUnsignedInt paramXmlUnsignedInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlUnsignedInt xmlUnsignedInt = null;
      xmlUnsignedInt = (XmlUnsignedInt)get_store().find_attribute_user(DEFAULTTHEMEVERSION$34);
      if (xmlUnsignedInt == null)
        xmlUnsignedInt = (XmlUnsignedInt)get_store().add_attribute_user(DEFAULTTHEMEVERSION$34); 
      xmlUnsignedInt.set((XmlObject)paramXmlUnsignedInt);
    } 
  }
  
  public void unsetDefaultThemeVersion() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DEFAULTTHEMEVERSION$34);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTWorkbookPrImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */