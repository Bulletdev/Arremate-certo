/*     */ package org.apache.xmlbeans.impl.xb.ltgfmt.impl;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlToken;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.ltgfmt.Code;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CodeImpl
/*     */   extends XmlComplexContentImpl
/*     */   implements Code
/*     */ {
/*     */   public CodeImpl(SchemaType paramSchemaType) {
/*  19 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  22 */   private static final b ID$0 = new b("", "ID");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getID() {
/*  31 */     synchronized (monitor()) {
/*     */       
/*  33 */       check_orphaned();
/*  34 */       SimpleValue simpleValue = null;
/*  35 */       simpleValue = (SimpleValue)get_store().find_attribute_user(ID$0);
/*  36 */       if (simpleValue == null)
/*     */       {
/*  38 */         return null;
/*     */       }
/*  40 */       return simpleValue.getStringValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlToken xgetID() {
/*  49 */     synchronized (monitor()) {
/*     */       
/*  51 */       check_orphaned();
/*  52 */       XmlToken xmlToken = null;
/*  53 */       xmlToken = (XmlToken)get_store().find_attribute_user(ID$0);
/*  54 */       return xmlToken;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetID() {
/*  63 */     synchronized (monitor()) {
/*     */       
/*  65 */       check_orphaned();
/*  66 */       return (get_store().find_attribute_user(ID$0) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setID(String paramString) {
/*  75 */     synchronized (monitor()) {
/*     */       
/*  77 */       check_orphaned();
/*  78 */       SimpleValue simpleValue = null;
/*  79 */       simpleValue = (SimpleValue)get_store().find_attribute_user(ID$0);
/*  80 */       if (simpleValue == null)
/*     */       {
/*  82 */         simpleValue = (SimpleValue)get_store().add_attribute_user(ID$0);
/*     */       }
/*  84 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetID(XmlToken paramXmlToken) {
/*  93 */     synchronized (monitor()) {
/*     */       
/*  95 */       check_orphaned();
/*  96 */       XmlToken xmlToken = null;
/*  97 */       xmlToken = (XmlToken)get_store().find_attribute_user(ID$0);
/*  98 */       if (xmlToken == null)
/*     */       {
/* 100 */         xmlToken = (XmlToken)get_store().add_attribute_user(ID$0);
/*     */       }
/* 102 */       xmlToken.set((XmlObject)paramXmlToken);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetID() {
/* 111 */     synchronized (monitor()) {
/*     */       
/* 113 */       check_orphaned();
/* 114 */       get_store().remove_attribute(ID$0);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\ltgfmt\impl\CodeImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */