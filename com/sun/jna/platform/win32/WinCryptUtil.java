/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.Pointer;
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
/*     */ public abstract class WinCryptUtil
/*     */ {
/*     */   public static class MANAGED_CRYPT_SIGN_MESSAGE_PARA
/*     */     extends WinCrypt.CRYPT_SIGN_MESSAGE_PARA
/*     */   {
/*     */     private WinCrypt.CERT_CONTEXT[] rgpMsgCerts;
/*     */     private WinCrypt.CRL_CONTEXT[] rgpMsgCrls;
/*     */     private WinCrypt.CRYPT_ATTRIBUTE[] rgAuthAttrs;
/*     */     private WinCrypt.CRYPT_ATTRIBUTE[] rgUnauthAttrs;
/*     */     
/*     */     public void setRgpMsgCert(WinCrypt.CERT_CONTEXT[] param1ArrayOfCERT_CONTEXT) {
/*  44 */       this.rgpMsgCerts = param1ArrayOfCERT_CONTEXT;
/*  45 */       if (param1ArrayOfCERT_CONTEXT == null || param1ArrayOfCERT_CONTEXT.length == 0) {
/*  46 */         this.rgpMsgCert = null;
/*  47 */         this.cMsgCert = 0;
/*     */       } else {
/*  49 */         this.cMsgCert = param1ArrayOfCERT_CONTEXT.length;
/*  50 */         Memory memory = new Memory((Native.POINTER_SIZE * param1ArrayOfCERT_CONTEXT.length));
/*  51 */         for (byte b = 0; b < param1ArrayOfCERT_CONTEXT.length; b++) {
/*  52 */           memory.setPointer((b * Native.POINTER_SIZE), param1ArrayOfCERT_CONTEXT[b].getPointer());
/*     */         }
/*  54 */         this.rgpMsgCert = (Pointer)memory;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public WinCrypt.CERT_CONTEXT[] getRgpMsgCert() {
/*  60 */       return this.rgpMsgCerts;
/*     */     }
/*     */     
/*     */     public void setRgpMsgCrl(WinCrypt.CRL_CONTEXT[] param1ArrayOfCRL_CONTEXT) {
/*  64 */       this.rgpMsgCrls = param1ArrayOfCRL_CONTEXT;
/*  65 */       if (param1ArrayOfCRL_CONTEXT == null || param1ArrayOfCRL_CONTEXT.length == 0) {
/*  66 */         this.rgpMsgCert = null;
/*  67 */         this.cMsgCert = 0;
/*     */       } else {
/*  69 */         this.cMsgCert = param1ArrayOfCRL_CONTEXT.length;
/*  70 */         Memory memory = new Memory((Native.POINTER_SIZE * param1ArrayOfCRL_CONTEXT.length));
/*  71 */         for (byte b = 0; b < param1ArrayOfCRL_CONTEXT.length; b++) {
/*  72 */           memory.setPointer((b * Native.POINTER_SIZE), param1ArrayOfCRL_CONTEXT[b].getPointer());
/*     */         }
/*  74 */         this.rgpMsgCert = (Pointer)memory;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public WinCrypt.CRL_CONTEXT[] getRgpMsgCrl() {
/*  80 */       return this.rgpMsgCrls;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setRgAuthAttr(WinCrypt.CRYPT_ATTRIBUTE[] param1ArrayOfCRYPT_ATTRIBUTE) {
/*  89 */       this.rgAuthAttrs = param1ArrayOfCRYPT_ATTRIBUTE;
/*  90 */       if (param1ArrayOfCRYPT_ATTRIBUTE == null || param1ArrayOfCRYPT_ATTRIBUTE.length == 0) {
/*  91 */         this.rgAuthAttr = null;
/*  92 */         this.cMsgCert = 0;
/*     */       } else {
/*  94 */         this.cMsgCert = this.rgpMsgCerts.length;
/*  95 */         this.rgAuthAttr = param1ArrayOfCRYPT_ATTRIBUTE[0].getPointer();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public WinCrypt.CRYPT_ATTRIBUTE[] getRgAuthAttr() {
/* 101 */       return this.rgAuthAttrs;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setRgUnauthAttr(WinCrypt.CRYPT_ATTRIBUTE[] param1ArrayOfCRYPT_ATTRIBUTE) {
/* 110 */       this.rgUnauthAttrs = param1ArrayOfCRYPT_ATTRIBUTE;
/* 111 */       if (param1ArrayOfCRYPT_ATTRIBUTE == null || param1ArrayOfCRYPT_ATTRIBUTE.length == 0) {
/* 112 */         this.rgUnauthAttr = null;
/* 113 */         this.cMsgCert = 0;
/*     */       } else {
/* 115 */         this.cMsgCert = this.rgpMsgCerts.length;
/* 116 */         this.rgUnauthAttr = param1ArrayOfCRYPT_ATTRIBUTE[0].getPointer();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public WinCrypt.CRYPT_ATTRIBUTE[] getRgUnauthAttr() {
/* 122 */       return this.rgUnauthAttrs;
/*     */     }
/*     */ 
/*     */     
/*     */     public void write() {
/* 127 */       if (this.rgpMsgCerts != null) {
/* 128 */         for (WinCrypt.CERT_CONTEXT cERT_CONTEXT : this.rgpMsgCerts) {
/* 129 */           cERT_CONTEXT.write();
/*     */         }
/*     */       }
/* 132 */       if (this.rgpMsgCrls != null) {
/* 133 */         for (WinCrypt.CRL_CONTEXT cRL_CONTEXT : this.rgpMsgCrls) {
/* 134 */           cRL_CONTEXT.write();
/*     */         }
/*     */       }
/* 137 */       if (this.rgAuthAttrs != null) {
/* 138 */         for (WinCrypt.CRYPT_ATTRIBUTE cRYPT_ATTRIBUTE : this.rgAuthAttrs) {
/* 139 */           cRYPT_ATTRIBUTE.write();
/*     */         }
/*     */       }
/* 142 */       if (this.rgUnauthAttrs != null) {
/* 143 */         for (WinCrypt.CRYPT_ATTRIBUTE cRYPT_ATTRIBUTE : this.rgUnauthAttrs) {
/* 144 */           cRYPT_ATTRIBUTE.write();
/*     */         }
/*     */       }
/* 147 */       this.cbSize = size();
/* 148 */       super.write();
/*     */     }
/*     */ 
/*     */     
/*     */     public void read() {
/* 153 */       if (this.rgpMsgCerts != null) {
/* 154 */         for (WinCrypt.CERT_CONTEXT cERT_CONTEXT : this.rgpMsgCerts) {
/* 155 */           cERT_CONTEXT.read();
/*     */         }
/*     */       }
/* 158 */       if (this.rgpMsgCrls != null) {
/* 159 */         for (WinCrypt.CRL_CONTEXT cRL_CONTEXT : this.rgpMsgCrls) {
/* 160 */           cRL_CONTEXT.read();
/*     */         }
/*     */       }
/* 163 */       if (this.rgAuthAttrs != null) {
/* 164 */         for (WinCrypt.CRYPT_ATTRIBUTE cRYPT_ATTRIBUTE : this.rgAuthAttrs) {
/* 165 */           cRYPT_ATTRIBUTE.read();
/*     */         }
/*     */       }
/* 168 */       if (this.rgUnauthAttrs != null) {
/* 169 */         for (WinCrypt.CRYPT_ATTRIBUTE cRYPT_ATTRIBUTE : this.rgUnauthAttrs) {
/* 170 */           cRYPT_ATTRIBUTE.read();
/*     */         }
/*     */       }
/* 173 */       super.read();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\WinCryptUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */