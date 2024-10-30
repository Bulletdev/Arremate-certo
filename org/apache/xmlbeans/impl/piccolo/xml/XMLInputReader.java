/*    */ package org.apache.xmlbeans.impl.piccolo.xml;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.Reader;
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
/*    */ public abstract class XMLInputReader
/*    */   extends Reader
/*    */ {
/* 36 */   private String xmlVersion = null;
/*    */   private boolean xmlStandaloneDeclared = false;
/*    */   private boolean xmlStandalone = false;
/* 39 */   private String xmlDeclaredEncoding = null;
/*    */   
/* 41 */   private XMLDeclParser parser = new XMLDeclParser();
/*    */   
/*    */   protected void resetInput() {
/* 44 */     this.xmlVersion = this.xmlDeclaredEncoding = null;
/* 45 */     this.xmlStandaloneDeclared = this.xmlStandalone = false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected int parseXMLDeclaration(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/* 55 */     this.parser.reset(paramArrayOfchar, paramInt1, paramInt2);
/* 56 */     if (this.parser.parse() == 1) {
/* 57 */       this.xmlVersion = this.parser.getXMLVersion();
/* 58 */       this.xmlStandalone = this.parser.isXMLStandalone();
/* 59 */       this.xmlStandaloneDeclared = this.parser.isXMLStandaloneDeclared();
/* 60 */       this.xmlDeclaredEncoding = this.parser.getXMLEncoding();
/* 61 */       return this.parser.getCharsRead();
/*    */     } 
/*    */     
/* 64 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getXMLVersion() {
/* 71 */     return this.xmlVersion;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isXMLStandalone() {
/* 79 */     return this.xmlStandalone;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isXMLStandaloneDeclared() {
/* 86 */     return this.xmlStandaloneDeclared;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getXMLDeclaredEncoding() {
/* 94 */     return this.xmlDeclaredEncoding;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\piccolo\xml\XMLInputReader.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */