/*    */ package org.apache.poi.xssf.usermodel.helpers;
/*    */ 
/*    */ import org.apache.poi.poifs.crypt.HashAlgorithm;
/*    */ import org.apache.poi.util.Internal;
/*    */ import org.apache.poi.util.Removal;
/*    */ import org.apache.xmlbeans.XmlObject;
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
/*    */ @Internal(since = "3.15 beta 3")
/*    */ @Deprecated
/*    */ @Removal(version = "3.17")
/*    */ public class XSSFPaswordHelper
/*    */ {
/*    */   public static void setPassword(XmlObject paramXmlObject, String paramString1, HashAlgorithm paramHashAlgorithm, String paramString2) {
/* 43 */     XSSFPasswordHelper.setPassword(paramXmlObject, paramString1, paramHashAlgorithm, paramString2);
/*    */   }
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
/*    */   public static boolean validatePassword(XmlObject paramXmlObject, String paramString1, String paramString2) {
/* 58 */     return XSSFPasswordHelper.validatePassword(paramXmlObject, paramString1, paramString2);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\helpers\XSSFPaswordHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */