/*     */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlQName;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupRef;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AttributeGroupRefImpl
/*     */   extends AttributeGroupImpl
/*     */   implements AttributeGroupRef
/*     */ {
/*     */   public AttributeGroupRefImpl(SchemaType paramSchemaType) {
/*  19 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  22 */   private static final b REF$0 = new b("", "ref");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b getRef() {
/*  31 */     synchronized (monitor()) {
/*     */       
/*  33 */       check_orphaned();
/*  34 */       SimpleValue simpleValue = null;
/*  35 */       simpleValue = (SimpleValue)get_store().find_attribute_user(REF$0);
/*  36 */       if (simpleValue == null)
/*     */       {
/*  38 */         return null;
/*     */       }
/*  40 */       return simpleValue.getQNameValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlQName xgetRef() {
/*  49 */     synchronized (monitor()) {
/*     */       
/*  51 */       check_orphaned();
/*  52 */       XmlQName xmlQName = null;
/*  53 */       xmlQName = (XmlQName)get_store().find_attribute_user(REF$0);
/*  54 */       return xmlQName;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetRef() {
/*  63 */     synchronized (monitor()) {
/*     */       
/*  65 */       check_orphaned();
/*  66 */       return (get_store().find_attribute_user(REF$0) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRef(b paramb) {
/*  75 */     synchronized (monitor()) {
/*     */       
/*  77 */       check_orphaned();
/*  78 */       SimpleValue simpleValue = null;
/*  79 */       simpleValue = (SimpleValue)get_store().find_attribute_user(REF$0);
/*  80 */       if (simpleValue == null)
/*     */       {
/*  82 */         simpleValue = (SimpleValue)get_store().add_attribute_user(REF$0);
/*     */       }
/*  84 */       simpleValue.setQNameValue(paramb);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetRef(XmlQName paramXmlQName) {
/*  93 */     synchronized (monitor()) {
/*     */       
/*  95 */       check_orphaned();
/*  96 */       XmlQName xmlQName = null;
/*  97 */       xmlQName = (XmlQName)get_store().find_attribute_user(REF$0);
/*  98 */       if (xmlQName == null)
/*     */       {
/* 100 */         xmlQName = (XmlQName)get_store().add_attribute_user(REF$0);
/*     */       }
/* 102 */       xmlQName.set((XmlObject)paramXmlQName);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetRef() {
/* 111 */     synchronized (monitor()) {
/*     */       
/* 113 */       check_orphaned();
/* 114 */       get_store().remove_attribute(REF$0);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\AttributeGroupRefImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */