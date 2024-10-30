/*     */ package org.apache.http.config;
/*     */ 
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.CodingErrorAction;
/*     */ import org.apache.http.Consts;
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
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public class ConnectionConfig
/*     */   implements Cloneable
/*     */ {
/*  46 */   public static final ConnectionConfig DEFAULT = (new Builder()).build();
/*     */ 
/*     */   
/*     */   private final int bufferSize;
/*     */   
/*     */   private final int fragmentSizeHint;
/*     */   
/*     */   private final Charset charset;
/*     */   
/*     */   private final CodingErrorAction malformedInputAction;
/*     */   
/*     */   private final CodingErrorAction unmappableInputAction;
/*     */   
/*     */   private final MessageConstraints messageConstraints;
/*     */ 
/*     */   
/*     */   ConnectionConfig(int paramInt1, int paramInt2, Charset paramCharset, CodingErrorAction paramCodingErrorAction1, CodingErrorAction paramCodingErrorAction2, MessageConstraints paramMessageConstraints) {
/*  63 */     this.bufferSize = paramInt1;
/*  64 */     this.fragmentSizeHint = paramInt2;
/*  65 */     this.charset = paramCharset;
/*  66 */     this.malformedInputAction = paramCodingErrorAction1;
/*  67 */     this.unmappableInputAction = paramCodingErrorAction2;
/*  68 */     this.messageConstraints = paramMessageConstraints;
/*     */   }
/*     */   
/*     */   public int getBufferSize() {
/*  72 */     return this.bufferSize;
/*     */   }
/*     */   
/*     */   public int getFragmentSizeHint() {
/*  76 */     return this.fragmentSizeHint;
/*     */   }
/*     */   
/*     */   public Charset getCharset() {
/*  80 */     return this.charset;
/*     */   }
/*     */   
/*     */   public CodingErrorAction getMalformedInputAction() {
/*  84 */     return this.malformedInputAction;
/*     */   }
/*     */   
/*     */   public CodingErrorAction getUnmappableInputAction() {
/*  88 */     return this.unmappableInputAction;
/*     */   }
/*     */   
/*     */   public MessageConstraints getMessageConstraints() {
/*  92 */     return this.messageConstraints;
/*     */   }
/*     */ 
/*     */   
/*     */   protected ConnectionConfig clone() throws CloneNotSupportedException {
/*  97 */     return (ConnectionConfig)super.clone();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 102 */     StringBuilder stringBuilder = new StringBuilder();
/* 103 */     stringBuilder.append("[bufferSize=").append(this.bufferSize).append(", fragmentSizeHint=").append(this.fragmentSizeHint).append(", charset=").append(this.charset).append(", malformedInputAction=").append(this.malformedInputAction).append(", unmappableInputAction=").append(this.unmappableInputAction).append(", messageConstraints=").append(this.messageConstraints).append("]");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 110 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static Builder custom() {
/* 114 */     return new Builder();
/*     */   }
/*     */   
/*     */   public static Builder copy(ConnectionConfig paramConnectionConfig) {
/* 118 */     Args.notNull(paramConnectionConfig, "Connection config");
/* 119 */     return (new Builder()).setBufferSize(paramConnectionConfig.getBufferSize()).setCharset(paramConnectionConfig.getCharset()).setFragmentSizeHint(paramConnectionConfig.getFragmentSizeHint()).setMalformedInputAction(paramConnectionConfig.getMalformedInputAction()).setUnmappableInputAction(paramConnectionConfig.getUnmappableInputAction()).setMessageConstraints(paramConnectionConfig.getMessageConstraints());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Builder
/*     */   {
/*     */     private int bufferSize;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 138 */     private int fragmentSizeHint = -1; private Charset charset;
/*     */     private CodingErrorAction malformedInputAction;
/*     */     
/*     */     public Builder setBufferSize(int param1Int) {
/* 142 */       this.bufferSize = param1Int;
/* 143 */       return this;
/*     */     }
/*     */     private CodingErrorAction unmappableInputAction; private MessageConstraints messageConstraints;
/*     */     public Builder setFragmentSizeHint(int param1Int) {
/* 147 */       this.fragmentSizeHint = param1Int;
/* 148 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setCharset(Charset param1Charset) {
/* 152 */       this.charset = param1Charset;
/* 153 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setMalformedInputAction(CodingErrorAction param1CodingErrorAction) {
/* 157 */       this.malformedInputAction = param1CodingErrorAction;
/* 158 */       if (param1CodingErrorAction != null && this.charset == null) {
/* 159 */         this.charset = Consts.ASCII;
/*     */       }
/* 161 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setUnmappableInputAction(CodingErrorAction param1CodingErrorAction) {
/* 165 */       this.unmappableInputAction = param1CodingErrorAction;
/* 166 */       if (param1CodingErrorAction != null && this.charset == null) {
/* 167 */         this.charset = Consts.ASCII;
/*     */       }
/* 169 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setMessageConstraints(MessageConstraints param1MessageConstraints) {
/* 173 */       this.messageConstraints = param1MessageConstraints;
/* 174 */       return this;
/*     */     }
/*     */     
/*     */     public ConnectionConfig build() {
/* 178 */       Charset charset = this.charset;
/* 179 */       if (charset == null && (this.malformedInputAction != null || this.unmappableInputAction != null)) {
/* 180 */         charset = Consts.ASCII;
/*     */       }
/* 182 */       boolean bool1 = (this.bufferSize > 0) ? this.bufferSize : true;
/* 183 */       boolean bool2 = (this.fragmentSizeHint >= 0) ? this.fragmentSizeHint : bool1;
/* 184 */       return new ConnectionConfig(bool1, bool2, charset, this.malformedInputAction, this.unmappableInputAction, this.messageConstraints);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\config\ConnectionConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */