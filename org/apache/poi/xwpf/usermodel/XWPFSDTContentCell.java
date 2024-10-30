/*     */ package org.apache.poi.xwpf.usermodel;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtContentCell;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XWPFSDTContentCell
/*     */   implements ISDTContent
/*     */ {
/*  43 */   private String text = "";
/*     */ 
/*     */ 
/*     */   
/*     */   public XWPFSDTContentCell(CTSdtContentCell paramCTSdtContentCell, XWPFTableRow paramXWPFTableRow, IBody paramIBody) {
/*  48 */     StringBuilder stringBuilder = new StringBuilder();
/*  49 */     XmlCursor xmlCursor = paramCTSdtContentCell.newCursor();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  56 */     byte b1 = 0;
/*     */     
/*  58 */     byte b2 = 0;
/*  59 */     byte b3 = 1;
/*     */     
/*  61 */     while (xmlCursor.hasNextToken() && b3) {
/*  62 */       XmlCursor.TokenType tokenType = xmlCursor.toNextToken();
/*  63 */       if (tokenType.isText()) {
/*  64 */         stringBuilder.append(xmlCursor.getTextValue());
/*  65 */       } else if (isStartToken(xmlCursor, "tr")) {
/*  66 */         b1 = 0;
/*  67 */         b2 = 0;
/*  68 */       } else if (isStartToken(xmlCursor, "tc")) {
/*  69 */         if (b1++ > 0) {
/*  70 */           stringBuilder.append("\t");
/*     */         }
/*  72 */         b2 = 0;
/*  73 */       } else if (isStartToken(xmlCursor, "p") || isStartToken(xmlCursor, "tbl") || isStartToken(xmlCursor, "sdt")) {
/*     */ 
/*     */         
/*  76 */         if (b2) {
/*  77 */           stringBuilder.append("\n");
/*     */         }
/*  79 */         b2++;
/*     */       } 
/*  81 */       if (xmlCursor.isStart()) {
/*  82 */         b3++; continue;
/*  83 */       }  if (xmlCursor.isEnd()) {
/*  84 */         b3--;
/*     */       }
/*     */     } 
/*  87 */     this.text = stringBuilder.toString();
/*  88 */     xmlCursor.dispose();
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isStartToken(XmlCursor paramXmlCursor, String paramString) {
/*  93 */     if (!paramXmlCursor.isStart()) {
/*  94 */       return false;
/*     */     }
/*  96 */     b b = paramXmlCursor.getName();
/*  97 */     if (b != null && b.dT() != null && b.dT().equals(paramString))
/*     */     {
/*  99 */       return true;
/*     */     }
/* 101 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getText() {
/* 106 */     return this.text;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 110 */     return getText();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\XWPFSDTContentCell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */