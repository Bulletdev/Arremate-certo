/*     */ package org.apache.xmlbeans;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class XmlDocumentProperties
/*     */ {
/*     */   public void setSourceName(String paramString) {
/*  42 */     put(SOURCE_NAME, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSourceName() {
/*  48 */     return (String)get(SOURCE_NAME);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEncoding(String paramString) {
/*  56 */     put(ENCODING, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getEncoding() {
/*  61 */     return (String)get(ENCODING);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVersion(String paramString) {
/*  68 */     put(VERSION, paramString);
/*     */   }
/*     */   
/*     */   public String getVersion() {
/*  72 */     return (String)get(VERSION);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStandalone(boolean paramBoolean) {
/*  78 */     put(STANDALONE, paramBoolean ? "true" : null);
/*     */   }
/*     */   
/*     */   public boolean getStandalone() {
/*  82 */     return (get(STANDALONE) != null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDoctypeName(String paramString) {
/*  88 */     put(DOCTYPE_NAME, paramString);
/*     */   }
/*     */   
/*     */   public String getDoctypeName() {
/*  92 */     return (String)get(DOCTYPE_NAME);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDoctypePublicId(String paramString) {
/*  98 */     put(DOCTYPE_PUBLIC_ID, paramString);
/*     */   }
/*     */   
/*     */   public String getDoctypePublicId() {
/* 102 */     return (String)get(DOCTYPE_PUBLIC_ID);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDoctypeSystemId(String paramString) {
/* 108 */     put(DOCTYPE_SYSTEM_ID, paramString);
/*     */   }
/*     */   
/*     */   public String getDoctypeSystemId() {
/* 112 */     return (String)get(DOCTYPE_SYSTEM_ID);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMessageDigest(byte[] paramArrayOfbyte) {
/* 120 */     put(MESSAGE_DIGEST, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getMessageDigest() {
/* 126 */     return (byte[])get(MESSAGE_DIGEST);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 137 */   public static final Object SOURCE_NAME = new Object();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 142 */   public static final Object ENCODING = new Object();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 147 */   public static final Object VERSION = new Object();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 152 */   public static final Object STANDALONE = new Object();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 157 */   public static final Object DOCTYPE_NAME = new Object();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 162 */   public static final Object DOCTYPE_PUBLIC_ID = new Object();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 167 */   public static final Object DOCTYPE_SYSTEM_ID = new Object();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 172 */   public static final Object MESSAGE_DIGEST = new Object();
/*     */   
/*     */   public abstract Object put(Object paramObject1, Object paramObject2);
/*     */   
/*     */   public abstract Object get(Object paramObject);
/*     */   
/*     */   public abstract Object remove(Object paramObject);
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlDocumentProperties.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */