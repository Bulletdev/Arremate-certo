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
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTDxf extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTDxf.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctdxfa3b1type");
  
  CTFont getFont();
  
  boolean isSetFont();
  
  void setFont(CTFont paramCTFont);
  
  CTFont addNewFont();
  
  void unsetFont();
  
  CTNumFmt getNumFmt();
  
  boolean isSetNumFmt();
  
  void setNumFmt(CTNumFmt paramCTNumFmt);
  
  CTNumFmt addNewNumFmt();
  
  void unsetNumFmt();
  
  CTFill getFill();
  
  boolean isSetFill();
  
  void setFill(CTFill paramCTFill);
  
  CTFill addNewFill();
  
  void unsetFill();
  
  CTCellAlignment getAlignment();
  
  boolean isSetAlignment();
  
  void setAlignment(CTCellAlignment paramCTCellAlignment);
  
  CTCellAlignment addNewAlignment();
  
  void unsetAlignment();
  
  CTBorder getBorder();
  
  boolean isSetBorder();
  
  void setBorder(CTBorder paramCTBorder);
  
  CTBorder addNewBorder();
  
  void unsetBorder();
  
  CTCellProtection getProtection();
  
  boolean isSetProtection();
  
  void setProtection(CTCellProtection paramCTCellProtection);
  
  CTCellProtection addNewProtection();
  
  void unsetProtection();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTDxf newInstance() {
      return (CTDxf)POIXMLTypeLoader.newInstance(CTDxf.type, null);
    }
    
    public static CTDxf newInstance(XmlOptions param1XmlOptions) {
      return (CTDxf)POIXMLTypeLoader.newInstance(CTDxf.type, param1XmlOptions);
    }
    
    public static CTDxf parse(String param1String) throws XmlException {
      return (CTDxf)POIXMLTypeLoader.parse(param1String, CTDxf.type, null);
    }
    
    public static CTDxf parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDxf)POIXMLTypeLoader.parse(param1String, CTDxf.type, param1XmlOptions);
    }
    
    public static CTDxf parse(File param1File) throws XmlException, IOException {
      return (CTDxf)POIXMLTypeLoader.parse(param1File, CTDxf.type, null);
    }
    
    public static CTDxf parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDxf)POIXMLTypeLoader.parse(param1File, CTDxf.type, param1XmlOptions);
    }
    
    public static CTDxf parse(URL param1URL) throws XmlException, IOException {
      return (CTDxf)POIXMLTypeLoader.parse(param1URL, CTDxf.type, null);
    }
    
    public static CTDxf parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDxf)POIXMLTypeLoader.parse(param1URL, CTDxf.type, param1XmlOptions);
    }
    
    public static CTDxf parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTDxf)POIXMLTypeLoader.parse(param1InputStream, CTDxf.type, null);
    }
    
    public static CTDxf parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDxf)POIXMLTypeLoader.parse(param1InputStream, CTDxf.type, param1XmlOptions);
    }
    
    public static CTDxf parse(Reader param1Reader) throws XmlException, IOException {
      return (CTDxf)POIXMLTypeLoader.parse(param1Reader, CTDxf.type, null);
    }
    
    public static CTDxf parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTDxf)POIXMLTypeLoader.parse(param1Reader, CTDxf.type, param1XmlOptions);
    }
    
    public static CTDxf parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTDxf)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDxf.type, null);
    }
    
    public static CTDxf parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDxf)POIXMLTypeLoader.parse(param1XMLStreamReader, CTDxf.type, param1XmlOptions);
    }
    
    public static CTDxf parse(Node param1Node) throws XmlException {
      return (CTDxf)POIXMLTypeLoader.parse(param1Node, CTDxf.type, null);
    }
    
    public static CTDxf parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTDxf)POIXMLTypeLoader.parse(param1Node, CTDxf.type, param1XmlOptions);
    }
    
    public static CTDxf parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTDxf)POIXMLTypeLoader.parse(param1XMLInputStream, CTDxf.type, null);
    }
    
    public static CTDxf parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTDxf)POIXMLTypeLoader.parse(param1XMLInputStream, CTDxf.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDxf.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTDxf.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTDxf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */