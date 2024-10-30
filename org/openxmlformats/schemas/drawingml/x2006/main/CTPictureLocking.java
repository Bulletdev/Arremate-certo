package org.openxmlformats.schemas.drawingml.x2006.main;

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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTPictureLocking extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTPictureLocking.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctpicturelockinga414type");
  
  CTOfficeArtExtensionList getExtLst();
  
  boolean isSetExtLst();
  
  void setExtLst(CTOfficeArtExtensionList paramCTOfficeArtExtensionList);
  
  CTOfficeArtExtensionList addNewExtLst();
  
  void unsetExtLst();
  
  boolean getNoGrp();
  
  XmlBoolean xgetNoGrp();
  
  boolean isSetNoGrp();
  
  void setNoGrp(boolean paramBoolean);
  
  void xsetNoGrp(XmlBoolean paramXmlBoolean);
  
  void unsetNoGrp();
  
  boolean getNoSelect();
  
  XmlBoolean xgetNoSelect();
  
  boolean isSetNoSelect();
  
  void setNoSelect(boolean paramBoolean);
  
  void xsetNoSelect(XmlBoolean paramXmlBoolean);
  
  void unsetNoSelect();
  
  boolean getNoRot();
  
  XmlBoolean xgetNoRot();
  
  boolean isSetNoRot();
  
  void setNoRot(boolean paramBoolean);
  
  void xsetNoRot(XmlBoolean paramXmlBoolean);
  
  void unsetNoRot();
  
  boolean getNoChangeAspect();
  
  XmlBoolean xgetNoChangeAspect();
  
  boolean isSetNoChangeAspect();
  
  void setNoChangeAspect(boolean paramBoolean);
  
  void xsetNoChangeAspect(XmlBoolean paramXmlBoolean);
  
  void unsetNoChangeAspect();
  
  boolean getNoMove();
  
  XmlBoolean xgetNoMove();
  
  boolean isSetNoMove();
  
  void setNoMove(boolean paramBoolean);
  
  void xsetNoMove(XmlBoolean paramXmlBoolean);
  
  void unsetNoMove();
  
  boolean getNoResize();
  
  XmlBoolean xgetNoResize();
  
  boolean isSetNoResize();
  
  void setNoResize(boolean paramBoolean);
  
  void xsetNoResize(XmlBoolean paramXmlBoolean);
  
  void unsetNoResize();
  
  boolean getNoEditPoints();
  
  XmlBoolean xgetNoEditPoints();
  
  boolean isSetNoEditPoints();
  
  void setNoEditPoints(boolean paramBoolean);
  
  void xsetNoEditPoints(XmlBoolean paramXmlBoolean);
  
  void unsetNoEditPoints();
  
  boolean getNoAdjustHandles();
  
  XmlBoolean xgetNoAdjustHandles();
  
  boolean isSetNoAdjustHandles();
  
  void setNoAdjustHandles(boolean paramBoolean);
  
  void xsetNoAdjustHandles(XmlBoolean paramXmlBoolean);
  
  void unsetNoAdjustHandles();
  
  boolean getNoChangeArrowheads();
  
  XmlBoolean xgetNoChangeArrowheads();
  
  boolean isSetNoChangeArrowheads();
  
  void setNoChangeArrowheads(boolean paramBoolean);
  
  void xsetNoChangeArrowheads(XmlBoolean paramXmlBoolean);
  
  void unsetNoChangeArrowheads();
  
  boolean getNoChangeShapeType();
  
  XmlBoolean xgetNoChangeShapeType();
  
  boolean isSetNoChangeShapeType();
  
  void setNoChangeShapeType(boolean paramBoolean);
  
  void xsetNoChangeShapeType(XmlBoolean paramXmlBoolean);
  
  void unsetNoChangeShapeType();
  
  boolean getNoCrop();
  
  XmlBoolean xgetNoCrop();
  
  boolean isSetNoCrop();
  
  void setNoCrop(boolean paramBoolean);
  
  void xsetNoCrop(XmlBoolean paramXmlBoolean);
  
  void unsetNoCrop();
  
  public static final class Factory {
    public static CTPictureLocking newInstance() {
      return (CTPictureLocking)POIXMLTypeLoader.newInstance(CTPictureLocking.type, null);
    }
    
    public static CTPictureLocking newInstance(XmlOptions param1XmlOptions) {
      return (CTPictureLocking)POIXMLTypeLoader.newInstance(CTPictureLocking.type, param1XmlOptions);
    }
    
    public static CTPictureLocking parse(String param1String) throws XmlException {
      return (CTPictureLocking)POIXMLTypeLoader.parse(param1String, CTPictureLocking.type, null);
    }
    
    public static CTPictureLocking parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPictureLocking)POIXMLTypeLoader.parse(param1String, CTPictureLocking.type, param1XmlOptions);
    }
    
    public static CTPictureLocking parse(File param1File) throws XmlException, IOException {
      return (CTPictureLocking)POIXMLTypeLoader.parse(param1File, CTPictureLocking.type, null);
    }
    
    public static CTPictureLocking parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPictureLocking)POIXMLTypeLoader.parse(param1File, CTPictureLocking.type, param1XmlOptions);
    }
    
    public static CTPictureLocking parse(URL param1URL) throws XmlException, IOException {
      return (CTPictureLocking)POIXMLTypeLoader.parse(param1URL, CTPictureLocking.type, null);
    }
    
    public static CTPictureLocking parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPictureLocking)POIXMLTypeLoader.parse(param1URL, CTPictureLocking.type, param1XmlOptions);
    }
    
    public static CTPictureLocking parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTPictureLocking)POIXMLTypeLoader.parse(param1InputStream, CTPictureLocking.type, null);
    }
    
    public static CTPictureLocking parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPictureLocking)POIXMLTypeLoader.parse(param1InputStream, CTPictureLocking.type, param1XmlOptions);
    }
    
    public static CTPictureLocking parse(Reader param1Reader) throws XmlException, IOException {
      return (CTPictureLocking)POIXMLTypeLoader.parse(param1Reader, CTPictureLocking.type, null);
    }
    
    public static CTPictureLocking parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTPictureLocking)POIXMLTypeLoader.parse(param1Reader, CTPictureLocking.type, param1XmlOptions);
    }
    
    public static CTPictureLocking parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTPictureLocking)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPictureLocking.type, null);
    }
    
    public static CTPictureLocking parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPictureLocking)POIXMLTypeLoader.parse(param1XMLStreamReader, CTPictureLocking.type, param1XmlOptions);
    }
    
    public static CTPictureLocking parse(Node param1Node) throws XmlException {
      return (CTPictureLocking)POIXMLTypeLoader.parse(param1Node, CTPictureLocking.type, null);
    }
    
    public static CTPictureLocking parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTPictureLocking)POIXMLTypeLoader.parse(param1Node, CTPictureLocking.type, param1XmlOptions);
    }
    
    public static CTPictureLocking parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTPictureLocking)POIXMLTypeLoader.parse(param1XMLInputStream, CTPictureLocking.type, null);
    }
    
    public static CTPictureLocking parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTPictureLocking)POIXMLTypeLoader.parse(param1XMLInputStream, CTPictureLocking.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPictureLocking.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTPictureLocking.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTPictureLocking.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */