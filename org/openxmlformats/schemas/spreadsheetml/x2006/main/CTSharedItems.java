package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Calendar;
import java.util.List;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlDouble;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTSharedItems extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSharedItems.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctshareditems677atype");
  
  List<CTMissing> getMList();
  
  CTMissing[] getMArray();
  
  CTMissing getMArray(int paramInt);
  
  int sizeOfMArray();
  
  void setMArray(CTMissing[] paramArrayOfCTMissing);
  
  void setMArray(int paramInt, CTMissing paramCTMissing);
  
  CTMissing insertNewM(int paramInt);
  
  CTMissing addNewM();
  
  void removeM(int paramInt);
  
  List<CTNumber> getNList();
  
  CTNumber[] getNArray();
  
  CTNumber getNArray(int paramInt);
  
  int sizeOfNArray();
  
  void setNArray(CTNumber[] paramArrayOfCTNumber);
  
  void setNArray(int paramInt, CTNumber paramCTNumber);
  
  CTNumber insertNewN(int paramInt);
  
  CTNumber addNewN();
  
  void removeN(int paramInt);
  
  List<CTBoolean> getBList();
  
  CTBoolean[] getBArray();
  
  CTBoolean getBArray(int paramInt);
  
  int sizeOfBArray();
  
  void setBArray(CTBoolean[] paramArrayOfCTBoolean);
  
  void setBArray(int paramInt, CTBoolean paramCTBoolean);
  
  CTBoolean insertNewB(int paramInt);
  
  CTBoolean addNewB();
  
  void removeB(int paramInt);
  
  List<CTError> getEList();
  
  CTError[] getEArray();
  
  CTError getEArray(int paramInt);
  
  int sizeOfEArray();
  
  void setEArray(CTError[] paramArrayOfCTError);
  
  void setEArray(int paramInt, CTError paramCTError);
  
  CTError insertNewE(int paramInt);
  
  CTError addNewE();
  
  void removeE(int paramInt);
  
  List<CTString> getSList();
  
  CTString[] getSArray();
  
  CTString getSArray(int paramInt);
  
  int sizeOfSArray();
  
  void setSArray(CTString[] paramArrayOfCTString);
  
  void setSArray(int paramInt, CTString paramCTString);
  
  CTString insertNewS(int paramInt);
  
  CTString addNewS();
  
  void removeS(int paramInt);
  
  List<CTDateTime> getDList();
  
  CTDateTime[] getDArray();
  
  CTDateTime getDArray(int paramInt);
  
  int sizeOfDArray();
  
  void setDArray(CTDateTime[] paramArrayOfCTDateTime);
  
  void setDArray(int paramInt, CTDateTime paramCTDateTime);
  
  CTDateTime insertNewD(int paramInt);
  
  CTDateTime addNewD();
  
  void removeD(int paramInt);
  
  boolean getContainsSemiMixedTypes();
  
  XmlBoolean xgetContainsSemiMixedTypes();
  
  boolean isSetContainsSemiMixedTypes();
  
  void setContainsSemiMixedTypes(boolean paramBoolean);
  
  void xsetContainsSemiMixedTypes(XmlBoolean paramXmlBoolean);
  
  void unsetContainsSemiMixedTypes();
  
  boolean getContainsNonDate();
  
  XmlBoolean xgetContainsNonDate();
  
  boolean isSetContainsNonDate();
  
  void setContainsNonDate(boolean paramBoolean);
  
  void xsetContainsNonDate(XmlBoolean paramXmlBoolean);
  
  void unsetContainsNonDate();
  
  boolean getContainsDate();
  
  XmlBoolean xgetContainsDate();
  
  boolean isSetContainsDate();
  
  void setContainsDate(boolean paramBoolean);
  
  void xsetContainsDate(XmlBoolean paramXmlBoolean);
  
  void unsetContainsDate();
  
  boolean getContainsString();
  
  XmlBoolean xgetContainsString();
  
  boolean isSetContainsString();
  
  void setContainsString(boolean paramBoolean);
  
  void xsetContainsString(XmlBoolean paramXmlBoolean);
  
  void unsetContainsString();
  
  boolean getContainsBlank();
  
  XmlBoolean xgetContainsBlank();
  
  boolean isSetContainsBlank();
  
  void setContainsBlank(boolean paramBoolean);
  
  void xsetContainsBlank(XmlBoolean paramXmlBoolean);
  
  void unsetContainsBlank();
  
  boolean getContainsMixedTypes();
  
  XmlBoolean xgetContainsMixedTypes();
  
  boolean isSetContainsMixedTypes();
  
  void setContainsMixedTypes(boolean paramBoolean);
  
  void xsetContainsMixedTypes(XmlBoolean paramXmlBoolean);
  
  void unsetContainsMixedTypes();
  
  boolean getContainsNumber();
  
  XmlBoolean xgetContainsNumber();
  
  boolean isSetContainsNumber();
  
  void setContainsNumber(boolean paramBoolean);
  
  void xsetContainsNumber(XmlBoolean paramXmlBoolean);
  
  void unsetContainsNumber();
  
  boolean getContainsInteger();
  
  XmlBoolean xgetContainsInteger();
  
  boolean isSetContainsInteger();
  
  void setContainsInteger(boolean paramBoolean);
  
  void xsetContainsInteger(XmlBoolean paramXmlBoolean);
  
  void unsetContainsInteger();
  
  double getMinValue();
  
  XmlDouble xgetMinValue();
  
  boolean isSetMinValue();
  
  void setMinValue(double paramDouble);
  
  void xsetMinValue(XmlDouble paramXmlDouble);
  
  void unsetMinValue();
  
  double getMaxValue();
  
  XmlDouble xgetMaxValue();
  
  boolean isSetMaxValue();
  
  void setMaxValue(double paramDouble);
  
  void xsetMaxValue(XmlDouble paramXmlDouble);
  
  void unsetMaxValue();
  
  Calendar getMinDate();
  
  XmlDateTime xgetMinDate();
  
  boolean isSetMinDate();
  
  void setMinDate(Calendar paramCalendar);
  
  void xsetMinDate(XmlDateTime paramXmlDateTime);
  
  void unsetMinDate();
  
  Calendar getMaxDate();
  
  XmlDateTime xgetMaxDate();
  
  boolean isSetMaxDate();
  
  void setMaxDate(Calendar paramCalendar);
  
  void xsetMaxDate(XmlDateTime paramXmlDateTime);
  
  void unsetMaxDate();
  
  long getCount();
  
  XmlUnsignedInt xgetCount();
  
  boolean isSetCount();
  
  void setCount(long paramLong);
  
  void xsetCount(XmlUnsignedInt paramXmlUnsignedInt);
  
  void unsetCount();
  
  boolean getLongText();
  
  XmlBoolean xgetLongText();
  
  boolean isSetLongText();
  
  void setLongText(boolean paramBoolean);
  
  void xsetLongText(XmlBoolean paramXmlBoolean);
  
  void unsetLongText();
  
  public static final class Factory {
    public static CTSharedItems newInstance() {
      return (CTSharedItems)POIXMLTypeLoader.newInstance(CTSharedItems.type, null);
    }
    
    public static CTSharedItems newInstance(XmlOptions param1XmlOptions) {
      return (CTSharedItems)POIXMLTypeLoader.newInstance(CTSharedItems.type, param1XmlOptions);
    }
    
    public static CTSharedItems parse(String param1String) throws XmlException {
      return (CTSharedItems)POIXMLTypeLoader.parse(param1String, CTSharedItems.type, null);
    }
    
    public static CTSharedItems parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSharedItems)POIXMLTypeLoader.parse(param1String, CTSharedItems.type, param1XmlOptions);
    }
    
    public static CTSharedItems parse(File param1File) throws XmlException, IOException {
      return (CTSharedItems)POIXMLTypeLoader.parse(param1File, CTSharedItems.type, null);
    }
    
    public static CTSharedItems parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSharedItems)POIXMLTypeLoader.parse(param1File, CTSharedItems.type, param1XmlOptions);
    }
    
    public static CTSharedItems parse(URL param1URL) throws XmlException, IOException {
      return (CTSharedItems)POIXMLTypeLoader.parse(param1URL, CTSharedItems.type, null);
    }
    
    public static CTSharedItems parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSharedItems)POIXMLTypeLoader.parse(param1URL, CTSharedItems.type, param1XmlOptions);
    }
    
    public static CTSharedItems parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSharedItems)POIXMLTypeLoader.parse(param1InputStream, CTSharedItems.type, null);
    }
    
    public static CTSharedItems parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSharedItems)POIXMLTypeLoader.parse(param1InputStream, CTSharedItems.type, param1XmlOptions);
    }
    
    public static CTSharedItems parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSharedItems)POIXMLTypeLoader.parse(param1Reader, CTSharedItems.type, null);
    }
    
    public static CTSharedItems parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSharedItems)POIXMLTypeLoader.parse(param1Reader, CTSharedItems.type, param1XmlOptions);
    }
    
    public static CTSharedItems parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSharedItems)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSharedItems.type, null);
    }
    
    public static CTSharedItems parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSharedItems)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSharedItems.type, param1XmlOptions);
    }
    
    public static CTSharedItems parse(Node param1Node) throws XmlException {
      return (CTSharedItems)POIXMLTypeLoader.parse(param1Node, CTSharedItems.type, null);
    }
    
    public static CTSharedItems parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSharedItems)POIXMLTypeLoader.parse(param1Node, CTSharedItems.type, param1XmlOptions);
    }
    
    public static CTSharedItems parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSharedItems)POIXMLTypeLoader.parse(param1XMLInputStream, CTSharedItems.type, null);
    }
    
    public static CTSharedItems parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSharedItems)POIXMLTypeLoader.parse(param1XMLInputStream, CTSharedItems.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSharedItems.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSharedItems.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\openxmlformats\schemas\spreadsheetml\x2006\main\CTSharedItems.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */