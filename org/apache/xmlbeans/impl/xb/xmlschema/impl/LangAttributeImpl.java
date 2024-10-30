/*     */ package org.apache.xmlbeans.impl.xb.xmlschema.impl;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlLanguage;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.xmlschema.LangAttribute;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LangAttributeImpl
/*     */   extends XmlComplexContentImpl
/*     */   implements LangAttribute
/*     */ {
/*     */   public LangAttributeImpl(SchemaType paramSchemaType) {
/*  20 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  23 */   private static final b LANG$0 = new b("http://www.w3.org/XML/1998/namespace", "lang");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLang() {
/*  32 */     synchronized (monitor()) {
/*     */       
/*  34 */       check_orphaned();
/*  35 */       SimpleValue simpleValue = null;
/*  36 */       simpleValue = (SimpleValue)get_store().find_attribute_user(LANG$0);
/*  37 */       if (simpleValue == null)
/*     */       {
/*  39 */         return null;
/*     */       }
/*  41 */       return simpleValue.getStringValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlLanguage xgetLang() {
/*  50 */     synchronized (monitor()) {
/*     */       
/*  52 */       check_orphaned();
/*  53 */       XmlLanguage xmlLanguage = null;
/*  54 */       xmlLanguage = (XmlLanguage)get_store().find_attribute_user(LANG$0);
/*  55 */       return xmlLanguage;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetLang() {
/*  64 */     synchronized (monitor()) {
/*     */       
/*  66 */       check_orphaned();
/*  67 */       return (get_store().find_attribute_user(LANG$0) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLang(String paramString) {
/*  76 */     synchronized (monitor()) {
/*     */       
/*  78 */       check_orphaned();
/*  79 */       SimpleValue simpleValue = null;
/*  80 */       simpleValue = (SimpleValue)get_store().find_attribute_user(LANG$0);
/*  81 */       if (simpleValue == null)
/*     */       {
/*  83 */         simpleValue = (SimpleValue)get_store().add_attribute_user(LANG$0);
/*     */       }
/*  85 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetLang(XmlLanguage paramXmlLanguage) {
/*  94 */     synchronized (monitor()) {
/*     */       
/*  96 */       check_orphaned();
/*  97 */       XmlLanguage xmlLanguage = null;
/*  98 */       xmlLanguage = (XmlLanguage)get_store().find_attribute_user(LANG$0);
/*  99 */       if (xmlLanguage == null)
/*     */       {
/* 101 */         xmlLanguage = (XmlLanguage)get_store().add_attribute_user(LANG$0);
/*     */       }
/* 103 */       xmlLanguage.set((XmlObject)paramXmlLanguage);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetLang() {
/* 112 */     synchronized (monitor()) {
/*     */       
/* 114 */       check_orphaned();
/* 115 */       get_store().remove_attribute(LANG$0);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xmlschema\impl\LangAttributeImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */