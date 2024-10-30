/*    */ package org.apache.xmlbeans.impl.values;
/*    */ 
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlToken;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class XmlTokenImpl
/*    */   extends JavaStringHolderEx
/*    */   implements XmlToken
/*    */ {
/*    */   public XmlTokenImpl() {
/* 25 */     super(XmlToken.type, false);
/*    */   } public XmlTokenImpl(SchemaType paramSchemaType, boolean paramBoolean) {
/* 27 */     super(paramSchemaType, paramBoolean);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\XmlTokenImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */