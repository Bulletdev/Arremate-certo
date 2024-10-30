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

public interface CTExternalLink extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTExternalLink.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctexternallink966etype");
  
  CTExternalBook getExternalBook();
  
  boolean isSetExternalBook();
  
  void setExternalBook(CTExternalBook paramCTExternalBook);
  
  CTExternalBook addNewExternalBook();
  
  void unsetExternalBook();
  
  CTDdeLink getDdeLink();
  
  boolean isSetDdeLink();
  
  void setDdeLink(CTDdeLink paramCTDdeLink);
  
  CTDdeLink addNewDdeLink();
  
  void unsetDdeLink();
  
  CTOleLink getOleLink();
  
  boolean isSetOleLink();
  
  void setOleLink(CTOleLink paramCTOleLink);
  
  CTOleLink addNewOleLink();
  
  void unsetOleLink();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTExternalLink newInstance() {
      return (CTExternalLink)POIXMLTypeLoader.newInstance(CTExternalLink.type, null);
    }
    
    public static CTExternalLink newInstance(XmlOptions param1XmlOptions) {
      return (CTExternalLink)POIXMLTypeLoader.newInstance(CTExternalLink.type, param1XmlOptions);
    }
    
    public static CTExternalLink parse(String param1String) throws XmlException {
      return (CTExternalLink)POIXMLTypeLoader.parse(param1String, CTExternalLink.type, null);
    }
    
    public static CTExternalLink parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTExternalLink)POIXMLTypeLoader.parse(param1String, CTExternalLink.type, param1XmlOptions);
    }
    
    public static CTExternalLink parse(File param1File) throws XmlException, IOException {
      return (CTExternalLink)POIXMLTypeLoader.parse(param1File, CTExternalLink.type, null);
    }
    
    public static CTExternalLink parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTExternalLink)POIXMLTypeLoader.parse(param1File, CTExternalLink.type, param1XmlOptions);
    }
    
    public static CTExternalLink parse(URL param1URL) throws XmlException, IOException {
      return (CTExternalLink)POIXMLTypeLoader.parse(param1URL, CTExternalLink.type, null);
    }
    
    public static CTExternalLink parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTExternalLink)POIXMLTypeLoader.parse(param1URL, CTExternalLink.type, param1XmlOptions);
    }
    
    public static CTExternalLink parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTExternalLink)POIXMLTypeLoader.parse(param1InputStream, CTExternalLink.type, null);
    }
    
    public static CTExternalLink parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTExternalLink)POIXMLTypeLoader.parse(param1InputStream, CTExternalLink.type, param1XmlOptions);
    }
    
    public static CTExternalLink parse(Reader param1Reader) throws XmlException, IOException {
      return (CTExternalLink)POIXMLTypeLoader.parse(param1Reader, CTExternalLink.type, null);
    }
    
    public static CTExternalLink parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTExternalLink)POIXMLTypeLoader.parse(param1Reader, CTExternalLink.type, param1XmlOptions);
    }
    
    public static CTExternalLink parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTExternalLink)POIXMLTypeLoader.parse(param1XMLStreamReader, CTExternalLink.type, null);
    }
    
    public static CTExternalLink parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTExternalLink)POIXMLTypeLoader.parse(param1XMLStreamReader, CTExternalLink.type, param1XmlOptions);
    }
    
    public static CTExternalLink parse(Node param1Node) throws XmlException {
      return (CTExternalLink)POIXMLTypeLoader.parse(param1Node, CTExternalLink.type, null);
    }
    
    public static CTExternalLink parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTExternalLink)POIXMLTypeLoader.parse(param1Node, CTExternalLink.type, param1XmlOptions);
    }
    
    public static CTExternalLink parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTExternalLink)POIXMLTypeLoader.parse(param1XMLInputStream, CTExternalLink.type, null);
    }
    
    public static CTExternalLink parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTExternalLink)POIXMLTypeLoader.parse(param1XMLInputStream, CTExternalLink.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTExternalLink.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTExternalLink.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTExternalLink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */