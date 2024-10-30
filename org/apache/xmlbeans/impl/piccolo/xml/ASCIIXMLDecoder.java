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
/*     */ public final class ASCIIXMLDecoder
/*     */   implements XMLDecoder
/*     */ {
/*     */   private boolean sawCR = false;
/*     */   
/*     */   public CharsetDecoder newCharsetDecoder() {
/*  36 */     return newXMLDecoder(); } public XMLDecoder newXMLDecoder() {
/*  37 */     return new ASCIIXMLDecoder();
/*     */   }
/*     */   public int minBytesPerChar() {
/*  40 */     return 1;
/*     */   }
/*     */   
/*     */   public int maxBytesPerChar() {
/*  44 */     return 1;
/*     */   }
/*     */   public void reset() {
/*  47 */     this.sawCR = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void decode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, char[] paramArrayOfchar, int paramInt3, int paramInt4, int[] paramArrayOfint) throws CharConversionException {
/*  52 */     internalDecode(paramArrayOfbyte, paramInt1, paramInt2, paramArrayOfchar, paramInt3, paramInt4, paramArrayOfint, false);
/*     */   }
/*     */ 
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
/*     */   private void internalDecode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, char[] paramArrayOfchar, int paramInt3, int paramInt4, int[] paramArrayOfint, boolean paramBoolean) throws CharConversionException {
/*     */     byte b1;
/*     */     byte b2;
/*  69 */     for (b1 = b2 = 0; b1 < paramInt2 && b2 < paramInt4; b1++) {
/*  70 */       char c = (char)(Byte.MAX_VALUE & paramArrayOfbyte[paramInt1 + b1]);
/*  71 */       if (c >= ' ') {
/*  72 */         this.sawCR = false;
/*  73 */         paramArrayOfchar[paramInt3 + b2++] = c;
/*     */       } else {
/*     */         
/*  76 */         switch (c) {
/*     */           case '\n':
/*  78 */             if (this.sawCR) {
/*  79 */               this.sawCR = false;
/*     */               break;
/*     */             } 
/*  82 */             paramArrayOfchar[paramInt3 + b2++] = '\n';
/*     */             break;
/*     */           
/*     */           case '\r':
/*  86 */             this.sawCR = true;
/*  87 */             paramArrayOfchar[paramInt3 + b2++] = '\n';
/*     */             break;
/*     */           
/*     */           case '\t':
/*  91 */             paramArrayOfchar[paramInt3 + b2++] = '\t';
/*     */             break;
/*     */           
/*     */           default:
/*  95 */             if (paramBoolean) {
/*     */               break;
/*     */             }
/*  98 */             throw new IllegalCharException("Illegal XML character: 0x" + Integer.toHexString(c));
/*     */         } 
/*     */ 
/*     */       
/*     */       } 
/*     */     } 
/* 104 */     paramArrayOfint[0] = b1;
/* 105 */     paramArrayOfint[1] = b2;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\piccolo\xml\ASCIIXMLDecoder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */