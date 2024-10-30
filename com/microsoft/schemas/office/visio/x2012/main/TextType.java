package com.microsoft.schemas.office.visio.x2012.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
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

public interface TextType extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(TextType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("texttyped2ectype");
  
  List<CpType> getCpList();
  
  CpType[] getCpArray();
  
  CpType getCpArray(int paramInt);
  
  int sizeOfCpArray();
  
  void setCpArray(CpType[] paramArrayOfCpType);
  
  void setCpArray(int paramInt, CpType paramCpType);
  
  CpType insertNewCp(int paramInt);
  
  CpType addNewCp();
  
  void removeCp(int paramInt);
  
  List<PpType> getPpList();
  
  PpType[] getPpArray();
  
  PpType getPpArray(int paramInt);
  
  int sizeOfPpArray();
  
  void setPpArray(PpType[] paramArrayOfPpType);
  
  void setPpArray(int paramInt, PpType paramPpType);
  
  PpType insertNewPp(int paramInt);
  
  PpType addNewPp();
  
  void removePp(int paramInt);
  
  List<TpType> getTpList();
  
  TpType[] getTpArray();
  
  TpType getTpArray(int paramInt);
  
  int sizeOfTpArray();
  
  void setTpArray(TpType[] paramArrayOfTpType);
  
  void setTpArray(int paramInt, TpType paramTpType);
  
  TpType insertNewTp(int paramInt);
  
  TpType addNewTp();
  
  void removeTp(int paramInt);
  
  List<FldType> getFldList();
  
  FldType[] getFldArray();
  
  FldType getFldArray(int paramInt);
  
  int sizeOfFldArray();
  
  void setFldArray(FldType[] paramArrayOfFldType);
  
  void setFldArray(int paramInt, FldType paramFldType);
  
  FldType insertNewFld(int paramInt);
  
  FldType addNewFld();
  
  void removeFld(int paramInt);
  
  public static final class Factory {
    public static TextType newInstance() {
      return (TextType)POIXMLTypeLoader.newInstance(TextType.type, null);
    }
    
    public static TextType newInstance(XmlOptions param1XmlOptions) {
      return (TextType)POIXMLTypeLoader.newInstance(TextType.type, param1XmlOptions);
    }
    
    public static TextType parse(String param1String) throws XmlException {
      return (TextType)POIXMLTypeLoader.parse(param1String, TextType.type, null);
    }
    
    public static TextType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (TextType)POIXMLTypeLoader.parse(param1String, TextType.type, param1XmlOptions);
    }
    
    public static TextType parse(File param1File) throws XmlException, IOException {
      return (TextType)POIXMLTypeLoader.parse(param1File, TextType.type, null);
    }
    
    public static TextType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (TextType)POIXMLTypeLoader.parse(param1File, TextType.type, param1XmlOptions);
    }
    
    public static TextType parse(URL param1URL) throws XmlException, IOException {
      return (TextType)POIXMLTypeLoader.parse(param1URL, TextType.type, null);
    }
    
    public static TextType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (TextType)POIXMLTypeLoader.parse(param1URL, TextType.type, param1XmlOptions);
    }
    
    public static TextType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (TextType)POIXMLTypeLoader.parse(param1InputStream, TextType.type, null);
    }
    
    public static TextType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (TextType)POIXMLTypeLoader.parse(param1InputStream, TextType.type, param1XmlOptions);
    }
    
    public static TextType parse(Reader param1Reader) throws XmlException, IOException {
      return (TextType)POIXMLTypeLoader.parse(param1Reader, TextType.type, null);
    }
    
    public static TextType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (TextType)POIXMLTypeLoader.parse(param1Reader, TextType.type, param1XmlOptions);
    }
    
    public static TextType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (TextType)POIXMLTypeLoader.parse(param1XMLStreamReader, TextType.type, null);
    }
    
    public static TextType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (TextType)POIXMLTypeLoader.parse(param1XMLStreamReader, TextType.type, param1XmlOptions);
    }
    
    public static TextType parse(Node param1Node) throws XmlException {
      return (TextType)POIXMLTypeLoader.parse(param1Node, TextType.type, null);
    }
    
    public static TextType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (TextType)POIXMLTypeLoader.parse(param1Node, TextType.type, param1XmlOptions);
    }
    
    public static TextType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (TextType)POIXMLTypeLoader.parse(param1XMLInputStream, TextType.type, null);
    }
    
    public static TextType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (TextType)POIXMLTypeLoader.parse(param1XMLInputStream, TextType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, TextType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, TextType.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\TextType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */