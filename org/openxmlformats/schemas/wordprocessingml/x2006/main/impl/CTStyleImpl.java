package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLongHexNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPrBase;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblStylePr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STStyleType;

public class CTStyleImpl extends XmlComplexContentImpl implements CTStyle {
  private static final b NAME$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "name");
  
  private static final b ALIASES$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "aliases");
  
  private static final b BASEDON$4 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "basedOn");
  
  private static final b NEXT$6 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "next");
  
  private static final b LINK$8 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "link");
  
  private static final b AUTOREDEFINE$10 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "autoRedefine");
  
  private static final b HIDDEN$12 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "hidden");
  
  private static final b UIPRIORITY$14 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "uiPriority");
  
  private static final b SEMIHIDDEN$16 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "semiHidden");
  
  private static final b UNHIDEWHENUSED$18 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "unhideWhenUsed");
  
  private static final b QFORMAT$20 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "qFormat");
  
  private static final b LOCKED$22 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "locked");
  
  private static final b PERSONAL$24 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "personal");
  
  private static final b PERSONALCOMPOSE$26 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "personalCompose");
  
  private static final b PERSONALREPLY$28 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "personalReply");
  
  private static final b RSID$30 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rsid");
  
  private static final b PPR$32 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "pPr");
  
  private static final b RPR$34 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "rPr");
  
  private static final b TBLPR$36 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblPr");
  
  private static final b TRPR$38 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "trPr");
  
  private static final b TCPR$40 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tcPr");
  
  private static final b TBLSTYLEPR$42 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "tblStylePr");
  
  private static final b TYPE$44 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "type");
  
  private static final b STYLEID$46 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "styleId");
  
  private static final b DEFAULT$48 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "default");
  
  private static final b CUSTOMSTYLE$50 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "customStyle");
  
  public CTStyleImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTString getName() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(NAME$0, 0);
      if (cTString == null)
        return null; 
      return cTString;
    } 
  }
  
  public boolean isSetName() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NAME$0) != 0);
    } 
  }
  
  public void setName(CTString paramCTString) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(NAME$0, 0);
      if (cTString == null)
        cTString = (CTString)get_store().add_element_user(NAME$0); 
      cTString.set((XmlObject)paramCTString);
    } 
  }
  
  public CTString addNewName() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().add_element_user(NAME$0);
      return cTString;
    } 
  }
  
  public void unsetName() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NAME$0, 0);
    } 
  }
  
  public CTString getAliases() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(ALIASES$2, 0);
      if (cTString == null)
        return null; 
      return cTString;
    } 
  }
  
  public boolean isSetAliases() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(ALIASES$2) != 0);
    } 
  }
  
  public void setAliases(CTString paramCTString) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(ALIASES$2, 0);
      if (cTString == null)
        cTString = (CTString)get_store().add_element_user(ALIASES$2); 
      cTString.set((XmlObject)paramCTString);
    } 
  }
  
  public CTString addNewAliases() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().add_element_user(ALIASES$2);
      return cTString;
    } 
  }
  
  public void unsetAliases() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ALIASES$2, 0);
    } 
  }
  
  public CTString getBasedOn() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(BASEDON$4, 0);
      if (cTString == null)
        return null; 
      return cTString;
    } 
  }
  
  public boolean isSetBasedOn() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(BASEDON$4) != 0);
    } 
  }
  
  public void setBasedOn(CTString paramCTString) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(BASEDON$4, 0);
      if (cTString == null)
        cTString = (CTString)get_store().add_element_user(BASEDON$4); 
      cTString.set((XmlObject)paramCTString);
    } 
  }
  
  public CTString addNewBasedOn() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().add_element_user(BASEDON$4);
      return cTString;
    } 
  }
  
  public void unsetBasedOn() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(BASEDON$4, 0);
    } 
  }
  
  public CTString getNext() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(NEXT$6, 0);
      if (cTString == null)
        return null; 
      return cTString;
    } 
  }
  
  public boolean isSetNext() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(NEXT$6) != 0);
    } 
  }
  
  public void setNext(CTString paramCTString) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(NEXT$6, 0);
      if (cTString == null)
        cTString = (CTString)get_store().add_element_user(NEXT$6); 
      cTString.set((XmlObject)paramCTString);
    } 
  }
  
  public CTString addNewNext() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().add_element_user(NEXT$6);
      return cTString;
    } 
  }
  
  public void unsetNext() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(NEXT$6, 0);
    } 
  }
  
  public CTString getLink() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(LINK$8, 0);
      if (cTString == null)
        return null; 
      return cTString;
    } 
  }
  
  public boolean isSetLink() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LINK$8) != 0);
    } 
  }
  
  public void setLink(CTString paramCTString) {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().find_element_user(LINK$8, 0);
      if (cTString == null)
        cTString = (CTString)get_store().add_element_user(LINK$8); 
      cTString.set((XmlObject)paramCTString);
    } 
  }
  
  public CTString addNewLink() {
    synchronized (monitor()) {
      check_orphaned();
      CTString cTString = null;
      cTString = (CTString)get_store().add_element_user(LINK$8);
      return cTString;
    } 
  }
  
  public void unsetLink() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LINK$8, 0);
    } 
  }
  
  public CTOnOff getAutoRedefine() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(AUTOREDEFINE$10, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetAutoRedefine() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(AUTOREDEFINE$10) != 0);
    } 
  }
  
  public void setAutoRedefine(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(AUTOREDEFINE$10, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(AUTOREDEFINE$10); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewAutoRedefine() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(AUTOREDEFINE$10);
      return cTOnOff;
    } 
  }
  
  public void unsetAutoRedefine() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(AUTOREDEFINE$10, 0);
    } 
  }
  
  public CTOnOff getHidden() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(HIDDEN$12, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetHidden() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HIDDEN$12) != 0);
    } 
  }
  
  public void setHidden(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(HIDDEN$12, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(HIDDEN$12); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewHidden() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(HIDDEN$12);
      return cTOnOff;
    } 
  }
  
  public void unsetHidden() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HIDDEN$12, 0);
    } 
  }
  
  public CTDecimalNumber getUiPriority() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(UIPRIORITY$14, 0);
      if (cTDecimalNumber == null)
        return null; 
      return cTDecimalNumber;
    } 
  }
  
  public boolean isSetUiPriority() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(UIPRIORITY$14) != 0);
    } 
  }
  
  public void setUiPriority(CTDecimalNumber paramCTDecimalNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().find_element_user(UIPRIORITY$14, 0);
      if (cTDecimalNumber == null)
        cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(UIPRIORITY$14); 
      cTDecimalNumber.set((XmlObject)paramCTDecimalNumber);
    } 
  }
  
  public CTDecimalNumber addNewUiPriority() {
    synchronized (monitor()) {
      check_orphaned();
      CTDecimalNumber cTDecimalNumber = null;
      cTDecimalNumber = (CTDecimalNumber)get_store().add_element_user(UIPRIORITY$14);
      return cTDecimalNumber;
    } 
  }
  
  public void unsetUiPriority() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(UIPRIORITY$14, 0);
    } 
  }
  
  public CTOnOff getSemiHidden() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SEMIHIDDEN$16, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetSemiHidden() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(SEMIHIDDEN$16) != 0);
    } 
  }
  
  public void setSemiHidden(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(SEMIHIDDEN$16, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(SEMIHIDDEN$16); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewSemiHidden() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(SEMIHIDDEN$16);
      return cTOnOff;
    } 
  }
  
  public void unsetSemiHidden() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(SEMIHIDDEN$16, 0);
    } 
  }
  
  public CTOnOff getUnhideWhenUsed() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(UNHIDEWHENUSED$18, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetUnhideWhenUsed() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(UNHIDEWHENUSED$18) != 0);
    } 
  }
  
  public void setUnhideWhenUsed(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(UNHIDEWHENUSED$18, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(UNHIDEWHENUSED$18); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewUnhideWhenUsed() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(UNHIDEWHENUSED$18);
      return cTOnOff;
    } 
  }
  
  public void unsetUnhideWhenUsed() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(UNHIDEWHENUSED$18, 0);
    } 
  }
  
  public CTOnOff getQFormat() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(QFORMAT$20, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetQFormat() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(QFORMAT$20) != 0);
    } 
  }
  
  public void setQFormat(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(QFORMAT$20, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(QFORMAT$20); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewQFormat() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(QFORMAT$20);
      return cTOnOff;
    } 
  }
  
  public void unsetQFormat() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(QFORMAT$20, 0);
    } 
  }
  
  public CTOnOff getLocked() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(LOCKED$22, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetLocked() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LOCKED$22) != 0);
    } 
  }
  
  public void setLocked(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(LOCKED$22, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(LOCKED$22); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewLocked() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(LOCKED$22);
      return cTOnOff;
    } 
  }
  
  public void unsetLocked() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LOCKED$22, 0);
    } 
  }
  
  public CTOnOff getPersonal() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(PERSONAL$24, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetPersonal() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PERSONAL$24) != 0);
    } 
  }
  
  public void setPersonal(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(PERSONAL$24, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(PERSONAL$24); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewPersonal() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(PERSONAL$24);
      return cTOnOff;
    } 
  }
  
  public void unsetPersonal() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PERSONAL$24, 0);
    } 
  }
  
  public CTOnOff getPersonalCompose() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(PERSONALCOMPOSE$26, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetPersonalCompose() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PERSONALCOMPOSE$26) != 0);
    } 
  }
  
  public void setPersonalCompose(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(PERSONALCOMPOSE$26, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(PERSONALCOMPOSE$26); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewPersonalCompose() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(PERSONALCOMPOSE$26);
      return cTOnOff;
    } 
  }
  
  public void unsetPersonalCompose() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PERSONALCOMPOSE$26, 0);
    } 
  }
  
  public CTOnOff getPersonalReply() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(PERSONALREPLY$28, 0);
      if (cTOnOff == null)
        return null; 
      return cTOnOff;
    } 
  }
  
  public boolean isSetPersonalReply() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PERSONALREPLY$28) != 0);
    } 
  }
  
  public void setPersonalReply(CTOnOff paramCTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().find_element_user(PERSONALREPLY$28, 0);
      if (cTOnOff == null)
        cTOnOff = (CTOnOff)get_store().add_element_user(PERSONALREPLY$28); 
      cTOnOff.set((XmlObject)paramCTOnOff);
    } 
  }
  
  public CTOnOff addNewPersonalReply() {
    synchronized (monitor()) {
      check_orphaned();
      CTOnOff cTOnOff = null;
      cTOnOff = (CTOnOff)get_store().add_element_user(PERSONALREPLY$28);
      return cTOnOff;
    } 
  }
  
  public void unsetPersonalReply() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PERSONALREPLY$28, 0);
    } 
  }
  
  public CTLongHexNumber getRsid() {
    synchronized (monitor()) {
      check_orphaned();
      CTLongHexNumber cTLongHexNumber = null;
      cTLongHexNumber = (CTLongHexNumber)get_store().find_element_user(RSID$30, 0);
      if (cTLongHexNumber == null)
        return null; 
      return cTLongHexNumber;
    } 
  }
  
  public boolean isSetRsid() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(RSID$30) != 0);
    } 
  }
  
  public void setRsid(CTLongHexNumber paramCTLongHexNumber) {
    synchronized (monitor()) {
      check_orphaned();
      CTLongHexNumber cTLongHexNumber = null;
      cTLongHexNumber = (CTLongHexNumber)get_store().find_element_user(RSID$30, 0);
      if (cTLongHexNumber == null)
        cTLongHexNumber = (CTLongHexNumber)get_store().add_element_user(RSID$30); 
      cTLongHexNumber.set((XmlObject)paramCTLongHexNumber);
    } 
  }
  
  public CTLongHexNumber addNewRsid() {
    synchronized (monitor()) {
      check_orphaned();
      CTLongHexNumber cTLongHexNumber = null;
      cTLongHexNumber = (CTLongHexNumber)get_store().add_element_user(RSID$30);
      return cTLongHexNumber;
    } 
  }
  
  public void unsetRsid() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RSID$30, 0);
    } 
  }
  
  public CTPPr getPPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTPPr cTPPr = null;
      cTPPr = (CTPPr)get_store().find_element_user(PPR$32, 0);
      if (cTPPr == null)
        return null; 
      return cTPPr;
    } 
  }
  
  public boolean isSetPPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PPR$32) != 0);
    } 
  }
  
  public void setPPr(CTPPr paramCTPPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTPPr cTPPr = null;
      cTPPr = (CTPPr)get_store().find_element_user(PPR$32, 0);
      if (cTPPr == null)
        cTPPr = (CTPPr)get_store().add_element_user(PPR$32); 
      cTPPr.set((XmlObject)paramCTPPr);
    } 
  }
  
  public CTPPr addNewPPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTPPr cTPPr = null;
      cTPPr = (CTPPr)get_store().add_element_user(PPR$32);
      return cTPPr;
    } 
  }
  
  public void unsetPPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PPR$32, 0);
    } 
  }
  
  public CTRPr getRPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTRPr cTRPr = null;
      cTRPr = (CTRPr)get_store().find_element_user(RPR$34, 0);
      if (cTRPr == null)
        return null; 
      return cTRPr;
    } 
  }
  
  public boolean isSetRPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(RPR$34) != 0);
    } 
  }
  
  public void setRPr(CTRPr paramCTRPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTRPr cTRPr = null;
      cTRPr = (CTRPr)get_store().find_element_user(RPR$34, 0);
      if (cTRPr == null)
        cTRPr = (CTRPr)get_store().add_element_user(RPR$34); 
      cTRPr.set((XmlObject)paramCTRPr);
    } 
  }
  
  public CTRPr addNewRPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTRPr cTRPr = null;
      cTRPr = (CTRPr)get_store().add_element_user(RPR$34);
      return cTRPr;
    } 
  }
  
  public void unsetRPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(RPR$34, 0);
    } 
  }
  
  public CTTblPrBase getTblPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblPrBase cTTblPrBase = null;
      cTTblPrBase = (CTTblPrBase)get_store().find_element_user(TBLPR$36, 0);
      if (cTTblPrBase == null)
        return null; 
      return cTTblPrBase;
    } 
  }
  
  public boolean isSetTblPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TBLPR$36) != 0);
    } 
  }
  
  public void setTblPr(CTTblPrBase paramCTTblPrBase) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblPrBase cTTblPrBase = null;
      cTTblPrBase = (CTTblPrBase)get_store().find_element_user(TBLPR$36, 0);
      if (cTTblPrBase == null)
        cTTblPrBase = (CTTblPrBase)get_store().add_element_user(TBLPR$36); 
      cTTblPrBase.set((XmlObject)paramCTTblPrBase);
    } 
  }
  
  public CTTblPrBase addNewTblPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblPrBase cTTblPrBase = null;
      cTTblPrBase = (CTTblPrBase)get_store().add_element_user(TBLPR$36);
      return cTTblPrBase;
    } 
  }
  
  public void unsetTblPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TBLPR$36, 0);
    } 
  }
  
  public CTTrPr getTrPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrPr cTTrPr = null;
      cTTrPr = (CTTrPr)get_store().find_element_user(TRPR$38, 0);
      if (cTTrPr == null)
        return null; 
      return cTTrPr;
    } 
  }
  
  public boolean isSetTrPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TRPR$38) != 0);
    } 
  }
  
  public void setTrPr(CTTrPr paramCTTrPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTTrPr cTTrPr = null;
      cTTrPr = (CTTrPr)get_store().find_element_user(TRPR$38, 0);
      if (cTTrPr == null)
        cTTrPr = (CTTrPr)get_store().add_element_user(TRPR$38); 
      cTTrPr.set((XmlObject)paramCTTrPr);
    } 
  }
  
  public CTTrPr addNewTrPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTrPr cTTrPr = null;
      cTTrPr = (CTTrPr)get_store().add_element_user(TRPR$38);
      return cTTrPr;
    } 
  }
  
  public void unsetTrPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TRPR$38, 0);
    } 
  }
  
  public CTTcPr getTcPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTcPr cTTcPr = null;
      cTTcPr = (CTTcPr)get_store().find_element_user(TCPR$40, 0);
      if (cTTcPr == null)
        return null; 
      return cTTcPr;
    } 
  }
  
  public boolean isSetTcPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(TCPR$40) != 0);
    } 
  }
  
  public void setTcPr(CTTcPr paramCTTcPr) {
    synchronized (monitor()) {
      check_orphaned();
      CTTcPr cTTcPr = null;
      cTTcPr = (CTTcPr)get_store().find_element_user(TCPR$40, 0);
      if (cTTcPr == null)
        cTTcPr = (CTTcPr)get_store().add_element_user(TCPR$40); 
      cTTcPr.set((XmlObject)paramCTTcPr);
    } 
  }
  
  public CTTcPr addNewTcPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTcPr cTTcPr = null;
      cTTcPr = (CTTcPr)get_store().add_element_user(TCPR$40);
      return cTTcPr;
    } 
  }
  
  public void unsetTcPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TCPR$40, 0);
    } 
  }
  
  public List<CTTblStylePr> getTblStylePrList() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CTTblStylePr>)new TblStylePrList(this);
    } 
  }
  
  public CTTblStylePr[] getTblStylePrArray() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(TBLSTYLEPR$42, arrayList);
      CTTblStylePr[] arrayOfCTTblStylePr = new CTTblStylePr[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCTTblStylePr);
      return arrayOfCTTblStylePr;
    } 
  }
  
  public CTTblStylePr getTblStylePrArray(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblStylePr cTTblStylePr = null;
      cTTblStylePr = (CTTblStylePr)get_store().find_element_user(TBLSTYLEPR$42, paramInt);
      if (cTTblStylePr == null)
        throw new IndexOutOfBoundsException(); 
      return cTTblStylePr;
    } 
  }
  
  public int sizeOfTblStylePrArray() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(TBLSTYLEPR$42);
    } 
  }
  
  public void setTblStylePrArray(CTTblStylePr[] paramArrayOfCTTblStylePr) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCTTblStylePr, TBLSTYLEPR$42);
    } 
  }
  
  public void setTblStylePrArray(int paramInt, CTTblStylePr paramCTTblStylePr) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblStylePr cTTblStylePr = null;
      cTTblStylePr = (CTTblStylePr)get_store().find_element_user(TBLSTYLEPR$42, paramInt);
      if (cTTblStylePr == null)
        throw new IndexOutOfBoundsException(); 
      cTTblStylePr.set((XmlObject)paramCTTblStylePr);
    } 
  }
  
  public CTTblStylePr insertNewTblStylePr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CTTblStylePr cTTblStylePr = null;
      cTTblStylePr = (CTTblStylePr)get_store().insert_element_user(TBLSTYLEPR$42, paramInt);
      return cTTblStylePr;
    } 
  }
  
  public CTTblStylePr addNewTblStylePr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTblStylePr cTTblStylePr = null;
      cTTblStylePr = (CTTblStylePr)get_store().add_element_user(TBLSTYLEPR$42);
      return cTTblStylePr;
    } 
  }
  
  public void removeTblStylePr(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(TBLSTYLEPR$42, paramInt);
    } 
  }
  
  public STStyleType.Enum getType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$44);
      if (simpleValue == null)
        return null; 
      return (STStyleType.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STStyleType xgetType() {
    synchronized (monitor()) {
      check_orphaned();
      STStyleType sTStyleType = null;
      sTStyleType = (STStyleType)get_store().find_attribute_user(TYPE$44);
      return sTStyleType;
    } 
  }
  
  public boolean isSetType() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(TYPE$44) != null);
    } 
  }
  
  public void setType(STStyleType.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$44);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(TYPE$44); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetType(STStyleType paramSTStyleType) {
    synchronized (monitor()) {
      check_orphaned();
      STStyleType sTStyleType = null;
      sTStyleType = (STStyleType)get_store().find_attribute_user(TYPE$44);
      if (sTStyleType == null)
        sTStyleType = (STStyleType)get_store().add_attribute_user(TYPE$44); 
      sTStyleType.set((XmlObject)paramSTStyleType);
    } 
  }
  
  public void unsetType() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(TYPE$44);
    } 
  }
  
  public String getStyleId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STYLEID$46);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STString xgetStyleId() {
    synchronized (monitor()) {
      check_orphaned();
      STString sTString = null;
      sTString = (STString)get_store().find_attribute_user(STYLEID$46);
      return sTString;
    } 
  }
  
  public boolean isSetStyleId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(STYLEID$46) != null);
    } 
  }
  
  public void setStyleId(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(STYLEID$46);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(STYLEID$46); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetStyleId(STString paramSTString) {
    synchronized (monitor()) {
      check_orphaned();
      STString sTString = null;
      sTString = (STString)get_store().find_attribute_user(STYLEID$46);
      if (sTString == null)
        sTString = (STString)get_store().add_attribute_user(STYLEID$46); 
      sTString.set((XmlObject)paramSTString);
    } 
  }
  
  public void unsetStyleId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(STYLEID$46);
    } 
  }
  
  public STOnOff.Enum getDefault() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFAULT$48);
      if (simpleValue == null)
        return null; 
      return (STOnOff.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STOnOff xgetDefault() {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(DEFAULT$48);
      return sTOnOff;
    } 
  }
  
  public boolean isSetDefault() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(DEFAULT$48) != null);
    } 
  }
  
  public void setDefault(STOnOff.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(DEFAULT$48);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(DEFAULT$48); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetDefault(STOnOff paramSTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(DEFAULT$48);
      if (sTOnOff == null)
        sTOnOff = (STOnOff)get_store().add_attribute_user(DEFAULT$48); 
      sTOnOff.set((XmlObject)paramSTOnOff);
    } 
  }
  
  public void unsetDefault() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(DEFAULT$48);
    } 
  }
  
  public STOnOff.Enum getCustomStyle() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CUSTOMSTYLE$50);
      if (simpleValue == null)
        return null; 
      return (STOnOff.Enum)simpleValue.getEnumValue();
    } 
  }
  
  public STOnOff xgetCustomStyle() {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(CUSTOMSTYLE$50);
      return sTOnOff;
    } 
  }
  
  public boolean isSetCustomStyle() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(CUSTOMSTYLE$50) != null);
    } 
  }
  
  public void setCustomStyle(STOnOff.Enum paramEnum) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(CUSTOMSTYLE$50);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(CUSTOMSTYLE$50); 
      simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
    } 
  }
  
  public void xsetCustomStyle(STOnOff paramSTOnOff) {
    synchronized (monitor()) {
      check_orphaned();
      STOnOff sTOnOff = null;
      sTOnOff = (STOnOff)get_store().find_attribute_user(CUSTOMSTYLE$50);
      if (sTOnOff == null)
        sTOnOff = (STOnOff)get_store().add_attribute_user(CUSTOMSTYLE$50); 
      sTOnOff.set((XmlObject)paramSTOnOff);
    } 
  }
  
  public void unsetCustomStyle() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(CUSTOMSTYLE$50);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTStyleImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */