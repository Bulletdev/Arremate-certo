/*     */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlAnyURI;
/*     */ import org.apache.xmlbeans.XmlLanguage;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DocumentationDocumentImpl
/*     */   extends XmlComplexContentImpl
/*     */   implements DocumentationDocument
/*     */ {
/*     */   public DocumentationDocumentImpl(SchemaType paramSchemaType) {
/*  20 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  23 */   private static final b DOCUMENTATION$0 = new b("http://www.w3.org/2001/XMLSchema", "documentation");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DocumentationDocument.Documentation getDocumentation() {
/*  32 */     synchronized (monitor()) {
/*     */       
/*  34 */       check_orphaned();
/*  35 */       DocumentationDocument.Documentation documentation = null;
/*  36 */       documentation = (DocumentationDocument.Documentation)get_store().find_element_user(DOCUMENTATION$0, 0);
/*  37 */       if (documentation == null)
/*     */       {
/*  39 */         return null;
/*     */       }
/*  41 */       return documentation;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentation(DocumentationDocument.Documentation paramDocumentation) {
/*  50 */     synchronized (monitor()) {
/*     */       
/*  52 */       check_orphaned();
/*  53 */       DocumentationDocument.Documentation documentation = null;
/*  54 */       documentation = (DocumentationDocument.Documentation)get_store().find_element_user(DOCUMENTATION$0, 0);
/*  55 */       if (documentation == null)
/*     */       {
/*  57 */         documentation = (DocumentationDocument.Documentation)get_store().add_element_user(DOCUMENTATION$0);
/*     */       }
/*  59 */       documentation.set((XmlObject)paramDocumentation);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DocumentationDocument.Documentation addNewDocumentation() {
/*  68 */     synchronized (monitor()) {
/*     */       
/*  70 */       check_orphaned();
/*  71 */       DocumentationDocument.Documentation documentation = null;
/*  72 */       documentation = (DocumentationDocument.Documentation)get_store().add_element_user(DOCUMENTATION$0);
/*  73 */       return documentation;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class DocumentationImpl
/*     */     extends XmlComplexContentImpl
/*     */     implements DocumentationDocument.Documentation
/*     */   {
/*     */     public DocumentationImpl(SchemaType param1SchemaType) {
/*  86 */       super(param1SchemaType);
/*     */     }
/*     */     
/*  89 */     private static final b SOURCE$0 = new b("", "source");
/*     */     
/*  91 */     private static final b LANG$2 = new b("http://www.w3.org/XML/1998/namespace", "lang");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getSource() {
/* 100 */       synchronized (monitor()) {
/*     */         
/* 102 */         check_orphaned();
/* 103 */         SimpleValue simpleValue = null;
/* 104 */         simpleValue = (SimpleValue)get_store().find_attribute_user(SOURCE$0);
/* 105 */         if (simpleValue == null)
/*     */         {
/* 107 */           return null;
/*     */         }
/* 109 */         return simpleValue.getStringValue();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlAnyURI xgetSource() {
/* 118 */       synchronized (monitor()) {
/*     */         
/* 120 */         check_orphaned();
/* 121 */         XmlAnyURI xmlAnyURI = null;
/* 122 */         xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(SOURCE$0);
/* 123 */         return xmlAnyURI;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isSetSource() {
/* 132 */       synchronized (monitor()) {
/*     */         
/* 134 */         check_orphaned();
/* 135 */         return (get_store().find_attribute_user(SOURCE$0) != null);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setSource(String param1String) {
/* 144 */       synchronized (monitor()) {
/*     */         
/* 146 */         check_orphaned();
/* 147 */         SimpleValue simpleValue = null;
/* 148 */         simpleValue = (SimpleValue)get_store().find_attribute_user(SOURCE$0);
/* 149 */         if (simpleValue == null)
/*     */         {
/* 151 */           simpleValue = (SimpleValue)get_store().add_attribute_user(SOURCE$0);
/*     */         }
/* 153 */         simpleValue.setStringValue(param1String);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void xsetSource(XmlAnyURI param1XmlAnyURI) {
/* 162 */       synchronized (monitor()) {
/*     */         
/* 164 */         check_orphaned();
/* 165 */         XmlAnyURI xmlAnyURI = null;
/* 166 */         xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(SOURCE$0);
/* 167 */         if (xmlAnyURI == null)
/*     */         {
/* 169 */           xmlAnyURI = (XmlAnyURI)get_store().add_attribute_user(SOURCE$0);
/*     */         }
/* 171 */         xmlAnyURI.set((XmlObject)param1XmlAnyURI);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void unsetSource() {
/* 180 */       synchronized (monitor()) {
/*     */         
/* 182 */         check_orphaned();
/* 183 */         get_store().remove_attribute(SOURCE$0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getLang() {
/* 192 */       synchronized (monitor()) {
/*     */         
/* 194 */         check_orphaned();
/* 195 */         SimpleValue simpleValue = null;
/* 196 */         simpleValue = (SimpleValue)get_store().find_attribute_user(LANG$2);
/* 197 */         if (simpleValue == null)
/*     */         {
/* 199 */           return null;
/*     */         }
/* 201 */         return simpleValue.getStringValue();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlLanguage xgetLang() {
/* 210 */       synchronized (monitor()) {
/*     */         
/* 212 */         check_orphaned();
/* 213 */         XmlLanguage xmlLanguage = null;
/* 214 */         xmlLanguage = (XmlLanguage)get_store().find_attribute_user(LANG$2);
/* 215 */         return xmlLanguage;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isSetLang() {
/* 224 */       synchronized (monitor()) {
/*     */         
/* 226 */         check_orphaned();
/* 227 */         return (get_store().find_attribute_user(LANG$2) != null);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setLang(String param1String) {
/* 236 */       synchronized (monitor()) {
/*     */         
/* 238 */         check_orphaned();
/* 239 */         SimpleValue simpleValue = null;
/* 240 */         simpleValue = (SimpleValue)get_store().find_attribute_user(LANG$2);
/* 241 */         if (simpleValue == null)
/*     */         {
/* 243 */           simpleValue = (SimpleValue)get_store().add_attribute_user(LANG$2);
/*     */         }
/* 245 */         simpleValue.setStringValue(param1String);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void xsetLang(XmlLanguage param1XmlLanguage) {
/* 254 */       synchronized (monitor()) {
/*     */         
/* 256 */         check_orphaned();
/* 257 */         XmlLanguage xmlLanguage = null;
/* 258 */         xmlLanguage = (XmlLanguage)get_store().find_attribute_user(LANG$2);
/* 259 */         if (xmlLanguage == null)
/*     */         {
/* 261 */           xmlLanguage = (XmlLanguage)get_store().add_attribute_user(LANG$2);
/*     */         }
/* 263 */         xmlLanguage.set((XmlObject)param1XmlLanguage);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void unsetLang() {
/* 272 */       synchronized (monitor()) {
/*     */         
/* 274 */         check_orphaned();
/* 275 */         get_store().remove_attribute(LANG$2);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\DocumentationDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */