package org.openxmlformats.schemas.presentationml.x2006.main;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualPictureProperties;
import org.w3c.dom.Node;

public interface CTPictureNonVisual extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPictureNonVisual.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpicturenonvisualb236type");
  
  CTNonVisualDrawingProps getCNvPr();
  
  void setCNvPr(CTNonVisualDrawingProps paramCTNonVisualDrawingProps);
  
  CTNonVisualDrawingProps addNewCNvPr();
  
  CTNonVisualPictureProperties getCNvPicPr();
  
  void setCNvPicPr(CTNonVisualPictureProperties paramCTNonVisualPictureProperties);
  
  CTNonVisualPictureProperties addNewCNvPicPr();
  
  CTApplicationNonVisualDrawingProps getNvPr();
  
  void setNvPr(CTApplicationNonVisualDrawingProps paramCTApplicationNonVisualDrawingProps);
  
  CTApplicationNonVisualDrawingProps addNewNvPr();
  
  public static final class Factory {
    public static CTPictureNonVisual newInstance() {
      return (CTPictureNonVisual)POIXMLTypeLoader.newInstance(CTPictureNonVisual.type, null);
    }
    
    public static CTPictureNonVisual newInstance(XmlOptions param1XmlOptions) {
      return (CTPictureNonVisual)POIXMLTypeLoader.newInstance(CTPictureNonVisual.type, param1XmlOptions);
    }
    
    public static CTPictureNonVisual parse(String param1String) throws XmlException {
      return (CTPictureNonVisual)POIXMLTypeLoader.parse(param1String, CTPictureNonVisual.type, null);
    }
    
    public static CTPictureNonVisual parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPictureNonVisual)POIXMLTypeLoader.parse(param1String, CTPictureNonVisual.type, param1XmlOptions);
    }
    
    public static CTPictureNonVisual parse(File param1File) throws XmlException, IOException {
      return (CTPictureNonVisual)POIXMLTypeLoader.parse(param1File, CTPictureNonVisual.type, null);
    }
    
    public static CTPictureNonVisual parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPictureNonVisual)POIXMLTypeLoader.parse(param1File, CTPictureNonVisual.type, param1XmlOptions);
    }
    
    public static CTPictureNonVisual parse(URL param1URL) throws XmlException, IOException {
      return (CTPictureNonVisual)POIXMLTypeLoader.parse(param1URL, CTPictureNonVisual.type, null);
    }
    
    public static CTPictureNonVisual parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPictureNonVisual)POIXMLTypeLoader.parse(param1URL, CTPictureNonVisual.type, param1XmlOptions);
    }
    
    public static CTPictureNonVisual parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPictureNonVisual)POIXMLTypeLoader.parse(param1InputStream, CTPictureNonVisual.type, null);
    }
    
    public static CTPictureNonVisual parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPictureNonVisual)POIXMLTypeLoader.parse(param1InputStream, CTPictureNonVisual.type, param1XmlOptions);
    }
    
    public static CTPictureNonVisual parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPictureNonVisual)POIXMLTypeLoader.parse(param1Reader, CTPictureNonVisual.type, null);
    }
    
    public static CTPictureNonVisual parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPictureNonVisual)POIXMLTypeLoader.parse(param1Reader, CTPictureNonVisual.type, param1XmlOptions);
    }
    
    public static CTPictureNonVisual parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPictureNonVisual)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPictureNonVisual.type, null);
    }
    
    public static CTPictureNonVisual parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPictureNonVisual)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPictureNonVisual.type, param1XmlOptions);
    }
    
    public static CTPictureNonVisual parse(Node param1Node) throws XmlException {
      return (CTPictureNonVisual)POIXMLTypeLoader.parse(param1Node, CTPictureNonVisual.type, null);
    }
    
    public static CTPictureNonVisual parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPictureNonVisual)POIXMLTypeLoader.parse(param1Node, CTPictureNonVisual.type, param1XmlOptions);
    }
    
    public static CTPictureNonVisual parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPictureNonVisual)POIXMLTypeLoader.parse(param1XMLInputStream, CTPictureNonVisual.type, null);
    }
    
    public static CTPictureNonVisual parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPictureNonVisual)POIXMLTypeLoader.parse(param1XMLInputStream, CTPictureNonVisual.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPictureNonVisual.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPictureNonVisual.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\presentationml\x2006\main\CTPictureNonVisual.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */