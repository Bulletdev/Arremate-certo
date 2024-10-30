package org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
import org.w3c.dom.Node;

public interface CTPicture extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPicture.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpicturee028type");
  
  CTPictureNonVisual getNvPicPr();
  
  void setNvPicPr(CTPictureNonVisual paramCTPictureNonVisual);
  
  CTPictureNonVisual addNewNvPicPr();
  
  CTBlipFillProperties getBlipFill();
  
  void setBlipFill(CTBlipFillProperties paramCTBlipFillProperties);
  
  CTBlipFillProperties addNewBlipFill();
  
  CTShapeProperties getSpPr();
  
  void setSpPr(CTShapeProperties paramCTShapeProperties);
  
  CTShapeProperties addNewSpPr();
  
  CTShapeStyle getStyle();
  
  boolean isSetStyle();
  
  void setStyle(CTShapeStyle paramCTShapeStyle);
  
  CTShapeStyle addNewStyle();
  
  void unsetStyle();
  
  String getMacro();
  
  XmlString xgetMacro();
  
  boolean isSetMacro();
  
  void setMacro(String paramString);
  
  void xsetMacro(XmlString paramXmlString);
  
  void unsetMacro();
  
  boolean getFPublished();
  
  XmlBoolean xgetFPublished();
  
  boolean isSetFPublished();
  
  void setFPublished(boolean paramBoolean);
  
  void xsetFPublished(XmlBoolean paramXmlBoolean);
  
  void unsetFPublished();
  
  public static final class Factory {
    public static CTPicture newInstance() {
      return (CTPicture)POIXMLTypeLoader.newInstance(CTPicture.type, null);
    }
    
    public static CTPicture newInstance(XmlOptions param1XmlOptions) {
      return (CTPicture)POIXMLTypeLoader.newInstance(CTPicture.type, param1XmlOptions);
    }
    
    public static CTPicture parse(String param1String) throws XmlException {
      return (CTPicture)POIXMLTypeLoader.parse(param1String, CTPicture.type, null);
    }
    
    public static CTPicture parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPicture)POIXMLTypeLoader.parse(param1String, CTPicture.type, param1XmlOptions);
    }
    
    public static CTPicture parse(File param1File) throws XmlException, IOException {
      return (CTPicture)POIXMLTypeLoader.parse(param1File, CTPicture.type, null);
    }
    
    public static CTPicture parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPicture)POIXMLTypeLoader.parse(param1File, CTPicture.type, param1XmlOptions);
    }
    
    public static CTPicture parse(URL param1URL) throws XmlException, IOException {
      return (CTPicture)POIXMLTypeLoader.parse(param1URL, CTPicture.type, null);
    }
    
    public static CTPicture parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPicture)POIXMLTypeLoader.parse(param1URL, CTPicture.type, param1XmlOptions);
    }
    
    public static CTPicture parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPicture)POIXMLTypeLoader.parse(param1InputStream, CTPicture.type, null);
    }
    
    public static CTPicture parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPicture)POIXMLTypeLoader.parse(param1InputStream, CTPicture.type, param1XmlOptions);
    }
    
    public static CTPicture parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPicture)POIXMLTypeLoader.parse(param1Reader, CTPicture.type, null);
    }
    
    public static CTPicture parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPicture)POIXMLTypeLoader.parse(param1Reader, CTPicture.type, param1XmlOptions);
    }
    
    public static CTPicture parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPicture)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPicture.type, null);
    }
    
    public static CTPicture parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPicture)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPicture.type, param1XmlOptions);
    }
    
    public static CTPicture parse(Node param1Node) throws XmlException {
      return (CTPicture)POIXMLTypeLoader.parse(param1Node, CTPicture.type, null);
    }
    
    public static CTPicture parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPicture)POIXMLTypeLoader.parse(param1Node, CTPicture.type, param1XmlOptions);
    }
    
    public static CTPicture parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPicture)POIXMLTypeLoader.parse(param1XMLInputStream, CTPicture.type, null);
    }
    
    public static CTPicture parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPicture)POIXMLTypeLoader.parse(param1XMLInputStream, CTPicture.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPicture.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPicture.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\spreadsheetDrawing\CTPicture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */