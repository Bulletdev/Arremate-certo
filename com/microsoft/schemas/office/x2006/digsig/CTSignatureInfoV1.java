package com.microsoft.schemas.office.x2006.digsig;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.stream.XMLStreamReader;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.apache.xmlbeans.xml.stream.XMLStreamException;
import org.w3c.dom.Node;

public interface CTSignatureInfoV1 extends XmlObject {
  public static final SchemaType type = (SchemaType)XmlBeans.typeSystemForClassLoader(CTSignatureInfoV1.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s8C3F193EE11A2F798ACF65489B9E6078").resolveHandle("ctsignatureinfov13a5ftype");
  
  String getSetupID();
  
  STUniqueIdentifierWithBraces xgetSetupID();
  
  void setSetupID(String paramString);
  
  void xsetSetupID(STUniqueIdentifierWithBraces paramSTUniqueIdentifierWithBraces);
  
  String getSignatureText();
  
  STSignatureText xgetSignatureText();
  
  void setSignatureText(String paramString);
  
  void xsetSignatureText(STSignatureText paramSTSignatureText);
  
  byte[] getSignatureImage();
  
  XmlBase64Binary xgetSignatureImage();
  
  void setSignatureImage(byte[] paramArrayOfbyte);
  
  void xsetSignatureImage(XmlBase64Binary paramXmlBase64Binary);
  
  String getSignatureComments();
  
  STSignatureComments xgetSignatureComments();
  
  void setSignatureComments(String paramString);
  
  void xsetSignatureComments(STSignatureComments paramSTSignatureComments);
  
  String getWindowsVersion();
  
  STVersion xgetWindowsVersion();
  
  void setWindowsVersion(String paramString);
  
  void xsetWindowsVersion(STVersion paramSTVersion);
  
  String getOfficeVersion();
  
  STVersion xgetOfficeVersion();
  
  void setOfficeVersion(String paramString);
  
  void xsetOfficeVersion(STVersion paramSTVersion);
  
  String getApplicationVersion();
  
  STVersion xgetApplicationVersion();
  
  void setApplicationVersion(String paramString);
  
  void xsetApplicationVersion(STVersion paramSTVersion);
  
  int getMonitors();
  
  STPositiveInteger xgetMonitors();
  
  void setMonitors(int paramInt);
  
  void xsetMonitors(STPositiveInteger paramSTPositiveInteger);
  
  int getHorizontalResolution();
  
  STPositiveInteger xgetHorizontalResolution();
  
  void setHorizontalResolution(int paramInt);
  
  void xsetHorizontalResolution(STPositiveInteger paramSTPositiveInteger);
  
  int getVerticalResolution();
  
  STPositiveInteger xgetVerticalResolution();
  
  void setVerticalResolution(int paramInt);
  
  void xsetVerticalResolution(STPositiveInteger paramSTPositiveInteger);
  
  int getColorDepth();
  
  STPositiveInteger xgetColorDepth();
  
  void setColorDepth(int paramInt);
  
  void xsetColorDepth(STPositiveInteger paramSTPositiveInteger);
  
  String getSignatureProviderId();
  
  STUniqueIdentifierWithBraces xgetSignatureProviderId();
  
  void setSignatureProviderId(String paramString);
  
  void xsetSignatureProviderId(STUniqueIdentifierWithBraces paramSTUniqueIdentifierWithBraces);
  
  String getSignatureProviderUrl();
  
  STSignatureProviderUrl xgetSignatureProviderUrl();
  
  void setSignatureProviderUrl(String paramString);
  
  void xsetSignatureProviderUrl(STSignatureProviderUrl paramSTSignatureProviderUrl);
  
  int getSignatureProviderDetails();
  
  XmlInt xgetSignatureProviderDetails();
  
  void setSignatureProviderDetails(int paramInt);
  
  void xsetSignatureProviderDetails(XmlInt paramXmlInt);
  
  int getSignatureType();
  
  STSignatureType xgetSignatureType();
  
  void setSignatureType(int paramInt);
  
  void xsetSignatureType(STSignatureType paramSTSignatureType);
  
  String getDelegateSuggestedSigner();
  
  XmlString xgetDelegateSuggestedSigner();
  
  boolean isSetDelegateSuggestedSigner();
  
  void setDelegateSuggestedSigner(String paramString);
  
  void xsetDelegateSuggestedSigner(XmlString paramXmlString);
  
  void unsetDelegateSuggestedSigner();
  
  String getDelegateSuggestedSigner2();
  
  XmlString xgetDelegateSuggestedSigner2();
  
  boolean isSetDelegateSuggestedSigner2();
  
  void setDelegateSuggestedSigner2(String paramString);
  
  void xsetDelegateSuggestedSigner2(XmlString paramXmlString);
  
  void unsetDelegateSuggestedSigner2();
  
  String getDelegateSuggestedSignerEmail();
  
  XmlString xgetDelegateSuggestedSignerEmail();
  
  boolean isSetDelegateSuggestedSignerEmail();
  
  void setDelegateSuggestedSignerEmail(String paramString);
  
  void xsetDelegateSuggestedSignerEmail(XmlString paramXmlString);
  
  void unsetDelegateSuggestedSignerEmail();
  
  String getManifestHashAlgorithm();
  
  XmlAnyURI xgetManifestHashAlgorithm();
  
  boolean isSetManifestHashAlgorithm();
  
  void setManifestHashAlgorithm(String paramString);
  
  void xsetManifestHashAlgorithm(XmlAnyURI paramXmlAnyURI);
  
  void unsetManifestHashAlgorithm();
  
  public static final class Factory {
    public static CTSignatureInfoV1 newInstance() {
      return (CTSignatureInfoV1)POIXMLTypeLoader.newInstance(CTSignatureInfoV1.type, null);
    }
    
    public static CTSignatureInfoV1 newInstance(XmlOptions param1XmlOptions) {
      return (CTSignatureInfoV1)POIXMLTypeLoader.newInstance(CTSignatureInfoV1.type, param1XmlOptions);
    }
    
    public static CTSignatureInfoV1 parse(String param1String) throws XmlException {
      return (CTSignatureInfoV1)POIXMLTypeLoader.parse(param1String, CTSignatureInfoV1.type, null);
    }
    
    public static CTSignatureInfoV1 parse(String param1String, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSignatureInfoV1)POIXMLTypeLoader.parse(param1String, CTSignatureInfoV1.type, param1XmlOptions);
    }
    
    public static CTSignatureInfoV1 parse(File param1File) throws XmlException, IOException {
      return (CTSignatureInfoV1)POIXMLTypeLoader.parse(param1File, CTSignatureInfoV1.type, null);
    }
    
    public static CTSignatureInfoV1 parse(File param1File, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSignatureInfoV1)POIXMLTypeLoader.parse(param1File, CTSignatureInfoV1.type, param1XmlOptions);
    }
    
    public static CTSignatureInfoV1 parse(URL param1URL) throws XmlException, IOException {
      return (CTSignatureInfoV1)POIXMLTypeLoader.parse(param1URL, CTSignatureInfoV1.type, null);
    }
    
    public static CTSignatureInfoV1 parse(URL param1URL, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSignatureInfoV1)POIXMLTypeLoader.parse(param1URL, CTSignatureInfoV1.type, param1XmlOptions);
    }
    
    public static CTSignatureInfoV1 parse(InputStream param1InputStream) throws XmlException, IOException {
      return (CTSignatureInfoV1)POIXMLTypeLoader.parse(param1InputStream, CTSignatureInfoV1.type, null);
    }
    
    public static CTSignatureInfoV1 parse(InputStream param1InputStream, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSignatureInfoV1)POIXMLTypeLoader.parse(param1InputStream, CTSignatureInfoV1.type, param1XmlOptions);
    }
    
    public static CTSignatureInfoV1 parse(Reader param1Reader) throws XmlException, IOException {
      return (CTSignatureInfoV1)POIXMLTypeLoader.parse(param1Reader, CTSignatureInfoV1.type, null);
    }
    
    public static CTSignatureInfoV1 parse(Reader param1Reader, XmlOptions param1XmlOptions) throws XmlException, IOException {
      return (CTSignatureInfoV1)POIXMLTypeLoader.parse(param1Reader, CTSignatureInfoV1.type, param1XmlOptions);
    }
    
    public static CTSignatureInfoV1 parse(XMLStreamReader param1XMLStreamReader) throws XmlException {
      return (CTSignatureInfoV1)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSignatureInfoV1.type, null);
    }
    
    public static CTSignatureInfoV1 parse(XMLStreamReader param1XMLStreamReader, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSignatureInfoV1)POIXMLTypeLoader.parse(param1XMLStreamReader, CTSignatureInfoV1.type, param1XmlOptions);
    }
    
    public static CTSignatureInfoV1 parse(Node param1Node) throws XmlException {
      return (CTSignatureInfoV1)POIXMLTypeLoader.parse(param1Node, CTSignatureInfoV1.type, null);
    }
    
    public static CTSignatureInfoV1 parse(Node param1Node, XmlOptions param1XmlOptions) throws XmlException {
      return (CTSignatureInfoV1)POIXMLTypeLoader.parse(param1Node, CTSignatureInfoV1.type, param1XmlOptions);
    }
    
    public static CTSignatureInfoV1 parse(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return (CTSignatureInfoV1)POIXMLTypeLoader.parse(param1XMLInputStream, CTSignatureInfoV1.type, null);
    }
    
    public static CTSignatureInfoV1 parse(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return (CTSignatureInfoV1)POIXMLTypeLoader.parse(param1XMLInputStream, CTSignatureInfoV1.type, param1XmlOptions);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSignatureInfoV1.type, null);
    }
    
    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream param1XMLInputStream, XmlOptions param1XmlOptions) throws XmlException, XMLStreamException {
      return POIXMLTypeLoader.newValidatingXMLInputStream(param1XMLInputStream, CTSignatureInfoV1.type, param1XmlOptions);
    }
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\x2006\digsig\CTSignatureInfoV1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */