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

public interface CTScaling extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTScaling.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctscaling1dfftype");
  
  CTLogBase getLogBase();
  
  boolean isSetLogBase();
  
  void setLogBase(CTLogBase paramCTLogBase);
  
  CTLogBase addNewLogBase();
  
  void unsetLogBase();
  
  CTOrientation getOrientation();
  
  boolean isSetOrientation();
  
  void setOrientation(CTOrientation paramCTOrientation);
  
  CTOrientation addNewOrientation();
  
  void unsetOrientation();
  
  CTDouble getMax();
  
  boolean isSetMax();
  
  void setMax(CTDouble paramCTDouble);
  
  CTDouble addNewMax();
  
  void unsetMax();
  
  CTDouble getMin();
  
  boolean isSetMin();
  
  void setMin(CTDouble paramCTDouble);
  
  CTDouble addNewMin();
  
  void unsetMin();
  
  CTExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTExtensionList paramCTExtensionList);
  
  CTExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  public static final class Factory {
    public static CTScaling newInstance() {
      return (CTScaling)POIXMLTypeLoader.newInstance(CTScaling.type, null);
    }
    
    public static CTScaling newInstance(XmlOptions param1XmlOptions) {
      return (CTScaling)POIXMLTypeLoader.newInstance(CTScaling.type, param1XmlOptions);
    }
    
    public static CTScaling parse(String param1String) throws XmlException {
      return (CTScaling)POIXMLTypeLoader.parse(param1String, CTScaling.type, null);
    }
    
    public static CTScaling parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTScaling)POIXMLTypeLoader.parse(param1String, CTScaling.type, param1XmlOptions);
    }
    
    public static CTScaling parse(File param1File) throws XmlException, IOException {
      return (CTScaling)POIXMLTypeLoader.parse(param1File, CTScaling.type, null);
    }
    
    public static CTScaling parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTScaling)POIXMLTypeLoader.parse(param1File, CTScaling.type, param1XmlOptions);
    }
    
    public static CTScaling parse(URL param1URL) throws XmlException, IOException {
      return (CTScaling)POIXMLTypeLoader.parse(param1URL, CTScaling.type, null);
    }
    
    public static CTScaling parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTScaling)POIXMLTypeLoader.parse(param1URL, CTScaling.type, param1XmlOptions);
    }
    
    public static CTScaling parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTScaling)POIXMLTypeLoader.parse(param1InputStream, CTScaling.type, null);
    }
    
    public static CTScaling parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTScaling)POIXMLTypeLoader.parse(param1InputStream, CTScaling.type, param1XmlOptions);
    }
    
    public static CTScaling parse(Reader param1Reader) throws XmlException, IOException {
      return (CTScaling)POIXMLTypeLoader.parse(param1Reader, CTScaling.type, null);
    }
    
    public static CTScaling parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTScaling)POIXMLTypeLoader.parse(param1Reader, CTScaling.type, param1XmlOptions);
    }
    
    public static CTScaling parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTScaling)POIXMLTypeLoader.parse(param1XMLStreamReader, CTScaling.type, null);
    }
    
    public static CTScaling parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTScaling)POIXMLTypeLoader.parse(param1XMLStreamReader, CTScaling.type, param1XmlOptions);
    }
    
    public static CTScaling parse(Node param1Node) throws XmlException {
      return (CTScaling)POIXMLTypeLoader.parse(param1Node, CTScaling.type, null);
    }
    
    public static CTScaling parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTScaling)POIXMLTypeLoader.parse(param1Node, CTScaling.type, param1XmlOptions);
    }
    
    public static CTScaling parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTScaling)POIXMLTypeLoader.parse(param1XMLInputStream, CTScaling.type, null);
    }
    
    public static CTScaling parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTScaling)POIXMLTypeLoader.parse(param1XMLInputStream, CTScaling.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTScaling.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTScaling.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\CTScaling.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */