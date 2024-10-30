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
/*     */ 
/*     */ public final class UnicodeBigXMLDecoder
/*     */   implements XMLDecoder
/*     */ {
/*     */   private boolean sawCR = false;
/*     */   
/*     */   public CharsetDecoder newCharsetDecoder() {
/*  39 */     return newXMLDecoder(); } public XMLDecoder newXMLDecoder() {
/*  40 */     return new UnicodeBigXMLDecoder();
/*     */   }
/*     */   public int minBytesPerChar() {
/*  43 */     return 2;
/*     */   }
/*     */   
/*     */   public int maxBytesPerChar() {
/*  47 */     return 2;
/*     */   }
/*     */   public void reset() {
/*  50 */     this.sawCR = false;
/*     */   }
/*     */   public void decode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, char[] paramArrayOfchar, int paramInt3, int paramInt4, int[] paramArrayOfint) throws CharConversionException {
/*     */     byte b1;
/*     */     byte b2;
/*  55 */     for (b1 = b2 = 0; b1 + 1 < paramInt2 && b2 < paramInt4; b1 += 2) {
/*  56 */       char c = (char)((0xFF & paramArrayOfbyte[paramInt1 + b1]) << 8 | 0xFF & paramArrayOfbyte[paramInt1 + b1 + 1]);
/*     */       
/*  58 */       if (c >= ' ') {
/*  59 */         if (c <= '퟿' || (c >= '' && c <= '�') || (c >= 65536 && c <= 1114111)) {
/*     */ 
/*     */           
/*  62 */           this.sawCR = false;
/*  63 */           paramArrayOfchar[paramInt3 + b2++] = c;
/*     */         } else {
/*     */           
/*  66 */           throw new IllegalCharException("Illegal XML Character: 0x" + Integer.toHexString(c));
/*     */         } 
/*     */       } else {
/*     */         
/*  70 */         switch (c) {
/*     */           case '\n':
/*  72 */             if (this.sawCR) {
/*  73 */               this.sawCR = false;
/*     */               break;
/*     */             } 
/*  76 */             paramArrayOfchar[paramInt3 + b2++] = '\n';
/*     */             break;
/*     */           
/*     */           case '\r':
/*  80 */             this.sawCR = true;
/*  81 */             paramArrayOfchar[paramInt3 + b2++] = '\n';
/*     */             break;
/*     */           
/*     */           case '\t':
/*  85 */             paramArrayOfchar[paramInt3 + b2++] = '\t';
/*     */             break;
/*     */           
/*     */           default:
/*  89 */             throw new IllegalCharException("Illegal XML character: 0x" + Integer.toHexString(c));
/*     */         } 
/*     */ 
/*     */       
/*     */       } 
/*     */     } 
/*  95 */     paramArrayOfint[0] = b1;
/*  96 */     paramArrayOfint[1] = b2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void decodeXMLDecl(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, char[] paramArrayOfchar, int paramInt3, int paramInt4, int[] paramArrayOfint) throws CharConversionException {
/*     */     byte b1;
/*     */     byte b2;
/* 104 */     for (b1 = b2 = 0; b1 + 1 < paramInt2 && b2 < paramInt4; b1 += 2) {
/* 105 */       char c = (char)((0xFF & paramArrayOfbyte[paramInt1 + b1]) << 8 | 0xFF & paramArrayOfbyte[paramInt1 + b1 + 1]);
/*     */       
/* 107 */       if (c >= ' ') {
/* 108 */         if (c <= '퟿' || (c >= '' && c <= '�') || (c >= 65536 && c <= 1114111)) {
/*     */ 
/*     */           
/* 111 */           this.sawCR = false;
/* 112 */           paramArrayOfchar[paramInt3 + b2++] = c;
/*     */ 
/*     */           
/* 115 */           if (c == '>') {
/* 116 */             b1 += 2;
/*     */ 
/*     */ 
/*     */             
/*     */             break;
/*     */           } 
/*     */         } else {
/*     */           break;
/*     */         } 
/*     */       } else {
/* 126 */         switch (c) {
/*     */           case '\n':
/* 128 */             if (this.sawCR) {
/* 129 */               this.sawCR = false;
/*     */               break;
/*     */             } 
/* 132 */             paramArrayOfchar[paramInt3 + b2++] = '\n';
/*     */             break;
/*     */           
/*     */           case '\r':
/* 136 */             this.sawCR = true;
/* 137 */             paramArrayOfchar[paramInt3 + b2++] = '\n';
/*     */             break;
/*     */           
/*     */           case '\t':
/* 141 */             paramArrayOfchar[paramInt3 + b2++] = '\t';
/*     */             break;
/*     */           
/*     */           default:
/*     */             break;
/*     */         } 
/*     */       
/*     */       } 
/*     */     } 
/* 150 */     paramArrayOfint[0] = b1;
/* 151 */     paramArrayOfint[1] = b2;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\piccolo\xml\UnicodeBigXMLDecoder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */