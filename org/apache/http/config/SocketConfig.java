/*     */ package org.apache.http.config;
/*     */ 
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class SocketConfig
/*     */   implements Cloneable
/*     */ {
/*  42 */   public static final SocketConfig DEFAULT = (new Builder()).build();
/*     */ 
/*     */   
/*     */   private final int soTimeout;
/*     */   
/*     */   private final boolean soReuseAddress;
/*     */   
/*     */   private final int soLinger;
/*     */   
/*     */   private final boolean soKeepAlive;
/*     */   
/*     */   private final boolean tcpNoDelay;
/*     */   
/*     */   private final int sndBufSize;
/*     */   
/*     */   private final int rcvBufSize;
/*     */   
/*     */   private final int backlogSize;
/*     */ 
/*     */   
/*     */   SocketConfig(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3, int paramInt3, int paramInt4, int paramInt5) {
/*  63 */     this.soTimeout = paramInt1;
/*  64 */     this.soReuseAddress = paramBoolean1;
/*  65 */     this.soLinger = paramInt2;
/*  66 */     this.soKeepAlive = paramBoolean2;
/*  67 */     this.tcpNoDelay = paramBoolean3;
/*  68 */     this.sndBufSize = paramInt3;
/*  69 */     this.rcvBufSize = paramInt4;
/*  70 */     this.backlogSize = paramInt5;
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
/*     */   public int getSoTimeout() {
/*  83 */     return this.soTimeout;
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
/*     */   public boolean isSoReuseAddress() {
/*  97 */     return this.soReuseAddress;
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
/*     */   public int getSoLinger() {
/* 111 */     return this.soLinger;
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
/*     */   public boolean isSoKeepAlive() {
/* 125 */     return this.soKeepAlive;
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
/*     */   public boolean isTcpNoDelay() {
/* 139 */     return this.tcpNoDelay;
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
/*     */   public int getSndBufSize() {
/* 154 */     return this.sndBufSize;
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
/*     */   public int getRcvBufSize() {
/* 169 */     return this.rcvBufSize;
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
/*     */   public int getBacklogSize() {
/* 182 */     return this.backlogSize;
/*     */   }
/*     */ 
/*     */   
/*     */   protected SocketConfig clone() throws CloneNotSupportedException {
/* 187 */     return (SocketConfig)super.clone();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 192 */     StringBuilder stringBuilder = new StringBuilder();
/* 193 */     stringBuilder.append("[soTimeout=").append(this.soTimeout).append(", soReuseAddress=").append(this.soReuseAddress).append(", soLinger=").append(this.soLinger).append(", soKeepAlive=").append(this.soKeepAlive).append(", tcpNoDelay=").append(this.tcpNoDelay).append(", sndBufSize=").append(this.sndBufSize).append(", rcvBufSize=").append(this.rcvBufSize).append(", backlogSize=").append(this.backlogSize).append("]");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 202 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static Builder custom() {
/* 206 */     return new Builder();
/*     */   }
/*     */   
/*     */   public static Builder copy(SocketConfig paramSocketConfig) {
/* 210 */     Args.notNull(paramSocketConfig, "Socket config");
/* 211 */     return (new Builder()).setSoTimeout(paramSocketConfig.getSoTimeout()).setSoReuseAddress(paramSocketConfig.isSoReuseAddress()).setSoLinger(paramSocketConfig.getSoLinger()).setSoKeepAlive(paramSocketConfig.isSoKeepAlive()).setTcpNoDelay(paramSocketConfig.isTcpNoDelay()).setSndBufSize(paramSocketConfig.getSndBufSize()).setRcvBufSize(paramSocketConfig.getRcvBufSize()).setBacklogSize(paramSocketConfig.getBacklogSize());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Builder
/*     */   {
/*     */     private int soTimeout;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean soReuseAddress;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 234 */     private int soLinger = -1;
/*     */     private boolean soKeepAlive;
/*     */     private boolean tcpNoDelay = true;
/*     */     
/*     */     public Builder setSoTimeout(int param1Int) {
/* 239 */       this.soTimeout = param1Int;
/* 240 */       return this;
/*     */     }
/*     */     private int sndBufSize; private int rcvBufSize; private int backlogSize;
/*     */     public Builder setSoReuseAddress(boolean param1Boolean) {
/* 244 */       this.soReuseAddress = param1Boolean;
/* 245 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setSoLinger(int param1Int) {
/* 249 */       this.soLinger = param1Int;
/* 250 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setSoKeepAlive(boolean param1Boolean) {
/* 254 */       this.soKeepAlive = param1Boolean;
/* 255 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setTcpNoDelay(boolean param1Boolean) {
/* 259 */       this.tcpNoDelay = param1Boolean;
/* 260 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder setSndBufSize(int param1Int) {
/* 267 */       this.sndBufSize = param1Int;
/* 268 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder setRcvBufSize(int param1Int) {
/* 275 */       this.rcvBufSize = param1Int;
/* 276 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Builder setBacklogSize(int param1Int) {
/* 283 */       this.backlogSize = param1Int;
/* 284 */       return this;
/*     */     }
/*     */     
/*     */     public SocketConfig build() {
/* 288 */       return new SocketConfig(this.soTimeout, this.soReuseAddress, this.soLinger, this.soKeepAlive, this.tcpNoDelay, this.sndBufSize, this.rcvBufSize, this.backlogSize);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\config\SocketConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */