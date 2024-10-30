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

public interface CTBorder extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTBorder.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctbordercdfctype");
  
  STBorder.Enum getVal();
  
  STBorder xgetVal();
  
  void setVal(STBorder.Enum paramEnum);
  
  void xsetVal(STBorder paramSTBorder);
  
  Object getColor();
  
  STHexColor xgetColor();
  
  boolean isSetColor();
  
  void setColor(Object paramObject);
  
  void xsetColor(STHexColor paramSTHexColor);
  
  void unsetColor();
  
  STThemeColor$Enum getThemeColor();
  
  STThemeColor xgetThemeColor();
  
  boolean isSetThemeColor();
  
  void setThemeColor(STThemeColor$Enum paramSTThemeColor$Enum);
  
  void xsetThemeColor(STThemeColor paramSTThemeColor);
  
  void unsetThemeColor();
  
  byte[] getThemeTint();
  
  STUcharHexNumber xgetThemeTint();
  
  boolean isSetThemeTint();
  
  void setThemeTint(byte[] paramArrayOfbyte);
  
  void xsetThemeTint(STUcharHexNumber paramSTUcharHexNumber);
  
  void unsetThemeTint();
  
  byte[] getThemeShade();
  
  STUcharHexNumber xgetThemeShade();
  
  boolean isSetThemeShade();
  
  void setThemeShade(byte[] paramArrayOfbyte);
  
  void xsetThemeShade(STUcharHexNumber paramSTUcharHexNumber);
  
  void unsetThemeShade();
  
  BigInteger getSz();
  
  STEighthPointMeasure xgetSz();
  
  boolean isSetSz();
  
  void setSz(BigInteger paramBigInteger);
  
  void xsetSz(STEighthPointMeasure paramSTEighthPointMeasure);
  
  void unsetSz();
  
  BigInteger getSpace();
  
  STPointMeasure xgetSpace();
  
  boolean isSetSpace();
  
  void setSpace(BigInteger paramBigInteger);
  
  void xsetSpace(STPointMeasure paramSTPointMeasure);
  
  void unsetSpace();
  
  STOnOff.Enum getShadow();
  
  STOnOff xgetShadow();
  
  boolean isSetShadow();
  
  void setShadow(STOnOff.Enum paramEnum);
  
  void xsetShadow(STOnOff paramSTOnOff);
  
  void unsetShadow();
  
  STOnOff.Enum getFrame();
  
  STOnOff xgetFrame();
  
  boolean isSetFrame();
  
  void setFrame(STOnOff.Enum paramEnum);
  
  void xsetFrame(STOnOff paramSTOnOff);
  
  void unsetFrame();
  
  public static final class Factory {
    public static CTBorder newInstance() {
      return (CTBorder)POIXMLTypeLoader.newInstance(CTBorder.type, null);
    }
    
    public static CTBorder newInstance(XmlOptions param1XmlOptions) {
      return (CTBorder)POIXMLTypeLoader.newInstance(CTBorder.type, param1XmlOptions);
    }
    
    public static CTBorder parse(String param1String) throws XmlException {
      return (CTBorder)POIXMLTypeLoader.parse(param1String, CTBorder.type, null);
    }
    
    public static CTBorder parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBorder)POIXMLTypeLoader.parse(param1String, CTBorder.type, param1XmlOptions);
    }
    
    public static CTBorder parse(File param1File) throws XmlException, IOException {
      return (CTBorder)POIXMLTypeLoader.parse(param1File, CTBorder.type, null);
    }
    
    public static CTBorder parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBorder)POIXMLTypeLoader.parse(param1File, CTBorder.type, param1XmlOptions);
    }
    
    public static CTBorder parse(URL param1URL) throws XmlException, IOException {
      return (CTBorder)POIXMLTypeLoader.parse(param1URL, CTBorder.type, null);
    }
    
    public static CTBorder parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBorder)POIXMLTypeLoader.parse(param1URL, CTBorder.type, param1XmlOptions);
    }
    
    public static CTBorder parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTBorder)POIXMLTypeLoader.parse(param1InputStream, CTBorder.type, null);
    }
    
    public static CTBorder parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBorder)POIXMLTypeLoader.parse(param1InputStream, CTBorder.type, param1XmlOptions);
    }
    
    public static CTBorder parse(Reader param1Reader) throws XmlException, IOException {
      return (CTBorder)POIXMLTypeLoader.parse(param1Reader, CTBorder.type, null);
    }
    
    public static CTBorder parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBorder)POIXMLTypeLoader.parse(param1Reader, CTBorder.type, param1XmlOptions);
    }
    
    public static CTBorder parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTBorder)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBorder.type, null);
    }
    
    public static CTBorder parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBorder)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBorder.type, param1XmlOptions);
    }
    
    public static CTBorder parse(Node param1Node) throws XmlException {
      return (CTBorder)POIXMLTypeLoader.parse(param1Node, CTBorder.type, null);
    }
    
    public static CTBorder parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBorder)POIXMLTypeLoader.parse(param1Node, CTBorder.type, param1XmlOptions);
    }
    
    public static CTBorder parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTBorder)POIXMLTypeLoader.parse(param1XMLInputStream, CTBorder.type, null);
    }
    
    public static CTBorder parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTBorder)POIXMLTypeLoader.parse(param1XMLInputStream, CTBorder.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBorder.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBorder.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\wordprocessingml\x2006\main\CTBorder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */