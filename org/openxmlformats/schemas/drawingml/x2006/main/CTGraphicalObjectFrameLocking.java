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

public interface CTGraphicalObjectFrameLocking extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTGraphicalObjectFrameLocking.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctgraphicalobjectframelocking42adtype");
  
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
  
  boolean getNoDrilldown();
  
  XmlBoolean xgetNoDrilldown();
  
  boolean isSetNoDrilldown();
  
  void setNoDrilldown(boolean paramBoolean);
  
  void xsetNoDrilldown(XmlBoolean paramXmlBoolean);
  
  void unsetNoDrilldown();
  
  boolean getNoSelect();
  
  XmlBoolean xgetNoSelect();
  
  boolean isSetNoSelect();
  
  void setNoSelect(boolean paramBoolean);
  
  void xsetNoSelect(XmlBoolean paramXmlBoolean);
  
  void unsetNoSelect();
  
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
  
  public static final class Factory {
    public static CTGraphicalObjectFrameLocking newInstance() {
      return (CTGraphicalObjectFrameLocking)POIXMLTypeLoader.newInstance(CTGraphicalObjectFrameLocking.type, null);
    }
    
    public static CTGraphicalObjectFrameLocking newInstance(XmlOptions param1XmlOptions) {
      return (CTGraphicalObjectFrameLocking)POIXMLTypeLoader.newInstance(CTGraphicalObjectFrameLocking.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectFrameLocking parse(String param1String) throws XmlException {
      return (CTGraphicalObjectFrameLocking)POIXMLTypeLoader.parse(param1String, CTGraphicalObjectFrameLocking.type, null);
    }
    
    public static CTGraphicalObjectFrameLocking parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGraphicalObjectFrameLocking)POIXMLTypeLoader.parse(param1String, CTGraphicalObjectFrameLocking.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectFrameLocking parse(File param1File) throws XmlException, IOException {
      return (CTGraphicalObjectFrameLocking)POIXMLTypeLoader.parse(param1File, CTGraphicalObjectFrameLocking.type, null);
    }
    
    public static CTGraphicalObjectFrameLocking parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGraphicalObjectFrameLocking)POIXMLTypeLoader.parse(param1File, CTGraphicalObjectFrameLocking.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectFrameLocking parse(URL param1URL) throws XmlException, IOException {
      return (CTGraphicalObjectFrameLocking)POIXMLTypeLoader.parse(param1URL, CTGraphicalObjectFrameLocking.type, null);
    }
    
    public static CTGraphicalObjectFrameLocking parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGraphicalObjectFrameLocking)POIXMLTypeLoader.parse(param1URL, CTGraphicalObjectFrameLocking.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectFrameLocking parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTGraphicalObjectFrameLocking)POIXMLTypeLoader.parse(param1InputStream, CTGraphicalObjectFrameLocking.type, null);
    }
    
    public static CTGraphicalObjectFrameLocking parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGraphicalObjectFrameLocking)POIXMLTypeLoader.parse(param1InputStream, CTGraphicalObjectFrameLocking.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectFrameLocking parse(Reader param1Reader) throws XmlException, IOException {
      return (CTGraphicalObjectFrameLocking)POIXMLTypeLoader.parse(param1Reader, CTGraphicalObjectFrameLocking.type, null);
    }
    
    public static CTGraphicalObjectFrameLocking parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTGraphicalObjectFrameLocking)POIXMLTypeLoader.parse(param1Reader, CTGraphicalObjectFrameLocking.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectFrameLocking parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTGraphicalObjectFrameLocking)POIXMLTypeLoader.parse(param1XMLStreamReader, CTGraphicalObjectFrameLocking.type, null);
    }
    
    public static CTGraphicalObjectFrameLocking parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGraphicalObjectFrameLocking)POIXMLTypeLoader.parse(param1XMLStreamReader, CTGraphicalObjectFrameLocking.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectFrameLocking parse(Node param1Node) throws XmlException {
      return (CTGraphicalObjectFrameLocking)POIXMLTypeLoader.parse(param1Node, CTGraphicalObjectFrameLocking.type, null);
    }
    
    public static CTGraphicalObjectFrameLocking parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTGraphicalObjectFrameLocking)POIXMLTypeLoader.parse(param1Node, CTGraphicalObjectFrameLocking.type, param1XmlOptions);
    }
    
    public static CTGraphicalObjectFrameLocking parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTGraphicalObjectFrameLocking)POIXMLTypeLoader.parse(param1XMLInputStream, CTGraphicalObjectFrameLocking.type, null);
    }
    
    public static CTGraphicalObjectFrameLocking parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTGraphicalObjectFrameLocking)POIXMLTypeLoader.parse(param1XMLInputStream, CTGraphicalObjectFrameLocking.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTGraphicalObjectFrameLocking.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTGraphicalObjectFrameLocking.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTGraphicalObjectFrameLocking.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */