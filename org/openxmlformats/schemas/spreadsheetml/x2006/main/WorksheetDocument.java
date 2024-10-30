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

public interface WorksheetDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(WorksheetDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("worksheetf539doctype");
  
  CTWorksheet getWorksheet();
  
  void setWorksheet(CTWorksheet paramCTWorksheet);
  
  CTWorksheet addNewWorksheet();
  
  public static final class Factory {
    public static WorksheetDocument newInstance() {
      return (WorksheetDocument)POIXMLTypeLoader.newInstance(WorksheetDocument.type, null);
    }
    
    public static WorksheetDocument newInstance(XmlOptions param1XmlOptions) {
      return (WorksheetDocument)POIXMLTypeLoader.newInstance(WorksheetDocument.type, param1XmlOptions);
    }
    
    public static WorksheetDocument parse(String param1String) throws XmlException {
      return (WorksheetDocument)POIXMLTypeLoader.parse(param1String, WorksheetDocument.type, null);
    }
    
    public static WorksheetDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (WorksheetDocument)POIXMLTypeLoader.parse(param1String, WorksheetDocument.type, param1XmlOptions);
    }
    
    public static WorksheetDocument parse(File param1File) throws XmlException, IOException {
      return (WorksheetDocument)POIXMLTypeLoader.parse(param1File, WorksheetDocument.type, null);
    }
    
    public static WorksheetDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (WorksheetDocument)POIXMLTypeLoader.parse(param1File, WorksheetDocument.type, param1XmlOptions);
    }
    
    public static WorksheetDocument parse(URL param1URL) throws XmlException, IOException {
      return (WorksheetDocument)POIXMLTypeLoader.parse(param1URL, WorksheetDocument.type, null);
    }
    
    public static WorksheetDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (WorksheetDocument)POIXMLTypeLoader.parse(param1URL, WorksheetDocument.type, param1XmlOptions);
    }
    
    public static WorksheetDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (WorksheetDocument)POIXMLTypeLoader.parse(param1InputStream, WorksheetDocument.type, null);
    }
    
    public static WorksheetDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (WorksheetDocument)POIXMLTypeLoader.parse(param1InputStream, WorksheetDocument.type, param1XmlOptions);
    }
    
    public static WorksheetDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (WorksheetDocument)POIXMLTypeLoader.parse(param1Reader, WorksheetDocument.type, null);
    }
    
    public static WorksheetDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (WorksheetDocument)POIXMLTypeLoader.parse(param1Reader, WorksheetDocument.type, param1XmlOptions);
    }
    
    public static WorksheetDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (WorksheetDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, WorksheetDocument.type, null);
    }
    
    public static WorksheetDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (WorksheetDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, WorksheetDocument.type, param1XmlOptions);
    }
    
    public static WorksheetDocument parse(Node param1Node) throws XmlException {
      return (WorksheetDocument)POIXMLTypeLoader.parse(param1Node, WorksheetDocument.type, null);
    }
    
    public static WorksheetDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (WorksheetDocument)POIXMLTypeLoader.parse(param1Node, WorksheetDocument.type, param1XmlOptions);
    }
    
    public static WorksheetDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (WorksheetDocument)POIXMLTypeLoader.parse(param1XMLInputStream, WorksheetDocument.type, null);
    }
    
    public static WorksheetDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (WorksheetDocument)POIXMLTypeLoader.parse(param1XMLInputStream, WorksheetDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, WorksheetDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, WorksheetDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\WorksheetDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */