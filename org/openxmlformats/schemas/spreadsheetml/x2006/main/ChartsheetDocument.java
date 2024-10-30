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

public interface ChartsheetDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(ChartsheetDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("chartsheet99dedoctype");
  
  CTChartsheet getChartsheet();
  
  void setChartsheet(CTChartsheet paramCTChartsheet);
  
  CTChartsheet addNewChartsheet();
  
  public static final class Factory {
    public static ChartsheetDocument newInstance() {
      return (ChartsheetDocument)POIXMLTypeLoader.newInstance(ChartsheetDocument.type, null);
    }
    
    public static ChartsheetDocument newInstance(XmlOptions param1XmlOptions) {
      return (ChartsheetDocument)POIXMLTypeLoader.newInstance(ChartsheetDocument.type, param1XmlOptions);
    }
    
    public static ChartsheetDocument parse(String param1String) throws XmlException {
      return (ChartsheetDocument)POIXMLTypeLoader.parse(param1String, ChartsheetDocument.type, null);
    }
    
    public static ChartsheetDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (ChartsheetDocument)POIXMLTypeLoader.parse(param1String, ChartsheetDocument.type, param1XmlOptions);
    }
    
    public static ChartsheetDocument parse(File param1File) throws XmlException, IOException {
      return (ChartsheetDocument)POIXMLTypeLoader.parse(param1File, ChartsheetDocument.type, null);
    }
    
    public static ChartsheetDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (ChartsheetDocument)POIXMLTypeLoader.parse(param1File, ChartsheetDocument.type, param1XmlOptions);
    }
    
    public static ChartsheetDocument parse(URL param1URL) throws XmlException, IOException {
      return (ChartsheetDocument)POIXMLTypeLoader.parse(param1URL, ChartsheetDocument.type, null);
    }
    
    public static ChartsheetDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (ChartsheetDocument)POIXMLTypeLoader.parse(param1URL, ChartsheetDocument.type, param1XmlOptions);
    }
    
    public static ChartsheetDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (ChartsheetDocument)POIXMLTypeLoader.parse(param1InputStream, ChartsheetDocument.type, null);
    }
    
    public static ChartsheetDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (ChartsheetDocument)POIXMLTypeLoader.parse(param1InputStream, ChartsheetDocument.type, param1XmlOptions);
    }
    
    public static ChartsheetDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (ChartsheetDocument)POIXMLTypeLoader.parse(param1Reader, ChartsheetDocument.type, null);
    }
    
    public static ChartsheetDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (ChartsheetDocument)POIXMLTypeLoader.parse(param1Reader, ChartsheetDocument.type, param1XmlOptions);
    }
    
    public static ChartsheetDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (ChartsheetDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, ChartsheetDocument.type, null);
    }
    
    public static ChartsheetDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (ChartsheetDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, ChartsheetDocument.type, param1XmlOptions);
    }
    
    public static ChartsheetDocument parse(Node param1Node) throws XmlException {
      return (ChartsheetDocument)POIXMLTypeLoader.parse(param1Node, ChartsheetDocument.type, null);
    }
    
    public static ChartsheetDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (ChartsheetDocument)POIXMLTypeLoader.parse(param1Node, ChartsheetDocument.type, param1XmlOptions);
    }
    
    public static ChartsheetDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (ChartsheetDocument)POIXMLTypeLoader.parse(param1XMLInputStream, ChartsheetDocument.type, null);
    }
    
    public static ChartsheetDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (ChartsheetDocument)POIXMLTypeLoader.parse(param1XMLInputStream, ChartsheetDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, ChartsheetDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, ChartsheetDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\ChartsheetDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */