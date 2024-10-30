/*    */ package org.apache.poi.xslf.usermodel;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*    */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*    */ import org.apache.poi.openxml4j.opc.PackageAccess;
/*    */ import org.apache.poi.sl.usermodel.SlideShow;
/*    */ import org.apache.poi.sl.usermodel.SlideShowFactory;
/*    */ import org.apache.poi.util.Internal;
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
/*    */ 
/*    */ 
/*    */ @Internal
/*    */ public class XSLFSlideShowFactory
/*    */   extends SlideShowFactory
/*    */ {
/*    */   public static SlideShow<?, ?> createSlideShow(OPCPackage paramOPCPackage) throws IOException {
/*    */     try {
/* 50 */       return new XMLSlideShow(paramOPCPackage);
/* 51 */     } catch (IllegalArgumentException illegalArgumentException) {
/*    */       
/* 53 */       paramOPCPackage.revert();
/*    */ 
/*    */ 
/*    */       
/* 57 */       throw illegalArgumentException;
/*    */     } 
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
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static SlideShow<?, ?> createSlideShow(File paramFile, boolean paramBoolean) throws IOException, InvalidFormatException {
/* 77 */     OPCPackage oPCPackage = OPCPackage.open(paramFile, paramBoolean ? PackageAccess.READ : PackageAccess.READ_WRITE);
/* 78 */     return createSlideShow(oPCPackage);
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
/*    */ 
/*    */ 
/*    */   
/*    */   public static SlideShow<?, ?> createSlideShow(InputStream paramInputStream) throws IOException, InvalidFormatException {
/* 96 */     OPCPackage oPCPackage = OPCPackage.open(paramInputStream);
/* 97 */     return createSlideShow(oPCPackage);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xsl\\usermodel\XSLFSlideShowFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */