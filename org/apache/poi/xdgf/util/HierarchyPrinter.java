/*    */ package org.apache.poi.xdgf.util;
/*    */ 
/*    */ import java.awt.geom.AffineTransform;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.PrintStream;
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import org.apache.poi.xdgf.usermodel.XDGFPage;
/*    */ import org.apache.poi.xdgf.usermodel.XDGFShape;
/*    */ import org.apache.poi.xdgf.usermodel.XmlVisioDocument;
/*    */ import org.apache.poi.xdgf.usermodel.shape.ShapeVisitor;
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
/*    */ public class HierarchyPrinter
/*    */ {
/*    */   public static void printHierarchy(XDGFPage paramXDGFPage, File paramFile) throws FileNotFoundException, UnsupportedEncodingException {
/* 43 */     File file = new File(paramFile, "page" + paramXDGFPage.getPageNumber() + "-" + Util.sanitizeFilename(paramXDGFPage.getName()) + ".txt");
/*    */ 
/*    */     
/* 46 */     FileOutputStream fileOutputStream = new FileOutputStream(file);
/* 47 */     PrintStream printStream = new PrintStream(fileOutputStream, false, "utf-8");
/*    */     
/* 49 */     printHierarchy(paramXDGFPage, printStream);
/*    */     
/* 51 */     printStream.close();
/*    */   }
/*    */ 
/*    */   
/*    */   public static void printHierarchy(XDGFPage paramXDGFPage, final PrintStream os) {
/* 56 */     paramXDGFPage.getContent().visitShapes(new ShapeVisitor()
/*    */         {
/*    */           
/*    */           public void visit(XDGFShape param1XDGFShape, AffineTransform param1AffineTransform, int param1Int)
/*    */           {
/* 61 */             for (byte b = 0; b < param1Int; b++) {
/* 62 */               os.append("  ");
/*    */             }
/*    */             
/* 65 */             os.println(param1XDGFShape.toString() + " [" + param1XDGFShape.getShapeType() + ", " + param1XDGFShape.getSymbolName() + "] " + param1XDGFShape.getMasterShape() + " " + param1XDGFShape.getTextAsString().trim());
/*    */           }
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void printHierarchy(XmlVisioDocument paramXmlVisioDocument, String paramString) throws FileNotFoundException, UnsupportedEncodingException {
/* 76 */     File file = new File(paramString);
/*    */     
/* 78 */     for (XDGFPage xDGFPage : paramXmlVisioDocument.getPages()) {
/* 79 */       printHierarchy(xDGFPage, file);
/*    */     }
/*    */   }
/*    */   
/*    */   public static void main(String[] paramArrayOfString) throws Exception {
/* 84 */     if (paramArrayOfString.length != 2) {
/* 85 */       System.err.println("Usage: in.vsdx outdir");
/* 86 */       System.exit(1);
/*    */     } 
/*    */     
/* 89 */     String str1 = paramArrayOfString[0];
/* 90 */     String str2 = paramArrayOfString[1];
/*    */     
/* 92 */     XmlVisioDocument xmlVisioDocument = new XmlVisioDocument(new FileInputStream(str1));
/*    */     
/* 94 */     printHierarchy(xmlVisioDocument, str2);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xdg\\util\HierarchyPrinter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */