package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
import java.net.URL;
import java.util.List;
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

public interface CTLatentStyles extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTLatentStyles.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlatentstyles2e3atype");
  
  List<CTLsdException> getLsdExceptionList();
  
  CTLsdException[] getLsdExceptionArray();
  
  CTLsdException getLsdExceptionArray(int paramInt);
  
  int sizeOfLsdExceptionArray();
  
  void setLsdExceptionArray(CTLsdException[] paramArrayOfCTLsdException);
  
  void setLsdExceptionArray(int paramInt, CTLsdException paramCTLsdException);
  
  CTLsdException insertNewLsdException(int paramInt);
  
  CTLsdException addNewLsdException();
  
  void removeLsdException(int paramInt);
  
  STOnOff.Enum getDefLockedState();
  
  STOnOff xgetDefLockedState();
  
  boolean isSetDefLockedState();
  
  void setDefLockedState(STOnOff.Enum paramEnum);
  
  void xsetDefLockedState(STOnOff paramSTOnOff);
  
  void unsetDefLockedState();
  
  BigInteger getDefUIPriority();
  
  STDecimalNumber xgetDefUIPriority();
  
  boolean isSetDefUIPriority();
  
  void setDefUIPriority(BigInteger paramBigInteger);
  
  void xsetDefUIPriority(STDecimalNumber paramSTDecimalNumber);
  
  void unsetDefUIPriority();
  
  STOnOff.Enum getDefSemiHidden();
  
  STOnOff xgetDefSemiHidden();
  
  boolean isSetDefSemiHidden();
  
  void setDefSemiHidden(STOnOff.Enum paramEnum);
  
  void xsetDefSemiHidden(STOnOff paramSTOnOff);
  
  void unsetDefSemiHidden();
  
  STOnOff.Enum getDefUnhideWhenUsed();
  
  STOnOff xgetDefUnhideWhenUsed();
  
  boolean isSetDefUnhideWhenUsed();
  
  void setDefUnhideWhenUsed(STOnOff.Enum paramEnum);
  
  void xsetDefUnhideWhenUsed(STOnOff paramSTOnOff);
  
  void unsetDefUnhideWhenUsed();
  
  STOnOff.Enum getDefQFormat();
  
  STOnOff xgetDefQFormat();
  
  boolean isSetDefQFormat();
  
  void setDefQFormat(STOnOff.Enum paramEnum);
  
  void xsetDefQFormat(STOnOff paramSTOnOff);
  
  void unsetDefQFormat();
  
  BigInteger getCount();
  
  STDecimalNumber xgetCount();
  
  boolean isSetCount();
  
  void setCount(BigInteger paramBigInteger);
  
  void xsetCount(STDecimalNumber paramSTDecimalNumber);
  
  void unsetCount();
  
  public static final class Factory {
    public static CTLatentStyles newInstance() {
      return (CTLatentStyles)POIXMLTypeLoader.newInstance(CTLatentStyles.type, null);
    }
    
    public static CTLatentStyles newInstance(XmlOptions param1XmlOptions) {
      return (CTLatentStyles)POIXMLTypeLoader.newInstance(CTLatentStyles.type, param1XmlOptions);
    }
    
    public static CTLatentStyles parse(String param1String) throws XmlException {
      return (CTLatentStyles)POIXMLTypeLoader.parse(param1String, CTLatentStyles.type, null);
    }
    
    public static CTLatentStyles parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLatentStyles)POIXMLTypeLoader.parse(param1String, CTLatentStyles.type, param1XmlOptions);
    }
    
    public static CTLatentStyles parse(File param1File) throws XmlException, IOException {
      return (CTLatentStyles)POIXMLTypeLoader.parse(param1File, CTLatentStyles.type, null);
    }
    
    public static CTLatentStyles parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLatentStyles)POIXMLTypeLoader.parse(param1File, CTLatentStyles.type, param1XmlOptions);
    }
    
    public static CTLatentStyles parse(URL param1URL) throws XmlException, IOException {
      return (CTLatentStyles)POIXMLTypeLoader.parse(param1URL, CTLatentStyles.type, null);
    }
    
    public static CTLatentStyles parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLatentStyles)POIXMLTypeLoader.parse(param1URL, CTLatentStyles.type, param1XmlOptions);
    }
    
    public static CTLatentStyles parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTLatentStyles)POIXMLTypeLoader.parse(param1InputStream, CTLatentStyles.type, null);
    }
    
    public static CTLatentStyles parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLatentStyles)POIXMLTypeLoader.parse(param1InputStream, CTLatentStyles.type, param1XmlOptions);
    }
    
    public static CTLatentStyles parse(Reader param1Reader) throws XmlException, IOException {
      return (CTLatentStyles)POIXMLTypeLoader.parse(param1Reader, CTLatentStyles.type, null);
    }
    
    public static CTLatentStyles parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLatentStyles)POIXMLTypeLoader.parse(param1Reader, CTLatentStyles.type, param1XmlOptions);
    }
    
    public static CTLatentStyles parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTLatentStyles)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLatentStyles.type, null);
    }
    
    public static CTLatentStyles parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLatentStyles)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLatentStyles.type, param1XmlOptions);
    }
    
    public static CTLatentStyles parse(Node param1Node) throws XmlException {
      return (CTLatentStyles)POIXMLTypeLoader.parse(param1Node, CTLatentStyles.type, null);
    }
    
    public static CTLatentStyles parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLatentStyles)POIXMLTypeLoader.parse(param1Node, CTLatentStyles.type, param1XmlOptions);
    }
    
    public static CTLatentStyles parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTLatentStyles)POIXMLTypeLoader.parse(param1XMLInputStream, CTLatentStyles.type, null);
    }
    
    public static CTLatentStyles parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTLatentStyles)POIXMLTypeLoader.parse(param1XMLInputStream, CTLatentStyles.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLatentStyles.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLatentStyles.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTLatentStyles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */