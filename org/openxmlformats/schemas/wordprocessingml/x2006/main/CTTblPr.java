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

public interface CTTblPr extends CTTblPrBase {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTTblPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("cttblpr5b72type");
  
  CTTblPrChange getTblPrChange();
  
  boolean isSetTblPrChange();
  
  void setTblPrChange(CTTblPrChange paramCTTblPrChange);
  
  CTTblPrChange addNewTblPrChange();
  
  void unsetTblPrChange();
  
  public static final class Factory {
    public static CTTblPr newInstance() {
      return (CTTblPr)POIXMLTypeLoader.newInstance(CTTblPr.type, null);
    }
    
    public static CTTblPr newInstance(XmlOptions param1XmlOptions) {
      return (CTTblPr)POIXMLTypeLoader.newInstance(CTTblPr.type, param1XmlOptions);
    }
    
    public static CTTblPr parse(String param1String) throws XmlException {
      return (CTTblPr)POIXMLTypeLoader.parse(param1String, CTTblPr.type, null);
    }
    
    public static CTTblPr parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTblPr)POIXMLTypeLoader.parse(param1String, CTTblPr.type, param1XmlOptions);
    }
    
    public static CTTblPr parse(File param1File) throws XmlException, IOException {
      return (CTTblPr)POIXMLTypeLoader.parse(param1File, CTTblPr.type, null);
    }
    
    public static CTTblPr parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblPr)POIXMLTypeLoader.parse(param1File, CTTblPr.type, param1XmlOptions);
    }
    
    public static CTTblPr parse(URL param1URL) throws XmlException, IOException {
      return (CTTblPr)POIXMLTypeLoader.parse(param1URL, CTTblPr.type, null);
    }
    
    public static CTTblPr parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblPr)POIXMLTypeLoader.parse(param1URL, CTTblPr.type, param1XmlOptions);
    }
    
    public static CTTblPr parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTTblPr)POIXMLTypeLoader.parse(param1InputStream, CTTblPr.type, null);
    }
    
    public static CTTblPr parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblPr)POIXMLTypeLoader.parse(param1InputStream, CTTblPr.type, param1XmlOptions);
    }
    
    public static CTTblPr parse(Reader param1Reader) throws XmlException, IOException {
      return (CTTblPr)POIXMLTypeLoader.parse(param1Reader, CTTblPr.type, null);
    }
    
    public static CTTblPr parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTTblPr)POIXMLTypeLoader.parse(param1Reader, CTTblPr.type, param1XmlOptions);
    }
    
    public static CTTblPr parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTTblPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTblPr.type, null);
    }
    
    public static CTTblPr parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTblPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTTblPr.type, param1XmlOptions);
    }
    
    public static CTTblPr parse(Node param1Node) throws XmlException {
      return (CTTblPr)POIXMLTypeLoader.parse(param1Node, CTTblPr.type, null);
    }
    
    public static CTTblPr parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTTblPr)POIXMLTypeLoader.parse(param1Node, CTTblPr.type, param1XmlOptions);
    }
    
    public static CTTblPr parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTTblPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTTblPr.type, null);
    }
    
    public static CTTblPr parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTTblPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTTblPr.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTblPr.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTTblPr.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTTblPr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */