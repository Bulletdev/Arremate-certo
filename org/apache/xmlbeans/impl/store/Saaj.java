package org.apache.xmlbeans.impl.store;

import java.util.Iterator;
import java.util.Locale;
import javax.xml.namespace.b;
import javax.xml.transform.Source;
import org.apache.xmlbeans.impl.soap.Detail;
import org.apache.xmlbeans.impl.soap.DetailEntry;
import org.apache.xmlbeans.impl.soap.Name;
import org.apache.xmlbeans.impl.soap.Node;
import org.apache.xmlbeans.impl.soap.SOAPBody;
import org.apache.xmlbeans.impl.soap.SOAPBodyElement;
import org.apache.xmlbeans.impl.soap.SOAPElement;
import org.apache.xmlbeans.impl.soap.SOAPEnvelope;
import org.apache.xmlbeans.impl.soap.SOAPException;
import org.apache.xmlbeans.impl.soap.SOAPFault;
import org.apache.xmlbeans.impl.soap.SOAPHeader;
import org.apache.xmlbeans.impl.soap.SOAPHeaderElement;
import org.apache.xmlbeans.impl.soap.SOAPPart;
import org.apache.xmlbeans.impl.soap.Text;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public interface Saaj {
  public static final String SAAJ_IMPL = "SAAJ_IMPL";
  
  void setCallback(SaajCallback paramSaajCallback);
  
  Class identifyElement(b paramb1, b paramb2);
  
  void soapNode_detachNode(Node paramNode);
  
  void soapNode_recycleNode(Node paramNode);
  
  String soapNode_getValue(Node paramNode);
  
  void soapNode_setValue(Node paramNode, String paramString);
  
  SOAPElement soapNode_getParentElement(Node paramNode);
  
  void soapNode_setParentElement(Node paramNode, SOAPElement paramSOAPElement);
  
  void soapElement_removeContents(SOAPElement paramSOAPElement);
  
  String soapElement_getEncodingStyle(SOAPElement paramSOAPElement);
  
  void soapElement_setEncodingStyle(SOAPElement paramSOAPElement, String paramString);
  
  boolean soapElement_removeNamespaceDeclaration(SOAPElement paramSOAPElement, String paramString);
  
  Iterator soapElement_getAllAttributes(SOAPElement paramSOAPElement);
  
  Iterator soapElement_getChildElements(SOAPElement paramSOAPElement);
  
  Iterator soapElement_getNamespacePrefixes(SOAPElement paramSOAPElement);
  
  SOAPElement soapElement_addAttribute(SOAPElement paramSOAPElement, Name paramName, String paramString) throws SOAPException;
  
  SOAPElement soapElement_addChildElement(SOAPElement paramSOAPElement1, SOAPElement paramSOAPElement2) throws SOAPException;
  
  SOAPElement soapElement_addChildElement(SOAPElement paramSOAPElement, Name paramName) throws SOAPException;
  
  SOAPElement soapElement_addChildElement(SOAPElement paramSOAPElement, String paramString) throws SOAPException;
  
  SOAPElement soapElement_addChildElement(SOAPElement paramSOAPElement, String paramString1, String paramString2) throws SOAPException;
  
  SOAPElement soapElement_addChildElement(SOAPElement paramSOAPElement, String paramString1, String paramString2, String paramString3) throws SOAPException;
  
  SOAPElement soapElement_addNamespaceDeclaration(SOAPElement paramSOAPElement, String paramString1, String paramString2);
  
  SOAPElement soapElement_addTextNode(SOAPElement paramSOAPElement, String paramString);
  
  String soapElement_getAttributeValue(SOAPElement paramSOAPElement, Name paramName);
  
  Iterator soapElement_getChildElements(SOAPElement paramSOAPElement, Name paramName);
  
  Name soapElement_getElementName(SOAPElement paramSOAPElement);
  
  String soapElement_getNamespaceURI(SOAPElement paramSOAPElement, String paramString);
  
  Iterator soapElement_getVisibleNamespacePrefixes(SOAPElement paramSOAPElement);
  
  boolean soapElement_removeAttribute(SOAPElement paramSOAPElement, Name paramName);
  
  SOAPBody soapEnvelope_addBody(SOAPEnvelope paramSOAPEnvelope) throws SOAPException;
  
  SOAPBody soapEnvelope_getBody(SOAPEnvelope paramSOAPEnvelope) throws SOAPException;
  
  SOAPHeader soapEnvelope_getHeader(SOAPEnvelope paramSOAPEnvelope) throws SOAPException;
  
  SOAPHeader soapEnvelope_addHeader(SOAPEnvelope paramSOAPEnvelope) throws SOAPException;
  
  Name soapEnvelope_createName(SOAPEnvelope paramSOAPEnvelope, String paramString);
  
  Name soapEnvelope_createName(SOAPEnvelope paramSOAPEnvelope, String paramString1, String paramString2, String paramString3);
  
  Iterator soapHeader_examineAllHeaderElements(SOAPHeader paramSOAPHeader);
  
  Iterator soapHeader_extractAllHeaderElements(SOAPHeader paramSOAPHeader);
  
  Iterator soapHeader_examineHeaderElements(SOAPHeader paramSOAPHeader, String paramString);
  
  Iterator soapHeader_examineMustUnderstandHeaderElements(SOAPHeader paramSOAPHeader, String paramString);
  
  Iterator soapHeader_extractHeaderElements(SOAPHeader paramSOAPHeader, String paramString);
  
  SOAPHeaderElement soapHeader_addHeaderElement(SOAPHeader paramSOAPHeader, Name paramName);
  
  void soapPart_removeAllMimeHeaders(SOAPPart paramSOAPPart);
  
  void soapPart_removeMimeHeader(SOAPPart paramSOAPPart, String paramString);
  
  Iterator soapPart_getAllMimeHeaders(SOAPPart paramSOAPPart);
  
  SOAPEnvelope soapPart_getEnvelope(SOAPPart paramSOAPPart);
  
  Source soapPart_getContent(SOAPPart paramSOAPPart);
  
  void soapPart_setContent(SOAPPart paramSOAPPart, Source paramSource);
  
  String[] soapPart_getMimeHeader(SOAPPart paramSOAPPart, String paramString);
  
  void soapPart_addMimeHeader(SOAPPart paramSOAPPart, String paramString1, String paramString2);
  
  void soapPart_setMimeHeader(SOAPPart paramSOAPPart, String paramString1, String paramString2);
  
  Iterator soapPart_getMatchingMimeHeaders(SOAPPart paramSOAPPart, String[] paramArrayOfString);
  
  Iterator soapPart_getNonMatchingMimeHeaders(SOAPPart paramSOAPPart, String[] paramArrayOfString);
  
  boolean soapBody_hasFault(SOAPBody paramSOAPBody);
  
  SOAPFault soapBody_addFault(SOAPBody paramSOAPBody) throws SOAPException;
  
  SOAPFault soapBody_getFault(SOAPBody paramSOAPBody);
  
  SOAPBodyElement soapBody_addBodyElement(SOAPBody paramSOAPBody, Name paramName);
  
  SOAPBodyElement soapBody_addDocument(SOAPBody paramSOAPBody, Document paramDocument);
  
  SOAPFault soapBody_addFault(SOAPBody paramSOAPBody, Name paramName, String paramString) throws SOAPException;
  
  SOAPFault soapBody_addFault(SOAPBody paramSOAPBody, Name paramName, String paramString, Locale paramLocale) throws SOAPException;
  
  Detail soapFault_addDetail(SOAPFault paramSOAPFault) throws SOAPException;
  
  Detail soapFault_getDetail(SOAPFault paramSOAPFault);
  
  String soapFault_getFaultActor(SOAPFault paramSOAPFault);
  
  String soapFault_getFaultCode(SOAPFault paramSOAPFault);
  
  Name soapFault_getFaultCodeAsName(SOAPFault paramSOAPFault);
  
  String soapFault_getFaultString(SOAPFault paramSOAPFault);
  
  Locale soapFault_getFaultStringLocale(SOAPFault paramSOAPFault);
  
  void soapFault_setFaultActor(SOAPFault paramSOAPFault, String paramString);
  
  void soapFault_setFaultCode(SOAPFault paramSOAPFault, Name paramName) throws SOAPException;
  
  void soapFault_setFaultCode(SOAPFault paramSOAPFault, String paramString) throws SOAPException;
  
  void soapFault_setFaultString(SOAPFault paramSOAPFault, String paramString);
  
  void soapFault_setFaultString(SOAPFault paramSOAPFault, String paramString, Locale paramLocale);
  
  void soapHeaderElement_setMustUnderstand(SOAPHeaderElement paramSOAPHeaderElement, boolean paramBoolean);
  
  boolean soapHeaderElement_getMustUnderstand(SOAPHeaderElement paramSOAPHeaderElement);
  
  void soapHeaderElement_setActor(SOAPHeaderElement paramSOAPHeaderElement, String paramString);
  
  String soapHeaderElement_getActor(SOAPHeaderElement paramSOAPHeaderElement);
  
  boolean soapText_isComment(Text paramText);
  
  DetailEntry detail_addDetailEntry(Detail paramDetail, Name paramName);
  
  Iterator detail_getDetailEntries(Detail paramDetail);
  
  public static interface SaajCallback {
    void setSaajData(Node param1Node, Object param1Object);
    
    Object getSaajData(Node param1Node);
    
    Element createSoapElement(b param1b1, b param1b2);
    
    Element importSoapElement(Document param1Document, Element param1Element, boolean param1Boolean, b param1b);
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\store\Saaj.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */