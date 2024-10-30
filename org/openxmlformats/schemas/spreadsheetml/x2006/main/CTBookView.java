package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTBookView extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTBookView.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctbookviewf677type");
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  STVisibility$Enum getVisibility();
  
  STVisibility xgetVisibility();
  
  boolean isSetVisibility();
  
  void setVisibility(STVisibility$Enum paramSTVisibility$Enum);
  
  void xsetVisibility(STVisibility paramSTVisibility);
  
  void unsetVisibility();
  
  boolean getMinimized();
  
  XmlBoolean xgetMinimized();
  
  boolean isSetMinimized();
  
  void setMinimized(boolean paramBoolean);
  
  void xsetMinimized(XmlBoolean paramXmlBoolean);
  
  void unsetMinimized();
  
  boolean getShowHorizontalScroll();
  
  XmlBoolean xgetShowHorizontalScroll();
  
  boolean isSetShowHorizontalScroll();
  
  void setShowHorizontalScroll(boolean paramBoolean);
  
  void xsetShowHorizontalScroll(XmlBoolean paramXmlBoolean);
  
  void unsetShowHorizontalScroll();
  
  boolean getShowVerticalScroll();
  
  XmlBoolean xgetShowVerticalScroll();
  
  boolean isSetShowVerticalScroll();
  
  void setShowVerticalScroll(boolean paramBoolean);
  
  void xsetShowVerticalScroll(XmlBoolean paramXmlBoolean);
  
  void unsetShowVerticalScroll();
  
  boolean getShowSheetTabs();
  
  XmlBoolean xgetShowSheetTabs();
  
  boolean isSetShowSheetTabs();
  
  void setShowSheetTabs(boolean paramBoolean);
  
  void xsetShowSheetTabs(XmlBoolean paramXmlBoolean);
  
  void unsetShowSheetTabs();
  
  int getXWindow();
  
  XmlInt xgetXWindow();
  
  boolean isSetXWindow();
  
  void setXWindow(int paramInt);
  
  void xsetXWindow(XmlInt paramXmlInt);
  
  void unsetXWindow();
  
  int getYWindow();
  
  XmlInt xgetYWindow();
  
  boolean isSetYWindow();
  
  void setYWindow(int paramInt);
  
  void xsetYWindow(XmlInt paramXmlInt);
  
  void unsetYWindow();
  
  long getWindowWidth();
  
  XmlUnsignedInt xgetWindowWidth();
  
  boolean isSetWindowWidth();
  
  void setWindowWidth(long paramLong);
  
  void xsetWindowWidth(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetWindowWidth();
  
  long getWindowHeight();
  
  XmlUnsignedInt xgetWindowHeight();
  
  boolean isSetWindowHeight();
  
  void setWindowHeight(long paramLong);
  
  void xsetWindowHeight(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetWindowHeight();
  
  long getTabRatio();
  
  XmlUnsignedInt xgetTabRatio();
  
  boolean isSetTabRatio();
  
  void setTabRatio(long paramLong);
  
  void xsetTabRatio(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetTabRatio();
  
  long getFirstSheet();
  
  XmlUnsignedInt xgetFirstSheet();
  
  boolean isSetFirstSheet();
  
  void setFirstSheet(long paramLong);
  
  void xsetFirstSheet(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetFirstSheet();
  
  long getActiveTab();
  
  XmlUnsignedInt xgetActiveTab();
  
  boolean isSetActiveTab();
  
  void setActiveTab(long paramLong);
  
  void xsetActiveTab(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetActiveTab();
  
  boolean getAutoFilterDateGrouping();
  
  XmlBoolean xgetAutoFilterDateGrouping();
  
  boolean isSetAutoFilterDateGrouping();
  
  void setAutoFilterDateGrouping(boolean paramBoolean);
  
  void xsetAutoFilterDateGrouping(XmlBoolean paramXmlBoolean);
  
  void unsetAutoFilterDateGrouping();
  
  public static final class Factory {
    public static CTBookView newInstance() {
      return (CTBookView)POIXMLTypeLoader.newInstance(CTBookView.type, null);
    }
    
    public static CTBookView newInstance(XmlOptions param1XmlOptions) {
      return (CTBookView)POIXMLTypeLoader.newInstance(CTBookView.type, param1XmlOptions);
    }
    
    public static CTBookView parse(String param1String) throws XmlException {
      return (CTBookView)POIXMLTypeLoader.parse(param1String, CTBookView.type, null);
    }
    
    public static CTBookView parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBookView)POIXMLTypeLoader.parse(param1String, CTBookView.type, param1XmlOptions);
    }
    
    public static CTBookView parse(File param1File) throws XmlException, IOException {
      return (CTBookView)POIXMLTypeLoader.parse(param1File, CTBookView.type, null);
    }
    
    public static CTBookView parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBookView)POIXMLTypeLoader.parse(param1File, CTBookView.type, param1XmlOptions);
    }
    
    public static CTBookView parse(URL param1URL) throws XmlException, IOException {
      return (CTBookView)POIXMLTypeLoader.parse(param1URL, CTBookView.type, null);
    }
    
    public static CTBookView parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBookView)POIXMLTypeLoader.parse(param1URL, CTBookView.type, param1XmlOptions);
    }
    
    public static CTBookView parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTBookView)POIXMLTypeLoader.parse(param1InputStream, CTBookView.type, null);
    }
    
    public static CTBookView parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBookView)POIXMLTypeLoader.parse(param1InputStream, CTBookView.type, param1XmlOptions);
    }
    
    public static CTBookView parse(Reader param1Reader) throws XmlException, IOException {
      return (CTBookView)POIXMLTypeLoader.parse(param1Reader, CTBookView.type, null);
    }
    
    public static CTBookView parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBookView)POIXMLTypeLoader.parse(param1Reader, CTBookView.type, param1XmlOptions);
    }
    
    public static CTBookView parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTBookView)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBookView.type, null);
    }
    
    public static CTBookView parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBookView)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBookView.type, param1XmlOptions);
    }
    
    public static CTBookView parse(Node param1Node) throws XmlException {
      return (CTBookView)POIXMLTypeLoader.parse(param1Node, CTBookView.type, null);
    }
    
    public static CTBookView parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBookView)POIXMLTypeLoader.parse(param1Node, CTBookView.type, param1XmlOptions);
    }
    
    public static CTBookView parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTBookView)POIXMLTypeLoader.parse(param1XMLInputStream, CTBookView.type, null);
    }
    
    public static CTBookView parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTBookView)POIXMLTypeLoader.parse(param1XMLInputStream, CTBookView.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBookView.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBookView.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTBookView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */