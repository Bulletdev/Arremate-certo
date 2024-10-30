package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTBookViews;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCustomWorkbookViews;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExtensionList;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalReferences;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFileRecoveryPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFileSharing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFileVersion;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTFunctionGroups;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleSize;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTPivotCaches;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSheets;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSmartTagPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTSmartTagTypes;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWebPublishObjects;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWebPublishing;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookPr;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorkbookProtection;

public class CTWorkbookImpl extends XmlComplexContentImpl implements CTWorkbook {
  private static final b FILEVERSION$0 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "fileVersion");
  
  private static final b FILESHARING$2 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "fileSharing");
  
  private static final b WORKBOOKPR$4 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "workbookPr");
  
  private static final b WORKBOOKPROTECTION$6 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "workbookProtection");
  
  private static final b BOOKVIEWS$8 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "bookViews");
  
  private static final b SHEETS$10 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "sheets");
  
  private static final b FUNCTIONGROUPS$12 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "functionGroups");
  
  private static final b EXTERNALREFERENCES$14 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "externalReferences");
  
  private static final b DEFINEDNAMES$16 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "definedNames");
  
  private static final b CALCPR$18 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "calcPr");
  
  private static final b OLESIZE$20 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "oleSize");
  
  private static final b CUSTOMWORKBOOKVIEWS$22 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "customWorkbookViews");
  
  private static final b PIVOTCACHES$24 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "pivotCaches");
  
  private static final b SMARTTAGPR$26 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "smartTagPr");
  
  private static final b SMARTTAGTYPES$28 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "smartTagTypes");
  
  private static final b WEBPUBLISHING$30 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "webPublishing");
  
  private static final b FILERECOVERYPR$32 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "fileRecoveryPr");
  
  private static final b WEBPUBLISHOBJECTS$34 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "webPublishObjects");
  
  private static final b EXTLST$36 = new b("http://schemas.openxmlformats.org/spreadsheetml/2006/main", "extLst");
  
  public CTWorkbookImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTFileVersion getFileVersion() {
    synchronized (monitor()) {
      check_orphaned();
      CTFileVersion cTFileVersion = null;
      cTFileVersion = (CTFileVersion)get_store().find_element_user(FILEVERSION$0, 0);
      if (cTFileVersion == null)
        return null; 
      return cTFileVersion;
    } 
  }
  
  public boolean isSetFileVersion() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FILEVERSION$0) != 0);
    } 
  }
  
  public void setFileVersion(CTFileVersion paramCTFileVersion) {
    synchronized (monitor()) {
      check_orphaned();
      CTFileVersion cTFileVersion = null;
      cTFileVersion = (CTFileVersion)get_store().find_element_user(FILEVERSION$0, 0);
      if (cTFileVersion == null)
        cTFileVersion = (CTFileVersion)get_store().add_element_user(FILEVERSION$0); 
      cTFileVersion.set((XmlObject)paramCTFileVersion);
    } 
  }
  
  public CTFileVersion addNewFileVersion() {
    synchronized (monitor()) {
      check_orphaned();
      CTFileVersion cTFileVersion = null;
      cTFileVersion = (CTFileVersion)get_store().add_element_user(FILEVERSION$0);
      return cTFileVersion;
    } 
  }
  
  public void unsetFileVersion() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FILEVERSION$0, 0);
    } 
  }
  
  public CTFileSharing getFileSharing() {
    synchronized (monitor()) {
      check_orphaned();
      CTFileSharing cTFileSharing = null;
      cTFileSharing = (CTFileSharing)get_store().find_element_user(FILESHARING$2, 0);
      if (cTFileSharing == null)
        return null; 
      return cTFileSharing;
    } 
  }
  
  public boolean isSetFileSharing() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FILESHARING$2) != 0);
    } 
  }
  
  public void setFileSharing(CTFileSharing paramCTFileSharing) {
    synchronized (monitor()) {
      check_orphaned();
      CTFileSharing cTFileSharing = null;
      cTFileSharing = (CTFileSharing)get_store().find_element_user(FILESHARING$2, 0);
      if (cTFileSharing == null)
        cTFileSharing = (CTFileSharing)get_store().add_element_user(FILESHARING$2); 
      cTFileSharing.set((XmlObject)paramCTFileSharing);
    } 
  }
  
  public CTFileSharing addNewFileSharing() {
    synchronized (monitor()) {
      check_orphaned();
      CTFileSharing cTFileSharing = null;
      cTFileSharing = (CTFileSharing)get_store().add_element_user(FILESHARING$2);
      return cTFileSharing;
    } 
  }
  
  public void unsetFileSharing() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FILESHARING$2, 0);
    } 
  }
  
  public CTWorkbookPr getWorkbookPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTWorkbookPr cTWorkbookPr = null;
      cTWorkbookPr = (CTWorkbookPr)get_store().find_element_user(WORKBOOKPR$4, 0);
      if (cTWorkbookPr == null)
        return null; 
      return cTWorkbookPr;
    } 
  }
  
  public boolean isSetWorkbookPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(WORKBOOKPR$4) != 0);
    } 
  }
  
  public void setWorkbookPr(CTWorkbookPr paramCTWorkbookPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTWorkbookPr cTWorkbookPr = null;
      cTWorkbookPr = (CTWorkbookPr)get_store().find_element_user(WORKBOOKPR$4, 0);
      if (cTWorkbookPr == null)
        cTWorkbookPr = (CTWorkbookPr)get_store().add_element_user(WORKBOOKPR$4); 
      cTWorkbookPr.set((XmlObject)paramCTWorkbookPr);
    } 
  }
  
  public CTWorkbookPr addNewWorkbookPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTWorkbookPr cTWorkbookPr = null;
      cTWorkbookPr = (CTWorkbookPr)get_store().add_element_user(WORKBOOKPR$4);
      return cTWorkbookPr;
    } 
  }
  
  public void unsetWorkbookPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(WORKBOOKPR$4, 0);
    } 
  }
  
  public CTWorkbookProtection getWorkbookProtection() {
    synchronized (monitor()) {
      check_orphaned();
      CTWorkbookProtection cTWorkbookProtection = null;
      cTWorkbookProtection = (CTWorkbookProtection)get_store().find_element_user(WORKBOOKPROTECTION$6, 0);
      if (cTWorkbookProtection == null)
        return null; 
      return cTWorkbookProtection;
    } 
  }
  
  public boolean isSetWorkbookProtection() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(WORKBOOKPROTECTION$6) != 0);
    } 
  }
  
  public void setWorkbookProtection(CTWorkbookProtection paramCTWorkbookProtection) {
    synchronized (monitor()) {
      check_orphaned();
      CTWorkbookProtection cTWorkbookProtection = null;
      cTWorkbookProtection = (CTWorkbookProtection)get_store().find_element_user(WORKBOOKPROTECTION$6, 0);
      if (cTWorkbookProtection == null)
        cTWorkbookProtection = (CTWorkbookProtection)get_store().add_element_user(WORKBOOKPROTECTION$6); 
      cTWorkbookProtection.set((XmlObject)paramCTWorkbookProtection);
    } 
  }
  
  public CTWorkbookProtection addNewWorkbookProtection() {
    synchronized (monitor()) {
      check_orphaned();
      CTWorkbookProtection cTWorkbookProtection = null;
      cTWorkbookProtection = (CTWorkbookProtection)get_store().add_element_user(WORKBOOKPROTECTION$6);
      return cTWorkbookProtection;
    } 
  }
  
  public void unsetWorkbookProtection() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(WORKBOOKPROTECTION$6, 0);
    } 
  }
  
  public CTBookViews getBookViews() {
    synchronized (monitor()) {
      check_orphaned();
      CTBookViews cTBookViews = null;
      cTBookViews = (CTBookViews)get_store().find_element_user(BOOKVIEWS$8, 0);
      if (cTBookViews == null)
        return null; 
      return cTBookViews;
    } 
  }
  
  public boolean isSetBookViews() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BOOKVIEWS$8) != 0);
    } 
  }
  
  public void setBookViews(CTBookViews paramCTBookViews) {
    synchronized (monitor()) {
      check_orphaned();
      CTBookViews cTBookViews = null;
      cTBookViews = (CTBookViews)get_store().find_element_user(BOOKVIEWS$8, 0);
      if (cTBookViews == null)
        cTBookViews = (CTBookViews)get_store().add_element_user(BOOKVIEWS$8); 
      cTBookViews.set((XmlObject)paramCTBookViews);
    } 
  }
  
  public CTBookViews addNewBookViews() {
    synchronized (monitor()) {
      check_orphaned();
      CTBookViews cTBookViews = null;
      cTBookViews = (CTBookViews)get_store().add_element_user(BOOKVIEWS$8);
      return cTBookViews;
    } 
  }
  
  public void unsetBookViews() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BOOKVIEWS$8, 0);
    } 
  }
  
  public CTSheets getSheets() {
    synchronized (monitor()) {
      check_orphaned();
      CTSheets cTSheets = null;
      cTSheets = (CTSheets)get_store().find_element_user(SHEETS$10, 0);
      if (cTSheets == null)
        return null; 
      return cTSheets;
    } 
  }
  
  public void setSheets(CTSheets paramCTSheets) {
    synchronized (monitor()) {
      check_orphaned();
      CTSheets cTSheets = null;
      cTSheets = (CTSheets)get_store().find_element_user(SHEETS$10, 0);
      if (cTSheets == null)
        cTSheets = (CTSheets)get_store().add_element_user(SHEETS$10); 
      cTSheets.set((XmlObject)paramCTSheets);
    } 
  }
  
  public CTSheets addNewSheets() {
    synchronized (monitor()) {
      check_orphaned();
      CTSheets cTSheets = null;
      cTSheets = (CTSheets)get_store().add_element_user(SHEETS$10);
      return cTSheets;
    } 
  }
  
  public CTFunctionGroups getFunctionGroups() {
    synchronized (monitor()) {
      check_orphaned();
      CTFunctionGroups cTFunctionGroups = null;
      cTFunctionGroups = (CTFunctionGroups)get_store().find_element_user(FUNCTIONGROUPS$12, 0);
      if (cTFunctionGroups == null)
        return null; 
      return cTFunctionGroups;
    } 
  }
  
  public boolean isSetFunctionGroups() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FUNCTIONGROUPS$12) != 0);
    } 
  }
  
  public void setFunctionGroups(CTFunctionGroups paramCTFunctionGroups) {
    synchronized (monitor()) {
      check_orphaned();
      CTFunctionGroups cTFunctionGroups = null;
      cTFunctionGroups = (CTFunctionGroups)get_store().find_element_user(FUNCTIONGROUPS$12, 0);
      if (cTFunctionGroups == null)
        cTFunctionGroups = (CTFunctionGroups)get_store().add_element_user(FUNCTIONGROUPS$12); 
      cTFunctionGroups.set((XmlObject)paramCTFunctionGroups);
    } 
  }
  
  public CTFunctionGroups addNewFunctionGroups() {
    synchronized (monitor()) {
      check_orphaned();
      CTFunctionGroups cTFunctionGroups = null;
      cTFunctionGroups = (CTFunctionGroups)get_store().add_element_user(FUNCTIONGROUPS$12);
      return cTFunctionGroups;
    } 
  }
  
  public void unsetFunctionGroups() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FUNCTIONGROUPS$12, 0);
    } 
  }
  
  public CTExternalReferences getExternalReferences() {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalReferences cTExternalReferences = null;
      cTExternalReferences = (CTExternalReferences)get_store().find_element_user(EXTERNALREFERENCES$14, 0);
      if (cTExternalReferences == null)
        return null; 
      return cTExternalReferences;
    } 
  }
  
  public boolean isSetExternalReferences() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTERNALREFERENCES$14) != 0);
    } 
  }
  
  public void setExternalReferences(CTExternalReferences paramCTExternalReferences) {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalReferences cTExternalReferences = null;
      cTExternalReferences = (CTExternalReferences)get_store().find_element_user(EXTERNALREFERENCES$14, 0);
      if (cTExternalReferences == null)
        cTExternalReferences = (CTExternalReferences)get_store().add_element_user(EXTERNALREFERENCES$14); 
      cTExternalReferences.set((XmlObject)paramCTExternalReferences);
    } 
  }
  
  public CTExternalReferences addNewExternalReferences() {
    synchronized (monitor()) {
      check_orphaned();
      CTExternalReferences cTExternalReferences = null;
      cTExternalReferences = (CTExternalReferences)get_store().add_element_user(EXTERNALREFERENCES$14);
      return cTExternalReferences;
    } 
  }
  
  public void unsetExternalReferences() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTERNALREFERENCES$14, 0);
    } 
  }
  
  public CTDefinedNames getDefinedNames() {
    synchronized (monitor()) {
      check_orphaned();
      CTDefinedNames cTDefinedNames = null;
      cTDefinedNames = (CTDefinedNames)get_store().find_element_user(DEFINEDNAMES$16, 0);
      if (cTDefinedNames == null)
        return null; 
      return cTDefinedNames;
    } 
  }
  
  public boolean isSetDefinedNames() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DEFINEDNAMES$16) != 0);
    } 
  }
  
  public void setDefinedNames(CTDefinedNames paramCTDefinedNames) {
    synchronized (monitor()) {
      check_orphaned();
      CTDefinedNames cTDefinedNames = null;
      cTDefinedNames = (CTDefinedNames)get_store().find_element_user(DEFINEDNAMES$16, 0);
      if (cTDefinedNames == null)
        cTDefinedNames = (CTDefinedNames)get_store().add_element_user(DEFINEDNAMES$16); 
      cTDefinedNames.set((XmlObject)paramCTDefinedNames);
    } 
  }
  
  public CTDefinedNames addNewDefinedNames() {
    synchronized (monitor()) {
      check_orphaned();
      CTDefinedNames cTDefinedNames = null;
      cTDefinedNames = (CTDefinedNames)get_store().add_element_user(DEFINEDNAMES$16);
      return cTDefinedNames;
    } 
  }
  
  public void unsetDefinedNames() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DEFINEDNAMES$16, 0);
    } 
  }
  
  public CTCalcPr getCalcPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTCalcPr cTCalcPr = null;
      cTCalcPr = (CTCalcPr)get_store().find_element_user(CALCPR$18, 0);
      if (cTCalcPr == null)
        return null; 
      return cTCalcPr;
    } 
  }
  
  public boolean isSetCalcPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CALCPR$18) != 0);
    } 
  }
  
  public void setCalcPr(CTCalcPr paramCTCalcPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTCalcPr cTCalcPr = null;
      cTCalcPr = (CTCalcPr)get_store().find_element_user(CALCPR$18, 0);
      if (cTCalcPr == null)
        cTCalcPr = (CTCalcPr)get_store().add_element_user(CALCPR$18); 
      cTCalcPr.set((XmlObject)paramCTCalcPr);
    } 
  }
  
  public CTCalcPr addNewCalcPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTCalcPr cTCalcPr = null;
      cTCalcPr = (CTCalcPr)get_store().add_element_user(CALCPR$18);
      return cTCalcPr;
    } 
  }
  
  public void unsetCalcPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CALCPR$18, 0);
    } 
  }
  
  public CTOleSize getOleSize() {
    synchronized (monitor()) {
      check_orphaned();
      CTOleSize cTOleSize = null;
      cTOleSize = (CTOleSize)get_store().find_element_user(OLESIZE$20, 0);
      if (cTOleSize == null)
        return null; 
      return cTOleSize;
    } 
  }
  
  public boolean isSetOleSize() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(OLESIZE$20) != 0);
    } 
  }
  
  public void setOleSize(CTOleSize paramCTOleSize) {
    synchronized (monitor()) {
      check_orphaned();
      CTOleSize cTOleSize = null;
      cTOleSize = (CTOleSize)get_store().find_element_user(OLESIZE$20, 0);
      if (cTOleSize == null)
        cTOleSize = (CTOleSize)get_store().add_element_user(OLESIZE$20); 
      cTOleSize.set((XmlObject)paramCTOleSize);
    } 
  }
  
  public CTOleSize addNewOleSize() {
    synchronized (monitor()) {
      check_orphaned();
      CTOleSize cTOleSize = null;
      cTOleSize = (CTOleSize)get_store().add_element_user(OLESIZE$20);
      return cTOleSize;
    } 
  }
  
  public void unsetOleSize() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(OLESIZE$20, 0);
    } 
  }
  
  public CTCustomWorkbookViews getCustomWorkbookViews() {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomWorkbookViews cTCustomWorkbookViews = null;
      cTCustomWorkbookViews = (CTCustomWorkbookViews)get_store().find_element_user(CUSTOMWORKBOOKVIEWS$22, 0);
      if (cTCustomWorkbookViews == null)
        return null; 
      return cTCustomWorkbookViews;
    } 
  }
  
  public boolean isSetCustomWorkbookViews() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CUSTOMWORKBOOKVIEWS$22) != 0);
    } 
  }
  
  public void setCustomWorkbookViews(CTCustomWorkbookViews paramCTCustomWorkbookViews) {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomWorkbookViews cTCustomWorkbookViews = null;
      cTCustomWorkbookViews = (CTCustomWorkbookViews)get_store().find_element_user(CUSTOMWORKBOOKVIEWS$22, 0);
      if (cTCustomWorkbookViews == null)
        cTCustomWorkbookViews = (CTCustomWorkbookViews)get_store().add_element_user(CUSTOMWORKBOOKVIEWS$22); 
      cTCustomWorkbookViews.set((XmlObject)paramCTCustomWorkbookViews);
    } 
  }
  
  public CTCustomWorkbookViews addNewCustomWorkbookViews() {
    synchronized (monitor()) {
      check_orphaned();
      CTCustomWorkbookViews cTCustomWorkbookViews = null;
      cTCustomWorkbookViews = (CTCustomWorkbookViews)get_store().add_element_user(CUSTOMWORKBOOKVIEWS$22);
      return cTCustomWorkbookViews;
    } 
  }
  
  public void unsetCustomWorkbookViews() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CUSTOMWORKBOOKVIEWS$22, 0);
    } 
  }
  
  public CTPivotCaches getPivotCaches() {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotCaches cTPivotCaches = null;
      cTPivotCaches = (CTPivotCaches)get_store().find_element_user(PIVOTCACHES$24, 0);
      if (cTPivotCaches == null)
        return null; 
      return cTPivotCaches;
    } 
  }
  
  public boolean isSetPivotCaches() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PIVOTCACHES$24) != 0);
    } 
  }
  
  public void setPivotCaches(CTPivotCaches paramCTPivotCaches) {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotCaches cTPivotCaches = null;
      cTPivotCaches = (CTPivotCaches)get_store().find_element_user(PIVOTCACHES$24, 0);
      if (cTPivotCaches == null)
        cTPivotCaches = (CTPivotCaches)get_store().add_element_user(PIVOTCACHES$24); 
      cTPivotCaches.set((XmlObject)paramCTPivotCaches);
    } 
  }
  
  public CTPivotCaches addNewPivotCaches() {
    synchronized (monitor()) {
      check_orphaned();
      CTPivotCaches cTPivotCaches = null;
      cTPivotCaches = (CTPivotCaches)get_store().add_element_user(PIVOTCACHES$24);
      return cTPivotCaches;
    } 
  }
  
  public void unsetPivotCaches() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PIVOTCACHES$24, 0);
    } 
  }
  
  public CTSmartTagPr getSmartTagPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSmartTagPr cTSmartTagPr = null;
      cTSmartTagPr = (CTSmartTagPr)get_store().find_element_user(SMARTTAGPR$26, 0);
      if (cTSmartTagPr == null)
        return null; 
      return cTSmartTagPr;
    } 
  }
  
  public boolean isSetSmartTagPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SMARTTAGPR$26) != 0);
    } 
  }
  
  public void setSmartTagPr(CTSmartTagPr paramCTSmartTagPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTSmartTagPr cTSmartTagPr = null;
      cTSmartTagPr = (CTSmartTagPr)get_store().find_element_user(SMARTTAGPR$26, 0);
      if (cTSmartTagPr == null)
        cTSmartTagPr = (CTSmartTagPr)get_store().add_element_user(SMARTTAGPR$26); 
      cTSmartTagPr.set((XmlObject)paramCTSmartTagPr);
    } 
  }
  
  public CTSmartTagPr addNewSmartTagPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTSmartTagPr cTSmartTagPr = null;
      cTSmartTagPr = (CTSmartTagPr)get_store().add_element_user(SMARTTAGPR$26);
      return cTSmartTagPr;
    } 
  }
  
  public void unsetSmartTagPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SMARTTAGPR$26, 0);
    } 
  }
  
  public CTSmartTagTypes getSmartTagTypes() {
    synchronized (monitor()) {
      check_orphaned();
      CTSmartTagTypes cTSmartTagTypes = null;
      cTSmartTagTypes = (CTSmartTagTypes)get_store().find_element_user(SMARTTAGTYPES$28, 0);
      if (cTSmartTagTypes == null)
        return null; 
      return cTSmartTagTypes;
    } 
  }
  
  public boolean isSetSmartTagTypes() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SMARTTAGTYPES$28) != 0);
    } 
  }
  
  public void setSmartTagTypes(CTSmartTagTypes paramCTSmartTagTypes) {
    synchronized (monitor()) {
      check_orphaned();
      CTSmartTagTypes cTSmartTagTypes = null;
      cTSmartTagTypes = (CTSmartTagTypes)get_store().find_element_user(SMARTTAGTYPES$28, 0);
      if (cTSmartTagTypes == null)
        cTSmartTagTypes = (CTSmartTagTypes)get_store().add_element_user(SMARTTAGTYPES$28); 
      cTSmartTagTypes.set((XmlObject)paramCTSmartTagTypes);
    } 
  }
  
  public CTSmartTagTypes addNewSmartTagTypes() {
    synchronized (monitor()) {
      check_orphaned();
      CTSmartTagTypes cTSmartTagTypes = null;
      cTSmartTagTypes = (CTSmartTagTypes)get_store().add_element_user(SMARTTAGTYPES$28);
      return cTSmartTagTypes;
    } 
  }
  
  public void unsetSmartTagTypes() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SMARTTAGTYPES$28, 0);
    } 
  }
  
  public CTWebPublishing getWebPublishing() {
    synchronized (monitor()) {
      check_orphaned();
      CTWebPublishing cTWebPublishing = null;
      cTWebPublishing = (CTWebPublishing)get_store().find_element_user(WEBPUBLISHING$30, 0);
      if (cTWebPublishing == null)
        return null; 
      return cTWebPublishing;
    } 
  }
  
  public boolean isSetWebPublishing() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(WEBPUBLISHING$30) != 0);
    } 
  }
  
  public void setWebPublishing(CTWebPublishing paramCTWebPublishing) {
    synchronized (monitor()) {
      check_orphaned();
      CTWebPublishing cTWebPublishing = null;
      cTWebPublishing = (CTWebPublishing)get_store().find_element_user(WEBPUBLISHING$30, 0);
      if (cTWebPublishing == null)
        cTWebPublishing = (CTWebPublishing)get_store().add_element_user(WEBPUBLISHING$30); 
      cTWebPublishing.set((XmlObject)paramCTWebPublishing);
    } 
  }
  
  public CTWebPublishing addNewWebPublishing() {
    synchronized (monitor()) {
      check_orphaned();
      CTWebPublishing cTWebPublishing = null;
      cTWebPublishing = (CTWebPublishing)get_store().add_element_user(WEBPUBLISHING$30);
      return cTWebPublishing;
    } 
  }
  
  public void unsetWebPublishing() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(WEBPUBLISHING$30, 0);
    } 
  }
  
  public List<CTFileRecoveryPr> getFileRecoveryPrList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTFileRecoveryPr>)new FileRecoveryPrList(this);
    } 
  }
  
  public CTFileRecoveryPr[] getFileRecoveryPrArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(FILERECOVERYPR$32, arrayList);
      CTFileRecoveryPr[] arrayOfCTFileRecoveryPr = new CTFileRecoveryPr[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTFileRecoveryPr);
      return arrayOfCTFileRecoveryPr;
    } 
  }
  
  public CTFileRecoveryPr getFileRecoveryPrArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFileRecoveryPr cTFileRecoveryPr = null;
      cTFileRecoveryPr = (CTFileRecoveryPr)get_store().find_element_user(FILERECOVERYPR$32, paramInt);
      if (cTFileRecoveryPr == null)
        throw new IndexOutOfBoundsException(); 
      return cTFileRecoveryPr;
    } 
  }
  
  public int sizeOfFileRecoveryPrArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(FILERECOVERYPR$32);
    } 
  }
  
  public void setFileRecoveryPrArray(CTFileRecoveryPr[] paramArrayOfCTFileRecoveryPr) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTFileRecoveryPr, FILERECOVERYPR$32);
    } 
  }
  
  public void setFileRecoveryPrArray(int paramInt, CTFileRecoveryPr paramCTFileRecoveryPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTFileRecoveryPr cTFileRecoveryPr = null;
      cTFileRecoveryPr = (CTFileRecoveryPr)get_store().find_element_user(FILERECOVERYPR$32, paramInt);
      if (cTFileRecoveryPr == null)
        throw new IndexOutOfBoundsException(); 
      cTFileRecoveryPr.set((XmlObject)paramCTFileRecoveryPr);
    } 
  }
  
  public CTFileRecoveryPr insertNewFileRecoveryPr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTFileRecoveryPr cTFileRecoveryPr = null;
      cTFileRecoveryPr = (CTFileRecoveryPr)get_store().insert_element_user(FILERECOVERYPR$32, paramInt);
      return cTFileRecoveryPr;
    } 
  }
  
  public CTFileRecoveryPr addNewFileRecoveryPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTFileRecoveryPr cTFileRecoveryPr = null;
      cTFileRecoveryPr = (CTFileRecoveryPr)get_store().add_element_user(FILERECOVERYPR$32);
      return cTFileRecoveryPr;
    } 
  }
  
  public void removeFileRecoveryPr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FILERECOVERYPR$32, paramInt);
    } 
  }
  
  public CTWebPublishObjects getWebPublishObjects() {
    synchronized (monitor()) {
      check_orphaned();
      CTWebPublishObjects cTWebPublishObjects = null;
      cTWebPublishObjects = (CTWebPublishObjects)get_store().find_element_user(WEBPUBLISHOBJECTS$34, 0);
      if (cTWebPublishObjects == null)
        return null; 
      return cTWebPublishObjects;
    } 
  }
  
  public boolean isSetWebPublishObjects() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(WEBPUBLISHOBJECTS$34) != 0);
    } 
  }
  
  public void setWebPublishObjects(CTWebPublishObjects paramCTWebPublishObjects) {
    synchronized (monitor()) {
      check_orphaned();
      CTWebPublishObjects cTWebPublishObjects = null;
      cTWebPublishObjects = (CTWebPublishObjects)get_store().find_element_user(WEBPUBLISHOBJECTS$34, 0);
      if (cTWebPublishObjects == null)
        cTWebPublishObjects = (CTWebPublishObjects)get_store().add_element_user(WEBPUBLISHOBJECTS$34); 
      cTWebPublishObjects.set((XmlObject)paramCTWebPublishObjects);
    } 
  }
  
  public CTWebPublishObjects addNewWebPublishObjects() {
    synchronized (monitor()) {
      check_orphaned();
      CTWebPublishObjects cTWebPublishObjects = null;
      cTWebPublishObjects = (CTWebPublishObjects)get_store().add_element_user(WEBPUBLISHOBJECTS$34);
      return cTWebPublishObjects;
    } 
  }
  
  public void unsetWebPublishObjects() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(WEBPUBLISHOBJECTS$34, 0);
    } 
  }
  
  public CTExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$36, 0);
      if (cTExtensionList == null)
        return null; 
      return cTExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$36) != 0);
    } 
  }
  
  public void setExtLst(CTExtensionList paramCTExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().find_element_user(EXTLST$36, 0);
      if (cTExtensionList == null)
        cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$36); 
      cTExtensionList.set((XmlObject)paramCTExtensionList);
    } 
  }
  
  public CTExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTExtensionList cTExtensionList = null;
      cTExtensionList = (CTExtensionList)get_store().add_element_user(EXTLST$36);
      return cTExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$36, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\impl\CTWorkbookImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */