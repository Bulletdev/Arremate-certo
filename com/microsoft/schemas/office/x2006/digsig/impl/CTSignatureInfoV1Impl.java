package com.microsoft.schemas.office.x2006.digsig.impl;

import com.microsoft.schemas.office.x2006.digsig.CTSignatureInfoV1;
import com.microsoft.schemas.office.x2006.digsig.STPositiveInteger;
import com.microsoft.schemas.office.x2006.digsig.STSignatureComments;
import com.microsoft.schemas.office.x2006.digsig.STSignatureProviderUrl;
import com.microsoft.schemas.office.x2006.digsig.STSignatureText;
import com.microsoft.schemas.office.x2006.digsig.STSignatureType;
import com.microsoft.schemas.office.x2006.digsig.STUniqueIdentifierWithBraces;
import com.microsoft.schemas.office.x2006.digsig.STVersion;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlBase64Binary;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

public class CTSignatureInfoV1Impl extends XmlComplexContentImpl implements CTSignatureInfoV1 {
  private static final b SETUPID$0 = new b("http://schemas.microsoft.com/office/2006/digsig", "SetupID");
  
  private static final b SIGNATURETEXT$2 = new b("http://schemas.microsoft.com/office/2006/digsig", "SignatureText");
  
  private static final b SIGNATUREIMAGE$4 = new b("http://schemas.microsoft.com/office/2006/digsig", "SignatureImage");
  
  private static final b SIGNATURECOMMENTS$6 = new b("http://schemas.microsoft.com/office/2006/digsig", "SignatureComments");
  
  private static final b WINDOWSVERSION$8 = new b("http://schemas.microsoft.com/office/2006/digsig", "WindowsVersion");
  
  private static final b OFFICEVERSION$10 = new b("http://schemas.microsoft.com/office/2006/digsig", "OfficeVersion");
  
  private static final b APPLICATIONVERSION$12 = new b("http://schemas.microsoft.com/office/2006/digsig", "ApplicationVersion");
  
  private static final b MONITORS$14 = new b("http://schemas.microsoft.com/office/2006/digsig", "Monitors");
  
  private static final b HORIZONTALRESOLUTION$16 = new b("http://schemas.microsoft.com/office/2006/digsig", "HorizontalResolution");
  
  private static final b VERTICALRESOLUTION$18 = new b("http://schemas.microsoft.com/office/2006/digsig", "VerticalResolution");
  
  private static final b COLORDEPTH$20 = new b("http://schemas.microsoft.com/office/2006/digsig", "ColorDepth");
  
  private static final b SIGNATUREPROVIDERID$22 = new b("http://schemas.microsoft.com/office/2006/digsig", "SignatureProviderId");
  
  private static final b SIGNATUREPROVIDERURL$24 = new b("http://schemas.microsoft.com/office/2006/digsig", "SignatureProviderUrl");
  
  private static final b SIGNATUREPROVIDERDETAILS$26 = new b("http://schemas.microsoft.com/office/2006/digsig", "SignatureProviderDetails");
  
  private static final b SIGNATURETYPE$28 = new b("http://schemas.microsoft.com/office/2006/digsig", "SignatureType");
  
  private static final b DELEGATESUGGESTEDSIGNER$30 = new b("http://schemas.microsoft.com/office/2006/digsig", "DelegateSuggestedSigner");
  
  private static final b DELEGATESUGGESTEDSIGNER2$32 = new b("http://schemas.microsoft.com/office/2006/digsig", "DelegateSuggestedSigner2");
  
  private static final b DELEGATESUGGESTEDSIGNEREMAIL$34 = new b("http://schemas.microsoft.com/office/2006/digsig", "DelegateSuggestedSignerEmail");
  
  private static final b MANIFESTHASHALGORITHM$36 = new b("http://schemas.microsoft.com/office/2006/digsig", "ManifestHashAlgorithm");
  
  public CTSignatureInfoV1Impl(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public String getSetupID() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SETUPID$0, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STUniqueIdentifierWithBraces xgetSetupID() {
    synchronized (monitor()) {
      check_orphaned();
      STUniqueIdentifierWithBraces sTUniqueIdentifierWithBraces = null;
      sTUniqueIdentifierWithBraces = (STUniqueIdentifierWithBraces)get_store().find_element_user(SETUPID$0, 0);
      return sTUniqueIdentifierWithBraces;
    } 
  }
  
  public void setSetupID(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SETUPID$0, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(SETUPID$0); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetSetupID(STUniqueIdentifierWithBraces paramSTUniqueIdentifierWithBraces) {
    synchronized (monitor()) {
      check_orphaned();
      STUniqueIdentifierWithBraces sTUniqueIdentifierWithBraces = null;
      sTUniqueIdentifierWithBraces = (STUniqueIdentifierWithBraces)get_store().find_element_user(SETUPID$0, 0);
      if (sTUniqueIdentifierWithBraces == null)
        sTUniqueIdentifierWithBraces = (STUniqueIdentifierWithBraces)get_store().add_element_user(SETUPID$0); 
      sTUniqueIdentifierWithBraces.set((XmlObject)paramSTUniqueIdentifierWithBraces);
    } 
  }
  
  public String getSignatureText() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SIGNATURETEXT$2, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STSignatureText xgetSignatureText() {
    synchronized (monitor()) {
      check_orphaned();
      STSignatureText sTSignatureText = null;
      sTSignatureText = (STSignatureText)get_store().find_element_user(SIGNATURETEXT$2, 0);
      return sTSignatureText;
    } 
  }
  
  public void setSignatureText(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SIGNATURETEXT$2, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(SIGNATURETEXT$2); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetSignatureText(STSignatureText paramSTSignatureText) {
    synchronized (monitor()) {
      check_orphaned();
      STSignatureText sTSignatureText = null;
      sTSignatureText = (STSignatureText)get_store().find_element_user(SIGNATURETEXT$2, 0);
      if (sTSignatureText == null)
        sTSignatureText = (STSignatureText)get_store().add_element_user(SIGNATURETEXT$2); 
      sTSignatureText.set((XmlObject)paramSTSignatureText);
    } 
  }
  
  public byte[] getSignatureImage() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SIGNATUREIMAGE$4, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getByteArrayValue();
    } 
  }
  
  public XmlBase64Binary xgetSignatureImage() {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_element_user(SIGNATUREIMAGE$4, 0);
      return xmlBase64Binary;
    } 
  }
  
  public void setSignatureImage(byte[] paramArrayOfbyte) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SIGNATUREIMAGE$4, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(SIGNATUREIMAGE$4); 
      simpleValue.setByteArrayValue(paramArrayOfbyte);
    } 
  }
  
  public void xsetSignatureImage(XmlBase64Binary paramXmlBase64Binary) {
    synchronized (monitor()) {
      check_orphaned();
      XmlBase64Binary xmlBase64Binary = null;
      xmlBase64Binary = (XmlBase64Binary)get_store().find_element_user(SIGNATUREIMAGE$4, 0);
      if (xmlBase64Binary == null)
        xmlBase64Binary = (XmlBase64Binary)get_store().add_element_user(SIGNATUREIMAGE$4); 
      xmlBase64Binary.set((XmlObject)paramXmlBase64Binary);
    } 
  }
  
  public String getSignatureComments() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SIGNATURECOMMENTS$6, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STSignatureComments xgetSignatureComments() {
    synchronized (monitor()) {
      check_orphaned();
      STSignatureComments sTSignatureComments = null;
      sTSignatureComments = (STSignatureComments)get_store().find_element_user(SIGNATURECOMMENTS$6, 0);
      return sTSignatureComments;
    } 
  }
  
  public void setSignatureComments(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SIGNATURECOMMENTS$6, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(SIGNATURECOMMENTS$6); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetSignatureComments(STSignatureComments paramSTSignatureComments) {
    synchronized (monitor()) {
      check_orphaned();
      STSignatureComments sTSignatureComments = null;
      sTSignatureComments = (STSignatureComments)get_store().find_element_user(SIGNATURECOMMENTS$6, 0);
      if (sTSignatureComments == null)
        sTSignatureComments = (STSignatureComments)get_store().add_element_user(SIGNATURECOMMENTS$6); 
      sTSignatureComments.set((XmlObject)paramSTSignatureComments);
    } 
  }
  
  public String getWindowsVersion() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(WINDOWSVERSION$8, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STVersion xgetWindowsVersion() {
    synchronized (monitor()) {
      check_orphaned();
      STVersion sTVersion = null;
      sTVersion = (STVersion)get_store().find_element_user(WINDOWSVERSION$8, 0);
      return sTVersion;
    } 
  }
  
  public void setWindowsVersion(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(WINDOWSVERSION$8, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(WINDOWSVERSION$8); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetWindowsVersion(STVersion paramSTVersion) {
    synchronized (monitor()) {
      check_orphaned();
      STVersion sTVersion = null;
      sTVersion = (STVersion)get_store().find_element_user(WINDOWSVERSION$8, 0);
      if (sTVersion == null)
        sTVersion = (STVersion)get_store().add_element_user(WINDOWSVERSION$8); 
      sTVersion.set((XmlObject)paramSTVersion);
    } 
  }
  
  public String getOfficeVersion() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(OFFICEVERSION$10, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STVersion xgetOfficeVersion() {
    synchronized (monitor()) {
      check_orphaned();
      STVersion sTVersion = null;
      sTVersion = (STVersion)get_store().find_element_user(OFFICEVERSION$10, 0);
      return sTVersion;
    } 
  }
  
  public void setOfficeVersion(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(OFFICEVERSION$10, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(OFFICEVERSION$10); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetOfficeVersion(STVersion paramSTVersion) {
    synchronized (monitor()) {
      check_orphaned();
      STVersion sTVersion = null;
      sTVersion = (STVersion)get_store().find_element_user(OFFICEVERSION$10, 0);
      if (sTVersion == null)
        sTVersion = (STVersion)get_store().add_element_user(OFFICEVERSION$10); 
      sTVersion.set((XmlObject)paramSTVersion);
    } 
  }
  
  public String getApplicationVersion() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(APPLICATIONVERSION$12, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STVersion xgetApplicationVersion() {
    synchronized (monitor()) {
      check_orphaned();
      STVersion sTVersion = null;
      sTVersion = (STVersion)get_store().find_element_user(APPLICATIONVERSION$12, 0);
      return sTVersion;
    } 
  }
  
  public void setApplicationVersion(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(APPLICATIONVERSION$12, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(APPLICATIONVERSION$12); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetApplicationVersion(STVersion paramSTVersion) {
    synchronized (monitor()) {
      check_orphaned();
      STVersion sTVersion = null;
      sTVersion = (STVersion)get_store().find_element_user(APPLICATIONVERSION$12, 0);
      if (sTVersion == null)
        sTVersion = (STVersion)get_store().add_element_user(APPLICATIONVERSION$12); 
      sTVersion.set((XmlObject)paramSTVersion);
    } 
  }
  
  public int getMonitors() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(MONITORS$14, 0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STPositiveInteger xgetMonitors() {
    synchronized (monitor()) {
      check_orphaned();
      STPositiveInteger sTPositiveInteger = null;
      sTPositiveInteger = (STPositiveInteger)get_store().find_element_user(MONITORS$14, 0);
      return sTPositiveInteger;
    } 
  }
  
  public void setMonitors(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(MONITORS$14, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(MONITORS$14); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetMonitors(STPositiveInteger paramSTPositiveInteger) {
    synchronized (monitor()) {
      check_orphaned();
      STPositiveInteger sTPositiveInteger = null;
      sTPositiveInteger = (STPositiveInteger)get_store().find_element_user(MONITORS$14, 0);
      if (sTPositiveInteger == null)
        sTPositiveInteger = (STPositiveInteger)get_store().add_element_user(MONITORS$14); 
      sTPositiveInteger.set((XmlObject)paramSTPositiveInteger);
    } 
  }
  
  public int getHorizontalResolution() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(HORIZONTALRESOLUTION$16, 0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STPositiveInteger xgetHorizontalResolution() {
    synchronized (monitor()) {
      check_orphaned();
      STPositiveInteger sTPositiveInteger = null;
      sTPositiveInteger = (STPositiveInteger)get_store().find_element_user(HORIZONTALRESOLUTION$16, 0);
      return sTPositiveInteger;
    } 
  }
  
  public void setHorizontalResolution(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(HORIZONTALRESOLUTION$16, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(HORIZONTALRESOLUTION$16); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetHorizontalResolution(STPositiveInteger paramSTPositiveInteger) {
    synchronized (monitor()) {
      check_orphaned();
      STPositiveInteger sTPositiveInteger = null;
      sTPositiveInteger = (STPositiveInteger)get_store().find_element_user(HORIZONTALRESOLUTION$16, 0);
      if (sTPositiveInteger == null)
        sTPositiveInteger = (STPositiveInteger)get_store().add_element_user(HORIZONTALRESOLUTION$16); 
      sTPositiveInteger.set((XmlObject)paramSTPositiveInteger);
    } 
  }
  
  public int getVerticalResolution() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(VERTICALRESOLUTION$18, 0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STPositiveInteger xgetVerticalResolution() {
    synchronized (monitor()) {
      check_orphaned();
      STPositiveInteger sTPositiveInteger = null;
      sTPositiveInteger = (STPositiveInteger)get_store().find_element_user(VERTICALRESOLUTION$18, 0);
      return sTPositiveInteger;
    } 
  }
  
  public void setVerticalResolution(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(VERTICALRESOLUTION$18, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(VERTICALRESOLUTION$18); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetVerticalResolution(STPositiveInteger paramSTPositiveInteger) {
    synchronized (monitor()) {
      check_orphaned();
      STPositiveInteger sTPositiveInteger = null;
      sTPositiveInteger = (STPositiveInteger)get_store().find_element_user(VERTICALRESOLUTION$18, 0);
      if (sTPositiveInteger == null)
        sTPositiveInteger = (STPositiveInteger)get_store().add_element_user(VERTICALRESOLUTION$18); 
      sTPositiveInteger.set((XmlObject)paramSTPositiveInteger);
    } 
  }
  
  public int getColorDepth() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(COLORDEPTH$20, 0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STPositiveInteger xgetColorDepth() {
    synchronized (monitor()) {
      check_orphaned();
      STPositiveInteger sTPositiveInteger = null;
      sTPositiveInteger = (STPositiveInteger)get_store().find_element_user(COLORDEPTH$20, 0);
      return sTPositiveInteger;
    } 
  }
  
  public void setColorDepth(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(COLORDEPTH$20, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(COLORDEPTH$20); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetColorDepth(STPositiveInteger paramSTPositiveInteger) {
    synchronized (monitor()) {
      check_orphaned();
      STPositiveInteger sTPositiveInteger = null;
      sTPositiveInteger = (STPositiveInteger)get_store().find_element_user(COLORDEPTH$20, 0);
      if (sTPositiveInteger == null)
        sTPositiveInteger = (STPositiveInteger)get_store().add_element_user(COLORDEPTH$20); 
      sTPositiveInteger.set((XmlObject)paramSTPositiveInteger);
    } 
  }
  
  public String getSignatureProviderId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SIGNATUREPROVIDERID$22, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STUniqueIdentifierWithBraces xgetSignatureProviderId() {
    synchronized (monitor()) {
      check_orphaned();
      STUniqueIdentifierWithBraces sTUniqueIdentifierWithBraces = null;
      sTUniqueIdentifierWithBraces = (STUniqueIdentifierWithBraces)get_store().find_element_user(SIGNATUREPROVIDERID$22, 0);
      return sTUniqueIdentifierWithBraces;
    } 
  }
  
  public void setSignatureProviderId(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SIGNATUREPROVIDERID$22, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(SIGNATUREPROVIDERID$22); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetSignatureProviderId(STUniqueIdentifierWithBraces paramSTUniqueIdentifierWithBraces) {
    synchronized (monitor()) {
      check_orphaned();
      STUniqueIdentifierWithBraces sTUniqueIdentifierWithBraces = null;
      sTUniqueIdentifierWithBraces = (STUniqueIdentifierWithBraces)get_store().find_element_user(SIGNATUREPROVIDERID$22, 0);
      if (sTUniqueIdentifierWithBraces == null)
        sTUniqueIdentifierWithBraces = (STUniqueIdentifierWithBraces)get_store().add_element_user(SIGNATUREPROVIDERID$22); 
      sTUniqueIdentifierWithBraces.set((XmlObject)paramSTUniqueIdentifierWithBraces);
    } 
  }
  
  public String getSignatureProviderUrl() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SIGNATUREPROVIDERURL$24, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public STSignatureProviderUrl xgetSignatureProviderUrl() {
    synchronized (monitor()) {
      check_orphaned();
      STSignatureProviderUrl sTSignatureProviderUrl = null;
      sTSignatureProviderUrl = (STSignatureProviderUrl)get_store().find_element_user(SIGNATUREPROVIDERURL$24, 0);
      return sTSignatureProviderUrl;
    } 
  }
  
  public void setSignatureProviderUrl(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SIGNATUREPROVIDERURL$24, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(SIGNATUREPROVIDERURL$24); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetSignatureProviderUrl(STSignatureProviderUrl paramSTSignatureProviderUrl) {
    synchronized (monitor()) {
      check_orphaned();
      STSignatureProviderUrl sTSignatureProviderUrl = null;
      sTSignatureProviderUrl = (STSignatureProviderUrl)get_store().find_element_user(SIGNATUREPROVIDERURL$24, 0);
      if (sTSignatureProviderUrl == null)
        sTSignatureProviderUrl = (STSignatureProviderUrl)get_store().add_element_user(SIGNATUREPROVIDERURL$24); 
      sTSignatureProviderUrl.set((XmlObject)paramSTSignatureProviderUrl);
    } 
  }
  
  public int getSignatureProviderDetails() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SIGNATUREPROVIDERDETAILS$26, 0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public XmlInt xgetSignatureProviderDetails() {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(SIGNATUREPROVIDERDETAILS$26, 0);
      return xmlInt;
    } 
  }
  
  public void setSignatureProviderDetails(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SIGNATUREPROVIDERDETAILS$26, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(SIGNATUREPROVIDERDETAILS$26); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetSignatureProviderDetails(XmlInt paramXmlInt) {
    synchronized (monitor()) {
      check_orphaned();
      XmlInt xmlInt = null;
      xmlInt = (XmlInt)get_store().find_element_user(SIGNATUREPROVIDERDETAILS$26, 0);
      if (xmlInt == null)
        xmlInt = (XmlInt)get_store().add_element_user(SIGNATUREPROVIDERDETAILS$26); 
      xmlInt.set((XmlObject)paramXmlInt);
    } 
  }
  
  public int getSignatureType() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SIGNATURETYPE$28, 0);
      if (simpleValue == null)
        return 0; 
      return simpleValue.getIntValue();
    } 
  }
  
  public STSignatureType xgetSignatureType() {
    synchronized (monitor()) {
      check_orphaned();
      STSignatureType sTSignatureType = null;
      sTSignatureType = (STSignatureType)get_store().find_element_user(SIGNATURETYPE$28, 0);
      return sTSignatureType;
    } 
  }
  
  public void setSignatureType(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(SIGNATURETYPE$28, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(SIGNATURETYPE$28); 
      simpleValue.setIntValue(paramInt);
    } 
  }
  
  public void xsetSignatureType(STSignatureType paramSTSignatureType) {
    synchronized (monitor()) {
      check_orphaned();
      STSignatureType sTSignatureType = null;
      sTSignatureType = (STSignatureType)get_store().find_element_user(SIGNATURETYPE$28, 0);
      if (sTSignatureType == null)
        sTSignatureType = (STSignatureType)get_store().add_element_user(SIGNATURETYPE$28); 
      sTSignatureType.set((XmlObject)paramSTSignatureType);
    } 
  }
  
  public String getDelegateSuggestedSigner() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(DELEGATESUGGESTEDSIGNER$30, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetDelegateSuggestedSigner() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(DELEGATESUGGESTEDSIGNER$30, 0);
      return xmlString;
    } 
  }
  
  public boolean isSetDelegateSuggestedSigner() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DELEGATESUGGESTEDSIGNER$30) != 0);
    } 
  }
  
  public void setDelegateSuggestedSigner(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(DELEGATESUGGESTEDSIGNER$30, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(DELEGATESUGGESTEDSIGNER$30); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetDelegateSuggestedSigner(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(DELEGATESUGGESTEDSIGNER$30, 0);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_element_user(DELEGATESUGGESTEDSIGNER$30); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetDelegateSuggestedSigner() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DELEGATESUGGESTEDSIGNER$30, 0);
    } 
  }
  
  public String getDelegateSuggestedSigner2() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(DELEGATESUGGESTEDSIGNER2$32, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetDelegateSuggestedSigner2() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(DELEGATESUGGESTEDSIGNER2$32, 0);
      return xmlString;
    } 
  }
  
  public boolean isSetDelegateSuggestedSigner2() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DELEGATESUGGESTEDSIGNER2$32) != 0);
    } 
  }
  
  public void setDelegateSuggestedSigner2(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(DELEGATESUGGESTEDSIGNER2$32, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(DELEGATESUGGESTEDSIGNER2$32); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetDelegateSuggestedSigner2(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(DELEGATESUGGESTEDSIGNER2$32, 0);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_element_user(DELEGATESUGGESTEDSIGNER2$32); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetDelegateSuggestedSigner2() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DELEGATESUGGESTEDSIGNER2$32, 0);
    } 
  }
  
  public String getDelegateSuggestedSignerEmail() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(DELEGATESUGGESTEDSIGNEREMAIL$34, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlString xgetDelegateSuggestedSignerEmail() {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(DELEGATESUGGESTEDSIGNEREMAIL$34, 0);
      return xmlString;
    } 
  }
  
  public boolean isSetDelegateSuggestedSignerEmail() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(DELEGATESUGGESTEDSIGNEREMAIL$34) != 0);
    } 
  }
  
  public void setDelegateSuggestedSignerEmail(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(DELEGATESUGGESTEDSIGNEREMAIL$34, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(DELEGATESUGGESTEDSIGNEREMAIL$34); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetDelegateSuggestedSignerEmail(XmlString paramXmlString) {
    synchronized (monitor()) {
      check_orphaned();
      XmlString xmlString = null;
      xmlString = (XmlString)get_store().find_element_user(DELEGATESUGGESTEDSIGNEREMAIL$34, 0);
      if (xmlString == null)
        xmlString = (XmlString)get_store().add_element_user(DELEGATESUGGESTEDSIGNEREMAIL$34); 
      xmlString.set((XmlObject)paramXmlString);
    } 
  }
  
  public void unsetDelegateSuggestedSignerEmail() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(DELEGATESUGGESTEDSIGNEREMAIL$34, 0);
    } 
  }
  
  public String getManifestHashAlgorithm() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(MANIFESTHASHALGORITHM$36, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlAnyURI xgetManifestHashAlgorithm() {
    synchronized (monitor()) {
      check_orphaned();
      XmlAnyURI xmlAnyURI = null;
      xmlAnyURI = (XmlAnyURI)get_store().find_element_user(MANIFESTHASHALGORITHM$36, 0);
      return xmlAnyURI;
    } 
  }
  
  public boolean isSetManifestHashAlgorithm() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(MANIFESTHASHALGORITHM$36) != 0);
    } 
  }
  
  public void setManifestHashAlgorithm(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(MANIFESTHASHALGORITHM$36, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(MANIFESTHASHALGORITHM$36); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetManifestHashAlgorithm(XmlAnyURI paramXmlAnyURI) {
    synchronized (monitor()) {
      check_orphaned();
      XmlAnyURI xmlAnyURI = null;
      xmlAnyURI = (XmlAnyURI)get_store().find_element_user(MANIFESTHASHALGORITHM$36, 0);
      if (xmlAnyURI == null)
        xmlAnyURI = (XmlAnyURI)get_store().add_element_user(MANIFESTHASHALGORITHM$36); 
      xmlAnyURI.set((XmlObject)paramXmlAnyURI);
    } 
  }
  
  public void unsetManifestHashAlgorithm() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(MANIFESTHASHALGORITHM$36, 0);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\com\microsoft\schemas\office\x2006\digsig\impl\CTSignatureInfoV1Impl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */