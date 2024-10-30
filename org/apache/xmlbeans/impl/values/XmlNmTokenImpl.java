/*    */ package org.apache.xmlbeans.impl.values;
/*    */ 
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlNMTOKEN;
/*    */ import org.apache.xmlbeans.impl.common.ValidationContext;
/*    */ import org.apache.xmlbeans.impl.common.XMLChar;
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
/*    */ 
/*    */ public class XmlNmTokenImpl
/*    */   extends JavaStringHolderEx
/*    */   implements XmlNMTOKEN
/*    */ {
/*    */   public XmlNmTokenImpl() {
/* 28 */     super(XmlNMTOKEN.type, false);
/*    */   } public XmlNmTokenImpl(SchemaType paramSchemaType, boolean paramBoolean) {
/* 30 */     super(paramSchemaType, paramBoolean);
/*    */   }
/*    */   
/*    */   public static void validateLexical(String paramString, ValidationContext paramValidationContext) {
/* 34 */     if (!XMLChar.isValidNmtoken(paramString)) {
/*    */       
/* 36 */       paramValidationContext.invalid("NMTOKEN", new Object[] { paramString });
/*    */       return;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\XmlNmTokenImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */