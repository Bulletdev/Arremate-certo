package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
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

public interface CTLsdException extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTLsdException.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlsdexceptiona296type");
  
  String getName();
  
  STString xgetName();
  
  void setName(String paramString);
  
  void xsetName(STString paramSTString);
  
  STOnOff.Enum getLocked();
  
  STOnOff xgetLocked();
  
  boolean isSetLocked();
  
  void setLocked(STOnOff.Enum paramEnum);
  
  void xsetLocked(STOnOff paramSTOnOff);
  
  void unsetLocked();
  
  BigInteger getUiPriority();
  
  STDecimalNumber xgetUiPriority();
  
  boolean isSetUiPriority();
  
  void setUiPriority(BigInteger paramBigInteger);
  
  void xsetUiPriority(STDecimalNumber paramSTDecimalNumber);
  
  void unsetUiPriority();
  
  STOnOff.Enum getSemiHidden();
  
  STOnOff xgetSemiHidden();
  
  boolean isSetSemiHidden();
  
  void setSemiHidden(STOnOff.Enum paramEnum);
  
  void xsetSemiHidden(STOnOff paramSTOnOff);
  
  void unsetSemiHidden();
  
  STOnOff.Enum getUnhideWhenUsed();
  
  STOnOff xgetUnhideWhenUsed();
  
  boolean isSetUnhideWhenUsed();
  
  void setUnhideWhenUsed(STOnOff.Enum paramEnum);
  
  void xsetUnhideWhenUsed(STOnOff paramSTOnOff);
  
  void unsetUnhideWhenUsed();
  
  STOnOff.Enum getQFormat();
  
  STOnOff xgetQFormat();
  
  boolean isSetQFormat();
  
  void setQFormat(STOnOff.Enum paramEnum);
  
  void xsetQFormat(STOnOff paramSTOnOff);
  
  void unsetQFormat();
  
  public static final class Factory {
    public static CTLsdException newInstance() {
      return (CTLsdException)POIXMLTypeLoader.newInstance(CTLsdException.type, null);
    }
    
    public static CTLsdException newInstance(XmlOptions param1XmlOptions) {
      return (CTLsdException)POIXMLTypeLoader.newInstance(CTLsdException.type, param1XmlOptions);
    }
    
    public static CTLsdException parse(String param1String) throws XmlException {
      return (CTLsdException)POIXMLTypeLoader.parse(param1String, CTLsdException.type, null);
    }
    
    public static CTLsdException parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLsdException)POIXMLTypeLoader.parse(param1String, CTLsdException.type, param1XmlOptions);
    }
    
    public static CTLsdException parse(File param1File) throws XmlException, IOException {
      return (CTLsdException)POIXMLTypeLoader.parse(param1File, CTLsdException.type, null);
    }
    
    public static CTLsdException parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLsdException)POIXMLTypeLoader.parse(param1File, CTLsdException.type, param1XmlOptions);
    }
    
    public static CTLsdException parse(URL param1URL) throws XmlException, IOException {
      return (CTLsdException)POIXMLTypeLoader.parse(param1URL, CTLsdException.type, null);
    }
    
    public static CTLsdException parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLsdException)POIXMLTypeLoader.parse(param1URL, CTLsdException.type, param1XmlOptions);
    }
    
    public static CTLsdException parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTLsdException)POIXMLTypeLoader.parse(param1InputStream, CTLsdException.type, null);
    }
    
    public static CTLsdException parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLsdException)POIXMLTypeLoader.parse(param1InputStream, CTLsdException.type, param1XmlOptions);
    }
    
    public static CTLsdException parse(Reader param1Reader) throws XmlException, IOException {
      return (CTLsdException)POIXMLTypeLoader.parse(param1Reader, CTLsdException.type, null);
    }
    
    public static CTLsdException parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLsdException)POIXMLTypeLoader.parse(param1Reader, CTLsdException.type, param1XmlOptions);
    }
    
    public static CTLsdException parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTLsdException)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLsdException.type, null);
    }
    
    public static CTLsdException parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLsdException)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLsdException.type, param1XmlOptions);
    }
    
    public static CTLsdException parse(Node param1Node) throws XmlException {
      return (CTLsdException)POIXMLTypeLoader.parse(param1Node, CTLsdException.type, null);
    }
    
    public static CTLsdException parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLsdException)POIXMLTypeLoader.parse(param1Node, CTLsdException.type, param1XmlOptions);
    }
    
    public static CTLsdException parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTLsdException)POIXMLTypeLoader.parse(param1XMLInputStream, CTLsdException.type, null);
    }
    
    public static CTLsdException parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTLsdException)POIXMLTypeLoader.parse(param1XMLInputStream, CTLsdException.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLsdException.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLsdException.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTLsdException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */