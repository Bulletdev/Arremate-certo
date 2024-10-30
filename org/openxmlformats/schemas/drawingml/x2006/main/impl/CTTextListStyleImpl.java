package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;

public class CTTextListStyleImpl extends XmlComplexContentImpl implements CTTextListStyle {
  private static final b DEFPPR$0 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "defPPr");
  
  private static final b LVL1PPR$2 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lvl1pPr");
  
  private static final b LVL2PPR$4 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lvl2pPr");
  
  private static final b LVL3PPR$6 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lvl3pPr");
  
  private static final b LVL4PPR$8 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lvl4pPr");
  
  private static final b LVL5PPR$10 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lvl5pPr");
  
  private static final b LVL6PPR$12 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lvl6pPr");
  
  private static final b LVL7PPR$14 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lvl7pPr");
  
  private static final b LVL8PPR$16 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lvl8pPr");
  
  private static final b LVL9PPR$18 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "lvl9pPr");
  
  private static final b EXTLST$20 = new b("http://schemas.openxmlformats.org/drawingml/2006/main", "extLst");
  
  public CTTextListStyleImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTTextParagraphProperties getDefPPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().find_element_user(DEFPPR$0, 0);
      if (cTTextParagraphProperties == null)
        return null; 
      return cTTextParagraphProperties;
    } 
  }
  
  public boolean isSetDefPPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DEFPPR$0) != 0);
    } 
  }
  
  public void setDefPPr(CTTextParagraphProperties paramCTTextParagraphProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().find_element_user(DEFPPR$0, 0);
      if (cTTextParagraphProperties == null)
        cTTextParagraphProperties = (CTTextParagraphProperties)get_store().add_element_user(DEFPPR$0); 
      cTTextParagraphProperties.set((XmlObject)paramCTTextParagraphProperties);
    } 
  }
  
  public CTTextParagraphProperties addNewDefPPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().add_element_user(DEFPPR$0);
      return cTTextParagraphProperties;
    } 
  }
  
  public void unsetDefPPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DEFPPR$0, 0);
    } 
  }
  
  public CTTextParagraphProperties getLvl1PPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().find_element_user(LVL1PPR$2, 0);
      if (cTTextParagraphProperties == null)
        return null; 
      return cTTextParagraphProperties;
    } 
  }
  
  public boolean isSetLvl1PPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LVL1PPR$2) != 0);
    } 
  }
  
  public void setLvl1PPr(CTTextParagraphProperties paramCTTextParagraphProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().find_element_user(LVL1PPR$2, 0);
      if (cTTextParagraphProperties == null)
        cTTextParagraphProperties = (CTTextParagraphProperties)get_store().add_element_user(LVL1PPR$2); 
      cTTextParagraphProperties.set((XmlObject)paramCTTextParagraphProperties);
    } 
  }
  
  public CTTextParagraphProperties addNewLvl1PPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().add_element_user(LVL1PPR$2);
      return cTTextParagraphProperties;
    } 
  }
  
  public void unsetLvl1PPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LVL1PPR$2, 0);
    } 
  }
  
  public CTTextParagraphProperties getLvl2PPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().find_element_user(LVL2PPR$4, 0);
      if (cTTextParagraphProperties == null)
        return null; 
      return cTTextParagraphProperties;
    } 
  }
  
  public boolean isSetLvl2PPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LVL2PPR$4) != 0);
    } 
  }
  
  public void setLvl2PPr(CTTextParagraphProperties paramCTTextParagraphProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().find_element_user(LVL2PPR$4, 0);
      if (cTTextParagraphProperties == null)
        cTTextParagraphProperties = (CTTextParagraphProperties)get_store().add_element_user(LVL2PPR$4); 
      cTTextParagraphProperties.set((XmlObject)paramCTTextParagraphProperties);
    } 
  }
  
  public CTTextParagraphProperties addNewLvl2PPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().add_element_user(LVL2PPR$4);
      return cTTextParagraphProperties;
    } 
  }
  
  public void unsetLvl2PPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LVL2PPR$4, 0);
    } 
  }
  
  public CTTextParagraphProperties getLvl3PPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().find_element_user(LVL3PPR$6, 0);
      if (cTTextParagraphProperties == null)
        return null; 
      return cTTextParagraphProperties;
    } 
  }
  
  public boolean isSetLvl3PPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LVL3PPR$6) != 0);
    } 
  }
  
  public void setLvl3PPr(CTTextParagraphProperties paramCTTextParagraphProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().find_element_user(LVL3PPR$6, 0);
      if (cTTextParagraphProperties == null)
        cTTextParagraphProperties = (CTTextParagraphProperties)get_store().add_element_user(LVL3PPR$6); 
      cTTextParagraphProperties.set((XmlObject)paramCTTextParagraphProperties);
    } 
  }
  
  public CTTextParagraphProperties addNewLvl3PPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().add_element_user(LVL3PPR$6);
      return cTTextParagraphProperties;
    } 
  }
  
  public void unsetLvl3PPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LVL3PPR$6, 0);
    } 
  }
  
  public CTTextParagraphProperties getLvl4PPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().find_element_user(LVL4PPR$8, 0);
      if (cTTextParagraphProperties == null)
        return null; 
      return cTTextParagraphProperties;
    } 
  }
  
  public boolean isSetLvl4PPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LVL4PPR$8) != 0);
    } 
  }
  
  public void setLvl4PPr(CTTextParagraphProperties paramCTTextParagraphProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().find_element_user(LVL4PPR$8, 0);
      if (cTTextParagraphProperties == null)
        cTTextParagraphProperties = (CTTextParagraphProperties)get_store().add_element_user(LVL4PPR$8); 
      cTTextParagraphProperties.set((XmlObject)paramCTTextParagraphProperties);
    } 
  }
  
  public CTTextParagraphProperties addNewLvl4PPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().add_element_user(LVL4PPR$8);
      return cTTextParagraphProperties;
    } 
  }
  
  public void unsetLvl4PPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LVL4PPR$8, 0);
    } 
  }
  
  public CTTextParagraphProperties getLvl5PPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().find_element_user(LVL5PPR$10, 0);
      if (cTTextParagraphProperties == null)
        return null; 
      return cTTextParagraphProperties;
    } 
  }
  
  public boolean isSetLvl5PPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LVL5PPR$10) != 0);
    } 
  }
  
  public void setLvl5PPr(CTTextParagraphProperties paramCTTextParagraphProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().find_element_user(LVL5PPR$10, 0);
      if (cTTextParagraphProperties == null)
        cTTextParagraphProperties = (CTTextParagraphProperties)get_store().add_element_user(LVL5PPR$10); 
      cTTextParagraphProperties.set((XmlObject)paramCTTextParagraphProperties);
    } 
  }
  
  public CTTextParagraphProperties addNewLvl5PPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().add_element_user(LVL5PPR$10);
      return cTTextParagraphProperties;
    } 
  }
  
  public void unsetLvl5PPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LVL5PPR$10, 0);
    } 
  }
  
  public CTTextParagraphProperties getLvl6PPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().find_element_user(LVL6PPR$12, 0);
      if (cTTextParagraphProperties == null)
        return null; 
      return cTTextParagraphProperties;
    } 
  }
  
  public boolean isSetLvl6PPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LVL6PPR$12) != 0);
    } 
  }
  
  public void setLvl6PPr(CTTextParagraphProperties paramCTTextParagraphProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().find_element_user(LVL6PPR$12, 0);
      if (cTTextParagraphProperties == null)
        cTTextParagraphProperties = (CTTextParagraphProperties)get_store().add_element_user(LVL6PPR$12); 
      cTTextParagraphProperties.set((XmlObject)paramCTTextParagraphProperties);
    } 
  }
  
  public CTTextParagraphProperties addNewLvl6PPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().add_element_user(LVL6PPR$12);
      return cTTextParagraphProperties;
    } 
  }
  
  public void unsetLvl6PPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LVL6PPR$12, 0);
    } 
  }
  
  public CTTextParagraphProperties getLvl7PPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().find_element_user(LVL7PPR$14, 0);
      if (cTTextParagraphProperties == null)
        return null; 
      return cTTextParagraphProperties;
    } 
  }
  
  public boolean isSetLvl7PPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LVL7PPR$14) != 0);
    } 
  }
  
  public void setLvl7PPr(CTTextParagraphProperties paramCTTextParagraphProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().find_element_user(LVL7PPR$14, 0);
      if (cTTextParagraphProperties == null)
        cTTextParagraphProperties = (CTTextParagraphProperties)get_store().add_element_user(LVL7PPR$14); 
      cTTextParagraphProperties.set((XmlObject)paramCTTextParagraphProperties);
    } 
  }
  
  public CTTextParagraphProperties addNewLvl7PPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().add_element_user(LVL7PPR$14);
      return cTTextParagraphProperties;
    } 
  }
  
  public void unsetLvl7PPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LVL7PPR$14, 0);
    } 
  }
  
  public CTTextParagraphProperties getLvl8PPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().find_element_user(LVL8PPR$16, 0);
      if (cTTextParagraphProperties == null)
        return null; 
      return cTTextParagraphProperties;
    } 
  }
  
  public boolean isSetLvl8PPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LVL8PPR$16) != 0);
    } 
  }
  
  public void setLvl8PPr(CTTextParagraphProperties paramCTTextParagraphProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().find_element_user(LVL8PPR$16, 0);
      if (cTTextParagraphProperties == null)
        cTTextParagraphProperties = (CTTextParagraphProperties)get_store().add_element_user(LVL8PPR$16); 
      cTTextParagraphProperties.set((XmlObject)paramCTTextParagraphProperties);
    } 
  }
  
  public CTTextParagraphProperties addNewLvl8PPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().add_element_user(LVL8PPR$16);
      return cTTextParagraphProperties;
    } 
  }
  
  public void unsetLvl8PPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LVL8PPR$16, 0);
    } 
  }
  
  public CTTextParagraphProperties getLvl9PPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().find_element_user(LVL9PPR$18, 0);
      if (cTTextParagraphProperties == null)
        return null; 
      return cTTextParagraphProperties;
    } 
  }
  
  public boolean isSetLvl9PPr() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(LVL9PPR$18) != 0);
    } 
  }
  
  public void setLvl9PPr(CTTextParagraphProperties paramCTTextParagraphProperties) {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().find_element_user(LVL9PPR$18, 0);
      if (cTTextParagraphProperties == null)
        cTTextParagraphProperties = (CTTextParagraphProperties)get_store().add_element_user(LVL9PPR$18); 
      cTTextParagraphProperties.set((XmlObject)paramCTTextParagraphProperties);
    } 
  }
  
  public CTTextParagraphProperties addNewLvl9PPr() {
    synchronized (monitor()) {
      check_orphaned();
      CTTextParagraphProperties cTTextParagraphProperties = null;
      cTTextParagraphProperties = (CTTextParagraphProperties)get_store().add_element_user(LVL9PPR$18);
      return cTTextParagraphProperties;
    } 
  }
  
  public void unsetLvl9PPr() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(LVL9PPR$18, 0);
    } 
  }
  
  public CTOfficeArtExtensionList getExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$20, 0);
      if (cTOfficeArtExtensionList == null)
        return null; 
      return cTOfficeArtExtensionList;
    } 
  }
  
  public boolean isSetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EXTLST$20) != 0);
    } 
  }
  
  public void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList) {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().find_element_user(EXTLST$20, 0);
      if (cTOfficeArtExtensionList == null)
        cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$20); 
      cTOfficeArtExtensionList.set((XmlObject)paramCTOfficeArtExtensionList);
    } 
  }
  
  public CTOfficeArtExtensionList addNewExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      CTOfficeArtExtensionList cTOfficeArtExtensionList = null;
      cTOfficeArtExtensionList = (CTOfficeArtExtensionList)get_store().add_element_user(EXTLST$20);
      return cTOfficeArtExtensionList;
    } 
  }
  
  public void unsetExtLst() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EXTLST$20, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\impl\CTTextListStyleImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */