package org.b.a.a.a.a;

import java.util.Calendar;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlDateTime;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.b.a.a.a.e;
import org.b.a.a.a.u;
import org.b.a.a.a.w;
import org.etsi.uri.x01903.v13.SignatureProductionPlaceType;
import org.etsi.uri.x01903.v13.SignerRoleType;

public class w extends XmlComplexContentImpl implements w {
  private static final b P = new b("http://uri.etsi.org/01903/v1.3.2#", "SigningTime");
  
  private static final b Q = new b("http://uri.etsi.org/01903/v1.3.2#", "SigningCertificate");
  
  private static final b R = new b("http://uri.etsi.org/01903/v1.3.2#", "SignaturePolicyIdentifier");
  
  private static final b S = new b("http://uri.etsi.org/01903/v1.3.2#", "SignatureProductionPlace");
  
  private static final b T = new b("http://uri.etsi.org/01903/v1.3.2#", "SignerRole");
  
  private static final b ID$10 = new b("", "Id");
  
  public w(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public Calendar l() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(P, 0);
      if (simpleValue == null)
        return null; 
      return simpleValue.getCalendarValue();
    } 
  }
  
  public XmlDateTime c() {
    synchronized (monitor()) {
      check_orphaned();
      XmlDateTime xmlDateTime = null;
      xmlDateTime = (XmlDateTime)get_store().find_element_user(P, 0);
      return xmlDateTime;
    } 
  }
  
  public boolean eP() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(P) != 0);
    } 
  }
  
  public void e(Calendar paramCalendar) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_element_user(P, 0);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_element_user(P); 
      simpleValue.setCalendarValue(paramCalendar);
    } 
  }
  
  public void c(XmlDateTime paramXmlDateTime) {
    synchronized (monitor()) {
      check_orphaned();
      XmlDateTime xmlDateTime = null;
      xmlDateTime = (XmlDateTime)get_store().find_element_user(P, 0);
      if (xmlDateTime == null)
        xmlDateTime = (XmlDateTime)get_store().add_element_user(P); 
      xmlDateTime.set((XmlObject)paramXmlDateTime);
    } 
  }
  
  public void hF() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(P, 0);
    } 
  }
  
  public e d() {
    synchronized (monitor()) {
      check_orphaned();
      e e = null;
      e = (e)get_store().find_element_user(Q, 0);
      if (e == null)
        return null; 
      return e;
    } 
  }
  
  public boolean eQ() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(Q) != 0);
    } 
  }
  
  public void b(e parame) {
    synchronized (monitor()) {
      check_orphaned();
      e e1 = null;
      e1 = (e)get_store().find_element_user(Q, 0);
      if (e1 == null)
        e1 = (e)get_store().add_element_user(Q); 
      e1.set((XmlObject)parame);
    } 
  }
  
  public e e() {
    synchronized (monitor()) {
      check_orphaned();
      e e = null;
      e = (e)get_store().add_element_user(Q);
      return e;
    } 
  }
  
  public void hG() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(Q, 0);
    } 
  }
  
  public u b() {
    synchronized (monitor()) {
      check_orphaned();
      u u = null;
      u = (u)get_store().find_element_user(R, 0);
      if (u == null)
        return null; 
      return u;
    } 
  }
  
  public boolean eR() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(R) != 0);
    } 
  }
  
  public void a(u paramu) {
    synchronized (monitor()) {
      check_orphaned();
      u u1 = null;
      u1 = (u)get_store().find_element_user(R, 0);
      if (u1 == null)
        u1 = (u)get_store().add_element_user(R); 
      u1.set((XmlObject)paramu);
    } 
  }
  
  public u c() {
    synchronized (monitor()) {
      check_orphaned();
      u u = null;
      u = (u)get_store().add_element_user(R);
      return u;
    } 
  }
  
  public void hH() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(R, 0);
    } 
  }
  
  public SignatureProductionPlaceType a() {
    synchronized (monitor()) {
      check_orphaned();
      SignatureProductionPlaceType signatureProductionPlaceType = null;
      signatureProductionPlaceType = (SignatureProductionPlaceType)get_store().find_element_user(S, 0);
      if (signatureProductionPlaceType == null)
        return null; 
      return signatureProductionPlaceType;
    } 
  }
  
  public boolean eS() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(S) != 0);
    } 
  }
  
  public void a(SignatureProductionPlaceType paramSignatureProductionPlaceType) {
    synchronized (monitor()) {
      check_orphaned();
      SignatureProductionPlaceType signatureProductionPlaceType = null;
      signatureProductionPlaceType = (SignatureProductionPlaceType)get_store().find_element_user(S, 0);
      if (signatureProductionPlaceType == null)
        signatureProductionPlaceType = (SignatureProductionPlaceType)get_store().add_element_user(S); 
      signatureProductionPlaceType.set((XmlObject)paramSignatureProductionPlaceType);
    } 
  }
  
  public SignatureProductionPlaceType b() {
    synchronized (monitor()) {
      check_orphaned();
      SignatureProductionPlaceType signatureProductionPlaceType = null;
      signatureProductionPlaceType = (SignatureProductionPlaceType)get_store().add_element_user(S);
      return signatureProductionPlaceType;
    } 
  }
  
  public void hI() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(S, 0);
    } 
  }
  
  public SignerRoleType a() {
    synchronized (monitor()) {
      check_orphaned();
      SignerRoleType signerRoleType = null;
      signerRoleType = (SignerRoleType)get_store().find_element_user(T, 0);
      if (signerRoleType == null)
        return null; 
      return signerRoleType;
    } 
  }
  
  public boolean eT() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().count_elements(T) != 0);
    } 
  }
  
  public void a(SignerRoleType paramSignerRoleType) {
    synchronized (monitor()) {
      check_orphaned();
      SignerRoleType signerRoleType = null;
      signerRoleType = (SignerRoleType)get_store().find_element_user(T, 0);
      if (signerRoleType == null)
        signerRoleType = (SignerRoleType)get_store().add_element_user(T); 
      signerRoleType.set((XmlObject)paramSignerRoleType);
    } 
  }
  
  public SignerRoleType b() {
    synchronized (monitor()) {
      check_orphaned();
      SignerRoleType signerRoleType = null;
      signerRoleType = (SignerRoleType)get_store().add_element_user(T);
      return signerRoleType;
    } 
  }
  
  public void hJ() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(T, 0);
    } 
  }
  
  public String getId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$10);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlID xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlID xmlID = null;
      xmlID = (XmlID)get_store().find_attribute_user(ID$10);
      return xmlID;
    } 
  }
  
  public boolean isSetId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(ID$10) != null);
    } 
  }
  
  public void setId(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(ID$10);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(ID$10); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetId(XmlID paramXmlID) {
    synchronized (monitor()) {
      check_orphaned();
      XmlID xmlID = null;
      xmlID = (XmlID)get_store().find_attribute_user(ID$10);
      if (xmlID == null)
        xmlID = (XmlID)get_store().add_attribute_user(ID$10); 
      xmlID.set((XmlObject)paramXmlID);
    } 
  }
  
  public void unsetId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(ID$10);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\a\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */