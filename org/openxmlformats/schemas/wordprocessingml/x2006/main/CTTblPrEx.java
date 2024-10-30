package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTTblPrEx extends CTTblPrExBase {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTblPrEx.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttblprex863ftype");
  
  CTTblPrExChange getTblPrExChange();
  
  boolean isSetTblPrExChange();
  
  void setTblPrExChange(CTTblPrExChange paramCTTblPrExChange);
  
  CTTblPrExChange addNewTblPrExChange();
  
  void unsetTblPrExChange();
  
  public static final class Factory {
    public static CTTblPrEx newInstance() {
      return (CTTblPrEx)POIXMLTypeLoader.newInstance(CTTblPrEx.type, null);
    }
    
    public static CTTblPrEx newInstance(XmlOptions param1XmlOptions) {
      return (CTTblPrEx)POIXMLTypeLoader.newInstance(CTTblPrEx.type, param1XmlOptions);
    }
    
    public static CTTblPrEx parse(String param1String) throws XmlException {
      return (CTTblPrEx)POIXMLTypeLoader.parse(param1String, CTTblPrEx.type, null);
    }
    
    public static CTTblPrEx parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTblPrEx)POIXMLTypeLoader.parse(param1String, CTTblPrEx.type, param1XmlOptions);
    }
    
    public static CTTblPrEx parse(File param1File) throws XmlException, IOException {
      return (CTTblPrEx)POIXMLTypeLoader.parse(param1File, CTTblPrEx.type, null);
    }
    
    public static CTTblPrEx parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblPrEx)POIXMLTypeLoader.parse(param1File, CTTblPrEx.type, param1XmlOptions);
    }
    
    public static CTTblPrEx parse(URL param1URL) throws XmlException, IOException {
      return (CTTblPrEx)POIXMLTypeLoader.parse(param1URL, CTTblPrEx.type, null);
    }
    
    public static CTTblPrEx parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblPrEx)POIXMLTypeLoader.parse(param1URL, CTTblPrEx.type, param1XmlOptions);
    }
    
    public static CTTblPrEx parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTblPrEx)POIXMLTypeLoader.parse(param1InputStream, CTTblPrEx.type, null);
    }
    
    public static CTTblPrEx parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblPrEx)POIXMLTypeLoader.parse(param1InputStream, CTTblPrEx.type, param1XmlOptions);
    }
    
    public static CTTblPrEx parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTblPrEx)POIXMLTypeLoader.parse(param1Reader, CTTblPrEx.type, null);
    }
    
    public static CTTblPrEx parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblPrEx)POIXMLTypeLoader.parse(param1Reader, CTTblPrEx.type, param1XmlOptions);
    }
    
    public static CTTblPrEx parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTblPrEx)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTblPrEx.type, null);
    }
    
    public static CTTblPrEx parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTblPrEx)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTblPrEx.type, param1XmlOptions);
    }
    
    public static CTTblPrEx parse(Node param1Node) throws XmlException {
      return (CTTblPrEx)POIXMLTypeLoader.parse(param1Node, CTTblPrEx.type, null);
    }
    
    public static CTTblPrEx parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTblPrEx)POIXMLTypeLoader.parse(param1Node, CTTblPrEx.type, param1XmlOptions);
    }
    
    public static CTTblPrEx parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTblPrEx)POIXMLTypeLoader.parse(param1XMLInputStream, CTTblPrEx.type, null);
    }
    
    public static CTTblPrEx parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTblPrEx)POIXMLTypeLoader.parse(param1XMLInputStream, CTTblPrEx.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTblPrEx.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTblPrEx.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTTblPrEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */