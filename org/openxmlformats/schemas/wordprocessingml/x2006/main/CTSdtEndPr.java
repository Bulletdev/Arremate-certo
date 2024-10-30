package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
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

public interface CTSdtEndPr extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSdtEndPr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctsdtendprbc6etype");
  
  List<CTRPr> getRPrList();
  
  CTRPr[] getRPrArray();
  
  CTRPr getRPrArray(int paramInt);
  
  int sizeOfRPrArray();
  
  void setRPrArray(CTRPr[] paramArrayOfCTRPr);
  
  void setRPrArray(int paramInt, CTRPr paramCTRPr);
  
  CTRPr insertNewRPr(int paramInt);
  
  CTRPr addNewRPr();
  
  void removeRPr(int paramInt);
  
  public static final class Factory {
    public static CTSdtEndPr newInstance() {
      return (CTSdtEndPr)POIXMLTypeLoader.newInstance(CTSdtEndPr.type, null);
    }
    
    public static CTSdtEndPr newInstance(XmlOptions param1XmlOptions) {
      return (CTSdtEndPr)POIXMLTypeLoader.newInstance(CTSdtEndPr.type, param1XmlOptions);
    }
    
    public static CTSdtEndPr parse(String param1String) throws XmlException {
      return (CTSdtEndPr)POIXMLTypeLoader.parse(param1String, CTSdtEndPr.type, null);
    }
    
    public static CTSdtEndPr parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSdtEndPr)POIXMLTypeLoader.parse(param1String, CTSdtEndPr.type, param1XmlOptions);
    }
    
    public static CTSdtEndPr parse(File param1File) throws XmlException, IOException {
      return (CTSdtEndPr)POIXMLTypeLoader.parse(param1File, CTSdtEndPr.type, null);
    }
    
    public static CTSdtEndPr parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSdtEndPr)POIXMLTypeLoader.parse(param1File, CTSdtEndPr.type, param1XmlOptions);
    }
    
    public static CTSdtEndPr parse(URL param1URL) throws XmlException, IOException {
      return (CTSdtEndPr)POIXMLTypeLoader.parse(param1URL, CTSdtEndPr.type, null);
    }
    
    public static CTSdtEndPr parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSdtEndPr)POIXMLTypeLoader.parse(param1URL, CTSdtEndPr.type, param1XmlOptions);
    }
    
    public static CTSdtEndPr parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSdtEndPr)POIXMLTypeLoader.parse(param1InputStream, CTSdtEndPr.type, null);
    }
    
    public static CTSdtEndPr parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSdtEndPr)POIXMLTypeLoader.parse(param1InputStream, CTSdtEndPr.type, param1XmlOptions);
    }
    
    public static CTSdtEndPr parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSdtEndPr)POIXMLTypeLoader.parse(param1Reader, CTSdtEndPr.type, null);
    }
    
    public static CTSdtEndPr parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSdtEndPr)POIXMLTypeLoader.parse(param1Reader, CTSdtEndPr.type, param1XmlOptions);
    }
    
    public static CTSdtEndPr parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSdtEndPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSdtEndPr.type, null);
    }
    
    public static CTSdtEndPr parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSdtEndPr)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSdtEndPr.type, param1XmlOptions);
    }
    
    public static CTSdtEndPr parse(Node param1Node) throws XmlException {
      return (CTSdtEndPr)POIXMLTypeLoader.parse(param1Node, CTSdtEndPr.type, null);
    }
    
    public static CTSdtEndPr parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSdtEndPr)POIXMLTypeLoader.parse(param1Node, CTSdtEndPr.type, param1XmlOptions);
    }
    
    public static CTSdtEndPr parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSdtEndPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTSdtEndPr.type, null);
    }
    
    public static CTSdtEndPr parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSdtEndPr)POIXMLTypeLoader.parse(param1XMLInputStream, CTSdtEndPr.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSdtEndPr.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSdtEndPr.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTSdtEndPr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */