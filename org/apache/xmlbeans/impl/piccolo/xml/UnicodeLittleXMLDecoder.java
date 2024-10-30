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
/*     */ 
/*     */ public final class UnicodeLittleXMLDecoder
/*     */   implements XMLDecoder
/*     */ {
/*     */   private boolean sawCR = false;
/*     */   
/*     */   public CharsetDecoder newCharsetDecoder() {
/*  40 */     return newXMLDecoder(); } public XMLDecoder newXMLDecoder() {
/*  41 */     return new UnicodeLittleXMLDecoder();
/*     */   }
/*     */   public int minBytesPerChar() {
/*  44 */     return 2;
/*     */   }
/*     */   
/*     */   public int maxBytesPerChar() {
/*  48 */     return 2;
/*     */   }
/*     */   public void reset() {
/*  51 */     this.sawCR = false;
/*     */   }
/*     */   public void decode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, char[] paramArrayOfchar, int paramInt3, int paramInt4, int[] paramArrayOfint) throws CharConversionException {
/*     */     byte b1;
/*     */     byte b2;
/*  56 */     for (b1 = b2 = 0; b1 + 1 < paramInt2 && b2 < paramInt4; b1 += 2) {
/*  57 */       char c = (char)((0xFF & paramArrayOfbyte[paramInt1 + b1 + 1]) << 8 | 0xFF & paramArrayOfbyte[paramInt1 + b1]);
/*     */ 
/*     */       
/*  60 */       if (c >= ' ') {
/*  61 */         if (c <= '퟿' || (c >= '' && c <= '�') || (c >= 65536 && c <= 1114111)) {
/*     */ 
/*     */           
/*  64 */           this.sawCR = false;
/*  65 */           paramArrayOfchar[paramInt3 + b2++] = c;
/*     */         } else {
/*     */           
/*  68 */           throw new IllegalCharException("Illegal XML Character: 0x" + Integer.toHexString(c));
/*     */         } 
/*     */       } else {
/*     */         
/*  72 */         switch (c) {
/*     */           case '\n':
/*  74 */             if (this.sawCR) {
/*  75 */               this.sawCR = false;
/*     */               break;
/*     */             } 
/*  78 */             paramArrayOfchar[paramInt3 + b2++] = '\n';
/*     */             break;
/*     */           
/*     */           case '\r':
/*  82 */             this.sawCR = true;
/*  83 */             paramArrayOfchar[paramInt3 + b2++] = '\n';
/*     */             break;
/*     */           
/*     */           case '\t':
/*  87 */             paramArrayOfchar[paramInt3 + b2++] = '\t';
/*     */             break;
/*     */           
/*     */           default:
/*  91 */             throw new IllegalCharException("Illegal XML character: 0x" + Integer.toHexString(c));
/*     */         } 
/*     */ 
/*     */       
/*     */       } 
/*     */     } 
/*  97 */     paramArrayOfint[0] = b1;
/*  98 */     paramArrayOfint[1] = b2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void decodeXMLDecl(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, char[] paramArrayOfchar, int paramInt3, int paramInt4, int[] paramArrayOfint) throws CharConversionException {
/*     */     byte b1;
/*     */     byte b2;
/* 106 */     for (b1 = b2 = 0; b1 + 1 < paramInt2 && b2 < paramInt4; b1 += 2) {
/* 107 */       char c = (char)((0xFF & paramArrayOfbyte[paramInt1 + b1 + 1]) << 8 | 0xFF & paramArrayOfbyte[paramInt1 + b1]);
/*     */ 
/*     */       
/* 110 */       if (c >= ' ') {
/* 111 */         if (c <= '퟿' || (c >= '' && c <= '�') || (c >= 65536 && c <= 1114111)) {
/*     */ 
/*     */           
/* 114 */           this.sawCR = false;
/* 115 */           paramArrayOfchar[paramInt3 + b2++] = c;
/*     */ 
/*     */           
/* 118 */           if (c == '>') {
/* 119 */             b1 += 2;
/*     */ 
/*     */ 
/*     */             
/*     */             break;
/*     */           } 
/*     */         } else {
/*     */           break;
/*     */         } 
/*     */       } else {
/* 129 */         switch (c) {
/*     */           case '\n':
/* 131 */             if (this.sawCR) {
/* 132 */               this.sawCR = false;
/*     */               break;
/*     */             } 
/* 135 */             paramArrayOfchar[paramInt3 + b2++] = '\n';
/*     */             break;
/*     */           
/*     */           case '\r':
/* 139 */             this.sawCR = true;
/* 140 */             paramArrayOfchar[paramInt3 + b2++] = '\n';
/*     */             break;
/*     */           
/*     */           case '\t':
/* 144 */             paramArrayOfchar[paramInt3 + b2++] = '\t';
/*     */             break;
/*     */           
/*     */           default:
/*     */             break;
/*     */         } 
/*     */       
/*     */       } 
/*     */     } 
/* 153 */     paramArrayOfint[0] = b1;
/* 154 */     paramArrayOfint[1] = b2;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\piccolo\xml\UnicodeLittleXMLDecoder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */