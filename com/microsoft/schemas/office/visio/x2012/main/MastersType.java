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

public interface MastersType extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(MastersType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2").resolveHandle("masterstypeaebatype");
  
  List<MasterType> getMasterList();
  
  MasterType[] getMasterArray();
  
  MasterType getMasterArray(int paramInt);
  
  int sizeOfMasterArray();
  
  void setMasterArray(MasterType[] paramArrayOfMasterType);
  
  void setMasterArray(int paramInt, MasterType paramMasterType);
  
  MasterType insertNewMaster(int paramInt);
  
  MasterType addNewMaster();
  
  void removeMaster(int paramInt);
  
  List<MasterShortcutType> getMasterShortcutList();
  
  MasterShortcutType[] getMasterShortcutArray();
  
  MasterShortcutType getMasterShortcutArray(int paramInt);
  
  int sizeOfMasterShortcutArray();
  
  void setMasterShortcutArray(MasterShortcutType[] paramArrayOfMasterShortcutType);
  
  void setMasterShortcutArray(int paramInt, MasterShortcutType paramMasterShortcutType);
  
  MasterShortcutType insertNewMasterShortcut(int paramInt);
  
  MasterShortcutType addNewMasterShortcut();
  
  void removeMasterShortcut(int paramInt);
  
  public static final class Factory {
    public static MastersType newInstance() {
      return (MastersType)POIXMLTypeLoader.newInstance(MastersType.type, null);
    }
    
    public static MastersType newInstance(XmlOptions param1XmlOptions) {
      return (MastersType)POIXMLTypeLoader.newInstance(MastersType.type, param1XmlOptions);
    }
    
    public static MastersType parse(String param1String) throws XmlException {
      return (MastersType)POIXMLTypeLoader.parse(param1String, MastersType.type, null);
    }
    
    public static MastersType parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (MastersType)POIXMLTypeLoader.parse(param1String, MastersType.type, param1XmlOptions);
    }
    
    public static MastersType parse(File param1File) throws XmlException, IOException {
      return (MastersType)POIXMLTypeLoader.parse(param1File, MastersType.type, null);
    }
    
    public static MastersType parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (MastersType)POIXMLTypeLoader.parse(param1File, MastersType.type, param1XmlOptions);
    }
    
    public static MastersType parse(URL param1URL) throws XmlException, IOException {
      return (MastersType)POIXMLTypeLoader.parse(param1URL, MastersType.type, null);
    }
    
    public static MastersType parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (MastersType)POIXMLTypeLoader.parse(param1URL, MastersType.type, param1XmlOptions);
    }
    
    public static MastersType parse(InputStream param1InputStream) throws XmlException, IOException {
      return (MastersType)POIXMLTypeLoader.parse(param1InputStream, MastersType.type, null);
    }
    
    public static MastersType parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (MastersType)POIXMLTypeLoader.parse(param1InputStream, MastersType.type, param1XmlOptions);
    }
    
    public static MastersType parse(Reader param1Reader) throws XmlException, IOException {
      return (MastersType)POIXMLTypeLoader.parse(param1Reader, MastersType.type, null);
    }
    
    public static MastersType parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (MastersType)POIXMLTypeLoader.parse(param1Reader, MastersType.type, param1XmlOptions);
    }
    
    public static MastersType parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (MastersType)POIXMLTypeLoader.parse(param1XMLStreamReader, MastersType.type, null);
    }
    
    public static MastersType parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (MastersType)POIXMLTypeLoader.parse(param1XMLStreamReader, MastersType.type, param1XmlOptions);
    }
    
    public static MastersType parse(Node param1Node) throws XmlException {
      return (MastersType)POIXMLTypeLoader.parse(param1Node, MastersType.type, null);
    }
    
    public static MastersType parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (MastersType)POIXMLTypeLoader.parse(param1Node, MastersType.type, param1XmlOptions);
    }
    
    public static MastersType parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (MastersType)POIXMLTypeLoader.parse(param1XMLInputStream, MastersType.type, null);
    }
    
    public static MastersType parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (MastersType)POIXMLTypeLoader.parse(param1XMLInputStream, MastersType.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, MastersType.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, MastersType.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\visio\x2012\main\MastersType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */