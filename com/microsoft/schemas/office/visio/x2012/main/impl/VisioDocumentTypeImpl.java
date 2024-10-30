package com.microsoft.schemas.office.visio.x2012.main.impl;

import com.microsoft.schemas.office.visio.x2012.main.ColorsType;
import com.microsoft.schemas.office.visio.x2012.main.DocumentSettingsType;
import com.microsoft.schemas.office.visio.x2012.main.DocumentSheetType;
import com.microsoft.schemas.office.visio.x2012.main.EventListType;
import com.microsoft.schemas.office.visio.x2012.main.FaceNamesType;
import com.microsoft.schemas.office.visio.x2012.main.HeaderFooterType;
import com.microsoft.schemas.office.visio.x2012.main.PublishSettingsType;
import com.microsoft.schemas.office.visio.x2012.main.StyleSheetsType;
import com.microsoft.schemas.office.visio.x2012.main.VisioDocumentType;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class VisioDocumentTypeImpl extends XmlComplexContentImpl implements VisioDocumentType {
  private static final b DOCUMENTSETTINGS$0 = new b("http://schemas.microsoft.com/office/visio/2012/main", "DocumentSettings");
  
  private static final b COLORS$2 = new b("http://schemas.microsoft.com/office/visio/2012/main", "Colors");
  
  private static final b FACENAMES$4 = new b("http://schemas.microsoft.com/office/visio/2012/main", "FaceNames");
  
  private static final b STYLESHEETS$6 = new b("http://schemas.microsoft.com/office/visio/2012/main", "StyleSheets");
  
  private static final b DOCUMENTSHEET$8 = new b("http://schemas.microsoft.com/office/visio/2012/main", "DocumentSheet");
  
  private static final b EVENTLIST$10 = new b("http://schemas.microsoft.com/office/visio/2012/main", "EventList");
  
  private static final b HEADERFOOTER$12 = new b("http://schemas.microsoft.com/office/visio/2012/main", "HeaderFooter");
  
  private static final b PUBLISHSETTINGS$14 = new b("http://schemas.microsoft.com/office/visio/2012/main", "PublishSettings");
  
  public VisioDocumentTypeImpl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public DocumentSettingsType getDocumentSettings() {
    synchronized (monitor()) {
      check_orphaned();
      DocumentSettingsType documentSettingsType = null;
      documentSettingsType = (DocumentSettingsType)get_store().find_element_user(DOCUMENTSETTINGS$0, 0);
      if (documentSettingsType == null)
        return null; 
      return documentSettingsType;
    } 
  }
  
  public boolean isSetDocumentSettings() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DOCUMENTSETTINGS$0) != 0);
    } 
  }
  
  public void setDocumentSettings(DocumentSettingsType paramDocumentSettingsType) {
    synchronized (monitor()) {
      check_orphaned();
      DocumentSettingsType documentSettingsType = null;
      documentSettingsType = (DocumentSettingsType)get_store().find_element_user(DOCUMENTSETTINGS$0, 0);
      if (documentSettingsType == null)
        documentSettingsType = (DocumentSettingsType)get_store().add_element_user(DOCUMENTSETTINGS$0); 
      documentSettingsType.set((XmlObject)paramDocumentSettingsType);
    } 
  }
  
  public DocumentSettingsType addNewDocumentSettings() {
    synchronized (monitor()) {
      check_orphaned();
      DocumentSettingsType documentSettingsType = null;
      documentSettingsType = (DocumentSettingsType)get_store().add_element_user(DOCUMENTSETTINGS$0);
      return documentSettingsType;
    } 
  }
  
  public void unsetDocumentSettings() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DOCUMENTSETTINGS$0, 0);
    } 
  }
  
  public ColorsType getColors() {
    synchronized (monitor()) {
      check_orphaned();
      ColorsType colorsType = null;
      colorsType = (ColorsType)get_store().find_element_user(COLORS$2, 0);
      if (colorsType == null)
        return null; 
      return colorsType;
    } 
  }
  
  public boolean isSetColors() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(COLORS$2) != 0);
    } 
  }
  
  public void setColors(ColorsType paramColorsType) {
    synchronized (monitor()) {
      check_orphaned();
      ColorsType colorsType = null;
      colorsType = (ColorsType)get_store().find_element_user(COLORS$2, 0);
      if (colorsType == null)
        colorsType = (ColorsType)get_store().add_element_user(COLORS$2); 
      colorsType.set((XmlObject)paramColorsType);
    } 
  }
  
  public ColorsType addNewColors() {
    synchronized (monitor()) {
      check_orphaned();
      ColorsType colorsType = null;
      colorsType = (ColorsType)get_store().add_element_user(COLORS$2);
      return colorsType;
    } 
  }
  
  public void unsetColors() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(COLORS$2, 0);
    } 
  }
  
  public FaceNamesType getFaceNames() {
    synchronized (monitor()) {
      check_orphaned();
      FaceNamesType faceNamesType = null;
      faceNamesType = (FaceNamesType)get_store().find_element_user(FACENAMES$4, 0);
      if (faceNamesType == null)
        return null; 
      return faceNamesType;
    } 
  }
  
  public boolean isSetFaceNames() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(FACENAMES$4) != 0);
    } 
  }
  
  public void setFaceNames(FaceNamesType paramFaceNamesType) {
    synchronized (monitor()) {
      check_orphaned();
      FaceNamesType faceNamesType = null;
      faceNamesType = (FaceNamesType)get_store().find_element_user(FACENAMES$4, 0);
      if (faceNamesType == null)
        faceNamesType = (FaceNamesType)get_store().add_element_user(FACENAMES$4); 
      faceNamesType.set((XmlObject)paramFaceNamesType);
    } 
  }
  
  public FaceNamesType addNewFaceNames() {
    synchronized (monitor()) {
      check_orphaned();
      FaceNamesType faceNamesType = null;
      faceNamesType = (FaceNamesType)get_store().add_element_user(FACENAMES$4);
      return faceNamesType;
    } 
  }
  
  public void unsetFaceNames() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(FACENAMES$4, 0);
    } 
  }
  
  public StyleSheetsType getStyleSheets() {
    synchronized (monitor()) {
      check_orphaned();
      StyleSheetsType styleSheetsType = null;
      styleSheetsType = (StyleSheetsType)get_store().find_element_user(STYLESHEETS$6, 0);
      if (styleSheetsType == null)
        return null; 
      return styleSheetsType;
    } 
  }
  
  public boolean isSetStyleSheets() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(STYLESHEETS$6) != 0);
    } 
  }
  
  public void setStyleSheets(StyleSheetsType paramStyleSheetsType) {
    synchronized (monitor()) {
      check_orphaned();
      StyleSheetsType styleSheetsType = null;
      styleSheetsType = (StyleSheetsType)get_store().find_element_user(STYLESHEETS$6, 0);
      if (styleSheetsType == null)
        styleSheetsType = (StyleSheetsType)get_store().add_element_user(STYLESHEETS$6); 
      styleSheetsType.set((XmlObject)paramStyleSheetsType);
    } 
  }
  
  public StyleSheetsType addNewStyleSheets() {
    synchronized (monitor()) {
      check_orphaned();
      StyleSheetsType styleSheetsType = null;
      styleSheetsType = (StyleSheetsType)get_store().add_element_user(STYLESHEETS$6);
      return styleSheetsType;
    } 
  }
  
  public void unsetStyleSheets() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(STYLESHEETS$6, 0);
    } 
  }
  
  public DocumentSheetType getDocumentSheet() {
    synchronized (monitor()) {
      check_orphaned();
      DocumentSheetType documentSheetType = null;
      documentSheetType = (DocumentSheetType)get_store().find_element_user(DOCUMENTSHEET$8, 0);
      if (documentSheetType == null)
        return null; 
      return documentSheetType;
    } 
  }
  
  public boolean isSetDocumentSheet() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DOCUMENTSHEET$8) != 0);
    } 
  }
  
  public void setDocumentSheet(DocumentSheetType paramDocumentSheetType) {
    synchronized (monitor()) {
      check_orphaned();
      DocumentSheetType documentSheetType = null;
      documentSheetType = (DocumentSheetType)get_store().find_element_user(DOCUMENTSHEET$8, 0);
      if (documentSheetType == null)
        documentSheetType = (DocumentSheetType)get_store().add_element_user(DOCUMENTSHEET$8); 
      documentSheetType.set((XmlObject)paramDocumentSheetType);
    } 
  }
  
  public DocumentSheetType addNewDocumentSheet() {
    synchronized (monitor()) {
      check_orphaned();
      DocumentSheetType documentSheetType = null;
      documentSheetType = (DocumentSheetType)get_store().add_element_user(DOCUMENTSHEET$8);
      return documentSheetType;
    } 
  }
  
  public void unsetDocumentSheet() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DOCUMENTSHEET$8, 0);
    } 
  }
  
  public EventListType getEventList() {
    synchronized (monitor()) {
      check_orphaned();
      EventListType eventListType = null;
      eventListType = (EventListType)get_store().find_element_user(EVENTLIST$10, 0);
      if (eventListType == null)
        return null; 
      return eventListType;
    } 
  }
  
  public boolean isSetEventList() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(EVENTLIST$10) != 0);
    } 
  }
  
  public void setEventList(EventListType paramEventListType) {
    synchronized (monitor()) {
      check_orphaned();
      EventListType eventListType = null;
      eventListType = (EventListType)get_store().find_element_user(EVENTLIST$10, 0);
      if (eventListType == null)
        eventListType = (EventListType)get_store().add_element_user(EVENTLIST$10); 
      eventListType.set((XmlObject)paramEventListType);
    } 
  }
  
  public EventListType addNewEventList() {
    synchronized (monitor()) {
      check_orphaned();
      EventListType eventListType = null;
      eventListType = (EventListType)get_store().add_element_user(EVENTLIST$10);
      return eventListType;
    } 
  }
  
  public void unsetEventList() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(EVENTLIST$10, 0);
    } 
  }
  
  public HeaderFooterType getHeaderFooter() {
    synchronized (monitor()) {
      check_orphaned();
      HeaderFooterType headerFooterType = null;
      headerFooterType = (HeaderFooterType)get_store().find_element_user(HEADERFOOTER$12, 0);
      if (headerFooterType == null)
        return null; 
      return headerFooterType;
    } 
  }
  
  public boolean isSetHeaderFooter() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(HEADERFOOTER$12) != 0);
    } 
  }
  
  public void setHeaderFooter(HeaderFooterType paramHeaderFooterType) {
    synchronized (monitor()) {
      check_orphaned();
      HeaderFooterType headerFooterType = null;
      headerFooterType = (HeaderFooterType)get_store().find_element_user(HEADERFOOTER$12, 0);
      if (headerFooterType == null)
        headerFooterType = (HeaderFooterType)get_store().add_element_user(HEADERFOOTER$12); 
      headerFooterType.set((XmlObject)paramHeaderFooterType);
    } 
  }
  
  public HeaderFooterType addNewHeaderFooter() {
    synchronized (monitor()) {
      check_orphaned();
      HeaderFooterType headerFooterType = null;
      headerFooterType = (HeaderFooterType)get_store().add_element_user(HEADERFOOTER$12);
      return headerFooterType;
    } 
  }
  
  public void unsetHeaderFooter() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(HEADERFOOTER$12, 0);
    } 
  }
  
  public PublishSettingsType getPublishSettings() {
    synchronized (monitor()) {
      check_orphaned();
      PublishSettingsType publishSettingsType = null;
      publishSettingsType = (PublishSettingsType)get_store().find_element_user(PUBLISHSETTINGS$14, 0);
      if (publishSettingsType == null)
        return null; 
      return publishSettingsType;
    } 
  }
  
  public boolean isSetPublishSettings() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(PUBLISHSETTINGS$14) != 0);
    } 
  }
  
  public void setPublishSettings(PublishSettingsType paramPublishSettingsType) {
    synchronized (monitor()) {
      check_orphaned();
      PublishSettingsType publishSettingsType = null;
      publishSettingsType = (PublishSettingsType)get_store().find_element_user(PUBLISHSETTINGS$14, 0);
      if (publishSettingsType == null)
        publishSettingsType = (PublishSettingsType)get_store().add_element_user(PUBLISHSETTINGS$14); 
      publishSettingsType.set((XmlObject)paramPublishSettingsType);
    } 
  }
  
  public PublishSettingsType addNewPublishSettings() {
    synchronized (monitor()) {
      check_orphaned();
      PublishSettingsType publishSettingsType = null;
      publishSettingsType = (PublishSettingsType)get_store().add_element_user(PUBLISHSETTINGS$14);
      return publishSettingsType;
    } 
  }
  
  public void unsetPublishSettings() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(PUBLISHSETTINGS$14, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\impl\VisioDocumentTypeImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */