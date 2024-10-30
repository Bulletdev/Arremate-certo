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

public interface ChartSpaceDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(ChartSpaceDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("chartspace36e0doctype");
  
  CTChartSpace getChartSpace();
  
  void setChartSpace(CTChartSpace paramCTChartSpace);
  
  CTChartSpace addNewChartSpace();
  
  public static final class Factory {
    public static ChartSpaceDocument newInstance() {
      return (ChartSpaceDocument)POIXMLTypeLoader.newInstance(ChartSpaceDocument.type, null);
    }
    
    public static ChartSpaceDocument newInstance(XmlOptions param1XmlOptions) {
      return (ChartSpaceDocument)POIXMLTypeLoader.newInstance(ChartSpaceDocument.type, param1XmlOptions);
    }
    
    public static ChartSpaceDocument parse(String param1String) throws XmlException {
      return (ChartSpaceDocument)POIXMLTypeLoader.parse(param1String, ChartSpaceDocument.type, null);
    }
    
    public static ChartSpaceDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (ChartSpaceDocument)POIXMLTypeLoader.parse(param1String, ChartSpaceDocument.type, param1XmlOptions);
    }
    
    public static ChartSpaceDocument parse(File param1File) throws XmlException, IOException {
      return (ChartSpaceDocument)POIXMLTypeLoader.parse(param1File, ChartSpaceDocument.type, null);
    }
    
    public static ChartSpaceDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (ChartSpaceDocument)POIXMLTypeLoader.parse(param1File, ChartSpaceDocument.type, param1XmlOptions);
    }
    
    public static ChartSpaceDocument parse(URL param1URL) throws XmlException, IOException {
      return (ChartSpaceDocument)POIXMLTypeLoader.parse(param1URL, ChartSpaceDocument.type, null);
    }
    
    public static ChartSpaceDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (ChartSpaceDocument)POIXMLTypeLoader.parse(param1URL, ChartSpaceDocument.type, param1XmlOptions);
    }
    
    public static ChartSpaceDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (ChartSpaceDocument)POIXMLTypeLoader.parse(param1InputStream, ChartSpaceDocument.type, null);
    }
    
    public static ChartSpaceDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (ChartSpaceDocument)POIXMLTypeLoader.parse(param1InputStream, ChartSpaceDocument.type, param1XmlOptions);
    }
    
    public static ChartSpaceDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (ChartSpaceDocument)POIXMLTypeLoader.parse(param1Reader, ChartSpaceDocument.type, null);
    }
    
    public static ChartSpaceDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (ChartSpaceDocument)POIXMLTypeLoader.parse(param1Reader, ChartSpaceDocument.type, param1XmlOptions);
    }
    
    public static ChartSpaceDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (ChartSpaceDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, ChartSpaceDocument.type, null);
    }
    
    public static ChartSpaceDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (ChartSpaceDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, ChartSpaceDocument.type, param1XmlOptions);
    }
    
    public static ChartSpaceDocument parse(Node param1Node) throws XmlException {
      return (ChartSpaceDocument)POIXMLTypeLoader.parse(param1Node, ChartSpaceDocument.type, null);
    }
    
    public static ChartSpaceDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (ChartSpaceDocument)POIXMLTypeLoader.parse(param1Node, ChartSpaceDocument.type, param1XmlOptions);
    }
    
    public static ChartSpaceDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (ChartSpaceDocument)POIXMLTypeLoader.parse(param1XMLInputStream, ChartSpaceDocument.type, null);
    }
    
    public static ChartSpaceDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (ChartSpaceDocument)POIXMLTypeLoader.parse(param1XMLInputStream, ChartSpaceDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, ChartSpaceDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, ChartSpaceDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\chart\ChartSpaceDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */