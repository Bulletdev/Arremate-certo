/*      */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*      */ import java.util.ArrayList;
/*      */ import javax.xml.namespace.b;
/*      */ import org.apache.xmlbeans.SimpleValue;
/*      */ import org.apache.xmlbeans.XmlBoolean;
/*      */ import org.apache.xmlbeans.XmlNonNegativeInteger;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.apache.xmlbeans.XmlQName;
/*      */ import org.apache.xmlbeans.XmlString;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.AllNNI;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.FormChoice;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.Keybase;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.LocalComplexType;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;
/*      */ 
/*      */ public class ElementImpl extends AnnotatedImpl implements Element {
/*      */   public ElementImpl(SchemaType paramSchemaType) {
/*   19 */     super(paramSchemaType);
/*      */   }
/*      */   
/*   22 */   private static final b SIMPLETYPE$0 = new b("http://www.w3.org/2001/XMLSchema", "simpleType");
/*      */   
/*   24 */   private static final b COMPLEXTYPE$2 = new b("http://www.w3.org/2001/XMLSchema", "complexType");
/*      */   
/*   26 */   private static final b UNIQUE$4 = new b("http://www.w3.org/2001/XMLSchema", "unique");
/*      */   
/*   28 */   private static final b KEY$6 = new b("http://www.w3.org/2001/XMLSchema", "key");
/*      */   
/*   30 */   private static final b KEYREF$8 = new b("http://www.w3.org/2001/XMLSchema", "keyref");
/*      */   
/*   32 */   private static final b NAME$10 = new b("", "name");
/*      */   
/*   34 */   private static final b REF$12 = new b("", "ref");
/*      */   
/*   36 */   private static final b TYPE$14 = new b("", "type");
/*      */   
/*   38 */   private static final b SUBSTITUTIONGROUP$16 = new b("", "substitutionGroup");
/*      */   
/*   40 */   private static final b MINOCCURS$18 = new b("", "minOccurs");
/*      */   
/*   42 */   private static final b MAXOCCURS$20 = new b("", "maxOccurs");
/*      */   
/*   44 */   private static final b DEFAULT$22 = new b("", "default");
/*      */   
/*   46 */   private static final b FIXED$24 = new b("", "fixed");
/*      */   
/*   48 */   private static final b NILLABLE$26 = new b("", "nillable");
/*      */   
/*   50 */   private static final b ABSTRACT$28 = new b("", "abstract");
/*      */   
/*   52 */   private static final b FINAL$30 = new b("", "final");
/*      */   
/*   54 */   private static final b BLOCK$32 = new b("", "block");
/*      */   
/*   56 */   private static final b FORM$34 = new b("", "form");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LocalSimpleType getSimpleType() {
/*   65 */     synchronized (monitor()) {
/*      */       
/*   67 */       check_orphaned();
/*   68 */       LocalSimpleType localSimpleType = null;
/*   69 */       localSimpleType = (LocalSimpleType)get_store().find_element_user(SIMPLETYPE$0, 0);
/*   70 */       if (localSimpleType == null)
/*      */       {
/*   72 */         return null;
/*      */       }
/*   74 */       return localSimpleType;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetSimpleType() {
/*   83 */     synchronized (monitor()) {
/*      */       
/*   85 */       check_orphaned();
/*   86 */       return (get_store().count_elements(SIMPLETYPE$0) != 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSimpleType(LocalSimpleType paramLocalSimpleType) {
/*   95 */     synchronized (monitor()) {
/*      */       
/*   97 */       check_orphaned();
/*   98 */       LocalSimpleType localSimpleType = null;
/*   99 */       localSimpleType = (LocalSimpleType)get_store().find_element_user(SIMPLETYPE$0, 0);
/*  100 */       if (localSimpleType == null)
/*      */       {
/*  102 */         localSimpleType = (LocalSimpleType)get_store().add_element_user(SIMPLETYPE$0);
/*      */       }
/*  104 */       localSimpleType.set((XmlObject)paramLocalSimpleType);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LocalSimpleType addNewSimpleType() {
/*  113 */     synchronized (monitor()) {
/*      */       
/*  115 */       check_orphaned();
/*  116 */       LocalSimpleType localSimpleType = null;
/*  117 */       localSimpleType = (LocalSimpleType)get_store().add_element_user(SIMPLETYPE$0);
/*  118 */       return localSimpleType;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetSimpleType() {
/*  127 */     synchronized (monitor()) {
/*      */       
/*  129 */       check_orphaned();
/*  130 */       get_store().remove_element(SIMPLETYPE$0, 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LocalComplexType getComplexType() {
/*  139 */     synchronized (monitor()) {
/*      */       
/*  141 */       check_orphaned();
/*  142 */       LocalComplexType localComplexType = null;
/*  143 */       localComplexType = (LocalComplexType)get_store().find_element_user(COMPLEXTYPE$2, 0);
/*  144 */       if (localComplexType == null)
/*      */       {
/*  146 */         return null;
/*      */       }
/*  148 */       return localComplexType;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetComplexType() {
/*  157 */     synchronized (monitor()) {
/*      */       
/*  159 */       check_orphaned();
/*  160 */       return (get_store().count_elements(COMPLEXTYPE$2) != 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setComplexType(LocalComplexType paramLocalComplexType) {
/*  169 */     synchronized (monitor()) {
/*      */       
/*  171 */       check_orphaned();
/*  172 */       LocalComplexType localComplexType = null;
/*  173 */       localComplexType = (LocalComplexType)get_store().find_element_user(COMPLEXTYPE$2, 0);
/*  174 */       if (localComplexType == null)
/*      */       {
/*  176 */         localComplexType = (LocalComplexType)get_store().add_element_user(COMPLEXTYPE$2);
/*      */       }
/*  178 */       localComplexType.set((XmlObject)paramLocalComplexType);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public LocalComplexType addNewComplexType() {
/*  187 */     synchronized (monitor()) {
/*      */       
/*  189 */       check_orphaned();
/*  190 */       LocalComplexType localComplexType = null;
/*  191 */       localComplexType = (LocalComplexType)get_store().add_element_user(COMPLEXTYPE$2);
/*  192 */       return localComplexType;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetComplexType() {
/*  201 */     synchronized (monitor()) {
/*      */       
/*  203 */       check_orphaned();
/*  204 */       get_store().remove_element(COMPLEXTYPE$2, 0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Keybase[] getUniqueArray() {
/*  213 */     synchronized (monitor()) {
/*      */       
/*  215 */       check_orphaned();
/*  216 */       ArrayList arrayList = new ArrayList();
/*  217 */       get_store().find_all_element_users(UNIQUE$4, arrayList);
/*  218 */       Keybase[] arrayOfKeybase = new Keybase[arrayList.size()];
/*  219 */       arrayList.toArray((Object[])arrayOfKeybase);
/*  220 */       return arrayOfKeybase;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Keybase getUniqueArray(int paramInt) {
/*  229 */     synchronized (monitor()) {
/*      */       
/*  231 */       check_orphaned();
/*  232 */       Keybase keybase = null;
/*  233 */       keybase = (Keybase)get_store().find_element_user(UNIQUE$4, paramInt);
/*  234 */       if (keybase == null)
/*      */       {
/*  236 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  238 */       return keybase;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sizeOfUniqueArray() {
/*  247 */     synchronized (monitor()) {
/*      */       
/*  249 */       check_orphaned();
/*  250 */       return get_store().count_elements(UNIQUE$4);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUniqueArray(Keybase[] paramArrayOfKeybase) {
/*  259 */     synchronized (monitor()) {
/*      */       
/*  261 */       check_orphaned();
/*  262 */       arraySetterHelper((XmlObject[])paramArrayOfKeybase, UNIQUE$4);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setUniqueArray(int paramInt, Keybase paramKeybase) {
/*  271 */     synchronized (monitor()) {
/*      */       
/*  273 */       check_orphaned();
/*  274 */       Keybase keybase = null;
/*  275 */       keybase = (Keybase)get_store().find_element_user(UNIQUE$4, paramInt);
/*  276 */       if (keybase == null)
/*      */       {
/*  278 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  280 */       keybase.set((XmlObject)paramKeybase);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Keybase insertNewUnique(int paramInt) {
/*  289 */     synchronized (monitor()) {
/*      */       
/*  291 */       check_orphaned();
/*  292 */       Keybase keybase = null;
/*  293 */       keybase = (Keybase)get_store().insert_element_user(UNIQUE$4, paramInt);
/*  294 */       return keybase;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Keybase addNewUnique() {
/*  303 */     synchronized (monitor()) {
/*      */       
/*  305 */       check_orphaned();
/*  306 */       Keybase keybase = null;
/*  307 */       keybase = (Keybase)get_store().add_element_user(UNIQUE$4);
/*  308 */       return keybase;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeUnique(int paramInt) {
/*  317 */     synchronized (monitor()) {
/*      */       
/*  319 */       check_orphaned();
/*  320 */       get_store().remove_element(UNIQUE$4, paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Keybase[] getKeyArray() {
/*  329 */     synchronized (monitor()) {
/*      */       
/*  331 */       check_orphaned();
/*  332 */       ArrayList arrayList = new ArrayList();
/*  333 */       get_store().find_all_element_users(KEY$6, arrayList);
/*  334 */       Keybase[] arrayOfKeybase = new Keybase[arrayList.size()];
/*  335 */       arrayList.toArray((Object[])arrayOfKeybase);
/*  336 */       return arrayOfKeybase;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Keybase getKeyArray(int paramInt) {
/*  345 */     synchronized (monitor()) {
/*      */       
/*  347 */       check_orphaned();
/*  348 */       Keybase keybase = null;
/*  349 */       keybase = (Keybase)get_store().find_element_user(KEY$6, paramInt);
/*  350 */       if (keybase == null)
/*      */       {
/*  352 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  354 */       return keybase;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sizeOfKeyArray() {
/*  363 */     synchronized (monitor()) {
/*      */       
/*  365 */       check_orphaned();
/*  366 */       return get_store().count_elements(KEY$6);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setKeyArray(Keybase[] paramArrayOfKeybase) {
/*  375 */     synchronized (monitor()) {
/*      */       
/*  377 */       check_orphaned();
/*  378 */       arraySetterHelper((XmlObject[])paramArrayOfKeybase, KEY$6);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setKeyArray(int paramInt, Keybase paramKeybase) {
/*  387 */     synchronized (monitor()) {
/*      */       
/*  389 */       check_orphaned();
/*  390 */       Keybase keybase = null;
/*  391 */       keybase = (Keybase)get_store().find_element_user(KEY$6, paramInt);
/*  392 */       if (keybase == null)
/*      */       {
/*  394 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  396 */       keybase.set((XmlObject)paramKeybase);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Keybase insertNewKey(int paramInt) {
/*  405 */     synchronized (monitor()) {
/*      */       
/*  407 */       check_orphaned();
/*  408 */       Keybase keybase = null;
/*  409 */       keybase = (Keybase)get_store().insert_element_user(KEY$6, paramInt);
/*  410 */       return keybase;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Keybase addNewKey() {
/*  419 */     synchronized (monitor()) {
/*      */       
/*  421 */       check_orphaned();
/*  422 */       Keybase keybase = null;
/*  423 */       keybase = (Keybase)get_store().add_element_user(KEY$6);
/*  424 */       return keybase;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeKey(int paramInt) {
/*  433 */     synchronized (monitor()) {
/*      */       
/*  435 */       check_orphaned();
/*  436 */       get_store().remove_element(KEY$6, paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public KeyrefDocument.Keyref[] getKeyrefArray() {
/*  445 */     synchronized (monitor()) {
/*      */       
/*  447 */       check_orphaned();
/*  448 */       ArrayList arrayList = new ArrayList();
/*  449 */       get_store().find_all_element_users(KEYREF$8, arrayList);
/*  450 */       KeyrefDocument.Keyref[] arrayOfKeyref = new KeyrefDocument.Keyref[arrayList.size()];
/*  451 */       arrayList.toArray((Object[])arrayOfKeyref);
/*  452 */       return arrayOfKeyref;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public KeyrefDocument.Keyref getKeyrefArray(int paramInt) {
/*  461 */     synchronized (monitor()) {
/*      */       
/*  463 */       check_orphaned();
/*  464 */       KeyrefDocument.Keyref keyref = null;
/*  465 */       keyref = (KeyrefDocument.Keyref)get_store().find_element_user(KEYREF$8, paramInt);
/*  466 */       if (keyref == null)
/*      */       {
/*  468 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  470 */       return keyref;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int sizeOfKeyrefArray() {
/*  479 */     synchronized (monitor()) {
/*      */       
/*  481 */       check_orphaned();
/*  482 */       return get_store().count_elements(KEYREF$8);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setKeyrefArray(KeyrefDocument.Keyref[] paramArrayOfKeyref) {
/*  491 */     synchronized (monitor()) {
/*      */       
/*  493 */       check_orphaned();
/*  494 */       arraySetterHelper((XmlObject[])paramArrayOfKeyref, KEYREF$8);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setKeyrefArray(int paramInt, KeyrefDocument.Keyref paramKeyref) {
/*  503 */     synchronized (monitor()) {
/*      */       
/*  505 */       check_orphaned();
/*  506 */       KeyrefDocument.Keyref keyref = null;
/*  507 */       keyref = (KeyrefDocument.Keyref)get_store().find_element_user(KEYREF$8, paramInt);
/*  508 */       if (keyref == null)
/*      */       {
/*  510 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  512 */       keyref.set((XmlObject)paramKeyref);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public KeyrefDocument.Keyref insertNewKeyref(int paramInt) {
/*  521 */     synchronized (monitor()) {
/*      */       
/*  523 */       check_orphaned();
/*  524 */       KeyrefDocument.Keyref keyref = null;
/*  525 */       keyref = (KeyrefDocument.Keyref)get_store().insert_element_user(KEYREF$8, paramInt);
/*  526 */       return keyref;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public KeyrefDocument.Keyref addNewKeyref() {
/*  535 */     synchronized (monitor()) {
/*      */       
/*  537 */       check_orphaned();
/*  538 */       KeyrefDocument.Keyref keyref = null;
/*  539 */       keyref = (KeyrefDocument.Keyref)get_store().add_element_user(KEYREF$8);
/*  540 */       return keyref;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removeKeyref(int paramInt) {
/*  549 */     synchronized (monitor()) {
/*      */       
/*  551 */       check_orphaned();
/*  552 */       get_store().remove_element(KEYREF$8, paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getName() {
/*  561 */     synchronized (monitor()) {
/*      */       
/*  563 */       check_orphaned();
/*  564 */       SimpleValue simpleValue = null;
/*  565 */       simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$10);
/*  566 */       if (simpleValue == null)
/*      */       {
/*  568 */         return null;
/*      */       }
/*  570 */       return simpleValue.getStringValue();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlNCName xgetName() {
/*  579 */     synchronized (monitor()) {
/*      */       
/*  581 */       check_orphaned();
/*  582 */       XmlNCName xmlNCName = null;
/*  583 */       xmlNCName = (XmlNCName)get_store().find_attribute_user(NAME$10);
/*  584 */       return xmlNCName;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetName() {
/*  593 */     synchronized (monitor()) {
/*      */       
/*  595 */       check_orphaned();
/*  596 */       return (get_store().find_attribute_user(NAME$10) != null);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setName(String paramString) {
/*  605 */     synchronized (monitor()) {
/*      */       
/*  607 */       check_orphaned();
/*  608 */       SimpleValue simpleValue = null;
/*  609 */       simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$10);
/*  610 */       if (simpleValue == null)
/*      */       {
/*  612 */         simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$10);
/*      */       }
/*  614 */       simpleValue.setStringValue(paramString);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void xsetName(XmlNCName paramXmlNCName) {
/*  623 */     synchronized (monitor()) {
/*      */       
/*  625 */       check_orphaned();
/*  626 */       XmlNCName xmlNCName = null;
/*  627 */       xmlNCName = (XmlNCName)get_store().find_attribute_user(NAME$10);
/*  628 */       if (xmlNCName == null)
/*      */       {
/*  630 */         xmlNCName = (XmlNCName)get_store().add_attribute_user(NAME$10);
/*      */       }
/*  632 */       xmlNCName.set((XmlObject)paramXmlNCName);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetName() {
/*  641 */     synchronized (monitor()) {
/*      */       
/*  643 */       check_orphaned();
/*  644 */       get_store().remove_attribute(NAME$10);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public b getRef() {
/*  653 */     synchronized (monitor()) {
/*      */       
/*  655 */       check_orphaned();
/*  656 */       SimpleValue simpleValue = null;
/*  657 */       simpleValue = (SimpleValue)get_store().find_attribute_user(REF$12);
/*  658 */       if (simpleValue == null)
/*      */       {
/*  660 */         return null;
/*      */       }
/*  662 */       return simpleValue.getQNameValue();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlQName xgetRef() {
/*  671 */     synchronized (monitor()) {
/*      */       
/*  673 */       check_orphaned();
/*  674 */       XmlQName xmlQName = null;
/*  675 */       xmlQName = (XmlQName)get_store().find_attribute_user(REF$12);
/*  676 */       return xmlQName;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetRef() {
/*  685 */     synchronized (monitor()) {
/*      */       
/*  687 */       check_orphaned();
/*  688 */       return (get_store().find_attribute_user(REF$12) != null);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setRef(b paramb) {
/*  697 */     synchronized (monitor()) {
/*      */       
/*  699 */       check_orphaned();
/*  700 */       SimpleValue simpleValue = null;
/*  701 */       simpleValue = (SimpleValue)get_store().find_attribute_user(REF$12);
/*  702 */       if (simpleValue == null)
/*      */       {
/*  704 */         simpleValue = (SimpleValue)get_store().add_attribute_user(REF$12);
/*      */       }
/*  706 */       simpleValue.setQNameValue(paramb);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void xsetRef(XmlQName paramXmlQName) {
/*  715 */     synchronized (monitor()) {
/*      */       
/*  717 */       check_orphaned();
/*  718 */       XmlQName xmlQName = null;
/*  719 */       xmlQName = (XmlQName)get_store().find_attribute_user(REF$12);
/*  720 */       if (xmlQName == null)
/*      */       {
/*  722 */         xmlQName = (XmlQName)get_store().add_attribute_user(REF$12);
/*      */       }
/*  724 */       xmlQName.set((XmlObject)paramXmlQName);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetRef() {
/*  733 */     synchronized (monitor()) {
/*      */       
/*  735 */       check_orphaned();
/*  736 */       get_store().remove_attribute(REF$12);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public b getType() {
/*  745 */     synchronized (monitor()) {
/*      */       
/*  747 */       check_orphaned();
/*  748 */       SimpleValue simpleValue = null;
/*  749 */       simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$14);
/*  750 */       if (simpleValue == null)
/*      */       {
/*  752 */         return null;
/*      */       }
/*  754 */       return simpleValue.getQNameValue();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlQName xgetType() {
/*  763 */     synchronized (monitor()) {
/*      */       
/*  765 */       check_orphaned();
/*  766 */       XmlQName xmlQName = null;
/*  767 */       xmlQName = (XmlQName)get_store().find_attribute_user(TYPE$14);
/*  768 */       return xmlQName;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetType() {
/*  777 */     synchronized (monitor()) {
/*      */       
/*  779 */       check_orphaned();
/*  780 */       return (get_store().find_attribute_user(TYPE$14) != null);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setType(b paramb) {
/*  789 */     synchronized (monitor()) {
/*      */       
/*  791 */       check_orphaned();
/*  792 */       SimpleValue simpleValue = null;
/*  793 */       simpleValue = (SimpleValue)get_store().find_attribute_user(TYPE$14);
/*  794 */       if (simpleValue == null)
/*      */       {
/*  796 */         simpleValue = (SimpleValue)get_store().add_attribute_user(TYPE$14);
/*      */       }
/*  798 */       simpleValue.setQNameValue(paramb);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void xsetType(XmlQName paramXmlQName) {
/*  807 */     synchronized (monitor()) {
/*      */       
/*  809 */       check_orphaned();
/*  810 */       XmlQName xmlQName = null;
/*  811 */       xmlQName = (XmlQName)get_store().find_attribute_user(TYPE$14);
/*  812 */       if (xmlQName == null)
/*      */       {
/*  814 */         xmlQName = (XmlQName)get_store().add_attribute_user(TYPE$14);
/*      */       }
/*  816 */       xmlQName.set((XmlObject)paramXmlQName);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetType() {
/*  825 */     synchronized (monitor()) {
/*      */       
/*  827 */       check_orphaned();
/*  828 */       get_store().remove_attribute(TYPE$14);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public b getSubstitutionGroup() {
/*  837 */     synchronized (monitor()) {
/*      */       
/*  839 */       check_orphaned();
/*  840 */       SimpleValue simpleValue = null;
/*  841 */       simpleValue = (SimpleValue)get_store().find_attribute_user(SUBSTITUTIONGROUP$16);
/*  842 */       if (simpleValue == null)
/*      */       {
/*  844 */         return null;
/*      */       }
/*  846 */       return simpleValue.getQNameValue();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlQName xgetSubstitutionGroup() {
/*  855 */     synchronized (monitor()) {
/*      */       
/*  857 */       check_orphaned();
/*  858 */       XmlQName xmlQName = null;
/*  859 */       xmlQName = (XmlQName)get_store().find_attribute_user(SUBSTITUTIONGROUP$16);
/*  860 */       return xmlQName;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetSubstitutionGroup() {
/*  869 */     synchronized (monitor()) {
/*      */       
/*  871 */       check_orphaned();
/*  872 */       return (get_store().find_attribute_user(SUBSTITUTIONGROUP$16) != null);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSubstitutionGroup(b paramb) {
/*  881 */     synchronized (monitor()) {
/*      */       
/*  883 */       check_orphaned();
/*  884 */       SimpleValue simpleValue = null;
/*  885 */       simpleValue = (SimpleValue)get_store().find_attribute_user(SUBSTITUTIONGROUP$16);
/*  886 */       if (simpleValue == null)
/*      */       {
/*  888 */         simpleValue = (SimpleValue)get_store().add_attribute_user(SUBSTITUTIONGROUP$16);
/*      */       }
/*  890 */       simpleValue.setQNameValue(paramb);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void xsetSubstitutionGroup(XmlQName paramXmlQName) {
/*  899 */     synchronized (monitor()) {
/*      */       
/*  901 */       check_orphaned();
/*  902 */       XmlQName xmlQName = null;
/*  903 */       xmlQName = (XmlQName)get_store().find_attribute_user(SUBSTITUTIONGROUP$16);
/*  904 */       if (xmlQName == null)
/*      */       {
/*  906 */         xmlQName = (XmlQName)get_store().add_attribute_user(SUBSTITUTIONGROUP$16);
/*      */       }
/*  908 */       xmlQName.set((XmlObject)paramXmlQName);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetSubstitutionGroup() {
/*  917 */     synchronized (monitor()) {
/*      */       
/*  919 */       check_orphaned();
/*  920 */       get_store().remove_attribute(SUBSTITUTIONGROUP$16);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BigInteger getMinOccurs() {
/*  929 */     synchronized (monitor()) {
/*      */       
/*  931 */       check_orphaned();
/*  932 */       SimpleValue simpleValue = null;
/*  933 */       simpleValue = (SimpleValue)get_store().find_attribute_user(MINOCCURS$18);
/*  934 */       if (simpleValue == null)
/*      */       {
/*  936 */         simpleValue = (SimpleValue)get_default_attribute_value(MINOCCURS$18);
/*      */       }
/*  938 */       if (simpleValue == null)
/*      */       {
/*  940 */         return null;
/*      */       }
/*  942 */       return simpleValue.getBigIntegerValue();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlNonNegativeInteger xgetMinOccurs() {
/*  951 */     synchronized (monitor()) {
/*      */       
/*  953 */       check_orphaned();
/*  954 */       XmlNonNegativeInteger xmlNonNegativeInteger = null;
/*  955 */       xmlNonNegativeInteger = (XmlNonNegativeInteger)get_store().find_attribute_user(MINOCCURS$18);
/*  956 */       if (xmlNonNegativeInteger == null)
/*      */       {
/*  958 */         xmlNonNegativeInteger = (XmlNonNegativeInteger)get_default_attribute_value(MINOCCURS$18);
/*      */       }
/*  960 */       return xmlNonNegativeInteger;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetMinOccurs() {
/*  969 */     synchronized (monitor()) {
/*      */       
/*  971 */       check_orphaned();
/*  972 */       return (get_store().find_attribute_user(MINOCCURS$18) != null);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMinOccurs(BigInteger paramBigInteger) {
/*  981 */     synchronized (monitor()) {
/*      */       
/*  983 */       check_orphaned();
/*  984 */       SimpleValue simpleValue = null;
/*  985 */       simpleValue = (SimpleValue)get_store().find_attribute_user(MINOCCURS$18);
/*  986 */       if (simpleValue == null)
/*      */       {
/*  988 */         simpleValue = (SimpleValue)get_store().add_attribute_user(MINOCCURS$18);
/*      */       }
/*  990 */       simpleValue.setBigIntegerValue(paramBigInteger);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void xsetMinOccurs(XmlNonNegativeInteger paramXmlNonNegativeInteger) {
/*  999 */     synchronized (monitor()) {
/*      */       
/* 1001 */       check_orphaned();
/* 1002 */       XmlNonNegativeInteger xmlNonNegativeInteger = null;
/* 1003 */       xmlNonNegativeInteger = (XmlNonNegativeInteger)get_store().find_attribute_user(MINOCCURS$18);
/* 1004 */       if (xmlNonNegativeInteger == null)
/*      */       {
/* 1006 */         xmlNonNegativeInteger = (XmlNonNegativeInteger)get_store().add_attribute_user(MINOCCURS$18);
/*      */       }
/* 1008 */       xmlNonNegativeInteger.set((XmlObject)paramXmlNonNegativeInteger);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetMinOccurs() {
/* 1017 */     synchronized (monitor()) {
/*      */       
/* 1019 */       check_orphaned();
/* 1020 */       get_store().remove_attribute(MINOCCURS$18);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object getMaxOccurs() {
/* 1029 */     synchronized (monitor()) {
/*      */       
/* 1031 */       check_orphaned();
/* 1032 */       SimpleValue simpleValue = null;
/* 1033 */       simpleValue = (SimpleValue)get_store().find_attribute_user(MAXOCCURS$20);
/* 1034 */       if (simpleValue == null)
/*      */       {
/* 1036 */         simpleValue = (SimpleValue)get_default_attribute_value(MAXOCCURS$20);
/*      */       }
/* 1038 */       if (simpleValue == null)
/*      */       {
/* 1040 */         return null;
/*      */       }
/* 1042 */       return simpleValue.getObjectValue();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public AllNNI xgetMaxOccurs() {
/* 1051 */     synchronized (monitor()) {
/*      */       
/* 1053 */       check_orphaned();
/* 1054 */       AllNNI allNNI = null;
/* 1055 */       allNNI = (AllNNI)get_store().find_attribute_user(MAXOCCURS$20);
/* 1056 */       if (allNNI == null)
/*      */       {
/* 1058 */         allNNI = (AllNNI)get_default_attribute_value(MAXOCCURS$20);
/*      */       }
/* 1060 */       return allNNI;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetMaxOccurs() {
/* 1069 */     synchronized (monitor()) {
/*      */       
/* 1071 */       check_orphaned();
/* 1072 */       return (get_store().find_attribute_user(MAXOCCURS$20) != null);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMaxOccurs(Object paramObject) {
/* 1081 */     synchronized (monitor()) {
/*      */       
/* 1083 */       check_orphaned();
/* 1084 */       SimpleValue simpleValue = null;
/* 1085 */       simpleValue = (SimpleValue)get_store().find_attribute_user(MAXOCCURS$20);
/* 1086 */       if (simpleValue == null)
/*      */       {
/* 1088 */         simpleValue = (SimpleValue)get_store().add_attribute_user(MAXOCCURS$20);
/*      */       }
/* 1090 */       simpleValue.setObjectValue(paramObject);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void xsetMaxOccurs(AllNNI paramAllNNI) {
/* 1099 */     synchronized (monitor()) {
/*      */       
/* 1101 */       check_orphaned();
/* 1102 */       AllNNI allNNI = null;
/* 1103 */       allNNI = (AllNNI)get_store().find_attribute_user(MAXOCCURS$20);
/* 1104 */       if (allNNI == null)
/*      */       {
/* 1106 */         allNNI = (AllNNI)get_store().add_attribute_user(MAXOCCURS$20);
/*      */       }
/* 1108 */       allNNI.set((XmlObject)paramAllNNI);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetMaxOccurs() {
/* 1117 */     synchronized (monitor()) {
/*      */       
/* 1119 */       check_orphaned();
/* 1120 */       get_store().remove_attribute(MAXOCCURS$20);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getDefault() {
/* 1129 */     synchronized (monitor()) {
/*      */       
/* 1131 */       check_orphaned();
/* 1132 */       SimpleValue simpleValue = null;
/* 1133 */       simpleValue = (SimpleValue)get_store().find_attribute_user(DEFAULT$22);
/* 1134 */       if (simpleValue == null)
/*      */       {
/* 1136 */         return null;
/*      */       }
/* 1138 */       return simpleValue.getStringValue();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlString xgetDefault() {
/* 1147 */     synchronized (monitor()) {
/*      */       
/* 1149 */       check_orphaned();
/* 1150 */       XmlString xmlString = null;
/* 1151 */       xmlString = (XmlString)get_store().find_attribute_user(DEFAULT$22);
/* 1152 */       return xmlString;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetDefault() {
/* 1161 */     synchronized (monitor()) {
/*      */       
/* 1163 */       check_orphaned();
/* 1164 */       return (get_store().find_attribute_user(DEFAULT$22) != null);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setDefault(String paramString) {
/* 1173 */     synchronized (monitor()) {
/*      */       
/* 1175 */       check_orphaned();
/* 1176 */       SimpleValue simpleValue = null;
/* 1177 */       simpleValue = (SimpleValue)get_store().find_attribute_user(DEFAULT$22);
/* 1178 */       if (simpleValue == null)
/*      */       {
/* 1180 */         simpleValue = (SimpleValue)get_store().add_attribute_user(DEFAULT$22);
/*      */       }
/* 1182 */       simpleValue.setStringValue(paramString);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void xsetDefault(XmlString paramXmlString) {
/* 1191 */     synchronized (monitor()) {
/*      */       
/* 1193 */       check_orphaned();
/* 1194 */       XmlString xmlString = null;
/* 1195 */       xmlString = (XmlString)get_store().find_attribute_user(DEFAULT$22);
/* 1196 */       if (xmlString == null)
/*      */       {
/* 1198 */         xmlString = (XmlString)get_store().add_attribute_user(DEFAULT$22);
/*      */       }
/* 1200 */       xmlString.set((XmlObject)paramXmlString);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetDefault() {
/* 1209 */     synchronized (monitor()) {
/*      */       
/* 1211 */       check_orphaned();
/* 1212 */       get_store().remove_attribute(DEFAULT$22);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getFixed() {
/* 1221 */     synchronized (monitor()) {
/*      */       
/* 1223 */       check_orphaned();
/* 1224 */       SimpleValue simpleValue = null;
/* 1225 */       simpleValue = (SimpleValue)get_store().find_attribute_user(FIXED$24);
/* 1226 */       if (simpleValue == null)
/*      */       {
/* 1228 */         return null;
/*      */       }
/* 1230 */       return simpleValue.getStringValue();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlString xgetFixed() {
/* 1239 */     synchronized (monitor()) {
/*      */       
/* 1241 */       check_orphaned();
/* 1242 */       XmlString xmlString = null;
/* 1243 */       xmlString = (XmlString)get_store().find_attribute_user(FIXED$24);
/* 1244 */       return xmlString;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetFixed() {
/* 1253 */     synchronized (monitor()) {
/*      */       
/* 1255 */       check_orphaned();
/* 1256 */       return (get_store().find_attribute_user(FIXED$24) != null);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFixed(String paramString) {
/* 1265 */     synchronized (monitor()) {
/*      */       
/* 1267 */       check_orphaned();
/* 1268 */       SimpleValue simpleValue = null;
/* 1269 */       simpleValue = (SimpleValue)get_store().find_attribute_user(FIXED$24);
/* 1270 */       if (simpleValue == null)
/*      */       {
/* 1272 */         simpleValue = (SimpleValue)get_store().add_attribute_user(FIXED$24);
/*      */       }
/* 1274 */       simpleValue.setStringValue(paramString);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void xsetFixed(XmlString paramXmlString) {
/* 1283 */     synchronized (monitor()) {
/*      */       
/* 1285 */       check_orphaned();
/* 1286 */       XmlString xmlString = null;
/* 1287 */       xmlString = (XmlString)get_store().find_attribute_user(FIXED$24);
/* 1288 */       if (xmlString == null)
/*      */       {
/* 1290 */         xmlString = (XmlString)get_store().add_attribute_user(FIXED$24);
/*      */       }
/* 1292 */       xmlString.set((XmlObject)paramXmlString);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetFixed() {
/* 1301 */     synchronized (monitor()) {
/*      */       
/* 1303 */       check_orphaned();
/* 1304 */       get_store().remove_attribute(FIXED$24);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getNillable() {
/* 1313 */     synchronized (monitor()) {
/*      */       
/* 1315 */       check_orphaned();
/* 1316 */       SimpleValue simpleValue = null;
/* 1317 */       simpleValue = (SimpleValue)get_store().find_attribute_user(NILLABLE$26);
/* 1318 */       if (simpleValue == null)
/*      */       {
/* 1320 */         simpleValue = (SimpleValue)get_default_attribute_value(NILLABLE$26);
/*      */       }
/* 1322 */       if (simpleValue == null)
/*      */       {
/* 1324 */         return false;
/*      */       }
/* 1326 */       return simpleValue.getBooleanValue();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlBoolean xgetNillable() {
/* 1335 */     synchronized (monitor()) {
/*      */       
/* 1337 */       check_orphaned();
/* 1338 */       XmlBoolean xmlBoolean = null;
/* 1339 */       xmlBoolean = (XmlBoolean)get_store().find_attribute_user(NILLABLE$26);
/* 1340 */       if (xmlBoolean == null)
/*      */       {
/* 1342 */         xmlBoolean = (XmlBoolean)get_default_attribute_value(NILLABLE$26);
/*      */       }
/* 1344 */       return xmlBoolean;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetNillable() {
/* 1353 */     synchronized (monitor()) {
/*      */       
/* 1355 */       check_orphaned();
/* 1356 */       return (get_store().find_attribute_user(NILLABLE$26) != null);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setNillable(boolean paramBoolean) {
/* 1365 */     synchronized (monitor()) {
/*      */       
/* 1367 */       check_orphaned();
/* 1368 */       SimpleValue simpleValue = null;
/* 1369 */       simpleValue = (SimpleValue)get_store().find_attribute_user(NILLABLE$26);
/* 1370 */       if (simpleValue == null)
/*      */       {
/* 1372 */         simpleValue = (SimpleValue)get_store().add_attribute_user(NILLABLE$26);
/*      */       }
/* 1374 */       simpleValue.setBooleanValue(paramBoolean);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void xsetNillable(XmlBoolean paramXmlBoolean) {
/* 1383 */     synchronized (monitor()) {
/*      */       
/* 1385 */       check_orphaned();
/* 1386 */       XmlBoolean xmlBoolean = null;
/* 1387 */       xmlBoolean = (XmlBoolean)get_store().find_attribute_user(NILLABLE$26);
/* 1388 */       if (xmlBoolean == null)
/*      */       {
/* 1390 */         xmlBoolean = (XmlBoolean)get_store().add_attribute_user(NILLABLE$26);
/*      */       }
/* 1392 */       xmlBoolean.set((XmlObject)paramXmlBoolean);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetNillable() {
/* 1401 */     synchronized (monitor()) {
/*      */       
/* 1403 */       check_orphaned();
/* 1404 */       get_store().remove_attribute(NILLABLE$26);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getAbstract() {
/* 1413 */     synchronized (monitor()) {
/*      */       
/* 1415 */       check_orphaned();
/* 1416 */       SimpleValue simpleValue = null;
/* 1417 */       simpleValue = (SimpleValue)get_store().find_attribute_user(ABSTRACT$28);
/* 1418 */       if (simpleValue == null)
/*      */       {
/* 1420 */         simpleValue = (SimpleValue)get_default_attribute_value(ABSTRACT$28);
/*      */       }
/* 1422 */       if (simpleValue == null)
/*      */       {
/* 1424 */         return false;
/*      */       }
/* 1426 */       return simpleValue.getBooleanValue();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlBoolean xgetAbstract() {
/* 1435 */     synchronized (monitor()) {
/*      */       
/* 1437 */       check_orphaned();
/* 1438 */       XmlBoolean xmlBoolean = null;
/* 1439 */       xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ABSTRACT$28);
/* 1440 */       if (xmlBoolean == null)
/*      */       {
/* 1442 */         xmlBoolean = (XmlBoolean)get_default_attribute_value(ABSTRACT$28);
/*      */       }
/* 1444 */       return xmlBoolean;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetAbstract() {
/* 1453 */     synchronized (monitor()) {
/*      */       
/* 1455 */       check_orphaned();
/* 1456 */       return (get_store().find_attribute_user(ABSTRACT$28) != null);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setAbstract(boolean paramBoolean) {
/* 1465 */     synchronized (monitor()) {
/*      */       
/* 1467 */       check_orphaned();
/* 1468 */       SimpleValue simpleValue = null;
/* 1469 */       simpleValue = (SimpleValue)get_store().find_attribute_user(ABSTRACT$28);
/* 1470 */       if (simpleValue == null)
/*      */       {
/* 1472 */         simpleValue = (SimpleValue)get_store().add_attribute_user(ABSTRACT$28);
/*      */       }
/* 1474 */       simpleValue.setBooleanValue(paramBoolean);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void xsetAbstract(XmlBoolean paramXmlBoolean) {
/* 1483 */     synchronized (monitor()) {
/*      */       
/* 1485 */       check_orphaned();
/* 1486 */       XmlBoolean xmlBoolean = null;
/* 1487 */       xmlBoolean = (XmlBoolean)get_store().find_attribute_user(ABSTRACT$28);
/* 1488 */       if (xmlBoolean == null)
/*      */       {
/* 1490 */         xmlBoolean = (XmlBoolean)get_store().add_attribute_user(ABSTRACT$28);
/*      */       }
/* 1492 */       xmlBoolean.set((XmlObject)paramXmlBoolean);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetAbstract() {
/* 1501 */     synchronized (monitor()) {
/*      */       
/* 1503 */       check_orphaned();
/* 1504 */       get_store().remove_attribute(ABSTRACT$28);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object getFinal() {
/* 1513 */     synchronized (monitor()) {
/*      */       
/* 1515 */       check_orphaned();
/* 1516 */       SimpleValue simpleValue = null;
/* 1517 */       simpleValue = (SimpleValue)get_store().find_attribute_user(FINAL$30);
/* 1518 */       if (simpleValue == null)
/*      */       {
/* 1520 */         return null;
/*      */       }
/* 1522 */       return simpleValue.getObjectValue();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DerivationSet xgetFinal() {
/* 1531 */     synchronized (monitor()) {
/*      */       
/* 1533 */       check_orphaned();
/* 1534 */       DerivationSet derivationSet = null;
/* 1535 */       derivationSet = (DerivationSet)get_store().find_attribute_user(FINAL$30);
/* 1536 */       return derivationSet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetFinal() {
/* 1545 */     synchronized (monitor()) {
/*      */       
/* 1547 */       check_orphaned();
/* 1548 */       return (get_store().find_attribute_user(FINAL$30) != null);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setFinal(Object paramObject) {
/* 1557 */     synchronized (monitor()) {
/*      */       
/* 1559 */       check_orphaned();
/* 1560 */       SimpleValue simpleValue = null;
/* 1561 */       simpleValue = (SimpleValue)get_store().find_attribute_user(FINAL$30);
/* 1562 */       if (simpleValue == null)
/*      */       {
/* 1564 */         simpleValue = (SimpleValue)get_store().add_attribute_user(FINAL$30);
/*      */       }
/* 1566 */       simpleValue.setObjectValue(paramObject);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void xsetFinal(DerivationSet paramDerivationSet) {
/* 1575 */     synchronized (monitor()) {
/*      */       
/* 1577 */       check_orphaned();
/* 1578 */       DerivationSet derivationSet = null;
/* 1579 */       derivationSet = (DerivationSet)get_store().find_attribute_user(FINAL$30);
/* 1580 */       if (derivationSet == null)
/*      */       {
/* 1582 */         derivationSet = (DerivationSet)get_store().add_attribute_user(FINAL$30);
/*      */       }
/* 1584 */       derivationSet.set((XmlObject)paramDerivationSet);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetFinal() {
/* 1593 */     synchronized (monitor()) {
/*      */       
/* 1595 */       check_orphaned();
/* 1596 */       get_store().remove_attribute(FINAL$30);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object getBlock() {
/* 1605 */     synchronized (monitor()) {
/*      */       
/* 1607 */       check_orphaned();
/* 1608 */       SimpleValue simpleValue = null;
/* 1609 */       simpleValue = (SimpleValue)get_store().find_attribute_user(BLOCK$32);
/* 1610 */       if (simpleValue == null)
/*      */       {
/* 1612 */         return null;
/*      */       }
/* 1614 */       return simpleValue.getObjectValue();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public BlockSet xgetBlock() {
/* 1623 */     synchronized (monitor()) {
/*      */       
/* 1625 */       check_orphaned();
/* 1626 */       BlockSet blockSet = null;
/* 1627 */       blockSet = (BlockSet)get_store().find_attribute_user(BLOCK$32);
/* 1628 */       return blockSet;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetBlock() {
/* 1637 */     synchronized (monitor()) {
/*      */       
/* 1639 */       check_orphaned();
/* 1640 */       return (get_store().find_attribute_user(BLOCK$32) != null);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBlock(Object paramObject) {
/* 1649 */     synchronized (monitor()) {
/*      */       
/* 1651 */       check_orphaned();
/* 1652 */       SimpleValue simpleValue = null;
/* 1653 */       simpleValue = (SimpleValue)get_store().find_attribute_user(BLOCK$32);
/* 1654 */       if (simpleValue == null)
/*      */       {
/* 1656 */         simpleValue = (SimpleValue)get_store().add_attribute_user(BLOCK$32);
/*      */       }
/* 1658 */       simpleValue.setObjectValue(paramObject);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void xsetBlock(BlockSet paramBlockSet) {
/* 1667 */     synchronized (monitor()) {
/*      */       
/* 1669 */       check_orphaned();
/* 1670 */       BlockSet blockSet = null;
/* 1671 */       blockSet = (BlockSet)get_store().find_attribute_user(BLOCK$32);
/* 1672 */       if (blockSet == null)
/*      */       {
/* 1674 */         blockSet = (BlockSet)get_store().add_attribute_user(BLOCK$32);
/*      */       }
/* 1676 */       blockSet.set((XmlObject)paramBlockSet);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetBlock() {
/* 1685 */     synchronized (monitor()) {
/*      */       
/* 1687 */       check_orphaned();
/* 1688 */       get_store().remove_attribute(BLOCK$32);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FormChoice.Enum getForm() {
/* 1697 */     synchronized (monitor()) {
/*      */       
/* 1699 */       check_orphaned();
/* 1700 */       SimpleValue simpleValue = null;
/* 1701 */       simpleValue = (SimpleValue)get_store().find_attribute_user(FORM$34);
/* 1702 */       if (simpleValue == null)
/*      */       {
/* 1704 */         return null;
/*      */       }
/* 1706 */       return (FormChoice.Enum)simpleValue.getEnumValue();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public FormChoice xgetForm() {
/* 1715 */     synchronized (monitor()) {
/*      */       
/* 1717 */       check_orphaned();
/* 1718 */       FormChoice formChoice = null;
/* 1719 */       formChoice = (FormChoice)get_store().find_attribute_user(FORM$34);
/* 1720 */       return formChoice;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isSetForm() {
/* 1729 */     synchronized (monitor()) {
/*      */       
/* 1731 */       check_orphaned();
/* 1732 */       return (get_store().find_attribute_user(FORM$34) != null);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setForm(FormChoice.Enum paramEnum) {
/* 1741 */     synchronized (monitor()) {
/*      */       
/* 1743 */       check_orphaned();
/* 1744 */       SimpleValue simpleValue = null;
/* 1745 */       simpleValue = (SimpleValue)get_store().find_attribute_user(FORM$34);
/* 1746 */       if (simpleValue == null)
/*      */       {
/* 1748 */         simpleValue = (SimpleValue)get_store().add_attribute_user(FORM$34);
/*      */       }
/* 1750 */       simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void xsetForm(FormChoice paramFormChoice) {
/* 1759 */     synchronized (monitor()) {
/*      */       
/* 1761 */       check_orphaned();
/* 1762 */       FormChoice formChoice = null;
/* 1763 */       formChoice = (FormChoice)get_store().find_attribute_user(FORM$34);
/* 1764 */       if (formChoice == null)
/*      */       {
/* 1766 */         formChoice = (FormChoice)get_store().add_attribute_user(FORM$34);
/*      */       }
/* 1768 */       formChoice.set((XmlObject)paramFormChoice);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unsetForm() {
/* 1777 */     synchronized (monitor()) {
/*      */       
/* 1779 */       check_orphaned();
/* 1780 */       get_store().remove_attribute(FORM$34);
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\ElementImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */