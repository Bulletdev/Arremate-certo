package org.openxmlformats.schemas.drawingml.x2006.chart;

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

public interface CTLayout extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTLayout.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlayout3192type");
  
  CTManualLayout getManualLayout();
  
  boolean isSetManualLayout();
  
  void setManualLayout(CTManualLayout paramCTManualLayout);
  
  CTManualLayout addNewManualLayout();
  
  void unsetManualLayout();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTLayout newInstance() {
      return (CTLayout)POIXMLTypeLoader.newInstance(CTLayout.type, null);
    }
    
    public static CTLayout newInstance(XmlOptions param1XmlOptions) {
      return (CTLayout)POIXMLTypeLoader.newInstance(CTLayout.type, param1XmlOptions);
    }
    
    public static CTLayout parse(String param1String) throws XmlException {
      return (CTLayout)POIXMLTypeLoader.parse(param1String, CTLayout.type, null);
    }
    
    public static CTLayout parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLayout)POIXMLTypeLoader.parse(param1String, CTLayout.type, param1XmlOptions);
    }
    
    public static CTLayout parse(File param1File) throws XmlException, IOException {
      return (CTLayout)POIXMLTypeLoader.parse(param1File, CTLayout.type, null);
    }
    
    public static CTLayout parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLayout)POIXMLTypeLoader.parse(param1File, CTLayout.type, param1XmlOptions);
    }
    
    public static CTLayout parse(URL param1URL) throws XmlException, IOException {
      return (CTLayout)POIXMLTypeLoader.parse(param1URL, CTLayout.type, null);
    }
    
    public static CTLayout parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLayout)POIXMLTypeLoader.parse(param1URL, CTLayout.type, param1XmlOptions);
    }
    
    public static CTLayout parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTLayout)POIXMLTypeLoader.parse(param1InputStream, CTLayout.type, null);
    }
    
    public static CTLayout parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLayout)POIXMLTypeLoader.parse(param1InputStream, CTLayout.type, param1XmlOptions);
    }
    
    public static CTLayout parse(Reader param1Reader) throws XmlException, IOException {
      return (CTLayout)POIXMLTypeLoader.parse(param1Reader, CTLayout.type, null);
    }
    
    public static CTLayout parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLayout)POIXMLTypeLoader.parse(param1Reader, CTLayout.type, param1XmlOptions);
    }
    
    public static CTLayout parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTLayout)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLayout.type, null);
    }
    
    public static CTLayout parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLayout)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLayout.type, param1XmlOptions);
    }
    
    public static CTLayout parse(Node param1Node) throws XmlException {
      return (CTLayout)POIXMLTypeLoader.parse(param1Node, CTLayout.type, null);
    }
    
    public static CTLayout parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLayout)POIXMLTypeLoader.parse(param1Node, CTLayout.type, param1XmlOptions);
    }
    
    public static CTLayout parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTLayout)POIXMLTypeLoader.parse(param1XMLInputStream, CTLayout.type, null);
    }
    
    public static CTLayout parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTLayout)POIXMLTypeLoader.parse(param1XMLInputStream, CTLayout.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLayout.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLayout.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */