/*    */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*    */ 
/*    */ import javax.xml.namespace.b;
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlObject;
/*    */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.KeyDocument;
/*    */ import org.apache.xmlbeans.impl.xb.xsdschema.Keybase;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class KeyDocumentImpl
/*    */   extends XmlComplexContentImpl
/*    */   implements KeyDocument
/*    */ {
/*    */   public KeyDocumentImpl(SchemaType paramSchemaType) {
/* 20 */     super(paramSchemaType);
/*    */   }
/*    */   
/* 23 */   private static final b KEY$0 = new b("http://www.w3.org/2001/XMLSchema", "key");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Keybase getKey() {
/* 32 */     synchronized (monitor()) {
/*    */       
/* 34 */       check_orphaned();
/* 35 */       Keybase keybase = null;
/* 36 */       keybase = (Keybase)get_store().find_element_user(KEY$0, 0);
/* 37 */       if (keybase == null)
/*    */       {
/* 39 */         return null;
/*    */       }
/* 41 */       return keybase;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setKey(Keybase paramKeybase) {
/* 50 */     synchronized (monitor()) {
/*    */       
/* 52 */       check_orphaned();
/* 53 */       Keybase keybase = null;
/* 54 */       keybase = (Keybase)get_store().find_element_user(KEY$0, 0);
/* 55 */       if (keybase == null)
/*    */       {
/* 57 */         keybase = (Keybase)get_store().add_element_user(KEY$0);
/*    */       }
/* 59 */       keybase.set((XmlObject)paramKeybase);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Keybase addNewKey() {
/* 68 */     synchronized (monitor()) {
/*    */       
/* 70 */       check_orphaned();
/* 71 */       Keybase keybase = null;
/* 72 */       keybase = (Keybase)get_store().add_element_user(KEY$0);
/* 73 */       return keybase;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\KeyDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */