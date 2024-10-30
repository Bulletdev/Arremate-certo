/*     */ package org.apache.http.message;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import org.apache.http.ProtocolVersion;
/*     */ import org.apache.http.StatusLine;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.CharArrayBuffer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class BasicStatusLine
/*     */   implements Serializable, Cloneable, StatusLine
/*     */ {
/*     */   private static final long serialVersionUID = -2443303766890459269L;
/*     */   private final ProtocolVersion protoVersion;
/*     */   private final int statusCode;
/*     */   private final String reasonPhrase;
/*     */   
/*     */   public BasicStatusLine(ProtocolVersion paramProtocolVersion, int paramInt, String paramString) {
/*  71 */     this.protoVersion = (ProtocolVersion)Args.notNull(paramProtocolVersion, "Version");
/*  72 */     this.statusCode = Args.notNegative(paramInt, "Status code");
/*  73 */     this.reasonPhrase = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getStatusCode() {
/*  80 */     return this.statusCode;
/*     */   }
/*     */ 
/*     */   
/*     */   public ProtocolVersion getProtocolVersion() {
/*  85 */     return this.protoVersion;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getReasonPhrase() {
/*  90 */     return this.reasonPhrase;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  96 */     return BasicLineFormatter.INSTANCE.formatStatusLine((CharArrayBuffer)null, this).toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object clone() throws CloneNotSupportedException {
/* 101 */     return super.clone();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\message\BasicStatusLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */