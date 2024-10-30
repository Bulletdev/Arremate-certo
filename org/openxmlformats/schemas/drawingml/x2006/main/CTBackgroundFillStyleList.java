package org.openxmlformats.schemas.drawingml.x2006.main;

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

public interface CTBackgroundFillStyleList extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTBackgroundFillStyleList.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctbackgroundfillstylelist13cftype");
  
  List<CTNoFillProperties> getNoFillList();
  
  CTNoFillProperties[] getNoFillArray();
  
  CTNoFillProperties getNoFillArray(int paramInt);
  
  int sizeOfNoFillArray();
  
  void setNoFillArray(CTNoFillProperties[] paramArrayOfCTNoFillProperties);
  
  void setNoFillArray(int paramInt, CTNoFillProperties paramCTNoFillProperties);
  
  CTNoFillProperties insertNewNoFill(int paramInt);
  
  CTNoFillProperties addNewNoFill();
  
  void removeNoFill(int paramInt);
  
  List<CTSolidColorFillProperties> getSolidFillList();
  
  CTSolidColorFillProperties[] getSolidFillArray();
  
  CTSolidColorFillProperties getSolidFillArray(int paramInt);
  
  int sizeOfSolidFillArray();
  
  void setSolidFillArray(CTSolidColorFillProperties[] paramArrayOfCTSolidColorFillProperties);
  
  void setSolidFillArray(int paramInt, CTSolidColorFillProperties paramCTSolidColorFillProperties);
  
  CTSolidColorFillProperties insertNewSolidFill(int paramInt);
  
  CTSolidColorFillProperties addNewSolidFill();
  
  void removeSolidFill(int paramInt);
  
  List<CTGradientFillProperties> getGradFillList();
  
  CTGradientFillProperties[] getGradFillArray();
  
  CTGradientFillProperties getGradFillArray(int paramInt);
  
  int sizeOfGradFillArray();
  
  void setGradFillArray(CTGradientFillProperties[] paramArrayOfCTGradientFillProperties);
  
  void setGradFillArray(int paramInt, CTGradientFillProperties paramCTGradientFillProperties);
  
  CTGradientFillProperties insertNewGradFill(int paramInt);
  
  CTGradientFillProperties addNewGradFill();
  
  void removeGradFill(int paramInt);
  
  List<CTBlipFillProperties> getBlipFillList();
  
  CTBlipFillProperties[] getBlipFillArray();
  
  CTBlipFillProperties getBlipFillArray(int paramInt);
  
  int sizeOfBlipFillArray();
  
  void setBlipFillArray(CTBlipFillProperties[] paramArrayOfCTBlipFillProperties);
  
  void setBlipFillArray(int paramInt, CTBlipFillProperties paramCTBlipFillProperties);
  
  CTBlipFillProperties insertNewBlipFill(int paramInt);
  
  CTBlipFillProperties addNewBlipFill();
  
  void removeBlipFill(int paramInt);
  
  List<CTPatternFillProperties> getPattFillList();
  
  CTPatternFillProperties[] getPattFillArray();
  
  CTPatternFillProperties getPattFillArray(int paramInt);
  
  int sizeOfPattFillArray();
  
  void setPattFillArray(CTPatternFillProperties[] paramArrayOfCTPatternFillProperties);
  
  void setPattFillArray(int paramInt, CTPatternFillProperties paramCTPatternFillProperties);
  
  CTPatternFillProperties insertNewPattFill(int paramInt);
  
  CTPatternFillProperties addNewPattFill();
  
  void removePattFill(int paramInt);
  
  List<CTGroupFillProperties> getGrpFillList();
  
  CTGroupFillProperties[] getGrpFillArray();
  
  CTGroupFillProperties getGrpFillArray(int paramInt);
  
  int sizeOfGrpFillArray();
  
  void setGrpFillArray(CTGroupFillProperties[] paramArrayOfCTGroupFillProperties);
  
  void setGrpFillArray(int paramInt, CTGroupFillProperties paramCTGroupFillProperties);
  
  CTGroupFillProperties insertNewGrpFill(int paramInt);
  
  CTGroupFillProperties addNewGrpFill();
  
  void removeGrpFill(int paramInt);
  
  public static final class Factory {
    public static CTBackgroundFillStyleList newInstance() {
      return (CTBackgroundFillStyleList)POIXMLTypeLoader.newInstance(CTBackgroundFillStyleList.type, null);
    }
    
    public static CTBackgroundFillStyleList newInstance(XmlOptions param1XmlOptions) {
      return (CTBackgroundFillStyleList)POIXMLTypeLoader.newInstance(CTBackgroundFillStyleList.type, param1XmlOptions);
    }
    
    public static CTBackgroundFillStyleList parse(String param1String) throws XmlException {
      return (CTBackgroundFillStyleList)POIXMLTypeLoader.parse(param1String, CTBackgroundFillStyleList.type, null);
    }
    
    public static CTBackgroundFillStyleList parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBackgroundFillStyleList)POIXMLTypeLoader.parse(param1String, CTBackgroundFillStyleList.type, param1XmlOptions);
    }
    
    public static CTBackgroundFillStyleList parse(File param1File) throws XmlException, IOException {
      return (CTBackgroundFillStyleList)POIXMLTypeLoader.parse(param1File, CTBackgroundFillStyleList.type, null);
    }
    
    public static CTBackgroundFillStyleList parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBackgroundFillStyleList)POIXMLTypeLoader.parse(param1File, CTBackgroundFillStyleList.type, param1XmlOptions);
    }
    
    public static CTBackgroundFillStyleList parse(URL param1URL) throws XmlException, IOException {
      return (CTBackgroundFillStyleList)POIXMLTypeLoader.parse(param1URL, CTBackgroundFillStyleList.type, null);
    }
    
    public static CTBackgroundFillStyleList parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBackgroundFillStyleList)POIXMLTypeLoader.parse(param1URL, CTBackgroundFillStyleList.type, param1XmlOptions);
    }
    
    public static CTBackgroundFillStyleList parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTBackgroundFillStyleList)POIXMLTypeLoader.parse(param1InputStream, CTBackgroundFillStyleList.type, null);
    }
    
    public static CTBackgroundFillStyleList parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBackgroundFillStyleList)POIXMLTypeLoader.parse(param1InputStream, CTBackgroundFillStyleList.type, param1XmlOptions);
    }
    
    public static CTBackgroundFillStyleList parse(Reader param1Reader) throws XmlException, IOException {
      return (CTBackgroundFillStyleList)POIXMLTypeLoader.parse(param1Reader, CTBackgroundFillStyleList.type, null);
    }
    
    public static CTBackgroundFillStyleList parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTBackgroundFillStyleList)POIXMLTypeLoader.parse(param1Reader, CTBackgroundFillStyleList.type, param1XmlOptions);
    }
    
    public static CTBackgroundFillStyleList parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTBackgroundFillStyleList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBackgroundFillStyleList.type, null);
    }
    
    public static CTBackgroundFillStyleList parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBackgroundFillStyleList)POIXMLTypeLoader.parse(param1XMLStreamReader, CTBackgroundFillStyleList.type, param1XmlOptions);
    }
    
    public static CTBackgroundFillStyleList parse(Node param1Node) throws XmlException {
      return (CTBackgroundFillStyleList)POIXMLTypeLoader.parse(param1Node, CTBackgroundFillStyleList.type, null);
    }
    
    public static CTBackgroundFillStyleList parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTBackgroundFillStyleList)POIXMLTypeLoader.parse(param1Node, CTBackgroundFillStyleList.type, param1XmlOptions);
    }
    
    public static CTBackgroundFillStyleList parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTBackgroundFillStyleList)POIXMLTypeLoader.parse(param1XMLInputStream, CTBackgroundFillStyleList.type, null);
    }
    
    public static CTBackgroundFillStyleList parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTBackgroundFillStyleList)POIXMLTypeLoader.parse(param1XMLInputStream, CTBackgroundFillStyleList.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBackgroundFillStyleList.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTBackgroundFillStyleList.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\drawingml\x2006\main\CTBackgroundFillStyleList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */