/*     */ package org.apache.xmlbeans.impl.xb.substwsdl.impl;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlAnyURI;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.substwsdl.TImport;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TImportImpl
/*     */   extends XmlComplexContentImpl
/*     */   implements TImport
/*     */ {
/*     */   public TImportImpl(SchemaType paramSchemaType) {
/*  19 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  22 */   private static final b NAMESPACE$0 = new b("", "namespace");
/*     */   
/*  24 */   private static final b LOCATION$2 = new b("", "location");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNamespace() {
/*  33 */     synchronized (monitor()) {
/*     */       
/*  35 */       check_orphaned();
/*  36 */       SimpleValue simpleValue = null;
/*  37 */       simpleValue = (SimpleValue)get_store().find_attribute_user(NAMESPACE$0);
/*  38 */       if (simpleValue == null)
/*     */       {
/*  40 */         return null;
/*     */       }
/*  42 */       return simpleValue.getStringValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlAnyURI xgetNamespace() {
/*  51 */     synchronized (monitor()) {
/*     */       
/*  53 */       check_orphaned();
/*  54 */       XmlAnyURI xmlAnyURI = null;
/*  55 */       xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(NAMESPACE$0);
/*  56 */       return xmlAnyURI;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNamespace(String paramString) {
/*  65 */     synchronized (monitor()) {
/*     */       
/*  67 */       check_orphaned();
/*  68 */       SimpleValue simpleValue = null;
/*  69 */       simpleValue = (SimpleValue)get_store().find_attribute_user(NAMESPACE$0);
/*  70 */       if (simpleValue == null)
/*     */       {
/*  72 */         simpleValue = (SimpleValue)get_store().add_attribute_user(NAMESPACE$0);
/*     */       }
/*  74 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetNamespace(XmlAnyURI paramXmlAnyURI) {
/*  83 */     synchronized (monitor()) {
/*     */       
/*  85 */       check_orphaned();
/*  86 */       XmlAnyURI xmlAnyURI = null;
/*  87 */       xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(NAMESPACE$0);
/*  88 */       if (xmlAnyURI == null)
/*     */       {
/*  90 */         xmlAnyURI = (XmlAnyURI)get_store().add_attribute_user(NAMESPACE$0);
/*     */       }
/*  92 */       xmlAnyURI.set((XmlObject)paramXmlAnyURI);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLocation() {
/* 101 */     synchronized (monitor()) {
/*     */       
/* 103 */       check_orphaned();
/* 104 */       SimpleValue simpleValue = null;
/* 105 */       simpleValue = (SimpleValue)get_store().find_attribute_user(LOCATION$2);
/* 106 */       if (simpleValue == null)
/*     */       {
/* 108 */         return null;
/*     */       }
/* 110 */       return simpleValue.getStringValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlAnyURI xgetLocation() {
/* 119 */     synchronized (monitor()) {
/*     */       
/* 121 */       check_orphaned();
/* 122 */       XmlAnyURI xmlAnyURI = null;
/* 123 */       xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(LOCATION$2);
/* 124 */       return xmlAnyURI;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLocation(String paramString) {
/* 133 */     synchronized (monitor()) {
/*     */       
/* 135 */       check_orphaned();
/* 136 */       SimpleValue simpleValue = null;
/* 137 */       simpleValue = (SimpleValue)get_store().find_attribute_user(LOCATION$2);
/* 138 */       if (simpleValue == null)
/*     */       {
/* 140 */         simpleValue = (SimpleValue)get_store().add_attribute_user(LOCATION$2);
/*     */       }
/* 142 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetLocation(XmlAnyURI paramXmlAnyURI) {
/* 151 */     synchronized (monitor()) {
/*     */       
/* 153 */       check_orphaned();
/* 154 */       XmlAnyURI xmlAnyURI = null;
/* 155 */       xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(LOCATION$2);
/* 156 */       if (xmlAnyURI == null)
/*     */       {
/* 158 */         xmlAnyURI = (XmlAnyURI)get_store().add_attribute_user(LOCATION$2);
/*     */       }
/* 160 */       xmlAnyURI.set((XmlObject)paramXmlAnyURI);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\substwsdl\impl\TImportImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */