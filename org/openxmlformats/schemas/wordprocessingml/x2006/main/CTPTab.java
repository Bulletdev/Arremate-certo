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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTPTab extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPTab.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctptaba283type");
  
  STPTabAlignment$Enum getAlignment();
  
  STPTabAlignment xgetAlignment();
  
  void setAlignment(STPTabAlignment$Enum paramSTPTabAlignment$Enum);
  
  void xsetAlignment(STPTabAlignment paramSTPTabAlignment);
  
  STPTabRelativeTo$Enum getRelativeTo();
  
  STPTabRelativeTo xgetRelativeTo();
  
  void setRelativeTo(STPTabRelativeTo$Enum paramSTPTabRelativeTo$Enum);
  
  void xsetRelativeTo(STPTabRelativeTo paramSTPTabRelativeTo);
  
  STPTabLeader$Enum getLeader();
  
  STPTabLeader xgetLeader();
  
  void setLeader(STPTabLeader$Enum paramSTPTabLeader$Enum);
  
  void xsetLeader(STPTabLeader paramSTPTabLeader);
  
  public static final class Factory {
    public static CTPTab newInstance() {
      return (CTPTab)POIXMLTypeLoader.newInstance(CTPTab.type, null);
    }
    
    public static CTPTab newInstance(XmlOptions param1XmlOptions) {
      return (CTPTab)POIXMLTypeLoader.newInstance(CTPTab.type, param1XmlOptions);
    }
    
    public static CTPTab parse(String param1String) throws XmlException {
      return (CTPTab)POIXMLTypeLoader.parse(param1String, CTPTab.type, null);
    }
    
    public static CTPTab parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPTab)POIXMLTypeLoader.parse(param1String, CTPTab.type, param1XmlOptions);
    }
    
    public static CTPTab parse(File param1File) throws XmlException, IOException {
      return (CTPTab)POIXMLTypeLoader.parse(param1File, CTPTab.type, null);
    }
    
    public static CTPTab parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPTab)POIXMLTypeLoader.parse(param1File, CTPTab.type, param1XmlOptions);
    }
    
    public static CTPTab parse(URL param1URL) throws XmlException, IOException {
      return (CTPTab)POIXMLTypeLoader.parse(param1URL, CTPTab.type, null);
    }
    
    public static CTPTab parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPTab)POIXMLTypeLoader.parse(param1URL, CTPTab.type, param1XmlOptions);
    }
    
    public static CTPTab parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPTab)POIXMLTypeLoader.parse(param1InputStream, CTPTab.type, null);
    }
    
    public static CTPTab parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPTab)POIXMLTypeLoader.parse(param1InputStream, CTPTab.type, param1XmlOptions);
    }
    
    public static CTPTab parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPTab)POIXMLTypeLoader.parse(param1Reader, CTPTab.type, null);
    }
    
    public static CTPTab parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPTab)POIXMLTypeLoader.parse(param1Reader, CTPTab.type, param1XmlOptions);
    }
    
    public static CTPTab parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPTab)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPTab.type, null);
    }
    
    public static CTPTab parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPTab)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPTab.type, param1XmlOptions);
    }
    
    public static CTPTab parse(Node param1Node) throws XmlException {
      return (CTPTab)POIXMLTypeLoader.parse(param1Node, CTPTab.type, null);
    }
    
    public static CTPTab parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPTab)POIXMLTypeLoader.parse(param1Node, CTPTab.type, param1XmlOptions);
    }
    
    public static CTPTab parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPTab)POIXMLTypeLoader.parse(param1XMLInputStream, CTPTab.type, null);
    }
    
    public static CTPTab parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPTab)POIXMLTypeLoader.parse(param1XMLInputStream, CTPTab.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPTab.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPTab.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTPTab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */