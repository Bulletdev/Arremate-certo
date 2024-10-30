package com.microsoft.schemas.office.visio.x2012.main;

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
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface PageType extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(PageType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("pagetype2fcatype");
  
  PageSheetType getPageSheet();
  
  boolean isSetPageSheet();
  
  void setPageSheet(PageSheetType paramPageSheetType);
  
  PageSheetType addNewPageSheet();
  
  void unsetPageSheet();
  
  RelType getRel();
  
  void setRel(RelType paramRelType);
  
  RelType addNewRel();
  
  long getID();
  
  XmlUnsignedInt xgetID();
  
  void setID(long paramLong);
  
  void xsetID(XmlUnsignedInt paramXmlUnsignedInt);
  
  String getName();
  
  XmlString xgetName();
  
  boolean isSetName();
  
  void setName(String paramString);
  
  void xsetName(XmlString paramXmlString);
  
  void unsetName();
  
  String getNameU();
  
  XmlString xgetNameU();
  
  boolean isSetNameU();
  
  void setNameU(String paramString);
  
  void xsetNameU(XmlString paramXmlString);
  
  void unsetNameU();
  
  boolean getIsCustomName();
  
  XmlBoolean xgetIsCustomName();
  
  boolean isSetIsCustomName();
  
  void setIsCustomName(boolean paramBoolean);
  
  void xsetIsCustomName(XmlBoolean paramXmlBoolean);
  
  void unsetIsCustomName();
  
  boolean getIsCustomNameU();
  
  XmlBoolean xgetIsCustomNameU();
  
  boolean isSetIsCustomNameU();
  
  void setIsCustomNameU(boolean paramBoolean);
  
  void xsetIsCustomNameU(XmlBoolean paramXmlBoolean);
  
  void unsetIsCustomNameU();
  
  boolean getBackground();
  
  XmlBoolean xgetBackground();
  
  boolean isSetBackground();
  
  void setBackground(boolean paramBoolean);
  
  void xsetBackground(XmlBoolean paramXmlBoolean);
  
  void unsetBackground();
  
  long getBackPage();
  
  XmlUnsignedInt xgetBackPage();
  
  boolean isSetBackPage();
  
  void setBackPage(long paramLong);
  
  void xsetBackPage(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetBackPage();
  
  double getViewScale();
  
  XmlDouble xgetViewScale();
  
  boolean isSetViewScale();
  
  void setViewScale(double paramDouble);
  
  void xsetViewScale(XmlDouble paramXmlDouble);
  
  void unsetViewScale();
  
  double getViewCenterX();
  
  XmlDouble xgetViewCenterX();
  
  boolean isSetViewCenterX();
  
  void setViewCenterX(double paramDouble);
  
  void xsetViewCenterX(XmlDouble paramXmlDouble);
  
  void unsetViewCenterX();
  
  double getViewCenterY();
  
  XmlDouble xgetViewCenterY();
  
  boolean isSetViewCenterY();
  
  void setViewCenterY(double paramDouble);
  
  void xsetViewCenterY(XmlDouble paramXmlDouble);
  
  void unsetViewCenterY();
  
  long getReviewerID();
  
  XmlUnsignedInt xgetReviewerID();
  
  boolean isSetReviewerID();
  
  void setReviewerID(long paramLong);
  
  void xsetReviewerID(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetReviewerID();
  
  long getAssociatedPage();
  
  XmlUnsignedInt xgetAssociatedPage();
  
  boolean isSetAssociatedPage();
  
  void setAssociatedPage(long paramLong);
  
  void xsetAssociatedPage(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetAssociatedPage();
  
  public static final class Factory {
    public static PageType newInstance() {
      return (PageType)POIXMLTypeLoader.newInstance(PageType.type, null);
    }
    
    public static PageType newInstance(XmlOptions param1XmlOptions) {
      return (PageType)POIXMLTypeLoader.newInstance(PageType.type, param1XmlOptions);
    }
    
    public static PageType parse(String param1String) throws XmlException {
      return (PageType)POIXMLTypeLoader.parse(param1String, PageType.type, null);
    }
    
    public static PageType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (PageType)POIXMLTypeLoader.parse(param1String, PageType.type, param1XmlOptions);
    }
    
    public static PageType parse(File param1File) throws XmlException, IOException {
      return (PageType)POIXMLTypeLoader.parse(param1File, PageType.type, null);
    }
    
    public static PageType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PageType)POIXMLTypeLoader.parse(param1File, PageType.type, param1XmlOptions);
    }
    
    public static PageType parse(URL param1URL) throws XmlException, IOException {
      return (PageType)POIXMLTypeLoader.parse(param1URL, PageType.type, null);
    }
    
    public static PageType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PageType)POIXMLTypeLoader.parse(param1URL, PageType.type, param1XmlOptions);
    }
    
    public static PageType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (PageType)POIXMLTypeLoader.parse(param1InputStream, PageType.type, null);
    }
    
    public static PageType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PageType)POIXMLTypeLoader.parse(param1InputStream, PageType.type, param1XmlOptions);
    }
    
    public static PageType parse(Reader param1Reader) throws XmlException, IOException {
      return (PageType)POIXMLTypeLoader.parse(param1Reader, PageType.type, null);
    }
    
    public static PageType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (PageType)POIXMLTypeLoader.parse(param1Reader, PageType.type, param1XmlOptions);
    }
    
    public static PageType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (PageType)POIXMLTypeLoader.parse(param1XMLStreamReader, PageType.type, null);
    }
    
    public static PageType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (PageType)POIXMLTypeLoader.parse(param1XMLStreamReader, PageType.type, param1XmlOptions);
    }
    
    public static PageType parse(Node param1Node) throws XmlException {
      return (PageType)POIXMLTypeLoader.parse(param1Node, PageType.type, null);
    }
    
    public static PageType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (PageType)POIXMLTypeLoader.parse(param1Node, PageType.type, param1XmlOptions);
    }
    
    public static PageType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (PageType)POIXMLTypeLoader.parse(param1XMLInputStream, PageType.type, null);
    }
    
    public static PageType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (PageType)POIXMLTypeLoader.parse(param1XMLInputStream, PageType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, PageType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, PageType.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\PageType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */