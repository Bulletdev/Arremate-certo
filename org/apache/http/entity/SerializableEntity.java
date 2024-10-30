/*     */ package org.apache.http.entity;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.Serializable;
/*     */ import org.apache.http.util.Args;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SerializableEntity
/*     */   extends AbstractHttpEntity
/*     */ {
/*     */   private byte[] objSer;
/*     */   private Serializable objRef;
/*     */   
/*     */   public SerializableEntity(Serializable paramSerializable, boolean paramBoolean) throws IOException {
/*  64 */     Args.notNull(paramSerializable, "Source object");
/*  65 */     if (paramBoolean) {
/*  66 */       createBytes(paramSerializable);
/*     */     } else {
/*  68 */       this.objRef = paramSerializable;
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
/*     */   
/*     */   public SerializableEntity(Serializable paramSerializable) {
/*  81 */     Args.notNull(paramSerializable, "Source object");
/*  82 */     this.objRef = paramSerializable;
/*     */   }
/*     */   
/*     */   private void createBytes(Serializable paramSerializable) throws IOException {
/*  86 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*  87 */     ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
/*  88 */     objectOutputStream.writeObject(paramSerializable);
/*  89 */     objectOutputStream.flush();
/*  90 */     this.objSer = byteArrayOutputStream.toByteArray();
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream getContent() throws IOException, IllegalStateException {
/*  95 */     if (this.objSer == null) {
/*  96 */       createBytes(this.objRef);
/*     */     }
/*  98 */     return new ByteArrayInputStream(this.objSer);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getContentLength() {
/* 103 */     return (this.objSer == null) ? -1L : this.objSer.length;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRepeatable() {
/* 108 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isStreaming() {
/* 113 */     return (this.objSer == null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeTo(OutputStream paramOutputStream) throws IOException {
/* 118 */     Args.notNull(paramOutputStream, "Output stream");
/* 119 */     if (this.objSer == null) {
/* 120 */       ObjectOutputStream objectOutputStream = new ObjectOutputStream(paramOutputStream);
/* 121 */       objectOutputStream.writeObject(this.objRef);
/* 122 */       objectOutputStream.flush();
/*     */     } else {
/* 124 */       paramOutputStream.write(this.objSer);
/* 125 */       paramOutputStream.flush();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\entity\SerializableEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */