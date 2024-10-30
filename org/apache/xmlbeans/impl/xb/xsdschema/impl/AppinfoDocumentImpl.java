/*     */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlAnyURI;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AppinfoDocumentImpl
/*     */   extends XmlComplexContentImpl
/*     */   implements AppinfoDocument
/*     */ {
/*     */   public AppinfoDocumentImpl(SchemaType paramSchemaType) {
/*  20 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  23 */   private static final b APPINFO$0 = new b("http://www.w3.org/2001/XMLSchema", "appinfo");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AppinfoDocument.Appinfo getAppinfo() {
/*  32 */     synchronized (monitor()) {
/*     */       
/*  34 */       check_orphaned();
/*  35 */       AppinfoDocument.Appinfo appinfo = null;
/*  36 */       appinfo = (AppinfoDocument.Appinfo)get_store().find_element_user(APPINFO$0, 0);
/*  37 */       if (appinfo == null)
/*     */       {
/*  39 */         return null;
/*     */       }
/*  41 */       return appinfo;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAppinfo(AppinfoDocument.Appinfo paramAppinfo) {
/*  50 */     synchronized (monitor()) {
/*     */       
/*  52 */       check_orphaned();
/*  53 */       AppinfoDocument.Appinfo appinfo = null;
/*  54 */       appinfo = (AppinfoDocument.Appinfo)get_store().find_element_user(APPINFO$0, 0);
/*  55 */       if (appinfo == null)
/*     */       {
/*  57 */         appinfo = (AppinfoDocument.Appinfo)get_store().add_element_user(APPINFO$0);
/*     */       }
/*  59 */       appinfo.set((XmlObject)paramAppinfo);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AppinfoDocument.Appinfo addNewAppinfo() {
/*  68 */     synchronized (monitor()) {
/*     */       
/*  70 */       check_orphaned();
/*  71 */       AppinfoDocument.Appinfo appinfo = null;
/*  72 */       appinfo = (AppinfoDocument.Appinfo)get_store().add_element_user(APPINFO$0);
/*  73 */       return appinfo;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class AppinfoImpl
/*     */     extends XmlComplexContentImpl
/*     */     implements AppinfoDocument.Appinfo
/*     */   {
/*     */     public AppinfoImpl(SchemaType param1SchemaType) {
/*  86 */       super(param1SchemaType);
/*     */     }
/*     */     
/*  89 */     private static final b SOURCE$0 = new b("", "source");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getSource() {
/*  98 */       synchronized (monitor()) {
/*     */         
/* 100 */         check_orphaned();
/* 101 */         SimpleValue simpleValue = null;
/* 102 */         simpleValue = (SimpleValue)get_store().find_attribute_user(SOURCE$0);
/* 103 */         if (simpleValue == null)
/*     */         {
/* 105 */           return null;
/*     */         }
/* 107 */         return simpleValue.getStringValue();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlAnyURI xgetSource() {
/* 116 */       synchronized (monitor()) {
/*     */         
/* 118 */         check_orphaned();
/* 119 */         XmlAnyURI xmlAnyURI = null;
/* 120 */         xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(SOURCE$0);
/* 121 */         return xmlAnyURI;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isSetSource() {
/* 130 */       synchronized (monitor()) {
/*     */         
/* 132 */         check_orphaned();
/* 133 */         return (get_store().find_attribute_user(SOURCE$0) != null);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setSource(String param1String) {
/* 142 */       synchronized (monitor()) {
/*     */         
/* 144 */         check_orphaned();
/* 145 */         SimpleValue simpleValue = null;
/* 146 */         simpleValue = (SimpleValue)get_store().find_attribute_user(SOURCE$0);
/* 147 */         if (simpleValue == null)
/*     */         {
/* 149 */           simpleValue = (SimpleValue)get_store().add_attribute_user(SOURCE$0);
/*     */         }
/* 151 */         simpleValue.setStringValue(param1String);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void xsetSource(XmlAnyURI param1XmlAnyURI) {
/* 160 */       synchronized (monitor()) {
/*     */         
/* 162 */         check_orphaned();
/* 163 */         XmlAnyURI xmlAnyURI = null;
/* 164 */         xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(SOURCE$0);
/* 165 */         if (xmlAnyURI == null)
/*     */         {
/* 167 */           xmlAnyURI = (XmlAnyURI)get_store().add_attribute_user(SOURCE$0);
/*     */         }
/* 169 */         xmlAnyURI.set((XmlObject)param1XmlAnyURI);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void unsetSource() {
/* 178 */       synchronized (monitor()) {
/*     */         
/* 180 */         check_orphaned();
/* 181 */         get_store().remove_attribute(SOURCE$0);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\AppinfoDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */