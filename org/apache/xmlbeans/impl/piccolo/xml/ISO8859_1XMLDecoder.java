/*     */ package org.apache.xmlbeans.impl.piccolo.xml;
/*     */ 
/*     */ import java.io.CharConversionException;
/*     */ import org.apache.xmlbeans.impl.piccolo.io.CharsetDecoder;
/*     */ import org.apache.xmlbeans.impl.piccolo.io.IllegalCharException;
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
/*     */ public final class ISO8859_1XMLDecoder
/*     */   implements XMLDecoder
/*     */ {
/*     */   private boolean sawCR = false;
/*     */   
/*     */   public CharsetDecoder newCharsetDecoder() {
/*  38 */     return newXMLDecoder(); } public XMLDecoder newXMLDecoder() {
/*  39 */     return new ISO8859_1XMLDecoder();
/*     */   }
/*     */   public int minBytesPerChar() {
/*  42 */     return 1;
/*     */   }
/*     */   
/*     */   public int maxBytesPerChar() {
/*  46 */     return 1;
/*     */   }
/*     */   public void reset() {
/*  49 */     this.sawCR = false;
/*     */   }
/*     */   
/*     */   public void decode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, char[] paramArrayOfchar, int paramInt3, int paramInt4, int[] paramArrayOfint) throws CharConversionException {
/*  53 */     internalDecode(paramArrayOfbyte, paramInt1, paramInt2, paramArrayOfchar, paramInt3, paramInt4, paramArrayOfint, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void decodeXMLDecl(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, char[] paramArrayOfchar, int paramInt3, int paramInt4, int[] paramArrayOfint) throws CharConversionException {
/*  59 */     internalDecode(paramArrayOfbyte, paramInt1, paramInt2, paramArrayOfchar, paramInt3, paramInt4, paramArrayOfint, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void internalDecode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, char[] paramArrayOfchar, int paramInt3, int paramInt4, int[] paramArrayOfint, boolean paramBoolean) throws CharConversionException {
/*     */     byte b1;
/*     */     byte b2;
/*  70 */     for (b1 = b2 = 0; b1 < paramInt2 && b2 < paramInt4; b1++) {
/*  71 */       char c = (char)(0xFF & paramArrayOfbyte[paramInt1 + b1]);
/*  72 */       if (c >= ' ') {
/*  73 */         this.sawCR = false;
/*  74 */         paramArrayOfchar[paramInt3 + b2++] = c;
/*     */       } else {
/*     */         
/*  77 */         switch (c) {
/*     */           case '\n':
/*  79 */             if (this.sawCR) {
/*  80 */               this.sawCR = false;
/*     */               break;
/*     */             } 
/*  83 */             paramArrayOfchar[paramInt3 + b2++] = '\n';
/*     */             break;
/*     */           
/*     */           case '\r':
/*  87 */             this.sawCR = true;
/*  88 */             paramArrayOfchar[paramInt3 + b2++] = '\n';
/*     */             break;
/*     */           
/*     */           case '\t':
/*  92 */             paramArrayOfchar[paramInt3 + b2++] = '\t';
/*     */             break;
/*     */           
/*     */           default:
/*  96 */             if (paramBoolean) {
/*     */               break;
/*     */             }
/*  99 */             throw new IllegalCharException("Illegal XML character: 0x" + Integer.toHexString(c));
/*     */         } 
/*     */ 
/*     */       
/*     */       } 
/*     */     } 
/* 105 */     paramArrayOfint[0] = b1;
/* 106 */     paramArrayOfint[1] = b2;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\piccolo\xml\ISO8859_1XMLDecoder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */