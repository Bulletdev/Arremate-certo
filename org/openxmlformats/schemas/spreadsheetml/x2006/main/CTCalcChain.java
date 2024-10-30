package org.openxmlformats.schemas.spreadsheetml.x2006.main;

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

public interface CTCalcChain extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTCalcChain.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctcalcchain5a0btype");
  
  List<CTCalcCell> getCList();
  
  CTCalcCell[] getCArray();
  
  CTCalcCell getCArray(int paramInt);
  
  int sizeOfCArray();
  
  void setCArray(CTCalcCell[] paramArrayOfCTCalcCell);
  
  void setCArray(int paramInt, CTCalcCell paramCTCalcCell);
  
  CTCalcCell insertNewC(int paramInt);
  
  CTCalcCell addNewC();
  
  void removeC(int paramInt);
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTCalcChain newInstance() {
      return (CTCalcChain)POIXMLTypeLoader.newInstance(CTCalcChain.type, null);
    }
    
    public static CTCalcChain newInstance(XmlOptions param1XmlOptions) {
      return (CTCalcChain)POIXMLTypeLoader.newInstance(CTCalcChain.type, param1XmlOptions);
    }
    
    public static CTCalcChain parse(String param1String) throws XmlException {
      return (CTCalcChain)POIXMLTypeLoader.parse(param1String, CTCalcChain.type, null);
    }
    
    public static CTCalcChain parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCalcChain)POIXMLTypeLoader.parse(param1String, CTCalcChain.type, param1XmlOptions);
    }
    
    public static CTCalcChain parse(File param1File) throws XmlException, IOException {
      return (CTCalcChain)POIXMLTypeLoader.parse(param1File, CTCalcChain.type, null);
    }
    
    public static CTCalcChain parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCalcChain)POIXMLTypeLoader.parse(param1File, CTCalcChain.type, param1XmlOptions);
    }
    
    public static CTCalcChain parse(URL param1URL) throws XmlException, IOException {
      return (CTCalcChain)POIXMLTypeLoader.parse(param1URL, CTCalcChain.type, null);
    }
    
    public static CTCalcChain parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCalcChain)POIXMLTypeLoader.parse(param1URL, CTCalcChain.type, param1XmlOptions);
    }
    
    public static CTCalcChain parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTCalcChain)POIXMLTypeLoader.parse(param1InputStream, CTCalcChain.type, null);
    }
    
    public static CTCalcChain parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCalcChain)POIXMLTypeLoader.parse(param1InputStream, CTCalcChain.type, param1XmlOptions);
    }
    
    public static CTCalcChain parse(Reader param1Reader) throws XmlException, IOException {
      return (CTCalcChain)POIXMLTypeLoader.parse(param1Reader, CTCalcChain.type, null);
    }
    
    public static CTCalcChain parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTCalcChain)POIXMLTypeLoader.parse(param1Reader, CTCalcChain.type, param1XmlOptions);
    }
    
    public static CTCalcChain parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTCalcChain)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCalcChain.type, null);
    }
    
    public static CTCalcChain parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCalcChain)POIXMLTypeLoader.parse(param1XMLStreamReader, CTCalcChain.type, param1XmlOptions);
    }
    
    public static CTCalcChain parse(Node param1Node) throws XmlException {
      return (CTCalcChain)POIXMLTypeLoader.parse(param1Node, CTCalcChain.type, null);
    }
    
    public static CTCalcChain parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTCalcChain)POIXMLTypeLoader.parse(param1Node, CTCalcChain.type, param1XmlOptions);
    }
    
    public static CTCalcChain parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTCalcChain)POIXMLTypeLoader.parse(param1XMLInputStream, CTCalcChain.type, null);
    }
    
    public static CTCalcChain parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTCalcChain)POIXMLTypeLoader.parse(param1XMLInputStream, CTCalcChain.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCalcChain.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTCalcChain.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTCalcChain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */