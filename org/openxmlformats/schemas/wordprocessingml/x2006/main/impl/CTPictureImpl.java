package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTControl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPicture;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRel;

public class CTPictureImpl extends CTPictureBaseImpl implements CTPicture {
  private static final b MOVIE$0 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "movie");
  
  private static final b CONTROL$2 = new b("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "control");
  
  public CTPictureImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public CTRel getMovie() {
    synchronized (monitor()) {
      check_orphaned();
      CTRel cTRel = null;
      cTRel = (CTRel)get_store().find_element_user(MOVIE$0, 0);
      if (cTRel == null)
        return null; 
      return cTRel;
    } 
  }
  
  public boolean isSetMovie() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(MOVIE$0) != 0);
    } 
  }
  
  public void setMovie(CTRel paramCTRel) {
    synchronized (monitor()) {
      check_orphaned();
      CTRel cTRel = null;
      cTRel = (CTRel)get_store().find_element_user(MOVIE$0, 0);
      if (cTRel == null)
        cTRel = (CTRel)get_store().add_element_user(MOVIE$0); 
      cTRel.set((XmlObject)paramCTRel);
    } 
  }
  
  public CTRel addNewMovie() {
    synchronized (monitor()) {
      check_orphaned();
      CTRel cTRel = null;
      cTRel = (CTRel)get_store().add_element_user(MOVIE$0);
      return cTRel;
    } 
  }
  
  public void unsetMovie() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MOVIE$0, 0);
    } 
  }
  
  public CTControl getControl() {
    synchronized (monitor()) {
      check_orphaned();
      CTControl cTControl = null;
      cTControl = (CTControl)get_store().find_element_user(CONTROL$2, 0);
      if (cTControl == null)
        return null; 
      return cTControl;
    } 
  }
  
  public boolean isSetControl() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(CONTROL$2) != 0);
    } 
  }
  
  public void setControl(CTControl paramCTControl) {
    synchronized (monitor()) {
      check_orphaned();
      CTControl cTControl = null;
      cTControl = (CTControl)get_store().find_element_user(CONTROL$2, 0);
      if (cTControl == null)
        cTControl = (CTControl)get_store().add_element_user(CONTROL$2); 
      cTControl.set((XmlObject)paramCTControl);
    } 
  }
  
  public CTControl addNewControl() {
    synchronized (monitor()) {
      check_orphaned();
      CTControl cTControl = null;
      cTControl = (CTControl)get_store().add_element_user(CONTROL$2);
      return cTControl;
    } 
  }
  
  public void unsetControl() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(CONTROL$2, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\impl\CTPictureImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */