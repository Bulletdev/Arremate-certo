/*     */ package org.apache.commons.io.input;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.NoSuchAlgorithmException;
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
/*     */ public class MessageDigestCalculatingInputStream
/*     */   extends ObservableInputStream
/*     */ {
/*     */   private final MessageDigest messageDigest;
/*     */   
/*     */   public static class MessageDigestMaintainingObserver
/*     */     extends ObservableInputStream.Observer
/*     */   {
/*     */     private final MessageDigest messageDigest;
/*     */     
/*     */     public MessageDigestMaintainingObserver(MessageDigest param1MessageDigest) {
/*  45 */       this.messageDigest = param1MessageDigest;
/*     */     }
/*     */ 
/*     */     
/*     */     public void data(int param1Int) throws IOException {
/*  50 */       this.messageDigest.update((byte)param1Int);
/*     */     }
/*     */ 
/*     */     
/*     */     public void data(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
/*  55 */       this.messageDigest.update(param1ArrayOfbyte, param1Int1, param1Int2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MessageDigestCalculatingInputStream(InputStream paramInputStream, MessageDigest paramMessageDigest) {
/*  67 */     super(paramInputStream);
/*  68 */     this.messageDigest = paramMessageDigest;
/*  69 */     add(new MessageDigestMaintainingObserver(paramMessageDigest));
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
/*     */ 
/*     */   
/*     */   public MessageDigestCalculatingInputStream(InputStream paramInputStream, String paramString) throws NoSuchAlgorithmException {
/*  83 */     this(paramInputStream, MessageDigest.getInstance(paramString));
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
/*     */   public MessageDigestCalculatingInputStream(InputStream paramInputStream) throws NoSuchAlgorithmException {
/*  95 */     this(paramInputStream, MessageDigest.getInstance("MD5"));
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
/*     */   public MessageDigest getMessageDigest() {
/* 107 */     return this.messageDigest;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\MessageDigestCalculatingInputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */