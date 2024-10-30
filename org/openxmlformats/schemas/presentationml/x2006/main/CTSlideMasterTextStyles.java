package org.openxmlformats.schemas.presentationml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextListStyle;
import org.w3c.dom.Node;

public interface CTSlideMasterTextStyles extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSlideMasterTextStyles.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctslidemastertextstylesb48dtype");
  
  CTTextListStyle getTitleStyle();
  
  boolean isSetTitleStyle();
  
  void setTitleStyle(CTTextListStyle paramCTTextListStyle);
  
  CTTextListStyle addNewTitleStyle();
  
  void unsetTitleStyle();
  
  CTTextListStyle getBodyStyle();
  
  boolean isSetBodyStyle();
  
  void setBodyStyle(CTTextListStyle paramCTTextListStyle);
  
  CTTextListStyle addNewBodyStyle();
  
  void unsetBodyStyle();
  
  CTTextListStyle getOtherStyle();
  
  boolean isSetOtherStyle();
  
  void setOtherStyle(CTTextListStyle paramCTTextListStyle);
  
  CTTextListStyle addNewOtherStyle();
  
  void unsetOtherStyle();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTSlideMasterTextStyles newInstance() {
      return (CTSlideMasterTextStyles)POIXMLTypeLoader.newInstance(CTSlideMasterTextStyles.type, null);
    }
    
    public static CTSlideMasterTextStyles newInstance(XmlOptions param1XmlOptions) {
      return (CTSlideMasterTextStyles)POIXMLTypeLoader.newInstance(CTSlideMasterTextStyles.type, param1XmlOptions);
    }
    
    public static CTSlideMasterTextStyles parse(String param1String) throws XmlException {
      return (CTSlideMasterTextStyles)POIXMLTypeLoader.parse(param1String, CTSlideMasterTextStyles.type, null);
    }
    
    public static CTSlideMasterTextStyles parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSlideMasterTextStyles)POIXMLTypeLoader.parse(param1String, CTSlideMasterTextStyles.type, param1XmlOptions);
    }
    
    public static CTSlideMasterTextStyles parse(File param1File) throws XmlException, IOException {
      return (CTSlideMasterTextStyles)POIXMLTypeLoader.parse(param1File, CTSlideMasterTextStyles.type, null);
    }
    
    public static CTSlideMasterTextStyles parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideMasterTextStyles)POIXMLTypeLoader.parse(param1File, CTSlideMasterTextStyles.type, param1XmlOptions);
    }
    
    public static CTSlideMasterTextStyles parse(URL param1URL) throws XmlException, IOException {
      return (CTSlideMasterTextStyles)POIXMLTypeLoader.parse(param1URL, CTSlideMasterTextStyles.type, null);
    }
    
    public static CTSlideMasterTextStyles parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideMasterTextStyles)POIXMLTypeLoader.parse(param1URL, CTSlideMasterTextStyles.type, param1XmlOptions);
    }
    
    public static CTSlideMasterTextStyles parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSlideMasterTextStyles)POIXMLTypeLoader.parse(param1InputStream, CTSlideMasterTextStyles.type, null);
    }
    
    public static CTSlideMasterTextStyles parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideMasterTextStyles)POIXMLTypeLoader.parse(param1InputStream, CTSlideMasterTextStyles.type, param1XmlOptions);
    }
    
    public static CTSlideMasterTextStyles parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSlideMasterTextStyles)POIXMLTypeLoader.parse(param1Reader, CTSlideMasterTextStyles.type, null);
    }
    
    public static CTSlideMasterTextStyles parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSlideMasterTextStyles)POIXMLTypeLoader.parse(param1Reader, CTSlideMasterTextStyles.type, param1XmlOptions);
    }
    
    public static CTSlideMasterTextStyles parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSlideMasterTextStyles)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSlideMasterTextStyles.type, null);
    }
    
    public static CTSlideMasterTextStyles parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSlideMasterTextStyles)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSlideMasterTextStyles.type, param1XmlOptions);
    }
    
    public static CTSlideMasterTextStyles parse(Node param1Node) throws XmlException {
      return (CTSlideMasterTextStyles)POIXMLTypeLoader.parse(param1Node, CTSlideMasterTextStyles.type, null);
    }
    
    public static CTSlideMasterTextStyles parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSlideMasterTextStyles)POIXMLTypeLoader.parse(param1Node, CTSlideMasterTextStyles.type, param1XmlOptions);
    }
    
    public static CTSlideMasterTextStyles parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSlideMasterTextStyles)POIXMLTypeLoader.parse(param1XMLInputStream, CTSlideMasterTextStyles.type, null);
    }
    
    public static CTSlideMasterTextStyles parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSlideMasterTextStyles)POIXMLTypeLoader.parse(param1XMLInputStream, CTSlideMasterTextStyles.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSlideMasterTextStyles.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSlideMasterTextStyles.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CTSlideMasterTextStyles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */