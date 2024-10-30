/*    */ package org.apache.poi.poifs.dev;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
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
/*    */ 
/*    */ 
/*    */ public class POIFSViewer
/*    */ {
/*    */   public static void main(String[] paramArrayOfString) {
/* 44 */     if (paramArrayOfString.length == 0) {
/* 45 */       System.err.println("Must specify at least one file to view");
/* 46 */       System.exit(1);
/*    */     } 
/* 48 */     boolean bool = (paramArrayOfString.length > 1) ? true : false;
/*    */     
/* 50 */     for (byte b = 0; b < paramArrayOfString.length; b++)
/*    */     {
/* 52 */       viewFile(paramArrayOfString[b], bool);
/*    */     }
/*    */   }
/*    */   
/*    */   private static void viewFile(String paramString, boolean paramBoolean) {
/* 57 */     if (paramBoolean) {
/* 58 */       StringBuffer stringBuffer = new StringBuffer();
/*    */       
/* 60 */       stringBuffer.append(".");
/* 61 */       for (byte b = 0; b < paramString.length(); b++) {
/* 62 */         stringBuffer.append("-");
/*    */       }
/* 64 */       stringBuffer.append(".");
/* 65 */       System.out.println(stringBuffer);
/* 66 */       System.out.println("|" + paramString + "|");
/* 67 */       System.out.println(stringBuffer);
/*    */     } 
/*    */     try {
/* 70 */       NPOIFSFileSystem nPOIFSFileSystem = new NPOIFSFileSystem(new File(paramString));
/* 71 */       List<String> list = POIFSViewEngine.inspectViewable(nPOIFSFileSystem, true, 0, "  ");
/* 72 */       for (String str : list) {
/* 73 */         System.out.print(str);
/*    */       }
/* 75 */       nPOIFSFileSystem.close();
/* 76 */     } catch (IOException iOException) {
/* 77 */       System.out.println(iOException.getMessage());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\dev\POIFSViewer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */