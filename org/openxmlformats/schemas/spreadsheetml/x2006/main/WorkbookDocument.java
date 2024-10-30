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

public interface WorkbookDocument extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(WorkbookDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("workbookec17doctype");
  
  CTWorkbook getWorkbook();
  
  void setWorkbook(CTWorkbook paramCTWorkbook);
  
  CTWorkbook addNewWorkbook();
  
  public static final class Factory {
    public static WorkbookDocument newInstance() {
      return (WorkbookDocument)POIXMLTypeLoader.newInstance(WorkbookDocument.type, null);
    }
    
    public static WorkbookDocument newInstance(XmlOptions param1XmlOptions) {
      return (WorkbookDocument)POIXMLTypeLoader.newInstance(WorkbookDocument.type, param1XmlOptions);
    }
    
    public static WorkbookDocument parse(String param1String) throws XmlException {
      return (WorkbookDocument)POIXMLTypeLoader.parse(param1String, WorkbookDocument.type, null);
    }
    
    public static WorkbookDocument parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (WorkbookDocument)POIXMLTypeLoader.parse(param1String, WorkbookDocument.type, param1XmlOptions);
    }
    
    public static WorkbookDocument parse(File param1File) throws XmlException, IOException {
      return (WorkbookDocument)POIXMLTypeLoader.parse(param1File, WorkbookDocument.type, null);
    }
    
    public static WorkbookDocument parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (WorkbookDocument)POIXMLTypeLoader.parse(param1File, WorkbookDocument.type, param1XmlOptions);
    }
    
    public static WorkbookDocument parse(URL param1URL) throws XmlException, IOException {
      return (WorkbookDocument)POIXMLTypeLoader.parse(param1URL, WorkbookDocument.type, null);
    }
    
    public static WorkbookDocument parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (WorkbookDocument)POIXMLTypeLoader.parse(param1URL, WorkbookDocument.type, param1XmlOptions);
    }
    
    public static WorkbookDocument parse(InputStream param1InputStream) throws XmlException, IOException {
      return (WorkbookDocument)POIXMLTypeLoader.parse(param1InputStream, WorkbookDocument.type, null);
    }
    
    public static WorkbookDocument parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (WorkbookDocument)POIXMLTypeLoader.parse(param1InputStream, WorkbookDocument.type, param1XmlOptions);
    }
    
    public static WorkbookDocument parse(Reader param1Reader) throws XmlException, IOException {
      return (WorkbookDocument)POIXMLTypeLoader.parse(param1Reader, WorkbookDocument.type, null);
    }
    
    public static WorkbookDocument parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (WorkbookDocument)POIXMLTypeLoader.parse(param1Reader, WorkbookDocument.type, param1XmlOptions);
    }
    
    public static WorkbookDocument parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (WorkbookDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, WorkbookDocument.type, null);
    }
    
    public static WorkbookDocument parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (WorkbookDocument)POIXMLTypeLoader.parse(param1XMLStreamReader, WorkbookDocument.type, param1XmlOptions);
    }
    
    public static WorkbookDocument parse(Node param1Node) throws XmlException {
      return (WorkbookDocument)POIXMLTypeLoader.parse(param1Node, WorkbookDocument.type, null);
    }
    
    public static WorkbookDocument parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (WorkbookDocument)POIXMLTypeLoader.parse(param1Node, WorkbookDocument.type, param1XmlOptions);
    }
    
    public static WorkbookDocument parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (WorkbookDocument)POIXMLTypeLoader.parse(param1XMLInputStream, WorkbookDocument.type, null);
    }
    
    public static WorkbookDocument parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (WorkbookDocument)POIXMLTypeLoader.parse(param1XMLInputStream, WorkbookDocument.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, WorkbookDocument.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, WorkbookDocument.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\WorkbookDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */