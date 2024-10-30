/*     */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlNCName;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.Keybase;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.SelectorDocument;
/*     */ 
/*     */ 
/*     */ public class KeybaseImpl
/*     */   extends AnnotatedImpl
/*     */   implements Keybase
/*     */ {
/*     */   public KeybaseImpl(SchemaType paramSchemaType) {
/*  19 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  22 */   private static final b SELECTOR$0 = new b("http://www.w3.org/2001/XMLSchema", "selector");
/*     */   
/*  24 */   private static final b FIELD$2 = new b("http://www.w3.org/2001/XMLSchema", "field");
/*     */   
/*  26 */   private static final b NAME$4 = new b("", "name");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SelectorDocument.Selector getSelector() {
/*  35 */     synchronized (monitor()) {
/*     */       
/*  37 */       check_orphaned();
/*  38 */       SelectorDocument.Selector selector = null;
/*  39 */       selector = (SelectorDocument.Selector)get_store().find_element_user(SELECTOR$0, 0);
/*  40 */       if (selector == null)
/*     */       {
/*  42 */         return null;
/*     */       }
/*  44 */       return selector;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSelector(SelectorDocument.Selector paramSelector) {
/*  53 */     synchronized (monitor()) {
/*     */       
/*  55 */       check_orphaned();
/*  56 */       SelectorDocument.Selector selector = null;
/*  57 */       selector = (SelectorDocument.Selector)get_store().find_element_user(SELECTOR$0, 0);
/*  58 */       if (selector == null)
/*     */       {
/*  60 */         selector = (SelectorDocument.Selector)get_store().add_element_user(SELECTOR$0);
/*     */       }
/*  62 */       selector.set((XmlObject)paramSelector);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SelectorDocument.Selector addNewSelector() {
/*  71 */     synchronized (monitor()) {
/*     */       
/*  73 */       check_orphaned();
/*  74 */       SelectorDocument.Selector selector = null;
/*  75 */       selector = (SelectorDocument.Selector)get_store().add_element_user(SELECTOR$0);
/*  76 */       return selector;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FieldDocument.Field[] getFieldArray() {
/*  85 */     synchronized (monitor()) {
/*     */       
/*  87 */       check_orphaned();
/*  88 */       ArrayList arrayList = new ArrayList();
/*  89 */       get_store().find_all_element_users(FIELD$2, arrayList);
/*  90 */       FieldDocument.Field[] arrayOfField = new FieldDocument.Field[arrayList.size()];
/*  91 */       arrayList.toArray((Object[])arrayOfField);
/*  92 */       return arrayOfField;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FieldDocument.Field getFieldArray(int paramInt) {
/* 101 */     synchronized (monitor()) {
/*     */       
/* 103 */       check_orphaned();
/* 104 */       FieldDocument.Field field = null;
/* 105 */       field = (FieldDocument.Field)get_store().find_element_user(FIELD$2, paramInt);
/* 106 */       if (field == null)
/*     */       {
/* 108 */         throw new IndexOutOfBoundsException();
/*     */       }
/* 110 */       return field;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int sizeOfFieldArray() {
/* 119 */     synchronized (monitor()) {
/*     */       
/* 121 */       check_orphaned();
/* 122 */       return get_store().count_elements(FIELD$2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFieldArray(FieldDocument.Field[] paramArrayOfField) {
/* 131 */     synchronized (monitor()) {
/*     */       
/* 133 */       check_orphaned();
/* 134 */       arraySetterHelper((XmlObject[])paramArrayOfField, FIELD$2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFieldArray(int paramInt, FieldDocument.Field paramField) {
/* 143 */     synchronized (monitor()) {
/*     */       
/* 145 */       check_orphaned();
/* 146 */       FieldDocument.Field field = null;
/* 147 */       field = (FieldDocument.Field)get_store().find_element_user(FIELD$2, paramInt);
/* 148 */       if (field == null)
/*     */       {
/* 150 */         throw new IndexOutOfBoundsException();
/*     */       }
/* 152 */       field.set((XmlObject)paramField);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FieldDocument.Field insertNewField(int paramInt) {
/* 161 */     synchronized (monitor()) {
/*     */       
/* 163 */       check_orphaned();
/* 164 */       FieldDocument.Field field = null;
/* 165 */       field = (FieldDocument.Field)get_store().insert_element_user(FIELD$2, paramInt);
/* 166 */       return field;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FieldDocument.Field addNewField() {
/* 175 */     synchronized (monitor()) {
/*     */       
/* 177 */       check_orphaned();
/* 178 */       FieldDocument.Field field = null;
/* 179 */       field = (FieldDocument.Field)get_store().add_element_user(FIELD$2);
/* 180 */       return field;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeField(int paramInt) {
/* 189 */     synchronized (monitor()) {
/*     */       
/* 191 */       check_orphaned();
/* 192 */       get_store().remove_element(FIELD$2, paramInt);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 201 */     synchronized (monitor()) {
/*     */       
/* 203 */       check_orphaned();
/* 204 */       SimpleValue simpleValue = null;
/* 205 */       simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$4);
/* 206 */       if (simpleValue == null)
/*     */       {
/* 208 */         return null;
/*     */       }
/* 210 */       return simpleValue.getStringValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlNCName xgetName() {
/* 219 */     synchronized (monitor()) {
/*     */       
/* 221 */       check_orphaned();
/* 222 */       XmlNCName xmlNCName = null;
/* 223 */       xmlNCName = (XmlNCName)get_store().find_attribute_user(NAME$4);
/* 224 */       return xmlNCName;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String paramString) {
/* 233 */     synchronized (monitor()) {
/*     */       
/* 235 */       check_orphaned();
/* 236 */       SimpleValue simpleValue = null;
/* 237 */       simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$4);
/* 238 */       if (simpleValue == null)
/*     */       {
/* 240 */         simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$4);
/*     */       }
/* 242 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetName(XmlNCName paramXmlNCName) {
/* 251 */     synchronized (monitor()) {
/*     */       
/* 253 */       check_orphaned();
/* 254 */       XmlNCName xmlNCName = null;
/* 255 */       xmlNCName = (XmlNCName)get_store().find_attribute_user(NAME$4);
/* 256 */       if (xmlNCName == null)
/*     */       {
/* 258 */         xmlNCName = (XmlNCName)get_store().add_attribute_user(NAME$4);
/*     */       }
/* 260 */       xmlNCName.set((XmlObject)paramXmlNCName);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\KeybaseImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */