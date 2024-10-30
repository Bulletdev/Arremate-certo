/*     */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlQName;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class KeyrefDocumentImpl
/*     */   extends XmlComplexContentImpl
/*     */   implements KeyrefDocument
/*     */ {
/*     */   public KeyrefDocumentImpl(SchemaType paramSchemaType) {
/*  20 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  23 */   private static final b KEYREF$0 = new b("http://www.w3.org/2001/XMLSchema", "keyref");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public KeyrefDocument.Keyref getKeyref() {
/*  32 */     synchronized (monitor()) {
/*     */       
/*  34 */       check_orphaned();
/*  35 */       KeyrefDocument.Keyref keyref = null;
/*  36 */       keyref = (KeyrefDocument.Keyref)get_store().find_element_user(KEYREF$0, 0);
/*  37 */       if (keyref == null)
/*     */       {
/*  39 */         return null;
/*     */       }
/*  41 */       return keyref;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKeyref(KeyrefDocument.Keyref paramKeyref) {
/*  50 */     synchronized (monitor()) {
/*     */       
/*  52 */       check_orphaned();
/*  53 */       KeyrefDocument.Keyref keyref = null;
/*  54 */       keyref = (KeyrefDocument.Keyref)get_store().find_element_user(KEYREF$0, 0);
/*  55 */       if (keyref == null)
/*     */       {
/*  57 */         keyref = (KeyrefDocument.Keyref)get_store().add_element_user(KEYREF$0);
/*     */       }
/*  59 */       keyref.set((XmlObject)paramKeyref);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public KeyrefDocument.Keyref addNewKeyref() {
/*  68 */     synchronized (monitor()) {
/*     */       
/*  70 */       check_orphaned();
/*  71 */       KeyrefDocument.Keyref keyref = null;
/*  72 */       keyref = (KeyrefDocument.Keyref)get_store().add_element_user(KEYREF$0);
/*  73 */       return keyref;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class KeyrefImpl
/*     */     extends KeybaseImpl
/*     */     implements KeyrefDocument.Keyref
/*     */   {
/*     */     public KeyrefImpl(SchemaType param1SchemaType) {
/*  86 */       super(param1SchemaType);
/*     */     }
/*     */     
/*  89 */     private static final b REFER$0 = new b("", "refer");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public b getRefer() {
/*  98 */       synchronized (monitor()) {
/*     */         
/* 100 */         check_orphaned();
/* 101 */         SimpleValue simpleValue = null;
/* 102 */         simpleValue = (SimpleValue)get_store().find_attribute_user(REFER$0);
/* 103 */         if (simpleValue == null)
/*     */         {
/* 105 */           return null;
/*     */         }
/* 107 */         return simpleValue.getQNameValue();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlQName xgetRefer() {
/* 116 */       synchronized (monitor()) {
/*     */         
/* 118 */         check_orphaned();
/* 119 */         XmlQName xmlQName = null;
/* 120 */         xmlQName = (XmlQName)get_store().find_attribute_user(REFER$0);
/* 121 */         return xmlQName;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setRefer(b param1b) {
/* 130 */       synchronized (monitor()) {
/*     */         
/* 132 */         check_orphaned();
/* 133 */         SimpleValue simpleValue = null;
/* 134 */         simpleValue = (SimpleValue)get_store().find_attribute_user(REFER$0);
/* 135 */         if (simpleValue == null)
/*     */         {
/* 137 */           simpleValue = (SimpleValue)get_store().add_attribute_user(REFER$0);
/*     */         }
/* 139 */         simpleValue.setQNameValue(param1b);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void xsetRefer(XmlQName param1XmlQName) {
/* 148 */       synchronized (monitor()) {
/*     */         
/* 150 */         check_orphaned();
/* 151 */         XmlQName xmlQName = null;
/* 152 */         xmlQName = (XmlQName)get_store().find_attribute_user(REFER$0);
/* 153 */         if (xmlQName == null)
/*     */         {
/* 155 */           xmlQName = (XmlQName)get_store().add_attribute_user(REFER$0);
/*     */         }
/* 157 */         xmlQName.set((XmlObject)param1XmlQName);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\KeyrefDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */