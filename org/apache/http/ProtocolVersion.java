/*     */ package org.apache.http;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
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
/*     */ public class ProtocolVersion
/*     */   implements Serializable, Cloneable
/*     */ {
/*     */   private static final long serialVersionUID = 8950662842175091068L;
/*     */   protected final String protocol;
/*     */   protected final int major;
/*     */   protected final int minor;
/*     */   
/*     */   public ProtocolVersion(String paramString, int paramInt1, int paramInt2) {
/*  72 */     this.protocol = (String)Args.notNull(paramString, "Protocol name");
/*  73 */     this.major = Args.notNegative(paramInt1, "Protocol major version");
/*  74 */     this.minor = Args.notNegative(paramInt2, "Protocol minor version");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getProtocol() {
/*  83 */     return this.protocol;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getMajor() {
/*  92 */     return this.major;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int getMinor() {
/* 101 */     return this.minor;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ProtocolVersion forVersion(int paramInt1, int paramInt2) {
/* 123 */     if (paramInt1 == this.major && paramInt2 == this.minor) {
/* 124 */       return this;
/*     */     }
/*     */ 
/*     */     
/* 128 */     return new ProtocolVersion(this.protocol, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 139 */     return this.protocol.hashCode() ^ this.major * 100000 ^ this.minor;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 158 */     if (this == paramObject) {
/* 159 */       return true;
/*     */     }
/* 161 */     if (!(paramObject instanceof ProtocolVersion)) {
/* 162 */       return false;
/*     */     }
/* 164 */     ProtocolVersion protocolVersion = (ProtocolVersion)paramObject;
/*     */     
/* 166 */     return (this.protocol.equals(protocolVersion.protocol) && this.major == protocolVersion.major && this.minor == protocolVersion.minor);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isComparable(ProtocolVersion paramProtocolVersion) {
/* 183 */     return (paramProtocolVersion != null && this.protocol.equals(paramProtocolVersion.protocol));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareToVersion(ProtocolVersion paramProtocolVersion) {
/* 204 */     Args.notNull(paramProtocolVersion, "Protocol version");
/* 205 */     Args.check(this.protocol.equals(paramProtocolVersion.protocol), "Versions for different protocols cannot be compared: %s %s", new Object[] { this, paramProtocolVersion });
/*     */     
/* 207 */     int i = getMajor() - paramProtocolVersion.getMajor();
/* 208 */     if (i == 0) {
/* 209 */       i = getMinor() - paramProtocolVersion.getMinor();
/*     */     }
/* 211 */     return i;
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
/*     */   
/*     */   public final boolean greaterEquals(ProtocolVersion paramProtocolVersion) {
/* 226 */     return (isComparable(paramProtocolVersion) && compareToVersion(paramProtocolVersion) >= 0);
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
/*     */   
/*     */   public final boolean lessEquals(ProtocolVersion paramProtocolVersion) {
/* 241 */     return (isComparable(paramProtocolVersion) && compareToVersion(paramProtocolVersion) <= 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 252 */     StringBuilder stringBuilder = new StringBuilder();
/* 253 */     stringBuilder.append(this.protocol);
/* 254 */     stringBuilder.append('/');
/* 255 */     stringBuilder.append(Integer.toString(this.major));
/* 256 */     stringBuilder.append('.');
/* 257 */     stringBuilder.append(Integer.toString(this.minor));
/* 258 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object clone() throws CloneNotSupportedException {
/* 263 */     return super.clone();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\ProtocolVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */