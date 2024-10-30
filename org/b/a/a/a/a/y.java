package org.b.a.a.a.a;

import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.b;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlID;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.b.a.a.a.g;
import org.b.a.a.a.h;
import org.b.a.a.a.i;
import org.b.a.a.a.t;
import org.b.a.a.a.y;
import org.b.a.a.a.z;
import org.etsi.uri.x01903.v13.CounterSignatureType;
import org.etsi.uri.x01903.v13.impl.UnsignedSignaturePropertiesTypeImpl;

public class y extends XmlComplexContentImpl implements y {
  private static final b W = new b("http://uri.etsi.org/01903/v1.3.2#", "CounterSignature");
  
  private static final b X = new b("http://uri.etsi.org/01903/v1.3.2#", "SignatureTimeStamp");
  
  private static final b Y = new b("http://uri.etsi.org/01903/v1.3.2#", "CompleteCertificateRefs");
  
  private static final b Z = new b("http://uri.etsi.org/01903/v1.3.2#", "CompleteRevocationRefs");
  
  private static final b aa = new b("http://uri.etsi.org/01903/v1.3.2#", "AttributeCertificateRefs");
  
  private static final b ab = new b("http://uri.etsi.org/01903/v1.3.2#", "AttributeRevocationRefs");
  
  private static final b ac = new b("http://uri.etsi.org/01903/v1.3.2#", "SigAndRefsTimeStamp");
  
  private static final b ad = new b("http://uri.etsi.org/01903/v1.3.2#", "RefsOnlyTimeStamp");
  
  private static final b ae = new b("http://uri.etsi.org/01903/v1.3.2#", "CertificateValues");
  
  private static final b af = new b("http://uri.etsi.org/01903/v1.3.2#", "RevocationValues");
  
  private static final b ag = new b("http://uri.etsi.org/01903/v1.3.2#", "AttrAuthoritiesCertValues");
  
  private static final b ah = new b("http://uri.etsi.org/01903/v1.3.2#", "AttributeRevocationValues");
  
  private static final b ai = new b("http://uri.etsi.org/01903/v1.3.2#", "ArchiveTimeStamp");
  
  private static final b aj = new b("", "Id");
  
  public y(SchemaType paramSchemaType) {
    super(paramSchemaType);
  }
  
  public List<CounterSignatureType> at() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<CounterSignatureType>)new UnsignedSignaturePropertiesTypeImpl.CounterSignatureList((UnsignedSignaturePropertiesTypeImpl)this);
    } 
  }
  
  public CounterSignatureType[] a() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(W, arrayList);
      CounterSignatureType[] arrayOfCounterSignatureType = new CounterSignatureType[arrayList.size()];
      arrayList.toArray((Object[])arrayOfCounterSignatureType);
      return arrayOfCounterSignatureType;
    } 
  }
  
  public CounterSignatureType a(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CounterSignatureType counterSignatureType = null;
      counterSignatureType = (CounterSignatureType)get_store().find_element_user(W, paramInt);
      if (counterSignatureType == null)
        throw new IndexOutOfBoundsException(); 
      return counterSignatureType;
    } 
  }
  
  public int bx() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(W);
    } 
  }
  
  public void a(CounterSignatureType[] paramArrayOfCounterSignatureType) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfCounterSignatureType, W);
    } 
  }
  
  public void a(int paramInt, CounterSignatureType paramCounterSignatureType) {
    synchronized (monitor()) {
      check_orphaned();
      CounterSignatureType counterSignatureType = null;
      counterSignatureType = (CounterSignatureType)get_store().find_element_user(W, paramInt);
      if (counterSignatureType == null)
        throw new IndexOutOfBoundsException(); 
      counterSignatureType.set((XmlObject)paramCounterSignatureType);
    } 
  }
  
  public CounterSignatureType b(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      CounterSignatureType counterSignatureType = null;
      counterSignatureType = (CounterSignatureType)get_store().insert_element_user(W, paramInt);
      return counterSignatureType;
    } 
  }
  
  public CounterSignatureType a() {
    synchronized (monitor()) {
      check_orphaned();
      CounterSignatureType counterSignatureType = null;
      counterSignatureType = (CounterSignatureType)get_store().add_element_user(W);
      return counterSignatureType;
    } 
  }
  
  public void be(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(W, paramInt);
    } 
  }
  
  public List<z> au() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<z>)new UnsignedSignaturePropertiesTypeImpl.SignatureTimeStampList((UnsignedSignaturePropertiesTypeImpl)this);
    } 
  }
  
  public z[] a() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(X, arrayList);
      z[] arrayOfZ = new z[arrayList.size()];
      arrayList.toArray((Object[])arrayOfZ);
      return arrayOfZ;
    } 
  }
  
  public z a(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      z z = null;
      z = (z)get_store().find_element_user(X, paramInt);
      if (z == null)
        throw new IndexOutOfBoundsException(); 
      return z;
    } 
  }
  
  public int by() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(X);
    } 
  }
  
  public void a(z[] paramArrayOfz) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfz, X);
    } 
  }
  
  public void a(int paramInt, z paramz) {
    synchronized (monitor()) {
      check_orphaned();
      z z1 = null;
      z1 = (z)get_store().find_element_user(X, paramInt);
      if (z1 == null)
        throw new IndexOutOfBoundsException(); 
      z1.set((XmlObject)paramz);
    } 
  }
  
  public z b(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      z z = null;
      z = (z)get_store().insert_element_user(X, paramInt);
      return z;
    } 
  }
  
  public z a() {
    synchronized (monitor()) {
      check_orphaned();
      z z = null;
      z = (z)get_store().add_element_user(X);
      return z;
    } 
  }
  
  public void bf(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(X, paramInt);
    } 
  }
  
  public List<h> av() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<h>)new UnsignedSignaturePropertiesTypeImpl.CompleteCertificateRefsList((UnsignedSignaturePropertiesTypeImpl)this);
    } 
  }
  
  public h[] a() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(Y, arrayList);
      h[] arrayOfH = new h[arrayList.size()];
      arrayList.toArray((Object[])arrayOfH);
      return arrayOfH;
    } 
  }
  
  public h a(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      h h = null;
      h = (h)get_store().find_element_user(Y, paramInt);
      if (h == null)
        throw new IndexOutOfBoundsException(); 
      return h;
    } 
  }
  
  public int bz() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(Y);
    } 
  }
  
  public void a(h[] paramArrayOfh) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfh, Y);
    } 
  }
  
  public void a(int paramInt, h paramh) {
    synchronized (monitor()) {
      check_orphaned();
      h h1 = null;
      h1 = (h)get_store().find_element_user(Y, paramInt);
      if (h1 == null)
        throw new IndexOutOfBoundsException(); 
      h1.set((XmlObject)paramh);
    } 
  }
  
  public h b(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      h h = null;
      h = (h)get_store().insert_element_user(Y, paramInt);
      return h;
    } 
  }
  
  public h b() {
    synchronized (monitor()) {
      check_orphaned();
      h h = null;
      h = (h)get_store().add_element_user(Y);
      return h;
    } 
  }
  
  public void bg(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(Y, paramInt);
    } 
  }
  
  public List<i> aw() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<i>)new UnsignedSignaturePropertiesTypeImpl.CompleteRevocationRefsList((UnsignedSignaturePropertiesTypeImpl)this);
    } 
  }
  
  public i[] a() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(Z, arrayList);
      i[] arrayOfI = new i[arrayList.size()];
      arrayList.toArray((Object[])arrayOfI);
      return arrayOfI;
    } 
  }
  
  public i a(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      i i = null;
      i = (i)get_store().find_element_user(Z, paramInt);
      if (i == null)
        throw new IndexOutOfBoundsException(); 
      return i;
    } 
  }
  
  public int bA() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(Z);
    } 
  }
  
  public void a(i[] paramArrayOfi) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfi, Z);
    } 
  }
  
  public void a(int paramInt, i parami) {
    synchronized (monitor()) {
      check_orphaned();
      i i1 = null;
      i1 = (i)get_store().find_element_user(Z, paramInt);
      if (i1 == null)
        throw new IndexOutOfBoundsException(); 
      i1.set((XmlObject)parami);
    } 
  }
  
  public i b(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      i i = null;
      i = (i)get_store().insert_element_user(Z, paramInt);
      return i;
    } 
  }
  
  public i b() {
    synchronized (monitor()) {
      check_orphaned();
      i i = null;
      i = (i)get_store().add_element_user(Z);
      return i;
    } 
  }
  
  public void bh(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(Z, paramInt);
    } 
  }
  
  public List<h> ax() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<h>)new UnsignedSignaturePropertiesTypeImpl.AttributeCertificateRefsList((UnsignedSignaturePropertiesTypeImpl)this);
    } 
  }
  
  public h[] b() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(aa, arrayList);
      h[] arrayOfH = new h[arrayList.size()];
      arrayList.toArray((Object[])arrayOfH);
      return arrayOfH;
    } 
  }
  
  public h c(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      h h = null;
      h = (h)get_store().find_element_user(aa, paramInt);
      if (h == null)
        throw new IndexOutOfBoundsException(); 
      return h;
    } 
  }
  
  public int bB() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(aa);
    } 
  }
  
  public void b(h[] paramArrayOfh) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfh, aa);
    } 
  }
  
  public void b(int paramInt, h paramh) {
    synchronized (monitor()) {
      check_orphaned();
      h h1 = null;
      h1 = (h)get_store().find_element_user(aa, paramInt);
      if (h1 == null)
        throw new IndexOutOfBoundsException(); 
      h1.set((XmlObject)paramh);
    } 
  }
  
  public h d(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      h h = null;
      h = (h)get_store().insert_element_user(aa, paramInt);
      return h;
    } 
  }
  
  public h c() {
    synchronized (monitor()) {
      check_orphaned();
      h h = null;
      h = (h)get_store().add_element_user(aa);
      return h;
    } 
  }
  
  public void bi(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(aa, paramInt);
    } 
  }
  
  public List<i> ay() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<i>)new UnsignedSignaturePropertiesTypeImpl.AttributeRevocationRefsList((UnsignedSignaturePropertiesTypeImpl)this);
    } 
  }
  
  public i[] b() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ab, arrayList);
      i[] arrayOfI = new i[arrayList.size()];
      arrayList.toArray((Object[])arrayOfI);
      return arrayOfI;
    } 
  }
  
  public i c(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      i i = null;
      i = (i)get_store().find_element_user(ab, paramInt);
      if (i == null)
        throw new IndexOutOfBoundsException(); 
      return i;
    } 
  }
  
  public int bC() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ab);
    } 
  }
  
  public void b(i[] paramArrayOfi) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfi, ab);
    } 
  }
  
  public void b(int paramInt, i parami) {
    synchronized (monitor()) {
      check_orphaned();
      i i1 = null;
      i1 = (i)get_store().find_element_user(ab, paramInt);
      if (i1 == null)
        throw new IndexOutOfBoundsException(); 
      i1.set((XmlObject)parami);
    } 
  }
  
  public i d(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      i i = null;
      i = (i)get_store().insert_element_user(ab, paramInt);
      return i;
    } 
  }
  
  public i c() {
    synchronized (monitor()) {
      check_orphaned();
      i i = null;
      i = (i)get_store().add_element_user(ab);
      return i;
    } 
  }
  
  public void bj(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ab, paramInt);
    } 
  }
  
  public List<z> az() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<z>)new UnsignedSignaturePropertiesTypeImpl.SigAndRefsTimeStampList((UnsignedSignaturePropertiesTypeImpl)this);
    } 
  }
  
  public z[] b() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ac, arrayList);
      z[] arrayOfZ = new z[arrayList.size()];
      arrayList.toArray((Object[])arrayOfZ);
      return arrayOfZ;
    } 
  }
  
  public z c(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      z z = null;
      z = (z)get_store().find_element_user(ac, paramInt);
      if (z == null)
        throw new IndexOutOfBoundsException(); 
      return z;
    } 
  }
  
  public int bD() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ac);
    } 
  }
  
  public void b(z[] paramArrayOfz) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfz, ac);
    } 
  }
  
  public void b(int paramInt, z paramz) {
    synchronized (monitor()) {
      check_orphaned();
      z z1 = null;
      z1 = (z)get_store().find_element_user(ac, paramInt);
      if (z1 == null)
        throw new IndexOutOfBoundsException(); 
      z1.set((XmlObject)paramz);
    } 
  }
  
  public z d(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      z z = null;
      z = (z)get_store().insert_element_user(ac, paramInt);
      return z;
    } 
  }
  
  public z b() {
    synchronized (monitor()) {
      check_orphaned();
      z z = null;
      z = (z)get_store().add_element_user(ac);
      return z;
    } 
  }
  
  public void bk(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ac, paramInt);
    } 
  }
  
  public List<z> aA() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<z>)new UnsignedSignaturePropertiesTypeImpl.RefsOnlyTimeStampList((UnsignedSignaturePropertiesTypeImpl)this);
    } 
  }
  
  public z[] c() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ad, arrayList);
      z[] arrayOfZ = new z[arrayList.size()];
      arrayList.toArray((Object[])arrayOfZ);
      return arrayOfZ;
    } 
  }
  
  public z e(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      z z = null;
      z = (z)get_store().find_element_user(ad, paramInt);
      if (z == null)
        throw new IndexOutOfBoundsException(); 
      return z;
    } 
  }
  
  public int bE() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ad);
    } 
  }
  
  public void c(z[] paramArrayOfz) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfz, ad);
    } 
  }
  
  public void c(int paramInt, z paramz) {
    synchronized (monitor()) {
      check_orphaned();
      z z1 = null;
      z1 = (z)get_store().find_element_user(ad, paramInt);
      if (z1 == null)
        throw new IndexOutOfBoundsException(); 
      z1.set((XmlObject)paramz);
    } 
  }
  
  public z f(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      z z = null;
      z = (z)get_store().insert_element_user(ad, paramInt);
      return z;
    } 
  }
  
  public z c() {
    synchronized (monitor()) {
      check_orphaned();
      z z = null;
      z = (z)get_store().add_element_user(ad);
      return z;
    } 
  }
  
  public void bl(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ad, paramInt);
    } 
  }
  
  public List<g> aB() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<g>)new UnsignedSignaturePropertiesTypeImpl.CertificateValuesList((UnsignedSignaturePropertiesTypeImpl)this);
    } 
  }
  
  public g[] a() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ae, arrayList);
      g[] arrayOfG = new g[arrayList.size()];
      arrayList.toArray((Object[])arrayOfG);
      return arrayOfG;
    } 
  }
  
  public g a(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      g g = null;
      g = (g)get_store().find_element_user(ae, paramInt);
      if (g == null)
        throw new IndexOutOfBoundsException(); 
      return g;
    } 
  }
  
  public int bF() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ae);
    } 
  }
  
  public void a(g[] paramArrayOfg) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfg, ae);
    } 
  }
  
  public void a(int paramInt, g paramg) {
    synchronized (monitor()) {
      check_orphaned();
      g g1 = null;
      g1 = (g)get_store().find_element_user(ae, paramInt);
      if (g1 == null)
        throw new IndexOutOfBoundsException(); 
      g1.set((XmlObject)paramg);
    } 
  }
  
  public g b(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      g g = null;
      g = (g)get_store().insert_element_user(ae, paramInt);
      return g;
    } 
  }
  
  public g b() {
    synchronized (monitor()) {
      check_orphaned();
      g g = null;
      g = (g)get_store().add_element_user(ae);
      return g;
    } 
  }
  
  public void bm(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ae, paramInt);
    } 
  }
  
  public List<t> aC() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<t>)new UnsignedSignaturePropertiesTypeImpl.RevocationValuesList((UnsignedSignaturePropertiesTypeImpl)this);
    } 
  }
  
  public t[] a() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(af, arrayList);
      t[] arrayOfT = new t[arrayList.size()];
      arrayList.toArray((Object[])arrayOfT);
      return arrayOfT;
    } 
  }
  
  public t a(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      t t = null;
      t = (t)get_store().find_element_user(af, paramInt);
      if (t == null)
        throw new IndexOutOfBoundsException(); 
      return t;
    } 
  }
  
  public int bG() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(af);
    } 
  }
  
  public void a(t[] paramArrayOft) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOft, af);
    } 
  }
  
  public void a(int paramInt, t paramt) {
    synchronized (monitor()) {
      check_orphaned();
      t t1 = null;
      t1 = (t)get_store().find_element_user(af, paramInt);
      if (t1 == null)
        throw new IndexOutOfBoundsException(); 
      t1.set((XmlObject)paramt);
    } 
  }
  
  public t b(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      t t = null;
      t = (t)get_store().insert_element_user(af, paramInt);
      return t;
    } 
  }
  
  public t b() {
    synchronized (monitor()) {
      check_orphaned();
      t t = null;
      t = (t)get_store().add_element_user(af);
      return t;
    } 
  }
  
  public void bn(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(af, paramInt);
    } 
  }
  
  public List<g> aD() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<g>)new UnsignedSignaturePropertiesTypeImpl.AttrAuthoritiesCertValuesList((UnsignedSignaturePropertiesTypeImpl)this);
    } 
  }
  
  public g[] b() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ag, arrayList);
      g[] arrayOfG = new g[arrayList.size()];
      arrayList.toArray((Object[])arrayOfG);
      return arrayOfG;
    } 
  }
  
  public g c(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      g g = null;
      g = (g)get_store().find_element_user(ag, paramInt);
      if (g == null)
        throw new IndexOutOfBoundsException(); 
      return g;
    } 
  }
  
  public int bH() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ag);
    } 
  }
  
  public void b(g[] paramArrayOfg) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfg, ag);
    } 
  }
  
  public void b(int paramInt, g paramg) {
    synchronized (monitor()) {
      check_orphaned();
      g g1 = null;
      g1 = (g)get_store().find_element_user(ag, paramInt);
      if (g1 == null)
        throw new IndexOutOfBoundsException(); 
      g1.set((XmlObject)paramg);
    } 
  }
  
  public g d(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      g g = null;
      g = (g)get_store().insert_element_user(ag, paramInt);
      return g;
    } 
  }
  
  public g c() {
    synchronized (monitor()) {
      check_orphaned();
      g g = null;
      g = (g)get_store().add_element_user(ag);
      return g;
    } 
  }
  
  public void bo(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ag, paramInt);
    } 
  }
  
  public List<t> aE() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<t>)new UnsignedSignaturePropertiesTypeImpl.AttributeRevocationValuesList((UnsignedSignaturePropertiesTypeImpl)this);
    } 
  }
  
  public t[] b() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ah, arrayList);
      t[] arrayOfT = new t[arrayList.size()];
      arrayList.toArray((Object[])arrayOfT);
      return arrayOfT;
    } 
  }
  
  public t c(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      t t = null;
      t = (t)get_store().find_element_user(ah, paramInt);
      if (t == null)
        throw new IndexOutOfBoundsException(); 
      return t;
    } 
  }
  
  public int bI() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ah);
    } 
  }
  
  public void b(t[] paramArrayOft) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOft, ah);
    } 
  }
  
  public void b(int paramInt, t paramt) {
    synchronized (monitor()) {
      check_orphaned();
      t t1 = null;
      t1 = (t)get_store().find_element_user(ah, paramInt);
      if (t1 == null)
        throw new IndexOutOfBoundsException(); 
      t1.set((XmlObject)paramt);
    } 
  }
  
  public t d(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      t t = null;
      t = (t)get_store().insert_element_user(ah, paramInt);
      return t;
    } 
  }
  
  public t c() {
    synchronized (monitor()) {
      check_orphaned();
      t t = null;
      t = (t)get_store().add_element_user(ah);
      return t;
    } 
  }
  
  public void bp(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ah, paramInt);
    } 
  }
  
  public List<z> aF() {
    synchronized (monitor()) {
      check_orphaned();
      return (List<z>)new UnsignedSignaturePropertiesTypeImpl.ArchiveTimeStampList((UnsignedSignaturePropertiesTypeImpl)this);
    } 
  }
  
  public z[] d() {
    synchronized (monitor()) {
      check_orphaned();
      ArrayList arrayList = new ArrayList();
      get_store().find_all_element_users(ai, arrayList);
      z[] arrayOfZ = new z[arrayList.size()];
      arrayList.toArray((Object[])arrayOfZ);
      return arrayOfZ;
    } 
  }
  
  public z g(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      z z = null;
      z = (z)get_store().find_element_user(ai, paramInt);
      if (z == null)
        throw new IndexOutOfBoundsException(); 
      return z;
    } 
  }
  
  public int bJ() {
    synchronized (monitor()) {
      check_orphaned();
      return get_store().count_elements(ai);
    } 
  }
  
  public void d(z[] paramArrayOfz) {
    synchronized (monitor()) {
      check_orphaned();
      arraySetterHelper((XmlObject[])paramArrayOfz, ai);
    } 
  }
  
  public void d(int paramInt, z paramz) {
    synchronized (monitor()) {
      check_orphaned();
      z z1 = null;
      z1 = (z)get_store().find_element_user(ai, paramInt);
      if (z1 == null)
        throw new IndexOutOfBoundsException(); 
      z1.set((XmlObject)paramz);
    } 
  }
  
  public z h(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      z z = null;
      z = (z)get_store().insert_element_user(ai, paramInt);
      return z;
    } 
  }
  
  public z d() {
    synchronized (monitor()) {
      check_orphaned();
      z z = null;
      z = (z)get_store().add_element_user(ai);
      return z;
    } 
  }
  
  public void bq(int paramInt) {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_element(ai, paramInt);
    } 
  }
  
  public String getId() {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(aj);
      if (simpleValue == null)
        return null; 
      return simpleValue.getStringValue();
    } 
  }
  
  public XmlID xgetId() {
    synchronized (monitor()) {
      check_orphaned();
      XmlID xmlID = null;
      xmlID = (XmlID)get_store().find_attribute_user(aj);
      return xmlID;
    } 
  }
  
  public boolean isSetId() {
    synchronized (monitor()) {
      check_orphaned();
      return (get_store().find_attribute_user(aj) != null);
    } 
  }
  
  public void setId(String paramString) {
    synchronized (monitor()) {
      check_orphaned();
      SimpleValue simpleValue = null;
      simpleValue = (SimpleValue)get_store().find_attribute_user(aj);
      if (simpleValue == null)
        simpleValue = (SimpleValue)get_store().add_attribute_user(aj); 
      simpleValue.setStringValue(paramString);
    } 
  }
  
  public void xsetId(XmlID paramXmlID) {
    synchronized (monitor()) {
      check_orphaned();
      XmlID xmlID = null;
      xmlID = (XmlID)get_store().find_attribute_user(aj);
      if (xmlID == null)
        xmlID = (XmlID)get_store().add_attribute_user(aj); 
      xmlID.set((XmlObject)paramXmlID);
    } 
  }
  
  public void unsetId() {
    synchronized (monitor()) {
      check_orphaned();
      get_store().remove_attribute(aj);
    } 
  }
}


/* Location:              C:\Arremate\Arremate.jar!\org\b\a\a\a\a\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */