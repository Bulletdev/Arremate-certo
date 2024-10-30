package com.microsoft.schemas.office.office;

import com.microsoft.schemas.vml.STExt;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
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

public interface CTLock extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTLock.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("ctlock6b8etype");
  
  STExt.Enum getExt();
  
  STExt xgetExt();
  
  boolean isSetExt();
  
  void setExt(STExt.Enum paramEnum);
  
  void xsetExt(STExt paramSTExt);
  
  void unsetExt();
  
  STTrueFalse$Enum getPosition();
  
  STTrueFalse xgetPosition();
  
  boolean isSetPosition();
  
  void setPosition(STTrueFalse$Enum paramSTTrueFalse$Enum);
  
  void xsetPosition(STTrueFalse paramSTTrueFalse);
  
  void unsetPosition();
  
  STTrueFalse$Enum getSelection();
  
  STTrueFalse xgetSelection();
  
  boolean isSetSelection();
  
  void setSelection(STTrueFalse$Enum paramSTTrueFalse$Enum);
  
  void xsetSelection(STTrueFalse paramSTTrueFalse);
  
  void unsetSelection();
  
  STTrueFalse$Enum getGrouping();
  
  STTrueFalse xgetGrouping();
  
  boolean isSetGrouping();
  
  void setGrouping(STTrueFalse$Enum paramSTTrueFalse$Enum);
  
  void xsetGrouping(STTrueFalse paramSTTrueFalse);
  
  void unsetGrouping();
  
  STTrueFalse$Enum getUngrouping();
  
  STTrueFalse xgetUngrouping();
  
  boolean isSetUngrouping();
  
  void setUngrouping(STTrueFalse$Enum paramSTTrueFalse$Enum);
  
  void xsetUngrouping(STTrueFalse paramSTTrueFalse);
  
  void unsetUngrouping();
  
  STTrueFalse$Enum getRotation();
  
  STTrueFalse xgetRotation();
  
  boolean isSetRotation();
  
  void setRotation(STTrueFalse$Enum paramSTTrueFalse$Enum);
  
  void xsetRotation(STTrueFalse paramSTTrueFalse);
  
  void unsetRotation();
  
  STTrueFalse$Enum getCropping();
  
  STTrueFalse xgetCropping();
  
  boolean isSetCropping();
  
  void setCropping(STTrueFalse$Enum paramSTTrueFalse$Enum);
  
  void xsetCropping(STTrueFalse paramSTTrueFalse);
  
  void unsetCropping();
  
  STTrueFalse$Enum getVerticies();
  
  STTrueFalse xgetVerticies();
  
  boolean isSetVerticies();
  
  void setVerticies(STTrueFalse$Enum paramSTTrueFalse$Enum);
  
  void xsetVerticies(STTrueFalse paramSTTrueFalse);
  
  void unsetVerticies();
  
  STTrueFalse$Enum getAdjusthandles();
  
  STTrueFalse xgetAdjusthandles();
  
  boolean isSetAdjusthandles();
  
  void setAdjusthandles(STTrueFalse$Enum paramSTTrueFalse$Enum);
  
  void xsetAdjusthandles(STTrueFalse paramSTTrueFalse);
  
  void unsetAdjusthandles();
  
  STTrueFalse$Enum getText();
  
  STTrueFalse xgetText();
  
  boolean isSetText();
  
  void setText(STTrueFalse$Enum paramSTTrueFalse$Enum);
  
  void xsetText(STTrueFalse paramSTTrueFalse);
  
  void unsetText();
  
  STTrueFalse$Enum getAspectratio();
  
  STTrueFalse xgetAspectratio();
  
  boolean isSetAspectratio();
  
  void setAspectratio(STTrueFalse$Enum paramSTTrueFalse$Enum);
  
  void xsetAspectratio(STTrueFalse paramSTTrueFalse);
  
  void unsetAspectratio();
  
  STTrueFalse$Enum getShapetype();
  
  STTrueFalse xgetShapetype();
  
  boolean isSetShapetype();
  
  void setShapetype(STTrueFalse$Enum paramSTTrueFalse$Enum);
  
  void xsetShapetype(STTrueFalse paramSTTrueFalse);
  
  void unsetShapetype();
  
  public static final class Factory {
    public static CTLock newInstance() {
      return (CTLock)POIXMLTypeLoader.newInstance(CTLock.type, null);
    }
    
    public static CTLock newInstance(XmlOptions param1XmlOptions) {
      return (CTLock)POIXMLTypeLoader.newInstance(CTLock.type, param1XmlOptions);
    }
    
    public static CTLock parse(String param1String) throws XmlException {
      return (CTLock)POIXMLTypeLoader.parse(param1String, CTLock.type, null);
    }
    
    public static CTLock parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLock)POIXMLTypeLoader.parse(param1String, CTLock.type, param1XmlOptions);
    }
    
    public static CTLock parse(File param1File) throws XmlException, IOException {
      return (CTLock)POIXMLTypeLoader.parse(param1File, CTLock.type, null);
    }
    
    public static CTLock parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLock)POIXMLTypeLoader.parse(param1File, CTLock.type, param1XmlOptions);
    }
    
    public static CTLock parse(URL param1URL) throws XmlException, IOException {
      return (CTLock)POIXMLTypeLoader.parse(param1URL, CTLock.type, null);
    }
    
    public static CTLock parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLock)POIXMLTypeLoader.parse(param1URL, CTLock.type, param1XmlOptions);
    }
    
    public static CTLock parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTLock)POIXMLTypeLoader.parse(param1InputStream, CTLock.type, null);
    }
    
    public static CTLock parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLock)POIXMLTypeLoader.parse(param1InputStream, CTLock.type, param1XmlOptions);
    }
    
    public static CTLock parse(Reader param1Reader) throws XmlException, IOException {
      return (CTLock)POIXMLTypeLoader.parse(param1Reader, CTLock.type, null);
    }
    
    public static CTLock parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTLock)POIXMLTypeLoader.parse(param1Reader, CTLock.type, param1XmlOptions);
    }
    
    public static CTLock parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTLock)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLock.type, null);
    }
    
    public static CTLock parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLock)POIXMLTypeLoader.parse(param1XMLStreamReader, CTLock.type, param1XmlOptions);
    }
    
    public static CTLock parse(Node param1Node) throws XmlException {
      return (CTLock)POIXMLTypeLoader.parse(param1Node, CTLock.type, null);
    }
    
    public static CTLock parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTLock)POIXMLTypeLoader.parse(param1Node, CTLock.type, param1XmlOptions);
    }
    
    public static CTLock parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTLock)POIXMLTypeLoader.parse(param1XMLInputStream, CTLock.type, null);
    }
    
    public static CTLock parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTLock)POIXMLTypeLoader.parse(param1XMLInputStream, CTLock.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLock.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTLock.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\office\CTLock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */