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
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTWorkbookProtection extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTWorkbookProtection.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctworkbookprotection56bctype");
  
  byte[] getWorkbookPassword();
  
  STUnsignedShortHex xgetWorkbookPassword();
  
  boolean isSetWorkbookPassword();
  
  void setWorkbookPassword(byte[] paramArrayOfbyte);
  
  void xsetWorkbookPassword(STUnsignedShortHex paramSTUnsignedShortHex);
  
  void unsetWorkbookPassword();
  
  byte[] getRevisionsPassword();
  
  STUnsignedShortHex xgetRevisionsPassword();
  
  boolean isSetRevisionsPassword();
  
  void setRevisionsPassword(byte[] paramArrayOfbyte);
  
  void xsetRevisionsPassword(STUnsignedShortHex paramSTUnsignedShortHex);
  
  void unsetRevisionsPassword();
  
  boolean getLockStructure();
  
  XmlBoolean xgetLockStructure();
  
  boolean isSetLockStructure();
  
  void setLockStructure(boolean paramBoolean);
  
  void xsetLockStructure(XmlBoolean paramXmlBoolean);
  
  void unsetLockStructure();
  
  boolean getLockWindows();
  
  XmlBoolean xgetLockWindows();
  
  boolean isSetLockWindows();
  
  void setLockWindows(boolean paramBoolean);
  
  void xsetLockWindows(XmlBoolean paramXmlBoolean);
  
  void unsetLockWindows();
  
  boolean getLockRevision();
  
  XmlBoolean xgetLockRevision();
  
  boolean isSetLockRevision();
  
  void setLockRevision(boolean paramBoolean);
  
  void xsetLockRevision(XmlBoolean paramXmlBoolean);
  
  void unsetLockRevision();
  
  public static final class Factory {
    public static CTWorkbookProtection newInstance() {
      return (CTWorkbookProtection)POIXMLTypeLoader.newInstance(CTWorkbookProtection.type, null);
    }
    
    public static CTWorkbookProtection newInstance(XmlOptions param1XmlOptions) {
      return (CTWorkbookProtection)POIXMLTypeLoader.newInstance(CTWorkbookProtection.type, param1XmlOptions);
    }
    
    public static CTWorkbookProtection parse(String param1String) throws XmlException {
      return (CTWorkbookProtection)POIXMLTypeLoader.parse(param1String, CTWorkbookProtection.type, null);
    }
    
    public static CTWorkbookProtection parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTWorkbookProtection)POIXMLTypeLoader.parse(param1String, CTWorkbookProtection.type, param1XmlOptions);
    }
    
    public static CTWorkbookProtection parse(File param1File) throws XmlException, IOException {
      return (CTWorkbookProtection)POIXMLTypeLoader.parse(param1File, CTWorkbookProtection.type, null);
    }
    
    public static CTWorkbookProtection parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTWorkbookProtection)POIXMLTypeLoader.parse(param1File, CTWorkbookProtection.type, param1XmlOptions);
    }
    
    public static CTWorkbookProtection parse(URL param1URL) throws XmlException, IOException {
      return (CTWorkbookProtection)POIXMLTypeLoader.parse(param1URL, CTWorkbookProtection.type, null);
    }
    
    public static CTWorkbookProtection parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTWorkbookProtection)POIXMLTypeLoader.parse(param1URL, CTWorkbookProtection.type, param1XmlOptions);
    }
    
    public static CTWorkbookProtection parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTWorkbookProtection)POIXMLTypeLoader.parse(param1InputStream, CTWorkbookProtection.type, null);
    }
    
    public static CTWorkbookProtection parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTWorkbookProtection)POIXMLTypeLoader.parse(param1InputStream, CTWorkbookProtection.type, param1XmlOptions);
    }
    
    public static CTWorkbookProtection parse(Reader param1Reader) throws XmlException, IOException {
      return (CTWorkbookProtection)POIXMLTypeLoader.parse(param1Reader, CTWorkbookProtection.type, null);
    }
    
    public static CTWorkbookProtection parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTWorkbookProtection)POIXMLTypeLoader.parse(param1Reader, CTWorkbookProtection.type, param1XmlOptions);
    }
    
    public static CTWorkbookProtection parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTWorkbookProtection)POIXMLTypeLoader.parse(param1XMLStreamReader, CTWorkbookProtection.type, null);
    }
    
    public static CTWorkbookProtection parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTWorkbookProtection)POIXMLTypeLoader.parse(param1XMLStreamReader, CTWorkbookProtection.type, param1XmlOptions);
    }
    
    public static CTWorkbookProtection parse(Node param1Node) throws XmlException {
      return (CTWorkbookProtection)POIXMLTypeLoader.parse(param1Node, CTWorkbookProtection.type, null);
    }
    
    public static CTWorkbookProtection parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTWorkbookProtection)POIXMLTypeLoader.parse(param1Node, CTWorkbookProtection.type, param1XmlOptions);
    }
    
    public static CTWorkbookProtection parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTWorkbookProtection)POIXMLTypeLoader.parse(param1XMLInputStream, CTWorkbookProtection.type, null);
    }
    
    public static CTWorkbookProtection parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTWorkbookProtection)POIXMLTypeLoader.parse(param1XMLInputStream, CTWorkbookProtection.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTWorkbookProtection.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTWorkbookProtection.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTWorkbookProtection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */